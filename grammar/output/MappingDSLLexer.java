// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g 2010-05-28 12:19:01

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MappingDSLLexer extends Lexer {
    public static final int DIRECTION=26;
    public static final int FUNCTION=15;
    public static final int EXPONENT=28;
    public static final int PROC_CALL=7;
    public static final int OCTAL_ESC=32;
    public static final int FLOAT=24;
    public static final int ID=16;
    public static final int EOF=-1;
    public static final int COLOR=17;
    public static final int CONTEXT=4;
    public static final int FUNC_CALL=6;
    public static final int RAW=13;
    public static final int T__51=51;
    public static final int ESC_SEQ=29;
    public static final int T__52=52;
    public static final int IMAGE=10;
    public static final int OFFSET=8;
    public static final int RECTANGLE=11;
    public static final int PLUS=20;
    public static final int COORD=9;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int DASH=19;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int UNICODE_ESC=31;
    public static final int HEX_DIGIT=30;
    public static final int INT=18;
    public static final int MULT=21;
    public static final int PROCEDURE=14;
    public static final int WS=27;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int AREA_ACTION=5;
    public static final int T__36=36;
    public static final int CIRCLE=12;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int OP=23;
    public static final int DIV=22;
    public static final int STRING=25;

    // delegates
    // delegators

    public MappingDSLLexer() {;} 
    public MappingDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MappingDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g"; }

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:3:7: ( ':' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:3:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:4:7: ( 'outline' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:4:9: 'outline'
            {
            match("outline"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:5:7: ( 'inline' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:5:9: 'inline'
            {
            match("inline"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:6:7: ( ';' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:6:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:7:7: ( '(' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:7:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:8:7: ( ')' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:8:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:9:7: ( ',' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:9:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:10:7: ( 'raw' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:10:9: 'raw'
            {
            match("raw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:11:7: ( '.' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:11:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:12:7: ( 'hex' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:12:9: 'hex'
            {
            match("hex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:13:7: ( 'square' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:13:9: 'square'
            {
            match("square"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:14:7: ( 'free' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:14:9: 'free'
            {
            match("free"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:15:7: ( 'size' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:15:9: 'size'
            {
            match("size"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:16:7: ( 'each' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:16:9: 'each'
            {
            match("each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:17:7: ( 'within' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:17:9: 'within'
            {
            match("within"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:18:7: ( 'beside' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:18:9: 'beside'
            {
            match("beside"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:19:7: ( 'proc' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:19:9: 'proc'
            {
            match("proc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:20:7: ( '{' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:20:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:21:7: ( '}' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:21:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:22:7: ( 'func' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:22:9: 'func'
            {
            match("func"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "DASH"
    public final void mDASH() throws RecognitionException {
        try {
            int _type = DASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:87:6: ( '-' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:87:8: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DASH"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:90:6: ( '+' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:90:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:93:6: ( '*' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:93:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:96:5: ( '/' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:96:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "OP"
    public final void mOP() throws RecognitionException {
        try {
            int _type = OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:99:4: ( ( '%' | '<' | '>' | '!' ) )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:99:6: ( '%' | '<' | '>' | '!' )
            {
            if ( input.LA(1)=='!'||input.LA(1)=='%'||input.LA(1)=='<'||input.LA(1)=='>' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP"

    // $ANTLR start "DIRECTION"
    public final void mDIRECTION() throws RecognitionException {
        try {
            int _type = DIRECTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:2: ( ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' ) )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:4: ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' )
            {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:4: ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' )
            int alt1=8;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:5: 'NW'
                    {
                    match("NW"); 


                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:10: 'N'
                    {
                    match('N'); 

                    }
                    break;
                case 3 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:14: 'E'
                    {
                    match('E'); 

                    }
                    break;
                case 4 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:18: 'W'
                    {
                    match('W'); 

                    }
                    break;
                case 5 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:22: 'S'
                    {
                    match('S'); 

                    }
                    break;
                case 6 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:26: 'NE'
                    {
                    match("NE"); 


                    }
                    break;
                case 7 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:31: 'SE'
                    {
                    match("SE"); 


                    }
                    break;
                case 8 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:103:36: 'SW'
                    {
                    match("SW"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIRECTION"

    // $ANTLR start "COLOR"
    public final void mCOLOR() throws RecognitionException {
        try {
            int _type = COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:105:7: ( '#' ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:105:9: '#' ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' )
            {
            match('#'); 
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLOR"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:108:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:108:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:108:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:111:5: ( ( '0' .. '9' )+ )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:111:7: ( '0' .. '9' )+
            {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:111:7: ( '0' .. '9' )+
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
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:111:7: '0' .. '9'
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:114:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:114:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:9: ( '0' .. '9' )+
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
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:10: '0' .. '9'
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
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:25: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:37: ( EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:122:37: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:123:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:123:13: ( '0' .. '9' )+
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
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:123:14: '0' .. '9'
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

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:123:25: ( EXPONENT )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:123:25: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:124:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:124:9: ( '0' .. '9' )+
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
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:124:10: '0' .. '9'
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

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:128:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:128:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:128:22: ( '+' | '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='+'||LA11_0=='-') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:
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

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:128:33: ( '0' .. '9' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:128:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:131:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:131:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:131:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\\') ) {
                    alt13=1;
                }
                else if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:131:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:131:24: ~ ( '\\\\' | '\"' )
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
            	    break loop13;
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

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:135:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:135:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:139:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt14=1;
                    }
                    break;
                case 'u':
                    {
                    alt14=2;
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
                    alt14=3;
                    }
                    break;
                default:
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
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:139:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:140:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:141:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\\') ) {
                int LA15_1 = input.LA(2);

                if ( ((LA15_1>='0' && LA15_1<='3')) ) {
                    int LA15_2 = input.LA(3);

                    if ( ((LA15_2>='0' && LA15_2<='7')) ) {
                        int LA15_5 = input.LA(4);

                        if ( ((LA15_5>='0' && LA15_5<='7')) ) {
                            alt15=1;
                        }
                        else {
                            alt15=2;}
                    }
                    else {
                        alt15=3;}
                }
                else if ( ((LA15_1>='4' && LA15_1<='7')) ) {
                    int LA15_3 = input.LA(3);

                    if ( ((LA15_3>='0' && LA15_3<='7')) ) {
                        alt15=2;
                    }
                    else {
                        alt15=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:14: ( '0' .. '3' )
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:25: ( '0' .. '7' )
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:36: ( '0' .. '7' )
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:146:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:147:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:147:14: ( '0' .. '7' )
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:147:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:147:25: ( '0' .. '7' )
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:147:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:148:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:148:14: ( '0' .. '7' )
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:148:15: '0' .. '7'
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
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:153:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:153:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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

    public void mTokens() throws RecognitionException {
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:8: ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | DASH | PLUS | MULT | DIV | OP | DIRECTION | COLOR | ID | INT | WS | FLOAT | STRING )
        int alt16=32;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:10: T__33
                {
                mT__33(); 

                }
                break;
            case 2 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:16: T__34
                {
                mT__34(); 

                }
                break;
            case 3 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:22: T__35
                {
                mT__35(); 

                }
                break;
            case 4 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:28: T__36
                {
                mT__36(); 

                }
                break;
            case 5 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:34: T__37
                {
                mT__37(); 

                }
                break;
            case 6 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:40: T__38
                {
                mT__38(); 

                }
                break;
            case 7 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:46: T__39
                {
                mT__39(); 

                }
                break;
            case 8 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:52: T__40
                {
                mT__40(); 

                }
                break;
            case 9 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:58: T__41
                {
                mT__41(); 

                }
                break;
            case 10 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:64: T__42
                {
                mT__42(); 

                }
                break;
            case 11 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:70: T__43
                {
                mT__43(); 

                }
                break;
            case 12 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:76: T__44
                {
                mT__44(); 

                }
                break;
            case 13 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:82: T__45
                {
                mT__45(); 

                }
                break;
            case 14 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:88: T__46
                {
                mT__46(); 

                }
                break;
            case 15 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:94: T__47
                {
                mT__47(); 

                }
                break;
            case 16 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:100: T__48
                {
                mT__48(); 

                }
                break;
            case 17 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:106: T__49
                {
                mT__49(); 

                }
                break;
            case 18 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:112: T__50
                {
                mT__50(); 

                }
                break;
            case 19 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:118: T__51
                {
                mT__51(); 

                }
                break;
            case 20 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:124: T__52
                {
                mT__52(); 

                }
                break;
            case 21 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:130: DASH
                {
                mDASH(); 

                }
                break;
            case 22 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:135: PLUS
                {
                mPLUS(); 

                }
                break;
            case 23 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:140: MULT
                {
                mMULT(); 

                }
                break;
            case 24 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:145: DIV
                {
                mDIV(); 

                }
                break;
            case 25 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:149: OP
                {
                mOP(); 

                }
                break;
            case 26 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:152: DIRECTION
                {
                mDIRECTION(); 

                }
                break;
            case 27 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:162: COLOR
                {
                mCOLOR(); 

                }
                break;
            case 28 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:168: ID
                {
                mID(); 

                }
                break;
            case 29 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:171: INT
                {
                mINT(); 

                }
                break;
            case 30 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:175: WS
                {
                mWS(); 

                }
                break;
            case 31 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:178: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 32 :
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:1:184: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA1_eotS =
        "\1\uffff\1\7\2\uffff\1\12\6\uffff";
    static final String DFA1_eofS =
        "\13\uffff";
    static final String DFA1_minS =
        "\2\105\2\uffff\1\105\6\uffff";
    static final String DFA1_maxS =
        "\2\127\2\uffff\1\127\6\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\1\1\6\1\2\1\7\1\10\1\5";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\10\uffff\1\1\4\uffff\1\4\3\uffff\1\3",
            "\1\6\21\uffff\1\5",
            "",
            "",
            "\1\10\21\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "103:4: ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' )";
        }
    }
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
            return "121:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA16_eotS =
        "\2\uffff\2\35\4\uffff\1\35\1\44\7\35\7\uffff\4\61\2\uffff\1\64\2"+
        "\uffff\3\35\2\uffff\11\35\2\61\1\uffff\2\61\1\uffff\2\35\1\103\1"+
        "\104\12\35\2\uffff\1\35\1\120\1\121\1\122\1\123\2\35\1\126\3\35"+
        "\4\uffff\2\35\1\uffff\1\35\1\135\1\136\1\137\1\140\1\141\5\uffff";
    static final String DFA16_eofS =
        "\142\uffff";
    static final String DFA16_minS =
        "\1\11\1\uffff\1\165\1\156\4\uffff\1\141\1\60\1\145\1\151\1\162\1"+
        "\141\1\151\1\145\1\162\7\uffff\4\60\2\uffff\1\56\2\uffff\1\164\1"+
        "\154\1\167\2\uffff\1\170\1\165\1\172\1\145\1\156\1\143\1\164\1\163"+
        "\1\157\2\60\1\uffff\2\60\1\uffff\1\154\1\151\2\60\1\141\2\145\1"+
        "\143\2\150\1\151\1\143\1\151\1\156\2\uffff\1\162\4\60\1\151\1\144"+
        "\1\60\1\156\2\145\4\uffff\1\156\1\145\1\uffff\1\145\5\60\5\uffff";
    static final String DFA16_maxS =
        "\1\175\1\uffff\1\165\1\156\4\uffff\1\141\1\71\1\145\1\161\1\165"+
        "\1\141\1\151\1\145\1\162\7\uffff\4\172\2\uffff\1\145\2\uffff\1\164"+
        "\1\154\1\167\2\uffff\1\170\1\165\1\172\1\145\1\156\1\143\1\164\1"+
        "\163\1\157\2\172\1\uffff\2\172\1\uffff\1\154\1\151\2\172\1\141\2"+
        "\145\1\143\2\150\1\151\1\143\1\151\1\156\2\uffff\1\162\4\172\1\151"+
        "\1\144\1\172\1\156\2\145\4\uffff\1\156\1\145\1\uffff\1\145\5\172"+
        "\5\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\11\uffff\1\22\1\23\1\25\1\26"+
        "\1\27\1\30\1\31\4\uffff\1\33\1\34\1\uffff\1\36\1\40\3\uffff\1\11"+
        "\1\37\13\uffff\1\32\2\uffff\1\35\16\uffff\1\10\1\12\13\uffff\1\15"+
        "\1\14\1\24\1\16\2\uffff\1\21\6\uffff\1\3\1\13\1\17\1\20\1\2";
    static final String DFA16_specialS =
        "\142\uffff}>";
    static final String[] DFA16_transitionS = {
            "\2\37\2\uffff\1\37\22\uffff\1\37\1\27\1\40\1\34\1\uffff\1\27"+
            "\2\uffff\1\5\1\6\1\25\1\24\1\7\1\23\1\11\1\26\12\36\1\1\1\4"+
            "\1\27\1\uffff\1\27\2\uffff\4\35\1\31\10\35\1\30\4\35\1\33\3"+
            "\35\1\32\3\35\4\uffff\1\35\1\uffff\1\35\1\17\2\35\1\15\1\14"+
            "\1\35\1\12\1\3\5\35\1\2\1\20\1\35\1\10\1\13\3\35\1\16\3\35\1"+
            "\21\1\uffff\1\22",
            "",
            "\1\41",
            "\1\42",
            "",
            "",
            "",
            "",
            "\1\43",
            "\12\45",
            "\1\46",
            "\1\50\7\uffff\1\47",
            "\1\51\2\uffff\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\35\7\uffff\4\35\1\60\21\35\1\57\3\35\4\uffff\1\35\1\uffff"+
            "\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\4\35\1\62\21\35\1\63\3\35\4\uffff\1\35\1\uffff"+
            "\32\35",
            "",
            "",
            "\1\45\1\uffff\12\36\13\uffff\1\45\37\uffff\1\45",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\101",
            "\1\102",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "",
            "\1\117",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\124",
            "\1\125",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\127",
            "\1\130",
            "\1\131",
            "",
            "",
            "",
            "",
            "\1\132",
            "\1\133",
            "",
            "\1\134",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "",
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
            return "1:1: Tokens : ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | DASH | PLUS | MULT | DIV | OP | DIRECTION | COLOR | ID | INT | WS | FLOAT | STRING );";
        }
    }
 

}