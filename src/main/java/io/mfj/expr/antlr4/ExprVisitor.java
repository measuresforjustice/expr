// Generated from Expr.g4 by ANTLR 4.7.2
package io.mfj.expr.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ExprParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ExprParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ExprParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ExprParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#literalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(ExprParser.LiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#nul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNul(ExprParser.NulContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ExprParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegex(ExprParser.RegexContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ExprParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ExprParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(ExprParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(ExprParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#datetime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetime(ExprParser.DatetimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(ExprParser.VarNameContext ctx);
}