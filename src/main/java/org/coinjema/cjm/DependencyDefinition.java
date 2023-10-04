package org.coinjema.cjm;

public record DependencyDefinition<O,D>(O obj,
                                   Class<D> dependencyClass,
                                   String method,
                                   String type) implements DependencyDefinitionI<D> {
}
