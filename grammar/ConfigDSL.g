grammar ConfigDSL;

options {
	output=AST;
	ASTLabelType=CommonTree;
}

tokens {
STRING_PROP;
INT_PROP;
TREE_PROP;
PROPERTY;
PROP_NAME;
FLOAT_TYPE;
FILE_TYPE;
TEXT;
}

@lexer::members {
	private boolean inValue = false;
	private String propType="string";
	private boolean inType = false;
	private boolean isRaw() {
		return inValue && "string".equals(propType);
	}	
}
	
main	:	pckg? config_tree+;

pckg	:	'package' ID ('.' ID)* NEWLINE+
	;

config_tree options {
                        k=3;
                    }	:	ID OPEN_TREE config_tree* CLOSE_TREE -> ^({adaptor.create(TREE_PROP,$ID.text)} config_tree*)
                    	|	(ID)=> a=ID COLON INTTYPE EQ INT -> ^({adaptor.create(INT_PROP,$a.text)} INT)
                    	|	(ID)=> a=ID COLON FLOATTYPE EQ FLOAT -> ^({adaptor.create(FLOAT_TYPE,$a.text)} FLOAT)
                      	|	(ID)=> a=ID COLON FILETYPE EQ (b+=ID|b+=INT|b+=FILE_SEP)* -> ^({adaptor.create(FILE_TYPE,$a.text)} $b* )
	|	a=ID (COLON STRINGTYPE)? EQ rawtext -> ^({adaptor.create(STRING_PROP,$a.text)} {adaptor.create(TEXT,$rawtext.text.trim())})
	;
	
rawtext	:	 .* (NEWLINE|EOF)!;
	
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\'|'\n'|'\r'|'{'|'}'|'/')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;
    
 EQ	:	'=' {inValue=true;inType=false;};
 
 STRINGTYPE	:	'string' {if(inType) propType="string"; else propType=null;};
 
 INTTYPE:	'int' {if(inType) propType=null;};
  
 FILETYPE:	'file' {if(inType) propType=null;};
 
 FLOATTYPE
 	:	'float' {if(inType) propType=null;};

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.')* {if(inType) propType=null;}
    ;

INT :	'0'..'9'+
    ;
    
OPEN_TREE
	:	'{';
	
CLOSE_TREE
	:	'}' {inValue=false;propType="string";};
	
COLON	:	':' {if(!inValue) inType=true;};

FILE_SEP:	'/';



FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        ) {if(!isRaw()) {$channel=HIDDEN;}}
    ;
    
  NEWLINE
  	:  '\n' {if(!isRaw()) {$channel=HIDDEN;} inValue=false;propType="string";};

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;



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
    
OTHER	:	.;
