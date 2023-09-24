package org.coinjema.nontest;

import org.coinjema.context.CoinjemaConstructorObject;
import org.coinjema.context.ConstructorDependency;

@CoinjemaConstructorObject
public class SimpleConstructorOriented {

    private final MockSingleton service;
    private final String username;

    public SimpleConstructorOriented(
            @ConstructorDependency MockSingleton service,
            @ConstructorDependency(method = "username") String username) {
        this.username = username;
        this.service = service;
    }

    public MockSingleton getService() {
        return service;
    }

    public String getUsername() {
        return username;
    }
}
