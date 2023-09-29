package org.coinjema.nontest;

import org.coinjema.context.AbstractContextOriented;
import org.coinjema.context.DependencyDefinition;
import org.coinjema.context.Recipe;
import org.coinjema.context.TypeDefinition;

public class SimpleConstructorOriented extends AbstractContextOriented {

    private final MockSingleton service;
    private final String username;

    public SimpleConstructorOriented() {
        this.username = Recipe.getDep(new DependencyDefinition<>(this, String.class, "username", null));
        this.service = Recipe.getDep(new TypeDefinition<>(this, MockSingleton.class));
    }

    public MockSingleton getService() {
        return service;
    }

    public String getUsername() {
        return username;
    }
}
