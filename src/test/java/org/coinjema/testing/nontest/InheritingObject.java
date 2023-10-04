package org.coinjema.testing.nontest;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.DependencyDefinition;
import org.coinjema.cjm.Cjm;

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
