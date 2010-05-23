package org.coinjema.grammar;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeNodeStream;

public class __Test__ {

	public static void main(String args[]) throws Exception {
		ConfigDSLLexer lex = new ConfigDSLLexer(
				new ANTLRFileStream(
						"/home/michael/DevelopmentEnvironment/workspace/coinjema/grammar/output/org/coinjema/grammar/__Test___input.txt",
						"UTF8"));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		ConfigDSLParser g = new ConfigDSLParser(tokens);
		try {
			Object tree = g.main().getTree();
			System.out.println("tree = " + tree.getClass());
			TreeNodeStream treeStream = new CommonTreeNodeStream(tree);
			ConfigDSLTree treeParser = new ConfigDSLTree(treeStream,
					"TestInput", g.usesFile);
			treeParser.main();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
}