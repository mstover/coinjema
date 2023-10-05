module coinjema.cjm.test {
    requires coinjema.cjm;
    requires org.apache.groovy;
    requires org.junit.jupiter.api;
    requires java.management;
    requires java.logging;
    requires java.sql;
    exports org.coinjema.testing.nontest;
    exports org.coinjema.testing.nontest.noaspect;
}