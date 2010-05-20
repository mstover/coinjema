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
}

@lexer::members {
	boolean propKey = true;
	private boolean getPropKey() {
	    return propKey;
	}
}
	
main	:	pckg? config_tree+ EOF;

pckg	:	'package' ID ('.' ID)* NEWLINE+
	;

config_tree options {
                        k=2;
                    }	:	ID ':int' EQ INTEGER NEWLINE? -> ^({adaptor.create(PROPERTY,$ID.text)} INT_PROP INTEGER)
	|	ID ':float' EQ FLOAT NEWLINE? -> ^({adaptor.create(PROPERTY,$ID.text)} FLOAT_TYPE FLOAT)
	|	ID TREE_START config_tree* TREE_END -> ^({adaptor.create(TREE_PROP,$ID.text)} config_tree*)
	|	ID ':file' EQ RAWTEXT NEWLINE? -> ^({adaptor.create(PROPERTY,$ID.text)} FILE_TYPE RAWTEXT)
	|	ID (':string')? EQ  RAWTEXT NEWLINE? -> ^({adaptor.create(PROPERTY,$ID.text)} STRING_PROP RAWTEXT)
	;
	
INTEGER	:	{!getPropKey()}?=>WS* '0'..'9'+ WS*
	;
	
FLOAT
    :  {!getPropKey()}?=> WS* ('0'..'9')+ '.' ('0'..'9')* EXPONENT? WS*
    |  {!getPropKey()}?=>WS*  '.' ('0'..'9')+ EXPONENT? WS*
    | {!getPropKey()}?=> WS* ('0'..'9')+ EXPONENT WS*
    ;
    
 
 fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
			
RAWTEXT	:	{!getPropKey()}?=> ( ESC_SEQ|~('\n'|'}'))*
	;

fragment
ESC_SEQ	:	'\\' ('n'|'t'|'='|'{'|'}'|':'|'\n')
	;

EQ	:	{getPropKey()}?=> '=' {propKey=false;}
	;
	
TREE_START
	:	{getPropKey()}?=> '{'
	;
	
TREE_END:		'}' {propKey=true;}
	;	

NEWLINE	:	{!getPropKey()}?=>'\r'* '\n' {propKey = true;}
	|	{getPropKey()}?=>'r'* '\n' {$channel=HIDDEN;}
	;

ID	:	{getPropKey()}?=> ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'.')*
	;
	
WS	:	(' '|'\t')+ {$channel=HIDDEN;}
	;