package org.coinjema.context;

public class TempCoinjemaContext implements AutoCloseable{
    private final CoinjemaContext context;

    public TempCoinjemaContext(CoinjemaContext coinjemaContext) {
        this.context = coinjemaContext;
    }

    @Override
    public void close() {
        ContextFactory.popContext();
    }
}
