package org.coinjema.nontest;

import java.util.Properties;

import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject(type="gpropClass")
public class HasGroovyProperties {

	public HasGroovyProperties() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Properties props;
	
	@CoinjemaDependency(method="config")
	public void setProperties(Properties p)
	{
		props = p;
	}
	
	public String getProperty(String key)
	{
		return props.getProperty(key);
	}

}
