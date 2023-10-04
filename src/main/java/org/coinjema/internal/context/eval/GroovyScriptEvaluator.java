package org.coinjema.internal.context.eval;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.coinjema.cjm.Cjm;
import org.coinjema.cjm.ContextOriented;
import org.coinjema.cjm.DependencyInjectionException;
import org.coinjema.cjm.source.Resource;

import java.io.Reader;
import java.util.Map;
import java.util.logging.Level;

import static org.coinjema.logging.CoinjemaLogger.log;

public class GroovyScriptEvaluator implements Evaluator {

    public Object evaluate(final Resource source, final Map params) {
        try (Reader scriptBytes = source.getReader()) {
            if (scriptBytes != null) {
                Binding vars = new Binding(params);
                GroovyShell shell = new GroovyShell(vars);
                Object evaluate = shell.evaluate(scriptBytes);
                if (evaluate instanceof ContextOriented && ((ContextOriented) evaluate).getCoinjemaContext() == null) {
                    Cjm.contextualize((ContextOriented) evaluate);
                }
                return evaluate;
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Couldn't evaluate script: " + source, e);
            throw new DependencyInjectionException(
                    "Couldn't evaluate script: " + source, e);
        }
        return null;
    }

}
