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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, CONJUNCTION=7, OPERATOR=8, 
		INT=9, DECIMAL=10, DIGIT=11, TRUE=12, FALSE=13, VAR_NAME=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "CONJUNCTION", "OPERATOR", 
			"ESC", "RESC", "INT", "DECIMAL", "DIGIT", "TRUE", "FALSE", "VAR_NAME", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'not('", "'null'", "'\"'", "'/'", null, null, null, 
			null, null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "CONJUNCTION", "OPERATOR", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b=\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\tK\n\t\3\n\3\n\3\n\3\n\5\nQ\n\n\3\13\3\13\3\13\3\13"+
		"\5\13W\n\13\3\f\5\fZ\n\f\3\f\6\f]\n\f\r\f\16\f^\3\r\5\rb\n\r\3\r\7\re"+
		"\n\r\f\r\16\rh\13\r\3\r\3\r\7\rl\n\r\f\r\16\ro\13\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u0080\n\21"+
		"\f\21\16\21\u0083\13\21\3\22\6\22\u0086\n\22\r\22\16\22\u0087\3\22\3\22"+
		"\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27\13\31\f\33\r\35"+
		"\16\37\17!\20#\21\3\2\7\4\2>>@@\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2"+
		"\13\f\17\17\"\"\2\u0098\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t.\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2"+
		"\2\17<\3\2\2\2\21J\3\2\2\2\23P\3\2\2\2\25V\3\2\2\2\27Y\3\2\2\2\31a\3\2"+
		"\2\2\33p\3\2\2\2\35r\3\2\2\2\37w\3\2\2\2!}\3\2\2\2#\u0085\3\2\2\2%&\7"+
		"*\2\2&\4\3\2\2\2\'(\7+\2\2(\6\3\2\2\2)*\7p\2\2*+\7q\2\2+,\7v\2\2,-\7*"+
		"\2\2-\b\3\2\2\2./\7p\2\2/\60\7w\2\2\60\61\7n\2\2\61\62\7n\2\2\62\n\3\2"+
		"\2\2\63\64\7$\2\2\64\f\3\2\2\2\65\66\7\61\2\2\66\16\3\2\2\2\678\7c\2\2"+
		"89\7p\2\29=\7f\2\2:;\7q\2\2;=\7t\2\2<\67\3\2\2\2<:\3\2\2\2=\20\3\2\2\2"+
		">?\7#\2\2?K\7?\2\2@A\7>\2\2AK\7@\2\2BC\7@\2\2CK\7?\2\2DE\7>\2\2EK\7?\2"+
		"\2FK\t\2\2\2GH\7?\2\2HK\7\u0080\2\2IK\7?\2\2J>\3\2\2\2J@\3\2\2\2JB\3\2"+
		"\2\2JD\3\2\2\2JF\3\2\2\2JG\3\2\2\2JI\3\2\2\2K\22\3\2\2\2LM\7^\2\2MQ\7"+
		"$\2\2NO\7^\2\2OQ\7^\2\2PL\3\2\2\2PN\3\2\2\2Q\24\3\2\2\2RS\7^\2\2SW\7\61"+
		"\2\2TU\7^\2\2UW\7^\2\2VR\3\2\2\2VT\3\2\2\2W\26\3\2\2\2XZ\7/\2\2YX\3\2"+
		"\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\5\33\16\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2"+
		"^_\3\2\2\2_\30\3\2\2\2`b\7/\2\2a`\3\2\2\2ab\3\2\2\2bf\3\2\2\2ce\5\33\16"+
		"\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2im\7\60"+
		"\2\2jl\5\33\16\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\32\3\2\2\2o"+
		"m\3\2\2\2pq\t\3\2\2q\34\3\2\2\2rs\7v\2\2st\7t\2\2tu\7w\2\2uv\7g\2\2v\36"+
		"\3\2\2\2wx\7h\2\2xy\7c\2\2yz\7n\2\2z{\7u\2\2{|\7g\2\2| \3\2\2\2}\u0081"+
		"\t\4\2\2~\u0080\t\5\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\"\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086"+
		"\t\6\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\22\2\2\u008a$\3\2\2\2"+
		"\16\2<JPVY^afm\u0081\u0087\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}