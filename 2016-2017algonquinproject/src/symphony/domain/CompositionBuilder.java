
/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//package for the project

import java.util.ArrayList;
import java.util.List;

/**
 * The builder pattern of the composition
 * @version 1.0
 * @author Bo
 */
public class CompositionBuilder {
	

	/** id for the composition */
   protected ID compositionID;

	
	/** the composer */
	protected Composer composer;

	/** store soloist as list */
	 List<Soloist> soloist;

	/** store movement as list */
	protected List<Movement> movement;

	/**
	 * parameterized constructor
	 * 
	 * @param compositionID
	 */
	public CompositionBuilder(ID compositionID) {
		this.compositionID = compositionID;
		
	}
	
	/**
	 * get the composer builder
	 * @return compositionBuilder
	 * @param composer
	 * */
	public CompositionBuilder composer(Composer composer) {
		this.composer = composer;
		return this;
	}


	/**
	 * get the movement builder
	 * @return compositionBuilder
	 * @param movement
	 * */
	public CompositionBuilder movement(ArrayList<Movement> movement) {
		this.movement = movement;
		return this;
	}

	/**
	 * the builder build method
	 * @return composition
	 * */
	public Composition build() {
		return new Composition(this);
	}

}
