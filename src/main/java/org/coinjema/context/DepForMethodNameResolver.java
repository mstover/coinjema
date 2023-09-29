package org.coinjema.context;

import java.util.Collection;

public class DepForMethodNameResolver extends AbstractSingleDepResolver {

    public DepForMethodNameResolver(Class<?> clzz, String methodName) {
        super(getSimpleName(clzz)+"."+methodName);
    }
}
