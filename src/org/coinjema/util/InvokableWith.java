package org.coinjema.util;

public interface InvokableWith<T> extends Invokable<T> {
	public T invokeWith(Object... args);

}
