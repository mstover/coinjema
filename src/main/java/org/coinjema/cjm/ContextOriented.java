package org.coinjema.cjm;

public interface ContextOriented {
    
    CjmContext getCoinjemaContext();
    
    void setCoinjemaContext(CjmContext context);
    
    boolean isGiven();
    
    void setGiven(boolean g);

}
