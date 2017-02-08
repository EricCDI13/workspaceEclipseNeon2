package fr.imie.cours;

public class Person {

	public Person() {
		setFirstName("brad");
		setFirstName("pitt");
	}

	String firstName;

	String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
