grammar Test;

main	:	(COORD)=> COORD PLUS COORD
	|	OFFSET;

PLUS	:	'+';

COORD options{k=7;} :	'0'..'9'+  ',' '0'..'9'+ 
	;

OFFSET options{k=7;} :	(('+'|'-') '0'..'9'+  ',' ('-'|'+'))=> ('+'|'-') '0'..'9'+  ',' ('-'|'+') '0'..'9'+ 
	;
	
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;