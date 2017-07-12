/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//the package for the project

/**
 * Name class include firstname, lastname, and salutation
 * @author BO
 */
public class Name {

	/**
	 * stores first name
	 */
	private String firstName;
	
	/**
	 * stores last name
	 */
	private String lastName;
	
	/**
	 * stores salutation
	 */
	private String salutation;

	/** default constructor */
	public Name() {

	}

	/** parameterized constructor */
	
	public Name(String firstName, String lastName, String salutation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salutation = salutation;
	}

	//-----------getters and setters
	/**
	 * getter of the firstName
	 * @return firstName
	 * */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setter of the firstName
	 * @param firstName
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * getter of the lastName
	 * @return lastName
	 * */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setter of the lastName
	 * @param lastName
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getter of the Salutation
	 * @return salutation
	 * */
	public String getSalutation() {
		return salutation;
	}
	
	/**
	 * setter of the Salutation
	 * @param salutation
	 * */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	
	/**
	 * toString method for Name
	 * @return resultOfName
	 * */
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + ", salutation=" + salutation + "]";
	}

	
}
