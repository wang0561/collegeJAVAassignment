/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;
/**model of the ID class
 * @author BO */


public class ID {

	
	/** stores the ID
	 * */
	private String id;
	
	/**
	 * parameterized constructor
	 * @param id
	 * */
	public ID(String id ){
		this.id = id;
	}

	/**
	 * getter of id
	 * @return id;
	 * */
	public String getId() {
		return id;
	}

	
	/**setter of id 
	 * @param id
	 * */
	public void setId(String id) {
		this.id = id;
	}

	
	/**
	 * toString method. convert result to String
	 * */
	public String  toString (){
		
		return ""+id;
		
	}
}
