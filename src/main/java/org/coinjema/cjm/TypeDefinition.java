package org.coinjema.cjm;

import org.coinjema.cjm.DependencyDefinitionI;

public record TypeDefinition<O, D>(O obj,
                                   Class<D> dependencyClass) implements DependencyDefinitionI<D> {
}
