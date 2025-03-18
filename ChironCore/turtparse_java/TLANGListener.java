// Generated from TLANG.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TLANGParser}.
 */
public interface TLANGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TLANGParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(TLANGParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(TLANGParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#instruction_list}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_list(TLANGParser.Instruction_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#instruction_list}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_list(TLANGParser.Instruction_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#strict_ilist}.
	 * @param ctx the parse tree
	 */
	void enterStrict_ilist(TLANGParser.Strict_ilistContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#strict_ilist}.
	 * @param ctx the parse tree
	 */
	void exitStrict_ilist(TLANGParser.Strict_ilistContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(TLANGParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(TLANGParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(TLANGParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(TLANGParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#ifConditional}.
	 * @param ctx the parse tree
	 */
	void enterIfConditional(TLANGParser.IfConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#ifConditional}.
	 * @param ctx the parse tree
	 */
	void exitIfConditional(TLANGParser.IfConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#ifElseConditional}.
	 * @param ctx the parse tree
	 */
	void enterIfElseConditional(TLANGParser.IfElseConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#ifElseConditional}.
	 * @param ctx the parse tree
	 */
	void exitIfElseConditional(TLANGParser.IfElseConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(TLANGParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(TLANGParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#gotoCommand}.
	 * @param ctx the parse tree
	 */
	void enterGotoCommand(TLANGParser.GotoCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#gotoCommand}.
	 * @param ctx the parse tree
	 */
	void exitGotoCommand(TLANGParser.GotoCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TLANGParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TLANGParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#moveCommand}.
	 * @param ctx the parse tree
	 */
	void enterMoveCommand(TLANGParser.MoveCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#moveCommand}.
	 * @param ctx the parse tree
	 */
	void exitMoveCommand(TLANGParser.MoveCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#moveOp}.
	 * @param ctx the parse tree
	 */
	void enterMoveOp(TLANGParser.MoveOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#moveOp}.
	 * @param ctx the parse tree
	 */
	void exitMoveOp(TLANGParser.MoveOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#penCommand}.
	 * @param ctx the parse tree
	 */
	void enterPenCommand(TLANGParser.PenCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#penCommand}.
	 * @param ctx the parse tree
	 */
	void exitPenCommand(TLANGParser.PenCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#pauseCommand}.
	 * @param ctx the parse tree
	 */
	void enterPauseCommand(TLANGParser.PauseCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#pauseCommand}.
	 * @param ctx the parse tree
	 */
	void exitPauseCommand(TLANGParser.PauseCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(TLANGParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(TLANGParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(TLANGParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(TLANGParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(TLANGParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(TLANGParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(TLANGParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(TLANGParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(TLANGParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(TLANGParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(TLANGParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link TLANGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(TLANGParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(TLANGParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(TLANGParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(TLANGParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(TLANGParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#unaryArithOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryArithOp(TLANGParser.UnaryArithOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#unaryArithOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryArithOp(TLANGParser.UnaryArithOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(TLANGParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(TLANGParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(TLANGParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(TLANGParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCall(TLANGParser.ProcedureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCall(TLANGParser.ProcedureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(TLANGParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(TLANGParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(TLANGParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(TLANGParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(TLANGParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(TLANGParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(TLANGParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(TLANGParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#binCondOp}.
	 * @param ctx the parse tree
	 */
	void enterBinCondOp(TLANGParser.BinCondOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#binCondOp}.
	 * @param ctx the parse tree
	 */
	void exitBinCondOp(TLANGParser.BinCondOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(TLANGParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(TLANGParser.LogicOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(TLANGParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLANGParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(TLANGParser.ValueContext ctx);
}