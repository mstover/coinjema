// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g 2010-05-20 18:23:30

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ConfigDSLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING_PROP", "INT_PROP", "TREE_PROP", "PROPERTY", "PROP_NAME", "FLOAT_TYPE", "FILE_TYPE", "ID", "NEWLINE", "EQ", "INTEGER", "FLOAT", "TREE_START", "TREE_END", "RAWTEXT", "WS", "EXPONENT", "ESC_SEQ", "'package'", "'.'", "':int'", "':float'", "':file'", "':string'"
    };
    public static final int INTEGER=14;
    public static final int EXPONENT=20;
    public static final int FLOAT_TYPE=9;
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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:25:1: main : ( pckg )? ( config_tree )+ EOF ;
    public final ConfigDSLParser.main_return main() throws RecognitionException {
        ConfigDSLParser.main_return retval = new ConfigDSLParser.main_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        ConfigDSLParser.pckg_return pckg1 = null;

        ConfigDSLParser.config_tree_return config_tree2 = null;


        CommonTree EOF3_tree=null;

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:25:6: ( ( pckg )? ( config_tree )+ EOF )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:25:8: ( pckg )? ( config_tree )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:25:8: ( pckg )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==22) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:25:8: pckg
                    {
                    pushFollow(FOLLOW_pckg_in_main63);
                    pckg1=pckg();

                    state._fsp--;

                    adaptor.addChild(root_0, pckg1.getTree());

                    }
                    break;

            }

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:25:14: ( config_tree )+
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
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:25:14: config_tree
            	    {
            	    pushFollow(FOLLOW_config_tree_in_main66);
            	    config_tree2=config_tree();

            	    state._fsp--;

            	    adaptor.addChild(root_0, config_tree2.getTree());

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

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_main69); 
            EOF3_tree = (CommonTree)adaptor.create(EOF3);
            adaptor.addChild(root_0, EOF3_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:27:1: pckg : 'package' ID ( '.' ID )* ( NEWLINE )+ ;
    public final ConfigDSLParser.pckg_return pckg() throws RecognitionException {
        ConfigDSLParser.pckg_return retval = new ConfigDSLParser.pckg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal4=null;
        Token ID5=null;
        Token char_literal6=null;
        Token ID7=null;
        Token NEWLINE8=null;

        CommonTree string_literal4_tree=null;
        CommonTree ID5_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree ID7_tree=null;
        CommonTree NEWLINE8_tree=null;

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:27:6: ( 'package' ID ( '.' ID )* ( NEWLINE )+ )
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:27:8: 'package' ID ( '.' ID )* ( NEWLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal4=(Token)match(input,22,FOLLOW_22_in_pckg77); 
            string_literal4_tree = (CommonTree)adaptor.create(string_literal4);
            adaptor.addChild(root_0, string_literal4_tree);

            ID5=(Token)match(input,ID,FOLLOW_ID_in_pckg79); 
            ID5_tree = (CommonTree)adaptor.create(ID5);
            adaptor.addChild(root_0, ID5_tree);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:27:21: ( '.' ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==23) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:27:22: '.' ID
            	    {
            	    char_literal6=(Token)match(input,23,FOLLOW_23_in_pckg82); 
            	    char_literal6_tree = (CommonTree)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);

            	    ID7=(Token)match(input,ID,FOLLOW_ID_in_pckg84); 
            	    ID7_tree = (CommonTree)adaptor.create(ID7);
            	    adaptor.addChild(root_0, ID7_tree);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:27:31: ( NEWLINE )+
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
            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:27:31: NEWLINE
            	    {
            	    NEWLINE8=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_pckg88); 
            	    NEWLINE8_tree = (CommonTree)adaptor.create(NEWLINE8);
            	    adaptor.addChild(root_0, NEWLINE8_tree);


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


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:30:1: config_tree options {k=2; } : ( ID ':int' EQ INTEGER ( NEWLINE )? -> ^( INT_PROP INTEGER ) | ID ':float' EQ FLOAT ( NEWLINE )? -> ^( FLOAT_TYPE FLOAT ) | ID TREE_START ( config_tree )* TREE_END -> ^( ( config_tree )* ) | ID ':file' EQ RAWTEXT ( NEWLINE )? -> ^( FILE_TYPE RAWTEXT ) | ID ( ':string' )? EQ RAWTEXT ( NEWLINE )? -> ^( STRING_PROP RAWTEXT ) );
    public final ConfigDSLParser.config_tree_return config_tree() throws RecognitionException {
        ConfigDSLParser.config_tree_return retval = new ConfigDSLParser.config_tree_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID9=null;
        Token string_literal10=null;
        Token EQ11=null;
        Token INTEGER12=null;
        Token NEWLINE13=null;
        Token ID14=null;
        Token string_literal15=null;
        Token EQ16=null;
        Token FLOAT17=null;
        Token NEWLINE18=null;
        Token ID19=null;
        Token TREE_START20=null;
        Token TREE_END22=null;
        Token ID23=null;
        Token string_literal24=null;
        Token EQ25=null;
        Token RAWTEXT26=null;
        Token NEWLINE27=null;
        Token ID28=null;
        Token string_literal29=null;
        Token EQ30=null;
        Token RAWTEXT31=null;
        Token NEWLINE32=null;
        ConfigDSLParser.config_tree_return config_tree21 = null;


        CommonTree ID9_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree EQ11_tree=null;
        CommonTree INTEGER12_tree=null;
        CommonTree NEWLINE13_tree=null;
        CommonTree ID14_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree EQ16_tree=null;
        CommonTree FLOAT17_tree=null;
        CommonTree NEWLINE18_tree=null;
        CommonTree ID19_tree=null;
        CommonTree TREE_START20_tree=null;
        CommonTree TREE_END22_tree=null;
        CommonTree ID23_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree EQ25_tree=null;
        CommonTree RAWTEXT26_tree=null;
        CommonTree NEWLINE27_tree=null;
        CommonTree ID28_tree=null;
        CommonTree string_literal29_tree=null;
        CommonTree EQ30_tree=null;
        CommonTree RAWTEXT31_tree=null;
        CommonTree NEWLINE32_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_RAWTEXT=new RewriteRuleTokenStream(adaptor,"token RAWTEXT");
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleTokenStream stream_TREE_START=new RewriteRuleTokenStream(adaptor,"token TREE_START");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleTokenStream stream_TREE_END=new RewriteRuleTokenStream(adaptor,"token TREE_END");
        RewriteRuleSubtreeStream stream_config_tree=new RewriteRuleSubtreeStream(adaptor,"rule config_tree");
        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:32:23: ( ID ':int' EQ INTEGER ( NEWLINE )? -> ^( INT_PROP INTEGER ) | ID ':float' EQ FLOAT ( NEWLINE )? -> ^( FLOAT_TYPE FLOAT ) | ID TREE_START ( config_tree )* TREE_END -> ^( ( config_tree )* ) | ID ':file' EQ RAWTEXT ( NEWLINE )? -> ^( FILE_TYPE RAWTEXT ) | ID ( ':string' )? EQ RAWTEXT ( NEWLINE )? -> ^( STRING_PROP RAWTEXT ) )
            int alt11=5;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                switch ( input.LA(2) ) {
                case 24:
                    {
                    alt11=1;
                    }
                    break;
                case 25:
                    {
                    alt11=2;
                    }
                    break;
                case TREE_START:
                    {
                    alt11=3;
                    }
                    break;
                case 26:
                    {
                    alt11=4;
                    }
                    break;
                case EQ:
                case 27:
                    {
                    alt11=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:32:25: ID ':int' EQ INTEGER ( NEWLINE )?
                    {
                    ID9=(Token)match(input,ID,FOLLOW_ID_in_config_tree152);  
                    stream_ID.add(ID9);

                    string_literal10=(Token)match(input,24,FOLLOW_24_in_config_tree154);  
                    stream_24.add(string_literal10);

                    EQ11=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree156);  
                    stream_EQ.add(EQ11);

                    INTEGER12=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_config_tree158);  
                    stream_INTEGER.add(INTEGER12);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:32:46: ( NEWLINE )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==NEWLINE) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:32:46: NEWLINE
                            {
                            NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_config_tree160);  
                            stream_NEWLINE.add(NEWLINE13);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: INTEGER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 32:55: -> ^( INT_PROP INTEGER )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:32:58: ^( INT_PROP INTEGER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(PROPERTY,(ID9!=null?ID9.getText():null)), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(INT_PROP, "INT_PROP"));
                        adaptor.addChild(root_1, stream_INTEGER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:33:4: ID ':float' EQ FLOAT ( NEWLINE )?
                    {
                    ID14=(Token)match(input,ID,FOLLOW_ID_in_config_tree176);  
                    stream_ID.add(ID14);

                    string_literal15=(Token)match(input,25,FOLLOW_25_in_config_tree178);  
                    stream_25.add(string_literal15);

                    EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree180);  
                    stream_EQ.add(EQ16);

                    FLOAT17=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_config_tree182);  
                    stream_FLOAT.add(FLOAT17);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:33:25: ( NEWLINE )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==NEWLINE) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:33:25: NEWLINE
                            {
                            NEWLINE18=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_config_tree184);  
                            stream_NEWLINE.add(NEWLINE18);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: FLOAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 33:34: -> ^( FLOAT_TYPE FLOAT )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:33:37: ^( FLOAT_TYPE FLOAT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(PROPERTY,(ID14!=null?ID14.getText():null)), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(FLOAT_TYPE, "FLOAT_TYPE"));
                        adaptor.addChild(root_1, stream_FLOAT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:34:4: ID TREE_START ( config_tree )* TREE_END
                    {
                    ID19=(Token)match(input,ID,FOLLOW_ID_in_config_tree200);  
                    stream_ID.add(ID19);

                    TREE_START20=(Token)match(input,TREE_START,FOLLOW_TREE_START_in_config_tree202);  
                    stream_TREE_START.add(TREE_START20);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:34:18: ( config_tree )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:34:18: config_tree
                    	    {
                    	    pushFollow(FOLLOW_config_tree_in_config_tree204);
                    	    config_tree21=config_tree();

                    	    state._fsp--;

                    	    stream_config_tree.add(config_tree21.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    TREE_END22=(Token)match(input,TREE_END,FOLLOW_TREE_END_in_config_tree207);  
                    stream_TREE_END.add(TREE_END22);



                    // AST REWRITE
                    // elements: config_tree
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 34:40: -> ^( ( config_tree )* )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:34:43: ^( ( config_tree )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(TREE_PROP,(ID19!=null?ID19.getText():null)), root_1);

                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:34:82: ( config_tree )*
                        while ( stream_config_tree.hasNext() ) {
                            adaptor.addChild(root_1, stream_config_tree.nextTree());

                        }
                        stream_config_tree.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:4: ID ':file' EQ RAWTEXT ( NEWLINE )?
                    {
                    ID23=(Token)match(input,ID,FOLLOW_ID_in_config_tree221);  
                    stream_ID.add(ID23);

                    string_literal24=(Token)match(input,26,FOLLOW_26_in_config_tree223);  
                    stream_26.add(string_literal24);

                    EQ25=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree225);  
                    stream_EQ.add(EQ25);

                    RAWTEXT26=(Token)match(input,RAWTEXT,FOLLOW_RAWTEXT_in_config_tree227);  
                    stream_RAWTEXT.add(RAWTEXT26);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:26: ( NEWLINE )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==NEWLINE) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:26: NEWLINE
                            {
                            NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_config_tree229);  
                            stream_NEWLINE.add(NEWLINE27);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: RAWTEXT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 35:35: -> ^( FILE_TYPE RAWTEXT )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:35:38: ^( FILE_TYPE RAWTEXT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(PROPERTY,(ID23!=null?ID23.getText():null)), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(FILE_TYPE, "FILE_TYPE"));
                        adaptor.addChild(root_1, stream_RAWTEXT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:4: ID ( ':string' )? EQ RAWTEXT ( NEWLINE )?
                    {
                    ID28=(Token)match(input,ID,FOLLOW_ID_in_config_tree245);  
                    stream_ID.add(ID28);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:7: ( ':string' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==27) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:8: ':string'
                            {
                            string_literal29=(Token)match(input,27,FOLLOW_27_in_config_tree248);  
                            stream_27.add(string_literal29);


                            }
                            break;

                    }

                    EQ30=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree252);  
                    stream_EQ.add(EQ30);

                    RAWTEXT31=(Token)match(input,RAWTEXT,FOLLOW_RAWTEXT_in_config_tree255);  
                    stream_RAWTEXT.add(RAWTEXT31);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:32: ( NEWLINE )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NEWLINE) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:32: NEWLINE
                            {
                            NEWLINE32=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_config_tree257);  
                            stream_NEWLINE.add(NEWLINE32);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: RAWTEXT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 36:41: -> ^( STRING_PROP RAWTEXT )
                    {
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/ConfigDSL.g:36:44: ^( STRING_PROP RAWTEXT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(PROPERTY,(ID28!=null?ID28.getText():null)), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(STRING_PROP, "STRING_PROP"));
                        adaptor.addChild(root_1, stream_RAWTEXT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    // Delegated rules


 

    public static final BitSet FOLLOW_pckg_in_main63 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_config_tree_in_main66 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EOF_in_main69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_pckg77 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_pckg79 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_23_in_pckg82 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_pckg84 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_NEWLINE_in_pckg88 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ID_in_config_tree152 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_config_tree154 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_config_tree156 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEGER_in_config_tree158 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_NEWLINE_in_config_tree160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree176 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_config_tree178 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_config_tree180 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_FLOAT_in_config_tree182 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_NEWLINE_in_config_tree184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree200 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_TREE_START_in_config_tree202 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_config_tree_in_config_tree204 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_TREE_END_in_config_tree207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree221 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_config_tree223 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_config_tree225 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RAWTEXT_in_config_tree227 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_NEWLINE_in_config_tree229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree245 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_config_tree248 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQ_in_config_tree252 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RAWTEXT_in_config_tree255 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_NEWLINE_in_config_tree257 = new BitSet(new long[]{0x0000000000000002L});

}