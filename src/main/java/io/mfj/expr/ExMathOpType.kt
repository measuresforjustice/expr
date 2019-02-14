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

/**
 * Math Operator types.
 *
 * ORDER MATTERS! The parser tries these in order, so if a symbol is a prefix of another symbol, it must be later.
 * E.g.: '=~' must be after '='.
 *
 * When generating an expression, the first symbol for an op type is preferred.
 */
enum class ExMathOpType(vararg val symbols:String) {
  PLUS("+"),
  MINUS("-"),
  ;

  companion object {
    private val bySymbol:Map<String,ExMathOpType> = values()
        .map { exOpType ->
            exOpType.symbols.map { symbol ->
              symbol to exOpType
            }
          }
          .flatten()
          .toMap() // this keeps order. that is important.

    val symbols:Set<String> = bySymbol.keys

    val symbolsString:String = symbols.fold("") { i, n -> i + n }

    fun fromSymbol( symbol:String ): ExMathOpType = bySymbol[symbol] ?: throw Exception( "No ExMathOpType with symbol ${symbol}" )

    init {
      // Validate that 2 types do not have the same symbol.
      values().forEach { exOpType ->
        exOpType.symbols.forEach { symbol ->
          val t = fromSymbol(symbol)
          if ( t != exOpType ) {
            throw Exception( "Symbol \"${symbol}\" is used by both ${t} and ${exOpType}" )
          }
        }

      }
    }
  }

  val symbol:String = if ( symbols.isNotEmpty() ) symbols.first() else throw Exception( "ExMathOpType.${name} Must have at least one symbol." )

}
