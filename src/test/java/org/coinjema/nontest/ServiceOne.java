package org.coinjema.nontest;

import java.net.URL;
import java.util.Properties;

public class ServiceOne {

    private String configName;
    private URL host;

    private Properties configuration;

    public String getConfigName() {
        return configName;
    }

    public URL getHost() {
        return host;
    }

    public Properties getConfiguration() {
        return configuration;
    }

    public ServiceOne(String configName, URL host, Properties configuration) {
        this.configName = configName;
        this.host = host;
        this.configuration = configuration;
    }
}
