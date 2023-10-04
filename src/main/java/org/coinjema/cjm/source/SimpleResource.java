package org.coinjema.cjm.source;

import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SimpleResource implements Resource {

    String name;
    MetaType scope = MetaType.global;

    public SimpleResource(String name) {
        this.name = name;
    }

    public SimpleResource(String name, MetaType scope) {
        this(name);
        if (scope != null)
            this.scope = scope;
    }

    public String getFormat() {
        return "";
    }

    public InputStream getInputStream() {
        return null;
    }

    public Collection<MetaType> getMetaTypes() {
        Set<MetaType> scopes = new HashSet<MetaType>();
        scopes.add(scope);
        return scopes;
    }

    public String getName() {
        return name;
    }

    public Reader getReader() {
        return null;
    }

    public MetaType getScope() {
        return scope;
    }
}
