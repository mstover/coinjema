package org.coinjema.nontest;

import org.coinjema.context.*;

import java.util.Properties;


@CoinjemaObject(type = "AService")
public class AdvancedContextObject extends AbstractContextOriented {

    Properties props;
    PersistentConfig session;

    public AdvancedContextObject() {
        Recipe.contextualize(this);
    }

    public AdvancedContextObject(String context) {
        this(new CoinjemaContext(context));
        System.out.println(((ContextOriented) this).getCoinjemaContext());
    }

    public AdvancedContextObject(CoinjemaContext c) {
        super(c);
        Recipe.contextualize(this, c);
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
        return ContextFactory.withContext(getCoinjemaContext(),() -> new SimpleDynamic().getProperties());
    }

    public String getStaticDynamicName() {
        return new SimpleDynamic().getDynName();
    }

}
