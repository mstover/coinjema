package org.coinjema.context;

public record TypeDefinition<O, D>(O obj,
                                   Class<D> dependencyClass) implements DependencyDefinitionI<D> {
}
