package org.coinjema.context;

public interface ContextOriented {
    
    CjmContext getCoinjemaContext();
    
    void setCoinjemaContext(CjmContext context);
    
    boolean isGiven();
    
    void setGiven(boolean g);

}
