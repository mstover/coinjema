package org.coinjema.cjm.source;

import java.io.*;
import java.util.Collection;
import java.util.Set;

public class FileResource implements Resource {
	File file;
	String name;
	Set<MetaType> types;
	String format;

	public FileResource(File f, String resourceName) {
		file = f;
		name = resourceName;
		types = MetaType.getIncludedTypes(f.getName());
	}

	public FileResource(File f, String resourceName, String format) {
		this(f, resourceName);
		this.format = format;
	}

	public InputStream getInputStream() {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public Reader getReader() {
		try {
			return new FileReader(file);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	public Collection<MetaType> getMetaTypes() {
		return types;
	}

	public synchronized String getFormat() {
		if (format == null) {
			format = file.getName().substring(name.length());
			format = MetaType.stripMetaTypes(format);
			if (format.startsWith(".")) {
				format = format.substring(1);
			}
			if (format.endsWith(".")) {
				format = format.substring(0, format.length() - 1);
			}
		}
		return format;
	}

	@Override
	public String toString() {
		return "Resource(name=" + file.getAbsolutePath() + ")";
	}

}
