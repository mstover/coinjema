package org.coinjema.context;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.coinjema.context.eval.Evaluator;
import org.coinjema.context.source.Resource;

class JavaEvaluator implements Evaluator {

    public JavaEvaluator() {
        super();
    }

    public Object evaluate(Resource source, Map params) {
        InputStream stream = source.getInputStream();
        if(stream == null) return null;
        ObjectInputStream objectStream = null;
        try { 
            objectStream = new ObjectInputStream(stream);
            return objectStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }  finally {
            try {
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to close config file: " + source+".txt",e);
            }
        }
    }

}
