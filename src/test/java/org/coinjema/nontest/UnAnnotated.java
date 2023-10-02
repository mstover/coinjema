package org.coinjema.nontest;

import org.coinjema.context.AbstractContextOriented;
import org.coinjema.context.Recipe;

public class UnAnnotated {

    private final String name;

    private String value = "Has Default";

    public UnAnnotated(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

}
