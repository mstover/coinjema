package org.coinjema.internal.context.names;

public class DepForTypeNameResolver  extends AbstractSingleDepResolver {
    public DepForTypeNameResolver(String type, String method) {
        super(type+"."+method);

    }
}
