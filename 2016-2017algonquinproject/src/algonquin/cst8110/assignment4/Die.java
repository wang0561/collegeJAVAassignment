package algonquin.cst8110.assignment4;

/*
 Lab Teacher: Howard Rosenblum
 Author:Wang,Tao 040857654
 course: CST8110 300 ;
 */
import java.util.Random;

public class Die {
	private Random randomNumbers = new Random();// Java random number generator
	private int dieValue;// Current die value (i.e. 1-6)
	private int i;
	public void setI(int i){
		this.i=i;
		
	}
	public Die() {
        
	}// Construct the die

	public void roll() {
		
		this.dieValue = randomNumbers.nextInt(i) + 1;

	}// Roll the die (i.e. randomly change the value)

	public int getValue()// Get the current value

	{
		return dieValue;
	}
	
}
