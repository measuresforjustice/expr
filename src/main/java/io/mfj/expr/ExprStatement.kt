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

class ExprStatement(val left: ExValue, var op: ExOpType, val right:ExValue, var not: Boolean = false) : Expr {

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

  private fun calc( leftVal:Any?, op:ExOpType, rightVal:Any? ): Boolean {
    return when ( op ) {
      ExOpType.EQUAL -> {
        if ( leftVal is Number && rightVal is Number ) {
          leftVal.toDouble() == rightVal.toDouble()
        } else {
          leftVal == rightVal
        }
      }
      ExOpType.REGEX_MATCH -> {
        if ( leftVal != null ) {
          if ( ! ( leftVal is String ) ) throw IllegalArgumentException( "Regex input must be a String, not ${leftVal.javaClass}" )
          val regex = if ( rightVal is Regex ) rightVal else Regex( rightVal.toString() )
          regex.matchEntire( leftVal ) != null
        } else {
          false
        }
      }
      ExOpType.GREATER -> {
        if ( leftVal == null || rightVal == null ) {
          throw IllegalArgumentException( "operands for ${ExOpType.GREATER.symbol} cannot be null" )
        } else if ( leftVal is Number && rightVal is Number ) {
          leftVal.toDouble() > rightVal.toDouble()
        } else if ( leftVal is LocalDate && rightVal is LocalDate ) {
          leftVal > rightVal
        } else if ( leftVal is LocalTime && rightVal is LocalTime ) {
          leftVal > rightVal
        } else if ( leftVal is LocalDateTime && rightVal is LocalDateTime ) {
          leftVal > rightVal
        } else {
          throw IllegalArgumentException( "both operands for ${ExOpType.GREATER.symbol} must be numbers or dates/times/datetimes" )
        }
      }
      ExOpType.GREATER_EQUAL -> {
        if ( leftVal == null || rightVal == null ) {
          throw IllegalArgumentException( "operands for ${ExOpType.GREATER_EQUAL} cannot be null" )
        } else if ( leftVal is Number && rightVal is Number ) {
          leftVal.toDouble() >= rightVal.toDouble()
        } else if ( leftVal is LocalDate && rightVal is LocalDate ) {
          leftVal >= rightVal
        } else if ( leftVal is LocalTime && rightVal is LocalTime ) {
          leftVal >= rightVal
        } else if ( leftVal is LocalDateTime && rightVal is LocalDateTime ) {
          leftVal >= rightVal
        } else {
          throw IllegalArgumentException( "both operands for ${ExOpType.GREATER_EQUAL.symbol} must be numbers or dates/times/datetimes" )
        }
      }
      ExOpType.LESS -> {
        if ( leftVal == null || rightVal == null ) {
          throw IllegalArgumentException( "operands for ${ExOpType.LESS.symbol} cannot be null" )
        } else if ( leftVal is Number && rightVal is Number ) {
          leftVal.toDouble() < rightVal.toDouble()
        } else if ( leftVal is LocalDate && rightVal is LocalDate ) {
          leftVal < rightVal
        } else if ( leftVal is LocalTime && rightVal is LocalTime ) {
          leftVal < rightVal
        } else if ( leftVal is LocalDateTime && rightVal is LocalDateTime ) {
          leftVal < rightVal
        } else {
          throw IllegalArgumentException( "both operands for ${ExOpType.LESS.symbol} must be numbers or dates/times/datetimes" )
        }
      }
      ExOpType.LESS_EQUAL -> {
        if ( leftVal == null || rightVal == null ) {
          throw IllegalArgumentException( "operands for ${ExOpType.LESS_EQUAL} cannot be null" )
        } else if ( leftVal is Number && rightVal is Number ) {
          leftVal.toDouble() <= rightVal.toDouble()
        } else if ( leftVal is LocalDate && rightVal is LocalDate ) {
          leftVal <= rightVal
        } else if ( leftVal is LocalTime && rightVal is LocalTime ) {
          leftVal <= rightVal
        } else if ( leftVal is LocalDateTime && rightVal is LocalDateTime ) {
          leftVal <= rightVal
        } else {
          throw IllegalArgumentException( "both operands for ${ExOpType.LESS_EQUAL.symbol} must be numbers or dates/times/datetimes" )
        }
      }
      ExOpType.NOT_EQUAL -> { leftVal != rightVal }
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
    return ExprStatement(this.left, this.op, this.right, this.not)
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
