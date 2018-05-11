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

import org.parboiled.Parboiled
import org.parboiled.errors.ErrorUtils
import org.parboiled.parserunners.ReportingParseRunner

object ExprParser {

	fun parse(exp: String) : ExNode {
		//println("-=-= parsing: $exp")
		val parser = Parboiled.createParser(ExprPegParser::class.java)
		val result = ReportingParseRunner<Any>(parser.Root()).run(exp)
		if ( result.hasErrors() ) {
			throw Exception( ErrorUtils.printParseError( result.parseErrors[0] ) )
		}
		if (!result.valueStack.isEmpty) {
			val root = result.valueStack.pop() as ExNode
			if (root.node_type == ExNodeType.CONJUNCTION && root.conj_type == null && root.children.size == 1) {
				return root.children[0]
			}
			return root
		} else {
			throw RuntimeException("Error parsing expression $exp")
		}
	}

	fun parseToExpr(exp: String, model:VarTypeProvider ) : Expr {
		return parse(exp).toExpr(model)
	}


}
