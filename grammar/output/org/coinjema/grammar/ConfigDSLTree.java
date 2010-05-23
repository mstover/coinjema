// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g 2010-05-22 22:30:43

    package org.coinjema.grammar;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConfigDSLTree extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING_PROP", "INT_PROP", "TREE_PROP", "PROPERTY", "PROP_NAME", "FLOAT_TYPE", "FILE_TYPE", "TEXT", "PACKAGE", "ID", "OPEN_TREE", "CLOSE_TREE", "COLON", "INTTYPE", "EQ", "INT", "FLOATTYPE", "FLOAT", "FILETYPE", "STRINGTYPE", "FILE_SEP", "NEWLINE", "UNICODE_ESC", "OCTAL_ESC", "ESC_SEQ", "EXPONENT", "COMMENT", "WS", "STRING", "CHAR", "HEX_DIGIT", "OTHER", "'package'"
    };
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

    // delegates
    // delegators


        public ConfigDSLTree(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ConfigDSLTree(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ConfigDSLTree.tokenNames; }
    public String getGrammarFileName() { return "/home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g"; }


    	String classname = "Config";
    	boolean importsFile;
    	StringBuilder src = new StringBuilder();
    	public ConfigDSLTree(TreeNodeStream input,String classname,boolean importsFile) {	
    	            this(input, new RecognizerSharedState());
    	            this.classname = classname;
    	            this.importsFile = importsFile;
    	}
    	
    	public String makeClassName(String n) {
    		if(n.length() > 1) {
    		return n.substring(0,1).toUpperCase() + n.substring(1);
    		} else return n.toUpperCase();
    	}
    	
    	public String fixString(String s) {
    		return s.replaceAll("\\W*\\\\\\n\\W*"," ");
    	}



    // $ANTLR start "main"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:33:1: main : ( pckg )? ( config_tree )* ;
    public final void main() throws RecognitionException {
        String config_tree1 = null;



        	StringBuilder constructor = new StringBuilder();

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:35:3: ( ( pckg )? ( config_tree )* )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:35:5: ( pckg )? ( config_tree )*
            {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:35:5: ( pckg )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PACKAGE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:35:5: pckg
                    {
                    pushFollow(FOLLOW_pckg_in_main51);
                    pckg();

                    state._fsp--;


                    }
                    break;

            }


            		     if(importsFile) { src.append("import java.io.File;\n");}
            		     src.append("public class " + classname + " {\n");		     
            		     	 constructor.append("private " + classname + "(Reader r) {\n");
            		
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:41:3: ( config_tree )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=STRING_PROP && LA2_0<=TREE_PROP)||(LA2_0>=FLOAT_TYPE && LA2_0<=FILE_TYPE)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:41:4: config_tree
            	    {
            	    pushFollow(FOLLOW_config_tree_in_main63);
            	    config_tree1=config_tree();

            	    state._fsp--;

            	    constructor.append(config_tree1);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            			constructor.append("}\n");
            			src.append(constructor.toString());
            			src.append("\n}\n");
            			System.out.println(src.toString());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "main"


    // $ANTLR start "pckg"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:47:1: pckg : ^( PACKAGE ID ) ;
    public final void pckg() throws RecognitionException {
        CommonTree ID2=null;

        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:47:6: ( ^( PACKAGE ID ) )
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:47:8: ^( PACKAGE ID )
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_pckg78); 

            match(input, Token.DOWN, null); 
            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_pckg80); 

            match(input, Token.UP, null); 
            src.append("package "+(ID2!=null?ID2.getText():null) +";\n");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pckg"


    // $ANTLR start "config_tree"
    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:49:1: config_tree returns [String value] : ( ^( TREE_PROP (a= config_tree )* ) | ^( INT_PROP INT ) | ^( FLOAT_TYPE FLOAT ) | ^( FILE_TYPE TEXT ) | ^( STRING_PROP TEXT ) );
    public final String config_tree() throws RecognitionException {
        String value = null;

        CommonTree TREE_PROP3=null;
        CommonTree INT_PROP4=null;
        CommonTree INT5=null;
        CommonTree FLOAT_TYPE6=null;
        CommonTree FLOAT7=null;
        CommonTree FILE_TYPE8=null;
        CommonTree STRING_PROP9=null;
        String a = null;



        		StringBuilder constructor = new StringBuilder();
        	
        try {
            // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:56:2: ( ^( TREE_PROP (a= config_tree )* ) | ^( INT_PROP INT ) | ^( FLOAT_TYPE FLOAT ) | ^( FILE_TYPE TEXT ) | ^( STRING_PROP TEXT ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case TREE_PROP:
                {
                alt4=1;
                }
                break;
            case INT_PROP:
                {
                alt4=2;
                }
                break;
            case FLOAT_TYPE:
                {
                alt4=3;
                }
                break;
            case FILE_TYPE:
                {
                alt4=4;
                }
                break;
            case STRING_PROP:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:56:7: ^( TREE_PROP (a= config_tree )* )
                    {
                    TREE_PROP3=(CommonTree)match(input,TREE_PROP,FOLLOW_TREE_PROP_in_config_tree112); 

                    constructor.append((TREE_PROP3!=null?TREE_PROP3.getText():null) + " = new " + makeClassName((TREE_PROP3!=null?TREE_PROP3.getText():null))+"Class();\n");
                    			StringBuilder inner = new StringBuilder("public "+makeClassName((TREE_PROP3!=null?TREE_PROP3.getText():null))+"Class() { \n");
                    	 			src.append("public final " + makeClassName((TREE_PROP3!=null?TREE_PROP3.getText():null)) + "Class "+TREE_PROP3+";\n");
                    			src.append("public class " + makeClassName((TREE_PROP3!=null?TREE_PROP3.getText():null)) +"Class {\n");

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:60:4: (a= config_tree )*
                        loop3:
                        do {
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( ((LA3_0>=STRING_PROP && LA3_0<=TREE_PROP)||(LA3_0>=FLOAT_TYPE && LA3_0<=FILE_TYPE)) ) {
                                alt3=1;
                            }


                            switch (alt3) {
                        	case 1 :
                        	    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:60:5: a= config_tree
                        	    {
                        	    pushFollow(FOLLOW_config_tree_in_config_tree123);
                        	    a=config_tree();

                        	    state._fsp--;

                        	    inner.append(a).append("\n");

                        	    }
                        	    break;

                        	default :
                        	    break loop3;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }

                    	                	inner.append("}\n");
                    	                	src.append(inner.toString());
                    	                	src.append("}\n");
                    	                

                    }
                    break;
                case 2 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:66:4: ^( INT_PROP INT )
                    {
                    INT_PROP4=(CommonTree)match(input,INT_PROP,FOLLOW_INT_PROP_in_config_tree155); 

                    match(input, Token.DOWN, null); 
                    INT5=(CommonTree)match(input,INT,FOLLOW_INT_in_config_tree157); 

                    match(input, Token.UP, null); 

                    			src.append("public final int " + (INT_PROP4!=null?INT_PROP4.getText():null)+";\n");
                    			constructor.append((INT_PROP4!=null?INT_PROP4.getText():null) + " = " + (INT5!=null?INT5.getText():null) +";\n");
                    			

                    }
                    break;
                case 3 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:70:4: ^( FLOAT_TYPE FLOAT )
                    {
                    FLOAT_TYPE6=(CommonTree)match(input,FLOAT_TYPE,FOLLOW_FLOAT_TYPE_in_config_tree166); 

                    match(input, Token.DOWN, null); 
                    FLOAT7=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_config_tree168); 

                    match(input, Token.UP, null); 
                    src.append("public final double " + (FLOAT_TYPE6!=null?FLOAT_TYPE6.getText():null) + ";\n");
                    				constructor.append((FLOAT_TYPE6!=null?FLOAT_TYPE6.getText():null) + " = " + (FLOAT7!=null?FLOAT7.getText():null) +";\n");
                    			

                    }
                    break;
                case 4 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:73:4: ^( FILE_TYPE TEXT )
                    {
                    FILE_TYPE8=(CommonTree)match(input,FILE_TYPE,FOLLOW_FILE_TYPE_in_config_tree177); 

                    match(input, Token.DOWN, null); 
                    match(input,TEXT,FOLLOW_TEXT_in_config_tree179); 

                    match(input, Token.UP, null); 
                    src.append("public final File " + (FILE_TYPE8!=null?FILE_TYPE8.getText():null) + ";\n");
                    					constructor.append((FILE_TYPE8!=null?FILE_TYPE8.getText():null) + " = new File(\"/\");\n");
                    			

                    }
                    break;
                case 5 :
                    // /home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/ConfigDSLTree.g:76:4: ^( STRING_PROP TEXT )
                    {
                    STRING_PROP9=(CommonTree)match(input,STRING_PROP,FOLLOW_STRING_PROP_in_config_tree188); 

                    match(input, Token.DOWN, null); 
                    match(input,TEXT,FOLLOW_TEXT_in_config_tree190); 

                    match(input, Token.UP, null); 
                    src.append("public final String " + (STRING_PROP9!=null?STRING_PROP9.getText():null) + ";\n");
                    						constructor.append((STRING_PROP9!=null?STRING_PROP9.getText():null) + " = null;\n");
                    			

                    }
                    break;

            }

            		value =constructor.toString();
            	
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "config_tree"

    // Delegated rules


 

    public static final BitSet FOLLOW_pckg_in_main51 = new BitSet(new long[]{0x0000000000000672L});
    public static final BitSet FOLLOW_config_tree_in_main63 = new BitSet(new long[]{0x0000000000000672L});
    public static final BitSet FOLLOW_PACKAGE_in_pckg78 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_pckg80 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_PROP_in_config_tree112 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_config_tree_in_config_tree123 = new BitSet(new long[]{0x0000000000000678L});
    public static final BitSet FOLLOW_INT_PROP_in_config_tree155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_config_tree157 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FLOAT_TYPE_in_config_tree166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FLOAT_in_config_tree168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILE_TYPE_in_config_tree177 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TEXT_in_config_tree179 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_PROP_in_config_tree188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TEXT_in_config_tree190 = new BitSet(new long[]{0x0000000000000008L});

}