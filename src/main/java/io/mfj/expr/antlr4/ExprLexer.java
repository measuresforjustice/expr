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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NOT_START=6, NOT_P=7, NOT_SPACE_P=8, 
		NOT=9, CONJUNCTION=10, OPERATOR=11, INT=12, DECIMAL=13, DIGIT=14, TRUE=15, 
		FALSE=16, VAR_NAME=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "NOT_START", "NOT_P", "NOT_SPACE_P", 
			"NOT", "CONJUNCTION", "AND", "OR", "OPERATOR", "ESC", "RESC", "INT", 
			"DECIMAL", "DIGIT", "TRUE", "FALSE", "VAR_NAME", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'null'", "'\"'", "'/'", null, null, null, null, 
			null, null, null, null, null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NOT_START", "NOT_P", "NOT_SPACE_P", 
			"NOT", "CONJUNCTION", "OPERATOR", "INT", "DECIMAL", "DIGIT", "TRUE", 
			"FALSE", "VAR_NAME", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\5\7?\n\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\5\13M\n\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"b\n\16\3\17\3\17\3\17\3\17\5\17h\n\17\3\20\3\20\3\20\3\20\5\20n\n\20\3"+
		"\21\5\21q\n\21\3\21\6\21t\n\21\r\21\16\21u\3\22\5\22y\n\22\3\22\7\22|"+
		"\n\22\f\22\16\22\177\13\22\3\22\3\22\7\22\u0083\n\22\f\22\16\22\u0086"+
		"\13\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\7\26\u0097\n\26\f\26\16\26\u009a\13\26\3\27\6\27\u009d\n\27"+
		"\r\27\16\27\u009e\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\2\31\2\33\r\35\2\37\2!\16#\17%\20\'\21)\22+\23-\24\3\2"+
		"\r\4\2PPpp\4\2QQqq\4\2VVvv\4\2CCcc\4\2FFff\4\2TTtt\4\2>>@@\3\2\62;\5\2"+
		"C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00ae\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5"+
		"\61\3\2\2\2\7\63\3\2\2\2\t8\3\2\2\2\13:\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2"+
		"\21C\3\2\2\2\23F\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31R\3\2\2\2\33a\3\2\2"+
		"\2\35g\3\2\2\2\37m\3\2\2\2!p\3\2\2\2#x\3\2\2\2%\u0087\3\2\2\2\'\u0089"+
		"\3\2\2\2)\u008e\3\2\2\2+\u0094\3\2\2\2-\u009c\3\2\2\2/\60\7*\2\2\60\4"+
		"\3\2\2\2\61\62\7+\2\2\62\6\3\2\2\2\63\64\7p\2\2\64\65\7w\2\2\65\66\7n"+
		"\2\2\66\67\7n\2\2\67\b\3\2\2\289\7$\2\29\n\3\2\2\2:;\7\61\2\2;\f\3\2\2"+
		"\2<?\5\17\b\2=?\5\21\t\2><\3\2\2\2>=\3\2\2\2?\16\3\2\2\2@A\5\23\n\2AB"+
		"\7*\2\2B\20\3\2\2\2CD\5\23\n\2DE\7*\2\2E\22\3\2\2\2FG\t\2\2\2GH\t\3\2"+
		"\2HI\t\4\2\2I\24\3\2\2\2JM\5\27\f\2KM\5\31\r\2LJ\3\2\2\2LK\3\2\2\2M\26"+
		"\3\2\2\2NO\t\5\2\2OP\t\2\2\2PQ\t\6\2\2Q\30\3\2\2\2RS\t\3\2\2ST\t\7\2\2"+
		"T\32\3\2\2\2UV\7#\2\2Vb\7?\2\2WX\7>\2\2Xb\7@\2\2YZ\7@\2\2Zb\7?\2\2[\\"+
		"\7>\2\2\\b\7?\2\2]b\t\b\2\2^_\7?\2\2_b\7\u0080\2\2`b\7?\2\2aU\3\2\2\2"+
		"aW\3\2\2\2aY\3\2\2\2a[\3\2\2\2a]\3\2\2\2a^\3\2\2\2a`\3\2\2\2b\34\3\2\2"+
		"\2cd\7^\2\2dh\7$\2\2ef\7^\2\2fh\7^\2\2gc\3\2\2\2ge\3\2\2\2h\36\3\2\2\2"+
		"ij\7^\2\2jn\7\61\2\2kl\7^\2\2ln\7^\2\2mi\3\2\2\2mk\3\2\2\2n \3\2\2\2o"+
		"q\7/\2\2po\3\2\2\2pq\3\2\2\2qs\3\2\2\2rt\5%\23\2sr\3\2\2\2tu\3\2\2\2u"+
		"s\3\2\2\2uv\3\2\2\2v\"\3\2\2\2wy\7/\2\2xw\3\2\2\2xy\3\2\2\2y}\3\2\2\2"+
		"z|\5%\23\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177"+
		"}\3\2\2\2\u0080\u0084\7\60\2\2\u0081\u0083\5%\23\2\u0082\u0081\3\2\2\2"+
		"\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085$\3"+
		"\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\t\t\2\2\u0088&\3\2\2\2\u0089\u008a"+
		"\7v\2\2\u008a\u008b\7t\2\2\u008b\u008c\7w\2\2\u008c\u008d\7g\2\2\u008d"+
		"(\3\2\2\2\u008e\u008f\7h\2\2\u008f\u0090\7c\2\2\u0090\u0091\7n\2\2\u0091"+
		"\u0092\7u\2\2\u0092\u0093\7g\2\2\u0093*\3\2\2\2\u0094\u0098\t\n\2\2\u0095"+
		"\u0097\t\13\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3"+
		"\2\2\2\u0098\u0099\3\2\2\2\u0099,\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009d"+
		"\t\f\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\27\2\2\u00a1.\3\2\2\2"+
		"\17\2>Lagmpux}\u0084\u0098\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}