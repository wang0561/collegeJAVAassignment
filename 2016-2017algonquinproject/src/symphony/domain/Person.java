/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//package of package

/**
 * 
 * * abstract class person which ready for soloist, conductor etc...
 * 
 * @author Bo
 * 
 */

public abstract class Person {

	
	/** Identification of player */
	public ID id;

	/** name of player */
	public Name name;

	/** name of address */
	public Address address;

	/** name of Phone number */
	public PhoneNumber phoneNumber;

	/**
	 * parameterized constructor
	 * 
	 * @param name
	 */

	public Person(Name name) {
		this.name = name;
	}

	/**
	 * parameterized constructor
	 * 
	 * @param name
	 * @param address
	 * @param phoneNumber
	 */
	public Person(Name name, Address address, PhoneNumber phoneNumber) {

		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;

	}

	/**
	 * parameterized constructor
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param phoneNumber
	 */

	public Person(ID id, Name name, Address address, PhoneNumber phoneNumber) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;

	}

	//------------------getters and setters
	
	/**
	 * getter of the id
	 * @return id
	 * */
	public ID getId() {
		return id;
	}
	
	
	/**
	 * setter of the id
	 * @param id
	 * */
	public void setId(ID id) {
		this.id = id;
	}

	/**
	 * getter of the name
	 * @return name
	 * */
	public Name getName() {
		return name;
	}

	
	/**
	 * setter of the name
	 * @param name
	 * */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * getter of the address
	 * @return address
	 * */
	public Address getAddress() {
		return address;
	}

	/**
	 * setter of the address
	 * @param address
	 * */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * getter of the PhoneNumber
	 * @return PhoneNumber
	 * */
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setter of the phoneNumber
	 * @param phoneNumber
	 * */
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
