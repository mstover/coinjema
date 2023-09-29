package org.coinjema.nontest;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDynamic;
import org.coinjema.context.Recipe;

import java.util.Properties;

public class SimpleDynamic {

    public SimpleDynamic() {
        super();
    }

    public SimpleDynamic(CoinjemaContext cc) {

    }

    @CoinjemaDynamic(alias = "static_dynamic.name")
    public static String getDynName() {
        return (String) Recipe.dynamicGetter(null, SimpleDynamic.class, "getDynName");
    }

    @CoinjemaDynamic(method = "simpleProps", type = "Properties")
    public Properties getProperties() {
        return (Properties) Recipe.dynamicGetter(this, getClass(), "getProperties");
    }

}
