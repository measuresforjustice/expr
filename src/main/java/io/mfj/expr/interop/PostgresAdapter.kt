package io.mfj.expr.interop

import io.mfj.expr.ExDataType
import io.mfj.expr.ExLogicOpType
import io.mfj.expr.ExValue
import io.mfj.expr.ExValueCompound
import io.mfj.expr.ExValueList
import io.mfj.expr.ExValueLit
import io.mfj.expr.ExValueVar
import io.mfj.expr.Expr
import io.mfj.expr.ExprConjunction
import io.mfj.expr.ExprLogicStatement
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object PostgresAdapter {
  /**
   * Serialize `trustedExpr` into a Postgres-compatible
   * SQL expression string (e.g. for use in a WHERE clause)
   *
   * Input expression is NOT sanitized - do not use with
   * expressions from untrusted sources, to avoid a SQL
   * injection vector
   */
  fun toSqlExpression(trustedExpr: Expr): String {
    return when (trustedExpr) {
      is ExprConjunction -> toSql(trustedExpr, mapOf())
      is ExprLogicStatement -> toSql(trustedExpr, mapOf())
      else -> error("Unexpected type ${trustedExpr.javaClass}")
    }
  }

  /**
   * Serialize `trustedExpr` into a Postgres-compatible
   * SQL expression string (e.g. for use in a WHERE clause).
   *
   * Additionally replace any encountered variables whose keys
   * are in `trustedSubsitutionVars` with the mapped value.
   *
   * Input expression and substitution values are
   * NOT sanitized - do not use with expressions from
   * untrusted sources, to avoid a SQL injection vector
   */
  fun toSqlExpression(trustedExpr: Expr, trustedSubstitutionVars: Map<String, Any>): String {
    return when (trustedExpr) {
      is ExprConjunction -> toSql(trustedExpr, trustedSubstitutionVars)
      is ExprLogicStatement -> toSql(trustedExpr, trustedSubstitutionVars)
      else -> error("Unexpected type ${trustedExpr.javaClass}")
    }
  }

  private fun toSql(conjunction: ExprConjunction, subVars: Map<String, Any>): String {
    return conjunction.params.joinToString(" ${conjunction.type.name} ") { expr ->
      toSqlExpression(expr, subVars)
    }.let { joined ->
      if (conjunction.not) {
        "NOT ($joined)"
      } else {
        if (conjunction.params.size > 1) {
          "($joined)"
        } else {
          joined
        }
      }
    }
  }

  private fun toSql(statement: ExprLogicStatement, subVars: Map<String, Any>): String {
    return when (statement.op) {
      ExLogicOpType.REGEX_MATCH -> {
        if (statement.left.getType() != ExDataType.STRING)
          throw IllegalArgumentException( "Regex input must be a String, not ${statement.left.getType()}" )
        val literal = (statement.right as? ExValueLit)?.value
            ?: throw IllegalArgumentException("Regex pattern must be a simple literal")
        val regex = if (literal is Regex) literal else Regex(literal.toString())
        // the grammar doesn't seem to have any way to specify a case-insensitive regex
        "${toSql(statement.left, subVars)} ~ '${regex.pattern}'"
      }
      ExLogicOpType.IN -> {
        val rightList = (statement.right as? ExValueList)
            ?: throw IllegalArgumentException("right operand for ${ExLogicOpType.IN} must be a list")
        validateListElements(rightList.values)
        val joinedList = rightList.values.joinToString { toSql(it, subVars) }
        "${toSql(statement.left, subVars)} IN ($joinedList)"
      }
      ExLogicOpType.NOT_IN -> {
        val rightList = (statement.right as? ExValueList)
          ?: throw IllegalArgumentException("right operand for ${ExLogicOpType.IN} must be a list")
        validateListElements(rightList.values)
        val joinedList = rightList.values.joinToString { toSql(it, subVars) }
        "${toSql(statement.left, subVars)} NOT IN ($joinedList)"
      }
      ExLogicOpType.CONTAINS -> {
        val leftList = (statement.left as? ExValueList)
          ?: throw IllegalArgumentException("left operand for ${ExLogicOpType.CONTAINS} must be a list")
        validateListElements(leftList.values)
        val joinedList = leftList.values.joinToString { toSql(it, subVars) }
        "${toSql(statement.right, subVars)} IN ($joinedList)"
      }
      ExLogicOpType.NOT_CONTAINS -> {
        val leftList = (statement.left as? ExValueList)
          ?: throw IllegalArgumentException("left operand for ${ExLogicOpType.CONTAINS} must be a list")
        validateListElements(leftList.values)
        val joinedList = leftList.values.joinToString { toSql(it, subVars) }
        "${toSql(statement.right, subVars)} NOT IN ($joinedList)"
      }
      ExLogicOpType.EQUAL -> {
        if (statement.right is ExValueLit && statement.right.value == null) {
          "${toSql(statement.left, subVars)} IS NULL"
        } else if (statement.left is ExValueLit && statement.left.value == null) {
          "${toSql(statement.right, subVars)} IS NULL"
        } else {
          "${toSql(statement.left, subVars)} = ${toSql(statement.right, subVars)}"
        }
      }
      ExLogicOpType.NOT_EQUAL -> {
        if (statement.right is ExValueLit && statement.right.value == null) {
          "${toSql(statement.left, subVars)} IS NOT NULL"
        } else if (statement.left is ExValueLit && statement.left.value == null) {
          "${toSql(statement.right, subVars)} IS NOT NULL"
        } else {
          "${toSql(statement.left, subVars)} <> ${toSql(statement.right, subVars)}"
        }
      }
      ExLogicOpType.GREATER,
      ExLogicOpType.GREATER_EQUAL,
      ExLogicOpType.LESS,
      ExLogicOpType.LESS_EQUAL -> {
        validateGreaterOrLessOperands(statement.left, statement.right)
        "${toSql(statement.left, subVars)} ${statement.op.symbol} ${toSql(statement.right, subVars)}"
      }
    }.let { stmt ->
      if (statement.not) {
        "NOT ($stmt)"
      } else {
        stmt
      }
    }
  }

  private fun toSql(value: ExValue, subVars: Map<String, Any>): String {
    return when (value) {
      is ExValueList -> throw IllegalArgumentException("list value can only be used with IN or CONTAINS")
      is ExValueCompound -> {
        "${toSql(value.left, subVars)} ${value.op.symbol} ${toSql(value.right, subVars)}"
      }
      is ExValueVar -> value.name
      is ExValueLit -> {
        when (value.getType()) {
          ExDataType.STRING -> "'${value.value.toString().replace("'", "''")}'"
          ExDataType.NUMBER -> value.value.toString()
          ExDataType.REGEX -> throw IllegalArgumentException("regex value can only be used with =~")
          ExDataType.DATE -> {
            val dt = value.value as? LocalDate
                ?: throw IllegalArgumentException("invalid type ${value.value?.javaClass} for DATE value")
            val fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            "'${dt.format(fmt)}'"
          }
          ExDataType.TIME -> {
            val tm = value.value as? LocalTime
              ?: throw IllegalArgumentException("invalid type ${value.value?.javaClass} for TIME value")
            val fmt = DateTimeFormatter.ofPattern("HH:mm:ss")
            "'${tm.format(fmt)}'"
          }
          ExDataType.DATETIME -> {
            val dtTm = value.value as? LocalDateTime
              ?: throw IllegalArgumentException("invalid type ${value.value?.javaClass} for TIME value")
            val fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            "'${dtTm.format(fmt)}'"
          }
          ExDataType.BOOLEAN -> value.toString().uppercase()
          ExDataType.LIST -> throw IllegalArgumentException("list value can only be used with IN or CONTAINS")
        }
      }
      else -> error("Unexpected value type ${value.javaClass}")
    }
  }

  private fun validateGreaterOrLessOperands(left: ExValue, right: ExValue) {
    if (left.getType() != right.getType()) {
      throw IllegalArgumentException("greater/less than operands must be of matching types")
    }

    if (!setOf(
        ExDataType.STRING,
        ExDataType.NUMBER,
        ExDataType.DATE,
        ExDataType.TIME,
        ExDataType.DATETIME
    ).contains(left.getType())) {
      throw IllegalArgumentException("operands for greater/less than must be string, number or date/time")
    }
  }

  private fun validateListElements(list: List<ExValue>) {
    if (list.any { element ->
      element is ExValueLit && element.value == null
    }) {
      throw IllegalArgumentException("null cannot be used as a list value")
    }
  }
}