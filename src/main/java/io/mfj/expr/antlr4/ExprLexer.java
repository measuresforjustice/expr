// Generated from Expr.g4 by ANTLR 4.7.2
package io.mfj.expr.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NOT=14, CONJUNCTION=15, OPERATOR=16, 
		INT=17, DECIMAL=18, DIGIT=19, TRUE=20, FALSE=21, VAR_NAME=22, MATH_OP=23, 
		WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "NOTP", "NOT", "CONJUNCTION", "AND", 
			"OR", "OPERATOR", "IN", "CONTAINS", "ESC", "RESC", "INT", "DECIMAL", 
			"DIGIT", "TRUE", "FALSE", "SQESC", "VAR_NAME", "MATH_OP", "WS"
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
			"TRUE", "FALSE", "VAR_NAME", "MATH_OP", "WS"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00e1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\5\21p\n\21"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0087\n\24\3\25\5\25\u008a\n"+
		"\25\3\25\3\25\3\25\3\26\5\26\u0090\n\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u009f\n\27\3\30\3\30\3\30\3\30"+
		"\5\30\u00a5\n\30\3\31\5\31\u00a8\n\31\3\31\6\31\u00ab\n\31\r\31\16\31"+
		"\u00ac\3\32\5\32\u00b0\n\32\3\32\7\32\u00b3\n\32\f\32\16\32\u00b6\13\32"+
		"\3\32\3\32\7\32\u00ba\n\32\f\32\16\32\u00bd\13\32\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36"+
		"\u00d0\n\36\3\37\3\37\7\37\u00d4\n\37\f\37\16\37\u00d7\13\37\3 \3 \3!"+
		"\6!\u00dc\n!\r!\16!\u00dd\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\21#\2%\2\'\22)\2+\2-\2/\2\61"+
		"\23\63\24\65\25\67\269\27;\2=\30?\31A\32\3\2\21\4\2PPpp\4\2QQqq\4\2VV"+
		"vv\4\2CCcc\4\2FFff\4\2TTtt\4\2>>@@\4\2KKkk\4\2EEee\4\2UUuu\3\2\62;\5\2"+
		"C\\aac|\6\2\62;C\\aac|\4\2--//\5\2\13\f\17\17\"\"\2\u00ed\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2\'\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tL\3\2\2\2\13N\3\2\2\2\rP\3\2"+
		"\2\2\17S\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25Z\3\2\2\2\27^\3\2\2\2\31`\3"+
		"\2\2\2\33b\3\2\2\2\35d\3\2\2\2\37i\3\2\2\2!o\3\2\2\2#q\3\2\2\2%u\3\2\2"+
		"\2\'\u0086\3\2\2\2)\u0089\3\2\2\2+\u008f\3\2\2\2-\u009e\3\2\2\2/\u00a4"+
		"\3\2\2\2\61\u00a7\3\2\2\2\63\u00af\3\2\2\2\65\u00be\3\2\2\2\67\u00c0\3"+
		"\2\2\29\u00c5\3\2\2\2;\u00cf\3\2\2\2=\u00d1\3\2\2\2?\u00d8\3\2\2\2A\u00db"+
		"\3\2\2\2CD\7*\2\2D\4\3\2\2\2EF\7+\2\2F\6\3\2\2\2GH\7p\2\2HI\7w\2\2IJ\7"+
		"n\2\2JK\7n\2\2K\b\3\2\2\2LM\7$\2\2M\n\3\2\2\2NO\7\61\2\2O\f\3\2\2\2PQ"+
		"\7f\2\2QR\7)\2\2R\16\3\2\2\2ST\7<\2\2T\20\3\2\2\2UV\7)\2\2V\22\3\2\2\2"+
		"WX\7v\2\2XY\7)\2\2Y\24\3\2\2\2Z[\7f\2\2[\\\7v\2\2\\]\7)\2\2]\26\3\2\2"+
		"\2^_\7]\2\2_\30\3\2\2\2`a\7.\2\2a\32\3\2\2\2bc\7_\2\2c\34\3\2\2\2de\t"+
		"\2\2\2ef\t\3\2\2fg\t\4\2\2gh\7*\2\2h\36\3\2\2\2ij\t\2\2\2jk\t\3\2\2kl"+
		"\t\4\2\2l \3\2\2\2mp\5#\22\2np\5%\23\2om\3\2\2\2on\3\2\2\2p\"\3\2\2\2"+
		"qr\t\5\2\2rs\t\2\2\2st\t\6\2\2t$\3\2\2\2uv\t\3\2\2vw\t\7\2\2w&\3\2\2\2"+
		"xy\7#\2\2y\u0087\7?\2\2z{\7>\2\2{\u0087\7@\2\2|}\7@\2\2}\u0087\7?\2\2"+
		"~\177\7>\2\2\177\u0087\7?\2\2\u0080\u0087\t\b\2\2\u0081\u0082\7?\2\2\u0082"+
		"\u0087\7\u0080\2\2\u0083\u0087\7?\2\2\u0084\u0087\5)\25\2\u0085\u0087"+
		"\5+\26\2\u0086x\3\2\2\2\u0086z\3\2\2\2\u0086|\3\2\2\2\u0086~\3\2\2\2\u0086"+
		"\u0080\3\2\2\2\u0086\u0081\3\2\2\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0085\3\2\2\2\u0087(\3\2\2\2\u0088\u008a\7#\2\2\u0089\u0088"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\t\t\2\2\u008c"+
		"\u008d\t\2\2\2\u008d*\3\2\2\2\u008e\u0090\7#\2\2\u008f\u008e\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\t\n\2\2\u0092\u0093\t\3"+
		"\2\2\u0093\u0094\t\2\2\2\u0094\u0095\t\4\2\2\u0095\u0096\t\5\2\2\u0096"+
		"\u0097\t\t\2\2\u0097\u0098\t\2\2\2\u0098\u0099\t\13\2\2\u0099,\3\2\2\2"+
		"\u009a\u009b\7^\2\2\u009b\u009f\7$\2\2\u009c\u009d\7^\2\2\u009d\u009f"+
		"\7^\2\2\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f.\3\2\2\2\u00a0\u00a1"+
		"\7^\2\2\u00a1\u00a5\7\61\2\2\u00a2\u00a3\7^\2\2\u00a3\u00a5\7^\2\2\u00a4"+
		"\u00a0\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\60\3\2\2\2\u00a6\u00a8\7/\2\2"+
		"\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00ab"+
		"\5\65\33\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\62\3\2\2\2\u00ae\u00b0\7/\2\2\u00af\u00ae\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b4\3\2\2\2\u00b1\u00b3\5\65\33\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bb\7\60\2\2\u00b8"+
		"\u00ba\5\65\33\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3"+
		"\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\64\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00bf\t\f\2\2\u00bf\66\3\2\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7t\2\2"+
		"\u00c2\u00c3\7w\2\2\u00c3\u00c4\7g\2\2\u00c48\3\2\2\2\u00c5\u00c6\7h\2"+
		"\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7u\2\2\u00c9\u00ca"+
		"\7g\2\2\u00ca:\3\2\2\2\u00cb\u00cc\7^\2\2\u00cc\u00d0\7)\2\2\u00cd\u00ce"+
		"\7^\2\2\u00ce\u00d0\7^\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"<\3\2\2\2\u00d1\u00d5\t\r\2\2\u00d2\u00d4\t\16\2\2\u00d3\u00d2\3\2\2\2"+
		"\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6>\3"+
		"\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\t\17\2\2\u00d9@\3\2\2\2\u00da\u00dc"+
		"\t\20\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\b!\2\2\u00e0B\3\2"+
		"\2\2\21\2o\u0086\u0089\u008f\u009e\u00a4\u00a7\u00ac\u00af\u00b4\u00bb"+
		"\u00cf\u00d5\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}