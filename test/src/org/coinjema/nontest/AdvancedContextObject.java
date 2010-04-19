package org.coinjema.nontest;

import java.util.Properties;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;
import org.coinjema.context.ContextOriented;


@CoinjemaObject(type="AService")
public class AdvancedContextObject {
    
    Properties props;
    PersistentConfig session;

    public AdvancedContextObject() {
    }
    
    public AdvancedContextObject(String context)
    {
    	this(new CoinjemaContext(context));
    	System.out.println(((ContextOriented)this).getCoinjemaContext());
    }
    
    public AdvancedContextObject(CoinjemaContext c)
    {
        
    }
    
    @CoinjemaDependency(method="config")
    public void setServiceProperties(Properties p)
    {
        props = p;
    }
    
    public String getProperty(String name)
    {
        return props.getProperty(name);
    }
    
    @CoinjemaDependency(type="sessionStore")
    public void setPersistentSession(PersistentConfig config)
    {
        this.session = config;
    }

    /**
     * @return Returns the session.
     */
    public PersistentConfig getSession() {
        return session;
    }
    
    
    public Properties getDynamicProperties()
    {
    	return new SimpleDynamic().getProperties();    	
    }
    
    public String getStaticDynamicName()
    {
    	return new SimpleDynamic().getDynName();
    }

}
