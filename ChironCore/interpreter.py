
from ChironAST import ChironAST
from ChironHooks import Chironhooks
import turtle
import re
Release="Chiron v5.3"

def addContext(s):
    return str(s).strip().replace(":", "self.prg.")
class ActivationRecord:
    """Represents a function call's execution context"""
    def __init__(self, proc_name, return_address, params=None):
        self.proc_name = proc_name  # Procedure name
        self.return_address = return_address  # Return PC address
        self.local_vars = {}  # Local variables dictionary
        self.return_value = None  # Explicitly store return value here
        # Initialize with parameters if provided by default i is one
        if params:
            for name, value in params.items():
                print(f"{name} : {value}")
                self.local_vars[name] = value

    def get_var(self, name):
        """Get a local variable value"""
        return self.local_vars.get(name)

    def set_var(self, name, value):
        """Set a local variable value"""
        self.local_vars[name] = value

    def set_return_value(self, value):
        """Store the return value"""
        self.return_value = value

    def get_return_value(self):
        """Get the stored return value"""
        return self.return_value

    def clear_return_value(self):
        """Clear the return value after use"""
        # This is just so that we are absolutely correct, and do not use stray return values in the future by mistake
        # and can help in debugging
        self.return_value = None


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
        self.call_stack = []
        # Hooks Object:
        if self.args is not None and self.args.hooks:
            self.chironhook = Chironhooks.ConcreteChironHooks()
        self.pc = 0

        self.procedureTable = {}
    def interpret(self):
        #print("Program counter : ", self.pc)
        # Check if we're about to execute outside procedure boundaries
        if self.call_stack and self.call_stack[-1].return_value is None:
            current_activation = self.call_stack[-1]
            proc_name = current_activation.proc_name

            if proc_name in self.procedureTable:
                proc_info = self.procedureTable[proc_name]
                if len(proc_info) >= 4:
                    start_pc, _, _, end_pc = proc_info

                    # If we're about to execute past the end of the procedure
                    if self.pc < start_pc or self.pc >= end_pc:
                        print(f"Implicit return from {proc_name} (end of procedure reached)")
                        return_addr = current_activation.return_address
                        # self.call_stack.pop()

                        # Jump to return address
                        self.pc = return_addr
                        return False  # Continue execution
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
        # Clear existing state
        self.call_stack = []
        self.temp_return_value = None  # Add temporary storage for return values

        # Create a main program activation record
        main_ar = ActivationRecord("main", 0, {})
        self.call_stack.append(main_ar)
        print(f"Created main program context for globals and return values")
        for key, val in params.items():
            var = key.replace(":", "")
            # Use set_variable instead of direct exec
            self.set_variable(var, val)

    def handleAssignment(self, stmt, tgt):
        print(" Assignment Statement")
        lhs = str(stmt.lvar)  # Keep the original format, including ':' if present
        if not lhs.startswith(':'):
            raise RuntimeError(f"Assignment to not a variable: {lhs}")
        # Check if right side is a FunctionCall
        print(f"LHS: {lhs}")
        if isinstance(stmt.rexpr, ChironAST.FunctionCall):
            proc_name = stmt.rexpr.name
            print(f"RHS EVALUATION STARTS {stmt.rexpr} for Function {proc_name}")
            rhs_value = self.evaluate_expression(stmt.rexpr)
            print(f"RHS EVALUATION COMPLETE: {rhs_value} for Function {proc_name}")
            if rhs_value is None:
                raise RuntimeError(
                    f"Runtime Error: Function {proc_name} does not return a value but assignment was attempted")
        else:
            rhs_value = self.evaluate_expression(stmt.rexpr)
            print(f"RHS EVALUATION COMPLETE: {rhs_value} for Function {self.call_stack[-1].proc_name}")

        # Set variable using our scoping mechanism
        self.set_variable(lhs, rhs_value)
        return 1

    def handleCondition(self, stmt, tgt):
        print(" Branch Instruction")
        condstr = str(stmt)
        print(condstr)

        # Evaluate the condition directly as an AST node
        self.cond_eval = self.evaluate_expression(stmt.cond)
        print(f"condition eval : {self.cond_eval}")
        # Calculate absolute target PC
        next_pc = self.pc + (1 if self.cond_eval else tgt)

        # Validate the jump target
        validated_pc = self.validate_jump(next_pc)

        # Return relative jump
        return validated_pc - self.pc

    def handleMove(self, stmt, tgt):
        print(" MoveCommand")

        # Get the direction (forward/backward/etc.)
        direction = stmt.direction

        # Evaluate the expression for the distance/angle
        expr_value = self.evaluate_expression(str(stmt.expr))

        # Execute the turtle command
        if direction == "forward":
            self.trtl.forward(expr_value)
        elif direction == "backward":
            self.trtl.backward(expr_value)
        elif direction == "right":
            self.trtl.right(expr_value)
        elif direction == "left":
            self.trtl.left(expr_value)
        else:
            exec(f"self.trtl.{direction}({expr_value})")

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
            print(f"Checking variable in  {current_ar.proc_name}")
            local_value = current_ar.get_var(name)
            if local_value is not None:
                print(f"Variable {name} has value {local_value}")
                return local_value

        # Fall back to global scope
        print(f"Returning {name} as {getattr(self.prg, name,None)}")
        return getattr(self.prg, name,None)

    def set_variable(self, name, value):
        """Set variable value respecting scope chain"""
        # Remove ':' prefix if present
        if name.startswith(':'):
            name = name[1:]

        # If inside a function, set in local scope
        if self.call_stack[-1].proc_name != "main":
            current_ar = self.call_stack[-1]
            current_ar.set_var(name, value)
        else:
            # Set in global scope
            setattr(self.prg, name, value)

    def validate_jump(self, target_pc):
        """Validates jump targets for both global scope and procedure boundaries"""

        # First check if target is within program bounds
        if target_pc < 0 or target_pc >= len(self.ir):
            print(f"Warning: Jump target {target_pc} is out of program bounds (0-{len(self.ir) - 1})")
            # Return end of program to force termination
            return len(self.ir) - 1

        # If in procedure context, check procedure boundaries
        if self.call_stack:
            current_activation = self.call_stack[-1]
            proc_name = current_activation.proc_name

            if proc_name in self.procedureTable:
                proc_info = self.procedureTable[proc_name]
                # Check if we have boundary information
                if len(proc_info) >= 4:
                    start_pc, _, _, end_pc = proc_info

                    # If jump would exit procedure boundaries
                    if target_pc < start_pc or target_pc >= end_pc:
                        print(f"Jump would exit procedure {proc_name} boundaries")
                        # Handle as implicit return
                        return_addr = current_activation.return_address
                        # self.call_stack.pop() #Think about it
                        return return_addr

        return target_pc

    def handleFunctionCall(self, stmt, tgt):
        print(" Function Call Expression")
        # This is similar to handleProcedureCall but returns a value
        func_name = stmt.name
        print(stmt.args)
        # Evaluate arguments
        args = []
        for arg in stmt.args:
            arg_value = self.evaluate_expression(arg)
            print(f"argument is {arg_value}")
            args.append(arg_value)

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
        print(" Procedure Declaration")
        full_stmt = str(stmt).replace("procedure ", "")

        # Extract procedure name
        if "(" in full_stmt:
            proc_name = full_stmt.split("(")[0].strip()
        else:
            proc_name = full_stmt.strip()

        # Extract parameters
        params = []
        if "(" in full_stmt and ")" in full_stmt:
            param_section = full_stmt.split("(")[1].split(")")[0].strip()
            if param_section:
                params = [p.strip() for p in param_section.split(",")]

        # Store procedure info: [start_pc, return_addr, param_list, end_pc]
        proc_pc = self.pc + 1
        end_pc = self.pc + tgt  # Important: calculate end boundary

        self.procedureTable[proc_name] = [proc_pc, 0, params, end_pc]
        print(f"Declared procedure: {proc_name} with params: {params}, bounds: [{proc_pc}, {end_pc}]")

        return tgt

    def evaluate_expression(self, expr):
        """Evaluate an expression with proper variable scoping"""
        if isinstance(expr, ChironAST.ArithExpr):
            if isinstance(expr, ChironAST.BinArithOp):
                print("Getting left variable")
                left_val = self.evaluate_expression(expr.lexpr)
                print(f"Left value: {left_val}")
                print("Getting right variable")
                right_val = self.evaluate_expression(expr.rexpr)
                print(f"Right Value: {right_val}")
                if isinstance(expr, ChironAST.Sum):
                    return left_val + right_val
                elif isinstance(expr, ChironAST.Diff):
                    return left_val - right_val
                elif isinstance(expr, ChironAST.Mult):
                    return left_val * right_val
                elif isinstance(expr, ChironAST.Div):
                    if right_val == 0:
                        raise ValueError("Division by zero")
                    return left_val / right_val

                # Handle unary arithmetic operations
            elif isinstance(expr, ChironAST.UnaryArithOp):
                val = self.evaluate_expression(expr.expr)

                if isinstance(expr, ChironAST.UMinus):
                    return -val

            # Handle AST nodes for boolean operations
        elif isinstance(expr, ChironAST.BinCondOp):
            left_val = self.evaluate_expression(expr.lexpr)
            right_val = self.evaluate_expression(expr.rexpr)

            if isinstance(expr, ChironAST.LT):
                return left_val < right_val
            elif isinstance(expr, ChironAST.GT):
                return left_val > right_val
            elif isinstance(expr, ChironAST.LTE):
                return left_val <= right_val
            elif isinstance(expr, ChironAST.GTE):
                return left_val >= right_val
            elif isinstance(expr, ChironAST.EQ):
                return left_val == right_val
            elif isinstance(expr, ChironAST.NEQ):
                return left_val != right_val

            # Handle logical operations
        elif isinstance(expr, ChironAST.AND):
            return self.evaluate_expression(expr.lexpr) and self.evaluate_expression(expr.rexpr)
        elif isinstance(expr, ChironAST.OR):
            return self.evaluate_expression(expr.lexpr) or self.evaluate_expression(expr.rexpr)
        elif isinstance(expr, ChironAST.NOT):
            return not self.evaluate_expression(expr.expr)

            # Handle variables and numbers
        elif isinstance(expr, ChironAST.Var):
            return self.get_variable(expr.varname)
        elif isinstance(expr, ChironAST.Num):
            return expr.val

            # Handle boolean literals
        elif isinstance(expr, ChironAST.BoolTrue):
            return True
        elif isinstance(expr, ChironAST.BoolFalse):
            return False

            # Handle pen status
        elif isinstance(expr, ChironAST.PenStatus):
            return self.trtl.isdown()
        # If the expression is a FunctionCall object, evaluate it
        # If the expression is a FunctionCall object, evaluate it
        elif isinstance(expr, ChironAST.FunctionCall):
            print(f"Beginning to Evaluate Function Call of {expr.name}")
            func_name = expr.name

            # Evaluate arguments FIRST - This is critical
            args = []
            for arg in expr.args:
                arg_value = self.evaluate_expression(arg)
                print(f"Argument evaluated to {arg_value}")
                args.append(arg_value)

            # Check if procedure exists
            if func_name not in self.procedureTable:
                raise ValueError(f"Function {func_name} not defined")

            # Create parameter map
            params = {}
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

            # Record initial call depth before execution
            call_depth = len(self.call_stack)
            print(f"Starting execution of {func_name} at call depth {call_depth}")

            # Jump to function start
            start_pc = self.procedureTable[func_name][0]
            self.pc = start_pc  # Will be incremented in next interpret() call

            # Execute function until it returns
            while self.call_stack and len(self.call_stack) >= call_depth:
                if self.interpret():  # Program ended
                    break

                # If function has returned (call stack reduced), break
                if len(self.call_stack) < call_depth:
                    print(f"Function {func_name} has returned, breaking execution loop")
                    break

            # Restore PC
            self.pc = current_pc

            # Return the function's result
            print(f"Retrieving return value for {func_name}")
            return_value = None

            if self.call_stack:
                current_activation = self.call_stack[-1]
                return_value = current_activation.get_return_value()
                print(f"Retrieved return value {return_value} from {current_activation.proc_name}")
                # Clear the return value after use
                current_activation.clear_return_value()
            else:
                print("Warning: No activation record to retrieve return value from")

            print(f"Function {func_name} returned {return_value}")
            return return_value


        # Handle string-based expressions
        elif isinstance(expr, str):
            # Handle variable references
            if expr.startswith(':'):
                return self.get_variable(expr)

            # Handle expressions with variable references
            var_refs = re.findall(r':\w+', expr)
            modified_expr = expr

            for var_ref in var_refs:
                var_value = self.get_variable(var_ref)
                if var_value is None:
                    var_value = 0  # Default to 0 for undefined variables
                modified_expr = modified_expr.replace(var_ref, str(var_value))

            try:
                return eval(modified_expr)
            except Exception as e:
                print(f"Error evaluating expression: {expr}, {e}")
                return None

        # For AST nodes, return them as is
        print(f"Error evaluating expression: {expr} and returned as is")
        return expr

    def handleProcedureCall(self, stmt):
        print(" Procedure Call")
        full_stmt = str(stmt).replace("procedure call ", "")

        # Extract procedure name and arguments
        if "(" in full_stmt and ")" in full_stmt:
            proc_name = full_stmt.split("(")[0].strip()
            arg_section = full_stmt.split("(")[1].split(")")[0].strip()

            # Parse arguments
            args = []
            if arg_section:
                for arg in arg_section.split(","):
                    arg = arg.strip()
                    args.append(self.evaluate_expression(arg))
        else:
            proc_name = full_stmt.strip()
            args = []

        # Get procedure info
        if proc_name not in self.procedureTable:
            raise ValueError(f"Procedure {proc_name} not defined")

        proc_info = self.procedureTable[proc_name]
        start_pc = proc_info[0]
        param_names = proc_info[2] if len(proc_info) > 2 else []

        # Match arguments to parameters
        params = {}
        for i, param_name in enumerate(param_names):
            if i < len(args):
                # Remove ":" prefix if it exists
                clean_name = param_name[1:] if param_name.startswith(':') else param_name
                params[clean_name] = args[i]

        # Create and push activation record
        return_addr = self.pc + 1
        activation_record = ActivationRecord(proc_name, return_addr, params)
        self.call_stack.append(activation_record)

        # Set return address in procedure table
        self.procedureTable[proc_name][1] = return_addr
        # Calculate and validate jump target
        target_pc = start_pc
        validated_pc = self.validate_jump(target_pc)
        # Calculate jump target
        return validated_pc - self.pc

    def handleProcedureRet(self, stmt):
        print(" Return from Procedure")
        # Check if we have a call stack
        if not self.call_stack:
            raise RuntimeError("Return statement encountered without a corresponding procedure call")

        # Get the expression to return, if present
        ret_value = None
        if hasattr(stmt, 'expr') and stmt.expr is not None:
            print(stmt.expr)
            ret_value = self.evaluate_expression(stmt.expr)
            print(f"Function returning value: {ret_value}")
        # Get the current activation record
        current_activation = self.call_stack.pop()
        return_addr = current_activation.return_address
        print(f"returning to the address {return_addr}")
        # If there's a caller, store the return value in the caller's activation record
        if self.call_stack:
            caller_activation = self.call_stack[-1]
            caller_activation.set_return_value(ret_value)
            print(f"Stored return value in caller's {caller_activation.proc_name}activation record")

        # Calculate jump target to return to caller
        return return_addr - self.pc

    def handleOutput(self, stmt, tgt):
        print(" Output Statement")
        stmt_str = str(stmt).replace("output ", "")
        value = self.evaluate_expression(stmt_str)

        print(f"Output: {value}")

        # If in a procedure call, store as the return value
        if self.call_stack:
            self.set_variable("_return_value", value)

        return 1

    
    