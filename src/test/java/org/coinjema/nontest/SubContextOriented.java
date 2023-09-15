package org.coinjema.nontest;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;

public class SubContextOriented extends BasicContextOriented {
    int countInjections;

    public SubContextOriented() {
        super();
        paths=new String[]{"wrong_path1","wrong_path2"};
    }

    public SubContextOriented(CoinjemaContext context) {
        super(context);
    }

    public SubContextOriented(String init, CoinjemaContext context) {
        super(init, context);
    }
    
    @CoinjemaDependency(method="string")
    public void setDummyDep(String d)
    {
        countInjections++;
    }
    
    public int getNumInjections()
    {
        return countInjections;
    }

}
