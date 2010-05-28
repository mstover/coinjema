grammar MappingDSL;

options {
output=AST;
k=100;
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
}

main	:	(context|areaAction|proc|func)*;

context	:	ID ':' coordinateSystem a=('outline'|'inline')? ';' -> ^(CONTEXT[$ID.text] coordinateSystem $a? ) ;

areaAction
	:	areaExpr ':' action ';' -> ^(AREA_ACTION areaExpr action);
	
action	:	image -> ^(IMAGE[$image.text])
	|	COLOR
	|	ID
	|	procCall;
	
simpleExpr
	:	INT ((DASH|PLUS|MULT|DIV|OP)^ simpleExpr)?
	|	FLOAT ((DASH|PLUS|MULT|DIV)^ simpleExpr)?
	|	STRING (PLUS^ simpleExpr)?
	;
	
procCall:	ID '(' (a+=areaExpr|a+=offset|a+=simpleExpr)* action? ')' -> ^(PROC_CALL[$ID.text] $a* action?)
	;

offset	:	(DASH|PLUS) INT ','^ (DASH|PLUS) INT; 
	
coord	:	a=INT ',' b=INT -> ^(COORD $a $b)
	|	'raw' a=INT ',' b=INT  -> ^(COORD RAW $a $b)
	;

image	:	DIV? ID (DIV ID)* '.' ID;

rectangle
	:	coord DASH coord -> ^(RECTANGLE coord coord)
	|	'raw' coord DASH coord -> ^(RECTANGLE RAW coord coord)
	;
	
circle	:	coord MULT INT -> ^(CIRCLE coord INT)
	|	'raw' coord MULT FLOAT -> ^(CIRCLE RAW coord FLOAT);
	
areaExpr:	area ((DASH|PLUS)^ areaExpr)? 
	|	ID ((DASH|PLUS)^ areaExpr)? 
	|	procCall ((DASH|PLUS)^ areaExpr)? 
	;
	
area	:	(ID ':')? rectangle
	|	(ID ':')? circle
	|	(ID ':')? coord
	;

coordinateSystem
	:	'hex' coord size? location?
	|	'square' coord size? location?
	|	'free' size? location?
	;

size	:	'size' coord
	|	'each' INT;

location	:	'within' ID area
	|	'beside' ID DIRECTION;

proc	:	'proc' name=ID '(' ID* ')' '{' (a+=areaAction|a+=procCall ';')+ '}' -> ^(PROCEDURE[$name.text] $a+);

func	:	'func' name=ID '(' ID* ')' '{' a=(areaExpr|simpleExpr) ';'? '}' -> ^(FUNCTION[$name.text] $a);

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

