package io.mfj.expr

// These classes are in target/generated-sources/antlr4/
// If they do not exist, `mvn generate-sources`. (`mvn install` will also do it.)
import io.mfj.expr.antlr4.ExprBaseVisitor
import io.mfj.expr.antlr4.ExprLexer
import io.mfj.expr.antlr4.ExprParser as Antlr4ExprParser
import io.mfj.expr.antlr4.ExprParser.*

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

object ExprParser {

	fun parse(exp:String):ExNode {
		val input = CharStreams.fromString(exp)
		val lexer = ExprLexer(input)
		val tokens = CommonTokenStream(lexer)
		val parser = Antlr4ExprParser(tokens)
		val tree = parser.root()
		if ( ! parser.isMatchedEOF ) throw Exception("did not reach EOF")

		// walk [tree] to generate [ExNode].
		return object:ExprBaseVisitor<Any>() {
			fun ParseTree.v():Any = visit(this)

			override fun visitRoot(ctx:RootContext):Any {
				return ctx.children.first().v()
			}

			override fun visitExpression(ctx:ExpressionContext):ExNode {
				return ExNode(ExNodeType.CONJUNCTION)
						.apply {
							children.add( ctx.term().v() as ExNode )
							if ( ctx.CONJUNCTION() != null ) {
								conj_type = ExConjType.valueOf(ctx.CONJUNCTION().text.uppercase())
								children.add( ctx.expression().v() as ExNode )
							} else {
								conj_type = ExConjType.AND
							}
						}
			}

			override fun visitTerm(ctx:TermContext):Any {
				return ctx.statement()?.v()
						?: ctx.not()?.v()
						?: ctx.parens()?.v()
						?: error("should have found something")
			}

			override fun visitParens(ctx:ParensContext):ExNode {
				return ctx.expression().v() as ExNode
			}

			override fun visitNot(ctx:NotContext):Any {
				return ( ctx.expression().v() as ExNode )
						.apply {
							not = true
						}
			}

			override fun visitStatement(ctx:StatementContext):Any {
				return ExNode(ExNodeType.LOGIC_STATEMENT)
						.apply {
							left = ctx.value(0).v() as ExVal
							op = ctx.OPERATOR(0).text
							right = ctx.value(1).v() as ExVal
							op2 = ctx.OPERATOR(1)?.text
							right2 = ctx.value(2)?.v() as ExVal?
						}
			}

			override fun visitValue(ctx:ValueContext):Any {
				return ctx.literalValue()?.v()
						?: ctx.varName()?.v()
						?: ctx.list()?.v()
						?: ExCom(
								left = ctx.value(0).v() as ExVal,
								right = ctx.value(1).v() as ExVal,
								op = ExMathOpType.fromSymbol( ctx.MATH_OP().text.uppercase() )
						)
			}

			override fun visitVarName(ctx:VarNameContext):Any {
				return ExVar(ctx.text)
			}

			override fun visitLiteralValue(ctx:LiteralValueContext):Any {
				return visit(ctx.children.single())
			}
			override fun visitNul(ctx:NulContext):Any {
				return ExLit(ExDataType.STRING,null)
			}
			override fun visitNumber(ctx:NumberContext):Any {
				return ExLit(ExDataType.NUMBER,ctx.text)
			}
			override fun visitString(ctx:StringContext):Any {
				return ExLit(ExDataType.STRING,
						ctx.text
								.drop(1).dropLast(1) // remove quotes
								.replace("\\\"","\"")
								.replace("\\\\","\\")
				)
			}
			override fun visitRegex(ctx:RegexContext):Any {
				return ExLit(ExDataType.REGEX,
						ctx.text
								.drop(1).dropLast(1) // remove quotes
								.replace("\\/","/")
								.replace("\\\\","\\")
				)
			}
			override fun visitDate(ctx:DateContext):Any {
				return ExLit(ExDataType.DATE,
						ctx.text
								.drop(2).dropLast(1)
								.replace("\\'","'")
								.replace("\\\\","\\")
				)
			}
			override fun visitDatetime(ctx:DatetimeContext):Any {
				val text = ctx.text
				return ExLit(ExDataType.DATETIME,
						ctx.text
								.drop(3).dropLast(1)
								.replace("\\'","'")
								.replace("\\\\","\\")
				)
			}
			override fun visitTime(ctx:TimeContext):Any {
				return ExLit(ExDataType.TIME,
						ctx.text
								.drop(2).dropLast(1)
								.replace("\\'","'")
								.replace("\\\\","\\")
				)
			}
			override fun visitBool(ctx:BoolContext):Any {
				return ExLit(ExDataType.BOOLEAN,ctx.text)
			}

			override fun visitList(ctx:ListContext):Any {
				return ExList(
						ctx.children
								.drop(1).dropLast(1) // remove '[', ']'
								.filterIndexed { i, child -> i % 2 == 0 } // omit commas
								.map { child ->
									child.v() as ExVal
								}
								.toMutableList()
				)
			}
		}.visit(tree) as ExNode
	}

	fun parseToExpr(exp: String, model:VarTypeProvider) : Expr {
		return parse(exp).toExpr(model)
	}

}