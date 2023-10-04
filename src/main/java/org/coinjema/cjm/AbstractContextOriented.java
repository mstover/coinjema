package org.coinjema.cjm;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextOriented;

public class AbstractContextOriented implements ContextOriented {
    private CjmContext context;
    private boolean given;

    public AbstractContextOriented(CjmContext context) {
        this.context = context;
        this.given = true;
    }

    public AbstractContextOriented() {
    }

    @Override
    public CjmContext getCoinjemaContext() {
        return context;
    }

    @Override
    public void setCoinjemaContext(CjmContext context) {
        this.context = context;
    }

    @Override
    public boolean isGiven() {
        return given;
    }

    @Override
    public void setGiven(boolean g) {
        given = g;
    }
}
