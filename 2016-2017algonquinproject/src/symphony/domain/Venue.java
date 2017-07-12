package symphony.domain;

import java.util.List;

/**Venue class which use for store the detail information of venue
 * @author Bo
 * 
 * */
public class Venue  {
	
	
	/**List of the phoneNumbers*/
	private List<PhoneNumber> phonenumber;
	/**address information*/
	private Address address;
	
	
	/**parameterized constructor
	 * @param address
	 * @param ListOfPhoneNumber*/
	public Venue(  Address address, List<PhoneNumber> phonenumber) {
		super();
		this.phonenumber = phonenumber;
		this.address = address;
	}

	//----------------getters and setters
	/**getter of the List Of PhoneNumber
	 * @return phonenumber
	 * */
	public List<PhoneNumber> getPhonenumber() {
		return phonenumber;
	}

	/**setter of the List Of PhoneNumber
	 * @param ListOfPhonenumber
	 * */	public void setPhonenumber(List<PhoneNumber> phonenumber) {
		this.phonenumber = phonenumber;
	}

	 /**getter of the List Of address
		 * @return Address
		 * */
	public Address getAddress() {
		return address;
	}

	/**getter of the address
	 * @param address
	 * */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
