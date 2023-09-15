package org.coinjema.nontest;

import java.util.Properties;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject
public class InheritingObject {
	
	public InheritingObject()
	{
		
	}
	
	public InheritingObject(CoinjemaContext cc)
	{
		
	}

	Properties props;

	public Properties getProps() {
		return props;
	}

	@CoinjemaDependency(method="config")
	public void setProps(Properties props) {
		this.props = props;
	}
}
