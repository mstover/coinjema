// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g 2010-05-30 22:11:41

    package org.coinjema.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class ConfigDSLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING_PROP", "INT_PROP", "TREE_PROP", "PROPERTY", "PROP_NAME", "FLOAT_TYPE", "FILE_TYPE", "TEXT", "PACKAGE", "ID", "OPEN_TREE", "CLOSE_TREE", "COLON", "INTTYPE", "EQ", "INT", "FLOATTYPE", "FLOAT", "FILETYPE", "STRINGTYPE", "FILE_SEP", "NEWLINE", "UNICODE_ESC", "OCTAL_ESC", "ESC_SEQ", "EXPONENT", "COMMENT", "WS", "STRING", "CHAR", "HEX_DIGIT", "OTHER", "'package'"
    };
    public static final int PACKAGE=12;
    public static final int EXPONENT=29;
    public static final int FLOAT_TYPE=9;
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
    public static final int FILE_SEP=24;
    public static final int ID=13;
    public static final int OPEN_TREE=14;
    public static final int EOF=-1;
    public static final int COLON=16;
    public static final int WS=31;
    public static final int ESC_SEQ=28;
    public static final int NEWLINE=25;
    public static final int T__36=36;
    public static final int PROPERTY=7;
    public static final int FLOATTYPE=20;
    public static final int TREE_PROP=6;
    public static final int STRINGTYPE=23;
    public static final int FILE_TYPE=10;
    public static final int STRING_PROP=4;
    public static final int EQ=18;
    public static final int COMMENT=30;
    public static final int PROP_NAME=8;
    public static final int INTTYPE=17;
    public static final int STRING=32;

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
    public String getGrammarFileName() { return "/home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g"; }


    	public boolean usesFile = false;
    	
    	private String fixID(String id) {
    		return id.replaceAll("\\.","_");
    	}


    public static class main_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:45:1: main : ( pckg )? ( config_tree )+ ;
    public final ConfigDSLParser.main_return main() throws RecognitionException {
        ConfigDSLParser.main_return retval = new ConfigDSLParser.main_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ConfigDSLParser.pckg_return pckg1 = null;

        ConfigDSLParser.config_tree_return config_tree2 = null;



        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:45:6: ( ( pckg )? ( config_tree )+ )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:45:8: ( pckg )? ( config_tree )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:45:8: ( pckg )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==36) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:45:8: pckg
                    {
                    pushFollow(FOLLOW_pckg_in_main90);
                    pckg1=pckg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pckg1.getTree());

                    }
                    break;

            }

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:45:14: ( config_tree )+
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
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:45:14: config_tree
            	    {
            	    pushFollow(FOLLOW_config_tree_in_main93);
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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:47:1: pckg : 'package' ID -> ^( PACKAGE ID ) ;
    public final ConfigDSLParser.pckg_return pckg() throws RecognitionException {
        ConfigDSLParser.pckg_return retval = new ConfigDSLParser.pckg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal3=null;
        Token ID4=null;

        CommonTree string_literal3_tree=null;
        CommonTree ID4_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:47:6: ( 'package' ID -> ^( PACKAGE ID ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:47:8: 'package' ID
            {
            string_literal3=(Token)match(input,36,FOLLOW_36_in_pckg102); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_36.add(string_literal3);

            ID4=(Token)match(input,ID,FOLLOW_ID_in_pckg104); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID4);



            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 47:21: -> ^( PACKAGE ID )
            {
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:47:24: ^( PACKAGE ID )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PACKAGE, "PACKAGE"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:50:1: config_tree options {k=3; } : ( ID OPEN_TREE ( config_tree )* CLOSE_TREE -> ^( ( config_tree )* ) | ( ID )=>a= ID COLON INTTYPE EQ INT -> ^( INT ) | ( ID )=>a= ID COLON FLOATTYPE EQ FLOAT -> ^( FLOAT ) | ( ID )=>a= ID COLON FILETYPE EQ filename -> ^() | a= ID ( COLON STRINGTYPE )? EQ rawtext -> ^() );
    public final ConfigDSLParser.config_tree_return config_tree() throws RecognitionException {
        ConfigDSLParser.config_tree_return retval = new ConfigDSLParser.config_tree_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token a=null;
        Token ID5=null;
        Token OPEN_TREE6=null;
        Token CLOSE_TREE8=null;
        Token COLON9=null;
        Token INTTYPE10=null;
        Token EQ11=null;
        Token INT12=null;
        Token COLON13=null;
        Token FLOATTYPE14=null;
        Token EQ15=null;
        Token FLOAT16=null;
        Token COLON17=null;
        Token FILETYPE18=null;
        Token EQ19=null;
        Token COLON21=null;
        Token STRINGTYPE22=null;
        Token EQ23=null;
        ConfigDSLParser.config_tree_return config_tree7 = null;

        ConfigDSLParser.filename_return filename20 = null;

        ConfigDSLParser.rawtext_return rawtext24 = null;


        CommonTree a_tree=null;
        CommonTree ID5_tree=null;
        CommonTree OPEN_TREE6_tree=null;
        CommonTree CLOSE_TREE8_tree=null;
        CommonTree COLON9_tree=null;
        CommonTree INTTYPE10_tree=null;
        CommonTree EQ11_tree=null;
        CommonTree INT12_tree=null;
        CommonTree COLON13_tree=null;
        CommonTree FLOATTYPE14_tree=null;
        CommonTree EQ15_tree=null;
        CommonTree FLOAT16_tree=null;
        CommonTree COLON17_tree=null;
        CommonTree FILETYPE18_tree=null;
        CommonTree EQ19_tree=null;
        CommonTree COLON21_tree=null;
        CommonTree STRINGTYPE22_tree=null;
        CommonTree EQ23_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_OPEN_TREE=new RewriteRuleTokenStream(adaptor,"token OPEN_TREE");
        RewriteRuleTokenStream stream_CLOSE_TREE=new RewriteRuleTokenStream(adaptor,"token CLOSE_TREE");
        RewriteRuleTokenStream stream_INTTYPE=new RewriteRuleTokenStream(adaptor,"token INTTYPE");
        RewriteRuleTokenStream stream_FLOATTYPE=new RewriteRuleTokenStream(adaptor,"token FLOATTYPE");
        RewriteRuleTokenStream stream_STRINGTYPE=new RewriteRuleTokenStream(adaptor,"token STRINGTYPE");
        RewriteRuleTokenStream stream_FILETYPE=new RewriteRuleTokenStream(adaptor,"token FILETYPE");
        RewriteRuleSubtreeStream stream_config_tree=new RewriteRuleSubtreeStream(adaptor,"rule config_tree");
        RewriteRuleSubtreeStream stream_filename=new RewriteRuleSubtreeStream(adaptor,"rule filename");
        RewriteRuleSubtreeStream stream_rawtext=new RewriteRuleSubtreeStream(adaptor,"rule rawtext");
        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:52:23: ( ID OPEN_TREE ( config_tree )* CLOSE_TREE -> ^( ( config_tree )* ) | ( ID )=>a= ID COLON INTTYPE EQ INT -> ^( INT ) | ( ID )=>a= ID COLON FLOATTYPE EQ FLOAT -> ^( FLOAT ) | ( ID )=>a= ID COLON FILETYPE EQ filename -> ^() | a= ID ( COLON STRINGTYPE )? EQ rawtext -> ^() )
            int alt5=5;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ID) ) {
                switch ( input.LA(2) ) {
                case OPEN_TREE:
                    {
                    alt5=1;
                    }
                    break;
                case COLON:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==INTTYPE) && (synpred1_ConfigDSL())) {
                        alt5=2;
                    }
                    else if ( (LA5_3==FLOATTYPE) && (synpred2_ConfigDSL())) {
                        alt5=3;
                    }
                    else if ( (LA5_3==FILETYPE) && (synpred3_ConfigDSL())) {
                        alt5=4;
                    }
                    else if ( (LA5_3==STRINGTYPE) ) {
                        alt5=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case EQ:
                    {
                    alt5=5;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:52:25: ID OPEN_TREE ( config_tree )* CLOSE_TREE
                    {
                    ID5=(Token)match(input,ID,FOLLOW_ID_in_config_tree175); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID5);

                    OPEN_TREE6=(Token)match(input,OPEN_TREE,FOLLOW_OPEN_TREE_in_config_tree177); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_OPEN_TREE.add(OPEN_TREE6);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:52:38: ( config_tree )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==ID) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:52:38: config_tree
                    	    {
                    	    pushFollow(FOLLOW_config_tree_in_config_tree179);
                    	    config_tree7=config_tree();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_config_tree.add(config_tree7.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    CLOSE_TREE8=(Token)match(input,CLOSE_TREE,FOLLOW_CLOSE_TREE_in_config_tree182); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLOSE_TREE.add(CLOSE_TREE8);



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
                    // 52:62: -> ^( ( config_tree )* )
                    {
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:52:65: ^( ( config_tree )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(TREE_PROP,fixID((ID5!=null?ID5.getText():null))), root_1);

                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:52:111: ( config_tree )*
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
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:53:24: ( ID )=>a= ID COLON INTTYPE EQ INT
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree223); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    COLON9=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree225); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON9);

                    INTTYPE10=(Token)match(input,INTTYPE,FOLLOW_INTTYPE_in_config_tree227); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTTYPE.add(INTTYPE10);

                    EQ11=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree229); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ11);

                    INT12=(Token)match(input,INT,FOLLOW_INT_in_config_tree231); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT12);



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
                    // 53:57: -> ^( INT )
                    {
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:53:60: ^( INT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(INT_PROP,fixID((a!=null?a.getText():null))), root_1);

                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:54:24: ( ID )=>a= ID COLON FLOATTYPE EQ FLOAT
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree271); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    COLON13=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree273); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON13);

                    FLOATTYPE14=(Token)match(input,FLOATTYPE,FOLLOW_FLOATTYPE_in_config_tree275); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOATTYPE.add(FLOATTYPE14);

                    EQ15=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree277); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ15);

                    FLOAT16=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_config_tree279); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOAT.add(FLOAT16);



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
                    // 54:61: -> ^( FLOAT )
                    {
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:54:64: ^( FLOAT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(FLOAT_TYPE,fixID((a!=null?a.getText():null))), root_1);

                        adaptor.addChild(root_1, stream_FLOAT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:55:26: ( ID )=>a= ID COLON FILETYPE EQ filename
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree321); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    COLON17=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree323); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON17);

                    FILETYPE18=(Token)match(input,FILETYPE,FOLLOW_FILETYPE_in_config_tree325); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FILETYPE.add(FILETYPE18);

                    EQ19=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree327); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ19);

                    pushFollow(FOLLOW_filename_in_config_tree329);
                    filename20=filename();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_filename.add(filename20.getTree());
                    if ( state.backtracking==0 ) {
                      usesFile = true;
                    }


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
                    // 55:84: -> ^()
                    {
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:55:87: ^()
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(FILE_TYPE,fixID((a!=null?a.getText():null))), root_1);

                        adaptor.addChild(root_1, adaptor.create(TEXT,(filename20!=null?input.toString(filename20.start,filename20.stop):null)));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:56:4: a= ID ( COLON STRINGTYPE )? EQ rawtext
                    {
                    a=(Token)match(input,ID,FOLLOW_ID_in_config_tree346); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(a);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:56:9: ( COLON STRINGTYPE )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==COLON) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:56:10: COLON STRINGTYPE
                            {
                            COLON21=(Token)match(input,COLON,FOLLOW_COLON_in_config_tree349); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON21);

                            STRINGTYPE22=(Token)match(input,STRINGTYPE,FOLLOW_STRINGTYPE_in_config_tree351); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_STRINGTYPE.add(STRINGTYPE22);


                            }
                            break;

                    }

                    EQ23=(Token)match(input,EQ,FOLLOW_EQ_in_config_tree355); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ23);

                    pushFollow(FOLLOW_rawtext_in_config_tree357);
                    rawtext24=rawtext();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rawtext.add(rawtext24.getTree());


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
                    // 56:40: -> ^()
                    {
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:56:43: ^()
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(STRING_PROP,fixID((a!=null?a.getText():null))), root_1);

                        adaptor.addChild(root_1, adaptor.create(TEXT,(rawtext24!=null?input.toString(rawtext24.start,rawtext24.stop):null).trim()));

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

    public static class filename_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filename"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:59:1: filename : (b+= ID | b+= INT | b+= FILE_SEP )* ;
    public final ConfigDSLParser.filename_return filename() throws RecognitionException {
        ConfigDSLParser.filename_return retval = new ConfigDSLParser.filename_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token b=null;
        List list_b=null;

        CommonTree b_tree=null;

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:59:9: ( (b+= ID | b+= INT | b+= FILE_SEP )* )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:59:11: (b+= ID | b+= INT | b+= FILE_SEP )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:59:11: (b+= ID | b+= INT | b+= FILE_SEP )*
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
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:59:12: b+= ID
            	    {
            	    b=(Token)match(input,ID,FOLLOW_ID_in_filename378); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.create(b);
            	    adaptor.addChild(root_0, b_tree);
            	    }
            	    if (list_b==null) list_b=new ArrayList();
            	    list_b.add(b);


            	    }
            	    break;
            	case 2 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:59:18: b+= INT
            	    {
            	    b=(Token)match(input,INT,FOLLOW_INT_in_filename382); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.create(b);
            	    adaptor.addChild(root_0, b_tree);
            	    }
            	    if (list_b==null) list_b=new ArrayList();
            	    list_b.add(b);


            	    }
            	    break;
            	case 3 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:59:25: b+= FILE_SEP
            	    {
            	    b=(Token)match(input,FILE_SEP,FOLLOW_FILE_SEP_in_filename386); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.create(b);
            	    adaptor.addChild(root_0, b_tree);
            	    }
            	    if (list_b==null) list_b=new ArrayList();
            	    list_b.add(b);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
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
    // $ANTLR end "filename"

    public static class rawtext_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rawtext"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:61:1: rawtext : ( . )* ( NEWLINE | EOF ) ;
    public final ConfigDSLParser.rawtext_return rawtext() throws RecognitionException {
        ConfigDSLParser.rawtext_return retval = new ConfigDSLParser.rawtext_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token wildcard25=null;
        Token set26=null;

        CommonTree wildcard25_tree=null;
        CommonTree set26_tree=null;

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:61:9: ( ( . )* ( NEWLINE | EOF ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:61:12: ( . )* ( NEWLINE | EOF )
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:61:12: ( . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==NEWLINE) ) {
                    alt7=2;
                }
                else if ( ((LA7_0>=STRING_PROP && LA7_0<=FILE_SEP)||(LA7_0>=UNICODE_ESC && LA7_0<=36)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:61:12: .
            	    {
            	    wildcard25=(Token)input.LT(1);
            	    matchAny(input); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    wildcard25_tree = (CommonTree)adaptor.create(wildcard25);
            	    adaptor.addChild(root_0, wildcard25_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            set26=(Token)input.LT(1);
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
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:53:24: ( ID )
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:53:25: ID
        {
        match(input,ID,FOLLOW_ID_in_synpred1_ConfigDSL217); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_ConfigDSL

    // $ANTLR start synpred2_ConfigDSL
    public final void synpred2_ConfigDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:54:24: ( ID )
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:54:25: ID
        {
        match(input,ID,FOLLOW_ID_in_synpred2_ConfigDSL265); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_ConfigDSL

    // $ANTLR start synpred3_ConfigDSL
    public final void synpred3_ConfigDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:55:26: ( ID )
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSL.g:55:27: ID
        {
        match(input,ID,FOLLOW_ID_in_synpred3_ConfigDSL315); if (state.failed) return ;

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


 

    public static final BitSet FOLLOW_pckg_in_main90 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_config_tree_in_main93 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_36_in_pckg102 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_pckg104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree175 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_OPEN_TREE_in_config_tree177 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_config_tree_in_config_tree179 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_CLOSE_TREE_in_config_tree182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree223 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_config_tree225 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTTYPE_in_config_tree227 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree229 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_INT_in_config_tree231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree271 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_config_tree273 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_FLOATTYPE_in_config_tree275 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree277 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_FLOAT_in_config_tree279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree321 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_config_tree323 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_FILETYPE_in_config_tree325 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree327 = new BitSet(new long[]{0x0000000001082000L});
    public static final BitSet FOLLOW_filename_in_config_tree329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_config_tree346 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_COLON_in_config_tree349 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_STRINGTYPE_in_config_tree351 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EQ_in_config_tree355 = new BitSet(new long[]{0x0000001FFFFFFFF0L});
    public static final BitSet FOLLOW_rawtext_in_config_tree357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_filename378 = new BitSet(new long[]{0x0000000001082002L});
    public static final BitSet FOLLOW_INT_in_filename382 = new BitSet(new long[]{0x0000000001082002L});
    public static final BitSet FOLLOW_FILE_SEP_in_filename386 = new BitSet(new long[]{0x0000000001082002L});
    public static final BitSet FOLLOW_set_in_rawtext401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred1_ConfigDSL217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred2_ConfigDSL265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred3_ConfigDSL315 = new BitSet(new long[]{0x0000000000000002L});

}