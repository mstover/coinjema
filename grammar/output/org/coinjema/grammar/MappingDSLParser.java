// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g 2010-05-30 22:54:17

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class MappingDSLParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CONTEXT", "AREA_ACTION", "FUNC_CALL", "PROC_CALL", "OFFSET", "COORD", "IMAGE", "RECTANGLE", "CIRCLE", "RAW", "PROCEDURE", "FUNCTION", "ARGLIST", "BODY", "ID", "COLOR", "DASH", "PLUS", "FLOAT", "MULT", "DIV", "INT", "OP", "STRING", "DIRECTION", "WS", "EXPONENT", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "':'", "'outline'", "'inline'", "';'", "'('", "')'", "','", "'.'", "'hex'", "'square'", "'free'", "'size'", "'each'", "'within'", "'beside'", "'proc'", "'{'", "'}'", "'func'", "'['", "']'"
    };
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
    public static final int ESC_SEQ=31;
    public static final int T__51=51;
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
    public static final int T__36=36;
    public static final int AREA_ACTION=5;
    public static final int T__37=37;
    public static final int CIRCLE=12;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int OP=26;
    public static final int DIV=24;
    public static final int STRING=27;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "synpred31_MappingDSL", "synpred24_MappingDSL", "synpred56_MappingDSL", 
        "synpred25_MappingDSL", "synpred40_MappingDSL", "synpred62_MappingDSL", 
        "synpred46_MappingDSL", "synpred21_MappingDSL", "synpred49_MappingDSL", 
        "synpred42_MappingDSL", "synpred59_MappingDSL", "synpred32_MappingDSL", 
        "synpred35_MappingDSL", "synpred38_MappingDSL", "synpred58_MappingDSL", 
        "synpred39_MappingDSL", "synpred50_MappingDSL", "synpred48_MappingDSL", 
        "synpred6_MappingDSL", "synpred27_MappingDSL", "synpred43_MappingDSL", 
        "main", "synpred34_MappingDSL", "synpred26_MappingDSL", "synpred53_MappingDSL", 
        "expr", "synpred60_MappingDSL", "synpred36_MappingDSL", "synpred19_MappingDSL", 
        "synpred3_MappingDSL", "image", "synpred23_MappingDSL", "synpred12_MappingDSL", 
        "synpred9_MappingDSL", "synpred20_MappingDSL", "func", "synpred22_MappingDSL", 
        "synpred37_MappingDSL", "coordinateSystem", "synpred47_MappingDSL", 
        "location", "proc", "coord", "synpred5_MappingDSL", "synpred44_MappingDSL", 
        "synpred2_MappingDSL", "synpred18_MappingDSL", "synpred4_MappingDSL", 
        "synpred1_MappingDSL", "context", "synpred57_MappingDSL", "synpred55_MappingDSL", 
        "synpred54_MappingDSL", "synpred17_MappingDSL", "synpred33_MappingDSL", 
        "size", "synpred51_MappingDSL", "procCall", "synpred61_MappingDSL", 
        "synpred28_MappingDSL", "synpred7_MappingDSL", "areaAction", "synpred41_MappingDSL", 
        "synpred13_MappingDSL", "synpred52_MappingDSL", "synpred14_MappingDSL", 
        "synpred16_MappingDSL", "action", "synpred11_MappingDSL", "synpred10_MappingDSL", 
        "synpred29_MappingDSL", "synpred8_MappingDSL", "synpred30_MappingDSL", 
        "synpred15_MappingDSL", "synpred45_MappingDSL", "offset"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public MappingDSLParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public MappingDSLParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public MappingDSLParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return MappingDSLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g"; }


    public static class main_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:1: main : ( context | areaAction | proc | func )* ;
    public final MappingDSLParser.main_return main() throws RecognitionException {
        MappingDSLParser.main_return retval = new MappingDSLParser.main_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        MappingDSLParser.context_return context1 = null;

        MappingDSLParser.areaAction_return areaAction2 = null;

        MappingDSLParser.proc_return proc3 = null;

        MappingDSLParser.func_return func4 = null;



        try { dbg.enterRule(getGrammarFileName(), "main");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:6: ( ( context | areaAction | proc | func )* )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:8: ( context | areaAction | proc | func )*
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(26,8);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:8: ( context | areaAction | proc | func )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=5;
                try { dbg.enterDecision(1);

                try {
                    isCyclicDecision = true;
                    alt1 = dfa1.predict(input);
                }
                catch (NoViableAltException nvae) {
                    dbg.recognitionException(nvae);
                    throw nvae;
                }
                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:9: context
            	    {
            	    dbg.location(26,9);
            	    pushFollow(FOLLOW_context_in_main78);
            	    context1=context();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, context1.getTree());

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:17: areaAction
            	    {
            	    dbg.location(26,17);
            	    pushFollow(FOLLOW_areaAction_in_main80);
            	    areaAction2=areaAction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, areaAction2.getTree());

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:28: proc
            	    {
            	    dbg.location(26,28);
            	    pushFollow(FOLLOW_proc_in_main82);
            	    proc3=proc();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, proc3.getTree());

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:26:33: func
            	    {
            	    dbg.location(26,33);
            	    pushFollow(FOLLOW_func_in_main84);
            	    func4=func();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, func4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(26, 39);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "main");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "main"

    public static class context_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "context"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:1: context : ID ':' coordinateSystem (a= ( 'outline' | 'inline' ) )? ';' -> ^( CONTEXT[$ID.text] coordinateSystem ( $a)? ) ;
    public final MappingDSLParser.context_return context() throws RecognitionException {
        MappingDSLParser.context_return retval = new MappingDSLParser.context_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token a=null;
        Token ID5=null;
        Token char_literal6=null;
        Token string_literal8=null;
        Token string_literal9=null;
        Token char_literal10=null;
        MappingDSLParser.coordinateSystem_return coordinateSystem7 = null;


        Object a_tree=null;
        Object ID5_tree=null;
        Object char_literal6_tree=null;
        Object string_literal8_tree=null;
        Object string_literal9_tree=null;
        Object char_literal10_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_coordinateSystem=new RewriteRuleSubtreeStream(adaptor,"rule coordinateSystem");
        try { dbg.enterRule(getGrammarFileName(), "context");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(28, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:9: ( ID ':' coordinateSystem (a= ( 'outline' | 'inline' ) )? ';' -> ^( CONTEXT[$ID.text] coordinateSystem ( $a)? ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:11: ID ':' coordinateSystem (a= ( 'outline' | 'inline' ) )? ';'
            {
            dbg.location(28,11);
            ID5=(Token)match(input,ID,FOLLOW_ID_in_context94); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID5);

            dbg.location(28,14);
            char_literal6=(Token)match(input,35,FOLLOW_35_in_context96); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_35.add(char_literal6);

            dbg.location(28,18);
            pushFollow(FOLLOW_coordinateSystem_in_context98);
            coordinateSystem7=coordinateSystem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_coordinateSystem.add(coordinateSystem7.getTree());
            dbg.location(28,36);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:36: (a= ( 'outline' | 'inline' ) )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3);

            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=36 && LA3_0<=37)) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: a= ( 'outline' | 'inline' )
                    {
                    dbg.location(28,36);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:37: ( 'outline' | 'inline' )
                    int alt2=2;
                    try { dbg.enterSubRule(2);
                    try { dbg.enterDecision(2);

                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==36) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==37) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(2);}

                    switch (alt2) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:38: 'outline'
                            {
                            dbg.location(28,38);
                            string_literal8=(Token)match(input,36,FOLLOW_36_in_context103); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_36.add(string_literal8);


                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:48: 'inline'
                            {
                            dbg.location(28,48);
                            string_literal9=(Token)match(input,37,FOLLOW_37_in_context105); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_37.add(string_literal9);


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(2);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(28,59);
            char_literal10=(Token)match(input,38,FOLLOW_38_in_context109); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal10);



            // AST REWRITE
            // elements: a, coordinateSystem
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 28:63: -> ^( CONTEXT[$ID.text] coordinateSystem ( $a)? )
            {
                dbg.location(28,66);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:66: ^( CONTEXT[$ID.text] coordinateSystem ( $a)? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(28,68);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTEXT, (ID5!=null?ID5.getText():null)), root_1);

                dbg.location(28,86);
                adaptor.addChild(root_1, stream_coordinateSystem.nextTree());
                dbg.location(28,103);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:28:103: ( $a)?
                if ( stream_a.hasNext() ) {
                    dbg.location(28,103);
                    adaptor.addChild(root_1, stream_a.nextNode());

                }
                stream_a.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(28, 109);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "context");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "context"

    public static class areaAction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "areaAction"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:30:1: areaAction : ( expr ':' )=> expr ':' action ';' -> ^( AREA_ACTION expr action ) ;
    public final MappingDSLParser.areaAction_return areaAction() throws RecognitionException {
        MappingDSLParser.areaAction_return retval = new MappingDSLParser.areaAction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal12=null;
        Token char_literal14=null;
        MappingDSLParser.expr_return expr11 = null;

        MappingDSLParser.action_return action13 = null;


        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try { dbg.enterRule(getGrammarFileName(), "areaAction");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(30, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:31:2: ( ( expr ':' )=> expr ':' action ';' -> ^( AREA_ACTION expr action ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:31:4: ( expr ':' )=> expr ':' action ';'
            {
            dbg.location(31,17);
            pushFollow(FOLLOW_expr_in_areaAction140);
            expr11=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr11.getTree());
            dbg.location(31,22);
            char_literal12=(Token)match(input,35,FOLLOW_35_in_areaAction142); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_35.add(char_literal12);

            dbg.location(31,26);
            pushFollow(FOLLOW_action_in_areaAction144);
            action13=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action13.getTree());
            dbg.location(31,33);
            char_literal14=(Token)match(input,38,FOLLOW_38_in_areaAction146); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal14);



            // AST REWRITE
            // elements: action, expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 31:37: -> ^( AREA_ACTION expr action )
            {
                dbg.location(31,40);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:31:40: ^( AREA_ACTION expr action )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(31,42);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AREA_ACTION, "AREA_ACTION"), root_1);

                dbg.location(31,54);
                adaptor.addChild(root_1, stream_expr.nextTree());
                dbg.location(31,59);
                adaptor.addChild(root_1, stream_action.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(31, 66);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "areaAction");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "areaAction"

    public static class action_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "action"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:1: action : ( ( image )=> image -> ^( IMAGE[$image.text] ) | ( COLOR )=> COLOR | ( procCall )=> procCall | ID );
    public final MappingDSLParser.action_return action() throws RecognitionException {
        MappingDSLParser.action_return retval = new MappingDSLParser.action_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLOR16=null;
        Token ID18=null;
        MappingDSLParser.image_return image15 = null;

        MappingDSLParser.procCall_return procCall17 = null;


        Object COLOR16_tree=null;
        Object ID18_tree=null;
        RewriteRuleSubtreeStream stream_image=new RewriteRuleSubtreeStream(adaptor,"rule image");
        try { dbg.enterRule(getGrammarFileName(), "action");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(33, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:8: ( ( image )=> image -> ^( IMAGE[$image.text] ) | ( COLOR )=> COLOR | ( procCall )=> procCall | ID )
            int alt4=4;
            try { dbg.enterDecision(4);

            try {
                isCyclicDecision = true;
                alt4 = dfa4.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:10: ( image )=> image
                    {
                    dbg.location(33,20);
                    pushFollow(FOLLOW_image_in_action170);
                    image15=image();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_image.add(image15.getTree());


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

                    root_0 = (Object)adaptor.nil();
                    // 33:26: -> ^( IMAGE[$image.text] )
                    {
                        dbg.location(33,29);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:29: ^( IMAGE[$image.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(33,31);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMAGE, (image15!=null?input.toString(image15.start,image15.stop):null)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:34:4: ( COLOR )=> COLOR
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(34,14);
                    COLOR16=(Token)match(input,COLOR,FOLLOW_COLOR_in_action187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLOR16_tree = (Object)adaptor.create(COLOR16);
                    adaptor.addChild(root_0, COLOR16_tree);
                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:35:4: ( procCall )=> procCall
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(35,17);
                    pushFollow(FOLLOW_procCall_in_action197);
                    procCall17=procCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, procCall17.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:36:4: ID
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(36,4);
                    ID18=(Token)match(input,ID,FOLLOW_ID_in_action202); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID18_tree = (Object)adaptor.create(ID18);
                    adaptor.addChild(root_0, ID18_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(36, 6);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "action");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "action"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:38:1: expr : ( ( coord )=> coord ( ( DASH | PLUS ) expr )? | ( offset )=> offset | ( FLOAT )=> FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )? | ( INT )=> INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )? | ( STRING )=> STRING ( PLUS expr )? | ( procCall )=> procCall ( ( DASH | PLUS ) expr )? | ( '(' )=> '(' expr ')' | ID ( ( DASH | PLUS | MULT | DIV ) expr )? );
    public final MappingDSLParser.expr_return expr() throws RecognitionException {
        MappingDSLParser.expr_return retval = new MappingDSLParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set20=null;
        Token FLOAT23=null;
        Token set24=null;
        Token INT26=null;
        Token set27=null;
        Token STRING29=null;
        Token PLUS30=null;
        Token set33=null;
        Token char_literal35=null;
        Token char_literal37=null;
        Token ID38=null;
        Token set39=null;
        MappingDSLParser.coord_return coord19 = null;

        MappingDSLParser.expr_return expr21 = null;

        MappingDSLParser.offset_return offset22 = null;

        MappingDSLParser.expr_return expr25 = null;

        MappingDSLParser.expr_return expr28 = null;

        MappingDSLParser.expr_return expr31 = null;

        MappingDSLParser.procCall_return procCall32 = null;

        MappingDSLParser.expr_return expr34 = null;

        MappingDSLParser.expr_return expr36 = null;

        MappingDSLParser.expr_return expr40 = null;


        Object set20_tree=null;
        Object FLOAT23_tree=null;
        Object set24_tree=null;
        Object INT26_tree=null;
        Object set27_tree=null;
        Object STRING29_tree=null;
        Object PLUS30_tree=null;
        Object set33_tree=null;
        Object char_literal35_tree=null;
        Object char_literal37_tree=null;
        Object ID38_tree=null;
        Object set39_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(38, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:39:2: ( ( coord )=> coord ( ( DASH | PLUS ) expr )? | ( offset )=> offset | ( FLOAT )=> FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )? | ( INT )=> INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )? | ( STRING )=> STRING ( PLUS expr )? | ( procCall )=> procCall ( ( DASH | PLUS ) expr )? | ( '(' )=> '(' expr ')' | ID ( ( DASH | PLUS | MULT | DIV ) expr )? )
            int alt11=8;
            try { dbg.enterDecision(11);

            try {
                isCyclicDecision = true;
                alt11 = dfa11.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:39:4: ( coord )=> coord ( ( DASH | PLUS ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(39,14);
                    pushFollow(FOLLOW_coord_in_expr217);
                    coord19=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord19.getTree());
                    dbg.location(39,20);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:39:20: ( ( DASH | PLUS ) expr )?
                    int alt5=2;
                    try { dbg.enterSubRule(5);
                    try { dbg.enterDecision(5);

                    try {
                        isCyclicDecision = true;
                        alt5 = dfa5.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(5);}

                    switch (alt5) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:39:21: ( DASH | PLUS ) expr
                            {
                            dbg.location(39,21);
                            set20=(Token)input.LT(1);
                            set20=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set20), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(39,34);
                            pushFollow(FOLLOW_expr_in_expr227);
                            expr21=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr21.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(5);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:40:4: ( offset )=> offset
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(40,15);
                    pushFollow(FOLLOW_offset_in_expr239);
                    offset22=offset();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, offset22.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:41:4: ( FLOAT )=> FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(41,14);
                    FLOAT23=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_expr249); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT23_tree = (Object)adaptor.create(FLOAT23);
                    adaptor.addChild(root_0, FLOAT23_tree);
                    }
                    dbg.location(41,20);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:41:20: ( ( DASH | PLUS | MULT | DIV ) expr )?
                    int alt6=2;
                    try { dbg.enterSubRule(6);
                    try { dbg.enterDecision(6);

                    try {
                        isCyclicDecision = true;
                        alt6 = dfa6.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(6);}

                    switch (alt6) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:41:21: ( DASH | PLUS | MULT | DIV ) expr
                            {
                            dbg.location(41,21);
                            set24=(Token)input.LT(1);
                            set24=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS)||(input.LA(1)>=MULT && input.LA(1)<=DIV) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set24), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(41,43);
                            pushFollow(FOLLOW_expr_in_expr263);
                            expr25=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr25.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(6);}


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:42:4: ( INT )=> INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(42,12);
                    INT26=(Token)match(input,INT,FOLLOW_INT_in_expr275); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT26_tree = (Object)adaptor.create(INT26);
                    adaptor.addChild(root_0, INT26_tree);
                    }
                    dbg.location(42,16);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:42:16: ( ( DASH | PLUS | MULT | DIV | OP ) expr )?
                    int alt7=2;
                    try { dbg.enterSubRule(7);
                    try { dbg.enterDecision(7);

                    try {
                        isCyclicDecision = true;
                        alt7 = dfa7.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(7);}

                    switch (alt7) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:42:17: ( DASH | PLUS | MULT | DIV | OP ) expr
                            {
                            dbg.location(42,17);
                            set27=(Token)input.LT(1);
                            set27=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS)||(input.LA(1)>=MULT && input.LA(1)<=DIV)||input.LA(1)==OP ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set27), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(42,42);
                            pushFollow(FOLLOW_expr_in_expr291);
                            expr28=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr28.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(7);}


                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:43:4: ( STRING )=> STRING ( PLUS expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(43,15);
                    STRING29=(Token)match(input,STRING,FOLLOW_STRING_in_expr303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING29_tree = (Object)adaptor.create(STRING29);
                    adaptor.addChild(root_0, STRING29_tree);
                    }
                    dbg.location(43,22);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:43:22: ( PLUS expr )?
                    int alt8=2;
                    try { dbg.enterSubRule(8);
                    try { dbg.enterDecision(8);

                    try {
                        isCyclicDecision = true;
                        alt8 = dfa8.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(8);}

                    switch (alt8) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:43:23: PLUS expr
                            {
                            dbg.location(43,27);
                            PLUS30=(Token)match(input,PLUS,FOLLOW_PLUS_in_expr306); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUS30_tree = (Object)adaptor.create(PLUS30);
                            root_0 = (Object)adaptor.becomeRoot(PLUS30_tree, root_0);
                            }
                            dbg.location(43,29);
                            pushFollow(FOLLOW_expr_in_expr309);
                            expr31=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr31.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(8);}


                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:44:4: ( procCall )=> procCall ( ( DASH | PLUS ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(44,17);
                    pushFollow(FOLLOW_procCall_in_expr321);
                    procCall32=procCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, procCall32.getTree());
                    dbg.location(44,26);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:44:26: ( ( DASH | PLUS ) expr )?
                    int alt9=2;
                    try { dbg.enterSubRule(9);
                    try { dbg.enterDecision(9);

                    try {
                        isCyclicDecision = true;
                        alt9 = dfa9.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(9);}

                    switch (alt9) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:44:27: ( DASH | PLUS ) expr
                            {
                            dbg.location(44,27);
                            set33=(Token)input.LT(1);
                            set33=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set33), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(44,40);
                            pushFollow(FOLLOW_expr_in_expr331);
                            expr34=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr34.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(9);}


                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:45:4: ( '(' )=> '(' expr ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(45,12);
                    char_literal35=(Token)match(input,39,FOLLOW_39_in_expr344); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (Object)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    dbg.location(45,16);
                    pushFollow(FOLLOW_expr_in_expr346);
                    expr36=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr36.getTree());
                    dbg.location(45,21);
                    char_literal37=(Token)match(input,40,FOLLOW_40_in_expr348); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    adaptor.addChild(root_0, char_literal37_tree);
                    }

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:46:4: ID ( ( DASH | PLUS | MULT | DIV ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(46,4);
                    ID38=(Token)match(input,ID,FOLLOW_ID_in_expr353); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID38_tree = (Object)adaptor.create(ID38);
                    adaptor.addChild(root_0, ID38_tree);
                    }
                    dbg.location(46,7);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:46:7: ( ( DASH | PLUS | MULT | DIV ) expr )?
                    int alt10=2;
                    try { dbg.enterSubRule(10);
                    try { dbg.enterDecision(10);

                    try {
                        isCyclicDecision = true;
                        alt10 = dfa10.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(10);}

                    switch (alt10) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:46:8: ( DASH | PLUS | MULT | DIV ) expr
                            {
                            dbg.location(46,8);
                            set39=(Token)input.LT(1);
                            set39=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS)||(input.LA(1)>=MULT && input.LA(1)<=DIV) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set39), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(46,30);
                            pushFollow(FOLLOW_expr_in_expr367);
                            expr40=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr40.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(10);}


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(47, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expr"

    public static class procCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "procCall"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:1: procCall : ID '(' ( expr ( ',' expr )* )? ( ',' action )? ')' -> ^( PROC_CALL[$ID.text] ( expr )* ( action )? ) ;
    public final MappingDSLParser.procCall_return procCall() throws RecognitionException {
        MappingDSLParser.procCall_return retval = new MappingDSLParser.procCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID41=null;
        Token char_literal42=null;
        Token char_literal44=null;
        Token char_literal46=null;
        Token char_literal48=null;
        MappingDSLParser.expr_return expr43 = null;

        MappingDSLParser.expr_return expr45 = null;

        MappingDSLParser.action_return action47 = null;


        Object ID41_tree=null;
        Object char_literal42_tree=null;
        Object char_literal44_tree=null;
        Object char_literal46_tree=null;
        Object char_literal48_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try { dbg.enterRule(getGrammarFileName(), "procCall");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(49, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:9: ( ID '(' ( expr ( ',' expr )* )? ( ',' action )? ')' -> ^( PROC_CALL[$ID.text] ( expr )* ( action )? ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:11: ID '(' ( expr ( ',' expr )* )? ( ',' action )? ')'
            {
            dbg.location(49,11);
            ID41=(Token)match(input,ID,FOLLOW_ID_in_procCall379); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID41);

            dbg.location(49,14);
            char_literal42=(Token)match(input,39,FOLLOW_39_in_procCall381); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(char_literal42);

            dbg.location(49,18);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:18: ( expr ( ',' expr )* )?
            int alt13=2;
            try { dbg.enterSubRule(13);
            try { dbg.enterDecision(13);

            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID||LA13_0==FLOAT||LA13_0==INT||LA13_0==STRING||LA13_0==39||LA13_0==54) ) {
                alt13=1;
            }
            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:19: expr ( ',' expr )*
                    {
                    dbg.location(49,19);
                    pushFollow(FOLLOW_expr_in_procCall384);
                    expr43=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr43.getTree());
                    dbg.location(49,24);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:24: ( ',' expr )*
                    try { dbg.enterSubRule(12);

                    loop12:
                    do {
                        int alt12=2;
                        try { dbg.enterDecision(12);

                        try {
                            isCyclicDecision = true;
                            alt12 = dfa12.predict(input);
                        }
                        catch (NoViableAltException nvae) {
                            dbg.recognitionException(nvae);
                            throw nvae;
                        }
                        } finally {dbg.exitDecision(12);}

                        switch (alt12) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:25: ',' expr
                    	    {
                    	    dbg.location(49,25);
                    	    char_literal44=(Token)match(input,41,FOLLOW_41_in_procCall387); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_41.add(char_literal44);

                    	    dbg.location(49,29);
                    	    pushFollow(FOLLOW_expr_in_procCall389);
                    	    expr45=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(12);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(13);}

            dbg.location(49,38);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:38: ( ',' action )?
            int alt14=2;
            try { dbg.enterSubRule(14);
            try { dbg.enterDecision(14);

            int LA14_0 = input.LA(1);

            if ( (LA14_0==41) ) {
                alt14=1;
            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:39: ',' action
                    {
                    dbg.location(49,39);
                    char_literal46=(Token)match(input,41,FOLLOW_41_in_procCall396); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal46);

                    dbg.location(49,43);
                    pushFollow(FOLLOW_action_in_procCall398);
                    action47=action();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_action.add(action47.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(14);}

            dbg.location(49,52);
            char_literal48=(Token)match(input,40,FOLLOW_40_in_procCall402); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal48);



            // AST REWRITE
            // elements: expr, action
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 49:56: -> ^( PROC_CALL[$ID.text] ( expr )* ( action )? )
            {
                dbg.location(49,59);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:59: ^( PROC_CALL[$ID.text] ( expr )* ( action )? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(49,61);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROC_CALL, (ID41!=null?ID41.getText():null)), root_1);

                dbg.location(49,81);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:81: ( expr )*
                while ( stream_expr.hasNext() ) {
                    dbg.location(49,81);
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();
                dbg.location(49,87);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:87: ( action )?
                if ( stream_action.hasNext() ) {
                    dbg.location(49,87);
                    adaptor.addChild(root_1, stream_action.nextTree());

                }
                stream_action.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(50, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "procCall");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "procCall"

    public static class image_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "image"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:52:1: image : ( DIV )? ID ( DIV ID )* '.' ID ;
    public final MappingDSLParser.image_return image() throws RecognitionException {
        MappingDSLParser.image_return retval = new MappingDSLParser.image_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DIV49=null;
        Token ID50=null;
        Token DIV51=null;
        Token ID52=null;
        Token char_literal53=null;
        Token ID54=null;

        Object DIV49_tree=null;
        Object ID50_tree=null;
        Object DIV51_tree=null;
        Object ID52_tree=null;
        Object char_literal53_tree=null;
        Object ID54_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "image");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(52, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:52:7: ( ( DIV )? ID ( DIV ID )* '.' ID )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:52:9: ( DIV )? ID ( DIV ID )* '.' ID
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(52,9);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:52:9: ( DIV )?
            int alt15=2;
            try { dbg.enterSubRule(15);
            try { dbg.enterDecision(15);

            int LA15_0 = input.LA(1);

            if ( (LA15_0==DIV) ) {
                alt15=1;
            }
            } finally {dbg.exitDecision(15);}

            switch (alt15) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: DIV
                    {
                    dbg.location(52,9);
                    DIV49=(Token)match(input,DIV,FOLLOW_DIV_in_image425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV49_tree = (Object)adaptor.create(DIV49);
                    adaptor.addChild(root_0, DIV49_tree);
                    }

                    }
                    break;

            }
            } finally {dbg.exitSubRule(15);}

            dbg.location(52,14);
            ID50=(Token)match(input,ID,FOLLOW_ID_in_image428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID50_tree = (Object)adaptor.create(ID50);
            adaptor.addChild(root_0, ID50_tree);
            }
            dbg.location(52,17);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:52:17: ( DIV ID )*
            try { dbg.enterSubRule(16);

            loop16:
            do {
                int alt16=2;
                try { dbg.enterDecision(16);

                int LA16_0 = input.LA(1);

                if ( (LA16_0==DIV) ) {
                    alt16=1;
                }


                } finally {dbg.exitDecision(16);}

                switch (alt16) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:52:18: DIV ID
            	    {
            	    dbg.location(52,18);
            	    DIV51=(Token)match(input,DIV,FOLLOW_DIV_in_image431); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV51_tree = (Object)adaptor.create(DIV51);
            	    adaptor.addChild(root_0, DIV51_tree);
            	    }
            	    dbg.location(52,22);
            	    ID52=(Token)match(input,ID,FOLLOW_ID_in_image433); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    ID52_tree = (Object)adaptor.create(ID52);
            	    adaptor.addChild(root_0, ID52_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);
            } finally {dbg.exitSubRule(16);}

            dbg.location(52,27);
            char_literal53=(Token)match(input,42,FOLLOW_42_in_image437); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = (Object)adaptor.create(char_literal53);
            adaptor.addChild(root_0, char_literal53_tree);
            }
            dbg.location(52,31);
            ID54=(Token)match(input,ID,FOLLOW_ID_in_image439); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID54_tree = (Object)adaptor.create(ID54);
            adaptor.addChild(root_0, ID54_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(52, 33);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "image");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "image"

    public static class coordinateSystem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "coordinateSystem"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:54:1: coordinateSystem : ( 'hex' coord ( size )? ( location )? | 'square' coord ( size )? ( location )? | 'free' ( size )? ( location )? );
    public final MappingDSLParser.coordinateSystem_return coordinateSystem() throws RecognitionException {
        MappingDSLParser.coordinateSystem_return retval = new MappingDSLParser.coordinateSystem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal55=null;
        Token string_literal59=null;
        Token string_literal63=null;
        MappingDSLParser.coord_return coord56 = null;

        MappingDSLParser.size_return size57 = null;

        MappingDSLParser.location_return location58 = null;

        MappingDSLParser.coord_return coord60 = null;

        MappingDSLParser.size_return size61 = null;

        MappingDSLParser.location_return location62 = null;

        MappingDSLParser.size_return size64 = null;

        MappingDSLParser.location_return location65 = null;


        Object string_literal55_tree=null;
        Object string_literal59_tree=null;
        Object string_literal63_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "coordinateSystem");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(54, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:55:2: ( 'hex' coord ( size )? ( location )? | 'square' coord ( size )? ( location )? | 'free' ( size )? ( location )? )
            int alt23=3;
            try { dbg.enterDecision(23);

            switch ( input.LA(1) ) {
            case 43:
                {
                alt23=1;
                }
                break;
            case 44:
                {
                alt23=2;
                }
                break;
            case 45:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(23);}

            switch (alt23) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:55:4: 'hex' coord ( size )? ( location )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(55,4);
                    string_literal55=(Token)match(input,43,FOLLOW_43_in_coordinateSystem448); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (Object)adaptor.create(string_literal55);
                    adaptor.addChild(root_0, string_literal55_tree);
                    }
                    dbg.location(55,10);
                    pushFollow(FOLLOW_coord_in_coordinateSystem450);
                    coord56=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord56.getTree());
                    dbg.location(55,16);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:55:16: ( size )?
                    int alt17=2;
                    try { dbg.enterSubRule(17);
                    try { dbg.enterDecision(17);

                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=46 && LA17_0<=47)) ) {
                        alt17=1;
                    }
                    } finally {dbg.exitDecision(17);}

                    switch (alt17) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(55,16);
                            pushFollow(FOLLOW_size_in_coordinateSystem452);
                            size57=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, size57.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(17);}

                    dbg.location(55,22);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:55:22: ( location )?
                    int alt18=2;
                    try { dbg.enterSubRule(18);
                    try { dbg.enterDecision(18);

                    int LA18_0 = input.LA(1);

                    if ( ((LA18_0>=48 && LA18_0<=49)) ) {
                        alt18=1;
                    }
                    } finally {dbg.exitDecision(18);}

                    switch (alt18) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: location
                            {
                            dbg.location(55,22);
                            pushFollow(FOLLOW_location_in_coordinateSystem455);
                            location58=location();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, location58.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(18);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:4: 'square' coord ( size )? ( location )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(56,4);
                    string_literal59=(Token)match(input,44,FOLLOW_44_in_coordinateSystem461); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal59_tree = (Object)adaptor.create(string_literal59);
                    adaptor.addChild(root_0, string_literal59_tree);
                    }
                    dbg.location(56,13);
                    pushFollow(FOLLOW_coord_in_coordinateSystem463);
                    coord60=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord60.getTree());
                    dbg.location(56,19);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:19: ( size )?
                    int alt19=2;
                    try { dbg.enterSubRule(19);
                    try { dbg.enterDecision(19);

                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=46 && LA19_0<=47)) ) {
                        alt19=1;
                    }
                    } finally {dbg.exitDecision(19);}

                    switch (alt19) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(56,19);
                            pushFollow(FOLLOW_size_in_coordinateSystem465);
                            size61=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, size61.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(19);}

                    dbg.location(56,25);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:25: ( location )?
                    int alt20=2;
                    try { dbg.enterSubRule(20);
                    try { dbg.enterDecision(20);

                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=48 && LA20_0<=49)) ) {
                        alt20=1;
                    }
                    } finally {dbg.exitDecision(20);}

                    switch (alt20) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: location
                            {
                            dbg.location(56,25);
                            pushFollow(FOLLOW_location_in_coordinateSystem468);
                            location62=location();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, location62.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(20);}


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:57:4: 'free' ( size )? ( location )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(57,4);
                    string_literal63=(Token)match(input,45,FOLLOW_45_in_coordinateSystem474); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal63_tree = (Object)adaptor.create(string_literal63);
                    adaptor.addChild(root_0, string_literal63_tree);
                    }
                    dbg.location(57,11);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:57:11: ( size )?
                    int alt21=2;
                    try { dbg.enterSubRule(21);
                    try { dbg.enterDecision(21);

                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=46 && LA21_0<=47)) ) {
                        alt21=1;
                    }
                    } finally {dbg.exitDecision(21);}

                    switch (alt21) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(57,11);
                            pushFollow(FOLLOW_size_in_coordinateSystem476);
                            size64=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, size64.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(21);}

                    dbg.location(57,17);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:57:17: ( location )?
                    int alt22=2;
                    try { dbg.enterSubRule(22);
                    try { dbg.enterDecision(22);

                    int LA22_0 = input.LA(1);

                    if ( ((LA22_0>=48 && LA22_0<=49)) ) {
                        alt22=1;
                    }
                    } finally {dbg.exitDecision(22);}

                    switch (alt22) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: location
                            {
                            dbg.location(57,17);
                            pushFollow(FOLLOW_location_in_coordinateSystem479);
                            location65=location();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, location65.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(22);}


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(58, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "coordinateSystem");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "coordinateSystem"

    public static class size_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "size"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:60:1: size : ( 'size' coord | 'each' INT );
    public final MappingDSLParser.size_return size() throws RecognitionException {
        MappingDSLParser.size_return retval = new MappingDSLParser.size_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal66=null;
        Token string_literal68=null;
        Token INT69=null;
        MappingDSLParser.coord_return coord67 = null;


        Object string_literal66_tree=null;
        Object string_literal68_tree=null;
        Object INT69_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "size");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(60, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:60:6: ( 'size' coord | 'each' INT )
            int alt24=2;
            try { dbg.enterDecision(24);

            int LA24_0 = input.LA(1);

            if ( (LA24_0==46) ) {
                alt24=1;
            }
            else if ( (LA24_0==47) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(24);}

            switch (alt24) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:60:8: 'size' coord
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(60,8);
                    string_literal66=(Token)match(input,46,FOLLOW_46_in_size490); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal66_tree = (Object)adaptor.create(string_literal66);
                    adaptor.addChild(root_0, string_literal66_tree);
                    }
                    dbg.location(60,15);
                    pushFollow(FOLLOW_coord_in_size492);
                    coord67=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord67.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:61:4: 'each' INT
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(61,4);
                    string_literal68=(Token)match(input,47,FOLLOW_47_in_size497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal68_tree = (Object)adaptor.create(string_literal68);
                    adaptor.addChild(root_0, string_literal68_tree);
                    }
                    dbg.location(61,11);
                    INT69=(Token)match(input,INT,FOLLOW_INT_in_size499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT69_tree = (Object)adaptor.create(INT69);
                    adaptor.addChild(root_0, INT69_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(61, 14);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "size");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "size"

    public static class location_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "location"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:1: location : ( 'within' ID expr | 'beside' ID DIRECTION );
    public final MappingDSLParser.location_return location() throws RecognitionException {
        MappingDSLParser.location_return retval = new MappingDSLParser.location_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal70=null;
        Token ID71=null;
        Token string_literal73=null;
        Token ID74=null;
        Token DIRECTION75=null;
        MappingDSLParser.expr_return expr72 = null;


        Object string_literal70_tree=null;
        Object ID71_tree=null;
        Object string_literal73_tree=null;
        Object ID74_tree=null;
        Object DIRECTION75_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "location");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(63, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:10: ( 'within' ID expr | 'beside' ID DIRECTION )
            int alt25=2;
            try { dbg.enterDecision(25);

            int LA25_0 = input.LA(1);

            if ( (LA25_0==48) ) {
                alt25=1;
            }
            else if ( (LA25_0==49) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(25);}

            switch (alt25) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:12: 'within' ID expr
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(63,12);
                    string_literal70=(Token)match(input,48,FOLLOW_48_in_location507); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal70_tree = (Object)adaptor.create(string_literal70);
                    adaptor.addChild(root_0, string_literal70_tree);
                    }
                    dbg.location(63,21);
                    ID71=(Token)match(input,ID,FOLLOW_ID_in_location509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID71_tree = (Object)adaptor.create(ID71);
                    adaptor.addChild(root_0, ID71_tree);
                    }
                    dbg.location(63,24);
                    pushFollow(FOLLOW_expr_in_location511);
                    expr72=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr72.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:64:4: 'beside' ID DIRECTION
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(64,4);
                    string_literal73=(Token)match(input,49,FOLLOW_49_in_location516); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal73_tree = (Object)adaptor.create(string_literal73);
                    adaptor.addChild(root_0, string_literal73_tree);
                    }
                    dbg.location(64,13);
                    ID74=(Token)match(input,ID,FOLLOW_ID_in_location518); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID74_tree = (Object)adaptor.create(ID74);
                    adaptor.addChild(root_0, ID74_tree);
                    }
                    dbg.location(64,16);
                    DIRECTION75=(Token)match(input,DIRECTION,FOLLOW_DIRECTION_in_location520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIRECTION75_tree = (Object)adaptor.create(DIRECTION75);
                    adaptor.addChild(root_0, DIRECTION75_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(64, 25);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "location");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "location"

    public static class proc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "proc"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:1: proc : 'proc' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' (a+= areaAction | a+= procCall ';' )+ '}' -> ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) ) ;
    public final MappingDSLParser.proc_return proc() throws RecognitionException {
        MappingDSLParser.proc_return retval = new MappingDSLParser.proc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token string_literal76=null;
        Token char_literal77=null;
        Token char_literal78=null;
        Token char_literal79=null;
        Token char_literal80=null;
        Token char_literal81=null;
        Token char_literal82=null;
        Token arg=null;
        List list_arg=null;
        List list_a=null;
        RuleReturnScope a = null;
        Object name_tree=null;
        Object string_literal76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal78_tree=null;
        Object char_literal79_tree=null;
        Object char_literal80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal82_tree=null;
        Object arg_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_areaAction=new RewriteRuleSubtreeStream(adaptor,"rule areaAction");
        RewriteRuleSubtreeStream stream_procCall=new RewriteRuleSubtreeStream(adaptor,"rule procCall");
        try { dbg.enterRule(getGrammarFileName(), "proc");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:6: ( 'proc' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' (a+= areaAction | a+= procCall ';' )+ '}' -> ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:8: 'proc' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' (a+= areaAction | a+= procCall ';' )+ '}'
            {
            dbg.location(66,8);
            string_literal76=(Token)match(input,50,FOLLOW_50_in_proc528); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(string_literal76);

            dbg.location(66,19);
            name=(Token)match(input,ID,FOLLOW_ID_in_proc532); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            dbg.location(66,23);
            char_literal77=(Token)match(input,39,FOLLOW_39_in_proc534); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(char_literal77);

            dbg.location(66,27);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:27: (arg+= ID ( ',' arg+= ID )* )?
            int alt27=2;
            try { dbg.enterSubRule(27);
            try { dbg.enterDecision(27);

            int LA27_0 = input.LA(1);

            if ( (LA27_0==ID) ) {
                alt27=1;
            }
            } finally {dbg.exitDecision(27);}

            switch (alt27) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:28: arg+= ID ( ',' arg+= ID )*
                    {
                    dbg.location(66,31);
                    arg=(Token)match(input,ID,FOLLOW_ID_in_proc539); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(arg);

                    if (list_arg==null) list_arg=new ArrayList();
                    list_arg.add(arg);

                    dbg.location(66,36);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:36: ( ',' arg+= ID )*
                    try { dbg.enterSubRule(26);

                    loop26:
                    do {
                        int alt26=2;
                        try { dbg.enterDecision(26);

                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==41) ) {
                            alt26=1;
                        }


                        } finally {dbg.exitDecision(26);}

                        switch (alt26) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:37: ',' arg+= ID
                    	    {
                    	    dbg.location(66,37);
                    	    char_literal78=(Token)match(input,41,FOLLOW_41_in_proc542); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_41.add(char_literal78);

                    	    dbg.location(66,44);
                    	    arg=(Token)match(input,ID,FOLLOW_ID_in_proc546); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(arg);

                    	    if (list_arg==null) list_arg=new ArrayList();
                    	    list_arg.add(arg);


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(26);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(27);}

            dbg.location(66,53);
            char_literal79=(Token)match(input,40,FOLLOW_40_in_proc552); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal79);

            dbg.location(66,57);
            char_literal80=(Token)match(input,51,FOLLOW_51_in_proc554); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(char_literal80);

            dbg.location(66,61);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:61: (a+= areaAction | a+= procCall ';' )+
            int cnt28=0;
            try { dbg.enterSubRule(28);

            loop28:
            do {
                int alt28=3;
                try { dbg.enterDecision(28);

                try {
                    isCyclicDecision = true;
                    alt28 = dfa28.predict(input);
                }
                catch (NoViableAltException nvae) {
                    dbg.recognitionException(nvae);
                    throw nvae;
                }
                } finally {dbg.exitDecision(28);}

                switch (alt28) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:62: a+= areaAction
            	    {
            	    dbg.location(66,63);
            	    pushFollow(FOLLOW_areaAction_in_proc559);
            	    a=areaAction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_areaAction.add(a.getTree());
            	    if (list_a==null) list_a=new ArrayList();
            	    list_a.add(a.getTree());


            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:76: a+= procCall ';'
            	    {
            	    dbg.location(66,77);
            	    pushFollow(FOLLOW_procCall_in_proc563);
            	    a=procCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_procCall.add(a.getTree());
            	    if (list_a==null) list_a=new ArrayList();
            	    list_a.add(a.getTree());

            	    dbg.location(66,88);
            	    char_literal81=(Token)match(input,38,FOLLOW_38_in_proc565); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_38.add(char_literal81);


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt28++;
            } while (true);
            } finally {dbg.exitSubRule(28);}

            dbg.location(66,94);
            char_literal82=(Token)match(input,52,FOLLOW_52_in_proc569); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_52.add(char_literal82);



            // AST REWRITE
            // elements: arg, a
            // token labels: 
            // rule labels: retval
            // token list labels: arg
            // rule list labels: a
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_arg=new RewriteRuleTokenStream(adaptor,"token arg", list_arg);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"token a",list_a);
            root_0 = (Object)adaptor.nil();
            // 66:98: -> ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) )
            {
                dbg.location(66,101);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:101: ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(66,103);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCEDURE, (name!=null?name.getText():null)), root_1);

                dbg.location(66,125);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:125: ^( ARGLIST ( $arg)* )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(66,127);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGLIST, "ARGLIST"), root_2);

                dbg.location(66,135);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:135: ( $arg)*
                while ( stream_arg.hasNext() ) {
                    dbg.location(66,135);
                    adaptor.addChild(root_2, stream_arg.nextNode());

                }
                stream_arg.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(66,142);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:142: ^( BODY ( $a)+ )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(66,144);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_2);

                dbg.location(66,149);
                if ( !(stream_a.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_a.hasNext() ) {
                    dbg.location(66,149);
                    adaptor.addChild(root_2, stream_a.nextTree());

                }
                stream_a.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(66, 154);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "proc");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "proc"

    public static class func_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "func"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:1: func : 'func' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' expr ( ';' )? '}' -> ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) ) ;
    public final MappingDSLParser.func_return func() throws RecognitionException {
        MappingDSLParser.func_return retval = new MappingDSLParser.func_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token string_literal83=null;
        Token char_literal84=null;
        Token char_literal85=null;
        Token char_literal86=null;
        Token char_literal87=null;
        Token char_literal89=null;
        Token char_literal90=null;
        Token arg=null;
        List list_arg=null;
        MappingDSLParser.expr_return expr88 = null;


        Object name_tree=null;
        Object string_literal83_tree=null;
        Object char_literal84_tree=null;
        Object char_literal85_tree=null;
        Object char_literal86_tree=null;
        Object char_literal87_tree=null;
        Object char_literal89_tree=null;
        Object char_literal90_tree=null;
        Object arg_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try { dbg.enterRule(getGrammarFileName(), "func");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(68, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:6: ( 'func' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' expr ( ';' )? '}' -> ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:8: 'func' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' expr ( ';' )? '}'
            {
            dbg.location(68,8);
            string_literal83=(Token)match(input,53,FOLLOW_53_in_func600); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_53.add(string_literal83);

            dbg.location(68,19);
            name=(Token)match(input,ID,FOLLOW_ID_in_func604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            dbg.location(68,23);
            char_literal84=(Token)match(input,39,FOLLOW_39_in_func606); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(char_literal84);

            dbg.location(68,27);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:27: (arg+= ID ( ',' arg+= ID )* )?
            int alt30=2;
            try { dbg.enterSubRule(30);
            try { dbg.enterDecision(30);

            int LA30_0 = input.LA(1);

            if ( (LA30_0==ID) ) {
                alt30=1;
            }
            } finally {dbg.exitDecision(30);}

            switch (alt30) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:28: arg+= ID ( ',' arg+= ID )*
                    {
                    dbg.location(68,31);
                    arg=(Token)match(input,ID,FOLLOW_ID_in_func611); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(arg);

                    if (list_arg==null) list_arg=new ArrayList();
                    list_arg.add(arg);

                    dbg.location(68,36);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:36: ( ',' arg+= ID )*
                    try { dbg.enterSubRule(29);

                    loop29:
                    do {
                        int alt29=2;
                        try { dbg.enterDecision(29);

                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==41) ) {
                            alt29=1;
                        }


                        } finally {dbg.exitDecision(29);}

                        switch (alt29) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:37: ',' arg+= ID
                    	    {
                    	    dbg.location(68,37);
                    	    char_literal85=(Token)match(input,41,FOLLOW_41_in_func614); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_41.add(char_literal85);

                    	    dbg.location(68,44);
                    	    arg=(Token)match(input,ID,FOLLOW_ID_in_func618); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(arg);

                    	    if (list_arg==null) list_arg=new ArrayList();
                    	    list_arg.add(arg);


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(29);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(30);}

            dbg.location(68,53);
            char_literal86=(Token)match(input,40,FOLLOW_40_in_func624); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal86);

            dbg.location(68,57);
            char_literal87=(Token)match(input,51,FOLLOW_51_in_func626); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(char_literal87);

            dbg.location(68,61);
            pushFollow(FOLLOW_expr_in_func628);
            expr88=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr88.getTree());
            dbg.location(68,66);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:66: ( ';' )?
            int alt31=2;
            try { dbg.enterSubRule(31);
            try { dbg.enterDecision(31);

            int LA31_0 = input.LA(1);

            if ( (LA31_0==38) ) {
                alt31=1;
            }
            } finally {dbg.exitDecision(31);}

            switch (alt31) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: ';'
                    {
                    dbg.location(68,66);
                    char_literal89=(Token)match(input,38,FOLLOW_38_in_func630); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal89);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(31);}

            dbg.location(68,71);
            char_literal90=(Token)match(input,52,FOLLOW_52_in_func633); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_52.add(char_literal90);



            // AST REWRITE
            // elements: arg, expr
            // token labels: 
            // rule labels: retval
            // token list labels: arg
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_arg=new RewriteRuleTokenStream(adaptor,"token arg", list_arg);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 68:75: -> ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) )
            {
                dbg.location(68,78);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:78: ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(68,80);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, (name!=null?name.getText():null)), root_1);

                dbg.location(68,101);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:101: ^( ARGLIST ( $arg)* )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(68,103);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGLIST, "ARGLIST"), root_2);

                dbg.location(68,111);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:111: ( $arg)*
                while ( stream_arg.hasNext() ) {
                    dbg.location(68,111);
                    adaptor.addChild(root_2, stream_arg.nextNode());

                }
                stream_arg.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(68,118);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:68:118: ^( BODY expr )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(68,120);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_2);

                dbg.location(68,125);
                adaptor.addChild(root_2, stream_expr.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(68, 131);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "func");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "func"

    public static class coord_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "coord"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:1: coord : '[' ( expr ) ',' ( expr ) ']' ;
    public final MappingDSLParser.coord_return coord() throws RecognitionException {
        MappingDSLParser.coord_return retval = new MappingDSLParser.coord_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal91=null;
        Token char_literal93=null;
        Token char_literal95=null;
        MappingDSLParser.expr_return expr92 = null;

        MappingDSLParser.expr_return expr94 = null;


        Object char_literal91_tree=null;
        Object char_literal93_tree=null;
        Object char_literal95_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "coord");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(71, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:7: ( '[' ( expr ) ',' ( expr ) ']' )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:10: '[' ( expr ) ',' ( expr ) ']'
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(71,10);
            char_literal91=(Token)match(input,54,FOLLOW_54_in_coord664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal91_tree = (Object)adaptor.create(char_literal91);
            adaptor.addChild(root_0, char_literal91_tree);
            }
            dbg.location(71,14);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:14: ( expr )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:15: expr
            {
            dbg.location(71,15);
            pushFollow(FOLLOW_expr_in_coord667);
            expr92=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr92.getTree());

            }

            dbg.location(71,24);
            char_literal93=(Token)match(input,41,FOLLOW_41_in_coord670); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal93_tree = (Object)adaptor.create(char_literal93);
            root_0 = (Object)adaptor.becomeRoot(char_literal93_tree, root_0);
            }
            dbg.location(71,26);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:26: ( expr )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:27: expr
            {
            dbg.location(71,27);
            pushFollow(FOLLOW_expr_in_coord674);
            expr94=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr94.getTree());

            }

            dbg.location(71,33);
            char_literal95=(Token)match(input,55,FOLLOW_55_in_coord677); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal95_tree = (Object)adaptor.create(char_literal95);
            adaptor.addChild(root_0, char_literal95_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(72, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "coord");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "coord"

    public static class offset_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "offset"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:1: offset : '[' ( '+' | '-' ) ( ID | INT ) ',' ( '+' | '-' ) ( ID | INT ) ']' ;
    public final MappingDSLParser.offset_return offset() throws RecognitionException {
        MappingDSLParser.offset_return retval = new MappingDSLParser.offset_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal96=null;
        Token set97=null;
        Token set98=null;
        Token char_literal99=null;
        Token set100=null;
        Token set101=null;
        Token char_literal102=null;

        Object char_literal96_tree=null;
        Object set97_tree=null;
        Object set98_tree=null;
        Object char_literal99_tree=null;
        Object set100_tree=null;
        Object set101_tree=null;
        Object char_literal102_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "offset");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(74, 1);

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:9: ( '[' ( '+' | '-' ) ( ID | INT ) ',' ( '+' | '-' ) ( ID | INT ) ']' )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:11: '[' ( '+' | '-' ) ( ID | INT ) ',' ( '+' | '-' ) ( ID | INT ) ']'
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(74,11);
            char_literal96=(Token)match(input,54,FOLLOW_54_in_offset689); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal96_tree = (Object)adaptor.create(char_literal96);
            adaptor.addChild(root_0, char_literal96_tree);
            }
            dbg.location(74,15);
            set97=(Token)input.LT(1);
            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set97));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(74,25);
            set98=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==INT ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set98));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(74,37);
            char_literal99=(Token)match(input,41,FOLLOW_41_in_offset703); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal99_tree = (Object)adaptor.create(char_literal99);
            root_0 = (Object)adaptor.becomeRoot(char_literal99_tree, root_0);
            }
            dbg.location(74,39);
            set100=(Token)input.LT(1);
            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set100));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(74,49);
            set101=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==INT ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set101));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(74,58);
            char_literal102=(Token)match(input,55,FOLLOW_55_in_offset718); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal102_tree = (Object)adaptor.create(char_literal102);
            adaptor.addChild(root_0, char_literal102_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(75, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "offset");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "offset"

    // $ANTLR start synpred9_MappingDSL
    public final void synpred9_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:10: ( image )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:11: image
        {
        dbg.location(33,11);
        pushFollow(FOLLOW_image_in_synpred9_MappingDSL166);
        image();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_MappingDSL

    // $ANTLR start synpred10_MappingDSL
    public final void synpred10_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:34:4: ( COLOR )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:34:5: COLOR
        {
        dbg.location(34,5);
        match(input,COLOR,FOLLOW_COLOR_in_synpred10_MappingDSL183); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_MappingDSL

    // $ANTLR start synpred11_MappingDSL
    public final void synpred11_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:35:4: ( procCall )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:35:5: procCall
        {
        dbg.location(35,5);
        pushFollow(FOLLOW_procCall_in_synpred11_MappingDSL193);
        procCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_MappingDSL

    // $ANTLR start synpred12_MappingDSL
    public final void synpred12_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:39:4: ( coord )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:39:5: coord
        {
        dbg.location(39,5);
        pushFollow(FOLLOW_coord_in_synpred12_MappingDSL213);
        coord();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_MappingDSL

    // $ANTLR start synpred15_MappingDSL
    public final void synpred15_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:40:4: ( offset )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:40:5: offset
        {
        dbg.location(40,5);
        pushFollow(FOLLOW_offset_in_synpred15_MappingDSL235);
        offset();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_MappingDSL

    // $ANTLR start synpred16_MappingDSL
    public final void synpred16_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:41:4: ( FLOAT )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:41:5: FLOAT
        {
        dbg.location(41,5);
        match(input,FLOAT,FOLLOW_FLOAT_in_synpred16_MappingDSL245); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_MappingDSL

    // $ANTLR start synpred21_MappingDSL
    public final void synpred21_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:42:4: ( INT )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:42:5: INT
        {
        dbg.location(42,5);
        match(input,INT,FOLLOW_INT_in_synpred21_MappingDSL271); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_MappingDSL

    // $ANTLR start synpred27_MappingDSL
    public final void synpred27_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:43:4: ( STRING )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:43:5: STRING
        {
        dbg.location(43,5);
        match(input,STRING,FOLLOW_STRING_in_synpred27_MappingDSL299); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_MappingDSL

    // $ANTLR start synpred29_MappingDSL
    public final void synpred29_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:44:4: ( procCall )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:44:5: procCall
        {
        dbg.location(44,5);
        pushFollow(FOLLOW_procCall_in_synpred29_MappingDSL317);
        procCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_MappingDSL

    // $ANTLR start synpred32_MappingDSL
    public final void synpred32_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:45:4: ( '(' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:45:5: '('
        {
        dbg.location(45,5);
        match(input,39,FOLLOW_39_in_synpred32_MappingDSL340); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_MappingDSL

    // $ANTLR start synpred37_MappingDSL
    public final void synpred37_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:25: ( ',' expr )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:25: ',' expr
        {
        dbg.location(49,25);
        match(input,41,FOLLOW_41_in_synpred37_MappingDSL387); if (state.failed) return ;
        dbg.location(49,29);
        pushFollow(FOLLOW_expr_in_synpred37_MappingDSL389);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_MappingDSL

    // $ANTLR start synpred54_MappingDSL
    public final void synpred54_MappingDSL_fragment() throws RecognitionException {   
        List list_a=null;
        RuleReturnScope a = null;
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:62: (a+= areaAction )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:62: a+= areaAction
        {
        dbg.location(66,63);
        pushFollow(FOLLOW_areaAction_in_synpred54_MappingDSL559);
        a=areaAction();

        state._fsp--;
        if (state.failed) return ;
        if (list_a==null) list_a=new ArrayList();
        list_a.add(a);


        }
    }
    // $ANTLR end synpred54_MappingDSL

    // $ANTLR start synpred55_MappingDSL
    public final void synpred55_MappingDSL_fragment() throws RecognitionException {   
        List list_a=null;
        RuleReturnScope a = null;
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:76: (a+= procCall ';' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:66:76: a+= procCall ';'
        {
        dbg.location(66,77);
        pushFollow(FOLLOW_procCall_in_synpred55_MappingDSL563);
        a=procCall();

        state._fsp--;
        if (state.failed) return ;
        if (list_a==null) list_a=new ArrayList();
        list_a.add(a);

        dbg.location(66,88);
        match(input,38,FOLLOW_38_in_synpred55_MappingDSL565); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_MappingDSL

    // Delegated rules

    public final boolean synpred54_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred54_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred32_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred15_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred12_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred9_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred37_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred29_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred55_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred10_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred21_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred11_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred16_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred27_MappingDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA1_eotS =
        "\23\uffff";
    static final String DFA1_eofS =
        "\1\1\22\uffff";
    static final String DFA1_minS =
        "\1\22\1\uffff\1\24\7\uffff\1\22\10\uffff";
    static final String DFA1_maxS =
        "\1\66\1\uffff\1\47\7\uffff\1\55\10\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\5\1\uffff\1\2\4\uffff\1\3\1\4\3\uffff\1\1\5\uffff";
    static final String DFA1_specialS =
        "\23\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\uffff\1\3\2\uffff\1\3\1\uffff\1\3\13\uffff\1\3\12\uffff"+
            "\1\10\2\uffff\1\11\1\3",
            "",
            "\2\3\1\uffff\2\3\12\uffff\1\12\3\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\3\4\uffff\1\3\22\uffff\3\15",
            "",
            "",
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
            return "()* loopback of 26:8: ( context | areaAction | proc | func )*";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA4_eotS =
        "\12\uffff";
    static final String DFA4_eofS =
        "\2\uffff\1\7\7\uffff";
    static final String DFA4_minS =
        "\1\22\1\uffff\1\30\7\uffff";
    static final String DFA4_maxS =
        "\1\30\1\uffff\1\52\7\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\2\1\1\4\2\uffff";
    static final String DFA4_specialS =
        "\1\0\1\uffff\1\1\7\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\1\3\4\uffff\1\1",
            "",
            "\1\5\15\uffff\1\7\1\4\1\7\1\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "33:1: action : ( ( image )=> image -> ^( IMAGE[$image.text] ) | ( COLOR )=> COLOR | ( procCall )=> procCall | ID );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                         
                        int index4_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA4_0==DIV) && (synpred9_MappingDSL())) {s = 1;}

                        else if ( (LA4_0==ID) ) {s = 2;}

                        else if ( (LA4_0==COLOR) && (synpred10_MappingDSL())) {s = 3;}

                         
                        input.seek(index4_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_2 = input.LA(1);

                         
                        int index4_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA4_2==39) && (synpred11_MappingDSL())) {s = 4;}

                        else if ( (LA4_2==DIV) && (synpred9_MappingDSL())) {s = 5;}

                        else if ( (LA4_2==42) && (synpred9_MappingDSL())) {s = 6;}

                        else if ( (LA4_2==EOF||LA4_2==38||LA4_2==40) ) {s = 7;}

                         
                        input.seek(index4_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA11_eotS =
        "\31\uffff";
    static final String DFA11_eofS =
        "\5\uffff\1\17\23\uffff";
    static final String DFA11_minS =
        "\2\22\3\uffff\1\24\23\uffff";
    static final String DFA11_maxS =
        "\2\66\3\uffff\1\67\23\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\uffff\1\7\1\2\6\1\1\6\1\10\11\uffff";
    static final String DFA11_specialS =
        "\1\0\1\1\3\uffff\1\2\23\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\5\3\uffff\1\2\2\uffff\1\3\1\uffff\1\4\13\uffff\1\6\16\uffff"+
            "\1\1",
            "\1\14\1\uffff\2\7\1\11\2\uffff\1\12\1\uffff\1\13\13\uffff\1"+
            "\15\16\uffff\1\10",
            "",
            "",
            "",
            "\2\17\1\uffff\2\17\12\uffff\4\17\1\16\2\17\12\uffff\1\17\2"+
            "\uffff\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "38:1: expr : ( ( coord )=> coord ( ( DASH | PLUS ) expr )? | ( offset )=> offset | ( FLOAT )=> FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )? | ( INT )=> INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )? | ( STRING )=> STRING ( PLUS expr )? | ( procCall )=> procCall ( ( DASH | PLUS ) expr )? | ( '(' )=> '(' expr ')' | ID ( ( DASH | PLUS | MULT | DIV ) expr )? );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_0 = input.LA(1);

                         
                        int index11_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_0==54) ) {s = 1;}

                        else if ( (LA11_0==FLOAT) && (synpred16_MappingDSL())) {s = 2;}

                        else if ( (LA11_0==INT) && (synpred21_MappingDSL())) {s = 3;}

                        else if ( (LA11_0==STRING) && (synpred27_MappingDSL())) {s = 4;}

                        else if ( (LA11_0==ID) ) {s = 5;}

                        else if ( (LA11_0==39) && (synpred32_MappingDSL())) {s = 6;}

                         
                        input.seek(index11_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA11_1>=DASH && LA11_1<=PLUS)) && (synpred15_MappingDSL())) {s = 7;}

                        else if ( (LA11_1==54) && (synpred12_MappingDSL())) {s = 8;}

                        else if ( (LA11_1==FLOAT) && (synpred12_MappingDSL())) {s = 9;}

                        else if ( (LA11_1==INT) && (synpred12_MappingDSL())) {s = 10;}

                        else if ( (LA11_1==STRING) && (synpred12_MappingDSL())) {s = 11;}

                        else if ( (LA11_1==ID) && (synpred12_MappingDSL())) {s = 12;}

                        else if ( (LA11_1==39) && (synpred12_MappingDSL())) {s = 13;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA11_5==39) && (synpred29_MappingDSL())) {s = 14;}

                        else if ( (LA11_5==EOF||(LA11_5>=DASH && LA11_5<=PLUS)||(LA11_5>=MULT && LA11_5<=DIV)||(LA11_5>=35 && LA11_5<=38)||(LA11_5>=40 && LA11_5<=41)||LA11_5==52||LA11_5==55) ) {s = 15;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA5_eotS =
        "\13\uffff";
    static final String DFA5_eofS =
        "\1\2\12\uffff";
    static final String DFA5_minS =
        "\1\24\12\uffff";
    static final String DFA5_maxS =
        "\1\67\12\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA5_specialS =
        "\13\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\1\15\uffff\4\2\1\uffff\2\2\12\uffff\1\2\2\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "39:20: ( ( DASH | PLUS ) expr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA6_eotS =
        "\13\uffff";
    static final String DFA6_eofS =
        "\1\2\12\uffff";
    static final String DFA6_minS =
        "\1\24\12\uffff";
    static final String DFA6_maxS =
        "\1\67\12\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA6_specialS =
        "\13\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\1\1\uffff\2\1\12\uffff\4\2\1\uffff\2\2\12\uffff\1\2\2\uffff"+
            "\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "41:20: ( ( DASH | PLUS | MULT | DIV ) expr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA7_eotS =
        "\13\uffff";
    static final String DFA7_eofS =
        "\1\2\12\uffff";
    static final String DFA7_minS =
        "\1\24\12\uffff";
    static final String DFA7_maxS =
        "\1\67\12\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA7_specialS =
        "\13\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\1\1\uffff\2\1\1\uffff\1\1\10\uffff\4\2\1\uffff\2\2\12\uffff"+
            "\1\2\2\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "42:16: ( ( DASH | PLUS | MULT | DIV | OP ) expr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA8_eotS =
        "\13\uffff";
    static final String DFA8_eofS =
        "\1\2\12\uffff";
    static final String DFA8_minS =
        "\1\25\12\uffff";
    static final String DFA8_maxS =
        "\1\67\12\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA8_specialS =
        "\13\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\15\uffff\4\2\1\uffff\2\2\12\uffff\1\2\2\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "43:22: ( PLUS expr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA9_eotS =
        "\13\uffff";
    static final String DFA9_eofS =
        "\1\2\12\uffff";
    static final String DFA9_minS =
        "\1\24\12\uffff";
    static final String DFA9_maxS =
        "\1\67\12\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA9_specialS =
        "\13\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\1\15\uffff\4\2\1\uffff\2\2\12\uffff\1\2\2\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "44:26: ( ( DASH | PLUS ) expr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA10_eotS =
        "\13\uffff";
    static final String DFA10_eofS =
        "\1\2\12\uffff";
    static final String DFA10_minS =
        "\1\24\12\uffff";
    static final String DFA10_maxS =
        "\1\67\12\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\1\1\uffff\2\1\12\uffff\4\2\1\uffff\2\2\12\uffff\1\2\2\uffff"+
            "\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "46:7: ( ( DASH | PLUS | MULT | DIV ) expr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA12_eotS =
        "\21\uffff";
    static final String DFA12_eofS =
        "\21\uffff";
    static final String DFA12_minS =
        "\1\50\1\22\5\uffff\1\0\11\uffff";
    static final String DFA12_maxS =
        "\1\51\1\66\5\uffff\1\0\11\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\1\15\uffff";
    static final String DFA12_specialS =
        "\7\uffff\1\0\11\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\1\1",
            "\1\7\1\2\2\uffff\1\3\1\uffff\1\2\1\3\1\uffff\1\3\13\uffff\1"+
            "\3\16\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()* loopback of 49:24: ( ',' expr )*";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_7 = input.LA(1);

                         
                        int index12_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_MappingDSL()) ) {s = 3;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index12_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA28_eotS =
        "\63\uffff";
    static final String DFA28_eofS =
        "\63\uffff";
    static final String DFA28_minS =
        "\1\22\5\uffff\1\24\1\uffff\1\22\2\uffff\1\22\2\24\1\25\1\24\2\22"+
        "\1\24\35\0\3\uffff";
    static final String DFA28_maxS =
        "\1\66\5\uffff\1\47\1\uffff\1\66\2\uffff\1\66\4\51\1\66\1\30\1\46"+
        "\35\0\3\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\3\1\1\57\uffff\1\2";
    static final String DFA28_specialS =
        "\23\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\33\1\34\3\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\6\3\uffff\1\2\2\uffff\1\2\1\uffff\1\2\13\uffff\1\2\14\uffff"+
            "\1\1\1\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "\2\2\1\uffff\2\2\12\uffff\1\2\3\uffff\1\10",
            "",
            "\1\17\3\uffff\1\14\2\uffff\1\15\1\uffff\1\16\13\uffff\1\20"+
            "\1\22\1\21\14\uffff\1\13",
            "",
            "",
            "\1\30\1\uffff\2\23\1\25\2\uffff\1\26\1\uffff\1\27\13\uffff"+
            "\1\31\16\uffff\1\24",
            "\2\32\1\uffff\2\32\17\uffff\1\34\1\33",
            "\2\35\1\uffff\2\35\1\uffff\1\35\15\uffff\1\37\1\36",
            "\1\40\22\uffff\1\42\1\41",
            "\2\44\1\uffff\2\44\16\uffff\1\43\1\46\1\45",
            "\1\53\3\uffff\1\50\2\uffff\1\51\1\uffff\1\52\13\uffff\1\54"+
            "\16\uffff\1\47",
            "\1\56\1\57\4\uffff\1\55",
            "\2\2\15\uffff\1\2\2\uffff\1\62",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()+ loopback of 66:61: (a+= areaAction | a+= procCall ';' )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_19 = input.LA(1);

                         
                        int index28_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_20 = input.LA(1);

                         
                        int index28_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_20);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_21 = input.LA(1);

                         
                        int index28_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_21);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA28_22 = input.LA(1);

                         
                        int index28_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_22);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA28_23 = input.LA(1);

                         
                        int index28_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_23);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA28_24 = input.LA(1);

                         
                        int index28_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_24);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA28_25 = input.LA(1);

                         
                        int index28_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_25);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA28_26 = input.LA(1);

                         
                        int index28_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_26);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA28_27 = input.LA(1);

                         
                        int index28_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_27);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA28_28 = input.LA(1);

                         
                        int index28_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_28);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA28_29 = input.LA(1);

                         
                        int index28_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_29);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA28_30 = input.LA(1);

                         
                        int index28_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA28_31 = input.LA(1);

                         
                        int index28_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_31);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA28_32 = input.LA(1);

                         
                        int index28_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_32);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA28_33 = input.LA(1);

                         
                        int index28_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_33);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA28_34 = input.LA(1);

                         
                        int index28_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_34);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA28_35 = input.LA(1);

                         
                        int index28_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_35);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA28_36 = input.LA(1);

                         
                        int index28_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_36);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA28_37 = input.LA(1);

                         
                        int index28_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_37);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA28_38 = input.LA(1);

                         
                        int index28_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_38);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA28_39 = input.LA(1);

                         
                        int index28_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_39);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA28_40 = input.LA(1);

                         
                        int index28_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_40);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA28_41 = input.LA(1);

                         
                        int index28_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_41);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA28_42 = input.LA(1);

                         
                        int index28_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_42);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA28_43 = input.LA(1);

                         
                        int index28_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_43);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA28_44 = input.LA(1);

                         
                        int index28_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_44);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA28_45 = input.LA(1);

                         
                        int index28_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_45);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA28_46 = input.LA(1);

                         
                        int index28_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_46);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA28_47 = input.LA(1);

                         
                        int index28_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 2;}

                        else if ( (synpred55_MappingDSL()) ) {s = 50;}

                         
                        input.seek(index28_47);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_context_in_main78 = new BitSet(new long[]{0x006400800A440002L});
    public static final BitSet FOLLOW_areaAction_in_main80 = new BitSet(new long[]{0x006400800A440002L});
    public static final BitSet FOLLOW_proc_in_main82 = new BitSet(new long[]{0x006400800A440002L});
    public static final BitSet FOLLOW_func_in_main84 = new BitSet(new long[]{0x006400800A440002L});
    public static final BitSet FOLLOW_ID_in_context94 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_context96 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_coordinateSystem_in_context98 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_36_in_context103 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_37_in_context105 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_context109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_areaAction140 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_areaAction142 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_action_in_areaAction144 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_areaAction146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_image_in_action170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_action187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_action197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_action202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coord_in_expr217 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_set_in_expr220 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_expr227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_offset_in_expr239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_expr249 = new BitSet(new long[]{0x0000000001B00002L});
    public static final BitSet FOLLOW_set_in_expr252 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_expr263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_expr275 = new BitSet(new long[]{0x0000000005B00002L});
    public static final BitSet FOLLOW_set_in_expr278 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_expr291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expr303 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_PLUS_in_expr306 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_expr309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_expr321 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_set_in_expr324 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_expr331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_expr344 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_expr346 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_expr348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr353 = new BitSet(new long[]{0x0000000001B00002L});
    public static final BitSet FOLLOW_set_in_expr356 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_expr367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_procCall379 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_procCall381 = new BitSet(new long[]{0x004003800A440000L});
    public static final BitSet FOLLOW_expr_in_procCall384 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_41_in_procCall387 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_procCall389 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_41_in_procCall396 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_action_in_procCall398 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_procCall402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_image425 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_image428 = new BitSet(new long[]{0x0000040001000000L});
    public static final BitSet FOLLOW_DIV_in_image431 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_image433 = new BitSet(new long[]{0x0000040001000000L});
    public static final BitSet FOLLOW_42_in_image437 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_image439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_coordinateSystem448 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_coord_in_coordinateSystem450 = new BitSet(new long[]{0x0003C00000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem452 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_location_in_coordinateSystem455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_coordinateSystem461 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_coord_in_coordinateSystem463 = new BitSet(new long[]{0x0003C00000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem465 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_location_in_coordinateSystem468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_coordinateSystem474 = new BitSet(new long[]{0x0003C00000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem476 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_location_in_coordinateSystem479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_size490 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_coord_in_size492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_size497 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_INT_in_size499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_location507 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_location509 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_location511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_location516 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_location518 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_DIRECTION_in_location520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_proc528 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_proc532 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_proc534 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_ID_in_proc539 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_41_in_proc542 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_proc546 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_40_in_proc552 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_proc554 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_areaAction_in_proc559 = new BitSet(new long[]{0x005000800A440000L});
    public static final BitSet FOLLOW_procCall_in_proc563 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_proc565 = new BitSet(new long[]{0x005000800A440000L});
    public static final BitSet FOLLOW_52_in_proc569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_func600 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_func604 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_func606 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_ID_in_func611 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_41_in_func614 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ID_in_func618 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_40_in_func624 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_func626 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_func628 = new BitSet(new long[]{0x0010004000000000L});
    public static final BitSet FOLLOW_38_in_func630 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_func633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_coord664 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_coord667 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_coord670 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_coord674 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_coord677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_offset689 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_set_in_offset691 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_set_in_offset697 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_offset703 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_set_in_offset706 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_set_in_offset712 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_offset718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_image_in_synpred9_MappingDSL166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_synpred10_MappingDSL183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_synpred11_MappingDSL193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coord_in_synpred12_MappingDSL213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_offset_in_synpred15_MappingDSL235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_synpred16_MappingDSL245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_synpred21_MappingDSL271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred27_MappingDSL299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_synpred29_MappingDSL317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred32_MappingDSL340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred37_MappingDSL387 = new BitSet(new long[]{0x004000800A440000L});
    public static final BitSet FOLLOW_expr_in_synpred37_MappingDSL389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_areaAction_in_synpred54_MappingDSL559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_synpred55_MappingDSL563 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred55_MappingDSL565 = new BitSet(new long[]{0x0000000000000002L});

}