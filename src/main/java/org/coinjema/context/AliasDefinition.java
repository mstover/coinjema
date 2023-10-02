package org.coinjema.context;

public record AliasDefinition<O, D>(O ownerObj,
                                    Class<D> dependencyClass,
                                    String alias) implements DependencyDefinitionI<D> {
}
