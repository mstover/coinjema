package org.coinjema.internal.context.eval;

import org.coinjema.cjm.DependencyInjectionException;
import org.coinjema.cjm.Evaluator;
import org.coinjema.internal.context.InternalCjm;
import org.coinjema.internal.context.RackLoop;
import org.coinjema.internal.context.SpiceRack;
import org.coinjema.internal.context.names.SimpleStringResolver;
import org.coinjema.cjm.source.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class ComponentMapEvaluator implements Evaluator {

    public Object evaluate(Resource source, Map<String,Object> params)
    {
        InputStream scriptBytes = source.getInputStream();
        if(scriptBytes == null) return null;
        Properties props = new Properties();
        Map<String,Object> components = new HashMap<>();
        try {
            props.load(scriptBytes);
            SpiceRack master = (SpiceRack)params.get("registry");
    		final Map<String,Object> tempParams = new HashMap<>();
    		tempParams.putAll(params);
            
            for(Object name : props.keySet())
            {
        		final SimpleStringResolver resolver = new SimpleStringResolver(props.getProperty((String)name));
                Object component = RackLoop.loop(master, rack -> InternalCjm.captureDep(tempParams, resolver, rack));
                components.put((String)name,component);
            }
        } catch (IOException e) {
            throw new DependencyInjectionException(
                    "Couldn't evaluate script: " + source + ".compmap", e);
        } finally
        {
            try {
                scriptBytes.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to close config file: " + source,e);
            }
        }
        components = Collections.unmodifiableMap(components);
        return components;
    }

}
