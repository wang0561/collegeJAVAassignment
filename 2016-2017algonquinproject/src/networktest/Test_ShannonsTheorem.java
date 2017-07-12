/*
 * lab2
 * package networktest
 * Test_ShannonsTheorem.java
 * Follow a more complex UML class diagram to model program design
 * Refactor (read about it at WikiWiki, this description is adequate for out purposes) your lab2
 *assignment, "ShannonsTheorem" code to:
 * Separate the "presentation" logic from the "domain" logic by creating a second class to
encapsulate the attributes and calculations (actually a "derived attribute") for Shannons
Theorem.
 *MDR is considered a "derived" attribute as it is calculated from other attributes.
 *Activities
 *Implement the attached UML diagram (below) in your code by refactoring (not completely rewriting) your
 *8code from lab01B. The user interface remains in the ShannonsTheorem.java driver class. Move the attributes

 *required for the algorithm to a new class called "ShannonsModel" representing the "data model" for the
 *application.
 */
package networktest;

import java.text.DecimalFormat;
import junit.framework.TestCase;
import network.ShannonsTheorem;
/**
 *class for test  ShannonsTheorem
 *@author Wang,Tao
 *@version 2.0
 * 
 */
public class Test_ShannonsTheorem extends TestCase {
	/**
	 *Constructor of ShannonsTheorem 
	 *@param name string value of name
	 **/
	public Test_ShannonsTheorem(String name) {
		//call the super class constructor
		super(name);
	}
	/**
	 * Method from super class to test the setup
	 * @throws Exception exception
	 */
	protected void setUp() throws Exception {
		//call the method from super class
		super.setUp();
	}
	/**Method from super class to test tearDown
	 * @throws Exception exception
	 * */ 
	protected void tearDown() throws Exception {
		//call the method from super class
		super.tearDown();
	}


	/**
	 * Test method for {@link network.ShannonsTheorem#getBindwidth()}.
	 */
	public void testGetBindwidth() {
		System.out.println("getBandwidth");
		ShannonsTheorem instance = new ShannonsTheorem();
		//expected result
		double expResult = 1000;
		instance.setBandWidth(1000);
		//actual result
		double result = instance.getBandWidth();
		if(expResult!= result)
			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}

	/**
	 * Test method for {@link network.ShannonsTheorem#getSignalToNoise()}.
	 */
	public void testGetSignalToNoise() {
		System.out.println("getSignalToNoise");
		ShannonsTheorem instance = new ShannonsTheorem();
		//expected value
		double expResult = 30;
		instance.setSignalToNoise(30);
		//actual value
		double result = instance.getSignalToNoise();
		if(expResult!=result)
			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}

	/**
	 * Test method for {@link network.ShannonsTheorem#getMaxinumDataRate()}.
	 */
	public void testGetMaxinumDataRate() {
		//format the double value
		DecimalFormat df=new DecimalFormat("0.00");
		System.out.println("getMaxinumDataRate");
		//new    ShannonsTheorem objext
		ShannonsTheorem instance = new ShannonsTheorem();
		//set values
		instance.setBandWidth(1000);
		instance.setSignalToNoise(30);
		//expected result
		double expResult = 9967.23;
		double result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		// assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		//test first set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		instance.setBandWidth(200);
		instance.setSignalToNoise(3.5);
		expResult = 339.08;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test third set of data
		instance.setBandWidth(200);
		instance.setSignalToNoise(-3.5);
		expResult = 106.55;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test third set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test fourth data
		instance.setBandWidth(0);
		instance.setSignalToNoise(-100);
		expResult = 0.00;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));

		if(result!=expResult)
			fail("The test case is a prototype.");
		//test fiveth set of data
		instance.setBandWidth(10000);
		instance.setSignalToNoise(100);
		expResult = 332192.81;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		if(result!=expResult)
			fail("The test case is a prototype.");

		//test sixth set of data
		instance.setBandWidth(1);
		instance.setSignalToNoise(-100);
		expResult = 0.00;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test seventh set of data
		instance.setBandWidth(1);
		instance.setSignalToNoise(100);
		expResult = 33.22;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test eightth set of dat
		instance.setBandWidth(10000);
		instance.setSignalToNoise(-100);
		expResult = 0.00;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test exception
		try{instance.setBandWidth(-100);
		instance.setSignalToNoise(20);

		}catch(NumberFormatException e1){
			System.out.println("number should be positive");
		}


	}



	/**
	 * Test method for {@link network.ShannonsTheorem#setBandwidth(double)}.
	 */
	public void testSetBandwidth() {
		System.out.println("setBandwidth");
		//expected value
		double expResult = 1000;
		ShannonsTheorem instance = new ShannonsTheorem();
		//set value of bindWidth
		instance.setBandWidth(expResult);
		//test if the reults matched    
		if(expResult!=instance.getBandWidth())

			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}

	/**
	 * Test method for {@link network.ShannonsTheorem#setSignalToNoise(double)}.
	 */
	public void testSetSignalToNoise() {
		System.out.println("setSignalToNoise");
		//expected value   
		double expResult = 10;
		// new ShannonsTheorem object   
		ShannonsTheorem instance = new ShannonsTheorem();
		//set value of SNR   
		instance.setSignalToNoise(expResult);
		//test the reuslt matched
		if(expResult!= instance.getSignalToNoise())

			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}



	

}



