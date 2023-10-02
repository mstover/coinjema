package org.coinjema.nontest;

import java.util.Properties;

import org.coinjema.context.*;

public class HasGroovyProperties {

	public HasGroovyProperties() {
		super();
		this.props = Cjm.getDep(new ObjectDependencyDefinition<>(this,Properties.class,"config","gpropClass"));
	}
	
	private final Properties props;
	
	public String getProperty(String key)
	{
		return props.getProperty(key);
	}

}
