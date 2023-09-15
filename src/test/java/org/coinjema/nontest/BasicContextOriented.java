package org.coinjema.nontest;

import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaContextTrack;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;
import org.coinjema.context.CoinjemaDependency.Order;

@CoinjemaObject
public class BasicContextOriented {
	Logger log;
	MockSingleton myService;
	MockSingleton myOtherService, redirectedService;
	Properties props;
	String init;

	URL home;

	protected String[] paths;

	public BasicContextOriented() {
	}

	public BasicContextOriented(CoinjemaContext context) {
	}

	public BasicContextOriented(String init, CoinjemaContext context) {
		this.init = init;
	}

	@CoinjemaDependency
	public void setPaths(String[] paths) {
		this.paths = paths;
	}

	@CoinjemaDependency(alias = "log4j")
	public void setLogger(Logger log) {
		this.log = log;
	}

	@CoinjemaDependency(method = "config")
	public void setConfig(Properties p) {
		props = p;
	}

	public Properties getConfig() {
		return props;
	}

	public String getProp(String key) {
		return props.getProperty(key);
	}

	@CoinjemaContextTrack
	public String getDynamicProperty(String key) {
		return getMyService().getProperty(key);
	}

	@CoinjemaDependency
	public void setService(MockSingleton myService) {
		this.myService = myService;
	}

	@CoinjemaDependency(type = "AnnotatedMock")
	public void setOtherService(MockSingleton myOtherService) {
		this.myOtherService = myOtherService;
	}

	@CoinjemaDependency(method = "redirectionMock")
	public void setRedirectedService(MockSingleton redirected) {
		this.redirectedService = redirected;
	}

	public MockSingleton getRedirectedService() {
		return redirectedService;
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

	@CoinjemaContextTrack
	public BasicContextOriented getSubObject() {
		return new BasicContextOriented();
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

	@CoinjemaContextTrack
	public BasicContextOriented getSubObject(String context) {
		return new BasicContextOriented(new CoinjemaContext(context));
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

	SimpleContextOriented simple;

	public Logger getLog() {
		return log;
	}

}
