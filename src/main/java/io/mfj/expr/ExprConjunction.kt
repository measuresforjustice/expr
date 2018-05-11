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

class ExprConjunction(val type: ExConjType, parms: List<Expr>, var not: Boolean = false) : Expr {
	val params = mutableListOf<Expr>()

	init {
		params.addAll(parms)
	}

	override fun value(vp: VarProvider): Boolean {
		val retval = when (type) {
			ExConjType.AND -> params.all { it.value(vp) }
			ExConjType.OR -> params.any { it.value(vp) }
		}
		return if (not) {
			!retval
		} else {
			retval
		}
	}

	// for expressions, toString() must generate a string
	// that will parse to an identical expression
	override fun toString() : String {
		return if (not) {
			"NOT(${params.joinToString(" ${type.name} ")})"
		} else {
			"(${params.joinToString(" ${type.name} ")})"
		}
	}

	override fun clone() : Expr {
		return ExprConjunction(this.type, params.map(Expr::clone), this.not)
	}

	override fun cloneReplacingForField(fieldName: String?, withExpr: Expr?) : Expr {
		return ExprConjunction(this.type, params.map {
			it.cloneReplacingForField(fieldName, withExpr)
		})
	}

	override fun cloneBifurcatingFields(replMap: Map<String, Expr>?) : Expr {
		return ExprConjunction(this.type, params.map {
			it.cloneBifurcatingFields(replMap)
		})
	}

	fun replaceParam(idx: Int, expr: Expr) {
		if (idx < 0 || idx >= params.size) throw RuntimeException("Function $this has no param $idx")
		params[idx] = expr
	}

	fun addParam(expr: Expr) {
		params.add(expr)
	}

}
