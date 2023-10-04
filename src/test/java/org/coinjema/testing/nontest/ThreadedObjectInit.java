package org.coinjema.testing.nontest;

import java.lang.reflect.Constructor;
import java.util.concurrent.Callable;

public class ThreadedObjectInit<T> implements Callable<T> {

	Constructor<T> constructor;
	Object[] args;
	
	public ThreadedObjectInit(Constructor<T> c,Object ... args) {
		constructor = c;
		this.args = args;
	}

	public T call() throws Exception {
		return constructor.newInstance(args);
	}

}
