module coinjema.cjm {
    requires org.apache.groovy;
    requires java.logging;
    requires java.management;
    requires java.sql;
    exports org.coinjema.cjm;
    exports org.coinjema.cjm.source;
    exports org.coinjema.collections;
    exports org.coinjema.cjm.util;
}