package org.coinjema.nontest;

import java.util.Properties;
import java.util.logging.Logger;

/**
 * 
 * @author mstover
 * 
 */
public class BasicObject {
	String[] paths;
	static Logger log;
	Properties props = new Properties();

	public BasicObject() {
		props.setProperty("color", "green");
	}

	public BasicObject(String[] paths) {
		this();
		setPaths(paths);
	}

	/**
	 * @return Returns the paths.
	 */
	public String[] getPaths() {
		return paths;
	}

	/**
	 * @param paths
	 *            The paths to set.
	 */
	public void setPaths(String[] paths) {
		this.paths = paths;
	}

	public void setLogger() {
		if (this.log == null) {
			this.log = Logger.getLogger(BasicObject.class.getName());
		}
	}

	public String getProperty(String key) {
		return props.getProperty(key);
	}

}
