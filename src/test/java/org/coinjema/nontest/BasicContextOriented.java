package org.coinjema.nontest;

import org.coinjema.context.*;
import org.coinjema.context.CjmDependency.Order;

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
        Cjm.contextualize(this);
    }

    public BasicContextOriented(CjmContext context) {
        Cjm.contextualize(this, context);
    }

    public BasicContextOriented(String init, CjmContext context) {
        this.init = init;
        Cjm.contextualize(this, context);
    }

    @CjmDependency(alias = "log4j")
    public void setLogger(Logger log) {
        this.log = log;
    }

    public Properties getConfig() {
        return props;
    }

    @CjmDependency(method = "config")
    public void setConfig(Properties p) {
        props = p;
    }

    public String getProp(String key) {
        return props.getProperty(key);
    }

    public String getDynamicProperty(String key) {
        return ContextFactory.withContext(getCoinjemaContext(), () -> getMyService().getProperty(key));
    }

    @CjmDependency
    public void setService(MockSingleton myService) {
        this.myService = myService;
    }

    @CjmDependency(type = "AnnotatedMock")
    public void setOtherService(MockSingleton myOtherService) {
        this.myOtherService = myOtherService;
    }

    public MockSingleton getRedirectedService() {
        return redirectedService;
    }

    @CjmDependency(method = "redirectionMock")
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

    @CjmDependency
    public void setPaths(String[] paths) {
        this.paths = paths;
    }

    public BasicContextOriented getSubObject() {
        return ContextFactory.withContext(getCoinjemaContext(), () -> new BasicContextOriented());
    }

    public BasicContextOriented getSubObject(BasicContextOriented obj) {
        return obj.getSubObject();
    }

    @CjmDependency(order = Order.LAST)
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
        return ContextFactory.withContext(getCoinjemaContext(), () -> new BasicContextOriented(new CjmContext(context)));
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

    @CjmDependency(alias = "homeURL")
    public void setHome(URL home) {
        this.home = home;
    }

    @CjmDependency(alias = "simple")
    public void setSimpleDep(SimpleContextOriented sco) {
        simple = sco;
    }

    public Logger getLog() {
        return log;
    }

}
