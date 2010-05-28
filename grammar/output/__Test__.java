import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        MappingDSLLexer lex = new MappingDSLLexer(new ANTLRFileStream("/Users/michaelstover/Documents/workspace/coinjema/grammar/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        MappingDSLParser g = new MappingDSLParser(tokens, 49100, null);
        try {
            g.main();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}