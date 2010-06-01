// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g 2010-05-30 22:11:41

    package org.coinjema.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConfigDSLLexer extends Lexer {
    public static final int PACKAGE=12;
    public static final int FLOAT_TYPE=9;
    public static final int EXPONENT=29;
    public static final int OTHER=35;
    public static final int CLOSE_TREE=15;
    public static final int FILETYPE=22;
    public static final int UNICODE_ESC=26;
    public static final int OCTAL_ESC=27;
    public static final int CHAR=33;
    public static final int INT_PROP=5;
    public static final int HEX_DIGIT=34;
    public static final int FLOAT=21;
    public static final int INT=19;
    public static final int TEXT=11;
    public static final int OPEN_TREE=14;
    public static final int FILE_SEP=24;
    public static final int ID=13;
    public static final int EOF=-1;
    public static final int COLON=16;
    public static final int ESC_SEQ=28;
    public static final int WS=31;
    public static final int NEWLINE=25;
    public static final int T__36=36;
    public static final int PROPERTY=7;
    public static final int TREE_PROP=6;
    public static final int FLOATTYPE=20;
    public static final int STRINGTYPE=23;
    public static final int FILE_TYPE=10;
    public static final int STRING_PROP=4;
    public static final int EQ=18;
    public static final int COMMENT=30;
    public static final int INTTYPE=17;
    public static final int PROP_NAME=8;
    public static final int STRING=32;

    	private boolean inValue = false;
    	private String propType="string";
    	private boolean inType = false;
    	private boolean isRaw() {
    		return inValue && "string".equals(propType);
    	}	


    // delegates
    // delegators

    public ConfigDSLLexer() {;} 
    public ConfigDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ConfigDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g"; }

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:15:7: ( 'package' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:15:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            int _type = ESC_SEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:64:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '\\n' | '\\r' | '{' | '}' | '/' ) | UNICODE_ESC | OCTAL_ESC )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\n':
                case '\r':
                case '\"':
                case '\'':
                case '/':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                case '{':
                case '}':
                    {
                    alt1=1;
                    }
                    break;
                case 'u':
                    {
                    alt1=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt1=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:64:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | '\\n' | '\\r' | '{' | '}' | '/' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\n'||input.LA(1)=='\r'||input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='/'||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t'||input.LA(1)=='{'||input.LA(1)=='}' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:65:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:66:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:69:4: ( '=' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:69:6: '='
            {
            match('='); 
            inValue=true;inType=false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "STRINGTYPE"
    public final void mSTRINGTYPE() throws RecognitionException {
        try {
            int _type = STRINGTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:71:12: ( 'string' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:71:14: 'string'
            {
            match("string"); 

            if(inType) propType="string"; else propType=null;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRINGTYPE"

    // $ANTLR start "INTTYPE"
    public final void mINTTYPE() throws RecognitionException {
        try {
            int _type = INTTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:73:8: ( 'int' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:73:10: 'int'
            {
            match("int"); 

            if(inType) propType=null;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTTYPE"

    // $ANTLR start "FILETYPE"
    public final void mFILETYPE() throws RecognitionException {
        try {
            int _type = FILETYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:75:9: ( 'file' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:75:11: 'file'
            {
            match("file"); 

            if(inType) propType=null;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FILETYPE"

    // $ANTLR start "FLOATTYPE"
    public final void mFLOATTYPE() throws RecognitionException {
        try {
            int _type = FLOATTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:78:3: ( 'float' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:78:5: 'float'
            {
            match("float"); 

            if(inType) propType=null;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOATTYPE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:80:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' )* )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:80:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:80:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='.'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if(inType) propType=null;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:83:5: ( ( '0' .. '9' )+ )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:83:7: ( '0' .. '9' )+
            {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:83:7: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:83:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "OPEN_TREE"
    public final void mOPEN_TREE() throws RecognitionException {
        try {
            int _type = OPEN_TREE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:87:2: ( '{' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:87:4: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_TREE"

    // $ANTLR start "CLOSE_TREE"
    public final void mCLOSE_TREE() throws RecognitionException {
        try {
            int _type = CLOSE_TREE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:90:2: ( '}' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:90:4: '}'
            {
            match('}'); 
            inValue=false;propType="string";

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_TREE"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:92:7: ( ':' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:92:9: ':'
            {
            match(':'); 
            if(!inValue) inType=true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "FILE_SEP"
    public final void mFILE_SEP() throws RecognitionException {
        try {
            int _type = FILE_SEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:94:9: ( '/' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:94:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FILE_SEP"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:9: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    match('.'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:25: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:37: ( EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:99:37: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:100:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:100:13: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:100:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:100:25: ( EXPONENT )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:100:25: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:101:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:101:9: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:101:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    mEXPONENT(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:105:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='/') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='/') ) {
                    alt14=1;
                }
                else if ( (LA14_1=='*') ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:105:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:105:14: (~ ( '\\n' | '\\r' ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:105:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:105:28: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:105:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:106:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:106:14: ( options {greedy=false; } : . )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='*') ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1=='/') ) {
                                alt13=2;
                            }
                            else if ( ((LA13_1>='\u0000' && LA13_1<='.')||(LA13_1>='0' && LA13_1<='\uFFFF')) ) {
                                alt13=1;
                            }


                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<=')')||(LA13_0>='+' && LA13_0<='\uFFFF')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:106:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match("*/"); 

                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:109:5: ( ( ' ' | '\\t' | '\\r' ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:109:9: ( ' ' | '\\t' | '\\r' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if(!isRaw()) {_channel=HIDDEN;}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:116:4: ( '\\n' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:116:7: '\\n'
            {
            match('\n'); 
            if(!isRaw()) {_channel=HIDDEN;} inValue=false;propType="string";

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:119:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:119:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:119:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\\') ) {
                    alt15=1;
                }
                else if ( ((LA15_0>='\u0000' && LA15_0<='!')||(LA15_0>='#' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:119:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:119:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:122:5: ( '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:122:8: '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:122:13: ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                alt16=1;
            }
            else if ( ((LA16_0>='\u0000' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='[')||(LA16_0>=']' && LA16_0<='\uFFFF')) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:122:15: ESC_SEQ
                    {
                    mESC_SEQ(); 

                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:122:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:126:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:126:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:126:22: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:126:33: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:126:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:129:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:129:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\\') ) {
                int LA19_1 = input.LA(2);

                if ( ((LA19_1>='0' && LA19_1<='3')) ) {
                    int LA19_2 = input.LA(3);

                    if ( ((LA19_2>='0' && LA19_2<='7')) ) {
                        int LA19_4 = input.LA(4);

                        if ( ((LA19_4>='0' && LA19_4<='7')) ) {
                            alt19=1;
                        }
                        else {
                            alt19=2;}
                    }
                    else {
                        alt19=3;}
                }
                else if ( ((LA19_1>='4' && LA19_1<='7')) ) {
                    int LA19_3 = input.LA(3);

                    if ( ((LA19_3>='0' && LA19_3<='7')) ) {
                        alt19=2;
                    }
                    else {
                        alt19=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:14: ( '0' .. '3' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:25: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:36: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:135:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:136:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:136:14: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:136:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:136:25: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:136:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:137:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:137:14: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:137:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:142:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:142:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 
            match('u'); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "OTHER"
    public final void mOTHER() throws RecognitionException {
        try {
            int _type = OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:145:7: ( . )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:145:9: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OTHER"

    public void mTokens() throws RecognitionException {
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:8: ( T__36 | ESC_SEQ | EQ | STRINGTYPE | INTTYPE | FILETYPE | FLOATTYPE | ID | INT | OPEN_TREE | CLOSE_TREE | COLON | FILE_SEP | FLOAT | COMMENT | WS | NEWLINE | STRING | CHAR | OTHER )
        int alt20=20;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:10: T__36
                {
                mT__36(); 

                }
                break;
            case 2 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:16: ESC_SEQ
                {
                mESC_SEQ(); 

                }
                break;
            case 3 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:24: EQ
                {
                mEQ(); 

                }
                break;
            case 4 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:27: STRINGTYPE
                {
                mSTRINGTYPE(); 

                }
                break;
            case 5 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:38: INTTYPE
                {
                mINTTYPE(); 

                }
                break;
            case 6 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:46: FILETYPE
                {
                mFILETYPE(); 

                }
                break;
            case 7 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:55: FLOATTYPE
                {
                mFLOATTYPE(); 

                }
                break;
            case 8 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:65: ID
                {
                mID(); 

                }
                break;
            case 9 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:68: INT
                {
                mINT(); 

                }
                break;
            case 10 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:72: OPEN_TREE
                {
                mOPEN_TREE(); 

                }
                break;
            case 11 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:82: CLOSE_TREE
                {
                mCLOSE_TREE(); 

                }
                break;
            case 12 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:93: COLON
                {
                mCOLON(); 

                }
                break;
            case 13 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:99: FILE_SEP
                {
                mFILE_SEP(); 

                }
                break;
            case 14 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:108: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 15 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:114: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 16 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:122: WS
                {
                mWS(); 

                }
                break;
            case 17 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:125: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 18 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:133: STRING
                {
                mSTRING(); 

                }
                break;
            case 19 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:140: CHAR
                {
                mCHAR(); 

                }
                break;
            case 20 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:1:145: OTHER
                {
                mOTHER(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA10_eotS =
        "\5\uffff";
    static final String DFA10_eofS =
        "\5\uffff";
    static final String DFA10_minS =
        "\2\56\3\uffff";
    static final String DFA10_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA10_specialS =
        "\5\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "98:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA20_eotS =
        "\1\uffff\1\24\1\22\1\uffff\3\24\1\uffff\1\33\3\uffff\1\42\1\22\2"+
        "\uffff\2\22\1\uffff\1\24\3\uffff\4\24\2\uffff\1\33\11\uffff\2\24"+
        "\1\56\4\24\1\uffff\1\63\3\24\1\uffff\1\67\1\24\1\71\1\uffff\1\72"+
        "\2\uffff";
    static final String DFA20_eofS =
        "\73\uffff";
    static final String DFA20_minS =
        "\1\0\1\141\1\12\1\uffff\1\164\1\156\1\151\1\uffff\1\56\3\uffff\1"+
        "\52\1\60\2\uffff\2\0\1\uffff\1\143\3\uffff\1\162\1\164\1\154\1\157"+
        "\2\uffff\1\56\11\uffff\1\153\1\151\1\56\1\145\2\141\1\156\1\uffff"+
        "\1\56\1\164\2\147\1\uffff\1\56\1\145\1\56\1\uffff\1\56\2\uffff";
    static final String DFA20_maxS =
        "\1\uffff\1\141\1\175\1\uffff\1\164\1\156\1\154\1\uffff\1\145\3\uffff"+
        "\1\57\1\71\2\uffff\2\uffff\1\uffff\1\143\3\uffff\1\162\1\164\1\154"+
        "\1\157\2\uffff\1\145\11\uffff\1\153\1\151\1\172\1\145\2\141\1\156"+
        "\1\uffff\1\172\1\164\2\147\1\uffff\1\172\1\145\1\172\1\uffff\1\172"+
        "\2\uffff";
    static final String DFA20_acceptS =
        "\3\uffff\1\3\3\uffff\1\10\1\uffff\1\12\1\13\1\14\2\uffff\1\20\1"+
        "\21\2\uffff\1\24\1\uffff\1\10\1\2\1\3\4\uffff\1\11\1\16\1\uffff"+
        "\1\12\1\13\1\14\1\17\1\15\1\20\1\21\1\22\1\23\7\uffff\1\5\4\uffff"+
        "\1\6\3\uffff\1\7\1\uffff\1\4\1\1";
    static final String DFA20_specialS =
        "\1\2\17\uffff\1\1\1\0\51\uffff}>";
    static final String[] DFA20_transitionS = {
            "\11\22\1\16\1\17\2\22\1\16\22\22\1\16\1\22\1\20\4\22\1\21\6"+
            "\22\1\15\1\14\12\10\1\13\2\22\1\3\3\22\32\7\1\22\1\2\2\22\1"+
            "\7\1\22\5\7\1\6\2\7\1\5\6\7\1\1\2\7\1\4\7\7\1\11\1\22\1\12\uff82"+
            "\22",
            "\1\23",
            "\1\25\2\uffff\1\25\24\uffff\1\25\4\uffff\1\25\7\uffff\11\25"+
            "\44\uffff\1\25\5\uffff\1\25\3\uffff\1\25\7\uffff\1\25\3\uffff"+
            "\1\25\1\uffff\2\25\5\uffff\1\25\1\uffff\1\25",
            "",
            "\1\27",
            "\1\30",
            "\1\31\2\uffff\1\32",
            "",
            "\1\34\1\uffff\12\35\13\uffff\1\34\37\uffff\1\34",
            "",
            "",
            "",
            "\1\41\4\uffff\1\41",
            "\12\34",
            "",
            "",
            "\0\45",
            "\47\46\1\uffff\uffd8\46",
            "",
            "\1\47",
            "",
            "",
            "",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "",
            "\1\34\1\uffff\12\35\13\uffff\1\34\37\uffff\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\54",
            "\1\55",
            "\1\24\1\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\70",
            "\1\24\1\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__36 | ESC_SEQ | EQ | STRINGTYPE | INTTYPE | FILETYPE | FLOATTYPE | ID | INT | OPEN_TREE | CLOSE_TREE | COLON | FILE_SEP | FLOAT | COMMENT | WS | NEWLINE | STRING | CHAR | OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_17 = input.LA(1);

                        s = -1;
                        if ( ((LA20_17>='\u0000' && LA20_17<='&')||(LA20_17>='(' && LA20_17<='\uFFFF')) ) {s = 38;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_16 = input.LA(1);

                        s = -1;
                        if ( ((LA20_16>='\u0000' && LA20_16<='\uFFFF')) ) {s = 37;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_0 = input.LA(1);

                        s = -1;
                        if ( (LA20_0=='p') ) {s = 1;}

                        else if ( (LA20_0=='\\') ) {s = 2;}

                        else if ( (LA20_0=='=') ) {s = 3;}

                        else if ( (LA20_0=='s') ) {s = 4;}

                        else if ( (LA20_0=='i') ) {s = 5;}

                        else if ( (LA20_0=='f') ) {s = 6;}

                        else if ( ((LA20_0>='A' && LA20_0<='Z')||LA20_0=='_'||(LA20_0>='a' && LA20_0<='e')||(LA20_0>='g' && LA20_0<='h')||(LA20_0>='j' && LA20_0<='o')||(LA20_0>='q' && LA20_0<='r')||(LA20_0>='t' && LA20_0<='z')) ) {s = 7;}

                        else if ( ((LA20_0>='0' && LA20_0<='9')) ) {s = 8;}

                        else if ( (LA20_0=='{') ) {s = 9;}

                        else if ( (LA20_0=='}') ) {s = 10;}

                        else if ( (LA20_0==':') ) {s = 11;}

                        else if ( (LA20_0=='/') ) {s = 12;}

                        else if ( (LA20_0=='.') ) {s = 13;}

                        else if ( (LA20_0=='\t'||LA20_0=='\r'||LA20_0==' ') ) {s = 14;}

                        else if ( (LA20_0=='\n') ) {s = 15;}

                        else if ( (LA20_0=='\"') ) {s = 16;}

                        else if ( (LA20_0=='\'') ) {s = 17;}

                        else if ( ((LA20_0>='\u0000' && LA20_0<='\b')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\u001F')||LA20_0=='!'||(LA20_0>='#' && LA20_0<='&')||(LA20_0>='(' && LA20_0<='-')||(LA20_0>=';' && LA20_0<='<')||(LA20_0>='>' && LA20_0<='@')||LA20_0=='['||(LA20_0>=']' && LA20_0<='^')||LA20_0=='`'||LA20_0=='|'||(LA20_0>='~' && LA20_0<='\uFFFF')) ) {s = 18;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}