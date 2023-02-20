package com.cg.spring.versioning;

public class Name {
  private String firstName;
  private String lastName;
/**
 * @param firstName
 * @param lastName
 */
public Name(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
}
/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}

/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}

@Override
public String toString() {
	return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
}
  
  
}
