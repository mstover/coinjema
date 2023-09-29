package org.coinjema.nontest;

import org.coinjema.context.AbstractContextOriented;
import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.DependencyDefinition;
import org.coinjema.context.Recipe;

import java.util.Properties;

public class InheritingObject {

    private final Properties props;

    public InheritingObject() {
        this.props = Recipe.getDep(new DependencyDefinition<>(this, Properties.class, "config", null));
    }

    public InheritingObject(CoinjemaContext cc) {
        this.props = Recipe.getDep(new DependencyDefinition<>(this, Properties.class, "config", null),cc);
    }

    public Properties getProps() {
        return props;
    }
}
