// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g 2010-06-01 21:32:42

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CONTEXT", "AREA_ACTION", "FUNC_CALL", "PROC_CALL", "OFFSET", "COORD", "IMAGE", "RECTANGLE", "CIRCLE", "RAW", "PROCEDURE", "FUNCTION", "ARGLIST", "BODY", "COORDINATE_SYSTEM", "SYSTEM_SIZE", "NEG", "ID", "COLOR", "STRING", "DASH", "PLUS", "FLOAT", "MULT", "DIV", "INT", "OP", "DIRECTION", "WS", "EXPONENT", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'{'", "';'", "'}'", "':'", "'('", "')'", "','", "'.'", "'hex'", "'square'", "'free'", "'outline'", "'inline'", "'size'", "'each'", "'proc'", "'func'", "'['", "']'", "'[r'"
    };
    public static final int DIRECTION=31;
    public static final int FUNCTION=15;
    public static final int EXPONENT=33;
    public static final int PROC_CALL=7;
    public static final int COORDINATE_SYSTEM=18;
    public static final int OCTAL_ESC=37;
    public static final int ARGLIST=16;
    public static final int FLOAT=26;
    public static final int ID=21;
    public static final int EOF=-1;
    public static final int COLOR=22;
    public static final int CONTEXT=4;
    public static final int FUNC_CALL=6;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int RAW=13;
    public static final int ESC_SEQ=34;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int SYSTEM_SIZE=19;
    public static final int OFFSET=8;
    public static final int IMAGE=10;
    public static final int RECTANGLE=11;
    public static final int PLUS=25;
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
    public static final int DASH=24;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int UNICODE_ESC=36;
    public static final int HEX_DIGIT=35;
    public static final int INT=29;
    public static final int MULT=27;
    public static final int PROCEDURE=14;
    public static final int WS=32;
    public static final int AREA_ACTION=5;
    public static final int CIRCLE=12;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int OP=30;
    public static final int NEG=20;
    public static final int DIV=28;
    public static final int STRING=23;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "proc", "synpred16_MappingDSL", "synpred25_MappingDSL", 
        "synpred14_MappingDSL", "synpred58_MappingDSL", "synpred38_MappingDSL", 
        "synpred13_MappingDSL", "synpred19_MappingDSL", "lines", "size", 
        "coord", "synpred37_MappingDSL", "synpred41_MappingDSL", "action", 
        "synpred33_MappingDSL", "coordinateSystem", "synpred29_MappingDSL", 
        "synpred4_MappingDSL", "synpred24_MappingDSL", "synpred59_MappingDSL", 
        "synpred55_MappingDSL", "synpred2_MappingDSL", "synpred12_MappingDSL", 
        "synpred36_MappingDSL", "synpred11_MappingDSL", "func", "synpred56_MappingDSL", 
        "synpred54_MappingDSL", "synpred3_MappingDSL", "synpred43_MappingDSL", 
        "synpred31_MappingDSL", "synpred7_MappingDSL", "synpred35_MappingDSL", 
        "synpred23_MappingDSL", "synpred6_MappingDSL", "synpred21_MappingDSL", 
        "expr", "synpred51_MappingDSL", "synpred44_MappingDSL", "synpred45_MappingDSL", 
        "synpred22_MappingDSL", "synpred42_MappingDSL", "synpred5_MappingDSL", 
        "synpred15_MappingDSL", "synpred10_MappingDSL", "synpred48_MappingDSL", 
        "image", "synpred46_MappingDSL", "synpred39_MappingDSL", "main", 
        "synpred49_MappingDSL", "synpred17_MappingDSL", "synpred52_MappingDSL", 
        "contextBodyEl", "synpred1_MappingDSL", "synpred20_MappingDSL", 
        "synpred9_MappingDSL", "synpred57_MappingDSL", "synpred28_MappingDSL", 
        "synpred18_MappingDSL", "synpred30_MappingDSL", "synpred32_MappingDSL", 
        "synpred40_MappingDSL", "procCall", "synpred47_MappingDSL", "synpred8_MappingDSL", 
        "synpred53_MappingDSL", "areaAction", "synpred26_MappingDSL", "synpred50_MappingDSL", 
        "synpred34_MappingDSL", "synpred27_MappingDSL"
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
            this.state.ruleMemo = new HashMap[72+1];
             
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
        this.state.ruleMemo = new HashMap[72+1];
         
         
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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:30:1: main : ID '{' coordinateSystem ';' ( contextBodyEl )* '}' -> ^( CONTEXT[$ID.text] coordinateSystem ( contextBodyEl )* ) ;
    public final MappingDSLParser.main_return main() throws RecognitionException {
        MappingDSLParser.main_return retval = new MappingDSLParser.main_return();
        retval.start = input.LT(1);
        int main_StartIndex = input.index();
        Object root_0 = null;

        Token ID1=null;
        Token char_literal2=null;
        Token char_literal4=null;
        Token char_literal6=null;
        MappingDSLParser.coordinateSystem_return coordinateSystem3 = null;

        MappingDSLParser.contextBodyEl_return contextBodyEl5 = null;


        Object ID1_tree=null;
        Object char_literal2_tree=null;
        Object char_literal4_tree=null;
        Object char_literal6_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_coordinateSystem=new RewriteRuleSubtreeStream(adaptor,"rule coordinateSystem");
        RewriteRuleSubtreeStream stream_contextBodyEl=new RewriteRuleSubtreeStream(adaptor,"rule contextBodyEl");
        try { dbg.enterRule(getGrammarFileName(), "main");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(30, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:30:6: ( ID '{' coordinateSystem ';' ( contextBodyEl )* '}' -> ^( CONTEXT[$ID.text] coordinateSystem ( contextBodyEl )* ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:30:8: ID '{' coordinateSystem ';' ( contextBodyEl )* '}'
            {
            dbg.location(30,8);
            ID1=(Token)match(input,ID,FOLLOW_ID_in_main91); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID1);

            dbg.location(30,11);
            char_literal2=(Token)match(input,38,FOLLOW_38_in_main93); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal2);

            dbg.location(30,15);
            pushFollow(FOLLOW_coordinateSystem_in_main95);
            coordinateSystem3=coordinateSystem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_coordinateSystem.add(coordinateSystem3.getTree());
            dbg.location(30,32);
            char_literal4=(Token)match(input,39,FOLLOW_39_in_main97); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(char_literal4);

            dbg.location(30,36);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:30:36: ( contextBodyEl )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
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

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: contextBodyEl
            	    {
            	    dbg.location(30,36);
            	    pushFollow(FOLLOW_contextBodyEl_in_main99);
            	    contextBodyEl5=contextBodyEl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_contextBodyEl.add(contextBodyEl5.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(30,51);
            char_literal6=(Token)match(input,40,FOLLOW_40_in_main102); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal6);



            // AST REWRITE
            // elements: contextBodyEl, coordinateSystem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 30:55: -> ^( CONTEXT[$ID.text] coordinateSystem ( contextBodyEl )* )
            {
                dbg.location(30,58);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:30:58: ^( CONTEXT[$ID.text] coordinateSystem ( contextBodyEl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(30,60);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTEXT, (ID1!=null?ID1.getText():null)), root_1);

                dbg.location(30,78);
                adaptor.addChild(root_1, stream_coordinateSystem.nextTree());
                dbg.location(30,95);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:30:95: ( contextBodyEl )*
                while ( stream_contextBodyEl.hasNext() ) {
                    dbg.location(30,95);
                    adaptor.addChild(root_1, stream_contextBodyEl.nextTree());

                }
                stream_contextBodyEl.reset();

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
            if ( state.backtracking>0 ) { memoize(input, 1, main_StartIndex); }
        }
        dbg.location(30, 110);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "main");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "main"

    public static class contextBodyEl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "contextBodyEl"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:32:1: contextBodyEl : ( areaAction | proc | func );
    public final MappingDSLParser.contextBodyEl_return contextBodyEl() throws RecognitionException {
        MappingDSLParser.contextBodyEl_return retval = new MappingDSLParser.contextBodyEl_return();
        retval.start = input.LT(1);
        int contextBodyEl_StartIndex = input.index();
        Object root_0 = null;

        MappingDSLParser.areaAction_return areaAction7 = null;

        MappingDSLParser.proc_return proc8 = null;

        MappingDSLParser.func_return func9 = null;



        try { dbg.enterRule(getGrammarFileName(), "contextBodyEl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(32, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:2: ( areaAction | proc | func )
            int alt2=3;
            try { dbg.enterDecision(2);

            try {
                isCyclicDecision = true;
                alt2 = dfa2.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:33:4: areaAction
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(33,4);
                    pushFollow(FOLLOW_areaAction_in_contextBodyEl123);
                    areaAction7=areaAction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, areaAction7.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:34:4: proc
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(34,4);
                    pushFollow(FOLLOW_proc_in_contextBodyEl128);
                    proc8=proc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, proc8.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:35:4: func
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(35,4);
                    pushFollow(FOLLOW_func_in_contextBodyEl133);
                    func9=func();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, func9.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 2, contextBodyEl_StartIndex); }
        }
        dbg.location(35, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "contextBodyEl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "contextBodyEl"

    public static class areaAction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "areaAction"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:37:1: areaAction : expr ':' action ';' -> ^( AREA_ACTION expr action ) ;
    public final MappingDSLParser.areaAction_return areaAction() throws RecognitionException {
        MappingDSLParser.areaAction_return retval = new MappingDSLParser.areaAction_return();
        retval.start = input.LT(1);
        int areaAction_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal11=null;
        Token char_literal13=null;
        MappingDSLParser.expr_return expr10 = null;

        MappingDSLParser.action_return action12 = null;


        Object char_literal11_tree=null;
        Object char_literal13_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try { dbg.enterRule(getGrammarFileName(), "areaAction");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(37, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:38:2: ( expr ':' action ';' -> ^( AREA_ACTION expr action ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:38:4: expr ':' action ';'
            {
            dbg.location(38,4);
            pushFollow(FOLLOW_expr_in_areaAction142);
            expr10=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr10.getTree());
            dbg.location(38,9);
            char_literal11=(Token)match(input,41,FOLLOW_41_in_areaAction144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal11);

            dbg.location(38,13);
            pushFollow(FOLLOW_action_in_areaAction146);
            action12=action();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_action.add(action12.getTree());
            dbg.location(38,20);
            char_literal13=(Token)match(input,39,FOLLOW_39_in_areaAction148); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(char_literal13);



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
            // 38:24: -> ^( AREA_ACTION expr action )
            {
                dbg.location(38,27);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:38:27: ^( AREA_ACTION expr action )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(38,29);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AREA_ACTION, "AREA_ACTION"), root_1);

                dbg.location(38,41);
                adaptor.addChild(root_1, stream_expr.nextTree());
                dbg.location(38,46);
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
            if ( state.backtracking>0 ) { memoize(input, 3, areaAction_StartIndex); }
        }
        dbg.location(38, 53);

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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:40:1: action : ( image -> ^( IMAGE[$image.text] ) | COLOR | procCall | ID | STRING );
    public final MappingDSLParser.action_return action() throws RecognitionException {
        MappingDSLParser.action_return retval = new MappingDSLParser.action_return();
        retval.start = input.LT(1);
        int action_StartIndex = input.index();
        Object root_0 = null;

        Token COLOR15=null;
        Token ID17=null;
        Token STRING18=null;
        MappingDSLParser.image_return image14 = null;

        MappingDSLParser.procCall_return procCall16 = null;


        Object COLOR15_tree=null;
        Object ID17_tree=null;
        Object STRING18_tree=null;
        RewriteRuleSubtreeStream stream_image=new RewriteRuleSubtreeStream(adaptor,"rule image");
        try { dbg.enterRule(getGrammarFileName(), "action");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:40:8: ( image -> ^( IMAGE[$image.text] ) | COLOR | procCall | ID | STRING )
            int alt3=5;
            try { dbg.enterDecision(3);

            try {
                isCyclicDecision = true;
                alt3 = dfa3.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:40:10: image
                    {
                    dbg.location(40,10);
                    pushFollow(FOLLOW_image_in_action167);
                    image14=image();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_image.add(image14.getTree());


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
                    // 40:16: -> ^( IMAGE[$image.text] )
                    {
                        dbg.location(40,19);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:40:19: ^( IMAGE[$image.text] )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(40,21);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMAGE, (image14!=null?input.toString(image14.start,image14.stop):null)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:41:4: COLOR
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(41,4);
                    COLOR15=(Token)match(input,COLOR,FOLLOW_COLOR_in_action179); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLOR15_tree = (Object)adaptor.create(COLOR15);
                    adaptor.addChild(root_0, COLOR15_tree);
                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:42:4: procCall
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(42,4);
                    pushFollow(FOLLOW_procCall_in_action184);
                    procCall16=procCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, procCall16.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:43:4: ID
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(43,4);
                    ID17=(Token)match(input,ID,FOLLOW_ID_in_action189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID17_tree = (Object)adaptor.create(ID17);
                    adaptor.addChild(root_0, ID17_tree);
                    }

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:44:4: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(44,4);
                    STRING18=(Token)match(input,STRING,FOLLOW_STRING_in_action194); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING18_tree = (Object)adaptor.create(STRING18);
                    adaptor.addChild(root_0, STRING18_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 4, action_StartIndex); }
        }
        dbg.location(44, 10);

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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:46:1: expr : ( coord ( ( DASH | PLUS ) expr )? | FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )? | INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )? | STRING ( PLUS expr )? | procCall ( ( DASH | PLUS ) expr )? | '(' expr ')' | ID ( ( DASH | PLUS | MULT | DIV ) expr )? );
    public final MappingDSLParser.expr_return expr() throws RecognitionException {
        MappingDSLParser.expr_return retval = new MappingDSLParser.expr_return();
        retval.start = input.LT(1);
        int expr_StartIndex = input.index();
        Object root_0 = null;

        Token set20=null;
        Token FLOAT22=null;
        Token set23=null;
        Token INT25=null;
        Token set26=null;
        Token STRING28=null;
        Token PLUS29=null;
        Token set32=null;
        Token char_literal34=null;
        Token char_literal36=null;
        Token ID37=null;
        Token set38=null;
        MappingDSLParser.coord_return coord19 = null;

        MappingDSLParser.expr_return expr21 = null;

        MappingDSLParser.expr_return expr24 = null;

        MappingDSLParser.expr_return expr27 = null;

        MappingDSLParser.expr_return expr30 = null;

        MappingDSLParser.procCall_return procCall31 = null;

        MappingDSLParser.expr_return expr33 = null;

        MappingDSLParser.expr_return expr35 = null;

        MappingDSLParser.expr_return expr39 = null;


        Object set20_tree=null;
        Object FLOAT22_tree=null;
        Object set23_tree=null;
        Object INT25_tree=null;
        Object set26_tree=null;
        Object STRING28_tree=null;
        Object PLUS29_tree=null;
        Object set32_tree=null;
        Object char_literal34_tree=null;
        Object char_literal36_tree=null;
        Object ID37_tree=null;
        Object set38_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(46, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:47:2: ( coord ( ( DASH | PLUS ) expr )? | FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )? | INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )? | STRING ( PLUS expr )? | procCall ( ( DASH | PLUS ) expr )? | '(' expr ')' | ID ( ( DASH | PLUS | MULT | DIV ) expr )? )
            int alt10=7;
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

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:47:4: coord ( ( DASH | PLUS ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(47,4);
                    pushFollow(FOLLOW_coord_in_expr204);
                    coord19=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, coord19.getTree());
                    dbg.location(47,10);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:47:10: ( ( DASH | PLUS ) expr )?
                    int alt4=2;
                    try { dbg.enterSubRule(4);
                    try { dbg.enterDecision(4);

                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=DASH && LA4_0<=PLUS)) ) {
                        alt4=1;
                    }
                    } finally {dbg.exitDecision(4);}

                    switch (alt4) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:47:11: ( DASH | PLUS ) expr
                            {
                            dbg.location(47,11);
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

                            dbg.location(47,24);
                            pushFollow(FOLLOW_expr_in_expr214);
                            expr21=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr21.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(4);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:48:4: FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(48,4);
                    FLOAT22=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_expr221); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT22_tree = (Object)adaptor.create(FLOAT22);
                    adaptor.addChild(root_0, FLOAT22_tree);
                    }
                    dbg.location(48,10);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:48:10: ( ( DASH | PLUS | MULT | DIV ) expr )?
                    int alt5=2;
                    try { dbg.enterSubRule(5);
                    try { dbg.enterDecision(5);

                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=DASH && LA5_0<=PLUS)||(LA5_0>=MULT && LA5_0<=DIV)) ) {
                        alt5=1;
                    }
                    } finally {dbg.exitDecision(5);}

                    switch (alt5) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:48:11: ( DASH | PLUS | MULT | DIV ) expr
                            {
                            dbg.location(48,11);
                            set23=(Token)input.LT(1);
                            set23=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS)||(input.LA(1)>=MULT && input.LA(1)<=DIV) ) {
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

                            dbg.location(48,33);
                            pushFollow(FOLLOW_expr_in_expr235);
                            expr24=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr24.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(5);}


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:4: INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(49,4);
                    INT25=(Token)match(input,INT,FOLLOW_INT_in_expr242); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT25_tree = (Object)adaptor.create(INT25);
                    adaptor.addChild(root_0, INT25_tree);
                    }
                    dbg.location(49,8);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:8: ( ( DASH | PLUS | MULT | DIV | OP ) expr )?
                    int alt6=2;
                    try { dbg.enterSubRule(6);
                    try { dbg.enterDecision(6);

                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=DASH && LA6_0<=PLUS)||(LA6_0>=MULT && LA6_0<=DIV)||LA6_0==OP) ) {
                        alt6=1;
                    }
                    } finally {dbg.exitDecision(6);}

                    switch (alt6) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:49:9: ( DASH | PLUS | MULT | DIV | OP ) expr
                            {
                            dbg.location(49,9);
                            set26=(Token)input.LT(1);
                            set26=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS)||(input.LA(1)>=MULT && input.LA(1)<=DIV)||input.LA(1)==OP ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set26), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(49,34);
                            pushFollow(FOLLOW_expr_in_expr258);
                            expr27=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr27.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(6);}


                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:50:4: STRING ( PLUS expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(50,4);
                    STRING28=(Token)match(input,STRING,FOLLOW_STRING_in_expr265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING28_tree = (Object)adaptor.create(STRING28);
                    adaptor.addChild(root_0, STRING28_tree);
                    }
                    dbg.location(50,11);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:50:11: ( PLUS expr )?
                    int alt7=2;
                    try { dbg.enterSubRule(7);
                    try { dbg.enterDecision(7);

                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==PLUS) ) {
                        alt7=1;
                    }
                    } finally {dbg.exitDecision(7);}

                    switch (alt7) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:50:12: PLUS expr
                            {
                            dbg.location(50,16);
                            PLUS29=(Token)match(input,PLUS,FOLLOW_PLUS_in_expr268); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUS29_tree = (Object)adaptor.create(PLUS29);
                            root_0 = (Object)adaptor.becomeRoot(PLUS29_tree, root_0);
                            }
                            dbg.location(50,18);
                            pushFollow(FOLLOW_expr_in_expr271);
                            expr30=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr30.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(7);}


                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:51:4: procCall ( ( DASH | PLUS ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(51,4);
                    pushFollow(FOLLOW_procCall_in_expr278);
                    procCall31=procCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, procCall31.getTree());
                    dbg.location(51,13);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:51:13: ( ( DASH | PLUS ) expr )?
                    int alt8=2;
                    try { dbg.enterSubRule(8);
                    try { dbg.enterDecision(8);

                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=DASH && LA8_0<=PLUS)) ) {
                        alt8=1;
                    }
                    } finally {dbg.exitDecision(8);}

                    switch (alt8) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:51:14: ( DASH | PLUS ) expr
                            {
                            dbg.location(51,14);
                            set32=(Token)input.LT(1);
                            set32=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set32), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(51,27);
                            pushFollow(FOLLOW_expr_in_expr288);
                            expr33=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr33.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(8);}


                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:52:4: '(' expr ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(52,4);
                    char_literal34=(Token)match(input,42,FOLLOW_42_in_expr296); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = (Object)adaptor.create(char_literal34);
                    adaptor.addChild(root_0, char_literal34_tree);
                    }
                    dbg.location(52,8);
                    pushFollow(FOLLOW_expr_in_expr298);
                    expr35=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr35.getTree());
                    dbg.location(52,13);
                    char_literal36=(Token)match(input,43,FOLLOW_43_in_expr300); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal36_tree = (Object)adaptor.create(char_literal36);
                    adaptor.addChild(root_0, char_literal36_tree);
                    }

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:53:4: ID ( ( DASH | PLUS | MULT | DIV ) expr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(53,4);
                    ID37=(Token)match(input,ID,FOLLOW_ID_in_expr305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID37_tree = (Object)adaptor.create(ID37);
                    adaptor.addChild(root_0, ID37_tree);
                    }
                    dbg.location(53,7);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:53:7: ( ( DASH | PLUS | MULT | DIV ) expr )?
                    int alt9=2;
                    try { dbg.enterSubRule(9);
                    try { dbg.enterDecision(9);

                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=DASH && LA9_0<=PLUS)||(LA9_0>=MULT && LA9_0<=DIV)) ) {
                        alt9=1;
                    }
                    } finally {dbg.exitDecision(9);}

                    switch (alt9) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:53:8: ( DASH | PLUS | MULT | DIV ) expr
                            {
                            dbg.location(53,8);
                            set38=(Token)input.LT(1);
                            set38=(Token)input.LT(1);
                            if ( (input.LA(1)>=DASH && input.LA(1)<=PLUS)||(input.LA(1)>=MULT && input.LA(1)<=DIV) ) {
                                input.consume();
                                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set38), root_0);
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                dbg.recognitionException(mse);
                                throw mse;
                            }

                            dbg.location(53,30);
                            pushFollow(FOLLOW_expr_in_expr319);
                            expr39=expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr39.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(9);}


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
            if ( state.backtracking>0 ) { memoize(input, 5, expr_StartIndex); }
        }
        dbg.location(54, 2);

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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:1: procCall : ID '(' ( expr ( ',' expr )* )? ( ',' action )? ')' -> ^( PROC_CALL[$ID.text] ( expr )* ( action )? ) ;
    public final MappingDSLParser.procCall_return procCall() throws RecognitionException {
        MappingDSLParser.procCall_return retval = new MappingDSLParser.procCall_return();
        retval.start = input.LT(1);
        int procCall_StartIndex = input.index();
        Object root_0 = null;

        Token ID40=null;
        Token char_literal41=null;
        Token char_literal43=null;
        Token char_literal45=null;
        Token char_literal47=null;
        MappingDSLParser.expr_return expr42 = null;

        MappingDSLParser.expr_return expr44 = null;

        MappingDSLParser.action_return action46 = null;


        Object ID40_tree=null;
        Object char_literal41_tree=null;
        Object char_literal43_tree=null;
        Object char_literal45_tree=null;
        Object char_literal47_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try { dbg.enterRule(getGrammarFileName(), "procCall");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:9: ( ID '(' ( expr ( ',' expr )* )? ( ',' action )? ')' -> ^( PROC_CALL[$ID.text] ( expr )* ( action )? ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:11: ID '(' ( expr ( ',' expr )* )? ( ',' action )? ')'
            {
            dbg.location(56,11);
            ID40=(Token)match(input,ID,FOLLOW_ID_in_procCall331); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID40);

            dbg.location(56,14);
            char_literal41=(Token)match(input,42,FOLLOW_42_in_procCall333); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_42.add(char_literal41);

            dbg.location(56,18);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:18: ( expr ( ',' expr )* )?
            int alt12=2;
            try { dbg.enterSubRule(12);
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

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:19: expr ( ',' expr )*
                    {
                    dbg.location(56,19);
                    pushFollow(FOLLOW_expr_in_procCall336);
                    expr42=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr42.getTree());
                    dbg.location(56,24);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:24: ( ',' expr )*
                    try { dbg.enterSubRule(11);

                    loop11:
                    do {
                        int alt11=2;
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

                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:25: ',' expr
                    	    {
                    	    dbg.location(56,25);
                    	    char_literal43=(Token)match(input,44,FOLLOW_44_in_procCall339); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_44.add(char_literal43);

                    	    dbg.location(56,29);
                    	    pushFollow(FOLLOW_expr_in_procCall341);
                    	    expr44=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr44.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(11);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(12);}

            dbg.location(56,38);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:38: ( ',' action )?
            int alt13=2;
            try { dbg.enterSubRule(13);
            try { dbg.enterDecision(13);

            int LA13_0 = input.LA(1);

            if ( (LA13_0==44) ) {
                alt13=1;
            }
            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:39: ',' action
                    {
                    dbg.location(56,39);
                    char_literal45=(Token)match(input,44,FOLLOW_44_in_procCall348); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal45);

                    dbg.location(56,43);
                    pushFollow(FOLLOW_action_in_procCall350);
                    action46=action();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_action.add(action46.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(13);}

            dbg.location(56,52);
            char_literal47=(Token)match(input,43,FOLLOW_43_in_procCall354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal47);



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
            // 56:56: -> ^( PROC_CALL[$ID.text] ( expr )* ( action )? )
            {
                dbg.location(56,59);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:59: ^( PROC_CALL[$ID.text] ( expr )* ( action )? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(56,61);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROC_CALL, (ID40!=null?ID40.getText():null)), root_1);

                dbg.location(56,81);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:81: ( expr )*
                while ( stream_expr.hasNext() ) {
                    dbg.location(56,81);
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();
                dbg.location(56,87);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:87: ( action )?
                if ( stream_action.hasNext() ) {
                    dbg.location(56,87);
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
            if ( state.backtracking>0 ) { memoize(input, 6, procCall_StartIndex); }
        }
        dbg.location(57, 2);

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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:59:1: image : ( DIV )? ID ( DIV ID )* '.' ID ;
    public final MappingDSLParser.image_return image() throws RecognitionException {
        MappingDSLParser.image_return retval = new MappingDSLParser.image_return();
        retval.start = input.LT(1);
        int image_StartIndex = input.index();
        Object root_0 = null;

        Token DIV48=null;
        Token ID49=null;
        Token DIV50=null;
        Token ID51=null;
        Token char_literal52=null;
        Token ID53=null;

        Object DIV48_tree=null;
        Object ID49_tree=null;
        Object DIV50_tree=null;
        Object ID51_tree=null;
        Object char_literal52_tree=null;
        Object ID53_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "image");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(59, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:59:7: ( ( DIV )? ID ( DIV ID )* '.' ID )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:59:9: ( DIV )? ID ( DIV ID )* '.' ID
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(59,9);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:59:9: ( DIV )?
            int alt14=2;
            try { dbg.enterSubRule(14);
            try { dbg.enterDecision(14);

            int LA14_0 = input.LA(1);

            if ( (LA14_0==DIV) ) {
                alt14=1;
            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: DIV
                    {
                    dbg.location(59,9);
                    DIV48=(Token)match(input,DIV,FOLLOW_DIV_in_image377); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV48_tree = (Object)adaptor.create(DIV48);
                    adaptor.addChild(root_0, DIV48_tree);
                    }

                    }
                    break;

            }
            } finally {dbg.exitSubRule(14);}

            dbg.location(59,14);
            ID49=(Token)match(input,ID,FOLLOW_ID_in_image380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID49_tree = (Object)adaptor.create(ID49);
            adaptor.addChild(root_0, ID49_tree);
            }
            dbg.location(59,17);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:59:17: ( DIV ID )*
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=2;
                try { dbg.enterDecision(15);

                int LA15_0 = input.LA(1);

                if ( (LA15_0==DIV) ) {
                    alt15=1;
                }


                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:59:18: DIV ID
            	    {
            	    dbg.location(59,18);
            	    DIV50=(Token)match(input,DIV,FOLLOW_DIV_in_image383); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV50_tree = (Object)adaptor.create(DIV50);
            	    adaptor.addChild(root_0, DIV50_tree);
            	    }
            	    dbg.location(59,22);
            	    ID51=(Token)match(input,ID,FOLLOW_ID_in_image385); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    ID51_tree = (Object)adaptor.create(ID51);
            	    adaptor.addChild(root_0, ID51_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);
            } finally {dbg.exitSubRule(15);}

            dbg.location(59,27);
            char_literal52=(Token)match(input,45,FOLLOW_45_in_image389); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal52_tree = (Object)adaptor.create(char_literal52);
            adaptor.addChild(root_0, char_literal52_tree);
            }
            dbg.location(59,31);
            ID53=(Token)match(input,ID,FOLLOW_ID_in_image391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID53_tree = (Object)adaptor.create(ID53);
            adaptor.addChild(root_0, ID53_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 7, image_StartIndex); }
        }
        dbg.location(59, 33);

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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:61:1: coordinateSystem : ( 'hex' coord ( size )? ( lines )? -> ^( COORDINATE_SYSTEM[\"hex\"] coord ( size )? ( lines )? ) | 'square' coord ( size )? ( lines )? -> ^( COORDINATE_SYSTEM[\"square\"] coord ( size )? ( lines )? ) | 'free' ( size )? ( lines )? -> ^( COORDINATE_SYSTEM[\"free\"] ( size )? ( lines )? ) );
    public final MappingDSLParser.coordinateSystem_return coordinateSystem() throws RecognitionException {
        MappingDSLParser.coordinateSystem_return retval = new MappingDSLParser.coordinateSystem_return();
        retval.start = input.LT(1);
        int coordinateSystem_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal54=null;
        Token string_literal58=null;
        Token string_literal62=null;
        MappingDSLParser.coord_return coord55 = null;

        MappingDSLParser.size_return size56 = null;

        MappingDSLParser.lines_return lines57 = null;

        MappingDSLParser.coord_return coord59 = null;

        MappingDSLParser.size_return size60 = null;

        MappingDSLParser.lines_return lines61 = null;

        MappingDSLParser.size_return size63 = null;

        MappingDSLParser.lines_return lines64 = null;


        Object string_literal54_tree=null;
        Object string_literal58_tree=null;
        Object string_literal62_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleSubtreeStream stream_coord=new RewriteRuleSubtreeStream(adaptor,"rule coord");
        RewriteRuleSubtreeStream stream_lines=new RewriteRuleSubtreeStream(adaptor,"rule lines");
        RewriteRuleSubtreeStream stream_size=new RewriteRuleSubtreeStream(adaptor,"rule size");
        try { dbg.enterRule(getGrammarFileName(), "coordinateSystem");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(61, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:62:2: ( 'hex' coord ( size )? ( lines )? -> ^( COORDINATE_SYSTEM[\"hex\"] coord ( size )? ( lines )? ) | 'square' coord ( size )? ( lines )? -> ^( COORDINATE_SYSTEM[\"square\"] coord ( size )? ( lines )? ) | 'free' ( size )? ( lines )? -> ^( COORDINATE_SYSTEM[\"free\"] ( size )? ( lines )? ) )
            int alt22=3;
            try { dbg.enterDecision(22);

            switch ( input.LA(1) ) {
            case 46:
                {
                alt22=1;
                }
                break;
            case 47:
                {
                alt22=2;
                }
                break;
            case 48:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(22);}

            switch (alt22) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:62:4: 'hex' coord ( size )? ( lines )?
                    {
                    dbg.location(62,4);
                    string_literal54=(Token)match(input,46,FOLLOW_46_in_coordinateSystem400); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal54);

                    dbg.location(62,10);
                    pushFollow(FOLLOW_coord_in_coordinateSystem402);
                    coord55=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord55.getTree());
                    dbg.location(62,16);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:62:16: ( size )?
                    int alt16=2;
                    try { dbg.enterSubRule(16);
                    try { dbg.enterDecision(16);

                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=51 && LA16_0<=52)) ) {
                        alt16=1;
                    }
                    } finally {dbg.exitDecision(16);}

                    switch (alt16) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(62,16);
                            pushFollow(FOLLOW_size_in_coordinateSystem404);
                            size56=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_size.add(size56.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(16);}

                    dbg.location(62,22);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:62:22: ( lines )?
                    int alt17=2;
                    try { dbg.enterSubRule(17);
                    try { dbg.enterDecision(17);

                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=49 && LA17_0<=50)) ) {
                        alt17=1;
                    }
                    } finally {dbg.exitDecision(17);}

                    switch (alt17) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: lines
                            {
                            dbg.location(62,22);
                            pushFollow(FOLLOW_lines_in_coordinateSystem407);
                            lines57=lines();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_lines.add(lines57.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(17);}



                    // AST REWRITE
                    // elements: size, coord, lines
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 62:29: -> ^( COORDINATE_SYSTEM[\"hex\"] coord ( size )? ( lines )? )
                    {
                        dbg.location(62,32);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:62:32: ^( COORDINATE_SYSTEM[\"hex\"] coord ( size )? ( lines )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(62,34);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORDINATE_SYSTEM, "hex"), root_1);

                        dbg.location(62,59);
                        adaptor.addChild(root_1, stream_coord.nextTree());
                        dbg.location(62,65);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:62:65: ( size )?
                        if ( stream_size.hasNext() ) {
                            dbg.location(62,65);
                            adaptor.addChild(root_1, stream_size.nextTree());

                        }
                        stream_size.reset();
                        dbg.location(62,71);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:62:71: ( lines )?
                        if ( stream_lines.hasNext() ) {
                            dbg.location(62,71);
                            adaptor.addChild(root_1, stream_lines.nextTree());

                        }
                        stream_lines.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:4: 'square' coord ( size )? ( lines )?
                    {
                    dbg.location(63,4);
                    string_literal58=(Token)match(input,47,FOLLOW_47_in_coordinateSystem428); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal58);

                    dbg.location(63,13);
                    pushFollow(FOLLOW_coord_in_coordinateSystem430);
                    coord59=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord59.getTree());
                    dbg.location(63,19);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:19: ( size )?
                    int alt18=2;
                    try { dbg.enterSubRule(18);
                    try { dbg.enterDecision(18);

                    int LA18_0 = input.LA(1);

                    if ( ((LA18_0>=51 && LA18_0<=52)) ) {
                        alt18=1;
                    }
                    } finally {dbg.exitDecision(18);}

                    switch (alt18) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(63,19);
                            pushFollow(FOLLOW_size_in_coordinateSystem432);
                            size60=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_size.add(size60.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(18);}

                    dbg.location(63,25);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:25: ( lines )?
                    int alt19=2;
                    try { dbg.enterSubRule(19);
                    try { dbg.enterDecision(19);

                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=49 && LA19_0<=50)) ) {
                        alt19=1;
                    }
                    } finally {dbg.exitDecision(19);}

                    switch (alt19) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: lines
                            {
                            dbg.location(63,25);
                            pushFollow(FOLLOW_lines_in_coordinateSystem435);
                            lines61=lines();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_lines.add(lines61.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(19);}



                    // AST REWRITE
                    // elements: coord, size, lines
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 63:32: -> ^( COORDINATE_SYSTEM[\"square\"] coord ( size )? ( lines )? )
                    {
                        dbg.location(63,35);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:35: ^( COORDINATE_SYSTEM[\"square\"] coord ( size )? ( lines )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(63,37);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORDINATE_SYSTEM, "square"), root_1);

                        dbg.location(63,65);
                        adaptor.addChild(root_1, stream_coord.nextTree());
                        dbg.location(63,71);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:71: ( size )?
                        if ( stream_size.hasNext() ) {
                            dbg.location(63,71);
                            adaptor.addChild(root_1, stream_size.nextTree());

                        }
                        stream_size.reset();
                        dbg.location(63,77);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:63:77: ( lines )?
                        if ( stream_lines.hasNext() ) {
                            dbg.location(63,77);
                            adaptor.addChild(root_1, stream_lines.nextTree());

                        }
                        stream_lines.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:64:4: 'free' ( size )? ( lines )?
                    {
                    dbg.location(64,4);
                    string_literal62=(Token)match(input,48,FOLLOW_48_in_coordinateSystem456); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal62);

                    dbg.location(64,11);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:64:11: ( size )?
                    int alt20=2;
                    try { dbg.enterSubRule(20);
                    try { dbg.enterDecision(20);

                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=51 && LA20_0<=52)) ) {
                        alt20=1;
                    }
                    } finally {dbg.exitDecision(20);}

                    switch (alt20) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: size
                            {
                            dbg.location(64,11);
                            pushFollow(FOLLOW_size_in_coordinateSystem458);
                            size63=size();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_size.add(size63.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(20);}

                    dbg.location(64,17);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:64:17: ( lines )?
                    int alt21=2;
                    try { dbg.enterSubRule(21);
                    try { dbg.enterDecision(21);

                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=49 && LA21_0<=50)) ) {
                        alt21=1;
                    }
                    } finally {dbg.exitDecision(21);}

                    switch (alt21) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: lines
                            {
                            dbg.location(64,17);
                            pushFollow(FOLLOW_lines_in_coordinateSystem461);
                            lines64=lines();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_lines.add(lines64.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(21);}



                    // AST REWRITE
                    // elements: size, lines
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 64:24: -> ^( COORDINATE_SYSTEM[\"free\"] ( size )? ( lines )? )
                    {
                        dbg.location(64,27);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:64:27: ^( COORDINATE_SYSTEM[\"free\"] ( size )? ( lines )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(64,29);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORDINATE_SYSTEM, "free"), root_1);

                        dbg.location(64,55);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:64:55: ( size )?
                        if ( stream_size.hasNext() ) {
                            dbg.location(64,55);
                            adaptor.addChild(root_1, stream_size.nextTree());

                        }
                        stream_size.reset();
                        dbg.location(64,61);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:64:61: ( lines )?
                        if ( stream_lines.hasNext() ) {
                            dbg.location(64,61);
                            adaptor.addChild(root_1, stream_lines.nextTree());

                        }
                        stream_lines.reset();

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
            if ( state.backtracking>0 ) { memoize(input, 8, coordinateSystem_StartIndex); }
        }
        dbg.location(65, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "coordinateSystem");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "coordinateSystem"

    public static class lines_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lines"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:67:1: lines : ( 'outline' | 'inline' );
    public final MappingDSLParser.lines_return lines() throws RecognitionException {
        MappingDSLParser.lines_return retval = new MappingDSLParser.lines_return();
        retval.start = input.LT(1);
        int lines_StartIndex = input.index();
        Object root_0 = null;

        Token set65=null;

        Object set65_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "lines");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(67, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:67:7: ( 'outline' | 'inline' )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(67,7);
            set65=(Token)input.LT(1);
            if ( (input.LA(1)>=49 && input.LA(1)<=50) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set65));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
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
            if ( state.backtracking>0 ) { memoize(input, 9, lines_StartIndex); }
        }
        dbg.location(69, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "lines");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "lines"

    public static class size_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "size"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:1: size : ( 'size' coord -> ^( SYSTEM_SIZE coord ) | 'each' INT -> ^( SYSTEM_SIZE INT ) );
    public final MappingDSLParser.size_return size() throws RecognitionException {
        MappingDSLParser.size_return retval = new MappingDSLParser.size_return();
        retval.start = input.LT(1);
        int size_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal66=null;
        Token string_literal68=null;
        Token INT69=null;
        MappingDSLParser.coord_return coord67 = null;


        Object string_literal66_tree=null;
        Object string_literal68_tree=null;
        Object INT69_tree=null;
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleSubtreeStream stream_coord=new RewriteRuleSubtreeStream(adaptor,"rule coord");
        try { dbg.enterRule(getGrammarFileName(), "size");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(71, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:6: ( 'size' coord -> ^( SYSTEM_SIZE coord ) | 'each' INT -> ^( SYSTEM_SIZE INT ) )
            int alt23=2;
            try { dbg.enterDecision(23);

            int LA23_0 = input.LA(1);

            if ( (LA23_0==51) ) {
                alt23=1;
            }
            else if ( (LA23_0==52) ) {
                alt23=2;
            }
            else {
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

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:8: 'size' coord
                    {
                    dbg.location(71,8);
                    string_literal66=(Token)match(input,51,FOLLOW_51_in_size501); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(string_literal66);

                    dbg.location(71,15);
                    pushFollow(FOLLOW_coord_in_size503);
                    coord67=coord();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_coord.add(coord67.getTree());


                    // AST REWRITE
                    // elements: coord
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 71:21: -> ^( SYSTEM_SIZE coord )
                    {
                        dbg.location(71,24);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:71:24: ^( SYSTEM_SIZE coord )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(71,26);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SYSTEM_SIZE, "SYSTEM_SIZE"), root_1);

                        dbg.location(71,38);
                        adaptor.addChild(root_1, stream_coord.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:72:4: 'each' INT
                    {
                    dbg.location(72,4);
                    string_literal68=(Token)match(input,52,FOLLOW_52_in_size516); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_52.add(string_literal68);

                    dbg.location(72,11);
                    INT69=(Token)match(input,INT,FOLLOW_INT_in_size518); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT69);



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

                    root_0 = (Object)adaptor.nil();
                    // 72:15: -> ^( SYSTEM_SIZE INT )
                    {
                        dbg.location(72,18);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:72:18: ^( SYSTEM_SIZE INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(72,20);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SYSTEM_SIZE, "SYSTEM_SIZE"), root_1);

                        dbg.location(72,32);
                        adaptor.addChild(root_1, stream_INT.nextNode());

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
            if ( state.backtracking>0 ) { memoize(input, 10, size_StartIndex); }
        }
        dbg.location(72, 36);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "size");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "size"

    public static class proc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "proc"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:1: proc : 'proc' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' (a+= areaAction )+ '}' -> ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) ) ;
    public final MappingDSLParser.proc_return proc() throws RecognitionException {
        MappingDSLParser.proc_return retval = new MappingDSLParser.proc_return();
        retval.start = input.LT(1);
        int proc_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal70=null;
        Token char_literal71=null;
        Token char_literal72=null;
        Token char_literal73=null;
        Token char_literal74=null;
        Token char_literal75=null;
        Token arg=null;
        List list_arg=null;
        List list_a=null;
        RuleReturnScope a = null;
        Object name_tree=null;
        Object string_literal70_tree=null;
        Object char_literal71_tree=null;
        Object char_literal72_tree=null;
        Object char_literal73_tree=null;
        Object char_literal74_tree=null;
        Object char_literal75_tree=null;
        Object arg_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_areaAction=new RewriteRuleSubtreeStream(adaptor,"rule areaAction");
        try { dbg.enterRule(getGrammarFileName(), "proc");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(74, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:6: ( 'proc' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' (a+= areaAction )+ '}' -> ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:8: 'proc' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' (a+= areaAction )+ '}'
            {
            dbg.location(74,8);
            string_literal70=(Token)match(input,53,FOLLOW_53_in_proc534); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_53.add(string_literal70);

            dbg.location(74,19);
            name=(Token)match(input,ID,FOLLOW_ID_in_proc538); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            dbg.location(74,23);
            char_literal71=(Token)match(input,42,FOLLOW_42_in_proc540); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_42.add(char_literal71);

            dbg.location(74,27);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:27: (arg+= ID ( ',' arg+= ID )* )?
            int alt25=2;
            try { dbg.enterSubRule(25);
            try { dbg.enterDecision(25);

            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID) ) {
                alt25=1;
            }
            } finally {dbg.exitDecision(25);}

            switch (alt25) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:28: arg+= ID ( ',' arg+= ID )*
                    {
                    dbg.location(74,31);
                    arg=(Token)match(input,ID,FOLLOW_ID_in_proc545); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(arg);

                    if (list_arg==null) list_arg=new ArrayList();
                    list_arg.add(arg);

                    dbg.location(74,36);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:36: ( ',' arg+= ID )*
                    try { dbg.enterSubRule(24);

                    loop24:
                    do {
                        int alt24=2;
                        try { dbg.enterDecision(24);

                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==44) ) {
                            alt24=1;
                        }


                        } finally {dbg.exitDecision(24);}

                        switch (alt24) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:37: ',' arg+= ID
                    	    {
                    	    dbg.location(74,37);
                    	    char_literal72=(Token)match(input,44,FOLLOW_44_in_proc548); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_44.add(char_literal72);

                    	    dbg.location(74,44);
                    	    arg=(Token)match(input,ID,FOLLOW_ID_in_proc552); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(arg);

                    	    if (list_arg==null) list_arg=new ArrayList();
                    	    list_arg.add(arg);


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(24);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(25);}

            dbg.location(74,53);
            char_literal73=(Token)match(input,43,FOLLOW_43_in_proc558); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal73);

            dbg.location(74,57);
            char_literal74=(Token)match(input,38,FOLLOW_38_in_proc560); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal74);

            dbg.location(74,61);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:61: (a+= areaAction )+
            int cnt26=0;
            try { dbg.enterSubRule(26);

            loop26:
            do {
                int alt26=2;
                try { dbg.enterDecision(26);

                int LA26_0 = input.LA(1);

                if ( (LA26_0==ID||LA26_0==STRING||LA26_0==FLOAT||LA26_0==INT||LA26_0==42||LA26_0==55||LA26_0==57) ) {
                    alt26=1;
                }


                } finally {dbg.exitDecision(26);}

                switch (alt26) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:62: a+= areaAction
            	    {
            	    dbg.location(74,63);
            	    pushFollow(FOLLOW_areaAction_in_proc565);
            	    a=areaAction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_areaAction.add(a.getTree());
            	    if (list_a==null) list_a=new ArrayList();
            	    list_a.add(a.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt26++;
            } while (true);
            } finally {dbg.exitSubRule(26);}

            dbg.location(74,78);
            char_literal75=(Token)match(input,40,FOLLOW_40_in_proc569); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal75);



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
            // 74:82: -> ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) )
            {
                dbg.location(74,85);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:85: ^( PROCEDURE[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY ( $a)+ ) )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(74,87);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCEDURE, (name!=null?name.getText():null)), root_1);

                dbg.location(74,109);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:109: ^( ARGLIST ( $arg)* )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(74,111);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGLIST, "ARGLIST"), root_2);

                dbg.location(74,119);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:119: ( $arg)*
                while ( stream_arg.hasNext() ) {
                    dbg.location(74,119);
                    adaptor.addChild(root_2, stream_arg.nextNode());

                }
                stream_arg.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(74,126);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:74:126: ^( BODY ( $a)+ )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(74,128);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_2);

                dbg.location(74,133);
                if ( !(stream_a.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_a.hasNext() ) {
                    dbg.location(74,133);
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
            if ( state.backtracking>0 ) { memoize(input, 11, proc_StartIndex); }
        }
        dbg.location(74, 138);

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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:1: func : 'func' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' expr ( ';' )? '}' -> ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) ) ;
    public final MappingDSLParser.func_return func() throws RecognitionException {
        MappingDSLParser.func_return retval = new MappingDSLParser.func_return();
        retval.start = input.LT(1);
        int func_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal76=null;
        Token char_literal77=null;
        Token char_literal78=null;
        Token char_literal79=null;
        Token char_literal80=null;
        Token char_literal82=null;
        Token char_literal83=null;
        Token arg=null;
        List list_arg=null;
        MappingDSLParser.expr_return expr81 = null;


        Object name_tree=null;
        Object string_literal76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal78_tree=null;
        Object char_literal79_tree=null;
        Object char_literal80_tree=null;
        Object char_literal82_tree=null;
        Object char_literal83_tree=null;
        Object arg_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try { dbg.enterRule(getGrammarFileName(), "func");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(76, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:6: ( 'func' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' expr ( ';' )? '}' -> ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) ) )
            dbg.enterAlt(1);

            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:8: 'func' name= ID '(' (arg+= ID ( ',' arg+= ID )* )? ')' '{' expr ( ';' )? '}'
            {
            dbg.location(76,8);
            string_literal76=(Token)match(input,54,FOLLOW_54_in_func600); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_54.add(string_literal76);

            dbg.location(76,19);
            name=(Token)match(input,ID,FOLLOW_ID_in_func604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            dbg.location(76,23);
            char_literal77=(Token)match(input,42,FOLLOW_42_in_func606); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_42.add(char_literal77);

            dbg.location(76,27);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:27: (arg+= ID ( ',' arg+= ID )* )?
            int alt28=2;
            try { dbg.enterSubRule(28);
            try { dbg.enterDecision(28);

            int LA28_0 = input.LA(1);

            if ( (LA28_0==ID) ) {
                alt28=1;
            }
            } finally {dbg.exitDecision(28);}

            switch (alt28) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:28: arg+= ID ( ',' arg+= ID )*
                    {
                    dbg.location(76,31);
                    arg=(Token)match(input,ID,FOLLOW_ID_in_func611); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(arg);

                    if (list_arg==null) list_arg=new ArrayList();
                    list_arg.add(arg);

                    dbg.location(76,36);
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:36: ( ',' arg+= ID )*
                    try { dbg.enterSubRule(27);

                    loop27:
                    do {
                        int alt27=2;
                        try { dbg.enterDecision(27);

                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==44) ) {
                            alt27=1;
                        }


                        } finally {dbg.exitDecision(27);}

                        switch (alt27) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:37: ',' arg+= ID
                    	    {
                    	    dbg.location(76,37);
                    	    char_literal78=(Token)match(input,44,FOLLOW_44_in_func614); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_44.add(char_literal78);

                    	    dbg.location(76,44);
                    	    arg=(Token)match(input,ID,FOLLOW_ID_in_func618); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(arg);

                    	    if (list_arg==null) list_arg=new ArrayList();
                    	    list_arg.add(arg);


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(27);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(28);}

            dbg.location(76,53);
            char_literal79=(Token)match(input,43,FOLLOW_43_in_func624); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal79);

            dbg.location(76,57);
            char_literal80=(Token)match(input,38,FOLLOW_38_in_func626); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal80);

            dbg.location(76,61);
            pushFollow(FOLLOW_expr_in_func628);
            expr81=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr81.getTree());
            dbg.location(76,66);
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:66: ( ';' )?
            int alt29=2;
            try { dbg.enterSubRule(29);
            try { dbg.enterDecision(29);

            int LA29_0 = input.LA(1);

            if ( (LA29_0==39) ) {
                alt29=1;
            }
            } finally {dbg.exitDecision(29);}

            switch (alt29) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:0:0: ';'
                    {
                    dbg.location(76,66);
                    char_literal82=(Token)match(input,39,FOLLOW_39_in_func630); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal82);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(29);}

            dbg.location(76,71);
            char_literal83=(Token)match(input,40,FOLLOW_40_in_func633); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal83);



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
            // 76:75: -> ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) )
            {
                dbg.location(76,78);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:78: ^( FUNCTION[$name.text] ^( ARGLIST ( $arg)* ) ^( BODY expr ) )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(76,80);
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, (name!=null?name.getText():null)), root_1);

                dbg.location(76,101);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:101: ^( ARGLIST ( $arg)* )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(76,103);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGLIST, "ARGLIST"), root_2);

                dbg.location(76,111);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:111: ( $arg)*
                while ( stream_arg.hasNext() ) {
                    dbg.location(76,111);
                    adaptor.addChild(root_2, stream_arg.nextNode());

                }
                stream_arg.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(76,118);
                // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:76:118: ^( BODY expr )
                {
                Object root_2 = (Object)adaptor.nil();
                dbg.location(76,120);
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_2);

                dbg.location(76,125);
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
            if ( state.backtracking>0 ) { memoize(input, 12, func_StartIndex); }
        }
        dbg.location(76, 131);

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
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:79:1: coord : ( '[' a= expr ',' b= expr ']' -> ^( COORD $a $b) | '[' '-' a= expr ',' b= expr ']' -> ^( COORD ^( NEG $a) $b) | '[' a= expr ',' '-' b= expr ']' -> ^( COORD $a ^( NEG $b) ) | '[' '-' a= expr ',' '-' b= expr ']' -> ^( COORD ^( NEG $a) ^( NEG $b) ) | '[r' a= expr ',' b= expr ']' -> ^( COORD RAW $a $b) | '[r' '-' a= expr ',' b= expr ']' -> ^( COORD RAW ^( NEG $a) $b) | '[r' a= expr ',' '-' b= expr ']' -> ^( COORD RAW $a ^( NEG $b) ) | '[r' '-' a= expr ',' '-' b= expr ']' -> ^( COORD RAW ^( NEG $a) ^( NEG $b) ) );
    public final MappingDSLParser.coord_return coord() throws RecognitionException {
        MappingDSLParser.coord_return retval = new MappingDSLParser.coord_return();
        retval.start = input.LT(1);
        int coord_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal84=null;
        Token char_literal85=null;
        Token char_literal86=null;
        Token char_literal87=null;
        Token char_literal88=null;
        Token char_literal89=null;
        Token char_literal90=null;
        Token char_literal91=null;
        Token char_literal92=null;
        Token char_literal93=null;
        Token char_literal94=null;
        Token char_literal95=null;
        Token char_literal96=null;
        Token char_literal97=null;
        Token char_literal98=null;
        Token char_literal99=null;
        Token string_literal100=null;
        Token char_literal101=null;
        Token char_literal102=null;
        Token string_literal103=null;
        Token char_literal104=null;
        Token char_literal105=null;
        Token char_literal106=null;
        Token string_literal107=null;
        Token char_literal108=null;
        Token char_literal109=null;
        Token char_literal110=null;
        Token string_literal111=null;
        Token char_literal112=null;
        Token char_literal113=null;
        Token char_literal114=null;
        Token char_literal115=null;
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        Object char_literal84_tree=null;
        Object char_literal85_tree=null;
        Object char_literal86_tree=null;
        Object char_literal87_tree=null;
        Object char_literal88_tree=null;
        Object char_literal89_tree=null;
        Object char_literal90_tree=null;
        Object char_literal91_tree=null;
        Object char_literal92_tree=null;
        Object char_literal93_tree=null;
        Object char_literal94_tree=null;
        Object char_literal95_tree=null;
        Object char_literal96_tree=null;
        Object char_literal97_tree=null;
        Object char_literal98_tree=null;
        Object char_literal99_tree=null;
        Object string_literal100_tree=null;
        Object char_literal101_tree=null;
        Object char_literal102_tree=null;
        Object string_literal103_tree=null;
        Object char_literal104_tree=null;
        Object char_literal105_tree=null;
        Object char_literal106_tree=null;
        Object string_literal107_tree=null;
        Object char_literal108_tree=null;
        Object char_literal109_tree=null;
        Object char_literal110_tree=null;
        Object string_literal111_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;
        Object char_literal114_tree=null;
        Object char_literal115_tree=null;
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_DASH=new RewriteRuleTokenStream(adaptor,"token DASH");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try { dbg.enterRule(getGrammarFileName(), "coord");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(79, 1);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:79:7: ( '[' a= expr ',' b= expr ']' -> ^( COORD $a $b) | '[' '-' a= expr ',' b= expr ']' -> ^( COORD ^( NEG $a) $b) | '[' a= expr ',' '-' b= expr ']' -> ^( COORD $a ^( NEG $b) ) | '[' '-' a= expr ',' '-' b= expr ']' -> ^( COORD ^( NEG $a) ^( NEG $b) ) | '[r' a= expr ',' b= expr ']' -> ^( COORD RAW $a $b) | '[r' '-' a= expr ',' b= expr ']' -> ^( COORD RAW ^( NEG $a) $b) | '[r' a= expr ',' '-' b= expr ']' -> ^( COORD RAW $a ^( NEG $b) ) | '[r' '-' a= expr ',' '-' b= expr ']' -> ^( COORD RAW ^( NEG $a) ^( NEG $b) ) )
            int alt30=8;
            try { dbg.enterDecision(30);

            try {
                isCyclicDecision = true;
                alt30 = dfa30.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(30);}

            switch (alt30) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:79:10: '[' a= expr ',' b= expr ']'
                    {
                    dbg.location(79,10);
                    char_literal84=(Token)match(input,55,FOLLOW_55_in_coord664); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal84);

                    dbg.location(79,15);
                    pushFollow(FOLLOW_expr_in_coord668);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(79,21);
                    char_literal85=(Token)match(input,44,FOLLOW_44_in_coord670); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal85);

                    dbg.location(79,26);
                    pushFollow(FOLLOW_expr_in_coord674);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(79,32);
                    char_literal86=(Token)match(input,56,FOLLOW_56_in_coord676); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal86);



                    // AST REWRITE
                    // elements: b, a
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 79:36: -> ^( COORD $a $b)
                    {
                        dbg.location(79,39);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:79:39: ^( COORD $a $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(79,41);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(79,47);
                        adaptor.addChild(root_1, stream_a.nextTree());
                        dbg.location(79,50);
                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:80:4: '[' '-' a= expr ',' b= expr ']'
                    {
                    dbg.location(80,4);
                    char_literal87=(Token)match(input,55,FOLLOW_55_in_coord693); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal87);

                    dbg.location(80,8);
                    char_literal88=(Token)match(input,DASH,FOLLOW_DASH_in_coord695); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal88);

                    dbg.location(80,13);
                    pushFollow(FOLLOW_expr_in_coord699);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(80,19);
                    char_literal89=(Token)match(input,44,FOLLOW_44_in_coord701); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal89);

                    dbg.location(80,24);
                    pushFollow(FOLLOW_expr_in_coord705);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(80,30);
                    char_literal90=(Token)match(input,56,FOLLOW_56_in_coord707); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal90);



                    // AST REWRITE
                    // elements: b, a
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 80:34: -> ^( COORD ^( NEG $a) $b)
                    {
                        dbg.location(80,37);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:80:37: ^( COORD ^( NEG $a) $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(80,39);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(80,45);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:80:45: ^( NEG $a)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(80,47);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(80,51);
                        adaptor.addChild(root_2, stream_a.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        dbg.location(80,55);
                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:81:4: '[' a= expr ',' '-' b= expr ']'
                    {
                    dbg.location(81,4);
                    char_literal91=(Token)match(input,55,FOLLOW_55_in_coord728); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal91);

                    dbg.location(81,9);
                    pushFollow(FOLLOW_expr_in_coord732);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(81,15);
                    char_literal92=(Token)match(input,44,FOLLOW_44_in_coord734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal92);

                    dbg.location(81,19);
                    char_literal93=(Token)match(input,DASH,FOLLOW_DASH_in_coord736); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal93);

                    dbg.location(81,24);
                    pushFollow(FOLLOW_expr_in_coord740);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(81,30);
                    char_literal94=(Token)match(input,56,FOLLOW_56_in_coord742); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal94);



                    // AST REWRITE
                    // elements: a, b
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 81:34: -> ^( COORD $a ^( NEG $b) )
                    {
                        dbg.location(81,37);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:81:37: ^( COORD $a ^( NEG $b) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(81,39);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(81,45);
                        adaptor.addChild(root_1, stream_a.nextTree());
                        dbg.location(81,48);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:81:48: ^( NEG $b)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(81,50);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(81,54);
                        adaptor.addChild(root_2, stream_b.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:82:4: '[' '-' a= expr ',' '-' b= expr ']'
                    {
                    dbg.location(82,4);
                    char_literal95=(Token)match(input,55,FOLLOW_55_in_coord763); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal95);

                    dbg.location(82,8);
                    char_literal96=(Token)match(input,DASH,FOLLOW_DASH_in_coord765); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal96);

                    dbg.location(82,13);
                    pushFollow(FOLLOW_expr_in_coord769);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(82,19);
                    char_literal97=(Token)match(input,44,FOLLOW_44_in_coord771); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal97);

                    dbg.location(82,23);
                    char_literal98=(Token)match(input,DASH,FOLLOW_DASH_in_coord773); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal98);

                    dbg.location(82,28);
                    pushFollow(FOLLOW_expr_in_coord777);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(82,34);
                    char_literal99=(Token)match(input,56,FOLLOW_56_in_coord779); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal99);



                    // AST REWRITE
                    // elements: b, a
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 82:38: -> ^( COORD ^( NEG $a) ^( NEG $b) )
                    {
                        dbg.location(82,41);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:82:41: ^( COORD ^( NEG $a) ^( NEG $b) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(82,43);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(82,49);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:82:49: ^( NEG $a)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(82,51);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(82,55);
                        adaptor.addChild(root_2, stream_a.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        dbg.location(82,59);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:82:59: ^( NEG $b)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(82,61);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(82,65);
                        adaptor.addChild(root_2, stream_b.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:83:4: '[r' a= expr ',' b= expr ']'
                    {
                    dbg.location(83,4);
                    string_literal100=(Token)match(input,57,FOLLOW_57_in_coord804); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal100);

                    dbg.location(83,10);
                    pushFollow(FOLLOW_expr_in_coord808);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(83,16);
                    char_literal101=(Token)match(input,44,FOLLOW_44_in_coord810); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal101);

                    dbg.location(83,21);
                    pushFollow(FOLLOW_expr_in_coord814);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(83,27);
                    char_literal102=(Token)match(input,56,FOLLOW_56_in_coord816); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal102);



                    // AST REWRITE
                    // elements: a, b
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 83:31: -> ^( COORD RAW $a $b)
                    {
                        dbg.location(83,34);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:83:34: ^( COORD RAW $a $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(83,36);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(83,42);
                        adaptor.addChild(root_1, (Object)adaptor.create(RAW, "RAW"));
                        dbg.location(83,46);
                        adaptor.addChild(root_1, stream_a.nextTree());
                        dbg.location(83,49);
                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:84:4: '[r' '-' a= expr ',' b= expr ']'
                    {
                    dbg.location(84,4);
                    string_literal103=(Token)match(input,57,FOLLOW_57_in_coord835); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal103);

                    dbg.location(84,9);
                    char_literal104=(Token)match(input,DASH,FOLLOW_DASH_in_coord837); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal104);

                    dbg.location(84,14);
                    pushFollow(FOLLOW_expr_in_coord841);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(84,20);
                    char_literal105=(Token)match(input,44,FOLLOW_44_in_coord843); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal105);

                    dbg.location(84,25);
                    pushFollow(FOLLOW_expr_in_coord847);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(84,31);
                    char_literal106=(Token)match(input,56,FOLLOW_56_in_coord849); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal106);



                    // AST REWRITE
                    // elements: a, b
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:35: -> ^( COORD RAW ^( NEG $a) $b)
                    {
                        dbg.location(84,38);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:84:38: ^( COORD RAW ^( NEG $a) $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(84,40);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(84,46);
                        adaptor.addChild(root_1, (Object)adaptor.create(RAW, "RAW"));
                        dbg.location(84,50);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:84:50: ^( NEG $a)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(84,52);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(84,56);
                        adaptor.addChild(root_2, stream_a.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        dbg.location(84,60);
                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:85:4: '[r' a= expr ',' '-' b= expr ']'
                    {
                    dbg.location(85,4);
                    string_literal107=(Token)match(input,57,FOLLOW_57_in_coord872); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal107);

                    dbg.location(85,10);
                    pushFollow(FOLLOW_expr_in_coord876);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(85,16);
                    char_literal108=(Token)match(input,44,FOLLOW_44_in_coord878); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal108);

                    dbg.location(85,20);
                    char_literal109=(Token)match(input,DASH,FOLLOW_DASH_in_coord880); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal109);

                    dbg.location(85,25);
                    pushFollow(FOLLOW_expr_in_coord884);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(85,31);
                    char_literal110=(Token)match(input,56,FOLLOW_56_in_coord886); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal110);



                    // AST REWRITE
                    // elements: a, b
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:35: -> ^( COORD RAW $a ^( NEG $b) )
                    {
                        dbg.location(85,38);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:85:38: ^( COORD RAW $a ^( NEG $b) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(85,40);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(85,46);
                        adaptor.addChild(root_1, (Object)adaptor.create(RAW, "RAW"));
                        dbg.location(85,50);
                        adaptor.addChild(root_1, stream_a.nextTree());
                        dbg.location(85,53);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:85:53: ^( NEG $b)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(85,55);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(85,59);
                        adaptor.addChild(root_2, stream_b.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:86:4: '[r' '-' a= expr ',' '-' b= expr ']'
                    {
                    dbg.location(86,4);
                    string_literal111=(Token)match(input,57,FOLLOW_57_in_coord909); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal111);

                    dbg.location(86,9);
                    char_literal112=(Token)match(input,DASH,FOLLOW_DASH_in_coord911); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal112);

                    dbg.location(86,14);
                    pushFollow(FOLLOW_expr_in_coord915);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(a.getTree());
                    dbg.location(86,20);
                    char_literal113=(Token)match(input,44,FOLLOW_44_in_coord917); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal113);

                    dbg.location(86,24);
                    char_literal114=(Token)match(input,DASH,FOLLOW_DASH_in_coord919); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DASH.add(char_literal114);

                    dbg.location(86,29);
                    pushFollow(FOLLOW_expr_in_coord923);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(b.getTree());
                    dbg.location(86,35);
                    char_literal115=(Token)match(input,56,FOLLOW_56_in_coord925); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal115);



                    // AST REWRITE
                    // elements: a, b
                    // token labels: 
                    // rule labels: retval, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 86:39: -> ^( COORD RAW ^( NEG $a) ^( NEG $b) )
                    {
                        dbg.location(86,42);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:86:42: ^( COORD RAW ^( NEG $a) ^( NEG $b) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(86,44);
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COORD, "COORD"), root_1);

                        dbg.location(86,50);
                        adaptor.addChild(root_1, (Object)adaptor.create(RAW, "RAW"));
                        dbg.location(86,54);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:86:54: ^( NEG $a)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(86,56);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(86,60);
                        adaptor.addChild(root_2, stream_a.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        dbg.location(86,64);
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:86:64: ^( NEG $b)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        dbg.location(86,66);
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_2);

                        dbg.location(86,70);
                        adaptor.addChild(root_2, stream_b.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

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
            if ( state.backtracking>0 ) { memoize(input, 13, coord_StartIndex); }
        }
        dbg.location(87, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "coord");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "coord"

    // $ANTLR start synpred32_MappingDSL
    public final void synpred32_MappingDSL_fragment() throws RecognitionException {   
        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:25: ( ',' expr )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:56:25: ',' expr
        {
        dbg.location(56,25);
        match(input,44,FOLLOW_44_in_synpred32_MappingDSL339); if (state.failed) return ;
        dbg.location(56,29);
        pushFollow(FOLLOW_expr_in_synpred32_MappingDSL341);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_MappingDSL

    // $ANTLR start synpred53_MappingDSL
    public final void synpred53_MappingDSL_fragment() throws RecognitionException {   
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:79:10: ( '[' a= expr ',' b= expr ']' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:79:10: '[' a= expr ',' b= expr ']'
        {
        dbg.location(79,10);
        match(input,55,FOLLOW_55_in_synpred53_MappingDSL664); if (state.failed) return ;
        dbg.location(79,15);
        pushFollow(FOLLOW_expr_in_synpred53_MappingDSL668);
        a=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(79,21);
        match(input,44,FOLLOW_44_in_synpred53_MappingDSL670); if (state.failed) return ;
        dbg.location(79,26);
        pushFollow(FOLLOW_expr_in_synpred53_MappingDSL674);
        b=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(79,32);
        match(input,56,FOLLOW_56_in_synpred53_MappingDSL676); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_MappingDSL

    // $ANTLR start synpred54_MappingDSL
    public final void synpred54_MappingDSL_fragment() throws RecognitionException {   
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:80:4: ( '[' '-' a= expr ',' b= expr ']' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:80:4: '[' '-' a= expr ',' b= expr ']'
        {
        dbg.location(80,4);
        match(input,55,FOLLOW_55_in_synpred54_MappingDSL693); if (state.failed) return ;
        dbg.location(80,8);
        match(input,DASH,FOLLOW_DASH_in_synpred54_MappingDSL695); if (state.failed) return ;
        dbg.location(80,13);
        pushFollow(FOLLOW_expr_in_synpred54_MappingDSL699);
        a=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(80,19);
        match(input,44,FOLLOW_44_in_synpred54_MappingDSL701); if (state.failed) return ;
        dbg.location(80,24);
        pushFollow(FOLLOW_expr_in_synpred54_MappingDSL705);
        b=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(80,30);
        match(input,56,FOLLOW_56_in_synpred54_MappingDSL707); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_MappingDSL

    // $ANTLR start synpred55_MappingDSL
    public final void synpred55_MappingDSL_fragment() throws RecognitionException {   
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:81:4: ( '[' a= expr ',' '-' b= expr ']' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:81:4: '[' a= expr ',' '-' b= expr ']'
        {
        dbg.location(81,4);
        match(input,55,FOLLOW_55_in_synpred55_MappingDSL728); if (state.failed) return ;
        dbg.location(81,9);
        pushFollow(FOLLOW_expr_in_synpred55_MappingDSL732);
        a=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(81,15);
        match(input,44,FOLLOW_44_in_synpred55_MappingDSL734); if (state.failed) return ;
        dbg.location(81,19);
        match(input,DASH,FOLLOW_DASH_in_synpred55_MappingDSL736); if (state.failed) return ;
        dbg.location(81,24);
        pushFollow(FOLLOW_expr_in_synpred55_MappingDSL740);
        b=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(81,30);
        match(input,56,FOLLOW_56_in_synpred55_MappingDSL742); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_MappingDSL

    // $ANTLR start synpred56_MappingDSL
    public final void synpred56_MappingDSL_fragment() throws RecognitionException {   
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:82:4: ( '[' '-' a= expr ',' '-' b= expr ']' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:82:4: '[' '-' a= expr ',' '-' b= expr ']'
        {
        dbg.location(82,4);
        match(input,55,FOLLOW_55_in_synpred56_MappingDSL763); if (state.failed) return ;
        dbg.location(82,8);
        match(input,DASH,FOLLOW_DASH_in_synpred56_MappingDSL765); if (state.failed) return ;
        dbg.location(82,13);
        pushFollow(FOLLOW_expr_in_synpred56_MappingDSL769);
        a=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(82,19);
        match(input,44,FOLLOW_44_in_synpred56_MappingDSL771); if (state.failed) return ;
        dbg.location(82,23);
        match(input,DASH,FOLLOW_DASH_in_synpred56_MappingDSL773); if (state.failed) return ;
        dbg.location(82,28);
        pushFollow(FOLLOW_expr_in_synpred56_MappingDSL777);
        b=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(82,34);
        match(input,56,FOLLOW_56_in_synpred56_MappingDSL779); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_MappingDSL

    // $ANTLR start synpred57_MappingDSL
    public final void synpred57_MappingDSL_fragment() throws RecognitionException {   
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:83:4: ( '[r' a= expr ',' b= expr ']' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:83:4: '[r' a= expr ',' b= expr ']'
        {
        dbg.location(83,4);
        match(input,57,FOLLOW_57_in_synpred57_MappingDSL804); if (state.failed) return ;
        dbg.location(83,10);
        pushFollow(FOLLOW_expr_in_synpred57_MappingDSL808);
        a=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(83,16);
        match(input,44,FOLLOW_44_in_synpred57_MappingDSL810); if (state.failed) return ;
        dbg.location(83,21);
        pushFollow(FOLLOW_expr_in_synpred57_MappingDSL814);
        b=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(83,27);
        match(input,56,FOLLOW_56_in_synpred57_MappingDSL816); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_MappingDSL

    // $ANTLR start synpred58_MappingDSL
    public final void synpred58_MappingDSL_fragment() throws RecognitionException {   
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:84:4: ( '[r' '-' a= expr ',' b= expr ']' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:84:4: '[r' '-' a= expr ',' b= expr ']'
        {
        dbg.location(84,4);
        match(input,57,FOLLOW_57_in_synpred58_MappingDSL835); if (state.failed) return ;
        dbg.location(84,9);
        match(input,DASH,FOLLOW_DASH_in_synpred58_MappingDSL837); if (state.failed) return ;
        dbg.location(84,14);
        pushFollow(FOLLOW_expr_in_synpred58_MappingDSL841);
        a=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(84,20);
        match(input,44,FOLLOW_44_in_synpred58_MappingDSL843); if (state.failed) return ;
        dbg.location(84,25);
        pushFollow(FOLLOW_expr_in_synpred58_MappingDSL847);
        b=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(84,31);
        match(input,56,FOLLOW_56_in_synpred58_MappingDSL849); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_MappingDSL

    // $ANTLR start synpred59_MappingDSL
    public final void synpred59_MappingDSL_fragment() throws RecognitionException {   
        MappingDSLParser.expr_return a = null;

        MappingDSLParser.expr_return b = null;


        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:85:4: ( '[r' a= expr ',' '-' b= expr ']' )
        dbg.enterAlt(1);

        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/MappingDSL.g:85:4: '[r' a= expr ',' '-' b= expr ']'
        {
        dbg.location(85,4);
        match(input,57,FOLLOW_57_in_synpred59_MappingDSL872); if (state.failed) return ;
        dbg.location(85,10);
        pushFollow(FOLLOW_expr_in_synpred59_MappingDSL876);
        a=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(85,16);
        match(input,44,FOLLOW_44_in_synpred59_MappingDSL878); if (state.failed) return ;
        dbg.location(85,20);
        match(input,DASH,FOLLOW_DASH_in_synpred59_MappingDSL880); if (state.failed) return ;
        dbg.location(85,25);
        pushFollow(FOLLOW_expr_in_synpred59_MappingDSL884);
        b=expr();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(85,31);
        match(input,56,FOLLOW_56_in_synpred59_MappingDSL886); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_MappingDSL

    // Delegated rules

    public final boolean synpred56_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred56_MappingDSL_fragment(); // can never throw exception
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
    public final boolean synpred57_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred57_MappingDSL_fragment(); // can never throw exception
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
    public final boolean synpred53_MappingDSL() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred53_MappingDSL_fragment(); // can never throw exception
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
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA1_eotS =
        "\13\uffff";
    static final String DFA1_eofS =
        "\13\uffff";
    static final String DFA1_minS =
        "\1\25\12\uffff";
    static final String DFA1_maxS =
        "\1\71\12\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\1\1\10\uffff";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\uffff\1\2\2\uffff\1\2\2\uffff\1\2\12\uffff\1\1\1\uffff"+
            "\1\2\12\uffff\3\2\1\uffff\1\2",
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
            return "()* loopback of 30:36: ( contextBodyEl )*";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA2_eotS =
        "\12\uffff";
    static final String DFA2_eofS =
        "\12\uffff";
    static final String DFA2_minS =
        "\1\25\11\uffff";
    static final String DFA2_maxS =
        "\1\71\11\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA2_specialS =
        "\12\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\uffff\1\1\2\uffff\1\1\2\uffff\1\1\14\uffff\1\1\12\uffff"+
            "\1\10\1\11\1\1\1\uffff\1\1",
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

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "32:1: contextBodyEl : ( areaAction | proc | func );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA3_eotS =
        "\13\uffff";
    static final String DFA3_eofS =
        "\2\uffff\1\6\10\uffff";
    static final String DFA3_minS =
        "\1\25\1\uffff\1\34\10\uffff";
    static final String DFA3_maxS =
        "\1\34\1\uffff\1\55\10\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\5\1\3\1\4\4\uffff";
    static final String DFA3_specialS =
        "\13\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\1\3\1\4\4\uffff\1\1",
            "",
            "\1\1\12\uffff\1\6\2\uffff\1\5\1\6\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "40:1: action : ( image -> ^( IMAGE[$image.text] ) | COLOR | procCall | ID | STRING );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA10_eotS =
        "\21\uffff";
    static final String DFA10_eofS =
        "\6\uffff\1\11\12\uffff";
    static final String DFA10_minS =
        "\1\25\5\uffff\1\30\12\uffff";
    static final String DFA10_maxS =
        "\1\71\5\uffff\1\70\12\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\uffff\1\6\1\5\1\7\7\uffff";
    static final String DFA10_specialS =
        "\21\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\6\1\uffff\1\5\2\uffff\1\3\2\uffff\1\4\14\uffff\1\7\14\uffff"+
            "\1\1\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "\2\11\1\uffff\2\11\12\uffff\3\11\1\10\2\11\13\uffff\1\11",
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
            return "46:1: expr : ( coord ( ( DASH | PLUS ) expr )? | FLOAT ( ( DASH | PLUS | MULT | DIV ) expr )? | INT ( ( DASH | PLUS | MULT | DIV | OP ) expr )? | STRING ( PLUS expr )? | procCall ( ( DASH | PLUS ) expr )? | '(' expr ')' | ID ( ( DASH | PLUS | MULT | DIV ) expr )? );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA12_eotS =
        "\12\uffff";
    static final String DFA12_eofS =
        "\12\uffff";
    static final String DFA12_minS =
        "\1\25\11\uffff";
    static final String DFA12_maxS =
        "\1\71\11\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\uffff";
    static final String DFA12_specialS =
        "\12\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\1\uffff\1\1\2\uffff\1\1\2\uffff\1\1\14\uffff\1\1\2\10\12"+
            "\uffff\1\1\1\uffff\1\1",
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
            return "56:18: ( expr ( ',' expr )* )?";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA11_eotS =
        "\14\uffff";
    static final String DFA11_eofS =
        "\14\uffff";
    static final String DFA11_minS =
        "\1\53\1\25\5\uffff\2\0\3\uffff";
    static final String DFA11_maxS =
        "\1\54\1\71\5\uffff\2\0\3\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\1\10\uffff";
    static final String DFA11_specialS =
        "\7\uffff\1\0\1\1\3\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\1",
            "\1\10\1\2\1\7\2\uffff\1\3\1\uffff\1\2\1\3\14\uffff\1\3\14\uffff"+
            "\1\3\1\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
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
            return "()* loopback of 56:24: ( ',' expr )*";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_7 = input.LA(1);

                         
                        int index11_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_MappingDSL()) ) {s = 3;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index11_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_8 = input.LA(1);

                         
                        int index11_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_MappingDSL()) ) {s = 3;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index11_8);
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
    static final String DFA30_eotS =
        "\33\uffff";
    static final String DFA30_eofS =
        "\33\uffff";
    static final String DFA30_minS =
        "\1\67\2\25\20\0\10\uffff";
    static final String DFA30_maxS =
        "\3\71\20\0\10\uffff";
    static final String DFA30_acceptS =
        "\23\uffff\1\2\1\4\1\1\1\3\1\6\1\10\1\5\1\7";
    static final String DFA30_specialS =
        "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\10\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\uffff\1\2",
            "\1\11\1\uffff\1\10\1\3\1\uffff\1\6\2\uffff\1\7\14\uffff\1\12"+
            "\14\uffff\1\4\1\uffff\1\5",
            "\1\21\1\uffff\1\20\1\13\1\uffff\1\16\2\uffff\1\17\14\uffff"+
            "\1\22\14\uffff\1\14\1\uffff\1\15",
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
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "79:1: coord : ( '[' a= expr ',' b= expr ']' -> ^( COORD $a $b) | '[' '-' a= expr ',' b= expr ']' -> ^( COORD ^( NEG $a) $b) | '[' a= expr ',' '-' b= expr ']' -> ^( COORD $a ^( NEG $b) ) | '[' '-' a= expr ',' '-' b= expr ']' -> ^( COORD ^( NEG $a) ^( NEG $b) ) | '[r' a= expr ',' b= expr ']' -> ^( COORD RAW $a $b) | '[r' '-' a= expr ',' b= expr ']' -> ^( COORD RAW ^( NEG $a) $b) | '[r' a= expr ',' '-' b= expr ']' -> ^( COORD RAW $a ^( NEG $b) ) | '[r' '-' a= expr ',' '-' b= expr ']' -> ^( COORD RAW ^( NEG $a) ^( NEG $b) ) );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_MappingDSL()) ) {s = 19;}

                        else if ( (synpred56_MappingDSL()) ) {s = 20;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_MappingDSL()) ) {s = 21;}

                        else if ( (synpred55_MappingDSL()) ) {s = 22;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_MappingDSL()) ) {s = 21;}

                        else if ( (synpred55_MappingDSL()) ) {s = 22;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_MappingDSL()) ) {s = 21;}

                        else if ( (synpred55_MappingDSL()) ) {s = 22;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_MappingDSL()) ) {s = 21;}

                        else if ( (synpred55_MappingDSL()) ) {s = 22;}

                         
                        input.seek(index30_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_8 = input.LA(1);

                         
                        int index30_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_MappingDSL()) ) {s = 21;}

                        else if ( (synpred55_MappingDSL()) ) {s = 22;}

                         
                        input.seek(index30_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA30_9 = input.LA(1);

                         
                        int index30_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_MappingDSL()) ) {s = 21;}

                        else if ( (synpred55_MappingDSL()) ) {s = 22;}

                         
                        input.seek(index30_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA30_10 = input.LA(1);

                         
                        int index30_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_MappingDSL()) ) {s = 21;}

                        else if ( (synpred55_MappingDSL()) ) {s = 22;}

                         
                        input.seek(index30_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA30_11 = input.LA(1);

                         
                        int index30_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred58_MappingDSL()) ) {s = 23;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index30_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA30_12 = input.LA(1);

                         
                        int index30_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_MappingDSL()) ) {s = 25;}

                        else if ( (synpred59_MappingDSL()) ) {s = 26;}

                         
                        input.seek(index30_12);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA30_13 = input.LA(1);

                         
                        int index30_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_MappingDSL()) ) {s = 25;}

                        else if ( (synpred59_MappingDSL()) ) {s = 26;}

                         
                        input.seek(index30_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA30_14 = input.LA(1);

                         
                        int index30_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_MappingDSL()) ) {s = 25;}

                        else if ( (synpred59_MappingDSL()) ) {s = 26;}

                         
                        input.seek(index30_14);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA30_15 = input.LA(1);

                         
                        int index30_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_MappingDSL()) ) {s = 25;}

                        else if ( (synpred59_MappingDSL()) ) {s = 26;}

                         
                        input.seek(index30_15);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA30_16 = input.LA(1);

                         
                        int index30_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_MappingDSL()) ) {s = 25;}

                        else if ( (synpred59_MappingDSL()) ) {s = 26;}

                         
                        input.seek(index30_16);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA30_17 = input.LA(1);

                         
                        int index30_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_MappingDSL()) ) {s = 25;}

                        else if ( (synpred59_MappingDSL()) ) {s = 26;}

                         
                        input.seek(index30_17);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA30_18 = input.LA(1);

                         
                        int index30_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_MappingDSL()) ) {s = 25;}

                        else if ( (synpred59_MappingDSL()) ) {s = 26;}

                         
                        input.seek(index30_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ID_in_main91 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_main93 = new BitSet(new long[]{0x0001C00000000000L});
    public static final BitSet FOLLOW_coordinateSystem_in_main95 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_main97 = new BitSet(new long[]{0x02E0050024A00000L});
    public static final BitSet FOLLOW_contextBodyEl_in_main99 = new BitSet(new long[]{0x02E0050024A00000L});
    public static final BitSet FOLLOW_40_in_main102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_areaAction_in_contextBodyEl123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_proc_in_contextBodyEl128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_in_contextBodyEl133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_areaAction142 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_areaAction144 = new BitSet(new long[]{0x0000000010E00000L});
    public static final BitSet FOLLOW_action_in_areaAction146 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_areaAction148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_image_in_action167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_action179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_action184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_action189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_action194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coord_in_expr204 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_expr207 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_expr214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_expr221 = new BitSet(new long[]{0x000000001B000002L});
    public static final BitSet FOLLOW_set_in_expr224 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_expr235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_expr242 = new BitSet(new long[]{0x000000005B000002L});
    public static final BitSet FOLLOW_set_in_expr245 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_expr258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expr265 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PLUS_in_expr268 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_expr271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procCall_in_expr278 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_expr281 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_expr288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_expr296 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_expr298 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_expr300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr305 = new BitSet(new long[]{0x000000001B000002L});
    public static final BitSet FOLLOW_set_in_expr308 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_expr319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_procCall331 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_procCall333 = new BitSet(new long[]{0x02801C0024A00000L});
    public static final BitSet FOLLOW_expr_in_procCall336 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_procCall339 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_procCall341 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_procCall348 = new BitSet(new long[]{0x0000000010E00000L});
    public static final BitSet FOLLOW_action_in_procCall350 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_procCall354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_image377 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_image380 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_DIV_in_image383 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_image385 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_45_in_image389 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_image391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_coordinateSystem400 = new BitSet(new long[]{0x0280000000000000L});
    public static final BitSet FOLLOW_coord_in_coordinateSystem402 = new BitSet(new long[]{0x001E000000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem404 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_lines_in_coordinateSystem407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_coordinateSystem428 = new BitSet(new long[]{0x0280000000000000L});
    public static final BitSet FOLLOW_coord_in_coordinateSystem430 = new BitSet(new long[]{0x001E000000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem432 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_lines_in_coordinateSystem435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_coordinateSystem456 = new BitSet(new long[]{0x001E000000000002L});
    public static final BitSet FOLLOW_size_in_coordinateSystem458 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_lines_in_coordinateSystem461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_lines0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_size501 = new BitSet(new long[]{0x0280000000000000L});
    public static final BitSet FOLLOW_coord_in_size503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_size516 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_INT_in_size518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_proc534 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_proc538 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_proc540 = new BitSet(new long[]{0x0000080000200000L});
    public static final BitSet FOLLOW_ID_in_proc545 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_proc548 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_proc552 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_proc558 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_proc560 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_areaAction_in_proc565 = new BitSet(new long[]{0x0280050024A00000L});
    public static final BitSet FOLLOW_40_in_proc569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_func600 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_func604 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_func606 = new BitSet(new long[]{0x0000080000200000L});
    public static final BitSet FOLLOW_ID_in_func611 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_func614 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_func618 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_func624 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_func626 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_func628 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_39_in_func630 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_func633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_coord664 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord668 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord670 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord674 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_coord693 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord695 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord699 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord701 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord705 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_coord728 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord732 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord734 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord736 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord740 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_coord763 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord765 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord769 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord771 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord773 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord777 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_coord804 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord808 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord810 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord814 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_coord835 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord837 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord841 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord843 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord847 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_coord872 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord876 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord878 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord880 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord884 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_coord909 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord911 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord915 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_coord917 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_coord919 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_coord923 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coord925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred32_MappingDSL339 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred32_MappingDSL341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred53_MappingDSL664 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred53_MappingDSL668 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred53_MappingDSL670 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred53_MappingDSL674 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred53_MappingDSL676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred54_MappingDSL693 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_synpred54_MappingDSL695 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred54_MappingDSL699 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred54_MappingDSL701 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred54_MappingDSL705 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred54_MappingDSL707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred55_MappingDSL728 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred55_MappingDSL732 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred55_MappingDSL734 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_synpred55_MappingDSL736 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred55_MappingDSL740 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred55_MappingDSL742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred56_MappingDSL763 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_synpred56_MappingDSL765 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred56_MappingDSL769 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred56_MappingDSL771 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_synpred56_MappingDSL773 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred56_MappingDSL777 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred56_MappingDSL779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred57_MappingDSL804 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred57_MappingDSL808 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred57_MappingDSL810 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred57_MappingDSL814 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred57_MappingDSL816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred58_MappingDSL835 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_synpred58_MappingDSL837 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred58_MappingDSL841 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred58_MappingDSL843 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred58_MappingDSL847 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred58_MappingDSL849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred59_MappingDSL872 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred59_MappingDSL876 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred59_MappingDSL878 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DASH_in_synpred59_MappingDSL880 = new BitSet(new long[]{0x0280040024A00000L});
    public static final BitSet FOLLOW_expr_in_synpred59_MappingDSL884 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred59_MappingDSL886 = new BitSet(new long[]{0x0000000000000002L});

}