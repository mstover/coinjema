package org.coinjema.nontest;

import org.coinjema.context.CjmContext;
import org.coinjema.context.DependencyDefinition;
import org.coinjema.context.Cjm;

import java.util.Properties;

public class InheritingObject {

    private final Properties props;

    public InheritingObject() {
        this.props = Cjm.getDep(new DependencyDefinition<>(this, Properties.class, "config", null));
    }

    public InheritingObject(CjmContext cc) {
        this.props = Cjm.getDep(new DependencyDefinition<>(this, Properties.class, "config", null),cc);
    }

    public Properties getProps() {
        return props;
    }
}
