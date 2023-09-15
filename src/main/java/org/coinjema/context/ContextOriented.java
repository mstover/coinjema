package org.coinjema.context;

public interface ContextOriented {
    
    CoinjemaContext getCoinjemaContext();
    
    void setCoinjemaContext(CoinjemaContext context);
    
    boolean isGiven();
    
    void setGiven(boolean g);

}
