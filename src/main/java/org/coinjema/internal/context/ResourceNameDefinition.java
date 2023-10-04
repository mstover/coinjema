package org.coinjema.internal.context;

import org.coinjema.cjm.DependencyDefinitionI;

public record ResourceNameDefinition(String resourceName) implements DependencyDefinitionI<Object> {
}
