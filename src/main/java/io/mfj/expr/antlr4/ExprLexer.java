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
		T__9=10, T__10=11, T__11=12, NOT_START=13, NOT_P=14, NOT_SPACE_P=15, NOT=16, 
		CONJUNCTION=17, OPERATOR=18, INT=19, DECIMAL=20, DIGIT=21, TRUE=22, FALSE=23, 
		VAR_NAME=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "NOT_START", "NOT_P", "NOT_SPACE_P", "NOT", 
			"CONJUNCTION", "AND", "OR", "OPERATOR", "IN", "CONTAINS", "ESC", "RESC", 
			"INT", "DECIMAL", "DIGIT", "TRUE", "FALSE", "SQESC", "VAR_NAME", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'null'", "'\"'", "'/'", "'d''", "'''", "'t''", "'dt''", 
			"'['", "','", "']'", null, null, null, null, null, null, null, null, 
			null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "NOT_START", "NOT_P", "NOT_SPACE_P", "NOT", "CONJUNCTION", "OPERATOR", 
			"INT", "DECIMAL", "DIGIT", "TRUE", "FALSE", "VAR_NAME", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00e2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\5\16e\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\5\22s\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u008a\n\25\3\26"+
		"\5\26\u008d\n\26\3\26\3\26\3\26\3\27\5\27\u0093\n\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u00a2\n\30\3\31"+
		"\3\31\3\31\3\31\5\31\u00a8\n\31\3\32\5\32\u00ab\n\32\3\32\6\32\u00ae\n"+
		"\32\r\32\16\32\u00af\3\33\5\33\u00b3\n\33\3\33\7\33\u00b6\n\33\f\33\16"+
		"\33\u00b9\13\33\3\33\3\33\7\33\u00bd\n\33\f\33\16\33\u00c0\13\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\5\37\u00d3\n\37\3 \3 \7 \u00d7\n \f \16 \u00da\13 \3!\6!\u00dd"+
		"\n!\r!\16!\u00de\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\2\'\2)\24+\2-\2/\2\61\2\63"+
		"\25\65\26\67\279\30;\31=\2?\32A\33\3\2\20\4\2PPpp\4\2QQqq\4\2VVvv\4\2"+
		"CCcc\4\2FFff\4\2TTtt\4\2>>@@\4\2KKkk\4\2EEee\4\2UUuu\3\2\62;\5\2C\\aa"+
		"c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00f0\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2)\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tL\3\2\2\2\13N\3\2\2\2\rP\3\2\2\2"+
		"\17S\3\2\2\2\21U\3\2\2\2\23X\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31`\3\2"+
		"\2\2\33d\3\2\2\2\35f\3\2\2\2\37i\3\2\2\2!l\3\2\2\2#r\3\2\2\2%t\3\2\2\2"+
		"\'x\3\2\2\2)\u0089\3\2\2\2+\u008c\3\2\2\2-\u0092\3\2\2\2/\u00a1\3\2\2"+
		"\2\61\u00a7\3\2\2\2\63\u00aa\3\2\2\2\65\u00b2\3\2\2\2\67\u00c1\3\2\2\2"+
		"9\u00c3\3\2\2\2;\u00c8\3\2\2\2=\u00d2\3\2\2\2?\u00d4\3\2\2\2A\u00dc\3"+
		"\2\2\2CD\7*\2\2D\4\3\2\2\2EF\7+\2\2F\6\3\2\2\2GH\7p\2\2HI\7w\2\2IJ\7n"+
		"\2\2JK\7n\2\2K\b\3\2\2\2LM\7$\2\2M\n\3\2\2\2NO\7\61\2\2O\f\3\2\2\2PQ\7"+
		"f\2\2QR\7)\2\2R\16\3\2\2\2ST\7)\2\2T\20\3\2\2\2UV\7v\2\2VW\7)\2\2W\22"+
		"\3\2\2\2XY\7f\2\2YZ\7v\2\2Z[\7)\2\2[\24\3\2\2\2\\]\7]\2\2]\26\3\2\2\2"+
		"^_\7.\2\2_\30\3\2\2\2`a\7_\2\2a\32\3\2\2\2be\5\35\17\2ce\5\37\20\2db\3"+
		"\2\2\2dc\3\2\2\2e\34\3\2\2\2fg\5!\21\2gh\7*\2\2h\36\3\2\2\2ij\5!\21\2"+
		"jk\7*\2\2k \3\2\2\2lm\t\2\2\2mn\t\3\2\2no\t\4\2\2o\"\3\2\2\2ps\5%\23\2"+
		"qs\5\'\24\2rp\3\2\2\2rq\3\2\2\2s$\3\2\2\2tu\t\5\2\2uv\t\2\2\2vw\t\6\2"+
		"\2w&\3\2\2\2xy\t\3\2\2yz\t\7\2\2z(\3\2\2\2{|\7#\2\2|\u008a\7?\2\2}~\7"+
		">\2\2~\u008a\7@\2\2\177\u0080\7@\2\2\u0080\u008a\7?\2\2\u0081\u0082\7"+
		">\2\2\u0082\u008a\7?\2\2\u0083\u008a\t\b\2\2\u0084\u0085\7?\2\2\u0085"+
		"\u008a\7\u0080\2\2\u0086\u008a\7?\2\2\u0087\u008a\5+\26\2\u0088\u008a"+
		"\5-\27\2\u0089{\3\2\2\2\u0089}\3\2\2\2\u0089\177\3\2\2\2\u0089\u0081\3"+
		"\2\2\2\u0089\u0083\3\2\2\2\u0089\u0084\3\2\2\2\u0089\u0086\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a*\3\2\2\2\u008b\u008d\7#\2\2\u008c"+
		"\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\t\t"+
		"\2\2\u008f\u0090\t\2\2\2\u0090,\3\2\2\2\u0091\u0093\7#\2\2\u0092\u0091"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\t\n\2\2\u0095"+
		"\u0096\t\3\2\2\u0096\u0097\t\2\2\2\u0097\u0098\t\4\2\2\u0098\u0099\t\5"+
		"\2\2\u0099\u009a\t\t\2\2\u009a\u009b\t\2\2\2\u009b\u009c\t\13\2\2\u009c"+
		".\3\2\2\2\u009d\u009e\7^\2\2\u009e\u00a2\7$\2\2\u009f\u00a0\7^\2\2\u00a0"+
		"\u00a2\7^\2\2\u00a1\u009d\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\60\3\2\2\2"+
		"\u00a3\u00a4\7^\2\2\u00a4\u00a8\7\61\2\2\u00a5\u00a6\7^\2\2\u00a6\u00a8"+
		"\7^\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\62\3\2\2\2\u00a9"+
		"\u00ab\7/\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00ae\5\67\34\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\64\3\2\2\2\u00b1\u00b3\7/\2\2"+
		"\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b7\3\2\2\2\u00b4\u00b6"+
		"\5\67\34\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2"+
		"\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00be"+
		"\7\60\2\2\u00bb\u00bd\5\67\34\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2"+
		"\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\66\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c2\t\f\2\2\u00c28\3\2\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5"+
		"\7t\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7g\2\2\u00c7:\3\2\2\2\u00c8\u00c9"+
		"\7h\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7u\2\2\u00cc"+
		"\u00cd\7g\2\2\u00cd<\3\2\2\2\u00ce\u00cf\7^\2\2\u00cf\u00d3\7)\2\2\u00d0"+
		"\u00d1\7^\2\2\u00d1\u00d3\7^\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00d0\3\2\2"+
		"\2\u00d3>\3\2\2\2\u00d4\u00d8\t\r\2\2\u00d5\u00d7\t\16\2\2\u00d6\u00d5"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"@\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\t\17\2\2\u00dc\u00db\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e1\b!\2\2\u00e1B\3\2\2\2\22\2dr\u0089\u008c\u0092\u00a1"+
		"\u00a7\u00aa\u00af\u00b2\u00b7\u00be\u00d2\u00d8\u00de\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}