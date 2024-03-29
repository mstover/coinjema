package org.coinjema.testing.nontest.noaspect;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.CjmDependency;
import org.coinjema.cjm.ContextOriented;
import org.coinjema.cjm.Cjm;
import org.coinjema.testing.nontest.PersistentConfig;
import org.coinjema.testing.nontest.SimpleDynamic;

import java.util.Properties;

public class AdvancedContextObject implements ContextOriented {

    private Properties props = null;
    PersistentConfig session;
    private CjmContext context;
    private boolean given;

    public AdvancedContextObject() {
        Cjm.contextualize(this);
    }

    public AdvancedContextObject(String context) {
        this(new CjmContext(context));
    }

    public AdvancedContextObject(CjmContext c) {
        Cjm.contextualize(this, c);
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
    public void setGiven(boolean given) {
        this.given = given;
    }

    @CjmDependency(method = "config")
    public void setServiceProperties(Properties p) {
        props = p;
    }

    public String getProperty(String name) {
        return props.getProperty(name);
    }

    @CjmDependency(type = "sessionStore")
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
