// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g 2010-05-21 13:41:41

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ConfigDSLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING_PROP", "INT_PROP", "TREE_PROP", "PROPERTY", "PROP_NAME", "FLOAT_TYPE", "FILE_TYPE", "TEXT", "ID", "NEWLINE", "OPEN_TREE", "CLOSE_TREE", "COLON", "INTTYPE", "EQ", "INT", "FLOATTYPE", "FLOAT", "FILETYPE", "FILE_SEP", "STRINGTYPE", "UNICODE_ESC", "OCTAL_ESC", "ESC_SEQ", "EXPONENT", "COMMENT", "WS", "STRING", "CHAR", "HEX_DIGIT", "OTHER", "'package'", "'.'"
    };
    public static final int EXPONENT=28;
    public static final int FLOAT_TYPE=9;
    public static final int OTHER=34;
    public static final int CLOSE_TREE=15;
    public static final int FILETYPE=22;
    public static final int UNICODE_ESC=25;
    public static final int OCTAL_ESC=26;
    public static final int CHAR=32;
    public static final int INT_PROP=5;
    public static final int HEX_DIGIT=33;
    public static final int FLOAT=21;
    public static final int INT=19;
    public static final int TEXT=11;
    public static final int FILE_SEP=23;
    public static final int ID=12;
    public static final int OPEN_TREE=14;
    public static final int EOF=-1;
    public static final int COLON=16;
    public static final int WS=30;
    public static final int ESC_SEQ=27;
    public static final int T__35=35;
    public static final int NEWLINE=13;
    public static final int T__36=36;
    public static final int PROPERTY=7;
    public static final int FLOATTYPE=20;
    public static final int TREE_PROP=6;
    public static final int STRINGTYPE=24;
    public static final int FILE_TYPE=10;
    public static final int STRING_PROP=4;
    public static final int EQ=18;
    public static final int COMMENT=29;
    public static final int PROP_NAME=8;
    public static final int INTTYPE=17;
    public static final int STRING=31;

    // delegates
    // delegators


        public ConfigDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ConfigDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ConfigDSLParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g"; }


    public static class main_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:28:1: main : ( pckg )? ( config_tree )+ ;
    public final ConfigDSLParser.main_return main() throws RecognitionException {
        ConfigDSLParser.main_return retval = new ConfigDSLParser.main_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ConfigDSLParser.pckg_return pckg1 = null;

        ConfigDSLParser.config_tree_return config_tree2 = null;



        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:28:6: ( ( pckg )? ( config_tree )+ )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:28:8: ( pckg )? ( config_tree )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:28:8: ( pckg )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==35) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:28:8: pckg
                    {
                    pushFollow(FOLLOW_pckg_in_main66);
                    pckg1=pckg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pckg1.getTree());

                    }
                    break;

            }

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:28:14: ( config_tree )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:28:14: config_tree
            	    {
            	    pushFollow(FOLLOW_config_tree_in_main69);
            	    config_tree2=config_tree();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, config_tree2.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "main"

    public static class pckg_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pckg"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:1: pckg : 'package' ID ( '.' ID )* ( NEWLINE )+ ;
    public final ConfigDSLParser.pckg_return pckg() throws RecognitionException {
        ConfigDSLParser.pckg_return retval = new ConfigDSLParser.pckg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token ID4=null;
        Token char_literal5=null;
        Token ID6=null;
        Token NEWLINE7=null;

        CommonTree string_literal3_tree=null;
        CommonTree ID4_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree ID6_tree=null;
        CommonTree NEWLINE7_tree=null;

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:6: ( 'package' ID ( '.' ID )* ( NEWLINE )+ )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:8: 'package' ID ( '.' ID )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal3=(Token)match(input,35,FOLLOW_35_in_pckg78); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            adaptor.addChild(root_0, string_literal3_tree);
            }
            ID4=(Token)match(input,ID,FOLLOW_ID_in_pckg80); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID4_tree = (CommonTree)adaptor.create(ID4);
            adaptor.addChild(root_0, ID4_tree);
            }
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:21: ( '.' ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==36) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:22: '.' ID
            	    {
            	    char_literal5=(Token)match(input,36,FOLLOW_36_in_pckg83); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal5_tree = (CommonTree)adaptor.create(char_literal5);
            	    adaptor.addChild(root_0, char_literal5_tree);
            	    }
            	    ID6=(Token)match(input,ID,FOLLOW_ID_in_pckg85); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    ID6_tree = (CommonTree)adaptor.create(ID6);
            	    adaptor.addChild(root_0, ID6_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:31: ( NEWLINE )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==NEWLINE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:31: NEWLINE
            	    {
            	    NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_pckg89); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEWLINE7_tree = (CommonTree)adaptor.create(NEWLINE7);
            	    adaptor.addChild(root_0, NEWLINE7_tree);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pckg"

    public static class config_tree_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "config_tree"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:33:1: config_tree options {k=3; } : ( ID OPEN_TREE ( config_tree )* CLOSE_TREE -> ^( ( config_tree )* ) | ( ID )=>a= ID COLON INTTYPE EQ INT -> ^( INT ) | ( ID )=>a= ID COLON FLOATTYPE EQ FLOAT -> ^( FLOAT ) | ( ID )=>a= ID COLON FILETYPE EQ (b+= ID | b+= INT | b+= FILE_SEP )* -> ^( ( $b)* ) | a= ID ( COLON STRINGTYPE )? EQ rawtext -> ^() );
    public final ConfigDSLParser.config_tree_return config_tree() throws RecognitionException {
        ConfigDSLParser.config_tree_return retval = new ConfigDSLParser.config_tree_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token a=null;
        Token ID8=null;
        Token OPEN_TREE9=null;
        Token CLOSE_TREE11=null;
        Token COLON12=null;
        Token INTTYPE13=null;
        Token EQ14=null;
        Token INT15=null;
        Token COLON16=null;
        Token FLOATTYPE17=null;
        Token EQ18=null;
        Token FLOAT19=null;
        Token COLON20=null;
        Token FILETYPE21=null;
        Token EQ22=null;
        Token COLON23=null;
        Token STRINGTYPE24=null;
        Token EQ25=null;
        Token b=null;
        List list_b=null;
        ConfigDSLParser.config_tree_return config_tree10 = null;

        ConfigDSLParser.rawtext_return rawtext26 = null;


        CommonTree a_tree=null;
        CommonTree ID8_tree=null;
        CommonTree OPEN_TREE9_tree=null;
        CommonTree CLOSE_TREE11_tree=null;
        CommonTree COLON12_tree=null;
        CommonTree INTTYPE13_tree=null;
        CommonTree EQ14_tree=null;
        CommonTree INT15_tree=null;
        CommonTree COLON16_tree=null;
        CommonTree FLOATTYPE17_tree=null;
        CommonTree EQ18_tree=null;
        CommonTree FLOAT19_tree=null;
        CommonTree COLON20_tree=null;
        CommonTree FILETYPE21_tree=null;
        CommonTree EQ22_tree=null;
        CommonTree COLON23_tree=null;
        CommonTree STRINGTYPE24_tree=null;
        CommonTree EQ25_tree=null;
        CommonTree b_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_FILE_SEP=new RewriteRuleTokenStream(adaptor,"token FILE_SEP");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_OPEN_TREE=new RewriteRuleTokenStream(adaptor,"token OPEN_TREE");
        RewriteRuleTokenStream stream_CLOSE_TREE=new RewriteRuleTokenStream(adaptor,"token CLOSE_TREE");
        RewriteRuleTokenStream stream_INTTYPE=new RewriteRuleTokenStream(adaptor,"token INTTYPE");
        RewriteRuleTokenStream stream_FLOATTYPE=new RewriteRuleTokenStream(adaptor,"token FLOATTYPE");
        RewriteRuleTokenStream stream_STRINGTYPE=new RewriteRuleTokenStream(adaptor,"token STRINGTYPE");
        RewriteRuleTokenStream stream_FILETYPE=new RewriteRuleTokenStream(adaptor,"token FILETYPE");
        RewriteRuleSubtreeStream stream_config_tree=new RewriteRuleSubtreeStream(adaptor,"rule config_tree");
        RewriteRuleSubtreeStream stream_rawtext=new RewriteRuleSubtreeStream(adaptor,"rule rawtext");
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:23: ( ID OPEN_TREE ( config_tree )* CLOSE_TREE -> ^( ( config_tree )* ) | ( ID )=>a= ID COLON INTTYPE EQ INT -> ^( INT ) | ( ID )=>a= ID COLON FLOATTYPE EQ FLOAT -> ^( FLOAT ) | ( ID )=>a= ID COLON FILETYPE EQ (b+= ID | b+= INT | b+= FILE_SEP )* -> ^( ( $b)* ) | a= ID ( COLON STRINGTYPE )? EQ rawtext -> ^() )
            int alt8=5;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                switch ( input.LA(2) ) {
                case OPEN_TREE:
                    {
                    alt8=1;
                    }
                    break;
                case COLON:
                    {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3==INTTYPE) && (synpred1_ConfigDSL())) {
                        alt8=2;
                    }
                    else if ( (LA8_3==FLOATTYPE) && (synpred2_ConfigDSL())) {
                        alt8=3;
                    }
                    else if ( (LA8_3==FILETYPE) && (synpred3_ConfigDSL())) {
                        alt8=4;
                    }
                    else if ( (LA8_3==STRINGTYPE) ) {
                        alt8=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case EQ:
                    {
                    alt8=5;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:25: ID OPEN_TREE ( config_tree )* CLOSE_TREE
                    {
                    ID8=(Token)match(input,ID,FOLLOW_ID_in_config_tree153); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID8);

                    OPEN_TREE9=(Token)match(input,OPEN_TREE,FOLLOW_OPEN_TREE_in_config_tree155); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_TREE.add(OPEN_TREE9);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:38: ( config_tree )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:38: config_tree
                    	    {
                    	    pushFollow(FOLLOW_config_tree_in_config_tree157);
                    	    config_tree10=config_tree();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_config_tree.add(config_tree10.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    CLOSE_TREE11=(Token)match(input,CLOSE_TREE,FOLLOW_CLOSE_TREE_in_config_tree160); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSE_TREE.add(CLOSE_TREE11);



                    // AST REWRITE
                    // elements: config_tree
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 35:62: -> ^( ( config_tree )* )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:65: ^( ( config_tree )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(TREE_PROP,(ID8!=null?ID8.getText():null)), root_1);

                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:104: ( config_tree )*
                        while ( stream_config_tree.hasNext() ) {
                            adaptor.addChild(root_1, stream_config_tree.nextTree());

                        }
                        stream_config_tree.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:24: ( ID )=>a= ID COLON INTTYPE EQ INT
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree201); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    COLON12=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree203); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON12);

                    INTTYPE13=(Token)match(input,INTTYPE,FOLLOW_INTTYPE_in_config_tree205); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTTYPE.add(INTTYPE13);

                    EQ14=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree207); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ14);

                    INT15=(Token)match(input,INT,FOLLOW_INT_in_config_tree209); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT15);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 36:57: -> ^( INT )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:60: ^( INT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(INT_PROP,(a!=null?a.getText():null)), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:37:24: ( ID )=>a= ID COLON FLOATTYPE EQ FLOAT
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree249); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    COLON16=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree251); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON16);

                    FLOATTYPE17=(Token)match(input,FLOATTYPE,FOLLOW_FLOATTYPE_in_config_tree253); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOATTYPE.add(FLOATTYPE17);

                    EQ18=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree255); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ18);

                    FLOAT19=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_config_tree257); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOAT.add(FLOAT19);



                    // AST REWRITE
                    // elements: FLOAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 37:61: -> ^( FLOAT )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:37:64: ^( FLOAT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(FLOAT_TYPE,(a!=null?a.getText():null)), root_1);

                        adaptor.addChild(root_1, stream_FLOAT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:26: ( ID )=>a= ID COLON FILETYPE EQ (b+= ID | b+= INT | b+= FILE_SEP )*
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree299); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    COLON20=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree301); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON20);

                    FILETYPE21=(Token)match(input,FILETYPE,FOLLOW_FILETYPE_in_config_tree303); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FILETYPE.add(FILETYPE21);

                    EQ22=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree305); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ22);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:56: (b+= ID | b+= INT | b+= FILE_SEP )*
                    loop6:
                    do {
                        int alt6=4;
                        switch ( input.LA(1) ) {
                        case ID:
                            {
                            int LA6_2 = input.LA(2);

                            if ( (LA6_2==EOF||LA6_2==ID||LA6_2==CLOSE_TREE||LA6_2==INT||LA6_2==FILE_SEP) ) {
                                alt6=1;
                            }


                            }
                            break;
                        case INT:
                            {
                            alt6=2;
                            }
                            break;
                        case FILE_SEP:
                            {
                            alt6=3;
                            }
                            break;

                        }

                        switch (alt6) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:57: b+= ID
                    	    {
                    	    b=(Token)match(input,ID,FOLLOW_ID_in_config_tree310); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(b);

                    	    if (list_b==null) list_b=new ArrayList();
                    	    list_b.add(b);


                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:63: b+= INT
                    	    {
                    	    b=(Token)match(input,INT,FOLLOW_INT_in_config_tree314); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_INT.add(b);

                    	    if (list_b==null) list_b=new ArrayList();
                    	    list_b.add(b);


                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:70: b+= FILE_SEP
                    	    {
                    	    b=(Token)match(input,FILE_SEP,FOLLOW_FILE_SEP_in_config_tree318); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_FILE_SEP.add(b);

                    	    if (list_b==null) list_b=new ArrayList();
                    	    list_b.add(b);


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: b
                    // token labels: 
                    // rule labels: retval
                    // token list labels: b
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b", list_b);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 38:84: -> ^( ( $b)* )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:87: ^( ( $b)* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(FILE_TYPE,(a!=null?a.getText():null)), root_1);

                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:125: ( $b)*
                        while ( stream_b.hasNext() ) {
                            adaptor.addChild(root_1, stream_b.nextNode());

                        }
                        stream_b.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:4: a= ID ( COLON STRINGTYPE )? EQ rawtext
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree338); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:9: ( COLON STRINGTYPE )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==COLON) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:10: COLON STRINGTYPE
                            {
                            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree341); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON23);

                            STRINGTYPE24=(Token)match(input,STRINGTYPE,FOLLOW_STRINGTYPE_in_config_tree343); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_STRINGTYPE.add(STRINGTYPE24);


                            }
                            break;

                    }

                    EQ25=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree347); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ25);

                    pushFollow(FOLLOW_rawtext_in_config_tree349);
                    rawtext26=rawtext();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rawtext.add(rawtext26.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 39:40: -> ^()
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:39:43: ^()
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(STRING_PROP,(a!=null?a.getText():null)), root_1);

                        adaptor.addChild(root_1, adaptor.create(TEXT,(rawtext26!=null?input.toString(rawtext26.start,rawtext26.stop):null).trim()));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "config_tree"

    public static class rawtext_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rawtext"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:42:1: rawtext : ( . )* ( NEWLINE | EOF ) ;
    public final ConfigDSLParser.rawtext_return rawtext() throws RecognitionException {
        ConfigDSLParser.rawtext_return retval = new ConfigDSLParser.rawtext_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token wildcard27=null;
        Token set28=null;

        CommonTree wildcard27_tree=null;
        CommonTree set28_tree=null;

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:42:9: ( ( . )* ( NEWLINE | EOF ) )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:42:12: ( . )* ( NEWLINE | EOF )
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:42:12: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==NEWLINE) ) {
                    alt9=2;
                }
                else if ( ((LA9_0>=STRING_PROP && LA9_0<=ID)||(LA9_0>=OPEN_TREE && LA9_0<=36)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:42:12: .
            	    {
            	    wildcard27=(Token)input.LT(1);
            	    matchAny(input); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    wildcard27_tree = (CommonTree)adaptor.create(wildcard27);
            	    adaptor.addChild(root_0, wildcard27_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            set28=(Token)input.LT(1);
            if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rawtext"

    // $ANTLR start synpred1_ConfigDSL
    public final void synpred1_ConfigDSL_fragment() throws RecognitionException {   
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:24: ( ID )
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:25: ID
        {
        match(input,ID,FOLLOW_ID_in_synpred1_ConfigDSL195); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_ConfigDSL

    // $ANTLR start synpred2_ConfigDSL
    public final void synpred2_ConfigDSL_fragment() throws RecognitionException {   
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:37:24: ( ID )
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:37:25: ID
        {
        match(input,ID,FOLLOW_ID_in_synpred2_ConfigDSL243); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_ConfigDSL

    // $ANTLR start synpred3_ConfigDSL
    public final void synpred3_ConfigDSL_fragment() throws RecognitionException {   
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:26: ( ID )
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:38:27: ID
        {
        match(input,ID,FOLLOW_ID_in_synpred3_ConfigDSL293); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_ConfigDSL

    // Delegated rules

    public final boolean synpred3_ConfigDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_ConfigDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ConfigDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ConfigDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_ConfigDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ConfigDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_pckg_in_main66 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_config_tree_in_main69 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_35_in_pckg78 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_pckg80 = new BitSet(new long[]{0x0000001000002000L});
    public static final BitSet FOLLOW_36_in_pckg83 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ID_in_pckg85 = new BitSet(new long[]{0x0000001000002000L});
    public static final BitSet FOLLOW_NEWLINE_in_pckg89 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ID_in_config_tree153 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_OPEN_TREE_in_config_tree155 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_config_tree_in_config_tree157 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_CLOSE_TREE_in_config_tree160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree201 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_config_tree203 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTTYPE_in_config_tree205 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree207 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_INT_in_config_tree209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree249 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_config_tree251 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_FLOATTYPE_in_config_tree253 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree255 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_FLOAT_in_config_tree257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree299 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_config_tree301 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_FILETYPE_in_config_tree303 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree305 = new BitSet(new long[]{0x0000000000881002L});
    public static final BitSet FOLLOW_ID_in_config_tree310 = new BitSet(new long[]{0x0000000000881002L});
    public static final BitSet FOLLOW_INT_in_config_tree314 = new BitSet(new long[]{0x0000000000881002L});
    public static final BitSet FOLLOW_FILE_SEP_in_config_tree318 = new BitSet(new long[]{0x0000000000881002L});
    public static final BitSet FOLLOW_ID_in_config_tree338 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_COLON_in_config_tree341 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_STRINGTYPE_in_config_tree343 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree347 = new BitSet(new long[]{0x0000001FFFFFFFF0L});
    public static final BitSet FOLLOW_rawtext_in_config_tree349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_rawtext372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred1_ConfigDSL195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred2_ConfigDSL243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred3_ConfigDSL293 = new BitSet(new long[]{0x0000000000000002L});

}