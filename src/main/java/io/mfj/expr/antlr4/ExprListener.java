// Generated from Expr.g4 by ANTLR 4.7.2
package io.mfj.expr.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(ExprParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(ExprParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExprParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExprParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#parens}.
	 * @param ctx the parse tree
	 */
	void enterParens(ExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#parens}.
	 * @param ctx the parse tree
	 */
	void exitParens(ExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(ExprParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(ExprParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ExprParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ExprParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ExprParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ExprParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(ExprParser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(ExprParser.LiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#nul}.
	 * @param ctx the parse tree
	 */
	void enterNul(ExprParser.NulContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#nul}.
	 * @param ctx the parse tree
	 */
	void exitNul(ExprParser.NulContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ExprParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ExprParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#regex}.
	 * @param ctx the parse tree
	 */
	void enterRegex(ExprParser.RegexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#regex}.
	 * @param ctx the parse tree
	 */
	void exitRegex(ExprParser.RegexContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(ExprParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(ExprParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(ExprParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(ExprParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(ExprParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(ExprParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#datetime}.
	 * @param ctx the parse tree
	 */
	void enterDatetime(ExprParser.DatetimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#datetime}.
	 * @param ctx the parse tree
	 */
	void exitDatetime(ExprParser.DatetimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(ExprParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(ExprParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(ExprParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(ExprParser.ListContext ctx);
}