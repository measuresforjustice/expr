package io.mfj.expr

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object SqlUtil {
  fun toSqlExpression(expr:Expr): String {
    return when (expr) {
      is ExprConjunction -> toSql(expr)
      is ExprLogicStatement -> toSql(expr)
      else -> error("Unexpected type ${expr.javaClass}")
    }
  }

  private fun toSql(conjunction: ExprConjunction): String {
    return conjunction.params.joinToString(" ${conjunction.type.name} ") { expr ->
      toSqlExpression(expr)
    }.let { joined ->
      if (conjunction.not) {
        "NOT ($joined)"
      } else {
        "($joined)"
      }
    }
  }

  private fun toSql(statement: ExprLogicStatement): String {
    return when (statement.op) {
      // TODO: Validate that operands are of the correct types for each operator (see ExprLogicStatement.calc)
      ExLogicOpType.REGEX_MATCH -> {
        val literal = (statement.right as? ExValueLit)?.value
            ?: throw IllegalArgumentException("Regex pattern must be a simple literal")
        val regex = if (literal is Regex) literal else Regex(literal.toString())
        // the grammar doesn't seem to have any way to specify a case-insensitive regex
        "${toSql(statement.left)} ~ '${regex.pattern}'"
      }
      ExLogicOpType.IN -> {
        val rightList = ( statement.right as? ExValueList )
            ?: throw IllegalArgumentException("right operand for ${ExLogicOpType.IN} must be a list")
        val joinedList = rightList.values.joinToString { toSql(it) }
        "${toSql(statement.left)} IN ($joinedList)"
      }
      ExLogicOpType.NOT_IN -> {
        val rightList = ( statement.right as? ExValueList )
          ?: throw IllegalArgumentException("right operand for ${ExLogicOpType.IN} must be a list")
        val joinedList = rightList.values.joinToString { toSql(it) }
        "${toSql(statement.left)} NOT IN ($joinedList)"
      }
      ExLogicOpType.CONTAINS -> {
        val leftList = ( statement.left as? ExValueList )
          ?: throw IllegalArgumentException("left operand for ${ExLogicOpType.CONTAINS} must be a list")
        val joinedList = leftList.values.joinToString { toSql(it) }
        "${toSql(statement.right)} IN ($joinedList)"
      }
      ExLogicOpType.NOT_CONTAINS -> {
        val leftList = ( statement.left as? ExValueList )
          ?: throw IllegalArgumentException("left operand for ${ExLogicOpType.CONTAINS} must be a list")
        val joinedList = leftList.values.joinToString { toSql(it) }
        "${toSql(statement.right)} NOT IN ($joinedList)"
      }
      else -> {
        "${toSql(statement.left)} ${statement.op.symbol} ${toSql(statement.right)}"
      }
    }.let { stmt ->
      if (statement.not) {
        "NOT ($stmt)"
      } else {
        stmt
      }
    }
  }

  private fun toSql(value: ExValue): String {
    return when (value) {
      is ExValueList -> throw IllegalArgumentException("list value can only be used with IN or CONTAINS")
      is ExValueCompound -> {
        "${toSql(value.left)} ${value.op.symbol} ${toSql(value.right)}"
      }
      is ExValueVar -> value.name
      is ExValueLit -> {
        when (value.getType()) {
          // TODO: Handle `null` as a possible value (for string at least... also date/time, number, boolean?)
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
}