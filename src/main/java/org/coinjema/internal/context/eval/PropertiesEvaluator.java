package org.coinjema.internal.context.eval;


import org.coinjema.cjm.DependencyInjectionException;
import org.coinjema.cjm.Evaluator;
import org.coinjema.internal.context.InternalCjm;
import org.coinjema.internal.context.RackLoop;
import org.coinjema.internal.context.SpiceRack;
import org.coinjema.internal.context.names.SimpleStringResolver;
import org.coinjema.cjm.source.MetaType;
import org.coinjema.cjm.source.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class PropertiesEvaluator implements Evaluator {

    public Object evaluate(Resource source, Map<String, Object> params) {
        Properties props = new Properties();
        if (source.getMetaTypes().contains(MetaType.inherit)) {
            Properties parentProps = getParentProperties(source, params);
            props.putAll(parentProps);
        }
        try (InputStream scriptBytes = source.getInputStream()) {
            Properties tempLoad = new Properties();
            tempLoad.load(scriptBytes);
            props.putAll(tempLoad);
        } catch (IOException e) {
            throw new DependencyInjectionException(
                    "Couldn't evaluate script: " + source, e);
        }
        return processProps(props, params);
    }

    protected Properties processProps(Properties props, Map<String, Object> params) {
        return props;
    }

    protected Properties getParentProperties(final Resource res, final Map params) {
        SpiceRack parent = ((SpiceRack) params.get("registry")).getParent();
        final Map<String, Object> tempParams = new HashMap<>();
        tempParams.putAll(params);
        final SimpleStringResolver resolver = new SimpleStringResolver(res.getName());
        Object props = RackLoop.loop(parent, rack -> InternalCjm.getContextualizer().captureDep(tempParams, resolver, rack)).dep;
        if (props instanceof Properties) return (Properties) props;
        else return new Properties();
    }
}
