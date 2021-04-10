/*
Copyright 2018 Measures for Justice Institute.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package io.mfj.expr

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class ExprLogicStatement(val left: ExValue, var op: ExLogicOpType, val right:ExValue, var not: Boolean = false) : Expr {

  override fun value(vp: VarProvider) : Boolean {

    val leftVal:Any? = left.getValue(vp)
    val rightVal:Any? = right.getValue(vp)

    val retval = calc( leftVal, op, rightVal )

    return if (not) {
      !retval
    } else {
      retval
    }
  }

  private fun calc(leftVal:Any?, op:ExLogicOpType, rightVal:Any? ): Boolean {
    return when ( op ) {
      ExLogicOpType.EQUAL -> {
        if ( leftVal is Number && rightVal is Number ) {
          leftVal.asBigDecimal().compareTo( rightVal.asBigDecimal() ) == 0
        } else {
          leftVal == rightVal
        }
      }
      ExLogicOpType.REGEX_MATCH -> {
        if ( leftVal != null ) {
          if (leftVal !is String) throw IllegalArgumentException( "Regex input must be a String, not ${leftVal.javaClass}" )
          val regex = if ( rightVal is Regex ) rightVal else Regex( rightVal.toString() )
          regex.matchEntire( leftVal ) != null
        } else {
          false
        }
      }
      ExLogicOpType.GREATER -> {
        when {
          leftVal == null || rightVal == null -> {
            throw IllegalArgumentException( "operands for ${ExLogicOpType.GREATER.symbol} cannot be null" )
          }
		  leftVal is String && rightVal is String -> {
            leftVal > rightVal
          }
          leftVal is Number && rightVal is Number -> {
            leftVal.asBigDecimal() > rightVal.asBigDecimal()
          }
          leftVal is LocalDate && rightVal is LocalDate -> {
            leftVal > rightVal
          }
          leftVal is LocalTime && rightVal is LocalTime -> {
            leftVal > rightVal
          }
          leftVal is LocalDateTime && rightVal is LocalDateTime -> {
            leftVal > rightVal
          }
          else -> {
            throw IllegalArgumentException( "both operands for ${ExLogicOpType.GREATER.symbol} must be numbers or dates/times/datetimes" )
          }
        }
      }
      ExLogicOpType.GREATER_EQUAL -> {
        when {
          leftVal == null || rightVal == null -> {
            throw IllegalArgumentException( "operands for ${ExLogicOpType.GREATER_EQUAL} cannot be null" )
          }
          leftVal is String && rightVal is String -> {
            leftVal >= rightVal
          }
          leftVal is Number && rightVal is Number -> {
            leftVal.asBigDecimal() >= rightVal.asBigDecimal()
          }
          leftVal is LocalDate && rightVal is LocalDate -> {
            leftVal >= rightVal
          }
          leftVal is LocalTime && rightVal is LocalTime -> {
            leftVal >= rightVal
          }
          leftVal is LocalDateTime && rightVal is LocalDateTime -> {
            leftVal >= rightVal
          }
          else -> {
            throw IllegalArgumentException( "both operands for ${ExLogicOpType.GREATER_EQUAL.symbol} must be numbers or dates/times/datetimes" )
          }
        }
      }
      ExLogicOpType.LESS -> {
        when {
          leftVal == null || rightVal == null -> {
            throw IllegalArgumentException( "operands for ${ExLogicOpType.LESS.symbol} cannot be null" )
          }
          leftVal is String && rightVal is String -> {
            leftVal < rightVal
          }
          leftVal is Number && rightVal is Number -> {
            leftVal.asBigDecimal() < rightVal.asBigDecimal()
          }
          leftVal is LocalDate && rightVal is LocalDate -> {
            leftVal < rightVal
          }
          leftVal is LocalTime && rightVal is LocalTime -> {
            leftVal < rightVal
          }
          leftVal is LocalDateTime && rightVal is LocalDateTime -> {
            leftVal < rightVal
          }
          else -> {
            throw IllegalArgumentException( "both operands for ${ExLogicOpType.LESS.symbol} must be numbers or dates/times/datetimes" )
          }
        }
      }
      ExLogicOpType.LESS_EQUAL -> {
        when {
          leftVal == null || rightVal == null -> {
            throw IllegalArgumentException( "operands for ${ExLogicOpType.LESS_EQUAL} cannot be null" )
          }
          leftVal is String && rightVal is String -> {
            leftVal <= rightVal
          }
          leftVal is Number && rightVal is Number -> {
            leftVal.asBigDecimal() <= rightVal.asBigDecimal()
          }
          leftVal is LocalDate && rightVal is LocalDate -> {
            leftVal <= rightVal
          }
          leftVal is LocalTime && rightVal is LocalTime -> {
            leftVal <= rightVal
          }
          leftVal is LocalDateTime && rightVal is LocalDateTime -> {
            leftVal <= rightVal
          }
          else -> {
            throw IllegalArgumentException( "both operands for ${ExLogicOpType.LESS_EQUAL.symbol} must be numbers or dates/times/datetimes" )
          }
        }
      }
      ExLogicOpType.NOT_EQUAL -> { leftVal != rightVal }
    }
  }

  // for expressions, toString() must generate a string
  // that will parse to an identical expression
  override fun toString() : String {
    return if (not) {
      "NOT( $left${op.symbol}$right )"
    } else {
      "$left${op.symbol}$right"
    }
  }

  override fun clone() : Expr {
    return ExprLogicStatement(this.left, this.op, this.right, this.not)
  }

  override fun cloneReplacingForField(fieldName: String?, withExpr: Expr?) : Expr {
    return if ( fieldName != null &&
        ( left.getVariableName() == fieldName || right.getVariableName() == fieldName ) ) {
      withExpr!!
    } else {
      clone()
    }
  }

  override fun cloneBifurcatingFields(replMap: Map<String, Expr>?) : Expr {
    val list:MutableList<Expr> = mutableListOf( clone() )
    if ( replMap != null ) {
      left.getVariableName()?.let { name -> replMap[name]?.let { list.add( it ) } }
      right.getVariableName()?.let { name -> replMap[name]?.let { list.add( it ) } }
    }
    return ExprConjunction(ExConjType.OR, list )
  }

}
