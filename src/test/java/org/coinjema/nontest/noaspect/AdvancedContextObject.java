package org.coinjema.nontest.noaspect;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.ContextOriented;
import org.coinjema.context.Recipe;
import org.coinjema.nontest.PersistentConfig;
import org.coinjema.nontest.SimpleDynamic;

import java.util.Properties;

public class AdvancedContextObject implements ContextOriented {

    private Properties props = null;
    PersistentConfig session;
    private CoinjemaContext context;
    private boolean given;

    public AdvancedContextObject() {
        Recipe.contextualize(this);
    }

    public AdvancedContextObject(String context) {
        this(new CoinjemaContext(context));
        System.out.println(((ContextOriented) this).getCoinjemaContext());
    }

    public AdvancedContextObject(CoinjemaContext c) {
        Recipe.contextualize(this, c);
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
    public void setGiven(boolean given) {
        this.given = given;
    }

    @CoinjemaDependency(method = "config")
    public void setServiceProperties(Properties p) {
        props = p;
    }

    public String getProperty(String name) {
        return props.getProperty(name);
    }

    @CoinjemaDependency(type = "sessionStore")
    public void setPersistentSession(PersistentConfig config) {
        this.session = config;
    }

    /**
     * @return Returns the session.
     */
    public PersistentConfig getSession() {
        return session;
    }


    public Properties getDynamicProperties() {
        return new SimpleDynamic().getProperties();
    }

    public String getStaticDynamicName() {
        return new SimpleDynamic().getDynName();
    }

}
