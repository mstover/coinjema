package org.coinjema.testing.nontest;

import org.coinjema.cjm.CjmDynamic;
import org.coinjema.cjm.Cjm;

public class StaticDynamic {

    static String name = getDynName();

    public StaticDynamic() {
        super();
        // TODO Auto-generated constructor stub
    }

    @CjmDynamic(alias = "static_dynamic.name")
    public static String getDynName() {
        return (String) Cjm.dynamicGetter(null, StaticDynamic.class, "getDynName");
    }

    public String getName() {
        return name;
    }

}
