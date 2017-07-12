/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */

package symphony.domain;//package of package


import java.util.List;
/**
 * Class soloist extends from Musician class
 * @author Bo
 */

public class Soloist extends Musician {
	

	/**
	 * ArrayList for expertise
	 */
	private List<String> expertise;

	/**
	 * parameterized constructor
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param expertise
	 */
	public Soloist(ID id, Name name, Address address, PhoneNumber phoneNumber, List<String> expertise) {
		super(id, name, address, phoneNumber);
		this.expertise = expertise;

	}

	/**
	 * getter of Expertise
	 * 
	 * @return expertise
	 */
	public List<String> getExpertise() {
		return expertise;
	}

	/**
	 * setter of expertise
	 * 
	 * @param expertise
	 */
	public void setExpertise(List<String> expertise) {
		this.expertise = expertise;
	}

}
