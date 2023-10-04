package org.coinjema.testing.nontest.noaspect;

import org.coinjema.cjm.AliasDefinition;
import org.coinjema.cjm.DependencyDefinition;
import org.coinjema.cjm.Cjm;
import org.coinjema.cjm.TypeDefinition;
import org.coinjema.testing.nontest.MockSingleton;

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
