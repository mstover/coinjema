// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g 2010-05-20 18:23:30

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConfigDSLLexer extends Lexer {
    public static final int INTEGER=14;
    public static final int FLOAT_TYPE=9;
    public static final int EXPONENT=20;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int TREE_START=16;
    public static final int INT_PROP=5;
    public static final int FLOAT=15;
    public static final int ID=11;
    public static final int EOF=-1;
    public static final int ESC_SEQ=21;
    public static final int WS=19;
    public static final int NEWLINE=12;
    public static final int RAWTEXT=18;
    public static final int PROPERTY=7;
    public static final int TREE_PROP=6;
    public static final int FILE_TYPE=10;
    public static final int STRING_PROP=4;
    public static final int EQ=13;
    public static final int PROP_NAME=8;
    public static final int TREE_END=17;

    	boolean propKey = true;
    	private boolean getPropKey() {
    	    return propKey;
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
    public String getGrammarFileName() { return "/Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g"; }

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:10:7: ( 'package' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:10:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:11:7: ( '.' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:11:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:12:7: ( ':int' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:12:9: ':int'
            {
            match(":int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:13:7: ( ':float' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:13:9: ':float'
            {
            match(":float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:14:7: ( ':file' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:14:9: ':file'
            {
            match(":file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:15:7: ( ':string' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:15:9: ':string'
            {
            match(":string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:9: ({...}? => ( WS )* ( '0' .. '9' )+ ( WS )* )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:11: {...}? => ( WS )* ( '0' .. '9' )+ ( WS )*
            {
            if ( !((!getPropKey())) ) {
                throw new FailedPredicateException(input, "INTEGER", "!getPropKey()");
            }
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:29: ( WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:29: WS
            	    {
            	    mWS(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:33: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:33: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:43: ( WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:43: WS
            	    {
            	    mWS(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:5: ({...}? => ( WS )* ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? ( WS )* | {...}? => ( WS )* '.' ( '0' .. '9' )+ ( EXPONENT )? ( WS )* | {...}? => ( WS )* ( '0' .. '9' )+ EXPONENT ( WS )* )
            int alt16=3;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:8: {...}? => ( WS )* ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? ( WS )*
                    {
                    if ( !((!getPropKey())) ) {
                        throw new FailedPredicateException(input, "FLOAT", "!getPropKey()");
                    }
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:27: ( WS )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\t'||LA4_0==' ') ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:27: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:31: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:32: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    match('.'); 
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:47: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:48: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:59: ( EXPONENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='E'||LA7_0=='e') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:59: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:69: ( WS )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\t'||LA8_0==' ') ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:43:69: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:8: {...}? => ( WS )* '.' ( '0' .. '9' )+ ( EXPONENT )? ( WS )*
                    {
                    if ( !((!getPropKey())) ) {
                        throw new FailedPredicateException(input, "FLOAT", "!getPropKey()");
                    }
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:26: ( WS )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\t'||LA9_0==' ') ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:26: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('.'); 
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:35: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:36: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:47: ( EXPONENT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:47: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:57: ( WS )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\t'||LA12_0==' ') ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:44:57: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:45:7: {...}? => ( WS )* ( '0' .. '9' )+ EXPONENT ( WS )*
                    {
                    if ( !((!getPropKey())) ) {
                        throw new FailedPredicateException(input, "FLOAT", "!getPropKey()");
                    }
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:45:26: ( WS )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\t'||LA13_0==' ') ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:45:26: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:45:30: ( '0' .. '9' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:45:31: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    mEXPONENT(); 
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:45:51: ( WS )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='\t'||LA15_0==' ') ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:45:51: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


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

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:50:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:50:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:50:22: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:
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

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:50:33: ( '0' .. '9' )+
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
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:50:34: '0' .. '9'
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

    // $ANTLR start "RAWTEXT"
    public final void mRAWTEXT() throws RecognitionException {
        try {
            int _type = RAWTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:52:9: ({...}? => ( ESC_SEQ | ~ ( '\\n' | '}' ) )* )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:52:11: {...}? => ( ESC_SEQ | ~ ( '\\n' | '}' ) )*
            {
            if ( !((!getPropKey())) ) {
                throw new FailedPredicateException(input, "RAWTEXT", "!getPropKey()");
            }
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:52:30: ( ESC_SEQ | ~ ( '\\n' | '}' ) )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\\') ) {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2=='\n'||LA19_2==':'||LA19_2=='='||LA19_2=='n'||LA19_2=='t'||LA19_2=='{'||LA19_2=='}') ) {
                        alt19=1;
                    }

                    else {
                        alt19=2;
                    }

                }
                else if ( ((LA19_0>='\u0000' && LA19_0<='\t')||(LA19_0>='\u000B' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='|')||(LA19_0>='~' && LA19_0<='\uFFFF')) ) {
                    alt19=2;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:52:32: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:52:40: ~ ( '\\n' | '}' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='|')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RAWTEXT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:56:9: ( '\\\\' ( 'n' | 't' | '=' | '{' | '}' | ':' | '\\n' ) )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:56:11: '\\\\' ( 'n' | 't' | '=' | '{' | '}' | ':' | '\\n' )
            {
            match('\\'); 
            if ( input.LA(1)=='\n'||input.LA(1)==':'||input.LA(1)=='='||input.LA(1)=='n'||input.LA(1)=='t'||input.LA(1)=='{'||input.LA(1)=='}' ) {
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
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:59:4: ({...}? => '=' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:59:6: {...}? => '='
            {
            if ( !((getPropKey())) ) {
                throw new FailedPredicateException(input, "EQ", "getPropKey()");
            }
            match('='); 
            propKey=false;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "TREE_START"
    public final void mTREE_START() throws RecognitionException {
        try {
            int _type = TREE_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:63:2: ({...}? => '{' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:63:4: {...}? => '{'
            {
            if ( !((getPropKey())) ) {
                throw new FailedPredicateException(input, "TREE_START", "getPropKey()");
            }
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TREE_START"

    // $ANTLR start "TREE_END"
    public final void mTREE_END() throws RecognitionException {
        try {
            int _type = TREE_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:66:9: ( '}' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:66:12: '}'
            {
            match('}'); 
            propKey=true;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TREE_END"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:69:9: ({...}? => ( '\\r' )* '\\n' | {...}? => ( 'r' )* '\\n' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\r') && ((!getPropKey()))) {
                alt22=1;
            }
            else if ( (LA22_0=='\n') && (((!getPropKey())||(getPropKey())))) {
                int LA22_2 = input.LA(2);

                if ( ((!getPropKey())) ) {
                    alt22=1;
                }
                else if ( ((getPropKey())) ) {
                    alt22=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA22_0=='r') && ((getPropKey()))) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:69:11: {...}? => ( '\\r' )* '\\n'
                    {
                    if ( !((!getPropKey())) ) {
                        throw new FailedPredicateException(input, "NEWLINE", "!getPropKey()");
                    }
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:69:29: ( '\\r' )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\r') ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:69:29: '\\r'
                    	    {
                    	    match('\r'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    match('\n'); 
                    propKey = true;

                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:70:4: {...}? => ( 'r' )* '\\n'
                    {
                    if ( !((getPropKey())) ) {
                        throw new FailedPredicateException(input, "NEWLINE", "getPropKey()");
                    }
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:70:21: ( 'r' )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0=='r') ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:70:21: 'r'
                    	    {
                    	    match('r'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    match('\n'); 
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
    // $ANTLR end "NEWLINE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:73:4: ({...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )* )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:73:6: {...}? => ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
            {
            if ( !((getPropKey())) ) {
                throw new FailedPredicateException(input, "ID", "getPropKey()");
            }
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:73:48: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '.' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='.'||(LA23_0>='0' && LA23_0<='9')||(LA23_0>='A' && LA23_0<='Z')||LA23_0=='_'||(LA23_0>='a' && LA23_0<='z')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:
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
            	    break loop23;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:76:4: ( ( ' ' | '\\t' )+ )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:76:6: ( ' ' | '\\t' )+
            {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:76:6: ( ' ' | '\\t' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0=='\t'||LA24_0==' ') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:8: ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | INTEGER | FLOAT | RAWTEXT | EQ | TREE_START | TREE_END | NEWLINE | ID | WS )
        int alt25=15;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:10: T__22
                {
                mT__22(); 

                }
                break;
            case 2 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:16: T__23
                {
                mT__23(); 

                }
                break;
            case 3 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:22: T__24
                {
                mT__24(); 

                }
                break;
            case 4 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:28: T__25
                {
                mT__25(); 

                }
                break;
            case 5 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:34: T__26
                {
                mT__26(); 

                }
                break;
            case 6 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:40: T__27
                {
                mT__27(); 

                }
                break;
            case 7 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:46: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 8 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:54: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 9 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:60: RAWTEXT
                {
                mRAWTEXT(); 

                }
                break;
            case 10 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:68: EQ
                {
                mEQ(); 

                }
                break;
            case 11 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:71: TREE_START
                {
                mTREE_START(); 

                }
                break;
            case 12 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:82: TREE_END
                {
                mTREE_END(); 

                }
                break;
            case 13 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:91: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 14 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:99: ID
                {
                mID(); 

                }
                break;
            case 15 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:1:102: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA16_eotS =
        "\6\uffff";
    static final String DFA16_eofS =
        "\6\uffff";
    static final String DFA16_minS =
        "\2\11\1\56\3\uffff";
    static final String DFA16_maxS =
        "\2\71\1\145\3\uffff";
    static final String DFA16_acceptS =
        "\3\uffff\1\2\1\3\1\1";
    static final String DFA16_specialS =
        "\1\2\1\1\1\0\3\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1\26\uffff\1\1\15\uffff\1\3\1\uffff\12\2",
            "\1\1\26\uffff\1\1\15\uffff\1\3\1\uffff\12\2",
            "\1\5\1\uffff\12\2\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "42:1: FLOAT : ({...}? => ( WS )* ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? ( WS )* | {...}? => ( WS )* '.' ( '0' .. '9' )+ ( EXPONENT )? ( WS )* | {...}? => ( WS )* ( '0' .. '9' )+ EXPONENT ( WS )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_2=='E'||LA16_2=='e') && ((!getPropKey()))) {s = 4;}

                        else if ( ((LA16_2>='0' && LA16_2<='9')) && ((!getPropKey()))) {s = 2;}

                        else if ( (LA16_2=='.') && ((!getPropKey()))) {s = 5;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_1 = input.LA(1);

                         
                        int index16_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA16_1>='0' && LA16_1<='9')) && ((!getPropKey()))) {s = 2;}

                        else if ( (LA16_1=='\t'||LA16_1==' ') && ((!getPropKey()))) {s = 1;}

                        else if ( (LA16_1=='.') && ((!getPropKey()))) {s = 3;}

                         
                        input.seek(index16_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_0=='\t'||LA16_0==' ') && ((!getPropKey()))) {s = 1;}

                        else if ( ((LA16_0>='0' && LA16_0<='9')) && ((!getPropKey()))) {s = 2;}

                        else if ( (LA16_0=='.') && ((!getPropKey()))) {s = 3;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA25_eotS =
        "\1\6\1\20\1\21\1\6\1\26\1\31\1\uffff\1\34\1\35\1\6\1\uffff\1\20"+
        "\1\uffff\3\20\2\uffff\1\46\3\6\1\uffff\1\6\1\31\1\uffff\1\46\1\6"+
        "\3\uffff\1\20\1\uffff\1\20\2\uffff\1\6\1\46\1\uffff\4\6\2\uffff"+
        "\1\46\1\6\1\46\1\6\1\46\2\uffff\1\20\1\6\1\46\1\uffff\1\100\4\6"+
        "\2\46\1\20\1\uffff\1\6\1\107\1\6\1\20\1\uffff\1\112\1\uffff\1\6"+
        "\1\115\2\uffff\1\117\5\uffff";
    static final String DFA25_eofS =
        "\122\uffff";
    static final String DFA25_minS =
        "\1\11\2\0\1\146\2\0\1\uffff\2\0\1\12\1\uffff\1\0\1\uffff\6\0\1\156"+
        "\1\151\1\164\1\0\1\60\3\0\1\53\2\0\1\uffff\1\0\1\uffff\1\0\2\uffff"+
        "\1\53\2\0\1\164\1\157\1\154\1\162\2\uffff\1\0\1\53\1\0\1\60\1\0"+
        "\2\uffff\1\0\1\60\1\0\1\uffff\1\0\1\141\1\145\1\151\1\60\4\0\1\164"+
        "\1\0\1\156\1\0\1\uffff\2\0\1\147\2\0\1\uffff\2\0\1\uffff\1\0\2\uffff";
    static final String DFA25_maxS =
        "\1\175\2\uffff\1\163\2\uffff\1\uffff\2\uffff\1\15\1\uffff\1\uffff"+
        "\1\uffff\3\uffff\2\0\1\uffff\1\156\1\154\1\164\1\0\1\71\1\uffff"+
        "\1\0\1\uffff\1\71\2\0\1\uffff\1\uffff\1\uffff\1\uffff\2\uffff\1"+
        "\71\1\uffff\1\0\1\164\1\157\1\154\1\162\2\uffff\1\uffff\1\71\1\uffff"+
        "\1\71\1\uffff\2\uffff\1\uffff\1\71\1\uffff\1\uffff\1\uffff\1\141"+
        "\1\145\1\151\1\71\3\uffff\1\0\1\164\1\uffff\1\156\1\uffff\1\uffff"+
        "\1\uffff\1\0\1\147\1\uffff\1\0\1\uffff\1\uffff\1\0\1\uffff\1\0\2"+
        "\uffff";
    static final String DFA25_acceptS =
        "\6\uffff\1\11\3\uffff\1\14\1\uffff\1\15\21\uffff\1\15\1\uffff\1"+
        "\15\1\uffff\1\16\1\2\7\uffff\1\17\1\7\5\uffff\1\12\1\13\3\uffff"+
        "\1\10\15\uffff\1\3\5\uffff\1\5\2\uffff\1\4\1\uffff\1\1\1\6";
    static final String DFA25_specialS =
        "\1\60\1\55\1\52\1\66\1\50\1\0\1\uffff\1\30\1\45\1\57\1\uffff\1\67"+
        "\1\uffff\1\41\1\2\1\46\1\3\1\25\1\40\1\47\1\72\1\32\1\65\1\56\1"+
        "\31\1\16\1\61\1\76\1\12\1\6\1\uffff\1\64\1\uffff\1\4\2\uffff\1\77"+
        "\1\23\1\17\1\51\1\42\1\36\1\33\2\uffff\1\73\1\100\1\10\1\15\1\1"+
        "\2\uffff\1\5\1\14\1\71\1\uffff\1\54\1\44\1\37\1\34\1\13\1\35\1\53"+
        "\1\7\1\22\1\43\1\70\1\26\1\11\1\uffff\1\63\1\20\1\27\1\74\1\24\1"+
        "\uffff\1\75\1\62\1\uffff\1\21\2\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\4\1\14\2\uffff\1\11\22\uffff\1\4\15\uffff\1\2\1\uffff\12"+
            "\5\1\3\2\uffff\1\7\3\uffff\32\15\4\uffff\1\15\1\uffff\17\15"+
            "\1\1\1\15\1\13\10\15\1\10\1\uffff\1\12",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\1"+
            "\16\31\17\2\6\1\uffff\uff82\6",
            "\12\6\1\uffff\45\6\12\22\103\6\1\uffff\uff82\6",
            "\1\24\2\uffff\1\23\11\uffff\1\25",
            "\11\6\1\4\1\uffff\25\6\1\4\15\6\1\27\1\6\12\5\103\6\1\uffff"+
            "\uff82\6",
            "\11\6\1\30\1\uffff\25\6\1\30\15\6\1\32\1\6\12\5\13\6\1\33\37"+
            "\6\1\33\27\6\1\uffff\uff82\6",
            "",
            "\12\6\1\uffff\162\6\1\uffff\uff82\6",
            "\12\6\1\uffff\162\6\1\uffff\uff82\6",
            "\1\36\2\uffff\1\11",
            "",
            "\12\6\1\40\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\21\17"+
            "\1\37\10\17\2\6\1\uffff\uff82\6",
            "",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\32"+
            "\17\2\6\1\uffff\uff82\6",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\2"+
            "\17\1\41\27\17\2\6\1\uffff\uff82\6",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\32"+
            "\17\2\6\1\uffff\uff82\6",
            "\1\uffff",
            "\1\uffff",
            "\11\6\1\45\1\uffff\25\6\1\45\17\6\12\22\13\6\1\44\37\6\1\44"+
            "\27\6\1\uffff\uff82\6",
            "\1\47",
            "\1\51\2\uffff\1\50",
            "\1\52",
            "\1\uffff",
            "\12\22",
            "\11\6\1\30\1\uffff\25\6\1\30\134\6\1\uffff\uff82\6",
            "\1\uffff",
            "\11\6\1\57\1\uffff\25\6\1\57\17\6\12\55\13\6\1\56\37\6\1\56"+
            "\27\6\1\uffff\uff82\6",
            "\1\60\1\uffff\1\60\2\uffff\12\61",
            "\1\uffff",
            "\1\uffff",
            "",
            "\12\6\1\40\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\21\17"+
            "\1\37\10\17\2\6\1\uffff\uff82\6",
            "",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\12"+
            "\17\1\64\17\17\2\6\1\uffff\uff82\6",
            "",
            "",
            "\1\65\1\uffff\1\65\2\uffff\12\66",
            "\11\6\1\45\1\uffff\25\6\1\45\134\6\1\uffff\uff82\6",
            "\1\uffff",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "",
            "\11\6\1\57\1\uffff\25\6\1\57\17\6\12\55\13\6\1\56\37\6\1\56"+
            "\27\6\1\uffff\uff82\6",
            "\1\74\1\uffff\1\74\2\uffff\12\75",
            "\11\6\1\57\1\uffff\25\6\1\57\134\6\1\uffff\uff82\6",
            "\12\61",
            "\11\6\1\76\1\uffff\25\6\1\76\17\6\12\61\103\6\1\uffff\uff82"+
            "\6",
            "",
            "",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\1"+
            "\77\31\17\2\6\1\uffff\uff82\6",
            "\12\66",
            "\11\6\1\45\1\uffff\25\6\1\45\17\6\12\66\103\6\1\uffff\uff82"+
            "\6",
            "",
            "\12\6\1\uffff\162\6\1\uffff\uff82\6",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\75",
            "\11\6\1\57\1\uffff\25\6\1\57\17\6\12\75\103\6\1\uffff\uff82"+
            "\6",
            "\11\6\1\76\1\uffff\25\6\1\76\134\6\1\uffff\uff82\6",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\6"+
            "\17\1\104\23\17\2\6\1\uffff\uff82\6",
            "\1\uffff",
            "\1\106",
            "\12\6\1\uffff\162\6\1\uffff\uff82\6",
            "\1\110",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\4"+
            "\17\1\111\25\17\2\6\1\uffff\uff82\6",
            "",
            "\12\6\1\uffff\162\6\1\uffff\uff82\6",
            "\1\uffff",
            "\1\114",
            "\12\6\1\uffff\43\6\1\17\1\6\12\17\7\6\32\17\4\6\1\17\1\6\32"+
            "\17\2\6\1\uffff\uff82\6",
            "\1\uffff",
            "",
            "\12\6\1\uffff\162\6\1\uffff\uff82\6",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | INTEGER | FLOAT | RAWTEXT | EQ | TREE_START | TREE_END | NEWLINE | ID | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_5=='\t'||LA25_5==' ') && ((!getPropKey()))) {s = 24;}

                        else if ( ((LA25_5>='0' && LA25_5<='9')) && ((!getPropKey()))) {s = 5;}

                        else if ( ((LA25_5>='\u0000' && LA25_5<='\b')||(LA25_5>='\u000B' && LA25_5<='\u001F')||(LA25_5>='!' && LA25_5<='-')||LA25_5=='/'||(LA25_5>=':' && LA25_5<='D')||(LA25_5>='F' && LA25_5<='d')||(LA25_5>='f' && LA25_5<='|')||(LA25_5>='~' && LA25_5<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else if ( (LA25_5=='.') && ((!getPropKey()))) {s = 26;}

                        else if ( (LA25_5=='E'||LA25_5=='e') && ((!getPropKey()))) {s = 27;}

                        else s = 25;

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_49 = input.LA(1);

                         
                        int index25_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_49>='\u0000' && LA25_49<='\b')||(LA25_49>='\u000B' && LA25_49<='\u001F')||(LA25_49>='!' && LA25_49<='/')||(LA25_49>=':' && LA25_49<='|')||(LA25_49>='~' && LA25_49<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else if ( (LA25_49=='\t'||LA25_49==' ') && ((!getPropKey()))) {s = 62;}

                        else if ( ((LA25_49>='0' && LA25_49<='9')) && ((!getPropKey()))) {s = 49;}

                        else s = 38;

                         
                        input.seek(index25_49);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_14 = input.LA(1);

                         
                        int index25_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_14=='c') ) {s = 33;}

                        else if ( (LA25_14=='.'||(LA25_14>='0' && LA25_14<='9')||(LA25_14>='A' && LA25_14<='Z')||LA25_14=='_'||(LA25_14>='a' && LA25_14<='b')||(LA25_14>='d' && LA25_14<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_14>='\u0000' && LA25_14<='\t')||(LA25_14>='\u000B' && LA25_14<='-')||LA25_14=='/'||(LA25_14>=':' && LA25_14<='@')||(LA25_14>='[' && LA25_14<='^')||LA25_14=='`'||(LA25_14>='{' && LA25_14<='|')||(LA25_14>='~' && LA25_14<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_14);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_16 = input.LA(1);

                         
                        int index25_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!getPropKey())) ) {s = 6;}

                        else if ( ((getPropKey())) ) {s = 34;}

                         
                        input.seek(index25_16);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_33 = input.LA(1);

                         
                        int index25_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_33=='k') ) {s = 52;}

                        else if ( (LA25_33=='.'||(LA25_33>='0' && LA25_33<='9')||(LA25_33>='A' && LA25_33<='Z')||LA25_33=='_'||(LA25_33>='a' && LA25_33<='j')||(LA25_33>='l' && LA25_33<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_33>='\u0000' && LA25_33<='\t')||(LA25_33>='\u000B' && LA25_33<='-')||LA25_33=='/'||(LA25_33>=':' && LA25_33<='@')||(LA25_33>='[' && LA25_33<='^')||LA25_33=='`'||(LA25_33>='{' && LA25_33<='|')||(LA25_33>='~' && LA25_33<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_33);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_52 = input.LA(1);

                         
                        int index25_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_52=='a') ) {s = 63;}

                        else if ( (LA25_52=='.'||(LA25_52>='0' && LA25_52<='9')||(LA25_52>='A' && LA25_52<='Z')||LA25_52=='_'||(LA25_52>='b' && LA25_52<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_52>='\u0000' && LA25_52<='\t')||(LA25_52>='\u000B' && LA25_52<='-')||LA25_52=='/'||(LA25_52>=':' && LA25_52<='@')||(LA25_52>='[' && LA25_52<='^')||LA25_52=='`'||(LA25_52>='{' && LA25_52<='|')||(LA25_52>='~' && LA25_52<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_52);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_29 = input.LA(1);

                         
                        int index25_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!getPropKey())) ) {s = 6;}

                        else if ( ((getPropKey())) ) {s = 51;}

                         
                        input.seek(index25_29);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_63 = input.LA(1);

                         
                        int index25_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_63=='g') ) {s = 68;}

                        else if ( (LA25_63=='.'||(LA25_63>='0' && LA25_63<='9')||(LA25_63>='A' && LA25_63<='Z')||LA25_63=='_'||(LA25_63>='a' && LA25_63<='f')||(LA25_63>='h' && LA25_63<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_63>='\u0000' && LA25_63<='\t')||(LA25_63>='\u000B' && LA25_63<='-')||LA25_63=='/'||(LA25_63>=':' && LA25_63<='@')||(LA25_63>='[' && LA25_63<='^')||LA25_63=='`'||(LA25_63>='{' && LA25_63<='|')||(LA25_63>='~' && LA25_63<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_63);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_47 = input.LA(1);

                         
                        int index25_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_47>='\u0000' && LA25_47<='\b')||(LA25_47>='\u000B' && LA25_47<='\u001F')||(LA25_47>='!' && LA25_47<='|')||(LA25_47>='~' && LA25_47<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else if ( (LA25_47=='\t'||LA25_47==' ') && ((!getPropKey()))) {s = 47;}

                        else s = 38;

                         
                        input.seek(index25_47);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_68 = input.LA(1);

                         
                        int index25_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_68=='e') ) {s = 73;}

                        else if ( (LA25_68=='.'||(LA25_68>='0' && LA25_68<='9')||(LA25_68>='A' && LA25_68<='Z')||LA25_68=='_'||(LA25_68>='a' && LA25_68<='d')||(LA25_68>='f' && LA25_68<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_68>='\u0000' && LA25_68<='\t')||(LA25_68>='\u000B' && LA25_68<='-')||LA25_68=='/'||(LA25_68>=':' && LA25_68<='@')||(LA25_68>='[' && LA25_68<='^')||LA25_68=='`'||(LA25_68>='{' && LA25_68<='|')||(LA25_68>='~' && LA25_68<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_68);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_28 = input.LA(1);

                         
                        int index25_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!getPropKey())) ) {s = 6;}

                        else if ( ((getPropKey())) ) {s = 50;}

                         
                        input.seek(index25_28);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_60 = input.LA(1);

                         
                        int index25_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_60>='0' && LA25_60<='9')) && ((!getPropKey()))) {s = 61;}

                        else s = 6;

                         
                        input.seek(index25_60);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA25_53 = input.LA(1);

                         
                        int index25_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_53>='0' && LA25_53<='9')) && ((!getPropKey()))) {s = 54;}

                        else s = 6;

                         
                        input.seek(index25_53);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA25_48 = input.LA(1);

                         
                        int index25_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_48>='0' && LA25_48<='9')) && ((!getPropKey()))) {s = 49;}

                        else s = 6;

                         
                        input.seek(index25_48);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA25_25 = input.LA(1);

                         
                        int index25_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!getPropKey())) ) {s = 44;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                         
                        input.seek(index25_25);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA25_38 = input.LA(1);

                         
                        int index25_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!getPropKey())) ) {s = 55;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                         
                        input.seek(index25_38);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA25_71 = input.LA(1);

                         
                        int index25_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((!getPropKey())))) ) {s = 75;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                         
                        input.seek(index25_71);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA25_79 = input.LA(1);

                         
                        int index25_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((!getPropKey())))) ) {s = 81;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                         
                        input.seek(index25_79);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA25_64 = input.LA(1);

                         
                        int index25_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((!getPropKey())))) ) {s = 69;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                         
                        input.seek(index25_64);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA25_37 = input.LA(1);

                         
                        int index25_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_37=='\t'||LA25_37==' ') && ((!getPropKey()))) {s = 37;}

                        else if ( ((LA25_37>='\u0000' && LA25_37<='\b')||(LA25_37>='\u000B' && LA25_37<='\u001F')||(LA25_37>='!' && LA25_37<='|')||(LA25_37>='~' && LA25_37<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 38;

                         
                        input.seek(index25_37);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA25_74 = input.LA(1);

                         
                        int index25_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((!getPropKey())))) ) {s = 78;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                         
                        input.seek(index25_74);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA25_17 = input.LA(1);

                         
                        int index25_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(((!getPropKey())))) ) {s = 35;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                         
                        input.seek(index25_17);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA25_67 = input.LA(1);

                         
                        int index25_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_67=='n') ) {s = 72;}

                        else s = 6;

                         
                        input.seek(index25_67);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA25_72 = input.LA(1);

                         
                        int index25_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_72=='g') ) {s = 76;}

                        else s = 6;

                         
                        input.seek(index25_72);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_7>='\u0000' && LA25_7<='\t')||(LA25_7>='\u000B' && LA25_7<='|')||(LA25_7>='~' && LA25_7<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 28;

                         
                        input.seek(index25_7);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA25_24 = input.LA(1);

                         
                        int index25_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_24>='\u0000' && LA25_24<='\b')||(LA25_24>='\u000B' && LA25_24<='\u001F')||(LA25_24>='!' && LA25_24<='|')||(LA25_24>='~' && LA25_24<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else if ( (LA25_24=='\t'||LA25_24==' ') && ((!getPropKey()))) {s = 24;}

                        else s = 25;

                         
                        input.seek(index25_24);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA25_21 = input.LA(1);

                         
                        int index25_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_21=='t') ) {s = 42;}

                        else s = 6;

                         
                        input.seek(index25_21);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA25_42 = input.LA(1);

                         
                        int index25_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_42=='r') ) {s = 59;}

                        else s = 6;

                         
                        input.seek(index25_42);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA25_59 = input.LA(1);

                         
                        int index25_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_59=='i') ) {s = 67;}

                        else s = 6;

                         
                        input.seek(index25_59);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA25_61 = input.LA(1);

                         
                        int index25_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_61>='\u0000' && LA25_61<='\b')||(LA25_61>='\u000B' && LA25_61<='\u001F')||(LA25_61>='!' && LA25_61<='/')||(LA25_61>=':' && LA25_61<='|')||(LA25_61>='~' && LA25_61<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else if ( (LA25_61=='\t'||LA25_61==' ') && ((!getPropKey()))) {s = 47;}

                        else if ( ((LA25_61>='0' && LA25_61<='9')) && ((!getPropKey()))) {s = 61;}

                        else s = 38;

                         
                        input.seek(index25_61);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA25_41 = input.LA(1);

                         
                        int index25_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_41=='l') ) {s = 58;}

                        else s = 6;

                         
                        input.seek(index25_41);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA25_58 = input.LA(1);

                         
                        int index25_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_58=='e') ) {s = 66;}

                        else s = 6;

                         
                        input.seek(index25_58);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA25_18 = input.LA(1);

                         
                        int index25_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_18=='E'||LA25_18=='e') && ((!getPropKey()))) {s = 36;}

                        else if ( (LA25_18=='\t'||LA25_18==' ') && ((!getPropKey()))) {s = 37;}

                        else if ( ((LA25_18>='0' && LA25_18<='9')) && ((!getPropKey()))) {s = 18;}

                        else if ( ((LA25_18>='\u0000' && LA25_18<='\b')||(LA25_18>='\u000B' && LA25_18<='\u001F')||(LA25_18>='!' && LA25_18<='/')||(LA25_18>=':' && LA25_18<='D')||(LA25_18>='F' && LA25_18<='d')||(LA25_18>='f' && LA25_18<='|')||(LA25_18>='~' && LA25_18<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 38;

                         
                        input.seek(index25_18);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA25_13 = input.LA(1);

                         
                        int index25_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_13=='.'||(LA25_13>='0' && LA25_13<='9')||(LA25_13>='A' && LA25_13<='Z')||LA25_13=='_'||(LA25_13>='a' && LA25_13<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_13>='\u0000' && LA25_13<='\t')||(LA25_13>='\u000B' && LA25_13<='-')||LA25_13=='/'||(LA25_13>=':' && LA25_13<='@')||(LA25_13>='[' && LA25_13<='^')||LA25_13=='`'||(LA25_13>='{' && LA25_13<='|')||(LA25_13>='~' && LA25_13<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_13);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA25_40 = input.LA(1);

                         
                        int index25_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_40=='o') ) {s = 57;}

                        else s = 6;

                         
                        input.seek(index25_40);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA25_65 = input.LA(1);

                         
                        int index25_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_65=='t') ) {s = 70;}

                        else s = 6;

                         
                        input.seek(index25_65);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA25_57 = input.LA(1);

                         
                        int index25_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_57=='a') ) {s = 65;}

                        else s = 6;

                         
                        input.seek(index25_57);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA25_8 = input.LA(1);

                         
                        int index25_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_8>='\u0000' && LA25_8<='\t')||(LA25_8>='\u000B' && LA25_8<='|')||(LA25_8>='~' && LA25_8<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 29;

                         
                        input.seek(index25_8);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA25_15 = input.LA(1);

                         
                        int index25_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_15=='.'||(LA25_15>='0' && LA25_15<='9')||(LA25_15>='A' && LA25_15<='Z')||LA25_15=='_'||(LA25_15>='a' && LA25_15<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_15>='\u0000' && LA25_15<='\t')||(LA25_15>='\u000B' && LA25_15<='-')||LA25_15=='/'||(LA25_15>=':' && LA25_15<='@')||(LA25_15>='[' && LA25_15<='^')||LA25_15=='`'||(LA25_15>='{' && LA25_15<='|')||(LA25_15>='~' && LA25_15<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_15);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA25_19 = input.LA(1);

                         
                        int index25_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_19=='n') ) {s = 39;}

                        else s = 6;

                         
                        input.seek(index25_19);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_4>='0' && LA25_4<='9')) && ((!getPropKey()))) {s = 5;}

                        else if ( (LA25_4=='\t'||LA25_4==' ') ) {s = 4;}

                        else if ( (LA25_4=='.') && ((!getPropKey()))) {s = 23;}

                        else if ( ((LA25_4>='\u0000' && LA25_4<='\b')||(LA25_4>='\u000B' && LA25_4<='\u001F')||(LA25_4>='!' && LA25_4<='-')||LA25_4=='/'||(LA25_4>=':' && LA25_4<='|')||(LA25_4>='~' && LA25_4<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 22;

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA25_39 = input.LA(1);

                         
                        int index25_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_39=='t') ) {s = 56;}

                        else s = 6;

                         
                        input.seek(index25_39);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA25_2 = input.LA(1);

                         
                        int index25_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_2>='\u0000' && LA25_2<='\t')||(LA25_2>='\u000B' && LA25_2<='/')||(LA25_2>=':' && LA25_2<='|')||(LA25_2>='~' && LA25_2<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else if ( ((LA25_2>='0' && LA25_2<='9')) && ((!getPropKey()))) {s = 18;}

                        else s = 17;

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA25_62 = input.LA(1);

                         
                        int index25_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_62>='\u0000' && LA25_62<='\b')||(LA25_62>='\u000B' && LA25_62<='\u001F')||(LA25_62>='!' && LA25_62<='|')||(LA25_62>='~' && LA25_62<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else if ( (LA25_62=='\t'||LA25_62==' ') && ((!getPropKey()))) {s = 62;}

                        else s = 38;

                         
                        input.seek(index25_62);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA25_56 = input.LA(1);

                         
                        int index25_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_56>='\u0000' && LA25_56<='\t')||(LA25_56>='\u000B' && LA25_56<='|')||(LA25_56>='~' && LA25_56<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 64;

                         
                        input.seek(index25_56);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_1=='a') ) {s = 14;}

                        else if ( (LA25_1=='.'||(LA25_1>='0' && LA25_1<='9')||(LA25_1>='A' && LA25_1<='Z')||LA25_1=='_'||(LA25_1>='b' && LA25_1<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_1>='\u0000' && LA25_1<='\t')||(LA25_1>='\u000B' && LA25_1<='-')||LA25_1=='/'||(LA25_1>=':' && LA25_1<='@')||(LA25_1>='[' && LA25_1<='^')||LA25_1=='`'||(LA25_1>='{' && LA25_1<='|')||(LA25_1>='~' && LA25_1<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA25_23 = input.LA(1);

                         
                        int index25_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_23>='0' && LA25_23<='9')) && ((!getPropKey()))) {s = 18;}

                        else s = 6;

                         
                        input.seek(index25_23);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA25_9 = input.LA(1);

                         
                        int index25_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_9=='\n') && ((!getPropKey()))) {s = 30;}

                        else if ( (LA25_9=='\r') && ((!getPropKey()))) {s = 9;}

                        else s = 6;

                         
                        input.seek(index25_9);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA25_0 = input.LA(1);

                         
                        int index25_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_0=='p') ) {s = 1;}

                        else if ( (LA25_0=='.') ) {s = 2;}

                        else if ( (LA25_0==':') ) {s = 3;}

                        else if ( (LA25_0=='\t'||LA25_0==' ') ) {s = 4;}

                        else if ( ((LA25_0>='0' && LA25_0<='9')) && ((!getPropKey()))) {s = 5;}

                        else if ( (LA25_0=='=') && (((!getPropKey())||(getPropKey())))) {s = 7;}

                        else if ( (LA25_0=='{') && (((!getPropKey())||(getPropKey())))) {s = 8;}

                        else if ( (LA25_0=='\r') && ((!getPropKey()))) {s = 9;}

                        else if ( (LA25_0=='}') ) {s = 10;}

                        else if ( (LA25_0=='r') && (((!getPropKey())||(getPropKey())))) {s = 11;}

                        else if ( (LA25_0=='\n') && (((!getPropKey())||(getPropKey())))) {s = 12;}

                        else if ( ((LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='o')||LA25_0=='q'||(LA25_0>='s' && LA25_0<='z')) && (((!getPropKey())||(getPropKey())))) {s = 13;}

                        else s = 6;

                         
                        input.seek(index25_0);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA25_26 = input.LA(1);

                         
                        int index25_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_26>='0' && LA25_26<='9')) && ((!getPropKey()))) {s = 45;}

                        else if ( (LA25_26=='E'||LA25_26=='e') && ((!getPropKey()))) {s = 46;}

                        else if ( (LA25_26=='\t'||LA25_26==' ') && ((!getPropKey()))) {s = 47;}

                        else if ( ((LA25_26>='\u0000' && LA25_26<='\b')||(LA25_26>='\u000B' && LA25_26<='\u001F')||(LA25_26>='!' && LA25_26<='/')||(LA25_26>=':' && LA25_26<='D')||(LA25_26>='F' && LA25_26<='d')||(LA25_26>='f' && LA25_26<='|')||(LA25_26>='~' && LA25_26<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 38;

                         
                        input.seek(index25_26);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA25_77 = input.LA(1);

                         
                        int index25_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!((((!getPropKey())||(getPropKey()))))) ) {s = 80;}

                        else if ( ((!getPropKey())) ) {s = 6;}

                        else if ( ((getPropKey())) ) {s = 34;}

                         
                        input.seek(index25_77);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA25_70 = input.LA(1);

                         
                        int index25_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_70>='\u0000' && LA25_70<='\t')||(LA25_70>='\u000B' && LA25_70<='|')||(LA25_70>='~' && LA25_70<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 74;

                         
                        input.seek(index25_70);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA25_31 = input.LA(1);

                         
                        int index25_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_31=='r') && (((!getPropKey())||(getPropKey())))) {s = 31;}

                        else if ( (LA25_31=='\n') && ((getPropKey()))) {s = 32;}

                        else if ( (LA25_31=='.'||(LA25_31>='0' && LA25_31<='9')||(LA25_31>='A' && LA25_31<='Z')||LA25_31=='_'||(LA25_31>='a' && LA25_31<='q')||(LA25_31>='s' && LA25_31<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_31>='\u0000' && LA25_31<='\t')||(LA25_31>='\u000B' && LA25_31<='-')||LA25_31=='/'||(LA25_31>=':' && LA25_31<='@')||(LA25_31>='[' && LA25_31<='^')||LA25_31=='`'||(LA25_31>='{' && LA25_31<='|')||(LA25_31>='~' && LA25_31<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_31);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA25_22 = input.LA(1);

                         
                        int index25_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((!getPropKey())) ) {s = 6;}

                        else if ( (true) ) {s = 43;}

                         
                        input.seek(index25_22);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_3=='i') ) {s = 19;}

                        else if ( (LA25_3=='f') ) {s = 20;}

                        else if ( (LA25_3=='s') ) {s = 21;}

                        else s = 6;

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA25_11 = input.LA(1);

                         
                        int index25_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_11=='r') && (((!getPropKey())||(getPropKey())))) {s = 31;}

                        else if ( (LA25_11=='\n') && ((getPropKey()))) {s = 32;}

                        else if ( (LA25_11=='.'||(LA25_11>='0' && LA25_11<='9')||(LA25_11>='A' && LA25_11<='Z')||LA25_11=='_'||(LA25_11>='a' && LA25_11<='q')||(LA25_11>='s' && LA25_11<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_11>='\u0000' && LA25_11<='\t')||(LA25_11>='\u000B' && LA25_11<='-')||LA25_11=='/'||(LA25_11>=':' && LA25_11<='@')||(LA25_11>='[' && LA25_11<='^')||LA25_11=='`'||(LA25_11>='{' && LA25_11<='|')||(LA25_11>='~' && LA25_11<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 16;

                         
                        input.seek(index25_11);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA25_66 = input.LA(1);

                         
                        int index25_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_66>='\u0000' && LA25_66<='\t')||(LA25_66>='\u000B' && LA25_66<='|')||(LA25_66>='~' && LA25_66<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 71;

                         
                        input.seek(index25_66);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA25_54 = input.LA(1);

                         
                        int index25_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_54=='\t'||LA25_54==' ') && ((!getPropKey()))) {s = 37;}

                        else if ( ((LA25_54>='0' && LA25_54<='9')) && ((!getPropKey()))) {s = 54;}

                        else if ( ((LA25_54>='\u0000' && LA25_54<='\b')||(LA25_54>='\u000B' && LA25_54<='\u001F')||(LA25_54>='!' && LA25_54<='/')||(LA25_54>=':' && LA25_54<='|')||(LA25_54>='~' && LA25_54<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 38;

                         
                        input.seek(index25_54);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA25_20 = input.LA(1);

                         
                        int index25_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_20=='l') ) {s = 40;}

                        else if ( (LA25_20=='i') ) {s = 41;}

                        else s = 6;

                         
                        input.seek(index25_20);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA25_45 = input.LA(1);

                         
                        int index25_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_45=='E'||LA25_45=='e') && ((!getPropKey()))) {s = 46;}

                        else if ( (LA25_45=='\t'||LA25_45==' ') && ((!getPropKey()))) {s = 47;}

                        else if ( ((LA25_45>='0' && LA25_45<='9')) && ((!getPropKey()))) {s = 45;}

                        else if ( ((LA25_45>='\u0000' && LA25_45<='\b')||(LA25_45>='\u000B' && LA25_45<='\u001F')||(LA25_45>='!' && LA25_45<='/')||(LA25_45>=':' && LA25_45<='D')||(LA25_45>='F' && LA25_45<='d')||(LA25_45>='f' && LA25_45<='|')||(LA25_45>='~' && LA25_45<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 38;

                         
                        input.seek(index25_45);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA25_73 = input.LA(1);

                         
                        int index25_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_73=='.'||(LA25_73>='0' && LA25_73<='9')||(LA25_73>='A' && LA25_73<='Z')||LA25_73=='_'||(LA25_73>='a' && LA25_73<='z')) && (((!getPropKey())||(getPropKey())))) {s = 15;}

                        else if ( ((LA25_73>='\u0000' && LA25_73<='\t')||(LA25_73>='\u000B' && LA25_73<='-')||LA25_73=='/'||(LA25_73>=':' && LA25_73<='@')||(LA25_73>='[' && LA25_73<='^')||LA25_73=='`'||(LA25_73>='{' && LA25_73<='|')||(LA25_73>='~' && LA25_73<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 77;

                         
                        input.seek(index25_73);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA25_76 = input.LA(1);

                         
                        int index25_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_76>='\u0000' && LA25_76<='\t')||(LA25_76>='\u000B' && LA25_76<='|')||(LA25_76>='~' && LA25_76<='\uFFFF')) && ((!getPropKey()))) {s = 6;}

                        else s = 79;

                         
                        input.seek(index25_76);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA25_27 = input.LA(1);

                         
                        int index25_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_27=='+'||LA25_27=='-') && ((!getPropKey()))) {s = 48;}

                        else if ( ((LA25_27>='0' && LA25_27<='9')) && ((!getPropKey()))) {s = 49;}

                        else s = 6;

                         
                        input.seek(index25_27);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA25_36 = input.LA(1);

                         
                        int index25_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_36=='+'||LA25_36=='-') && ((!getPropKey()))) {s = 53;}

                        else if ( ((LA25_36>='0' && LA25_36<='9')) && ((!getPropKey()))) {s = 54;}

                        else s = 6;

                         
                        input.seek(index25_36);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA25_46 = input.LA(1);

                         
                        int index25_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_46=='+'||LA25_46=='-') && ((!getPropKey()))) {s = 60;}

                        else if ( ((LA25_46>='0' && LA25_46<='9')) && ((!getPropKey()))) {s = 61;}

                        else s = 6;

                         
                        input.seek(index25_46);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}