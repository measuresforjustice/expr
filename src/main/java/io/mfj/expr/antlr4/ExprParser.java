// Generated from Expr.g4 by ANTLR 4.7.2
package io.mfj.expr.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NOT=14, CONJUNCTION=15, OPERATOR=16, 
		INT=17, DECIMAL=18, DIGIT=19, TRUE=20, FALSE=21, VAR_NAME=22, WS=23, NOTP=24, 
		ESC=25, RESC=26, SQESC=27;
	public static final int
		RULE_root = 0, RULE_expression = 1, RULE_term = 2, RULE_parens = 3, RULE_not = 4, 
		RULE_notStart = 5, RULE_notSpaceP = 6, RULE_statement = 7, RULE_value = 8, 
		RULE_literalValue = 9, RULE_nul = 10, RULE_string = 11, RULE_regex = 12, 
		RULE_number = 13, RULE_bool = 14, RULE_date = 15, RULE_time = 16, RULE_datetime = 17, 
		RULE_varName = 18, RULE_list = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "expression", "term", "parens", "not", "notStart", "notSpaceP", 
			"statement", "value", "literalValue", "nul", "string", "regex", "number", 
			"bool", "date", "time", "datetime", "varName", "list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'null'", "'\"'", "'/'", "'d''", "':'", "'''", "'t''", 
			"'dt''", "'['", "','", "']'", null, null, null, null, null, null, "'true'", 
			"'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NOT", "CONJUNCTION", "OPERATOR", "INT", "DECIMAL", "DIGIT", 
			"TRUE", "FALSE", "VAR_NAME", "WS", "NOTP", "ESC", "RESC", "SQESC"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			expression();
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode CONJUNCTION() { return getToken(ExprParser.CONJUNCTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			term();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONJUNCTION) {
				{
				setState(44);
				match(CONJUNCTION);
				setState(45);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ParensContext parens() {
			return getRuleContext(ParensContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__8:
			case T__9:
			case T__10:
			case INT:
			case DECIMAL:
			case TRUE:
			case FALSE:
			case VAR_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				statement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				parens();
				}
				break;
			case NOT:
			case NOTP:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				not();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParensContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParensContext parens() throws RecognitionException {
		ParensContext _localctx = new ParensContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			expression();
			setState(55);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public NotStartContext notStart() {
			return getRuleContext(NotStartContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			notStart();
			setState(58);
			expression();
			setState(59);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotStartContext extends ParserRuleContext {
		public TerminalNode NOTP() { return getToken(ExprParser.NOTP, 0); }
		public NotSpacePContext notSpaceP() {
			return getRuleContext(NotSpacePContext.class,0);
		}
		public NotStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNotStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNotStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitNotStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotStartContext notStart() throws RecognitionException {
		NotStartContext _localctx = new NotStartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_notStart);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTP:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(NOTP);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				notSpaceP();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotSpacePContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(ExprParser.NOT, 0); }
		public NotSpacePContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notSpaceP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNotSpaceP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNotSpaceP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitNotSpaceP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotSpacePContext notSpaceP() throws RecognitionException {
		NotSpacePContext _localctx = new NotSpacePContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_notSpaceP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(NOT);
			setState(66);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> OPERATOR() { return getTokens(ExprParser.OPERATOR); }
		public TerminalNode OPERATOR(int i) {
			return getToken(ExprParser.OPERATOR, i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			value();
			setState(69);
			match(OPERATOR);
			setState(70);
			value();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPERATOR) {
				{
				setState(71);
				match(OPERATOR);
				setState(72);
				value();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				varName();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__8:
			case T__9:
			case INT:
			case DECIMAL:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				literalValue();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralValueContext extends ParserRuleContext {
		public NulContext nul() {
			return getRuleContext(NulContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public DatetimeContext datetime() {
			return getRuleContext(DatetimeContext.class,0);
		}
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_literalValue);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				nul();
				}
				break;
			case INT:
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				number();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				string();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				bool();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				regex();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				date();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				time();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 8);
				{
				setState(87);
				datetime();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NulContext extends ParserRuleContext {
		public NulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitNul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NulContext nul() throws RecognitionException {
		NulContext _localctx = new NulContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nul);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> ESC() { return getTokens(ExprParser.ESC); }
		public TerminalNode ESC(int i) {
			return getToken(ExprParser.ESC, i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__3);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(95);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(93);
						match(ESC);
						}
						break;
					case 2:
						{
						setState(94);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(100);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegexContext extends ParserRuleContext {
		public List<TerminalNode> RESC() { return getTokens(ExprParser.RESC); }
		public TerminalNode RESC(int i) {
			return getToken(ExprParser.RESC, i);
		}
		public RegexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterRegex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitRegex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitRegex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegexContext regex() throws RecognitionException {
		RegexContext _localctx = new RegexContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_regex);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__4);
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(105);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(103);
						match(RESC);
						}
						break;
					case 2:
						{
						setState(104);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(110);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(ExprParser.DECIMAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DECIMAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ExprParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ExprParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DateContext extends ParserRuleContext {
		public List<TerminalNode> SQESC() { return getTokens(ExprParser.SQESC); }
		public TerminalNode SQESC(int i) {
			return getToken(ExprParser.SQESC, i);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_date);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__5);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(120);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						setState(117);
						match(SQESC);
						}
						break;
					case 2:
						{
						setState(118);
						match(T__6);
						}
						break;
					case 3:
						{
						setState(119);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(125);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeContext extends ParserRuleContext {
		public List<TerminalNode> SQESC() { return getTokens(ExprParser.SQESC); }
		public TerminalNode SQESC(int i) {
			return getToken(ExprParser.SQESC, i);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_time);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__8);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(128);
						match(SQESC);
						}
						break;
					case 2:
						{
						setState(129);
						match(T__6);
						}
						break;
					case 3:
						{
						setState(130);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(136);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatetimeContext extends ParserRuleContext {
		public List<TerminalNode> SQESC() { return getTokens(ExprParser.SQESC); }
		public TerminalNode SQESC(int i) {
			return getToken(ExprParser.SQESC, i);
		}
		public DatetimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDatetime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDatetime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitDatetime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatetimeContext datetime() throws RecognitionException {
		DatetimeContext _localctx = new DatetimeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_datetime);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__9);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(142);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(139);
						match(SQESC);
						}
						break;
					case 2:
						{
						setState(140);
						match(T__6);
						}
						break;
					case 3:
						{
						setState(141);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(147);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode VAR_NAME() { return getToken(ExprParser.VAR_NAME, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(VAR_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__10);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << INT) | (1L << DECIMAL) | (1L << TRUE) | (1L << FALSE) | (1L << VAR_NAME))) != 0)) {
				{
				setState(152);
				value();
				setState(155); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(153);
						match(T__11);
						setState(154);
						value();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(157); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(159);
					match(T__11);
					}
				}

				}
			}

			setState(164);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\3\3\5\3\61\n\3\3\4"+
		"\3\4\3\4\5\4\66\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7B\n\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tL\n\t\3\n\3\n\3\n\5\nQ\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13[\n\13\3\f\3\f\3\r\3\r\3\r\7\rb\n\r"+
		"\f\r\16\re\13\r\3\r\3\r\3\16\3\16\3\16\7\16l\n\16\f\16\16\16o\13\16\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\7\21{\n\21\f\21\16\21"+
		"~\13\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u0086\n\22\f\22\16\22\u0089"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u0091\n\23\f\23\16\23\u0094"+
		"\13\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\6\25\u009e\n\25\r\25\16"+
		"\25\u009f\3\25\5\25\u00a3\n\25\5\25\u00a5\n\25\3\25\3\25\3\25\7cm|\u0087"+
		"\u0092\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\4\3\2\23\24"+
		"\3\2\26\27\2\u00b2\2*\3\2\2\2\4-\3\2\2\2\6\65\3\2\2\2\b\67\3\2\2\2\n;"+
		"\3\2\2\2\fA\3\2\2\2\16C\3\2\2\2\20F\3\2\2\2\22P\3\2\2\2\24Z\3\2\2\2\26"+
		"\\\3\2\2\2\30^\3\2\2\2\32h\3\2\2\2\34r\3\2\2\2\36t\3\2\2\2 v\3\2\2\2\""+
		"\u0081\3\2\2\2$\u008c\3\2\2\2&\u0097\3\2\2\2(\u0099\3\2\2\2*+\5\4\3\2"+
		"+,\7\2\2\3,\3\3\2\2\2-\60\5\6\4\2./\7\21\2\2/\61\5\4\3\2\60.\3\2\2\2\60"+
		"\61\3\2\2\2\61\5\3\2\2\2\62\66\5\20\t\2\63\66\5\b\5\2\64\66\5\n\6\2\65"+
		"\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\7\3\2\2\2\678\7\3\2\289\5\4"+
		"\3\29:\7\4\2\2:\t\3\2\2\2;<\5\f\7\2<=\5\4\3\2=>\7\4\2\2>\13\3\2\2\2?B"+
		"\7\32\2\2@B\5\16\b\2A?\3\2\2\2A@\3\2\2\2B\r\3\2\2\2CD\7\20\2\2DE\7\3\2"+
		"\2E\17\3\2\2\2FG\5\22\n\2GH\7\22\2\2HK\5\22\n\2IJ\7\22\2\2JL\5\22\n\2"+
		"KI\3\2\2\2KL\3\2\2\2L\21\3\2\2\2MQ\5&\24\2NQ\5\24\13\2OQ\5(\25\2PM\3\2"+
		"\2\2PN\3\2\2\2PO\3\2\2\2Q\23\3\2\2\2R[\5\26\f\2S[\5\34\17\2T[\5\30\r\2"+
		"U[\5\36\20\2V[\5\32\16\2W[\5 \21\2X[\5\"\22\2Y[\5$\23\2ZR\3\2\2\2ZS\3"+
		"\2\2\2ZT\3\2\2\2ZU\3\2\2\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\25"+
		"\3\2\2\2\\]\7\5\2\2]\27\3\2\2\2^c\7\6\2\2_b\7\33\2\2`b\13\2\2\2a_\3\2"+
		"\2\2a`\3\2\2\2be\3\2\2\2cd\3\2\2\2ca\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\6"+
		"\2\2g\31\3\2\2\2hm\7\7\2\2il\7\34\2\2jl\13\2\2\2ki\3\2\2\2kj\3\2\2\2l"+
		"o\3\2\2\2mn\3\2\2\2mk\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\7\2\2q\33\3\2\2"+
		"\2rs\t\2\2\2s\35\3\2\2\2tu\t\3\2\2u\37\3\2\2\2v|\7\b\2\2w{\7\35\2\2x{"+
		"\7\t\2\2y{\13\2\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2|}\3\2\2\2"+
		"|z\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7\n\2\2\u0080!\3\2\2\2\u0081"+
		"\u0087\7\13\2\2\u0082\u0086\7\35\2\2\u0083\u0086\7\t\2\2\u0084\u0086\13"+
		"\2\2\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\n\2\2\u008b#\3\2\2\2\u008c\u0092"+
		"\7\f\2\2\u008d\u0091\7\35\2\2\u008e\u0091\7\t\2\2\u008f\u0091\13\2\2\2"+
		"\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u0094"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0096\7\n\2\2\u0096%\3\2\2\2\u0097\u0098\7\30\2\2"+
		"\u0098\'\3\2\2\2\u0099\u00a4\7\r\2\2\u009a\u009d\5\22\n\2\u009b\u009c"+
		"\7\16\2\2\u009c\u009e\5\22\n\2\u009d\u009b\3\2\2\2\u009e\u009f\3\2\2\2"+
		"\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3"+
		"\7\16\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2"+
		"\u00a4\u009a\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\7\17\2\2\u00a7)\3\2\2\2\25\60\65AKPZackmz|\u0085\u0087\u0090\u0092\u009f"+
		"\u00a2\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}