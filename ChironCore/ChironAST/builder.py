#!/usr/bin/python3
# -*- coding: utf-8 -*-
# ChironLang Abstract Syntax Tree Builder

import os
import sys
sys.path.insert(0, os.path.join("..", "turtparse"))

from turtparse.tlangParser import tlangParser
from turtparse.tlangVisitor import tlangVisitor

from ChironAST import ChironAST


class astGenPass(tlangVisitor):

    def __init__(self):
        self.repeatInstrCount = 0 # keeps count for no of 'repeat' instructions
        
        
    def visitStart(self, ctx:tlangParser.StartContext):
        print("visitStart called")
        stmtList = self.visit(ctx.instruction_list())
        print(f"visitStart returning statement list with {len(stmtList)} statements")
        return stmtList

    def visitInstruction_list(self, ctx: tlangParser.Instruction_listContext):
        print("visitInstruction_list called")
        instrList = []
        for i, instr in enumerate(ctx.instruction()):
            ctx_type = type(instr.getChild(0)).__name__ if instr.getChildCount() > 0 else "Unknown"
            print(f"Visiting instruction {i}, type: {instr.__class__.__name__}, text: {instr.getText()}, specific type: {ctx_type}")
            try:
                result = self.visit(instr)
                if result is None:
                    print(f"Warning: visit returned None for instruction {i}, specific type: {ctx_type}")
                else:
                    instrList.extend(result)
                    print(f"Added instruction, list now has {len(instrList)} items")
            except Exception as e:
                print(f"Error visiting instruction {i}: {e}")
                raise
        return instrList

    def visitStrict_ilist(self, ctx:tlangParser.Strict_ilistContext):
	# TODO: code refactoring. visitInstruction_list and visitStrict_ilist have same body
        instrList = []
        for instr in ctx.instruction():
            visvalue = self.visit(instr)
            instrList.extend(visvalue)

        return instrList

    def visitFunctionCall(self, ctx: tlangParser.FunctionCallContext):
        print(f"Visiting function call: {ctx.getText()}")
        name = str(ctx.NAME())
        args = []
        if ctx.argList():
            for expr in ctx.argList().expression():
                args.append(self.visit(expr))
        # Create function call node
        # Return appropriate AST node
        return [(ChironAST.ProcedureCall(name), 1)]

    def visitProcedureDeclaration(self, ctx: tlangParser.ProcedureDeclarationContext):
        print(f"Visiting procedure declaration: {ctx.NAME().getText()}")

        # Extract procedure name
        proc_name = ctx.NAME().getText()

        # Extract parameters if any
        params = []
        if ctx.paramList():
            for var in ctx.paramList().VAR():
                params.append(var.getText())

        print(f"  Procedure name: {proc_name}, params: {params}")

        # Create procedure node
        proc = ChironAST.Procedure(proc_name, params)

        # Visit body instructions
        print(f"  Visiting procedure body instructions")
        bodyInstrList = self.visit(ctx.strict_ilist())
        print(f" Body instructions count: {len(bodyInstrList)}")

        # Return instruction list with procedure declaration at start
        return [(proc, len(bodyInstrList) + 1)] + bodyInstrList

    def visitProcedureCall(self, ctx: tlangParser.ProcedureCallContext):
        """Visit a standalone procedure call"""
        # Extract procedure name
        proc_name = ctx.NAME().getText()

        # Create AST node for procedure call
        proc_call = ChironAST.ProcedureCall(proc_name)

        # If there are arguments, process them
        if ctx.argList():
            args = []
            for expr in ctx.argList().expression():
                args.append(self.visit(expr))
            proc_call.args = args

        return [(proc_call, 1)]  # Return as IR instruction with jump target 1

    def visitReturnStatement(self, ctx: tlangParser.ReturnStatementContext):
        print(f"Visiting return statement: {ctx.getText()}")
        expr = self.visit(ctx.expression())
        print(f"  Return expression: {expr}")
        return [(ChironAST.ProcedureRet(expr), 1)]
    # def visitFunction(self, ctx:tlangParser.FunctionContext):
    #
    #     arg0 = self.visit(ctx.VAR(0))
    #     arg1 = self.visit(ctx.VAR(1))
    #
    #     return [(ChironAST.Function(arg0, arg1), 1)]
        
        #if ctx.additive().PLUS():
            # return [(ChironAST.Function('+', arg0, arg1), 1)]
        #elif ctx.additive().MINUS():
            # return [(ChironAST.Function('-', arg0, arg1), 1)]


    def visitAssignment(self, ctx:tlangParser.AssignmentContext):
        lval = ChironAST.Var(ctx.VAR().getText())
        rval = self.visit(ctx.expression())
        return [(ChironAST.AssignmentCommand(lval, rval), 1)]


    def visitIfConditional(self, ctx:tlangParser.IfConditionalContext):
        condObj = ChironAST.ConditionCommand(self.visit(ctx.condition()))
        thenInstrList = self.visit(ctx.strict_ilist())
        return [(condObj, len(thenInstrList) + 1)] + thenInstrList

    def visitIfElseConditional(self, ctx:tlangParser.IfElseConditionalContext):
        condObj = ChironAST.ConditionCommand(self.visit(ctx.condition()))
        thenInstrList = self.visit(ctx.strict_ilist(0))
        elseInstrList = self.visit(ctx.strict_ilist(1))
        jumpOverElseBlock = [(ChironAST.ConditionCommand(ChironAST.BoolFalse()), len(elseInstrList) + 1)]
        return [(condObj, len(thenInstrList) + 2)] + thenInstrList + jumpOverElseBlock + elseInstrList

    def visitGotoCommand(self, ctx:tlangParser.GotoCommandContext):
        xcor = self.visit(ctx.expression(0))
        ycor = self.visit(ctx.expression(1))
        return [(ChironAST.GotoCommand(xcor, ycor), 1)]

    # Visit a parse tree produced by tlangParser#unaryExpr.
    def visitUnaryExpr(self, ctx:tlangParser.UnaryExprContext):
        expr1 = self.visit(ctx.expression())
        if ctx.unaryArithOp().MINUS():
            return ChironAST.UMinus(expr1)
        
        return self.visitChildren(ctx)


    # Visit a parse tree produced by tlangParser#addExpr.
    def visitAddExpr(self, ctx:tlangParser.AddExprContext):
        left = self.visit(ctx.expression(0))
        right = self.visit(ctx.expression(1))
        if ctx.additive().PLUS():
            return ChironAST.Sum(left, right)
        elif ctx.additive().MINUS():
            return ChironAST.Diff(left, right)


    # Visit a parse tree produced by tlangParser#mulExpr.
    def visitMulExpr(self, ctx:tlangParser.MulExprContext):
        left = self.visit(ctx.expression(0))
        right = self.visit(ctx.expression(1))
        if ctx.multiplicative().MUL():
            return ChironAST.Mult(left, right)
        elif ctx.multiplicative().DIV():
            return ChironAST.Div(left, right)


    # # Visit a parse tree produced by tlangParser#parenExpr.
    # def visitParenExpr(self, ctx:tlangParser.ParenExprContext):
    #     return self.visit(ctx.expression())
    #
    # def visitProcedureDeclaration(self, ctx:tlangParser.ProcedureDeclarationContext):
    #     proc_name = ChironAST.Procedure(ctx.NAME())
    #     InstrList = self.visit(ctx.strict_ilist())
    #     return [(proc_name, len(InstrList) + 1)] + InstrList
    #
    # def visitProcedureCall(self, ctx:tlangParser.ProcedureCallContext):
    #     proc_name = ChironAST.ProcedureCall(ctx.NAME())
    #
    #     return [(proc_name, 1)] #actually tgt = 1 is not requied,
    #                             #tgt will be found by handler from procedure table
    #
    # def visitRet(self, ctx:tlangParser.RetContext): #RetContext not needed
    #     ret_name = ChironAST.ProcedureRet(ctx.NAME())
    #
    #     return [(ret_name, 1)] #actually tgt = 1 is not requied,
    #                             #tgt will be found by handler from procedure table
    #
    def visitCondition(self, ctx:tlangParser.ConditionContext):
        if ctx.PENCOND():
            return ChironAST.PenStatus()

        if ctx.NOT():
            expr1 = self.visit(ctx.condition(0))
            return ChironAST.NOT(expr1)


        if ctx.logicOp():
            expr1 = self.visit(ctx.condition(0))
            expr2 = self.visit(ctx.condition(1))
            logicOpCtx = ctx.logicOp()

            if logicOpCtx.AND():
                return ChironAST.AND(expr1, expr2)
            elif logicOpCtx.OR():
                return ChironAST.OR(expr1, expr2)


        if ctx.binCondOp():
            expr1 = self.visit(ctx.expression(0))
            expr2 = self.visit(ctx.expression(1))
            binOpCtx = ctx.binCondOp()

            if binOpCtx.LT():
                return ChironAST.LT(expr1, expr2)
            elif binOpCtx.GT():
                return ChironAST.GT(expr1, expr2)
            elif binOpCtx.EQ():
                return ChironAST.EQ(expr1, expr2)
            elif binOpCtx.NEQ():
                return ChironAST.NEQ(expr1, expr2)
            elif binOpCtx.LTE():
                return ChironAST.LTE(expr1, expr2)
            elif binOpCtx.GTE():
                return ChironAST.GTE(expr1, expr2)

        if ctx.condition():
            # condition is inside paranthesis
            return self.visit(ctx.condition(0))

        return self.visitChildren(ctx)

    def visitValue(self, ctx:tlangParser.ValueContext):
        if ctx.NUM():
            return ChironAST.Num(ctx.NUM().getText())
        elif ctx.VAR():
            return ChironAST.Var(ctx.VAR().getText())

    def visitLoop(self, ctx:tlangParser.LoopContext):
        # insert counter variable in IR for tracking repeat count
        self.repeatInstrCount += 1
        repeatNum = self.visit(ctx.value())
        counterVar = ChironAST.Var(":__rep_counter_" + str(self.repeatInstrCount))
        counterVarInitInstr = ChironAST.AssignmentCommand(counterVar, repeatNum)
        constZero = ChironAST.Num(0)
        constOne = ChironAST.Num(1)
        loopCond = ChironAST.ConditionCommand(ChironAST.GT(counterVar, constZero))
        counterVarDecrInstr = ChironAST.AssignmentCommand(counterVar, ChironAST.Diff(counterVar, constOne))

        thenInstrList = []
        for instr in ctx.strict_ilist().instruction():
            temp = self.visit(instr)
            thenInstrList.extend(temp)

        boolFalse = ChironAST.ConditionCommand(ChironAST.BoolFalse())
        return [(counterVarInitInstr, 1), (loopCond, len(thenInstrList) + 3)] + thenInstrList +\
            [(counterVarDecrInstr, 1), (boolFalse, -len(thenInstrList) - 2)]

    def visitMoveCommand(self, ctx:tlangParser.MoveCommandContext):
        mvcommand = ctx.moveOp().getText()
        mvexpr = self.visit(ctx.expression())
        return [(ChironAST.MoveCommand(mvcommand, mvexpr), 1)]

    def visitPenCommand(self, ctx:tlangParser.PenCommandContext):
        return [(ChironAST.PenCommand(ctx.getText()), 1)]

    def visitFunctionCallExpr(self, ctx: tlangParser.FunctionCallExprContext):
        print("Visiting function call expression")
        func_call = ctx.functionCall()
        name = func_call.NAME().getText()

        # Create function call object
        func = ChironAST.FunctionCall(name)

        # Process arguments
        if func_call.argList():
            for expr in func_call.argList().expression():
                func.args.append(self.visit(expr))

        return func  # Return a FunctionCall object, not a list

    def visitPauseCommand(self, ctx:tlangParser.PauseCommandContext):
        return [(ChironAST.PauseCommand(), 1)]