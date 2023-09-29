package org.coinjema.nontest;

import org.coinjema.context.AbstractContextOriented;
import org.coinjema.context.Recipe;

public class UnAnnotated extends AbstractContextOriented {

    private String name;

    private String value = "Has Default";

    public UnAnnotated() {
        Recipe.contextualize(this);
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

    public void setName(String name) {
        this.name = name;
    }

}
