module coinjema.cjm.test {
    requires coinjema.cjm;
    requires org.apache.groovy;
    requires org.junit.jupiter.api;
    requires junit;
    requires java.management;
    requires java.logging;
    requires java.sql;
    exports org.coinjema.testing.nontest;
    exports org.coinjema.testing.nontest.noaspect;
    exports org.coinjema.testing.context;
    exports org.coinjema.testing.constructor;
    exports org.coinjema.testing.collections;
    exports org.coinjema.testing.util;
    opens org.coinjema.testing.constructor;
    opens org.coinjema.testing.context;
}