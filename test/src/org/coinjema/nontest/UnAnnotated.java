package org.coinjema.nontest;

public class UnAnnotated {
	
	private String name;
	
	private String value = "Has Default";

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
