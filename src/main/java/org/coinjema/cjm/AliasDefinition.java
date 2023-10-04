package org.coinjema.cjm;

public record AliasDefinition<O, D>(O ownerObj,
                                    Class<D> dependencyClass,
                                    String alias) implements DependencyDefinitionI<D> {
}
