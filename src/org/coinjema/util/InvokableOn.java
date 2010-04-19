package org.coinjema.util;

public interface InvokableOn<T> extends InvokableWith<T>{
	public T invokeOn(Object invokee);
	public T invoke(Object invokee,Object... args);
}
