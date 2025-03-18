// Generated from TLANG.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TLANGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, PLUS=21, MINUS=22, MUL=23, DIV=24, PENCOND=25, 
		LT=26, GT=27, EQ=28, NEQ=29, LTE=30, GTE=31, AND=32, OR=33, NOT=34, NUM=35, 
		VAR=36, NAME=37, Whitespace=38;
	public static final int
		RULE_start = 0, RULE_instruction_list = 1, RULE_strict_ilist = 2, RULE_instruction = 3, 
		RULE_conditional = 4, RULE_ifConditional = 5, RULE_ifElseConditional = 6, 
		RULE_loop = 7, RULE_gotoCommand = 8, RULE_assignment = 9, RULE_moveCommand = 10, 
		RULE_moveOp = 11, RULE_penCommand = 12, RULE_pauseCommand = 13, RULE_expression = 14, 
		RULE_multiplicative = 15, RULE_additive = 16, RULE_unaryArithOp = 17, 
		RULE_procedureDeclaration = 18, RULE_paramList = 19, RULE_procedureCall = 20, 
		RULE_functionCall = 21, RULE_argList = 22, RULE_returnStatement = 23, 
		RULE_condition = 24, RULE_binCondOp = 25, RULE_logicOp = 26, RULE_value = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "instruction_list", "strict_ilist", "instruction", "conditional", 
			"ifConditional", "ifElseConditional", "loop", "gotoCommand", "assignment", 
			"moveCommand", "moveOp", "penCommand", "pauseCommand", "expression", 
			"multiplicative", "additive", "unaryArithOp", "procedureDeclaration", 
			"paramList", "procedureCall", "functionCall", "argList", "returnStatement", 
			"condition", "binCondOp", "logicOp", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'['", "']'", "'else'", "'repeat'", "'goto'", "'('", "','", 
			"')'", "'='", "'forward'", "'backward'", "'left'", "'right'", "'penup'", 
			"'pendown'", "'pause'", "'to'", "'end'", "'output'", "'+'", "'-'", "'*'", 
			"'/'", "'pendown?'", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", "'&&'", 
			"'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "PLUS", "MINUS", 
			"MUL", "DIV", "PENCOND", "LT", "GT", "EQ", "NEQ", "LTE", "GTE", "AND", 
			"OR", "NOT", "NUM", "VAR", "NAME", "Whitespace"
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
	public String getGrammarFileName() { return "TLANG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TLANGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Instruction_listContext instruction_list() {
			return getRuleContext(Instruction_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TLANGParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			instruction_list();
			setState(57);
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

	public static class Instruction_listContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Instruction_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterInstruction_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitInstruction_list(this);
		}
	}

	public final Instruction_listContext instruction_list() throws RecognitionException {
		Instruction_listContext _localctx = new Instruction_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__5) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << VAR) | (1L << NAME))) != 0)) {
				{
				{
				setState(59);
				instruction();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Strict_ilistContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Strict_ilistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strict_ilist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterStrict_ilist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitStrict_ilist(this);
		}
	}

	public final Strict_ilistContext strict_ilist() throws RecognitionException {
		Strict_ilistContext _localctx = new Strict_ilistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_strict_ilist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				instruction();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__5) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << VAR) | (1L << NAME))) != 0) );
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

	public static class InstructionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ProcedureDeclarationContext procedureDeclaration() {
			return getRuleContext(ProcedureDeclarationContext.class,0);
		}
		public ProcedureCallContext procedureCall() {
			return getRuleContext(ProcedureCallContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public MoveCommandContext moveCommand() {
			return getRuleContext(MoveCommandContext.class,0);
		}
		public PenCommandContext penCommand() {
			return getRuleContext(PenCommandContext.class,0);
		}
		public GotoCommandContext gotoCommand() {
			return getRuleContext(GotoCommandContext.class,0);
		}
		public PauseCommandContext pauseCommand() {
			return getRuleContext(PauseCommandContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				assignment();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				conditional();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				loop();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				procedureDeclaration();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				procedureCall();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				returnStatement();
				}
				break;
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				moveCommand();
				}
				break;
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 8);
				{
				setState(77);
				penCommand();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 9);
				{
				setState(78);
				gotoCommand();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 10);
				{
				setState(79);
				pauseCommand();
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

	public static class ConditionalContext extends ParserRuleContext {
		public IfConditionalContext ifConditional() {
			return getRuleContext(IfConditionalContext.class,0);
		}
		public IfElseConditionalContext ifElseConditional() {
			return getRuleContext(IfElseConditionalContext.class,0);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_conditional);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				ifConditional();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				ifElseConditional();
				}
				break;
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

	public static class IfConditionalContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Strict_ilistContext strict_ilist() {
			return getRuleContext(Strict_ilistContext.class,0);
		}
		public IfConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifConditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterIfConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitIfConditional(this);
		}
	}

	public final IfConditionalContext ifConditional() throws RecognitionException {
		IfConditionalContext _localctx = new IfConditionalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifConditional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__0);
			setState(87);
			condition(0);
			setState(88);
			match(T__1);
			setState(89);
			strict_ilist();
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

	public static class IfElseConditionalContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<Strict_ilistContext> strict_ilist() {
			return getRuleContexts(Strict_ilistContext.class);
		}
		public Strict_ilistContext strict_ilist(int i) {
			return getRuleContext(Strict_ilistContext.class,i);
		}
		public IfElseConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseConditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterIfElseConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitIfElseConditional(this);
		}
	}

	public final IfElseConditionalContext ifElseConditional() throws RecognitionException {
		IfElseConditionalContext _localctx = new IfElseConditionalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifElseConditional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__0);
			setState(93);
			condition(0);
			setState(94);
			match(T__1);
			setState(95);
			strict_ilist();
			setState(96);
			match(T__2);
			setState(97);
			match(T__3);
			setState(98);
			match(T__1);
			setState(99);
			strict_ilist();
			setState(100);
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

	public static class LoopContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Strict_ilistContext strict_ilist() {
			return getRuleContext(Strict_ilistContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__4);
			setState(103);
			value();
			setState(104);
			match(T__1);
			setState(105);
			strict_ilist();
			setState(106);
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

	public static class GotoCommandContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GotoCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterGotoCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitGotoCommand(this);
		}
	}

	public final GotoCommandContext gotoCommand() throws RecognitionException {
		GotoCommandContext _localctx = new GotoCommandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_gotoCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__5);
			setState(109);
			match(T__6);
			setState(110);
			expression(0);
			setState(111);
			match(T__7);
			setState(112);
			expression(0);
			setState(113);
			match(T__8);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(TLANGParser.VAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(VAR);
			setState(116);
			match(T__9);
			setState(117);
			expression(0);
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

	public static class MoveCommandContext extends ParserRuleContext {
		public MoveOpContext moveOp() {
			return getRuleContext(MoveOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MoveCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterMoveCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitMoveCommand(this);
		}
	}

	public final MoveCommandContext moveCommand() throws RecognitionException {
		MoveCommandContext _localctx = new MoveCommandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_moveCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			moveOp();
			setState(120);
			expression(0);
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

	public static class MoveOpContext extends ParserRuleContext {
		public MoveOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moveOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterMoveOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitMoveOp(this);
		}
	}

	public final MoveOpContext moveOp() throws RecognitionException {
		MoveOpContext _localctx = new MoveOpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_moveOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
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

	public static class PenCommandContext extends ParserRuleContext {
		public PenCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_penCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterPenCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitPenCommand(this);
		}
	}

	public final PenCommandContext penCommand() throws RecognitionException {
		PenCommandContext _localctx = new PenCommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_penCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
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

	public static class PauseCommandContext extends ParserRuleContext {
		public PauseCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pauseCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterPauseCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitPauseCommand(this);
		}
	}

	public final PauseCommandContext pauseCommand() throws RecognitionException {
		PauseCommandContext _localctx = new PauseCommandContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pauseCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__16);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryExprContext extends ExpressionContext {
		public UnaryArithOpContext unaryArithOp() {
			return getRuleContext(UnaryArithOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitUnaryExpr(this);
		}
	}
	public static class ValueExprContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitValueExpr(this);
		}
	}
	public static class AddExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public AddExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitAddExpr(this);
		}
	}
	public static class FunctionCallExprContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitFunctionCallExpr(this);
		}
	}
	public static class MulExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public MulExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitMulExpr(this);
		}
	}
	public static class ParenExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitParenExpr(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				unaryArithOp();
				setState(130);
				expression(6);
				}
				break;
			case NAME:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				functionCall();
				}
				break;
			case NUM:
			case VAR:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				value();
				}
				break;
			case T__6:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(T__6);
				setState(135);
				expression(0);
				setState(136);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MulExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(141);
						multiplicative();
						setState(142);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(145);
						additive();
						setState(146);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(TLANGParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(TLANGParser.DIV, 0); }
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitMultiplicative(this);
		}
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multiplicative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
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

	public static class AdditiveContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(TLANGParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TLANGParser.MINUS, 0); }
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitAdditive(this);
		}
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_additive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	public static class UnaryArithOpContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(TLANGParser.MINUS, 0); }
		public UnaryArithOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryArithOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterUnaryArithOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitUnaryArithOp(this);
		}
	}

	public final UnaryArithOpContext unaryArithOp() throws RecognitionException {
		UnaryArithOpContext _localctx = new UnaryArithOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unaryArithOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(MINUS);
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

	public static class ProcedureDeclarationContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TLANGParser.NAME, 0); }
		public Strict_ilistContext strict_ilist() {
			return getRuleContext(Strict_ilistContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ProcedureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterProcedureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitProcedureDeclaration(this);
		}
	}

	public final ProcedureDeclarationContext procedureDeclaration() throws RecognitionException {
		ProcedureDeclarationContext _localctx = new ProcedureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_procedureDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__17);
			setState(160);
			match(NAME);
			setState(161);
			match(T__6);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(162);
				paramList();
				}
			}

			setState(165);
			match(T__8);
			setState(166);
			match(T__1);
			setState(167);
			strict_ilist();
			setState(168);
			match(T__2);
			setState(169);
			match(T__18);
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

	public static class ParamListContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(TLANGParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(TLANGParser.VAR, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(VAR);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(172);
				match(T__7);
				setState(173);
				match(VAR);
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ProcedureCallContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TLANGParser.NAME, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ProcedureCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterProcedureCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitProcedureCall(this);
		}
	}

	public final ProcedureCallContext procedureCall() throws RecognitionException {
		ProcedureCallContext _localctx = new ProcedureCallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_procedureCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(NAME);
			setState(180);
			match(T__6);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << MINUS) | (1L << NUM) | (1L << VAR) | (1L << NAME))) != 0)) {
				{
				setState(181);
				argList();
				}
			}

			setState(184);
			match(T__8);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TLANGParser.NAME, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(NAME);
			setState(187);
			match(T__6);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << MINUS) | (1L << NUM) | (1L << VAR) | (1L << NAME))) != 0)) {
				{
				setState(188);
				argList();
				}
			}

			setState(191);
			match(T__8);
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

	public static class ArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			expression(0);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(194);
				match(T__7);
				setState(195);
				expression(0);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__19);
			setState(202);
			expression(0);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(TLANGParser.NOT, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinCondOpContext binCondOp() {
			return getRuleContext(BinCondOpContext.class,0);
		}
		public TerminalNode PENCOND() { return getToken(TLANGParser.PENCOND, 0); }
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(205);
				match(NOT);
				setState(206);
				condition(5);
				}
				break;
			case 2:
				{
				setState(207);
				expression(0);
				setState(208);
				binCondOp();
				setState(209);
				expression(0);
				}
				break;
			case 3:
				{
				setState(211);
				match(PENCOND);
				}
				break;
			case 4:
				{
				setState(212);
				match(T__6);
				setState(213);
				condition(0);
				setState(214);
				match(T__8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(218);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(219);
					logicOp();
					setState(220);
					condition(4);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BinCondOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(TLANGParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(TLANGParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(TLANGParser.LT, 0); }
		public TerminalNode GT() { return getToken(TLANGParser.GT, 0); }
		public TerminalNode LTE() { return getToken(TLANGParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(TLANGParser.GTE, 0); }
		public BinCondOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binCondOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterBinCondOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitBinCondOp(this);
		}
	}

	public final BinCondOpContext binCondOp() throws RecognitionException {
		BinCondOpContext _localctx = new BinCondOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_binCondOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << EQ) | (1L << NEQ) | (1L << LTE) | (1L << GTE))) != 0)) ) {
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

	public static class LogicOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(TLANGParser.AND, 0); }
		public TerminalNode OR() { return getToken(TLANGParser.OR, 0); }
		public LogicOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterLogicOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitLogicOp(this);
		}
	}

	public final LogicOpContext logicOp() throws RecognitionException {
		LogicOpContext _localctx = new LogicOpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_logicOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(TLANGParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(TLANGParser.VAR, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLANGListener ) ((TLANGListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==VAR) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 24:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00ec\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\3\7\3?\n\3\f\3"+
		"\16\3B\13\3\3\4\6\4E\n\4\r\4\16\4F\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5S\n\5\3\6\3\6\5\6W\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u008d\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0097\n\20\f\20\16\20\u009a\13\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00a6\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u00b1\n\25\f\25\16\25\u00b4"+
		"\13\25\3\26\3\26\3\26\5\26\u00b9\n\26\3\26\3\26\3\27\3\27\3\27\5\27\u00c0"+
		"\n\27\3\27\3\27\3\30\3\30\3\30\7\30\u00c7\n\30\f\30\16\30\u00ca\13\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u00db\n\32\3\32\3\32\3\32\3\32\7\32\u00e1\n\32\f\32\16\32\u00e4"+
		"\13\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\2\4\36\62\36\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\t\3\2\r\20\3\2\21\22"+
		"\3\2\31\32\3\2\27\30\3\2\34!\3\2\"#\3\2%&\2\u00e9\2:\3\2\2\2\4@\3\2\2"+
		"\2\6D\3\2\2\2\bR\3\2\2\2\nV\3\2\2\2\fX\3\2\2\2\16^\3\2\2\2\20h\3\2\2\2"+
		"\22n\3\2\2\2\24u\3\2\2\2\26y\3\2\2\2\30|\3\2\2\2\32~\3\2\2\2\34\u0080"+
		"\3\2\2\2\36\u008c\3\2\2\2 \u009b\3\2\2\2\"\u009d\3\2\2\2$\u009f\3\2\2"+
		"\2&\u00a1\3\2\2\2(\u00ad\3\2\2\2*\u00b5\3\2\2\2,\u00bc\3\2\2\2.\u00c3"+
		"\3\2\2\2\60\u00cb\3\2\2\2\62\u00da\3\2\2\2\64\u00e5\3\2\2\2\66\u00e7\3"+
		"\2\2\28\u00e9\3\2\2\2:;\5\4\3\2;<\7\2\2\3<\3\3\2\2\2=?\5\b\5\2>=\3\2\2"+
		"\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\5\3\2\2\2B@\3\2\2\2CE\5\b\5\2DC\3\2"+
		"\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\7\3\2\2\2HS\5\24\13\2IS\5\n\6\2JS"+
		"\5\20\t\2KS\5&\24\2LS\5*\26\2MS\5\60\31\2NS\5\26\f\2OS\5\32\16\2PS\5\22"+
		"\n\2QS\5\34\17\2RH\3\2\2\2RI\3\2\2\2RJ\3\2\2\2RK\3\2\2\2RL\3\2\2\2RM\3"+
		"\2\2\2RN\3\2\2\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\t\3\2\2\2TW\5\f\7\2UW"+
		"\5\16\b\2VT\3\2\2\2VU\3\2\2\2W\13\3\2\2\2XY\7\3\2\2YZ\5\62\32\2Z[\7\4"+
		"\2\2[\\\5\6\4\2\\]\7\5\2\2]\r\3\2\2\2^_\7\3\2\2_`\5\62\32\2`a\7\4\2\2"+
		"ab\5\6\4\2bc\7\5\2\2cd\7\6\2\2de\7\4\2\2ef\5\6\4\2fg\7\5\2\2g\17\3\2\2"+
		"\2hi\7\7\2\2ij\58\35\2jk\7\4\2\2kl\5\6\4\2lm\7\5\2\2m\21\3\2\2\2no\7\b"+
		"\2\2op\7\t\2\2pq\5\36\20\2qr\7\n\2\2rs\5\36\20\2st\7\13\2\2t\23\3\2\2"+
		"\2uv\7&\2\2vw\7\f\2\2wx\5\36\20\2x\25\3\2\2\2yz\5\30\r\2z{\5\36\20\2{"+
		"\27\3\2\2\2|}\t\2\2\2}\31\3\2\2\2~\177\t\3\2\2\177\33\3\2\2\2\u0080\u0081"+
		"\7\23\2\2\u0081\35\3\2\2\2\u0082\u0083\b\20\1\2\u0083\u0084\5$\23\2\u0084"+
		"\u0085\5\36\20\b\u0085\u008d\3\2\2\2\u0086\u008d\5,\27\2\u0087\u008d\5"+
		"8\35\2\u0088\u0089\7\t\2\2\u0089\u008a\5\36\20\2\u008a\u008b\7\13\2\2"+
		"\u008b\u008d\3\2\2\2\u008c\u0082\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0087"+
		"\3\2\2\2\u008c\u0088\3\2\2\2\u008d\u0098\3\2\2\2\u008e\u008f\f\7\2\2\u008f"+
		"\u0090\5 \21\2\u0090\u0091\5\36\20\b\u0091\u0097\3\2\2\2\u0092\u0093\f"+
		"\6\2\2\u0093\u0094\5\"\22\2\u0094\u0095\5\36\20\7\u0095\u0097\3\2\2\2"+
		"\u0096\u008e\3\2\2\2\u0096\u0092\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\37\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\t\4\2\2\u009c!\3\2\2\2\u009d\u009e\t\5\2\2\u009e#\3\2\2\2\u009f"+
		"\u00a0\7\30\2\2\u00a0%\3\2\2\2\u00a1\u00a2\7\24\2\2\u00a2\u00a3\7\'\2"+
		"\2\u00a3\u00a5\7\t\2\2\u00a4\u00a6\5(\25\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\13\2\2\u00a8\u00a9\7\4\2\2"+
		"\u00a9\u00aa\5\6\4\2\u00aa\u00ab\7\5\2\2\u00ab\u00ac\7\25\2\2\u00ac\'"+
		"\3\2\2\2\u00ad\u00b2\7&\2\2\u00ae\u00af\7\n\2\2\u00af\u00b1\7&\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3)\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\'\2\2\u00b6\u00b8"+
		"\7\t\2\2\u00b7\u00b9\5.\30\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\7\13\2\2\u00bb+\3\2\2\2\u00bc\u00bd\7\'\2\2"+
		"\u00bd\u00bf\7\t\2\2\u00be\u00c0\5.\30\2\u00bf\u00be\3\2\2\2\u00bf\u00c0"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\13\2\2\u00c2-\3\2\2\2\u00c3"+
		"\u00c8\5\36\20\2\u00c4\u00c5\7\n\2\2\u00c5\u00c7\5\36\20\2\u00c6\u00c4"+
		"\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"/\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7\26\2\2\u00cc\u00cd\5\36\20"+
		"\2\u00cd\61\3\2\2\2\u00ce\u00cf\b\32\1\2\u00cf\u00d0\7$\2\2\u00d0\u00db"+
		"\5\62\32\7\u00d1\u00d2\5\36\20\2\u00d2\u00d3\5\64\33\2\u00d3\u00d4\5\36"+
		"\20\2\u00d4\u00db\3\2\2\2\u00d5\u00db\7\33\2\2\u00d6\u00d7\7\t\2\2\u00d7"+
		"\u00d8\5\62\32\2\u00d8\u00d9\7\13\2\2\u00d9\u00db\3\2\2\2\u00da\u00ce"+
		"\3\2\2\2\u00da\u00d1\3\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00db"+
		"\u00e2\3\2\2\2\u00dc\u00dd\f\5\2\2\u00dd\u00de\5\66\34\2\u00de\u00df\5"+
		"\62\32\6\u00df\u00e1\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\63\3\2\2\2\u00e4\u00e2\3\2\2"+
		"\2\u00e5\u00e6\t\6\2\2\u00e6\65\3\2\2\2\u00e7\u00e8\t\7\2\2\u00e8\67\3"+
		"\2\2\2\u00e9\u00ea\t\b\2\2\u00ea9\3\2\2\2\20@FRV\u008c\u0096\u0098\u00a5"+
		"\u00b2\u00b8\u00bf\u00c8\u00da\u00e2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}