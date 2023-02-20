package com.cg.spring.versioning;

public class PersonV2 {
	
	private Name name;

	
	/**
	 * @param name
	 */
	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

	
}
