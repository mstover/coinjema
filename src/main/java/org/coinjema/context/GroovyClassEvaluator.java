package org.coinjema.context;


import groovy.lang.GroovyClassLoader;
import org.coinjema.context.eval.Evaluator;
import org.coinjema.context.source.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

class GroovyClassEvaluator implements Evaluator {

    public Object evaluate(Resource source, Map params) {
        Reader scriptBytes = new InputStreamReader(source.getInputStream());
        GroovyClassLoader loader = new GroovyClassLoader(Thread.currentThread()
                .getContextClassLoader());
        try {
            return loader.parseClass(scriptBytes, source.getName()).getDeclaredConstructor().newInstance();
        } catch (Throwable e) {
            throw new DependencyInjectionException(
                    "Couldn't evaluate groovy class: " + source + ".groovyClass", e);
        } finally {
            try {
                scriptBytes.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to close config file: " + source, e);
            }
        }
    }

}
