/*
Copyright 2021 Measures for Justice Institute.

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
 * Get the variable names that are referenced in the supplied [expr].
 */
fun getVarNames( expr:Expr ):Set<String> {
	val varNames:MutableSet<String> = mutableSetOf()
	getVarNames( varNames, expr )
	return varNames
}

/**
 * Add the variable names that are referenced in the supplied [expr] to [varNames].
 */
fun getVarNames( varNames:MutableSet<String>, expr:Expr ) {
	when(expr) {
		is ExprConjunction -> {
			expr.params.forEach { param -> getVarNames(varNames,param) }
		}
		is ExprLogicStatement -> {
			getVarNames(varNames,expr.left)
			getVarNames(varNames,expr.right)
		}
		else -> error("Unexpected type ${expr.javaClass}")
	}
}

/**
 * Add the variable names that are referenced in the supplied [value] to [varNames].
 */
fun getVarNames( varNames:MutableSet<String>, value:ExValue ) {
	when(value) {
		is ExValueVar -> varNames.add(value.getVariableName())
		is ExValueLit -> { /* no vars in a literal */ }
		is ExValueList -> value.values.forEach { v -> getVarNames(varNames,v) }
		is ExValueCompound -> {
			getVarNames( varNames, value.left )
			getVarNames( varNames, value.right )
		}
		else -> error("Unexpected type ${value.javaClass}")
	}
}