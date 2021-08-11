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