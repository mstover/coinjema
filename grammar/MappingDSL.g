grammar MappingDSL;

options {
output=AST;
k=4;
backtrack=true;
}

tokens {
CONTEXT;
AREA_ACTION;
FUNC_CALL;
PROC_CALL;
OFFSET;
COORD;
IMAGE;
RECTANGLE;
CIRCLE;
RAW;
PROCEDURE;
FUNCTION;
ARGLIST;
BODY;
}

main	:	(context|areaAction|proc|func)*;

context	:	ID ':' coordinateSystem a=('outline'|'inline')? ';' -> ^(CONTEXT[$ID.text] coordinateSystem $a? ) ;

areaAction
	:	(expr ':')=> expr ':' action ';' -> ^(AREA_ACTION expr action);
	
action	:	(image)=> image -> ^(IMAGE[$image.text])
	|	(COLOR)=> COLOR
	|	(procCall)=> procCall
	|	ID;
	
expr
	:	(coord)=> coord ((DASH|PLUS)^ expr)?
	|	(offset)=> offset
	|	(FLOAT)=> FLOAT ((DASH|PLUS|MULT|DIV)^ expr)?
	|	(INT)=> INT ((DASH|PLUS|MULT|DIV|OP)^ expr)?
	|	(STRING)=> STRING (PLUS^ expr)?
	|	(procCall)=> procCall ((DASH|PLUS)^ expr)? 
	|	('(')=> '(' expr ')'
	|	ID ((DASH|PLUS|MULT|DIV)^ expr)?
	;
	
procCall:	ID '(' (expr (',' expr)*)? (',' action)? ')' -> ^(PROC_CALL[$ID.text] expr* action?)
	;

image	:	DIV? ID (DIV ID)* '.' ID;

coordinateSystem
	:	'hex' coord size? location?
	|	'square' coord size? location?
	|	'free' size? location?
	;

size	:	'size' coord
	|	'each' INT;

location	: 'within' ID expr
	|	'beside' ID DIRECTION;

proc	:	'proc' name=ID '(' (arg+=ID (',' arg+=ID)*)? ')' '{' (a+=areaAction|a+=procCall ';')+ '}' -> ^(PROCEDURE[$name.text] ^(ARGLIST $arg*) ^(BODY $a+));

func	:	'func' name=ID '(' (arg+=ID (',' arg+=ID)*)? ')' '{' expr ';'? '}' -> ^(FUNCTION[$name.text] ^(ARGLIST $arg*) ^(BODY expr));


coord :	 '[' (expr) ','^ (expr) ']' 
	;

offset  :	'[' ('+'|'-') (ID|INT) ','^ ('+'|'-') (ID|INT) ']'
	;
	

DASH	:	'-'
	;

PLUS	:	'+' 
	;
	
MULT	:	'*'
	;
	
DIV	:	'/'
	;

OP	:	('%'|'<'|'>'|'!')
	;
	
DIRECTION
	:	('NW'|'N'|'E'|'W'|'S'|'NE'|'SE'|'SW');
	    
 COLOR	: '#' ('0'..'9'|'a'..'f') ('0'..'9'|'a'..'f') ('0'..'9'|'a'..'f') ('0'..'9'|'a'..'f') ('0'..'9'|'a'..'f') ('0'..'9'|'a'..'f')
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;	

INT :	'0'..'9'+
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;
    
    FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

