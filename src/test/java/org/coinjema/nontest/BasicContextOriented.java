package org.coinjema.nontest;

import org.coinjema.context.*;
import org.coinjema.context.CoinjemaDependency.Order;

import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

public class BasicContextOriented extends AbstractContextOriented {
    protected String[] paths;
    Logger log;
    MockSingleton myService;
    MockSingleton myOtherService, redirectedService;
    Properties props;
    String init;
    URL home;
    SimpleContextOriented simple;

    public BasicContextOriented() {
        Recipe.contextualize(this);
    }

    public BasicContextOriented(CoinjemaContext context) {
        Recipe.contextualize(this, context);
    }

    public BasicContextOriented(String init, CoinjemaContext context) {
        this.init = init;
        Recipe.contextualize(this, context);
    }

    @CoinjemaDependency(alias = "log4j")
    public void setLogger(Logger log) {
        this.log = log;
    }

    public Properties getConfig() {
        return props;
    }

    @CoinjemaDependency(method = "config")
    public void setConfig(Properties p) {
        props = p;
    }

    public String getProp(String key) {
        return props.getProperty(key);
    }

    public String getDynamicProperty(String key) {

        try (TempCoinjemaContext tcc = ContextFactory.pushContext(this)) {
            return getMyService().getProperty(key);
        }
    }

    @CoinjemaDependency
    public void setService(MockSingleton myService) {
        this.myService = myService;
    }

    @CoinjemaDependency(type = "AnnotatedMock")
    public void setOtherService(MockSingleton myOtherService) {
        this.myOtherService = myOtherService;
    }

    public MockSingleton getRedirectedService() {
        return redirectedService;
    }

    @CoinjemaDependency(method = "redirectionMock")
    public void setRedirectedService(MockSingleton redirected) {
        this.redirectedService = redirected;
    }

    public String getMyMainValue() {
        return myService.getMainValue();
    }

    public String getMyOtherMainValue() {
        return myOtherService.getMainValue();
    }

    public String[] getPaths() {
        return paths;
    }

    @CoinjemaDependency
    public void setPaths(String[] paths) {
        this.paths = paths;
    }

    public BasicContextOriented getSubObject() {
        try (TempCoinjemaContext cc = ContextFactory.pushContext(this)) {
            return new BasicContextOriented();
        }
    }

    public BasicContextOriented getSubObject(BasicContextOriented obj) {
        return obj.getSubObject();
    }

    @CoinjemaDependency(order = Order.LAST)
    public void setZLastDependency(String v) {
        if (paths == null) {
            throw new RuntimeException();
        }
        if (myOtherService == null) {
            throw new RuntimeException();
        }
        if (myService == null) {
            throw new RuntimeException();
        }
        if (log == null) {
            throw new RuntimeException();
        }
    }

    public BasicContextOriented getSubObject(String context) {
        try (TempCoinjemaContext tcc = ContextFactory.pushContext(this)) {
            return new BasicContextOriented(new CoinjemaContext(context));
        }
    }

    public void testLogging() {
        log.info("My logger works great!");
    }

    public String getInit() {
        return init;
    }

    public SimpleContextOriented getSimple() {
        return simple;
    }

    /**
     * @return Returns the myService.
     */
    public MockSingleton getMyService() {
        return myService;
    }

    public URL getHome() {
        return home;
    }

    @CoinjemaDependency(alias = "homeURL")
    public void setHome(URL home) {
        this.home = home;
    }

    @CoinjemaDependency(alias = "simple")
    public void setSimpleDep(SimpleContextOriented sco) {
        simple = sco;
    }

    public Logger getLog() {
        return log;
    }

}
