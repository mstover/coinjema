package org.coinjema.nontest.noaspect;

import org.coinjema.context.AliasDefinition;
import org.coinjema.context.DependencyDefinition;
import org.coinjema.context.Cjm;
import org.coinjema.context.TypeDefinition;
import org.coinjema.nontest.MockSingleton;

import java.util.logging.Logger;

public class AjdtFreeConstructorOriented {

    private final MockSingleton service;
    private final String username;
    private final Logger logger;

    public AjdtFreeConstructorOriented() {
        service = Cjm.getDep(new TypeDefinition<>(this,MockSingleton.class));
        username = Cjm.getDep(new DependencyDefinition<>(this,String.class,"username",null));
        logger = (Logger) Cjm.getDep(new AliasDefinition<>(this,Logger.class,"log4j"));
    }

    public MockSingleton getService() {
        return service;
    }

    public String getUsername() {
        return username;
    }

    public Logger getLogger() {
        return logger;
    }
}
