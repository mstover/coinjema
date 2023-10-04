package org.coinjema.cjm;

import org.coinjema.cjm.DependencyDefinitionI;

public record ObjectDependencyDefinition<T>(Object obj,
                                            Class<T> depClass, String methodName,
                                            String type) implements DependencyDefinitionI<T> {
}
