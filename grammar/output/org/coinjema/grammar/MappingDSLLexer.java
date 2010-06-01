// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g 2010-05-30 22:54:18

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MappingDSLLexer extends Lexer {
    public static final int DIRECTION=28;
    public static final int FUNCTION=15;
    public static final int EXPONENT=30;
    public static final int PROC_CALL=7;
    public static final int OCTAL_ESC=34;
    public static final int ARGLIST=16;
    public static final int FLOAT=22;
    public static final int ID=18;
    public static final int EOF=-1;
    public static final int COLOR=19;
    public static final int CONTEXT=4;
    public static final int FUNC_CALL=6;
    public static final int T__55=55;
    public static final int RAW=13;
    public static final int T__51=51;
    public static final int ESC_SEQ=31;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int OFFSET=8;
    public static final int IMAGE=10;
    public static final int RECTANGLE=11;
    public static final int PLUS=21;
    public static final int BODY=17;
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
    public static final int DASH=20;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int UNICODE_ESC=33;
    public static final int HEX_DIGIT=32;
    public static final int INT=25;
    public static final int MULT=23;
    public static final int PROCEDURE=14;
    public static final int WS=29;
    public static final int T__35=35;
    public static final int AREA_ACTION=5;
    public static final int T__36=36;
    public static final int CIRCLE=12;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int OP=26;
    public static final int DIV=24;
    public static final int STRING=27;

    // delegates
    // delegators

    public MappingDSLLexer() {;} 
    public MappingDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MappingDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g"; }

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:3:7: ( ':' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:3:9: ':'
            {
            match(':'); 

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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:4:7: ( 'outline' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:4:9: 'outline'
            {
            match("outline"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:5:7: ( 'inline' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:5:9: 'inline'
            {
            match("inline"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:6:7: ( ';' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:6:9: ';'
            {
            match(';'); 

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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:7:7: ( '(' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:7:9: '('
            {
            match('('); 

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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:8:7: ( ')' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:8:9: ')'
            {
            match(')'); 

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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:9:7: ( ',' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:9:9: ','
            {
            match(','); 

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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:10:7: ( '.' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:10:9: '.'
            {
            match('.'); 

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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:11:7: ( 'hex' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:11:9: 'hex'
            {
            match("hex"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:12:7: ( 'square' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:12:9: 'square'
            {
            match("square"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:13:7: ( 'free' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:13:9: 'free'
            {
            match("free"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:14:7: ( 'size' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:14:9: 'size'
            {
            match("size"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:15:7: ( 'each' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:15:9: 'each'
            {
            match("each"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:16:7: ( 'within' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:16:9: 'within'
            {
            match("within"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:17:7: ( 'beside' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:17:9: 'beside'
            {
            match("beside"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:18:7: ( 'proc' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:18:9: 'proc'
            {
            match("proc"); 


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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:19:7: ( '{' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:19:9: '{'
            {
            match('{'); 

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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:20:7: ( '}' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:20:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:21:7: ( 'func' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:21:9: 'func'
            {
            match("func"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:22:7: ( '[' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:22:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:23:7: ( ']' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:23:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "DASH"
    public final void mDASH() throws RecognitionException {
        try {
            int _type = DASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:78:6: ( '-' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:78:8: '-'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:81:6: ( '+' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:81:8: '+'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:84:6: ( '*' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:84:8: '*'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:87:5: ( '/' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:87:7: '/'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:90:4: ( ( '%' | '<' | '>' | '!' ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:90:6: ( '%' | '<' | '>' | '!' )
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:2: ( ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:4: ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' )
            {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:4: ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' )
            int alt1=8;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:5: 'NW'
                    {
                    match("NW"); 


                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:10: 'N'
                    {
                    match('N'); 

                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:14: 'E'
                    {
                    match('E'); 

                    }
                    break;
                case 4 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:18: 'W'
                    {
                    match('W'); 

                    }
                    break;
                case 5 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:22: 'S'
                    {
                    match('S'); 

                    }
                    break;
                case 6 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:26: 'NE'
                    {
                    match("NE"); 


                    }
                    break;
                case 7 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:31: 'SE'
                    {
                    match("SE"); 


                    }
                    break;
                case 8 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:94:36: 'SW'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:96:7: ( '#' ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:96:9: '#' ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' ) ( '0' .. '9' | 'a' .. 'f' )
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:99:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:99:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:99:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:102:5: ( ( '0' .. '9' )+ )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:102:7: ( '0' .. '9' )+
            {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:102:7: ( '0' .. '9' )+
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
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:102:7: '0' .. '9'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:105:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:105:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:9: ( '0' .. '9' )+
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
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:10: '0' .. '9'
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
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:25: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:37: ( EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:113:37: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:114:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:114:13: ( '0' .. '9' )+
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
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:114:14: '0' .. '9'
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

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:114:25: ( EXPONENT )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:114:25: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:115:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:115:9: ( '0' .. '9' )+
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
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:115:10: '0' .. '9'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:119:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:119:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:119:22: ( '+' | '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='+'||LA11_0=='-') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:
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

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:119:33: ( '0' .. '9' )+
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
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:119:34: '0' .. '9'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:122:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:122:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:122:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
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
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:122:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:122:24: ~ ( '\\\\' | '\"' )
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:126:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:126:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:130:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
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
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:130:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:131:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:132:9: OCTAL_ESC
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
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
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:14: ( '0' .. '3' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:25: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:36: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:137:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:138:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:138:14: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:138:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:138:25: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:138:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:139:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:139:14: ( '0' .. '7' )
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:139:15: '0' .. '7'
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
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:144:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:144:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:8: ( T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | DASH | PLUS | MULT | DIV | OP | DIRECTION | COLOR | ID | INT | WS | FLOAT | STRING )
        int alt16=33;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:10: T__35
                {
                mT__35(); 

                }
                break;
            case 2 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:16: T__36
                {
                mT__36(); 

                }
                break;
            case 3 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:22: T__37
                {
                mT__37(); 

                }
                break;
            case 4 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:28: T__38
                {
                mT__38(); 

                }
                break;
            case 5 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:34: T__39
                {
                mT__39(); 

                }
                break;
            case 6 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:40: T__40
                {
                mT__40(); 

                }
                break;
            case 7 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:46: T__41
                {
                mT__41(); 

                }
                break;
            case 8 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:52: T__42
                {
                mT__42(); 

                }
                break;
            case 9 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:58: T__43
                {
                mT__43(); 

                }
                break;
            case 10 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:64: T__44
                {
                mT__44(); 

                }
                break;
            case 11 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:70: T__45
                {
                mT__45(); 

                }
                break;
            case 12 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:76: T__46
                {
                mT__46(); 

                }
                break;
            case 13 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:82: T__47
                {
                mT__47(); 

                }
                break;
            case 14 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:88: T__48
                {
                mT__48(); 

                }
                break;
            case 15 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:94: T__49
                {
                mT__49(); 

                }
                break;
            case 16 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:100: T__50
                {
                mT__50(); 

                }
                break;
            case 17 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:106: T__51
                {
                mT__51(); 

                }
                break;
            case 18 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:112: T__52
                {
                mT__52(); 

                }
                break;
            case 19 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:118: T__53
                {
                mT__53(); 

                }
                break;
            case 20 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:124: T__54
                {
                mT__54(); 

                }
                break;
            case 21 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:130: T__55
                {
                mT__55(); 

                }
                break;
            case 22 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:136: DASH
                {
                mDASH(); 

                }
                break;
            case 23 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:141: PLUS
                {
                mPLUS(); 

                }
                break;
            case 24 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:146: MULT
                {
                mMULT(); 

                }
                break;
            case 25 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:151: DIV
                {
                mDIV(); 

                }
                break;
            case 26 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:155: OP
                {
                mOP(); 

                }
                break;
            case 27 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:158: DIRECTION
                {
                mDIRECTION(); 

                }
                break;
            case 28 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:168: COLOR
                {
                mCOLOR(); 

                }
                break;
            case 29 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:174: ID
                {
                mID(); 

                }
                break;
            case 30 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:177: INT
                {
                mINT(); 

                }
                break;
            case 31 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:181: WS
                {
                mWS(); 

                }
                break;
            case 32 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:184: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 33 :
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:1:190: STRING
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
            return "94:4: ( 'NW' | 'N' | 'E' | 'W' | 'S' | 'NE' | 'SE' | 'SW' )";
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
            return "112:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA16_eotS =
        "\2\uffff\2\36\4\uffff\1\45\7\36\11\uffff\4\61\2\uffff\1\64\2\uffff"+
        "\2\36\2\uffff\11\36\2\61\1\uffff\2\61\1\uffff\2\36\1\102\12\36\1"+
        "\uffff\1\36\1\116\1\117\1\120\1\121\2\36\1\124\3\36\4\uffff\2\36"+
        "\1\uffff\1\36\1\133\1\134\1\135\1\136\1\137\5\uffff";
    static final String DFA16_eofS =
        "\140\uffff";
    static final String DFA16_minS =
        "\1\11\1\uffff\1\165\1\156\4\uffff\1\60\1\145\1\151\1\162\1\141\1"+
        "\151\1\145\1\162\11\uffff\4\60\2\uffff\1\56\2\uffff\1\164\1\154"+
        "\2\uffff\1\170\1\165\1\172\1\145\1\156\1\143\1\164\1\163\1\157\2"+
        "\60\1\uffff\2\60\1\uffff\1\154\1\151\1\60\1\141\2\145\1\143\2\150"+
        "\1\151\1\143\1\151\1\156\1\uffff\1\162\4\60\1\151\1\144\1\60\1\156"+
        "\2\145\4\uffff\1\156\1\145\1\uffff\1\145\5\60\5\uffff";
    static final String DFA16_maxS =
        "\1\175\1\uffff\1\165\1\156\4\uffff\1\71\1\145\1\161\1\165\1\141"+
        "\1\151\1\145\1\162\11\uffff\4\172\2\uffff\1\145\2\uffff\1\164\1"+
        "\154\2\uffff\1\170\1\165\1\172\1\145\1\156\1\143\1\164\1\163\1\157"+
        "\2\172\1\uffff\2\172\1\uffff\1\154\1\151\1\172\1\141\2\145\1\143"+
        "\2\150\1\151\1\143\1\151\1\156\1\uffff\1\162\4\172\1\151\1\144\1"+
        "\172\1\156\2\145\4\uffff\1\156\1\145\1\uffff\1\145\5\172\5\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\10\uffff\1\21\1\22\1\24\1\25"+
        "\1\26\1\27\1\30\1\31\1\32\4\uffff\1\34\1\35\1\uffff\1\37\1\41\2"+
        "\uffff\1\40\1\10\13\uffff\1\33\2\uffff\1\36\15\uffff\1\11\13\uffff"+
        "\1\14\1\13\1\23\1\15\2\uffff\1\20\6\uffff\1\3\1\12\1\16\1\17\1\2";
    static final String DFA16_specialS =
        "\140\uffff}>";
    static final String[] DFA16_transitionS = {
            "\2\40\2\uffff\1\40\22\uffff\1\40\1\30\1\41\1\35\1\uffff\1\30"+
            "\2\uffff\1\5\1\6\1\26\1\25\1\7\1\24\1\10\1\27\12\37\1\1\1\4"+
            "\1\30\1\uffff\1\30\2\uffff\4\36\1\32\10\36\1\31\4\36\1\34\3"+
            "\36\1\33\3\36\1\22\1\uffff\1\23\1\uffff\1\36\1\uffff\1\36\1"+
            "\16\2\36\1\14\1\13\1\36\1\11\1\3\5\36\1\2\1\17\2\36\1\12\3\36"+
            "\1\15\3\36\1\20\1\uffff\1\21",
            "",
            "\1\42",
            "\1\43",
            "",
            "",
            "",
            "",
            "\12\44",
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
            "",
            "",
            "\12\36\7\uffff\4\36\1\60\21\36\1\57\3\36\4\uffff\1\36\1\uffff"+
            "\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\4\36\1\62\21\36\1\63\3\36\4\uffff\1\36\1\uffff"+
            "\32\36",
            "",
            "",
            "\1\44\1\uffff\12\37\13\uffff\1\44\37\uffff\1\44",
            "",
            "",
            "\1\65",
            "\1\66",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\100",
            "\1\101",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "",
            "\1\115",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\122",
            "\1\123",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\125",
            "\1\126",
            "\1\127",
            "",
            "",
            "",
            "",
            "\1\130",
            "\1\131",
            "",
            "\1\132",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
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
            return "1:1: Tokens : ( T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | DASH | PLUS | MULT | DIV | OP | DIRECTION | COLOR | ID | INT | WS | FLOAT | STRING );";
        }
    }
 

}