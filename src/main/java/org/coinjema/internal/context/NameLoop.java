package org.coinjema.internal.context;

public interface NameLoop<T> {
	
	public T getDependency(String resourceName);

}
