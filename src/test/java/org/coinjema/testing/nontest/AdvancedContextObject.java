package org.coinjema.testing.nontest;

import org.coinjema.cjm.*;

import java.util.Properties;


@CjmObject(type = "AService")
public class AdvancedContextObject extends AbstractContextOriented {

    Properties props;
    PersistentConfig session;

    public AdvancedContextObject() {
        Cjm.contextualize(this);
    }

    public AdvancedContextObject(String context) {
        this(new CjmContext(context));
        System.out.println(((ContextOriented) this).getCoinjemaContext());
    }

    public AdvancedContextObject(CjmContext c) {
        super(c);
        Cjm.contextualize(this, c);
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
        return ContextFactory.withContext(getCoinjemaContext(),() -> new SimpleDynamic().getProperties());
    }

    public String getStaticDynamicName() {
        return new SimpleDynamic().getDynName();
    }

}
