package org.coinjema.testing.nontest;

import org.coinjema.cjm.AbstractContextOriented;
import org.coinjema.cjm.DependencyDefinition;
import org.coinjema.cjm.Cjm;
import org.coinjema.cjm.TypeDefinition;

public class SimpleConstructorOriented extends AbstractContextOriented {

    private final MockSingleton service;
    private final String username;

    public SimpleConstructorOriented() {
        this.username = Cjm.getDep(new DependencyDefinition<>(this, String.class, "username", null));
        this.service = Cjm.getDep(new TypeDefinition<>(this, MockSingleton.class));
    }

    public MockSingleton getService() {
        return service;
    }

    public String getUsername() {
        return username;
    }
}
