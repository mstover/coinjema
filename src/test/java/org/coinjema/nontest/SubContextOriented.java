package org.coinjema.nontest;

import org.coinjema.context.CjmContext;
import org.coinjema.context.CjmDependency;

public class SubContextOriented extends BasicContextOriented {
    int countInjections;

    public SubContextOriented() {
        super();
        paths=new String[]{"wrong_path1","wrong_path2"};
    }

    public SubContextOriented(CjmContext context) {
        super(context);
    }

    public SubContextOriented(String init, CjmContext context) {
        super(init, context);
    }
    
    @CjmDependency(method="string")
    public void setDummyDep(String d)
    {
        countInjections++;
    }
    
    public int getNumInjections()
    {
        return countInjections;
    }

}
