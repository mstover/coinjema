package org.coinjema.testing.nontest;

import org.coinjema.cjm.*;

import java.util.logging.Logger;

@CjmObject(type = "performer")
public class PerformanceTestObject extends AbstractContextOriented {
    static Logger log;
    String[] paths;

    public PerformanceTestObject() {
        Cjm.contextualize(this);
    }

    public PerformanceTestObject(CjmContext c) {
        Cjm.contextualize(this, c);
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
    @CjmDependency(method = "paths")
    public void setPaths(String[] paths) {
        this.paths = paths;
    }

    @CjmDependency(alias = "log4j")
    public void setLogger(Logger l) {
        log = l;
    }

}
