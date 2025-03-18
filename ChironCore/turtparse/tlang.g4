
grammar tlang;

start : instruction_list EOF
      ;

instruction_list : (instruction)*
		 ;

strict_ilist : (instruction)+
             ;

instruction : assignment
	    | conditional
	    | loop
		| procedureDeclaration
		| procedureCall      // standalone call, no return value expected, I will check at interpreter level whether it is correct or not. Even if provided I will ignore it
		| returnStatement
	    | moveCommand
	    | penCommand
	    | gotoCommand
	    | pauseCommand
	    ;

conditional : ifConditional | ifElseConditional ;

ifConditional : 'if' condition '[' strict_ilist ']' ;

ifElseConditional : 'if' condition '[' strict_ilist ']' 'else' '[' strict_ilist ']' ;

loop : 'repeat' value '[' strict_ilist ']' ;

gotoCommand : 'goto' '(' expression ',' expression ')';

assignment : VAR '=' expression
	   ;

moveCommand : moveOp expression ;
moveOp : 'forward' | 'backward' | 'left' | 'right' ;

penCommand : 'penup' | 'pendown' ;

pauseCommand : 'pause' ;

expression : unaryArithOp expression               #unaryExpr
           | expression multiplicative expression  #mulExpr
		   | expression additive expression        #addExpr
		   | functionCall                          #functionCallExpr  // explicitly returns value
		   | value                                 #valueExpr
		   | '(' expression ')'                    #parenExpr
 	   ;

multiplicative : MUL | DIV;
additive : PLUS | MINUS;

unaryArithOp : MINUS ;

PLUS     : '+' ;
MINUS    : '-' ;
MUL  	 : '*' ;
DIV      : '/' ;


// TODO :
// procedure_declaration : 'to' NAME (VAR)+ strict_ilist 'end' ;

procedureDeclaration : 'to' NAME '(' paramList? ')' '[' strict_ilist ']' 'end';
paramList : VAR (',' VAR)* ;
procedureCall : NAME '(' argList? ')' ;         // standalone instruction, no return expected
functionCall : NAME '(' argList? ')' ;          // used inside expressions, must return a value
argList : expression (',' expression)* ;

returnStatement : 'output' expression;


condition : NOT condition
          |expression binCondOp expression
	  | condition logicOp condition
	  | PENCOND
	  | '(' condition ')'
	  ;


binCondOp :  EQ | NEQ | LT | GT | LTE | GTE
	 ;

logicOp : AND | OR ;

PENCOND : 'pendown?';
LT : '<' ;
GT : '>' ;
EQ : '==';
NEQ: '!=';
LTE: '<=';
GTE: '>=';
AND: '&&';
OR : '||';
NOT: '!' ;

value : NUM
      | VAR
      ;

NUM  : [0-9]+        ;

VAR  : ':'[a-zA-Z_] [a-zA-Z0-9]* ;

NAME : [a-zA-Z]+     ;

Whitespace: [ \t\n\r]+ -> skip;
