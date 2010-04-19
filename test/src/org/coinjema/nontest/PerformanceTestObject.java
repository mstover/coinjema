package org.coinjema.nontest;

import java.util.logging.Logger;

import org.coinjema.context.CoinjemaContext;
import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject(type = "performer")
public class PerformanceTestObject {
	String[] paths;
	static Logger log;

	public PerformanceTestObject() {
	}

	public PerformanceTestObject(CoinjemaContext c) {

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
	@CoinjemaDependency(method = "paths")
	public void setPaths(String[] paths) {
		this.paths = paths;
	}

	@CoinjemaDependency(alias = "log4j")
	public void setLogger(Logger l) {
		log = l;
	}

	public static Logger getLog() {
		return log;
	}

}
