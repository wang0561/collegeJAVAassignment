/*
 * File name:Buffer.java
 * course number: cst8277_winter 2018
 * lab: 304
 * Professor: Rejaul Chowdhury, Stanley Pieda
 * Student: Tao Wang, 040857654
 * version 1.0
 * created date: January22, 2018
 * Reference:  Paul Deitel& Harvey Deitel, Java How to program, Fig. 23.9: Buffer.java
 * 
 * */


/**
 * Interface to define a buffer to store data
 * @author Tao Wang
 * @version 1.0
 * Date:January 2018
 * */
public interface  Buffer<T> {
	 /**
	  * Method to place object into Buffer 
	  * @param T t, type of object
	  * @throws  InterruptedException
	  */
	   public void blockingPut(T t) throws InterruptedException; 

	   /**
	    *Method to obtain object from Buffer 
	    *@return T, any type of object
	    *@throws  InterruptedException
	    */ 
	   public T blockingGet() throws InterruptedException;

	   /**
	    * Method to check if the buffer is empty
	    * @return boolean 
	    * */
	  public boolean isDone();
      /**
       *Method to set done
       *@param boolean done 
       */
	  public void setDone(boolean done);
	  
	  /**
	   *Method if the buffer is empty 
	   *@return boolean
	   */
	  public boolean isEmpty();
}
