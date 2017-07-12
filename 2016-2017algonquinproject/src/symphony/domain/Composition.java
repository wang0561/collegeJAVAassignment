
/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//package for the project

import java.util.List;

/**The model for the composition
 * @author BO
 * @version 1.0
 * */
public class Composition {
	/**the model for the composition
	 * @author BO
	 * */

	/** compostitionID stores ID by using class ID */
	private ID id;

	
	/** composer stores the player who are composer by using class composer */
	private Composer composer;



	/** a list which stores the movement */
	private List<Movement> movement;

	/**
	 * parameterized constructor
	 * 
	 * @param builder
	 */
	public Composition(CompositionBuilder builder) {
		this.id = builder.compositionID;
		this.composer = builder.composer;
		this.movement = builder.movement;

	}
	
	//----------------------------getters and setters------------------------
	/**getter of the compositionID
	 * @return compostitionID
	 * */
	public ID getCompositionID() {
		return id;
	}

	/**setter of the compositionID
	 * @param compositionID
	 * */
	public void setCompositionID(ID compositionID) {
		this.id = compositionID;
	}

	
	
	/**getter of the composer
	 * @return composer
	 */
	public Composer getComposer() {
		return composer;
	}

	/**setter of the composer
	 *@param composer 
	 */
	public void setComposer(Composer composer) {
		this.composer = composer;
	}
	
	
	
	/**
	 * getter of the movement
	 * @return movement
	 * */
	public List<Movement> getMovement() {
		return movement;
	}

	/**
	 * setter of the movement
	 * @param movement
	 * */
	public void setMovement(List<Movement> movement) {
		this.movement = movement;
	}

}
