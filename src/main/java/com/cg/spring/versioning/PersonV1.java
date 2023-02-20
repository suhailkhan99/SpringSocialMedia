package com.cg.spring.versioning;

public class PersonV1 {
	private String name;
	

	/**
	 * @param name
	 */
	public PersonV1(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}
	
	
	
}
