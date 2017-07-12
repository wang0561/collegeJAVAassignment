/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//package of project

/**
 * PhoneNumber class for store the information of the phone number
 * 
 * @author Bo
 */

public final class PhoneNumber {
	
	/**
	 * international area code (3-5 digits)
	 */
	private int countryCode;

	/** area code (3 digits) */
	private int area;
	/** exchange (3 digits) */
	private int exch;
	/** line (4 digits) */
	private int line;

	
	/**
	 * parameterized constructor
	 * @param countryCode
	 * @param area
	 * @param line
	 * */
	public PhoneNumber(int countryCode, int area, int exch, int line) {
		this.countryCode = countryCode;
		this.area = area;
		this.exch = exch;
		this.line = line;
	}

	// 0 for padding with leading 0s

	/**
	 * toString method for PhoneNumber
	 * 
	 * @return the result of the phone number
	 */
	@Override
	public String toString() {
		return String.format("(%05d)(%03d) %03d-%04d", countryCode, area, exch, line);
	}

}
