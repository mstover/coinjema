// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g 2010-05-28 12:19:00

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CONTEXT", "AREA_ACTION", "FUNC_CALL", "PROC_CALL", "OFFSET", "COORD", "IMAGE", "RECTANGLE", "CIRCLE", "RAW", "PROCEDURE", "FUNCTION", "ID", "COLOR", "INT", "DASH", "PLUS", "MULT", "DIV", "OP", "FLOAT", "STRING", "DIRECTION", "WS", "EXPONENT", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "':'", "'outline'", "'inline'", "';'", "'('", "')'", "','", "'raw'", "'.'", "'hex'", "'square'", "'free'", "'size'", "'each'", "'within'", "'beside'", "'proc'", "'{'", "'}'", "'func'"
    };
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
    public static final int ESC_SEQ=29;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int OFFSET=8;
    public static final int IMAGE=10;
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
    public static final int T__36=36;
    public static final int AREA_ACTION=5;
    public static final int T__37=37;
    public static final int CIRCLE=12;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int OP=23;
    public static final int DIV=22;
    public static final int STRING=25;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "synpred18_MappingDSL", "synpred34_MappingDSL", "area", 
        "synpred56_MappingDSL", "areaAction", "synpred62_MappingDSL", "synpred45_MappingDSL", 
        "simpleExpr", "synpred47_MappingDSL", "image", "synpred58_MappingDSL", 
        "coordinateSystem", "synpred14_MappingDSL", "synpred15_MappingDSL", 
        "synpred26_MappingDSL", "synpred54_MappingDSL", "synpred59_MappingDSL", 
        "synpred23_MappingDSL", "synpred41_MappingDSL", "synpred1_MappingDSL", 
        "synpred42_MappingDSL", "synpred28_MappingDSL", "synpred57_MappingDSL", 
        "synpred44_MappingDSL", "synpred12_MappingDSL", "synpred24_MappingDSL", 
        "synpred29_MappingDSL", "synpred46_MappingDSL", "synpred53_MappingDSL", 
        "synpred25_MappingDSL", "synpred39_MappingDSL", "synpred11_MappingDSL", 
        "synpred6_MappingDSL", "action", "location", "coord", "synpred49_MappingDSL", 
        "synpred61_MappingDSL", "synpred52_MappingDSL", "synpred3_MappingDSL", 
        "synpred60_MappingDSL", "synpred51_MappingDSL", "context", "synpred2_MappingDSL", 
        "synpred40_MappingDSL", "synpred7_MappingDSL", "synpred20_MappingDSL", 
        "synpred43_MappingDSL", "offset", "circle", "synpred31_MappingDSL", 
        "synpred48_MappingDSL", "synpred9_MappingDSL", "synpred27_MappingDSL", 
        "synpred5_MappingDSL", "size", "synpred36_MappingDSL", "func", "synpred32_MappingDSL", 
        "synpred17_MappingDSL", "proc", "areaExpr", "synpred4_MappingDSL", 
        "synpred30_MappingDSL", "synpred10_MappingDSL", "synpred8_MappingDSL", 
        "synpred22_MappingDSL", "synpred33_MappingDSL", "synpred35_MappingDSL", 
        "rectangle", "synpred13_MappingDSL", "synpred38_MappingDSL", "main", 
        "synpred37_MappingDSL", "synpred50_MappingDSL", "synpred21_MappingDSL", 
        "synpred19_MappingDSL", "synpred55_MappingDSL", "synpred16_MappingDSL", 
        "procCall"
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
    public String getGrammarFileName() { return "/Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g"; }


    public static class main_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:1: main : ( context | areaAction | proc | func )* ;
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
        dbg.location(24, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:6: ( ( context | areaAction | proc | func )* )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:8: ( context | areaAction | proc | func )*
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(24,8);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:8: ( context | areaAction | proc | func )*
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

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:9: context
            	    {
            	    dbg.location(24,9);
            	    pushFollow(FOLLOW_context_in_main72);
            	    context1=context();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, context1.getTree());

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:17: areaAction
            	    {
            	    dbg.location(24,17);
            	    pushFollow(FOLLOW_areaAction_in_main74);
            	    areaAction2=areaAction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, areaAction2.getTree());

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:28: proc
            	    {
            	    dbg.location(24,28);
            	    pushFollow(FOLLOW_proc_in_main76);
            	    proc3=proc();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, proc3.getTree());

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:24:33: func
            	    {
            	    dbg.location(24,33);
            	    pushFollow(FOLLOW_func_in_main78);
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
        dbg.location(24, 39);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:1: context : ID ':' coordinateSystem (a= ( 'outline' | 'inline' ) )? ';' -> ^( CONTEXT[$ID.text] coordinateSystem ( $a)? ) ;
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
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleSubtreeStream stream_coordinateSystem=new RewriteRuleSubtreeStream(adaptor,"rule coordinateSystem");
        try { dbg.enterRule(getGrammarFileName(), "context");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:9: ( ID ':' coordinateSystem (a= ( 'outline' | 'inline' ) )? ';' -> ^( CONTEXT[$ID.text] coordinateSystem ( $a)? ) )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:11: ID ':' coordinateSystem (a= ( 'outline' | 'inline' ) )? ';'
            {
            dbg.location(26,11);
            ID5=(Token)match(input,ID,FOLLOW_ID_in_context88); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID5);

            dbg.location(26,14);
            char_literal6=(Token)match(input,33,FOLLOW_33_in_context90); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_33.add(char_literal6);

            dbg.location(26,18);
            pushFollow(FOLLOW_coordinateSystem_in_context92);
            coordinateSystem7=coordinateSystem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_coordinateSystem.add(coordinateSystem7.getTree());
            dbg.location(26,36);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:36: (a= ( 'outline' | 'inline' ) )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3);

            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=34 && LA3_0<=35)) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: a= ( 'outline' | 'inline' )
                    {
                    dbg.location(26,36);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:37: ( 'outline' | 'inline' )
                    int alt2=2;
                    try { dbg.enterSubRule(2);
                    try { dbg.enterDecision(2);

                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==34) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==35) ) {
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

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:38: 'outline'
                            {
                            dbg.location(26,38);
                            string_literal8=(Token)match(input,34,FOLLOW_34_in_context97); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_34.add(string_literal8);


                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:48: 'inline'
                            {
                            dbg.location(26,48);
                            string_literal9=(Token)match(input,35,FOLLOW_35_in_context99); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_35.add(string_literal9);


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(2);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(26,59);
            char_literal10=(Token)match(input,36,FOLLOW_36_in_context103); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_36.add(char_literal10);



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
            // 26:63: -> ^( CONTEXT[$ID.text] coordinateSystem ( $a)? )
            {
                dbg.location(26,66);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:66: ^( CONTEXT[$ID.text] coordinateSystem ( $a)? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(26,68);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTEXT, (ID5!=null?ID5.getText():null)), root_1);

                dbg.location(26,86);
                adaptor.addChild(root_1, stream_coordinateSystem.nextTree());
                dbg.location(26,103);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:26:103: ( $a)?
                if ( stream_a.hasNext() ) {
                    dbg.location(26,103);
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
        dbg.location(26, 109);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:28:1: areaAction : areaExpr ':' action ';' -> ^( AREA_ACTION areaExpr action ) ;
    public final MappingDSLParser.areaAction_return areaAction() throws RecognitionException {
        MappingDSLParser.areaAction_return retval = new MappingDSLParser.areaAction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal12=null;
        Token char_literal14=null;
        MappingDSLParser.areaExpr_return areaExpr11 = null;

        MappingDSLParser.action_return action13 = null;


        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleSubtreeStream stream_areaExpr=new RewriteRuleSubtreeStream(adaptor,"rule areaExpr");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try { dbg.enterRule(getGrammarFileName(), "areaAction");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(28, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:29:2: ( areaExpr ':' action ';' -> ^( AREA_ACTION areaExpr action ) )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:29:4: areaExpr ':' action ';'
            {
            dbg.location(29,4);
            pushFollow(FOLLOW_areaExpr_in_areaAction127);
            areaExpr11=areaExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_areaExpr.add(areaExpr11.getTree());
            dbg.location(29,13);
            char_literal12=(Token)match(input,33,FOLLOW_33_in_areaAction129); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_33.add(char_literal12);

            dbg.location(29,17);
            pushFollow(FOLLOW_action_in_areaAction131);
            action13=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action13.getTree());
            dbg.location(29,24);
            char_literal14=(Token)match(input,36,FOLLOW_36_in_areaAction133); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_36.add(char_literal14);



            // AST REWRITE
            // elements: action, areaExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 29:28: -> ^( AREA_ACTION areaExpr action )
            {
                dbg.location(29,31);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:29:31: ^( AREA_ACTION areaExpr action )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(29,33);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AREA_ACTION, "AREA_ACTION"), root_1);

                dbg.location(29,45);
                adaptor.addChild(root_1, stream_areaExpr.nextTree());
                dbg.location(29,54);
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
        dbg.location(29, 61);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:31:1: action : ( image -> ^( IMAGE[$image.text] ) | COLOR | ID | procCall );
    public final MappingDSLParser.action_return action() throws RecognitionException {
        MappingDSLParser.action_return retval = new MappingDSLParser.action_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLOR16=null;
        Token ID17=null;
        MappingDSLParser.image_return image15 = null;

        MappingDSLParser.procCall_return procCall18 = null;


        Object COLOR16_tree=null;
        Object ID17_tree=null;
        RewriteRuleSubtreeStream stream_image=new RewriteRuleSubtreeStream(adaptor,"rule image");
        try { dbg.enterRule(getGrammarFileName(), "action");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:31:8: ( image -> ^( IMAGE[$image.text] ) | COLOR | ID | procCall )
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

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:31:10: image
                    {
                    dbg.location(31,10);
                    pushFollow(FOLLOW_image_in_action152);
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
                    // 31:16: -> ^( IMAGE[$image.text] )
                    {
                        dbg.location(31,19);
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:31:19: ^( IMAGE[$image.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(31,21);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMAGE, (image15!=null?input.toString(image15.start,image15.stop):null)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:32:4: COLOR
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(32,4);
                    COLOR16=(Token)match(input,COLOR,FOLLOW_COLOR_in_action164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLOR16_tree = (Object)adaptor.create(COLOR16);
                    adaptor.addChild(root_0, COLOR16_tree);
                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:33:4: ID
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(33,4);
                    ID17=(Token)match(input,ID,FOLLOW_ID_in_action169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID17_tree = (Object)adaptor.create(ID17);
                    adaptor.addChild(root_0, ID17_tree);
                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:34:4: procCall
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(34,4);
                    pushFollow(FOLLOW_procCall_in_action174);
                    procCall18=procCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, procCall18.getTree());

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
        dbg.location(34, 12);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "action");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "action"

    public static class simpleExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleExpr"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:36:1: simpleExpr : ( INT ( ( DASH | PLUS | MULT | DIV | OP ) simpleExpr )? | FLOAT ( ( DASH | PLUS | MULT | DIV ) simpleExpr )? | STRING ( PLUS simpleExpr )? );
    public final MappingDSLParser.simpleExpr_return simpleExpr() throws RecognitionException {
        MappingDSLParser.simpleExpr_return retval = new MappingDSLParser.simpleExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT19=null;
        Token set20=null;
        Token FLOAT22=null;
        Token set23=null;
        Token STRING25=null;
        Token PLUS26=null;
        MappingDSLParser.simpleExpr_return simpleExpr21 = null;

        MappingDSLParser.simpleExpr_return simpleExpr24 = null;

        MappingDSLParser.simpleExpr_return simpleExpr27 = null;


        Object INT19_tree=null;
        Object set20_tree=null;
        Object FLOAT22_tree=null;
        Object set23_tree=null;
        Object STRING25_tree=null;
        Object PLUS26_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "simpleExpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(36, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:37:2: ( INT ( ( DASH | PLUS | MULT | DIV | OP ) simpleExpr )? | FLOAT ( ( DASH | PLUS | MULT | DIV ) simpleExpr )? | STRING ( PLUS simpleExpr )? )
            int alt8=3;
            try { dbg.enterDecision(8);

            switch ( input.LA(1) ) {
            case INT:
                {
                alt8=1;
                }
                break;
            case FLOAT:
                {
                alt8=2;
                }
                break;
            case STRING:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:37:4: INT ( ( DASH | PLUS | MULT | DIV | OP ) simpleExpr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(37,4);
                    INT19=(Token)match(input,INT,FOLLOW_INT_in_simpleExpr184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT19_tree = (Object)adaptor.create(INT19);
                    adaptor.addChild(root_0, INT19_tree);
                    }
                    dbg.location(37,8);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:37:8: ( ( DASH | PLUS | MULT | DIV | OP ) simpleExpr )?
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

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:37:9: ( DASH | PLUS | MULT | DIV | OP ) simpleExpr
                            {
                            dbg.location(37,9);
                            set20=(Token)input.LT(1);
                            set20=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=OP) ) {
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

                            dbg.location(37,34);
                            pushFollow(FOLLOW_simpleExpr_in_simpleExpr200);
                            simpleExpr21=simpleExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr21.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(5);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:38:4: FLOAT ( ( DASH | PLUS | MULT | DIV ) simpleExpr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(38,4);
                    FLOAT22=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_simpleExpr207); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT22_tree = (Object)adaptor.create(FLOAT22);
                    adaptor.addChild(root_0, FLOAT22_tree);
                    }
                    dbg.location(38,10);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:38:10: ( ( DASH | PLUS | MULT | DIV ) simpleExpr )?
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

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:38:11: ( DASH | PLUS | MULT | DIV ) simpleExpr
                            {
                            dbg.location(38,11);
                            set23=(Token)input.LT(1);
                            set23=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=DIV) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set23), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(38,33);
                            pushFollow(FOLLOW_simpleExpr_in_simpleExpr221);
                            simpleExpr24=simpleExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr24.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(6);}


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:39:4: STRING ( PLUS simpleExpr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(39,4);
                    STRING25=(Token)match(input,STRING,FOLLOW_STRING_in_simpleExpr228); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING25_tree = (Object)adaptor.create(STRING25);
                    adaptor.addChild(root_0, STRING25_tree);
                    }
                    dbg.location(39,11);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:39:11: ( PLUS simpleExpr )?
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

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:39:12: PLUS simpleExpr
                            {
                            dbg.location(39,16);
                            PLUS26=(Token)match(input,PLUS,FOLLOW_PLUS_in_simpleExpr231); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUS26_tree = (Object)adaptor.create(PLUS26);
                            root_0 = (Object)adaptor.becomeRoot(PLUS26_tree, root_0);
                            }
                            dbg.location(39,18);
                            pushFollow(FOLLOW_simpleExpr_in_simpleExpr234);
                            simpleExpr27=simpleExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr27.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(7);}


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
        dbg.location(40, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "simpleExpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "simpleExpr"

    public static class procCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "procCall"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:1: procCall : ID '(' (a+= areaExpr | a+= offset | a+= simpleExpr )* ( action )? ')' -> ^( PROC_CALL[$ID.text] ( $a)* ( action )? ) ;
    public final MappingDSLParser.procCall_return procCall() throws RecognitionException {
        MappingDSLParser.procCall_return retval = new MappingDSLParser.procCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID28=null;
        Token char_literal29=null;
        Token char_literal31=null;
        List list_a=null;
        MappingDSLParser.action_return action30 = null;

        RuleReturnScope a = null;
        Object ID28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal31_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_simpleExpr=new RewriteRuleSubtreeStream(adaptor,"rule simpleExpr");
        RewriteRuleSubtreeStream stream_areaExpr=new RewriteRuleSubtreeStream(adaptor,"rule areaExpr");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        RewriteRuleSubtreeStream stream_offset=new RewriteRuleSubtreeStream(adaptor,"rule offset");
        try { dbg.enterRule(getGrammarFileName(), "procCall");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(42, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:9: ( ID '(' (a+= areaExpr | a+= offset | a+= simpleExpr )* ( action )? ')' -> ^( PROC_CALL[$ID.text] ( $a)* ( action )? ) )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:11: ID '(' (a+= areaExpr | a+= offset | a+= simpleExpr )* ( action )? ')'
            {
            dbg.location(42,11);
            ID28=(Token)match(input,ID,FOLLOW_ID_in_procCall246); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID28);

            dbg.location(42,14);
            char_literal29=(Token)match(input,37,FOLLOW_37_in_procCall248); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(char_literal29);

            dbg.location(42,18);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:18: (a+= areaExpr | a+= offset | a+= simpleExpr )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=4;
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

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:19: a+= areaExpr
            	    {
            	    dbg.location(42,20);
            	    pushFollow(FOLLOW_areaExpr_in_procCall253);
            	    a=areaExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_areaExpr.add(a.getTree());
            	    if (list_a==null) list_a=new ArrayList();
            	    list_a.add(a.getTree());


            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:31: a+= offset
            	    {
            	    dbg.location(42,32);
            	    pushFollow(FOLLOW_offset_in_procCall257);
            	    a=offset();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_offset.add(a.getTree());
            	    if (list_a==null) list_a=new ArrayList();
            	    list_a.add(a.getTree());


            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:41: a+= simpleExpr
            	    {
            	    dbg.location(42,42);
            	    pushFollow(FOLLOW_simpleExpr_in_procCall261);
            	    a=simpleExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_simpleExpr.add(a.getTree());
            	    if (list_a==null) list_a=new ArrayList();
            	    list_a.add(a.getTree());


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}

            dbg.location(42,57);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:57: ( action )?
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10);

            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=ID && LA10_0<=COLOR)||LA10_0==DIV) ) {
                alt10=1;
            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: action
                    {
                    dbg.location(42,57);
                    pushFollow(FOLLOW_action_in_procCall265);
                    action30=action();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_action.add(action30.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}

            dbg.location(42,65);
            char_literal31=(Token)match(input,38,FOLLOW_38_in_procCall268); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal31);



            // AST REWRITE
            // elements: action, a
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: a
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"token a",list_a);
            root_0 = (Object)adaptor.nil();
            // 42:69: -> ^( PROC_CALL[$ID.text] ( $a)* ( action )? )
            {
                dbg.location(42,72);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:72: ^( PROC_CALL[$ID.text] ( $a)* ( action )? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(42,74);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROC_CALL, (ID28!=null?ID28.getText():null)), root_1);

                dbg.location(42,94);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:94: ( $a)*
                while ( stream_a.hasNext() ) {
                    dbg.location(42,94);
                    adaptor.addChild(root_1, stream_a.nextTree());

                }
                stream_a.reset();
                dbg.location(42,98);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:98: ( action )?
                if ( stream_action.hasNext() ) {
                    dbg.location(42,98);
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
        dbg.location(43, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "procCall");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "procCall"

    public static class offset_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "offset"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:45:1: offset : ( DASH | PLUS ) INT ',' ( DASH | PLUS ) INT ;
    public final MappingDSLParser.offset_return offset() throws RecognitionException {
        MappingDSLParser.offset_return retval = new MappingDSLParser.offset_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set32=null;
        Token INT33=null;
        Token char_literal34=null;
        Token set35=null;
        Token INT36=null;

        Object set32_tree=null;
        Object INT33_tree=null;
        Object char_literal34_tree=null;
        Object set35_tree=null;
        Object INT36_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "offset");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:45:8: ( ( DASH | PLUS ) INT ',' ( DASH | PLUS ) INT )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:45:10: ( DASH | PLUS ) INT ',' ( DASH | PLUS ) INT
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(45,10);
            set32=(Token)input.LT(1);
            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set32));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(45,22);
            INT33=(Token)match(input,INT,FOLLOW_INT_in_offset298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INT33_tree = (Object)adaptor.create(INT33);
            adaptor.addChild(root_0, INT33_tree);
            }
            dbg.location(45,29);
            char_literal34=(Token)match(input,39,FOLLOW_39_in_offset300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal34_tree = (Object)adaptor.create(char_literal34);
            root_0 = (Object)adaptor.becomeRoot(char_literal34_tree, root_0);
            }
            dbg.location(45,31);
            set35=(Token)input.LT(1);
            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set35));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(45,43);
            INT36=(Token)match(input,INT,FOLLOW_INT_in_offset309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INT36_tree = (Object)adaptor.create(INT36);
            adaptor.addChild(root_0, INT36_tree);
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
        dbg.location(45, 46);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "offset");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "offset"

    public static class coord_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "coord"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:47:1: coord : (a= INT ',' b= INT -> ^( COORD $a $b) | 'raw' a= INT ',' b= INT -> ^( COORD RAW $a $b) );
    public final MappingDSLParser.coord_return coord() throws RecognitionException {
        MappingDSLParser.coord_return retval = new MappingDSLParser.coord_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token a=null;
        Token b=null;
        Token char_literal37=null;
        Token string_literal38=null;
        Token char_literal39=null;

        Object a_tree=null;
        Object b_tree=null;
        Object char_literal37_tree=null;
        Object string_literal38_tree=null;
        Object char_literal39_tree=null;
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");

        try { dbg.enterRule(getGrammarFileName(), "coord");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(47, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:47:7: (a= INT ',' b= INT -> ^( COORD $a $b) | 'raw' a= INT ',' b= INT -> ^( COORD RAW $a $b) )
            int alt11=2;
            try { dbg.enterDecision(11);

            int LA11_0 = input.LA(1);

            if ( (LA11_0==INT) ) {
                alt11=1;
            }
            else if ( (LA11_0==40) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:47:9: a= INT ',' b= INT
                    {
                    dbg.location(47,10);
                    a=(Token)match(input,INT,FOLLOW_INT_in_coord321); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(a);

                    dbg.location(47,15);
                    char_literal37=(Token)match(input,39,FOLLOW_39_in_coord323); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal37);

                    dbg.location(47,20);
                    b=(Token)match(input,INT,FOLLOW_INT_in_coord327); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(b);



                    // AST REWRITE
                    // elements: a, b
                    // token labels: b, a
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
                    RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 47:25: -> ^( COORD $a $b)
                    {
                        dbg.location(47,28);
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:47:28: ^( COORD $a $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(47,30);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(47,36);
                        adaptor.addChild(root_1, stream_a.nextNode());
                        dbg.location(47,39);
                        adaptor.addChild(root_1, stream_b.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:48:4: 'raw' a= INT ',' b= INT
                    {
                    dbg.location(48,4);
                    string_literal38=(Token)match(input,40,FOLLOW_40_in_coord344); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(string_literal38);

                    dbg.location(48,11);
                    a=(Token)match(input,INT,FOLLOW_INT_in_coord348); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(a);

                    dbg.location(48,16);
                    char_literal39=(Token)match(input,39,FOLLOW_39_in_coord350); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal39);

                    dbg.location(48,21);
                    b=(Token)match(input,INT,FOLLOW_INT_in_coord354); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(b);



                    // AST REWRITE
                    // elements: b, a
                    // token labels: b, a
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
                    RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 48:27: -> ^( COORD RAW $a $b)
                    {
                        dbg.location(48,30);
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:48:30: ^( COORD RAW $a $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(48,32);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(48,38);
                        adaptor.addChild(root_1, (Object)adaptor.create(RAW, "RAW"));
                        dbg.location(48,42);
                        adaptor.addChild(root_1, stream_a.nextNode());
                        dbg.location(48,45);
                        adaptor.addChild(root_1, stream_b.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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
        dbg.location(49, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "coord");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "coord"

    public static class image_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "image"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:51:1: image : ( DIV )? ID ( DIV ID )* '.' ID ;
    public final MappingDSLParser.image_return image() throws RecognitionException {
        MappingDSLParser.image_return retval = new MappingDSLParser.image_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DIV40=null;
        Token ID41=null;
        Token DIV42=null;
        Token ID43=null;
        Token char_literal44=null;
        Token ID45=null;

        Object DIV40_tree=null;
        Object ID41_tree=null;
        Object DIV42_tree=null;
        Object ID43_tree=null;
        Object char_literal44_tree=null;
        Object ID45_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "image");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(51, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:51:7: ( ( DIV )? ID ( DIV ID )* '.' ID )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:51:9: ( DIV )? ID ( DIV ID )* '.' ID
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(51,9);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:51:9: ( DIV )?
            int alt12=2;
            try { dbg.enterSubRule(12);
            try { dbg.enterDecision(12);

            int LA12_0 = input.LA(1);

            if ( (LA12_0==DIV) ) {
                alt12=1;
            }
            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: DIV
                    {
                    dbg.location(51,9);
                    DIV40=(Token)match(input,DIV,FOLLOW_DIV_in_image379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV40_tree = (Object)adaptor.create(DIV40);
                    adaptor.addChild(root_0, DIV40_tree);
                    }

                    }
                    break;

            }
            } finally {dbg.exitSubRule(12);}

            dbg.location(51,14);
            ID41=(Token)match(input,ID,FOLLOW_ID_in_image382); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID41_tree = (Object)adaptor.create(ID41);
            adaptor.addChild(root_0, ID41_tree);
            }
            dbg.location(51,17);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:51:17: ( DIV ID )*
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=2;
                try { dbg.enterDecision(13);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==DIV) ) {
                    alt13=1;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:51:18: DIV ID
            	    {
            	    dbg.location(51,18);
            	    DIV42=(Token)match(input,DIV,FOLLOW_DIV_in_image385); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV42_tree = (Object)adaptor.create(DIV42);
            	    adaptor.addChild(root_0, DIV42_tree);
            	    }
            	    dbg.location(51,22);
            	    ID43=(Token)match(input,ID,FOLLOW_ID_in_image387); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    ID43_tree = (Object)adaptor.create(ID43);
            	    adaptor.addChild(root_0, ID43_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);
            } finally {dbg.exitSubRule(13);}

            dbg.location(51,27);
            char_literal44=(Token)match(input,41,FOLLOW_41_in_image391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal44_tree = (Object)adaptor.create(char_literal44);
            adaptor.addChild(root_0, char_literal44_tree);
            }
            dbg.location(51,31);
            ID45=(Token)match(input,ID,FOLLOW_ID_in_image393); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID45_tree = (Object)adaptor.create(ID45);
            adaptor.addChild(root_0, ID45_tree);
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
        dbg.location(51, 33);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "image");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "image"

    public static class rectangle_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rectangle"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:53:1: rectangle : ( coord DASH coord -> ^( RECTANGLE coord coord ) | 'raw' coord DASH coord -> ^( RECTANGLE RAW coord coord ) );
    public final MappingDSLParser.rectangle_return rectangle() throws RecognitionException {
        MappingDSLParser.rectangle_return retval = new MappingDSLParser.rectangle_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DASH47=null;
        Token string_literal49=null;
        Token DASH51=null;
        MappingDSLParser.coord_return coord46 = null;

        MappingDSLParser.coord_return coord48 = null;

        MappingDSLParser.coord_return coord50 = null;

        MappingDSLParser.coord_return coord52 = null;


        Object DASH47_tree=null;
        Object string_literal49_tree=null;
        Object DASH51_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_DASH=new RewriteRuleTokenStream(adaptor,"token DASH");
        RewriteRuleSubtreeStream stream_coord=new RewriteRuleSubtreeStream(adaptor,"rule coord");
        try { dbg.enterRule(getGrammarFileName(), "rectangle");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:54:2: ( coord DASH coord -> ^( RECTANGLE coord coord ) | 'raw' coord DASH coord -> ^( RECTANGLE RAW coord coord ) )
            int alt14=2;
            try { dbg.enterDecision(14);

            try {
                isCyclicDecision = true;
                alt14 = dfa14.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:54:4: coord DASH coord
                    {
                    dbg.location(54,4);
                    pushFollow(FOLLOW_coord_in_rectangle402);
                    coord46=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord46.getTree());
                    dbg.location(54,10);
                    DASH47=(Token)match(input,DASH,FOLLOW_DASH_in_rectangle404); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(DASH47);

                    dbg.location(54,15);
                    pushFollow(FOLLOW_coord_in_rectangle406);
                    coord48=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord48.getTree());


                    // AST REWRITE
                    // elements: coord, coord
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 54:21: -> ^( RECTANGLE coord coord )
                    {
                        dbg.location(54,24);
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:54:24: ^( RECTANGLE coord coord )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(54,26);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RECTANGLE, "RECTANGLE"), root_1);

                        dbg.location(54,36);
                        adaptor.addChild(root_1, stream_coord.nextTree());
                        dbg.location(54,42);
                        adaptor.addChild(root_1, stream_coord.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:55:4: 'raw' coord DASH coord
                    {
                    dbg.location(55,4);
                    string_literal49=(Token)match(input,40,FOLLOW_40_in_rectangle421); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(string_literal49);

                    dbg.location(55,10);
                    pushFollow(FOLLOW_coord_in_rectangle423);
                    coord50=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord50.getTree());
                    dbg.location(55,16);
                    DASH51=(Token)match(input,DASH,FOLLOW_DASH_in_rectangle425); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(DASH51);

                    dbg.location(55,21);
                    pushFollow(FOLLOW_coord_in_rectangle427);
                    coord52=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord52.getTree());


                    // AST REWRITE
                    // elements: coord, coord
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 55:27: -> ^( RECTANGLE RAW coord coord )
                    {
                        dbg.location(55,30);
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:55:30: ^( RECTANGLE RAW coord coord )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(55,32);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RECTANGLE, "RECTANGLE"), root_1);

                        dbg.location(55,42);
                        adaptor.addChild(root_1, (Object)adaptor.create(RAW, "RAW"));
                        dbg.location(55,46);
                        adaptor.addChild(root_1, stream_coord.nextTree());
                        dbg.location(55,52);
                        adaptor.addChild(root_1, stream_coord.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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
        dbg.location(56, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "rectangle");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "rectangle"

    public static class circle_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "circle"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:58:1: circle : ( coord MULT INT -> ^( CIRCLE coord INT ) | 'raw' coord MULT FLOAT -> ^( CIRCLE RAW coord FLOAT ) );
    public final MappingDSLParser.circle_return circle() throws RecognitionException {
        MappingDSLParser.circle_return retval = new MappingDSLParser.circle_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token MULT54=null;
        Token INT55=null;
        Token string_literal56=null;
        Token MULT58=null;
        Token FLOAT59=null;
        MappingDSLParser.coord_return coord53 = null;

        MappingDSLParser.coord_return coord57 = null;


        Object MULT54_tree=null;
        Object INT55_tree=null;
        Object string_literal56_tree=null;
        Object MULT58_tree=null;
        Object FLOAT59_tree=null;
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_MULT=new RewriteRuleTokenStream(adaptor,"token MULT");
        RewriteRuleSubtreeStream stream_coord=new RewriteRuleSubtreeStream(adaptor,"rule coord");
        try { dbg.enterRule(getGrammarFileName(), "circle");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(58, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:58:8: ( coord MULT INT -> ^( CIRCLE coord INT ) | 'raw' coord MULT FLOAT -> ^( CIRCLE RAW coord FLOAT ) )
            int alt15=2;
            try { dbg.enterDecision(15);

            try {
                isCyclicDecision = true;
                alt15 = dfa15.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(15);}

            switch (alt15) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:58:10: coord MULT INT
                    {
                    dbg.location(58,10);
                    pushFollow(FOLLOW_coord_in_circle450);
                    coord53=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord53.getTree());
                    dbg.location(58,16);
                    MULT54=(Token)match(input,MULT,FOLLOW_MULT_in_circle452); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MULT.add(MULT54);

                    dbg.location(58,21);
                    INT55=(Token)match(input,INT,FOLLOW_INT_in_circle454); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT55);



                    // AST REWRITE
                    // elements: INT, coord
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 58:25: -> ^( CIRCLE coord INT )
                    {
                        dbg.location(58,28);
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:58:28: ^( CIRCLE coord INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(58,30);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CIRCLE, "CIRCLE"), root_1);

                        dbg.location(58,37);
                        adaptor.addChild(root_1, stream_coord.nextTree());
                        dbg.location(58,43);
                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:59:4: 'raw' coord MULT FLOAT
                    {
                    dbg.location(59,4);
                    string_literal56=(Token)match(input,40,FOLLOW_40_in_circle469); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(string_literal56);

                    dbg.location(59,10);
                    pushFollow(FOLLOW_coord_in_circle471);
                    coord57=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord57.getTree());
                    dbg.location(59,16);
                    MULT58=(Token)match(input,MULT,FOLLOW_MULT_in_circle473); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MULT.add(MULT58);

                    dbg.location(59,21);
                    FLOAT59=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_circle475); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOAT.add(FLOAT59);



                    // AST REWRITE
                    // elements: coord, FLOAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 59:27: -> ^( CIRCLE RAW coord FLOAT )
                    {
                        dbg.location(59,30);
                        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:59:30: ^( CIRCLE RAW coord FLOAT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(59,32);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CIRCLE, "CIRCLE"), root_1);

                        dbg.location(59,39);
                        adaptor.addChild(root_1, (Object)adaptor.create(RAW, "RAW"));
                        dbg.location(59,43);
                        adaptor.addChild(root_1, stream_coord.nextTree());
                        dbg.location(59,49);
                        adaptor.addChild(root_1, stream_FLOAT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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
        dbg.location(59, 55);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "circle");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "circle"

    public static class areaExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "areaExpr"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:61:1: areaExpr : ( area ( ( DASH | PLUS ) areaExpr )? | ID ( ( DASH | PLUS ) areaExpr )? | procCall ( ( DASH | PLUS ) areaExpr )? );
    public final MappingDSLParser.areaExpr_return areaExpr() throws RecognitionException {
        MappingDSLParser.areaExpr_return retval = new MappingDSLParser.areaExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set61=null;
        Token ID63=null;
        Token set64=null;
        Token set67=null;
        MappingDSLParser.area_return area60 = null;

        MappingDSLParser.areaExpr_return areaExpr62 = null;

        MappingDSLParser.areaExpr_return areaExpr65 = null;

        MappingDSLParser.procCall_return procCall66 = null;

        MappingDSLParser.areaExpr_return areaExpr68 = null;


        Object set61_tree=null;
        Object ID63_tree=null;
        Object set64_tree=null;
        Object set67_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "areaExpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(61, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:61:9: ( area ( ( DASH | PLUS ) areaExpr )? | ID ( ( DASH | PLUS ) areaExpr )? | procCall ( ( DASH | PLUS ) areaExpr )? )
            int alt19=3;
            try { dbg.enterDecision(19);

            try {
                isCyclicDecision = true;
                alt19 = dfa19.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(19);}

            switch (alt19) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:61:11: area ( ( DASH | PLUS ) areaExpr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(61,11);
                    pushFollow(FOLLOW_area_in_areaExpr495);
                    area60=area();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, area60.getTree());
                    dbg.location(61,16);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:61:16: ( ( DASH | PLUS ) areaExpr )?
                    int alt16=2;
                    try { dbg.enterSubRule(16);
                    try { dbg.enterDecision(16);

                    try {
                        isCyclicDecision = true;
                        alt16 = dfa16.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(16);}

                    switch (alt16) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:61:17: ( DASH | PLUS ) areaExpr
                            {
                            dbg.location(61,17);
                            set61=(Token)input.LT(1);
                            set61=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set61), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(61,30);
                            pushFollow(FOLLOW_areaExpr_in_areaExpr505);
                            areaExpr62=areaExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, areaExpr62.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(16);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:62:4: ID ( ( DASH | PLUS ) areaExpr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(62,4);
                    ID63=(Token)match(input,ID,FOLLOW_ID_in_areaExpr513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID63_tree = (Object)adaptor.create(ID63);
                    adaptor.addChild(root_0, ID63_tree);
                    }
                    dbg.location(62,7);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:62:7: ( ( DASH | PLUS ) areaExpr )?
                    int alt17=2;
                    try { dbg.enterSubRule(17);
                    try { dbg.enterDecision(17);

                    try {
                        isCyclicDecision = true;
                        alt17 = dfa17.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(17);}

                    switch (alt17) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:62:8: ( DASH | PLUS ) areaExpr
                            {
                            dbg.location(62,8);
                            set64=(Token)input.LT(1);
                            set64=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set64), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(62,21);
                            pushFollow(FOLLOW_areaExpr_in_areaExpr523);
                            areaExpr65=areaExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, areaExpr65.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(17);}


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:63:4: procCall ( ( DASH | PLUS ) areaExpr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(63,4);
                    pushFollow(FOLLOW_procCall_in_areaExpr531);
                    procCall66=procCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, procCall66.getTree());
                    dbg.location(63,13);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:63:13: ( ( DASH | PLUS ) areaExpr )?
                    int alt18=2;
                    try { dbg.enterSubRule(18);
                    try { dbg.enterDecision(18);

                    try {
                        isCyclicDecision = true;
                        alt18 = dfa18.predict(input);
                    }
                    catch (NoViableAltException nvae) {
                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                    } finally {dbg.exitDecision(18);}

                    switch (alt18) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:63:14: ( DASH | PLUS ) areaExpr
                            {
                            dbg.location(63,14);
                            set67=(Token)input.LT(1);
                            set67=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set67), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(63,27);
                            pushFollow(FOLLOW_areaExpr_in_areaExpr541);
                            areaExpr68=areaExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, areaExpr68.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(18);}


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
        dbg.location(64, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "areaExpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "areaExpr"

    public static class area_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "area"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:1: area : ( ( ID ':' )? rectangle | ( ID ':' )? circle | ( ID ':' )? coord );
    public final MappingDSLParser.area_return area() throws RecognitionException {
        MappingDSLParser.area_return retval = new MappingDSLParser.area_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID69=null;
        Token char_literal70=null;
        Token ID72=null;
        Token char_literal73=null;
        Token ID75=null;
        Token char_literal76=null;
        MappingDSLParser.rectangle_return rectangle71 = null;

        MappingDSLParser.circle_return circle74 = null;

        MappingDSLParser.coord_return coord77 = null;


        Object ID69_tree=null;
        Object char_literal70_tree=null;
        Object ID72_tree=null;
        Object char_literal73_tree=null;
        Object ID75_tree=null;
        Object char_literal76_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "area");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:6: ( ( ID ':' )? rectangle | ( ID ':' )? circle | ( ID ':' )? coord )
            int alt23=3;
            try { dbg.enterDecision(23);

            try {
                isCyclicDecision = true;
                alt23 = dfa23.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(23);}

            switch (alt23) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:8: ( ID ':' )? rectangle
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(66,8);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:8: ( ID ':' )?
                    int alt20=2;
                    try { dbg.enterSubRule(20);
                    try { dbg.enterDecision(20);

                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==ID) ) {
                        alt20=1;
                    }
                    } finally {dbg.exitDecision(20);}

                    switch (alt20) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:9: ID ':'
                            {
                            dbg.location(66,9);
                            ID69=(Token)match(input,ID,FOLLOW_ID_in_area556); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ID69_tree = (Object)adaptor.create(ID69);
                            adaptor.addChild(root_0, ID69_tree);
                            }
                            dbg.location(66,12);
                            char_literal70=(Token)match(input,33,FOLLOW_33_in_area558); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal70_tree = (Object)adaptor.create(char_literal70);
                            adaptor.addChild(root_0, char_literal70_tree);
                            }

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(20);}

                    dbg.location(66,18);
                    pushFollow(FOLLOW_rectangle_in_area562);
                    rectangle71=rectangle();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rectangle71.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:67:4: ( ID ':' )? circle
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(67,4);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:67:4: ( ID ':' )?
                    int alt21=2;
                    try { dbg.enterSubRule(21);
                    try { dbg.enterDecision(21);

                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==ID) ) {
                        alt21=1;
                    }
                    } finally {dbg.exitDecision(21);}

                    switch (alt21) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:67:5: ID ':'
                            {
                            dbg.location(67,5);
                            ID72=(Token)match(input,ID,FOLLOW_ID_in_area568); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ID72_tree = (Object)adaptor.create(ID72);
                            adaptor.addChild(root_0, ID72_tree);
                            }
                            dbg.location(67,8);
                            char_literal73=(Token)match(input,33,FOLLOW_33_in_area570); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal73_tree = (Object)adaptor.create(char_literal73);
                            adaptor.addChild(root_0, char_literal73_tree);
                            }

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(21);}

                    dbg.location(67,14);
                    pushFollow(FOLLOW_circle_in_area574);
                    circle74=circle();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, circle74.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:68:4: ( ID ':' )? coord
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(68,4);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:68:4: ( ID ':' )?
                    int alt22=2;
                    try { dbg.enterSubRule(22);
                    try { dbg.enterDecision(22);

                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==ID) ) {
                        alt22=1;
                    }
                    } finally {dbg.exitDecision(22);}

                    switch (alt22) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:68:5: ID ':'
                            {
                            dbg.location(68,5);
                            ID75=(Token)match(input,ID,FOLLOW_ID_in_area580); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ID75_tree = (Object)adaptor.create(ID75);
                            adaptor.addChild(root_0, ID75_tree);
                            }
                            dbg.location(68,8);
                            char_literal76=(Token)match(input,33,FOLLOW_33_in_area582); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal76_tree = (Object)adaptor.create(char_literal76);
                            adaptor.addChild(root_0, char_literal76_tree);
                            }

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(22);}

                    dbg.location(68,14);
                    pushFollow(FOLLOW_coord_in_area586);
                    coord77=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord77.getTree());

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
        dbg.location(69, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "area");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "area"

    public static class coordinateSystem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "coordinateSystem"
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:71:1: coordinateSystem : ( 'hex' coord ( size )? ( location )? | 'square' coord ( size )? ( location )? | 'free' ( size )? ( location )? );
    public final MappingDSLParser.coordinateSystem_return coordinateSystem() throws RecognitionException {
        MappingDSLParser.coordinateSystem_return retval = new MappingDSLParser.coordinateSystem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal78=null;
        Token string_literal82=null;
        Token string_literal86=null;
        MappingDSLParser.coord_return coord79 = null;

        MappingDSLParser.size_return size80 = null;

        MappingDSLParser.location_return location81 = null;

        MappingDSLParser.coord_return coord83 = null;

        MappingDSLParser.size_return size84 = null;

        MappingDSLParser.location_return location85 = null;

        MappingDSLParser.size_return size87 = null;

        MappingDSLParser.location_return location88 = null;


        Object string_literal78_tree=null;
        Object string_literal82_tree=null;
        Object string_literal86_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "coordinateSystem");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(71, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:72:2: ( 'hex' coord ( size )? ( location )? | 'square' coord ( size )? ( location )? | 'free' ( size )? ( location )? )
            int alt30=3;
            try { dbg.enterDecision(30);

            switch ( input.LA(1) ) {
            case 42:
                {
                alt30=1;
                }
                break;
            case 43:
                {
                alt30=2;
                }
                break;
            case 44:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(30);}

            switch (alt30) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:72:4: 'hex' coord ( size )? ( location )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(72,4);
                    string_literal78=(Token)match(input,42,FOLLOW_42_in_coordinateSystem597); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (Object)adaptor.create(string_literal78);
                    adaptor.addChild(root_0, string_literal78_tree);
                    }
                    dbg.location(72,10);
                    pushFollow(FOLLOW_coord_in_coordinateSystem599);
                    coord79=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord79.getTree());
                    dbg.location(72,16);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:72:16: ( size )?
                    int alt24=2;
                    try { dbg.enterSubRule(24);
                    try { dbg.enterDecision(24);

                    int LA24_0 = input.LA(1);

                    if ( ((LA24_0>=45 && LA24_0<=46)) ) {
                        alt24=1;
                    }
                    } finally {dbg.exitDecision(24);}

                    switch (alt24) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(72,16);
                            pushFollow(FOLLOW_size_in_coordinateSystem601);
                            size80=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, size80.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(24);}

                    dbg.location(72,22);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:72:22: ( location )?
                    int alt25=2;
                    try { dbg.enterSubRule(25);
                    try { dbg.enterDecision(25);

                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=47 && LA25_0<=48)) ) {
                        alt25=1;
                    }
                    } finally {dbg.exitDecision(25);}

                    switch (alt25) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: location
                            {
                            dbg.location(72,22);
                            pushFollow(FOLLOW_location_in_coordinateSystem604);
                            location81=location();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, location81.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(25);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:73:4: 'square' coord ( size )? ( location )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(73,4);
                    string_literal82=(Token)match(input,43,FOLLOW_43_in_coordinateSystem610); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal82_tree = (Object)adaptor.create(string_literal82);
                    adaptor.addChild(root_0, string_literal82_tree);
                    }
                    dbg.location(73,13);
                    pushFollow(FOLLOW_coord_in_coordinateSystem612);
                    coord83=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord83.getTree());
                    dbg.location(73,19);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:73:19: ( size )?
                    int alt26=2;
                    try { dbg.enterSubRule(26);
                    try { dbg.enterDecision(26);

                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=45 && LA26_0<=46)) ) {
                        alt26=1;
                    }
                    } finally {dbg.exitDecision(26);}

                    switch (alt26) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(73,19);
                            pushFollow(FOLLOW_size_in_coordinateSystem614);
                            size84=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, size84.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(26);}

                    dbg.location(73,25);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:73:25: ( location )?
                    int alt27=2;
                    try { dbg.enterSubRule(27);
                    try { dbg.enterDecision(27);

                    int LA27_0 = input.LA(1);

                    if ( ((LA27_0>=47 && LA27_0<=48)) ) {
                        alt27=1;
                    }
                    } finally {dbg.exitDecision(27);}

                    switch (alt27) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: location
                            {
                            dbg.location(73,25);
                            pushFollow(FOLLOW_location_in_coordinateSystem617);
                            location85=location();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, location85.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(27);}


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:74:4: 'free' ( size )? ( location )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(74,4);
                    string_literal86=(Token)match(input,44,FOLLOW_44_in_coordinateSystem623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal86_tree = (Object)adaptor.create(string_literal86);
                    adaptor.addChild(root_0, string_literal86_tree);
                    }
                    dbg.location(74,11);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:74:11: ( size )?
                    int alt28=2;
                    try { dbg.enterSubRule(28);
                    try { dbg.enterDecision(28);

                    int LA28_0 = input.LA(1);

                    if ( ((LA28_0>=45 && LA28_0<=46)) ) {
                        alt28=1;
                    }
                    } finally {dbg.exitDecision(28);}

                    switch (alt28) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(74,11);
                            pushFollow(FOLLOW_size_in_coordinateSystem625);
                            size87=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, size87.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(28);}

                    dbg.location(74,17);
                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:74:17: ( location )?
                    int alt29=2;
                    try { dbg.enterSubRule(29);
                    try { dbg.enterDecision(29);

                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=47 && LA29_0<=48)) ) {
                        alt29=1;
                    }
                    } finally {dbg.exitDecision(29);}

                    switch (alt29) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: location
                            {
                            dbg.location(74,17);
                            pushFollow(FOLLOW_location_in_coordinateSystem628);
                            location88=location();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, location88.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(29);}


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
        dbg.location(75, 2);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:77:1: size : ( 'size' coord | 'each' INT );
    public final MappingDSLParser.size_return size() throws RecognitionException {
        MappingDSLParser.size_return retval = new MappingDSLParser.size_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal89=null;
        Token string_literal91=null;
        Token INT92=null;
        MappingDSLParser.coord_return coord90 = null;


        Object string_literal89_tree=null;
        Object string_literal91_tree=null;
        Object INT92_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "size");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(77, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:77:6: ( 'size' coord | 'each' INT )
            int alt31=2;
            try { dbg.enterDecision(31);

            int LA31_0 = input.LA(1);

            if ( (LA31_0==45) ) {
                alt31=1;
            }
            else if ( (LA31_0==46) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(31);}

            switch (alt31) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:77:8: 'size' coord
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(77,8);
                    string_literal89=(Token)match(input,45,FOLLOW_45_in_size639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
                    }
                    dbg.location(77,15);
                    pushFollow(FOLLOW_coord_in_size641);
                    coord90=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord90.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:78:4: 'each' INT
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(78,4);
                    string_literal91=(Token)match(input,46,FOLLOW_46_in_size646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
                    }
                    dbg.location(78,11);
                    INT92=(Token)match(input,INT,FOLLOW_INT_in_size648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT92_tree = (Object)adaptor.create(INT92);
                    adaptor.addChild(root_0, INT92_tree);
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
        dbg.location(78, 14);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:80:1: location : ( 'within' ID area | 'beside' ID DIRECTION );
    public final MappingDSLParser.location_return location() throws RecognitionException {
        MappingDSLParser.location_return retval = new MappingDSLParser.location_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal93=null;
        Token ID94=null;
        Token string_literal96=null;
        Token ID97=null;
        Token DIRECTION98=null;
        MappingDSLParser.area_return area95 = null;


        Object string_literal93_tree=null;
        Object ID94_tree=null;
        Object string_literal96_tree=null;
        Object ID97_tree=null;
        Object DIRECTION98_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "location");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(80, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:80:10: ( 'within' ID area | 'beside' ID DIRECTION )
            int alt32=2;
            try { dbg.enterDecision(32);

            int LA32_0 = input.LA(1);

            if ( (LA32_0==47) ) {
                alt32=1;
            }
            else if ( (LA32_0==48) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(32);}

            switch (alt32) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:80:12: 'within' ID area
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(80,12);
                    string_literal93=(Token)match(input,47,FOLLOW_47_in_location656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
                    }
                    dbg.location(80,21);
                    ID94=(Token)match(input,ID,FOLLOW_ID_in_location658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID94_tree = (Object)adaptor.create(ID94);
                    adaptor.addChild(root_0, ID94_tree);
                    }
                    dbg.location(80,24);
                    pushFollow(FOLLOW_area_in_location660);
                    area95=area();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, area95.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:81:4: 'beside' ID DIRECTION
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(81,4);
                    string_literal96=(Token)match(input,48,FOLLOW_48_in_location665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
                    }
                    dbg.location(81,13);
                    ID97=(Token)match(input,ID,FOLLOW_ID_in_location667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID97_tree = (Object)adaptor.create(ID97);
                    adaptor.addChild(root_0, ID97_tree);
                    }
                    dbg.location(81,16);
                    DIRECTION98=(Token)match(input,DIRECTION,FOLLOW_DIRECTION_in_location669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIRECTION98_tree = (Object)adaptor.create(DIRECTION98);
                    adaptor.addChild(root_0, DIRECTION98_tree);
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
        dbg.location(81, 25);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:1: proc : 'proc' name= ID '(' ( ID )* ')' '{' (a+= areaAction | a+= procCall ';' )+ '}' -> ^( PROCEDURE[$name.text] ( $a)+ ) ;
    public final MappingDSLParser.proc_return proc() throws RecognitionException {
        MappingDSLParser.proc_return retval = new MappingDSLParser.proc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token string_literal99=null;
        Token char_literal100=null;
        Token ID101=null;
        Token char_literal102=null;
        Token char_literal103=null;
        Token char_literal104=null;
        Token char_literal105=null;
        List list_a=null;
        RuleReturnScope a = null;
        Object name_tree=null;
        Object string_literal99_tree=null;
        Object char_literal100_tree=null;
        Object ID101_tree=null;
        Object char_literal102_tree=null;
        Object char_literal103_tree=null;
        Object char_literal104_tree=null;
        Object char_literal105_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_areaAction=new RewriteRuleSubtreeStream(adaptor,"rule areaAction");
        RewriteRuleSubtreeStream stream_procCall=new RewriteRuleSubtreeStream(adaptor,"rule procCall");
        try { dbg.enterRule(getGrammarFileName(), "proc");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(83, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:6: ( 'proc' name= ID '(' ( ID )* ')' '{' (a+= areaAction | a+= procCall ';' )+ '}' -> ^( PROCEDURE[$name.text] ( $a)+ ) )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:8: 'proc' name= ID '(' ( ID )* ')' '{' (a+= areaAction | a+= procCall ';' )+ '}'
            {
            dbg.location(83,8);
            string_literal99=(Token)match(input,49,FOLLOW_49_in_proc677); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_49.add(string_literal99);

            dbg.location(83,19);
            name=(Token)match(input,ID,FOLLOW_ID_in_proc681); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            dbg.location(83,23);
            char_literal100=(Token)match(input,37,FOLLOW_37_in_proc683); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(char_literal100);

            dbg.location(83,27);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:27: ( ID )*
            try { dbg.enterSubRule(33);

            loop33:
            do {
                int alt33=2;
                try { dbg.enterDecision(33);

                int LA33_0 = input.LA(1);

                if ( (LA33_0==ID) ) {
                    alt33=1;
                }


                } finally {dbg.exitDecision(33);}

                switch (alt33) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: ID
            	    {
            	    dbg.location(83,27);
            	    ID101=(Token)match(input,ID,FOLLOW_ID_in_proc685); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID101);


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);
            } finally {dbg.exitSubRule(33);}

            dbg.location(83,31);
            char_literal102=(Token)match(input,38,FOLLOW_38_in_proc688); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal102);

            dbg.location(83,35);
            char_literal103=(Token)match(input,50,FOLLOW_50_in_proc690); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(char_literal103);

            dbg.location(83,39);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:39: (a+= areaAction | a+= procCall ';' )+
            int cnt34=0;
            try { dbg.enterSubRule(34);

            loop34:
            do {
                int alt34=3;
                try { dbg.enterDecision(34);

                int LA34_0 = input.LA(1);

                if ( (LA34_0==ID) ) {
                    int LA34_2 = input.LA(2);

                    if ( (synpred58_MappingDSL()) ) {
                        alt34=1;
                    }
                    else if ( (synpred59_MappingDSL()) ) {
                        alt34=2;
                    }


                }
                else if ( (LA34_0==INT||LA34_0==40) ) {
                    alt34=1;
                }


                } finally {dbg.exitDecision(34);}

                switch (alt34) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:40: a+= areaAction
            	    {
            	    dbg.location(83,41);
            	    pushFollow(FOLLOW_areaAction_in_proc695);
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

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:54: a+= procCall ';'
            	    {
            	    dbg.location(83,55);
            	    pushFollow(FOLLOW_procCall_in_proc699);
            	    a=procCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_procCall.add(a.getTree());
            	    if (list_a==null) list_a=new ArrayList();
            	    list_a.add(a.getTree());

            	    dbg.location(83,66);
            	    char_literal104=(Token)match(input,36,FOLLOW_36_in_proc701); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_36.add(char_literal104);


            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt34++;
            } while (true);
            } finally {dbg.exitSubRule(34);}

            dbg.location(83,72);
            char_literal105=(Token)match(input,51,FOLLOW_51_in_proc705); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(char_literal105);



            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: a
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"token a",list_a);
            root_0 = (Object)adaptor.nil();
            // 83:76: -> ^( PROCEDURE[$name.text] ( $a)+ )
            {
                dbg.location(83,79);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:79: ^( PROCEDURE[$name.text] ( $a)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(83,81);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCEDURE, (name!=null?name.getText():null)), root_1);

                dbg.location(83,103);
                if ( !(stream_a.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_a.hasNext() ) {
                    dbg.location(83,103);
                    adaptor.addChild(root_1, stream_a.nextTree());

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
        dbg.location(83, 107);

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
    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:1: func : 'func' name= ID '(' ( ID )* ')' '{' a= ( areaExpr | simpleExpr ) ( ';' )? '}' -> ^( FUNCTION[$name.text] $a) ;
    public final MappingDSLParser.func_return func() throws RecognitionException {
        MappingDSLParser.func_return retval = new MappingDSLParser.func_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token a=null;
        Token string_literal106=null;
        Token char_literal107=null;
        Token ID108=null;
        Token char_literal109=null;
        Token char_literal110=null;
        Token char_literal113=null;
        Token char_literal114=null;
        MappingDSLParser.areaExpr_return areaExpr111 = null;

        MappingDSLParser.simpleExpr_return simpleExpr112 = null;


        Object name_tree=null;
        Object a_tree=null;
        Object string_literal106_tree=null;
        Object char_literal107_tree=null;
        Object ID108_tree=null;
        Object char_literal109_tree=null;
        Object char_literal110_tree=null;
        Object char_literal113_tree=null;
        Object char_literal114_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_simpleExpr=new RewriteRuleSubtreeStream(adaptor,"rule simpleExpr");
        RewriteRuleSubtreeStream stream_areaExpr=new RewriteRuleSubtreeStream(adaptor,"rule areaExpr");
        try { dbg.enterRule(getGrammarFileName(), "func");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(85, 1);

        try {
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:6: ( 'func' name= ID '(' ( ID )* ')' '{' a= ( areaExpr | simpleExpr ) ( ';' )? '}' -> ^( FUNCTION[$name.text] $a) )
            dbg.enterAlt(1);

            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:8: 'func' name= ID '(' ( ID )* ')' '{' a= ( areaExpr | simpleExpr ) ( ';' )? '}'
            {
            dbg.location(85,8);
            string_literal106=(Token)match(input,52,FOLLOW_52_in_func724); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_52.add(string_literal106);

            dbg.location(85,19);
            name=(Token)match(input,ID,FOLLOW_ID_in_func728); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            dbg.location(85,23);
            char_literal107=(Token)match(input,37,FOLLOW_37_in_func730); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(char_literal107);

            dbg.location(85,27);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:27: ( ID )*
            try { dbg.enterSubRule(35);

            loop35:
            do {
                int alt35=2;
                try { dbg.enterDecision(35);

                int LA35_0 = input.LA(1);

                if ( (LA35_0==ID) ) {
                    alt35=1;
                }


                } finally {dbg.exitDecision(35);}

                switch (alt35) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: ID
            	    {
            	    dbg.location(85,27);
            	    ID108=(Token)match(input,ID,FOLLOW_ID_in_func732); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID108);


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);
            } finally {dbg.exitSubRule(35);}

            dbg.location(85,31);
            char_literal109=(Token)match(input,38,FOLLOW_38_in_func735); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal109);

            dbg.location(85,35);
            char_literal110=(Token)match(input,50,FOLLOW_50_in_func737); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(char_literal110);

            dbg.location(85,40);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:41: ( areaExpr | simpleExpr )
            int alt36=2;
            try { dbg.enterSubRule(36);
            try { dbg.enterDecision(36);

            try {
                isCyclicDecision = true;
                alt36 = dfa36.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(36);}

            switch (alt36) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:42: areaExpr
                    {
                    dbg.location(85,42);
                    pushFollow(FOLLOW_areaExpr_in_func742);
                    areaExpr111=areaExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_areaExpr.add(areaExpr111.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:51: simpleExpr
                    {
                    dbg.location(85,51);
                    pushFollow(FOLLOW_simpleExpr_in_func744);
                    simpleExpr112=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_simpleExpr.add(simpleExpr112.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(36);}

            dbg.location(85,63);
            // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:63: ( ';' )?
            int alt37=2;
            try { dbg.enterSubRule(37);
            try { dbg.enterDecision(37);

            int LA37_0 = input.LA(1);

            if ( (LA37_0==36) ) {
                alt37=1;
            }
            } finally {dbg.exitDecision(37);}

            switch (alt37) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:0:0: ';'
                    {
                    dbg.location(85,63);
                    char_literal113=(Token)match(input,36,FOLLOW_36_in_func747); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal113);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(37);}

            dbg.location(85,68);
            char_literal114=(Token)match(input,51,FOLLOW_51_in_func750); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(char_literal114);



            // AST REWRITE
            // elements: a
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
            // 85:72: -> ^( FUNCTION[$name.text] $a)
            {
                dbg.location(85,75);
                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:85:75: ^( FUNCTION[$name.text] $a)
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(85,77);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, (name!=null?name.getText():null)), root_1);

                dbg.location(85,98);
                adaptor.addChild(root_1, stream_a.nextNode());

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
        dbg.location(85, 101);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "func");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "func"

    // $ANTLR start synpred23_MappingDSL
    public final void synpred23_MappingDSL_fragment() throws RecognitionException {   
        List list_a=null;
        RuleReturnScope a = null;
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:19: (a+= areaExpr )
        dbg.enterAlt(1);

        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:42:19: a+= areaExpr
        {
        dbg.location(42,20);
        pushFollow(FOLLOW_areaExpr_in_synpred23_MappingDSL253);
        a=areaExpr();

        state._fsp--;
        if (state.failed) return ;
        if (list_a==null) list_a=new ArrayList();
        list_a.add(a);


        }
    }
    // $ANTLR end synpred23_MappingDSL

    // $ANTLR start synpred32_MappingDSL
    public final void synpred32_MappingDSL_fragment() throws RecognitionException {   
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:54:4: ( coord DASH coord )
        dbg.enterAlt(1);

        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:54:4: coord DASH coord
        {
        dbg.location(54,4);
        pushFollow(FOLLOW_coord_in_synpred32_MappingDSL402);
        coord();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(54,10);
        match(input,DASH,FOLLOW_DASH_in_synpred32_MappingDSL404); if (state.failed) return ;
        dbg.location(54,15);
        pushFollow(FOLLOW_coord_in_synpred32_MappingDSL406);
        coord();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_MappingDSL

    // $ANTLR start synpred43_MappingDSL
    public final void synpred43_MappingDSL_fragment() throws RecognitionException {   
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:8: ( ( ID ':' )? rectangle )
        dbg.enterAlt(1);

        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:8: ( ID ':' )? rectangle
        {
        dbg.location(66,8);
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:8: ( ID ':' )?
        int alt42=2;
        try { dbg.enterSubRule(42);
        try { dbg.enterDecision(42);

        int LA42_0 = input.LA(1);

        if ( (LA42_0==ID) ) {
            alt42=1;
        }
        } finally {dbg.exitDecision(42);}

        switch (alt42) {
            case 1 :
                dbg.enterAlt(1);

                // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:66:9: ID ':'
                {
                dbg.location(66,9);
                match(input,ID,FOLLOW_ID_in_synpred43_MappingDSL556); if (state.failed) return ;
                dbg.location(66,12);
                match(input,33,FOLLOW_33_in_synpred43_MappingDSL558); if (state.failed) return ;

                }
                break;

        }
        } finally {dbg.exitSubRule(42);}

        dbg.location(66,18);
        pushFollow(FOLLOW_rectangle_in_synpred43_MappingDSL562);
        rectangle();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_MappingDSL

    // $ANTLR start synpred58_MappingDSL
    public final void synpred58_MappingDSL_fragment() throws RecognitionException {   
        List list_a=null;
        RuleReturnScope a = null;
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:40: (a+= areaAction )
        dbg.enterAlt(1);

        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:40: a+= areaAction
        {
        dbg.location(83,41);
        pushFollow(FOLLOW_areaAction_in_synpred58_MappingDSL695);
        a=areaAction();

        state._fsp--;
        if (state.failed) return ;
        if (list_a==null) list_a=new ArrayList();
        list_a.add(a);


        }
    }
    // $ANTLR end synpred58_MappingDSL

    // $ANTLR start synpred59_MappingDSL
    public final void synpred59_MappingDSL_fragment() throws RecognitionException {   
        List list_a=null;
        RuleReturnScope a = null;
        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:54: (a+= procCall ';' )
        dbg.enterAlt(1);

        // /Users/michaelstover/Documents/workspace/coinjema/grammar/MappingDSL.g:83:54: a+= procCall ';'
        {
        dbg.location(83,55);
        pushFollow(FOLLOW_procCall_in_synpred59_MappingDSL699);
        a=procCall();

        state._fsp--;
        if (state.failed) return ;
        if (list_a==null) list_a=new ArrayList();
        list_a.add(a);

        dbg.location(83,66);
        match(input,36,FOLLOW_36_in_synpred59_MappingDSL701); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_MappingDSL

    // Delegated rules

    public final boolean synpred58_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred58_MappingDSL_fragment(); // can never throw exception
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
    public final boolean synpred59_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred59_MappingDSL_fragment(); // can never throw exception
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
    public final boolean synpred43_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred43_MappingDSL_fragment(); // can never throw exception
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
    public final boolean synpred23_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred23_MappingDSL_fragment(); // can never throw exception
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
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA1_eotS =
        "\22\uffff";
    static final String DFA1_eofS =
        "\1\1\21\uffff";
    static final String DFA1_minS =
        "\1\20\1\uffff\1\23\4\uffff\1\20\12\uffff";
    static final String DFA1_maxS =
        "\1\64\1\uffff\1\45\4\uffff\1\54\12\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\5\1\uffff\1\2\1\uffff\1\3\1\4\10\uffff\1\1\2\uffff";
    static final String DFA1_specialS =
        "\22\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\uffff\1\3\25\uffff\1\3\10\uffff\1\5\2\uffff\1\6",
            "",
            "\2\3\14\uffff\1\7\3\uffff\1\3",
            "",
            "",
            "",
            "",
            "\3\3\3\uffff\1\3\21\uffff\1\3\1\uffff\3\17",
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
            return "()* loopback of 24:8: ( context | areaAction | proc | func )*";
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
        "\1\20\1\uffff\1\26\7\uffff";
    static final String DFA4_maxS =
        "\1\26\1\uffff\1\51\7\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\4\2\uffff\1\3\2\uffff";
    static final String DFA4_specialS =
        "\12\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\1\3\4\uffff\1\1",
            "",
            "\1\1\15\uffff\1\7\1\4\1\7\2\uffff\1\1",
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
            return "31:1: action : ( image -> ^( IMAGE[$image.text] ) | COLOR | ID | procCall );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA5_eotS =
        "\43\uffff";
    static final String DFA5_eofS =
        "\1\3\21\uffff\1\10\20\uffff";
    static final String DFA5_minS =
        "\2\20\1\22\17\uffff\1\20\20\uffff";
    static final String DFA5_maxS =
        "\1\63\2\31\17\uffff\1\63\20\uffff";
    static final String DFA5_acceptS =
        "\3\uffff\1\2\4\uffff\1\1\32\uffff";
    static final String DFA5_specialS =
        "\43\uffff}>";
    static final String[] DFA5_transitionS = {
            "\3\3\2\2\1\10\1\1\1\10\2\3\12\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\3\12\uffff\1\3",
            "\1\3\1\uffff\1\10\5\uffff\2\10",
            "\1\22\5\uffff\2\10",
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
            "\12\10\12\uffff\1\10\1\uffff\1\10\1\3\1\10\12\uffff\1\10",
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
            return "37:8: ( ( DASH | PLUS | MULT | DIV | OP ) simpleExpr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA6_eotS =
        "\43\uffff";
    static final String DFA6_eofS =
        "\1\3\21\uffff\1\10\20\uffff";
    static final String DFA6_minS =
        "\2\20\1\22\17\uffff\1\20\20\uffff";
    static final String DFA6_maxS =
        "\1\63\2\31\17\uffff\1\63\20\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\1\2\4\uffff\1\1\32\uffff";
    static final String DFA6_specialS =
        "\43\uffff}>";
    static final String[] DFA6_transitionS = {
            "\3\3\2\2\1\10\1\1\1\uffff\2\3\12\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\3\12\uffff\1\3",
            "\1\3\1\uffff\1\10\5\uffff\2\10",
            "\1\22\5\uffff\2\10",
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
            "\12\10\12\uffff\1\10\1\uffff\1\10\1\3\1\10\12\uffff\1\10",
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
            return "38:10: ( ( DASH | PLUS | MULT | DIV ) simpleExpr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA7_eotS =
        "\37\uffff";
    static final String DFA7_eofS =
        "\1\2\15\uffff\1\17\20\uffff";
    static final String DFA7_minS =
        "\1\20\1\22\14\uffff\1\20\20\uffff";
    static final String DFA7_maxS =
        "\1\63\1\31\14\uffff\1\63\20\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\17\uffff";
    static final String DFA7_specialS =
        "\37\uffff}>";
    static final String[] DFA7_transitionS = {
            "\4\2\1\1\1\uffff\1\2\1\uffff\2\2\12\uffff\1\2\1\uffff\1\2\1"+
            "\uffff\1\2\12\uffff\1\2",
            "\1\16\5\uffff\2\17",
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
            "\12\17\12\uffff\1\17\1\uffff\1\17\1\2\1\17\12\uffff\1\17",
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
            return "39:11: ( PLUS simpleExpr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA9_eotS =
        "\41\uffff";
    static final String DFA9_eofS =
        "\41\uffff";
    static final String DFA9_minS =
        "\1\20\1\uffff\1\0\2\uffff\1\20\33\uffff";
    static final String DFA9_maxS =
        "\1\50\1\uffff\1\0\2\uffff\1\50\33\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\4\4\uffff\1\1\1\2\1\3\30\uffff";
    static final String DFA9_specialS =
        "\2\uffff\1\0\36\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\1\1\5\2\7\1\uffff\1\1\1\uffff\2\10\14\uffff\1\1\1\uffff"+
            "\1\6",
            "",
            "\1\uffff",
            "",
            "",
            "\12\10\14\uffff\1\10\1\6\1\10",
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
            return "()* loopback of 42:18: (a+= areaExpr | a+= offset | a+= simpleExpr )*";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_2 = input.LA(1);

                         
                        int index9_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_MappingDSL()) ) {s = 6;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index9_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA14_eotS =
        "\55\uffff";
    static final String DFA14_eofS =
        "\55\uffff";
    static final String DFA14_minS =
        "\1\22\1\uffff\1\22\1\47\1\uffff\1\22\1\23\1\22\1\47\2\22\1\47\1"+
        "\0\1\22\17\uffff\1\0\17\uffff";
    static final String DFA14_maxS =
        "\1\50\1\uffff\1\50\1\47\1\uffff\1\22\1\23\1\50\1\47\2\22\1\47\1"+
        "\0\1\22\17\uffff\1\0\17\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\50\uffff";
    static final String DFA14_specialS =
        "\14\uffff\1\0\20\uffff\1\1\17\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1\25\uffff\1\2",
            "",
            "\1\3\25\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\7",
            "\1\10\25\uffff\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\uffff",
            "\1\35",
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
            "\1\uffff",
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

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "53:1: rectangle : ( coord DASH coord -> ^( RECTANGLE coord coord ) | 'raw' coord DASH coord -> ^( RECTANGLE RAW coord coord ) );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_12 = input.LA(1);

                         
                        int index14_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_MappingDSL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_29 = input.LA(1);

                         
                        int index14_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_MappingDSL()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_29);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA15_eotS =
        "\12\uffff";
    static final String DFA15_eofS =
        "\12\uffff";
    static final String DFA15_minS =
        "\1\22\1\uffff\1\22\1\47\1\uffff\1\22\1\25\1\22\2\uffff";
    static final String DFA15_maxS =
        "\1\50\1\uffff\1\50\1\47\1\uffff\1\22\1\25\1\30\2\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\5\uffff";
    static final String DFA15_specialS =
        "\12\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\25\uffff\1\2",
            "",
            "\1\3\25\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\7",
            "\1\1\5\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "58:1: circle : ( coord MULT INT -> ^( CIRCLE coord INT ) | 'raw' coord MULT FLOAT -> ^( CIRCLE RAW coord FLOAT ) );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA19_eotS =
        "\27\uffff";
    static final String DFA19_eofS =
        "\1\uffff\1\6\25\uffff";
    static final String DFA19_minS =
        "\2\20\2\uffff\1\20\22\uffff";
    static final String DFA19_maxS =
        "\1\50\1\63\2\uffff\1\50\22\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\1\2\uffff\1\3\1\2\20\uffff";
    static final String DFA19_specialS =
        "\27\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\uffff\1\2\25\uffff\1\2",
            "\5\6\1\uffff\1\6\1\uffff\2\6\7\uffff\1\4\2\uffff\1\6\1\5\1"+
            "\6\1\uffff\1\6\12\uffff\1\6",
            "",
            "",
            "\2\6\1\2\3\uffff\1\6\21\uffff\1\2",
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

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "61:1: areaExpr : ( area ( ( DASH | PLUS ) areaExpr )? | ID ( ( DASH | PLUS ) areaExpr )? | procCall ( ( DASH | PLUS ) areaExpr )? );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA16_eotS =
        "\24\uffff";
    static final String DFA16_eofS =
        "\1\2\23\uffff";
    static final String DFA16_minS =
        "\2\20\14\uffff\1\47\2\uffff\1\22\2\uffff";
    static final String DFA16_maxS =
        "\1\63\1\50\14\uffff\1\47\2\uffff\1\24\2\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\4\uffff";
    static final String DFA16_specialS =
        "\24\uffff}>";
    static final String[] DFA16_transitionS = {
            "\3\2\2\1\1\uffff\1\2\1\uffff\2\2\7\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\1\2\12\uffff\1\2",
            "\1\17\1\uffff\1\16\25\uffff\1\17",
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
            "\1\21",
            "",
            "",
            "\1\17\2\2",
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
            return "61:16: ( ( DASH | PLUS ) areaExpr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA17_eotS =
        "\24\uffff";
    static final String DFA17_eofS =
        "\1\2\23\uffff";
    static final String DFA17_minS =
        "\2\20\14\uffff\1\47\2\uffff\1\22\2\uffff";
    static final String DFA17_maxS =
        "\1\63\1\50\14\uffff\1\47\2\uffff\1\24\2\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\4\uffff";
    static final String DFA17_specialS =
        "\24\uffff}>";
    static final String[] DFA17_transitionS = {
            "\3\2\2\1\1\uffff\1\2\1\uffff\2\2\7\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\1\2\12\uffff\1\2",
            "\1\17\1\uffff\1\16\25\uffff\1\17",
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
            "\1\21",
            "",
            "",
            "\1\17\2\2",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "62:7: ( ( DASH | PLUS ) areaExpr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA18_eotS =
        "\24\uffff";
    static final String DFA18_eofS =
        "\1\2\23\uffff";
    static final String DFA18_minS =
        "\2\20\14\uffff\1\47\2\uffff\1\22\2\uffff";
    static final String DFA18_maxS =
        "\1\63\1\50\14\uffff\1\47\2\uffff\1\24\2\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\4\uffff";
    static final String DFA18_specialS =
        "\24\uffff}>";
    static final String[] DFA18_transitionS = {
            "\3\2\2\1\1\uffff\1\2\1\uffff\2\2\7\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\1\2\12\uffff\1\2",
            "\1\17\1\uffff\1\16\25\uffff\1\17",
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
            "\1\21",
            "",
            "",
            "\1\17\2\2",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "63:13: ( ( DASH | PLUS ) areaExpr )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA23_eotS =
        "\u0111\uffff";
    static final String DFA23_eofS =
        "\12\uffff\1\21\26\uffff\1\21\1\uffff\1\21\50\uffff\1\21\u00c4\uffff";
    static final String DFA23_minS =
        "\1\20\1\41\1\47\3\22\1\47\1\22\1\47\1\22\1\20\1\22\1\47\1\22\1\47"+
        "\1\22\1\20\20\uffff\1\20\1\22\1\20\1\22\2\47\1\uffff\1\22\1\uffff"+
        "\1\20\17\uffff\1\23\1\20\20\uffff\1\20\2\22\1\47\1\uffff\1\47\1"+
        "\uffff\1\22\2\uffff\1\47\1\uffff\1\22\1\uffff\1\20\17\uffff\1\23"+
        "\1\uffff\1\0\2\22\1\47\1\uffff\1\22\1\47\1\uffff\1\47\1\uffff\1"+
        "\22\23\uffff\1\0\1\uffff\1\0\1\22\1\uffff\1\0\2\22\1\47\43\uffff"+
        "\1\0\21\uffff\1\0\1\uffff\1\0\1\22\63\uffff\1\0\21\uffff";
    static final String DFA23_maxS =
        "\1\50\1\41\1\47\2\50\1\22\1\47\1\22\1\47\1\50\1\63\1\22\1\47\1\22"+
        "\1\47\1\22\1\50\20\uffff\1\63\1\22\1\63\1\22\2\47\1\uffff\1\50\1"+
        "\uffff\1\50\17\uffff\1\25\1\50\20\uffff\1\63\1\22\1\24\1\47\1\uffff"+
        "\1\47\1\uffff\1\50\2\uffff\1\47\1\uffff\1\50\1\uffff\1\50\17\uffff"+
        "\1\25\1\uffff\1\0\1\22\1\24\1\47\1\uffff\1\24\1\47\1\uffff\1\47"+
        "\1\uffff\1\50\23\uffff\1\0\1\uffff\1\0\1\22\1\uffff\1\0\1\22\1\24"+
        "\1\47\43\uffff\1\0\21\uffff\1\0\1\uffff\1\0\1\22\63\uffff\1\0\21"+
        "\uffff";
    static final String DFA23_acceptS =
        "\21\uffff\1\3\16\uffff\1\2\63\uffff\1\1\u00bc\uffff";
    static final String DFA23_specialS =
        "\154\uffff\1\0\35\uffff\1\1\1\uffff\1\2\2\uffff\1\3\46\uffff\1\4"+
        "\21\uffff\1\5\1\uffff\1\6\64\uffff\1\7\21\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\1\uffff\1\2\25\uffff\1\3",
            "\1\4",
            "\1\5",
            "\1\6\25\uffff\1\7",
            "\1\10\25\uffff\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16\25\uffff\1\17",
            "\3\21\1\20\1\21\1\40\1\21\1\uffff\2\21\7\uffff\4\21\1\uffff"+
            "\1\21\1\uffff\1\21\12\uffff\1\21",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\21\1\uffff\1\46\25\uffff\1\50",
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
            "\3\21\1\52\1\21\1\40\1\21\1\uffff\2\21\7\uffff\4\21\1\uffff"+
            "\1\21\1\uffff\1\21\12\uffff\1\21",
            "\1\72",
            "\3\21\1\73\1\21\1\40\1\21\1\uffff\2\21\7\uffff\4\21\1\uffff"+
            "\1\21\1\uffff\1\21\12\uffff\1\21",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "\1\117\25\uffff\1\21",
            "",
            "\1\21\1\uffff\1\121\25\uffff\1\123",
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
            "\1\124\1\uffff\1\40",
            "\1\21\1\uffff\1\126\25\uffff\1\130",
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
            "\3\21\1\132\1\21\1\40\1\21\1\uffff\2\21\7\uffff\4\21\1\uffff"+
            "\1\21\1\uffff\1\21\12\uffff\1\21",
            "\1\152",
            "\1\154\2\21",
            "\1\155",
            "",
            "\1\156",
            "",
            "\1\157\25\uffff\1\21",
            "",
            "",
            "\1\161",
            "",
            "\1\162\25\uffff\1\21",
            "",
            "\1\21\1\uffff\1\164\25\uffff\1\166",
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
            "\1\124\1\uffff\1\40",
            "",
            "\1\uffff",
            "\1\u008a",
            "\1\u008c\2\21",
            "\1\u008d",
            "",
            "\1\u008f\2\21",
            "\1\u0090",
            "",
            "\1\u0091",
            "",
            "\1\u0092\25\uffff\1\21",
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
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\u00b6",
            "",
            "\1\uffff",
            "\1\u00c8",
            "\1\u00ca\2\21",
            "\1\u00cb",
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
            "\1\uffff",
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
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\u00ff",
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
            "\1\uffff",
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

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "66:1: area : ( ( ID ':' )? rectangle | ( ID ':' )? circle | ( ID ':' )? coord );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_108 = input.LA(1);

                         
                        int index23_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_108);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_138 = input.LA(1);

                         
                        int index23_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_138);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_140 = input.LA(1);

                         
                        int index23_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_140);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_143 = input.LA(1);

                         
                        int index23_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_143);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_182 = input.LA(1);

                         
                        int index23_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_182);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_200 = input.LA(1);

                         
                        int index23_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_200);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_202 = input.LA(1);

                         
                        int index23_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_202);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_255 = input.LA(1);

                         
                        int index23_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_MappingDSL()) ) {s = 84;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index23_255);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\12\uffff";
    static final String DFA36_eofS =
        "\12\uffff";
    static final String DFA36_minS =
        "\1\20\1\uffff\1\23\7\uffff";
    static final String DFA36_maxS =
        "\1\50\1\uffff\1\63\7\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\5\uffff";
    static final String DFA36_specialS =
        "\12\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\uffff\1\2\5\uffff\2\4\16\uffff\1\1",
            "",
            "\5\4\14\uffff\1\4\2\uffff\1\1\13\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "85:41: ( areaExpr | simpleExpr )";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_context_in_main72 = new BitSet(new long[]{0x0012010000050002L});
    public static final BitSet FOLLOW_areaAction_in_main74 = new BitSet(new long[]{0x0012010000050002L});
    public static final BitSet FOLLOW_proc_in_main76 = new BitSet(new long[]{0x0012010000050002L});
    public static final BitSet FOLLOW_func_in_main78 = new BitSet(new long[]{0x0012010000050002L});
    public static final BitSet FOLLOW_ID_in_context88 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_context90 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_coordinateSystem_in_context92 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_34_in_context97 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_35_in_context99 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_context103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_areaExpr_in_areaAction127 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_areaAction129 = new BitSet(new long[]{0x0000010000470000L});
    public static final BitSet FOLLOW_action_in_areaAction131 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_areaAction133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_image_in_action152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_action164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_action169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_action174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simpleExpr184 = new BitSet(new long[]{0x0000000000F80002L});
    public static final BitSet FOLLOW_set_in_simpleExpr187 = new BitSet(new long[]{0x0000000003040000L});
    public static final BitSet FOLLOW_simpleExpr_in_simpleExpr200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simpleExpr207 = new BitSet(new long[]{0x0000000000780002L});
    public static final BitSet FOLLOW_set_in_simpleExpr210 = new BitSet(new long[]{0x0000000003040000L});
    public static final BitSet FOLLOW_simpleExpr_in_simpleExpr221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_simpleExpr228 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_PLUS_in_simpleExpr231 = new BitSet(new long[]{0x0000000003040000L});
    public static final BitSet FOLLOW_simpleExpr_in_simpleExpr234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_procCall246 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_procCall248 = new BitSet(new long[]{0x00000140035F0000L});
    public static final BitSet FOLLOW_areaExpr_in_procCall253 = new BitSet(new long[]{0x00000140035F0000L});
    public static final BitSet FOLLOW_offset_in_procCall257 = new BitSet(new long[]{0x00000140035F0000L});
    public static final BitSet FOLLOW_simpleExpr_in_procCall261 = new BitSet(new long[]{0x00000140035F0000L});
    public static final BitSet FOLLOW_action_in_procCall265 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_procCall268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_offset292 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INT_in_offset298 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_offset300 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_set_in_offset303 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INT_in_offset309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_coord321 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_coord323 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INT_in_coord327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_coord344 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INT_in_coord348 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_coord350 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INT_in_coord354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_image379 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_image382 = new BitSet(new long[]{0x0000020000400000L});
    public static final BitSet FOLLOW_DIV_in_image385 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_image387 = new BitSet(new long[]{0x0000020000400000L});
    public static final BitSet FOLLOW_41_in_image391 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_image393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coord_in_rectangle402 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DASH_in_rectangle404 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_rectangle406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rectangle421 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_rectangle423 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DASH_in_rectangle425 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_rectangle427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coord_in_circle450 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_MULT_in_circle452 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INT_in_circle454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_circle469 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_circle471 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_MULT_in_circle473 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_FLOAT_in_circle475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_area_in_areaExpr495 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_areaExpr498 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_areaExpr_in_areaExpr505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_areaExpr513 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_areaExpr516 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_areaExpr_in_areaExpr523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_areaExpr531 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_areaExpr534 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_areaExpr_in_areaExpr541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_area556 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_area558 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_rectangle_in_area562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_area568 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_area570 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_circle_in_area574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_area580 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_area582 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_area586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_coordinateSystem597 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_coordinateSystem599 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem601 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_location_in_coordinateSystem604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_coordinateSystem610 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_coordinateSystem612 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem614 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_location_in_coordinateSystem617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_coordinateSystem623 = new BitSet(new long[]{0x0001E00000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem625 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_location_in_coordinateSystem628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_size639 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_size641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_size646 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_INT_in_size648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_location656 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_location658 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_area_in_location660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_location665 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_location667 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DIRECTION_in_location669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_proc677 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_proc681 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_proc683 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_ID_in_proc685 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_proc688 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_proc690 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_areaAction_in_proc695 = new BitSet(new long[]{0x0008010000050000L});
    public static final BitSet FOLLOW_procCall_in_proc699 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_proc701 = new BitSet(new long[]{0x0008010000050000L});
    public static final BitSet FOLLOW_51_in_proc705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_func724 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_func728 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_func730 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_ID_in_func732 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_func735 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_func737 = new BitSet(new long[]{0x0000010003050000L});
    public static final BitSet FOLLOW_areaExpr_in_func742 = new BitSet(new long[]{0x0008001000000000L});
    public static final BitSet FOLLOW_simpleExpr_in_func744 = new BitSet(new long[]{0x0008001000000000L});
    public static final BitSet FOLLOW_36_in_func747 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_func750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_areaExpr_in_synpred23_MappingDSL253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coord_in_synpred32_MappingDSL402 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DASH_in_synpred32_MappingDSL404 = new BitSet(new long[]{0x0000010000040000L});
    public static final BitSet FOLLOW_coord_in_synpred32_MappingDSL406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred43_MappingDSL556 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred43_MappingDSL558 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_rectangle_in_synpred43_MappingDSL562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_areaAction_in_synpred58_MappingDSL695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_synpred59_MappingDSL699 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_synpred59_MappingDSL701 = new BitSet(new long[]{0x0000000000000002L});

}