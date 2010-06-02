grammar MappingDSL;

options {
output=AST;
k=2;
backtrack=true;
memoize=true;
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
COORDINATE_SYSTEM;
SYSTEM_SIZE;
NEG;
}

main	:	ID '{' coordinateSystem ';' contextBodyEl* '}' -> ^(CONTEXT[$ID.text] coordinateSystem contextBodyEl*);

contextBodyEl
	:	areaAction
	|	proc
	|	func;

areaAction
	:	expr ':' action ';' -> ^(AREA_ACTION expr action);
	
action	:	image -> ^(IMAGE[$image.text])
	|	COLOR
	|	procCall
	|	ID
	|	STRING;
	
expr
	:	coord ((DASH|PLUS)^ expr)?
	|	FLOAT ((DASH|PLUS|MULT|DIV)^ expr)?
	|	INT ((DASH|PLUS|MULT|DIV|OP)^ expr)?
	|	STRING (PLUS^ expr)?
	|	procCall ((DASH|PLUS)^ expr)? 
	|	'(' expr ')'
	|	ID ((DASH|PLUS|MULT|DIV)^ expr)?
	;
	
procCall:	ID '(' (expr (',' expr)*)? (',' action)? ')' -> ^(PROC_CALL[$ID.text] expr* action?)
	;

image	:	DIV? ID (DIV ID)* '.' ID;

coordinateSystem
	:	'hex' coord size? lines? -> ^(COORDINATE_SYSTEM["hex"] coord size? lines?)
	|	'square' coord size? lines? -> ^(COORDINATE_SYSTEM["square"] coord size? lines?)
	|	'free' size? lines? -> ^(COORDINATE_SYSTEM["free"] size? lines?)
	;
	
lines	:	'outline'
	|	'inline'
	;

size	:	'size' coord -> ^(SYSTEM_SIZE coord)
	|	'each' INT -> ^(SYSTEM_SIZE INT);

proc	:	'proc' name=ID '(' (arg+=ID (',' arg+=ID)*)? ')' '{' (a+=areaAction)+ '}' -> ^(PROCEDURE[$name.text] ^(ARGLIST $arg*) ^(BODY $a+));

func	:	'func' name=ID '(' (arg+=ID (',' arg+=ID)*)? ')' '{' expr ';'? '}' -> ^(FUNCTION[$name.text] ^(ARGLIST $arg*) ^(BODY expr));


coord :	 '[' a=expr ',' b=expr ']' -> ^(COORD $a $b)
	|	'[' '-' a=expr ',' b=expr ']' -> ^(COORD ^(NEG $a) $b)
	|	'[' a=expr ',' '-' b=expr ']' -> ^(COORD $a ^(NEG $b))
	|	'[' '-' a=expr ',' '-' b=expr ']' -> ^(COORD ^(NEG $a) ^(NEG $b))
	|	'[r' a=expr ',' b=expr ']' -> ^(COORD RAW $a $b)
	|	'[r' '-' a=expr ',' b=expr ']' -> ^(COORD RAW ^(NEG $a) $b)
	|	'[r' a=expr ',' '-' b=expr ']' -> ^(COORD RAW $a ^(NEG $b))
	|	'[r' '-' a=expr ',' '-' b=expr ']' -> ^(COORD RAW ^(NEG $a) ^(NEG $b))
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

