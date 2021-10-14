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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, CONJUNCTION=6, OPERATOR=7, ESC=8, 
		INT=9, DECIMAL=10, DIGIT=11, TRUE=12, FALSE=13, VAR_NAME=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "CONJUNCTION", "OPERATOR", "ESC", 
			"INT", "DECIMAL", "DIGIT", "TRUE", "FALSE", "VAR_NAME", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'not('", "'null'", "'\"'", null, null, null, null, 
			null, null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "CONJUNCTION", "OPERATOR", "ESC", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\67\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bE\n\b\3\t\3"+
		"\t\3\t\3\t\5\tK\n\t\3\n\5\nN\n\n\3\n\6\nQ\n\n\r\n\16\nR\3\13\5\13V\n\13"+
		"\3\13\7\13Y\n\13\f\13\16\13\\\13\13\3\13\3\13\7\13`\n\13\f\13\16\13c\13"+
		"\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\7\17t\n\17\f\17\16\17w\13\17\3\20\6\20z\n\20\r\20\16\20{\3\20\3\20\2"+
		"\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21\3\2\7\4\2>>@@\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17"+
		"\17\"\"\2\u008d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3"+
		"\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t*\3\2\2\2\13/\3\2\2\2\r\66\3\2\2\2\17D\3"+
		"\2\2\2\21J\3\2\2\2\23M\3\2\2\2\25U\3\2\2\2\27d\3\2\2\2\31f\3\2\2\2\33"+
		"k\3\2\2\2\35q\3\2\2\2\37y\3\2\2\2!\"\7*\2\2\"\4\3\2\2\2#$\7+\2\2$\6\3"+
		"\2\2\2%&\7p\2\2&\'\7q\2\2\'(\7v\2\2()\7*\2\2)\b\3\2\2\2*+\7p\2\2+,\7w"+
		"\2\2,-\7n\2\2-.\7n\2\2.\n\3\2\2\2/\60\7$\2\2\60\f\3\2\2\2\61\62\7c\2\2"+
		"\62\63\7p\2\2\63\67\7f\2\2\64\65\7q\2\2\65\67\7t\2\2\66\61\3\2\2\2\66"+
		"\64\3\2\2\2\67\16\3\2\2\289\7#\2\29E\7?\2\2:;\7>\2\2;E\7@\2\2<=\7@\2\2"+
		"=E\7?\2\2>?\7>\2\2?E\7?\2\2@E\t\2\2\2AB\7?\2\2BE\7\u0080\2\2CE\7?\2\2"+
		"D8\3\2\2\2D:\3\2\2\2D<\3\2\2\2D>\3\2\2\2D@\3\2\2\2DA\3\2\2\2DC\3\2\2\2"+
		"E\20\3\2\2\2FG\7^\2\2GK\7$\2\2HI\7^\2\2IK\7^\2\2JF\3\2\2\2JH\3\2\2\2K"+
		"\22\3\2\2\2LN\7/\2\2ML\3\2\2\2MN\3\2\2\2NP\3\2\2\2OQ\5\27\f\2PO\3\2\2"+
		"\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\24\3\2\2\2TV\7/\2\2UT\3\2\2\2UV\3\2"+
		"\2\2VZ\3\2\2\2WY\5\27\f\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3"+
		"\2\2\2\\Z\3\2\2\2]a\7\60\2\2^`\5\27\f\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2"+
		"ab\3\2\2\2b\26\3\2\2\2ca\3\2\2\2de\t\3\2\2e\30\3\2\2\2fg\7v\2\2gh\7t\2"+
		"\2hi\7w\2\2ij\7g\2\2j\32\3\2\2\2kl\7h\2\2lm\7c\2\2mn\7n\2\2no\7u\2\2o"+
		"p\7g\2\2p\34\3\2\2\2qu\t\4\2\2rt\t\5\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2"+
		"uv\3\2\2\2v\36\3\2\2\2wu\3\2\2\2xz\t\6\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|}\3\2\2\2}~\b\20\2\2~ \3\2\2\2\r\2\66DJMRUZau{\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}