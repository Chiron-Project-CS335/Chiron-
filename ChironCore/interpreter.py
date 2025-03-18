
from ChironAST import ChironAST
from ChironHooks import Chironhooks
import turtle

Release="Chiron v5.3"

def addContext(s):
    return str(s).strip().replace(":", "self.prg.")


class ActivationRecord:
    """Represents a function call's execution context"""

    def __init__(self, proc_name, return_address, params=None):
        self.proc_name = proc_name  # Procedure name
        self.return_address = return_address  # Return PC address
        self.local_vars = {}  # Local variables dictionary
        self.return_value = None  # Return value storage

        # Initialize with parameters if provided
        if params:
            for name, value in params.items():
                self.local_vars[name] = value

    def get_var(self, name):
        """Get a local variable value"""
        return self.local_vars.get(name)

    def set_var(self, name, value):
        """Set a local variable value"""
        self.local_vars[name] = value

    def __repr__(self):
        """String representation for debugging"""
        return f"ActivationRecord({self.proc_name}, ret={self.return_address}, vars={self.local_vars})"


class Interpreter:
    # Turtle program should not contain variable with names "ir", "pc", "t_screen"
    ir = None
    pc = None
    t_screen = None
    trtl = None

    def __init__(self, irHandler, params):
        self.ir = irHandler.ir
        self.cfg = irHandler.cfg
        self.pc = 0
        self.t_screen = turtle.getscreen()
        self.trtl = turtle.Turtle()
        self.trtl.shape("turtle")
        self.trtl.color("blue", "yellow")
        self.trtl.fillcolor("green")
        self.trtl.begin_fill()
        self.trtl.pensize(4)
        self.trtl.speed(1) # TODO: Make it user friendly

        self.procedureTable = {}  # Table to store procedure declarations for procedure call handler
        self.returnTable = {} #Table storing the return address

        if params is not None:
            self.args = params
        else:
            self.args = None

        turtle.title(Release)
        turtle.bgcolor("white")
        turtle.hideturtle()

    def handleAssignment(self, stmt,tgt):
        raise NotImplementedError('Assignments are not handled!')

    def handleCondition(self, stmt, tgt):
        raise NotImplementedError('Conditions are not handled!')

    def handleMove(self, stmt, tgt):
        raise NotImplementedError('Moves are not handled!')

    def handlePen(self, stmt, tgt):
        raise NotImplementedError('Pens are not handled!')

    def handleGotoCommand(self, stmt, tgt):
        raise NotImplementedError('Gotos are not handled!')

    def handleNoOpCommand(self, stmt, tgt):
        raise NotImplementedError('No-Ops are not handled!')

    def handlePauseCommand(self, stmt, tgt):
        raise NotImplementedError('No-Ops are not handled!')

    def sanityCheck(self, irInstr):
        stmt, tgt = irInstr
        # if not a condition command, rel. jump can't be anything but 1
        if not (isinstance(stmt, ChironAST.ConditionCommand) 
                | isinstance(stmt, ChironAST.Procedure)
                | isinstance(stmt, ChironAST.ProcedureCall)
                | isinstance(stmt, ChironAST.ProcedureRet)):
            if tgt != 1:
                raise ValueError("Improper relative jump for non-conditional instruction", str(stmt), tgt)
    
    def interpret(self):
        pass

    def initProgramContext(self, params):
        pass

class ProgramContext:
    pass

# TODO: move to a different file
class ConcreteInterpreter(Interpreter):
    # Ref: https://realpython.com/beginners-guide-python-turtle
    cond_eval = None # used as a temporary variable within the embedded program interpreter
    prg = None

    def __init__(self, irHandler, params):
        super().__init__(irHandler, params)
        self.prg = ProgramContext()
        # Hooks Object:
        if self.args is not None and self.args.hooks:
            self.chironhook = Chironhooks.ConcreteChironHooks()
        self.pc = 0

        self.procedureTable = {}
    def interpret(self):
        #print("Program counter : ", self.pc)
        stmt, tgt = self.ir[self.pc] #############
        print("Program counter : ", self.pc, stmt, stmt.__class__.__name__, tgt)

        self.sanityCheck(self.ir[self.pc])

        if isinstance(stmt, ChironAST.AssignmentCommand):
            ntgt = self.handleAssignment(stmt, tgt)
        elif isinstance(stmt, ChironAST.ConditionCommand):
            ntgt = self.handleCondition(stmt, tgt)
        elif isinstance(stmt, ChironAST.MoveCommand):
            ntgt = self.handleMove(stmt, tgt)
        elif isinstance(stmt, ChironAST.PenCommand):
            ntgt = self.handlePen(stmt, tgt)
        elif isinstance(stmt, ChironAST.GotoCommand):
            ntgt = self.handleGotoCommand(stmt, tgt)
        elif isinstance(stmt, ChironAST.NoOpCommand):
            ntgt = self.handleNoOpCommand(stmt, tgt)
        elif isinstance(stmt, ChironAST.FunctionCall):
            ntgt = self.handleFunctionCall(stmt, tgt)


        elif isinstance(stmt, ChironAST.Procedure):
            ntgt = self.handleProcedureDec(stmt, tgt)
        elif isinstance(stmt, ChironAST.ProcedureCall):
            ntgt = self.handleProcedureCall(stmt)
        elif isinstance(stmt, ChironAST.ProcedureRet):
            ntgt = self.handleProcedureRet(stmt)
        else:
            raise NotImplementedError("Unknown instruction: %s, %s."%(type(stmt), stmt))

        print('ntgt :', ntgt)
        # TODO: handle statement
        self.pc += ntgt

        if self.pc >= len(self.ir):
            # This is the ending of the interpreter.
            self.trtl.write("End, Press ESC", font=("Arial", 15, "bold"))
            if self.args is not None and self.args.hooks:
                self.chironhook.ChironEndHook(self)
            return True
        else:
            return False
    
    def initProgramContext(self, params):
        # This is the starting of the interpreter at setup stage.
        if self.args is not None and self.args.hooks:
            self.chironhook.ChironStartHook(self)
        self.trtl.write("Start", font=("Arial", 15, "bold"))
        for key,val in params.items():
            var = key.replace(":","")
            exec("setattr(self.prg,\"%s\",%s)" % (var, val))
    
    def handleAssignment(self, stmt, tgt):
        print("  Assignment Statement")
        lhs = str(stmt.lvar).replace(":","")
        rhs = addContext(stmt.rexpr)
        exec("setattr(self.prg,\"%s\",%s)" % (lhs,rhs))
        return 1

    def handleCondition(self, stmt, tgt):
        print("  Branch Instruction")
        condstr = addContext(stmt)
        exec("self.cond_eval = %s" % (condstr))
        return 1 if self.cond_eval else tgt

    def handleMove(self, stmt, tgt):
        print("  MoveCommand")
        exec("self.trtl.%s(%s)" % (stmt.direction,addContext(stmt.expr)))
        return 1

    def handleNoOpCommand(self, stmt, tgt):
        print("  No-Op Command")
        return 1

    def handlePen(self, stmt, tgt):
        print("  PenCommand")
        exec("self.trtl.%s()"%(stmt.status))
        return 1

    def handleGotoCommand(self, stmt, tgt):
        print(" GotoCommand")
        xcor = addContext(stmt.xcor)
        ycor = addContext(stmt.ycor)
        exec("self.trtl.goto(%s, %s)" % (xcor, ycor))
        return 1

    def get_variable(self, name):
        """Get variable value respecting scope chain"""
        # Remove ':' prefix if present
        if name.startswith(':'):
            name = name[1:]

        # First check local scope (current activation record)
        if self.call_stack:
            current_ar = self.call_stack[-1]
            local_value = current_ar.get_var(name)
            if local_value is not None:
                return local_value

        # Fall back to global scope
        return getattr(self.prg, name, None)

    def set_variable(self, name, value):
        """Set variable value respecting scope chain"""
        # Remove ':' prefix if present
        if name.startswith(':'):
            name = name[1:]

        # If inside a function, set in local scope
        if self.call_stack:
            current_ar = self.call_stack[-1]
            current_ar.set_var(name, value)
        else:
            # Set in global scope
            setattr(self.prg, name, value)

    def handleFunctionCall(self, stmt, tgt):
        print(" Function Call Expression")
        # This is similar to handleProcedureCall but returns a value
        func_name = stmt.name

        # Evaluate arguments
        args = []
        for arg in stmt.args:
            args.append(self.evaluate_expression(arg))

        # Get procedure info
        if func_name not in self.procedureTable:
            raise ValueError(f"Function {func_name} not defined")

        proc_info = self.procedureTable[func_name]
        start_pc = proc_info[0]
        param_names = proc_info[2] if len(proc_info) > 2 else []

        # Match arguments to parameters
        params = {}
        for i, param_name in enumerate(param_names):
            if i < len(args):
                clean_name = param_name[1:] if param_name.startswith(':') else param_name
                params[clean_name] = args[i]

        # Create and push activation record
        return_addr = self.pc + 1
        activation_record = ActivationRecord(func_name, return_addr, params)
        self.call_stack.append(activation_record)

        # Execute the function
        self.procedureTable[func_name][1] = return_addr

        # Calculate jump target
        return start_pc - self.pc

    def handleProcedureDec(self, stmt, tgt):
        #print(" Procedure Declaration")
        #return pc will be defined in procedure_call

        stmt = str(stmt).replace("procedure ", "")
        print(stmt)
        self.procedureTable[stmt] = [0, 0]

        proc_pc = self.pc + 1
        self.procedureTable[stmt][0] = proc_pc

        #print(stmt, ' ', self.procedureTable[stmt][0])
        return tgt

    def evaluate_expression(self, expr):
        """Evaluate an expression with proper variable scoping"""
        # If the expression is a FunctionCall object, evaluate it
        if isinstance(expr, ChironAST.FunctionCall):
            func_name = expr.name

            # Evaluate arguments
            args = []
            for arg in expr.args:
                args.append(self.evaluate_expression(arg))

            # Create parameter map
            params = {}
            if func_name in self.procedureTable:
                param_names = self.procedureTable[func_name][2]
                for i, param_name in enumerate(param_names):
                    if i < len(args):
                        clean_name = param_name[1:] if param_name.startswith(':') else param_name
                        params[clean_name] = args[i]

            # Save current PC
            current_pc = self.pc
            return_addr = current_pc + 1

            # Create and push activation record
            activation_record = ActivationRecord(func_name, return_addr, params)
            self.call_stack.append(activation_record)

            # Jump to function start
            start_pc = self.procedureTable[func_name][0]
            self.pc = start_pc - 1  # Will be incremented in next interpret() call

            # Execute function until it returns
            while self.call_stack and self.call_stack[-1].proc_name == func_name:
                if self.interpret():  # Program ended
                    break

            # Restore PC
            self.pc = current_pc

            # Return the function's result
            return_value = self.get_variable("_return_value")
            return return_value

        # The rest of your existing evaluate_expression code for handling strings, etc.
        # ...

    def handleProcedureCall(self, stmt):
        #print(" Procedure Call")

        stmt = str(stmt).replace("procedure call ", "") # target is the called proc's pc, search in table
        #print(stmt)
        pc = self.pc
        absoluteTgt = self.procedureTable[stmt][0]
        tgt = absoluteTgt - pc

        retaddr = pc+1
        self.procedureTable[stmt][1] = retaddr

        return tgt
    
    def handleProcedureRet(self, stmt):
        #print(" Return from Procedure")
        
        stmt = str(stmt).replace("returning from ", "")
        #print(stmt)
        pc = self.pc
        retaddr = self.procedureTable[stmt][1]
        tgt = retaddr - pc
        

        return tgt
    
    