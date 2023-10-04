package org.coinjema.testing.nontest;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.CjmDependency;

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
