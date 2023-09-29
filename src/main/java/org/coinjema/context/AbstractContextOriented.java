package org.coinjema.context;

public class AbstractContextOriented implements ContextOriented {
    private CoinjemaContext context;
    private boolean given;

    public AbstractContextOriented(CoinjemaContext context) {
        this.context = context;
        this.given = true;
    }

    public AbstractContextOriented() {
    }

    @Override
    public CoinjemaContext getCoinjemaContext() {
        return context;
    }

    @Override
    public void setCoinjemaContext(CoinjemaContext context) {
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
