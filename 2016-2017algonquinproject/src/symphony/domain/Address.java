/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//package for the project

/**
 * This class stores the data of date for the address,include streetname,postalcode, province
 * @version 1.0
 * @author BO
 */
public class Address {
	/**
	 * this class stores the data of date for the Activity
	 * @version 1.0
	 * @author BO
	 */

	/**
	 * streetName is a String which stores the name of the street
	 */
	private String streetName;
	/**
	 * streeNumber is a String which stores the number of the street
	 */
	private String streeNumber;
	/**
	 * city is a String which stores the city of the street
	 */
	private String city;
	/**
	 * province is a String which stores the province of the city
	 */
	private String province;
	/**
	 * postalCode is a String which stores the postalCode of the street
	 */
	private PostalCode postalCode;

	// ---------------------Constructors------------------------
	/**
	 * Default Constructor
	 */
	public Address() {

	}

	/**
	 * parameterized constructor
	 * 
	 * @param streeNumber
	 * @param streetName
	 * @param city
	 * @param province
	 * @param postalCode
	 */
	public Address(String streeNumber, String streetName, String city, String province, PostalCode postalCode) {

		this.streetName = streetName;
		this.streeNumber = streeNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	// ----------------------getters and setters------------------------
	/**
	 * getter of the StreetName
	 * @return streetName
	 * */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * setter of the StreetName
	 * @param streetName
	 * */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	/**
	 * getter of the StreetNumber
	 * @return streeNumber
	 * */
	public String getStreeNumber() {
		return streeNumber;
	}

	/**
	 * setter of the StreetNumber
	 * @param streeNumber
	 * */
	public void setStreeNumber(String streeNumber) {
		this.streeNumber = streeNumber;
	}
	
	/**
	 * getter of the City
	 * @return city
	 * */
	public String getCity() {
		return city;
	}
	
	/**
	 * setter of the City
	 * @param city
	 * */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * getter of the province
	 * @return province
	 * */
	public String getProvince() {
		return province;
	}
	
	/**setter of the province
	 * @param province
	 * */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * getter of the postalCode
	 * @return postalCode
	 * */
	public PostalCode getPostalCode() {
		return postalCode;
	}

	/**
	 * setter of the postalCode
	 * @param postalCode
	 * */
	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	
	//----------toString-----------------
	/** toString method which could convert the result into the string
	 * @return String output
	 * */
	public String toString() {

		return "" + getStreeNumber() + " " + getStreetName() + " " + getCity() + " " + getProvince() + " "
				+ postalCode.getPostcode();
	}

	
}
