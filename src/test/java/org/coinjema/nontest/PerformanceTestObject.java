package org.coinjema.nontest;

import org.coinjema.context.*;

import java.util.logging.Logger;

@CoinjemaObject(type = "performer")
public class PerformanceTestObject extends AbstractContextOriented {
    static Logger log;
    String[] paths;

    public PerformanceTestObject() {
        Recipe.contextualize(this);
    }

    public PerformanceTestObject(CoinjemaContext c) {
        Recipe.contextualize(this, c);
    }

    public static Logger getLog() {
        return log;
    }

    /**
     * @return Returns the paths.
     */
    public String[] getPaths() {
        return paths;
    }

    /**
     * @param paths The paths to set.
     */
    @CoinjemaDependency(method = "paths")
    public void setPaths(String[] paths) {
        this.paths = paths;
    }

    @CoinjemaDependency(alias = "log4j")
    public void setLogger(Logger l) {
        log = l;
    }

}
