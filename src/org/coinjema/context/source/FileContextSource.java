package org.coinjema.context.source;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * An implementation of ContextSource based on a simple file structure.
 * 
 * @author mstover
 * 
 */
public class FileContextSource implements ContextSource {

	File root;
	ThreadLocal<Resource> latest = new ThreadLocal<Resource>();
	ThreadLocal<String> latestResourceName = new ThreadLocal<String>();

	public FileContextSource(File file) {
		root = file.getAbsoluteFile();
	}

	public FileContextSource(String filename) {
		root = new File(filename).getAbsoluteFile();
		if (!root.exists()) {
			throw new RuntimeException("Failed to find context directory: "
					+ root.getAbsolutePath());
		}
	}

	public Collection<ContextSource> getSubContexts() {
		List<ContextSource> children = new LinkedList<ContextSource>();
		for (File f : root.listFiles(new FileFilter() {
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}
				return false;
			}
		})) {
			children.add(new FileContextSource(f));
		}
		return children;
	}

	public String getName() {

		return root.getName();
	}

	public File getRootDirectory() {
		return root;
	}

	/**
	 * Returns null if no such file found.
	 */
	public Reader getReader(String resource, String type) {
		try {
			return new FileReader(new File(root, resource + "." + type));
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	/**
	 * Returns null if no such file found.
	 */
	public InputStream getInputStream(String resource, String type) {
		try {
			return new FileInputStream(new File(root, resource + "." + type));
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	public Resource getResource(final String resourceName, final String ext) {
		File res = new File(root, resourceName + "." + ext);
		latestResourceName.set(null);
		latest.set(null);
		if (res.exists() && !res.isDirectory()) {
			return new FileResource(res, resourceName, ext);
		}
		return null;
	}

	public Resource getResource(final String resourceName) {
		if (resourceName.equals(latestResourceName.get())) {
			return latest.get();
		} else {
			latestResourceName.set(resourceName);
			latest.set(null);
		}
		File[] candidates = root.listFiles(new FilenameFilter() {
			public boolean accept(File parent, String filename) {
				if (filename.startsWith(resourceName)) {
					String end = filename.substring(resourceName.length());
					if (end.length() > 0 && end.charAt(0) == '.') {
						if (end.substring(1).indexOf(".") == -1) {
							return true;
						} else {
							end = MetaType.stripMetaTypes(end);
							if (end.substring(1).indexOf(".") == -1) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		});
		if (candidates == null || candidates.length == 0) {
			latest.set(null);
		} else if (candidates.length == 1) {
			latest.set(new FileResource(candidates[0], resourceName));
		} else if (candidates.length > 1) {
			throw new RuntimeException(
					"More than one resource found with name: '" + resourceName
							+ "' in directory " + root.getAbsolutePath());
		}
		return latest.get();
	}

}
