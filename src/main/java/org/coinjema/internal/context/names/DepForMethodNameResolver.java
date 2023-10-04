package org.coinjema.internal.context.names;

public class DepForMethodNameResolver extends AbstractSingleDepResolver {

    public DepForMethodNameResolver(Class<?> clzz, String methodName) {
        super(getSimpleName(clzz)+"."+methodName);
    }
}
