package org.coinjema.nontest;

import org.coinjema.context.CoinjemaDynamic;
import org.coinjema.context.Recipe;

public class StaticDynamic {

    static String name = getDynName();

    public StaticDynamic() {
        super();
        // TODO Auto-generated constructor stub
    }

    @CoinjemaDynamic(alias = "static_dynamic.name")
    public static String getDynName() {
        return (String) Recipe.dynamicGetter(null, StaticDynamic.class, "getDynName");
    }

    public String getName() {
        return name;
    }

}
