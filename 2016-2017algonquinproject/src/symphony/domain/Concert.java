/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//package for the project

import java.util.List;

/**Model Concert ,include the concert id, compositions 
 * @author BO
 * @version 1.0
 * */

public class Concert {
	
	
	/**The concert id*/
	protected ID id;
		
	/**
	 * the list to store the composition
	 * */
	protected List<Composition> composition;
	
	/**
	 * default constructor
	 * */
	public Concert() {
		
	}
	
	/**
	 *Chained Constructor
	 *@param id
	 *@param composition
	 * */
	public Concert(ID id, List<Composition> composition) {
		super();
		this.id = id;
		this.composition = composition;
	}

	//----------------------------------setters and getters-----------------------------------
	/**getter of concertID
	 * @return concertID*/	
	public ID getConcertId() {
		return id;
	}

	/**setter of concertID
	 * @param id
	 * */
	public void setConcertId(ID id) {
		this.id = id;
	}

	/**
	 * getter of Composition
	 * @return composition
	 * */
	public List<Composition> getComposition() {
		return composition;
	}

	/**
	 * setter of Composition
	 * @param composition
	 * */
	public void setComposition(List<Composition> composition) {
		this.composition = composition;
	}
	
	

	
	   
}
