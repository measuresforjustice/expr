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

class ExNode(val node_type: ExNodeType) {
	var parent: ExNode? = null
	var conj_type: ExConjType? = null
	var left: ExVal? = null
	var op: String? = null
	var right: ExVal? = null

	var op2: String? = null
	var right2 : ExVal? = null

	var not: Boolean = false
	val children: MutableList<ExNode> = mutableListOf()

	fun setParent(p: ExNode) : Boolean {
		parent = p
		return true
	}

	fun setConjType(t: ExConjType) : Boolean {
		conj_type = t
		return true
	}

	fun setLeft(v: ExVal) : Boolean {
	  left = v
		return true
	}

	fun setOp(o: String) : Boolean {
		op = o
		return true
	}

	fun setRight(v: ExVal) : Boolean {
		right = v
		return true
	}

	fun setOp2( o:String ) : Boolean {
		op2 = o
		return true
	}
	fun setRight2( v:ExVal ) : Boolean {
		right2 = v
		return true
	}

	fun setNot(n: Boolean) : Boolean {
		not = n
		return true
	}

	fun addChild(c: ExNode) : Boolean {
		c.setParent(this)
		children.add(c)
		return true
	}

	fun toExpr(model: VarTypeProvider) : Expr {
		if (node_type == ExNodeType.CONJUNCTION && conj_type == null) {
			conj_type = ExConjType.AND
		}
		return when(node_type) {
			ExNodeType.STATEMENT -> {
				val left = this.left ?: throw Exception( "Left not set" )
				val right = this.right ?: throw Exception( "Right not set" )
				val leftValue = getExValue( left, model )
				val rightValue = getExValue( right, model )

				val stmt = ExprStatement( leftValue, ExOpType.fromSymbol(op!!), rightValue, not)

				if ( op2 == null ) {
					if ( right2 != null ) throw Exception( "If right2 (${right2}) is not null, op2 must not be null" )
					stmt
				} else {
					if ( right2 == null ) throw Exception( "If op2 (${op2}) is not null, right2 must not be null" )

					val right2Value = getExValue( right2!!, model )

					stmt.not = false
					val stmt2 = ExprStatement( rightValue, ExOpType.fromSymbol(op2!!), right2Value, false )

					ExprConjunction( ExConjType.AND,
							listOf( stmt, stmt2 ),
							not )
				}
			}
			ExNodeType.CONJUNCTION -> ExprConjunction(conj_type!!, children.map { it.toExpr(model) }, not)
		}
	}

	private fun getExValue( v:ExVal, model:VarTypeProvider ): ExValue =
			when ( v ) {
				is ExVar -> ExValueVar(
						type = model[v.name],
						name = v.name )
				is ExLit -> ExValueLit(
						type = v.type,
						value = ExConvert.convertStr( v.value, v.type ) )
			}

	override fun toString() : String {
		when(node_type) {
			ExNodeType.STATEMENT -> return "$left $op $right"
			ExNodeType.CONJUNCTION -> return "$conj_type"
		}
	}

}

interface ExValue {
	fun getType(): ExDataType
	fun getValue( vp:VarProvider ): Any?
	/** If not null, this value is a variable. */
	fun getVariableName(): String?

	fun isVariable():Boolean = getVariableName() != null
	fun isLiteral():Boolean = getVariableName() == null
}
class ExValueVar( private val type:ExDataType, private val name:String ): ExValue {
	override fun getType(): ExDataType = type
	override fun getVariableName(): String? = name
	override fun getValue(vp: VarProvider):Any? = vp[name]

	override fun toString():String = name
}
class ExValueLit( private val type:ExDataType, private val value:Any? ): ExValue {
	override fun getType(): ExDataType = type
	override fun getVariableName(): String? = null
	override fun getValue(vp: VarProvider):Any? = value

	override fun toString():String =
			value?.let { value ->
				when ( type ) {
					ExDataType.STRING -> "\"${escape(value,"\"")}\""
					ExDataType.DOUBLE -> value.toString()
					ExDataType.INTEGER -> value.toString()
					ExDataType.REGEX -> "/${escape(value,"/")}/"
					ExDataType.DATE -> "d'${escape(value, "'")}'"
					ExDataType.TIME -> "t'${escape(value, "'")}'"
					ExDataType.DATETIME -> "dt'${escape(value, "'")}'"
					ExDataType.BOOLEAN -> value.toString()
				}
			} ?: "null"

	private fun escape( value:Any, toEscape:String ) = value
			.toString()
			.replace( "\\", "\\\\" )
			.replace( toEscape, "\\${toEscape}" )

}
