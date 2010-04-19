package org.coinjema.context.source;

import java.util.Collection;
import java.util.Collections;

public class ClasspathContextSource implements ContextSource {
	
	String name;
	Resource latest;
	String latestResourceName;
	String path;

	public ClasspathContextSource(String n,String path) {
		name = n;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public Resource getResource(String resourceName) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return null;
	}

	public Resource getResource(String resourceName, String extension) {
		
		latestResourceName = null;
		latest = null;
		String name = path + "/" + resourceName + "." + extension;
		if(Thread.currentThread().getContextClassLoader().getResource(name) != null)
		{
			return new ClasspathResource(name,resourceName);
		}
		return null;
	}

	public Collection<ContextSource> getSubContexts() {
		return Collections.EMPTY_LIST;
	}

}
