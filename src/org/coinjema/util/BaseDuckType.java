package org.coinjema.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BaseDuckType implements DuckType {
	Map<String, Collection<Functor<?>>> methods = new HashMap<String, Collection<Functor<?>>>();

	public BaseDuckType() {
	}

	public void addMethod(String name, Functor iw) {
		Collection<Functor<?>> list = methods.get(name);
		if (list == null) {
			list = new LinkedList<Functor<?>>();
			methods.put(name, list);
		}
		list.add(iw);
	}

	public void addMethod(Functor<?> f) {
		addMethod(f.getMethodName(), f);
	}

	public void addMethod(Object o, String methodName) {
		addMethod(methodName, new Functor(o, methodName));
	}

	public void addMethods(Object o, String[] methodNames) {
		for (String name : methodNames) {
			addMethod(o, name);
		}
	}

	public Object ex(String method, Object... args) {
		for (Functor<?> f : methods.get(method)) {
			if (f.isMatchFor(args)) {
				return f.invokeWith(args);
			}
		}
		return null;
	}

}
