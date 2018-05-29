
/* File: FishStick.java
 * Course number: CST8277_350 2018 Winter
 * lab:304
 * Professor: Rejaul Chowdhury, Stanley Pieda
 * Student: Tao Wang 040857654
 * Date: Jan, 2018
 * Description: Simple data transfer object.
 */

/**
 * @author Stanley Pieda
 * @version 1.0
 * Class for identify the FishStick
 * */
public class FishStick {
	/**FishStick ID*/
	private int id;
	/**Fishstick record number*/
	private int recordNumber;
	/**Fishstick omega number*/
	private String omega;
	/**Fishstick lambda number*/
	private String lambda;
	/**FishStick UUID*/
	private String uuid;
	
    /**
     * Constructor of FishStick
     */	
	public FishStick() {
		this(0,0,"","","");
	}
	
	/**
	 * FishStick params Constructor
	 * @param int id, int recordNumber, String omega, String lambda, String uuid
	 * 
	 * 
	 * */
	public FishStick(int id, int recordNumber, String omega, String lambda, String uuid) {
		this.id = id;
		this.recordNumber = recordNumber;
		this.omega = omega;
		this.lambda = lambda;
		this.uuid = uuid;
	}
	
	/**
	 * Method to get the ID
	 * @return int value of ID
	 * */
	public int getId() {
		return id;
	}
	
	/**
	 * Method to set the value of ID
	 * @param int id
	 * */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 *Method to get the value of record number
	 *@return int value of record number 
	 */
	public int getRecordNumber() {
		return recordNumber;
	}
	
	/**
	 *Method to set the value of record number
	 *@param int recordNumber 
	 */
	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	/**
	 *Method to get the omega
	 *@return String value of omega 
	 */
	public String getOmega() {
		return omega;
	}
	
	/**
	 *Method to set the value of omega
	 *@param String omega 
	 */
	public void setOmega(String omega) {
		this.omega = omega;
	}
	
	/**
	 *Method to get the value of lambda
	 *@return String value of lambda 
	 */
	public String getLambda() {
		return lambda;
	}
	
	/**
	 *Method to set the value of lambda 
	 *@param String lambda
	 */
	public void setLambda(String lambda) {
		this.lambda = lambda;
	}
	
	/**
	 *Method to get the value of UUID
	 *@return String value of UUID 
	 */
	public String getUUID() {
		return uuid;
	}
	
	/**
	 * Method to set the value of UUID
	 * @param String uuid
	 */
	public void setUUID(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String toString() {
		
		return "FishStick is "+", "+getRecordNumber()+", "+getOmega()+", "+getLambda()+", "+getUUID();
	}
}
