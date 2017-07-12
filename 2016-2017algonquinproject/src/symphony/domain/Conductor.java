/**
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * @version 1.0
 * 
 * */
package symphony.domain;//package of the project

/**
 * Conductor class which inherit the player
 * @author BO
 * 
 * */
public class Conductor extends Musician {

	
	
	/**
	 * Parameterized Constructor
	 * @param id
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * */
	public Conductor(ID id, Name name,	Address address,	PhoneNumber phoneNumber  ){
		super(id, name,address,	phoneNumber);
				
	}
	
		

}
