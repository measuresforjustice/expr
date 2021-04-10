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

class ExprMathStatement(val left: ExValue, var op: ExMathOpType, val right:ExValue) {

  fun value(vp: VarProvider) : Number {

    val leftVal:Any? = left.getValue(vp)
    val rightVal:Any? = right.getValue(vp)

    if( leftVal == null || rightVal == null )
      throw IllegalArgumentException("Input values must not be null")
    if( !(leftVal is Number) || !(rightVal is Number) )
      throw IllegalArgumentException("Input values must be numbers");

    if( leftVal is Int && rightVal is Int ) return calc(leftVal, op, rightVal)
    else return calc( leftVal, op, rightVal )
  }

  private fun calc(leftVal:Number, op:ExMathOpType, rightVal:Number ): Number {
    val l = leftVal.asBigDecimal()
    val r = rightVal.asBigDecimal()
    return when ( op ) {
      ExMathOpType.PLUS -> l + r
      ExMathOpType.MINUS -> l - r
    }
  }

  private fun calc(leftVal:Int, op:ExMathOpType, rightVal:Int ): Number {
    return when ( op ) {
      ExMathOpType.PLUS -> leftVal + rightVal
      ExMathOpType.MINUS -> leftVal - rightVal
    }
  }

  // for expressions, toString() must generate a string
  // that will parse to an identical expression
  override fun toString() : String = "$left${op.symbol}$right"

}
