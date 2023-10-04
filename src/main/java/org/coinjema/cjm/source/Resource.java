package org.coinjema.cjm.source;

import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;

public interface Resource {
	
	InputStream getInputStream();
	Reader getReader();
	Collection<MetaType> getMetaTypes();
	String getName();
	String getFormat();
}
