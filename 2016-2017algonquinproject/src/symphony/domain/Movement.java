/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;// package for the project

/**
 * class for store all data of movement
 * @author Bo
 *
 */
public class Movement {

	
	/** the ID of movement*/
	private ID id;
	
	
	/**parameterized constructor
	 * @param movementID
	 * @param movementName*/
	public Movement(ID id) {
		this.id = id;
	}
	
	// ----------------------setters and getters-----------
	/**getter of the movementID
	 * @return movementID
	 * */
	public ID getMovementID() {
		return id;
	}

	/**setter of the movementID
	 * @param movementID*/
	public void setMovementID(ID id) {
		this.id = id;
	}

}
