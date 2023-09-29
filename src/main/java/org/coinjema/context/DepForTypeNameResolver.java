package org.coinjema.context;

public class DepForTypeNameResolver  extends AbstractSingleDepResolver {
    public DepForTypeNameResolver(String type, String method) {
        super(type+"."+method);

    }
}
