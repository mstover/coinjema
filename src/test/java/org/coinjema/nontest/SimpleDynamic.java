package org.coinjema.nontest;

import org.coinjema.context.CjmContext;
import org.coinjema.context.CjmDynamic;
import org.coinjema.context.Cjm;

import java.util.Properties;

public class SimpleDynamic {

    public SimpleDynamic() {
        super();
    }

    public SimpleDynamic(CjmContext cc) {

    }

    @CjmDynamic(alias = "static_dynamic.name")
    public static String getDynName() {
        return (String) Cjm.dynamicGetter(null, SimpleDynamic.class, "getDynName");
    }

    @CjmDynamic(method = "simpleProps", type = "Properties")
    public Properties getProperties() {
        return (Properties) Cjm.dynamicGetter(this, getClass(), "getProperties");
    }

}
