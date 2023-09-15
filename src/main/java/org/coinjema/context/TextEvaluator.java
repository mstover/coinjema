package org.coinjema.context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.coinjema.context.eval.Evaluator;
import org.coinjema.context.source.Resource;

class TextEvaluator implements Evaluator {

    public TextEvaluator() {
        super();
    }

    public Object evaluate(Resource source, Map params) {
        InputStream stream = source.getInputStream();
        if(stream == null) return null;
        BufferedReader scriptBytes = new BufferedReader(new InputStreamReader(stream));
        try {
            StringBuffer buf = new StringBuffer();
            char[] charBuf = new char[512];
            int charsRead = -1;
            while ((charsRead = scriptBytes.read(charBuf)) > -1) {
                buf.append(charBuf, 0, charsRead);
            }
            return buf.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to close config file: " + source +".txt",e);
            }
        }
    }

}
