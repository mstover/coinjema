package org.coinjema.context;

public record ObjectDependencyDefinition<T>(Object obj,
                                            Class<T> depClass, String methodName,
                                            String type) implements DependencyDefinitionI<T> {
}
