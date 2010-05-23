tree grammar ConfigDSLTree;

options {
    tokenVocab=ConfigDSL;
   ASTLabelType=CommonTree;
}

@header {
    package org.coinjema.grammar;
}

@members {
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
}

main	@init {
	StringBuilder constructor = new StringBuilder();
}	:	pckg? 
		{
		     if(importsFile) { src.append("import java.io.File;\n");}
		     src.append("public class " + classname + " {\n");		     
		     	 constructor.append("private " + classname + "(Reader r) {\n");
		} 
		(config_tree {constructor.append($config_tree.value);})* {
			constructor.append("}\n");
			src.append(constructor.toString());
			src.append("\n}\n");
			System.out.println(src.toString());};

pckg	:	^(PACKAGE ID) {src.append("package "+$ID.text +";\n");};

config_tree returns [String value]
	@init {
		StringBuilder constructor = new StringBuilder();
	}
	@after {
		$value =constructor.toString();
	}
	:	   ^(TREE_PROP {constructor.append($TREE_PROP.text + " = new " + makeClassName($TREE_PROP.text)+"Class();\n");
			StringBuilder inner = new StringBuilder("public "+makeClassName($TREE_PROP.text)+"Class() { \n");
	 			src.append("public final " + makeClassName($TREE_PROP.text) + "Class "+$TREE_PROP+";\n");
			src.append("public class " + makeClassName($TREE_PROP.text) +"Class {\n");} 
			(a=config_tree {inner.append($a.value).append("\n");})*) 
	                	{
	                	inner.append("}\n");
	                	src.append(inner.toString());
	                	src.append("}\n");
	                }
	|	^(INT_PROP INT) {
			src.append("public final int " + $INT_PROP.text+";\n");
			constructor.append($INT_PROP.text + " = " + $INT.text +";\n");
			}
	|	^(FLOAT_TYPE FLOAT) {src.append("public final double " + $FLOAT_TYPE.text + ";\n");
				constructor.append($FLOAT_TYPE.text + " = " + $FLOAT.text +";\n");
			}
	|	^(FILE_TYPE TEXT ){src.append("public final File " + $FILE_TYPE.text + ";\n");
					constructor.append($FILE_TYPE.text + " = new File(\"/\");\n");
			}
	|	^(STRING_PROP TEXT) {src.append("public final String " + $STRING_PROP.text + ";\n");
						constructor.append($STRING_PROP.text + " = null;\n");
			}
	;