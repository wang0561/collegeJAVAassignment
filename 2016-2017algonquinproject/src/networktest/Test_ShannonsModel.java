/*
 * lab2
 * package networktest
 * Test_ShannonsModel.java
 */
package networktest;

import java.text.DecimalFormat;
import junit.framework.TestCase;
import network.ShannonsModel;
/**
 *class for test  ShannonsModel
 *@author Wang,Tao
 *@version 2.0
 * 
 */
public class Test_ShannonsModel extends TestCase {
	/**
	 *construcor of Test_ShannonsModel
	 *
	 *@param name String value of name
	 */
	public Test_ShannonsModel(String name) {
		//call super class constructor
		super(name);
	}
	/**
	 *Method for test setup
	 *@throws Exception  exception
	 */
	protected void setUp() throws Exception {
		//call super class method
		super.setUp();
	}
	/**
	 *Method for test tearDown
	 *@throws Exception exception
	 */
	protected void tearDown() throws Exception {
		//call super class method

		super.tearDown();
	}
	/**
	 * Test method for {@link network.ShannonsModel#getBandwidth()}.
	 * */	
	public void testGetBandwidth() {
		System.out.println("getBandwidth");
		//create a new shannonsModel Object
		ShannonsModel instance = new ShannonsModel();
		//expected result
		double expResult = 1000;
		instance.setBandwidth(1000);
		//actual result
		double result = instance.getBandwidth();
		if(expResult!= result)
			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}

	/**
	 * Test method for {@link network.ShannonsModel#getSignalToNoise()}.
	 */
	public void testGetSignalToNoise() {
		System.out.println("getSignalToNoise");
		//new    ShannonsModel object
		ShannonsModel instance = new ShannonsModel();
		//expected result
		double expResult = 30;
		instance.setSignalToNoise(30);
		//actual result
		double result = instance.getSignalToNoise();
		//test the reults matched
		if(expResult!=result)
			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}

	/**
	 * Test method for {@link network.ShannonsModel#getMaxinumDataRate()}.
	 */
	public void testGetMaxinumDataRate() {
		//format the double value
		DecimalFormat df=new DecimalFormat("0.00");
		System.out.println("getMaxinumDataRate");
		//new    ShannonsModel objext
		ShannonsModel instance = new ShannonsModel();
		//set values
		instance.setBandwidth(1000);
		instance.setSignalToNoise(30);
		//expected result
		double expResult = 9967.23;
		double result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		// assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		//test first set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		instance.setBandwidth(200);
		instance.setSignalToNoise(3.5);
		expResult = 339.08;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
        //test third set of data
		instance.setBandwidth(200);
		instance.setSignalToNoise(-3.5);
		expResult = 106.55;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test third set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test fourth data
		instance.setBandwidth(10000);
		instance.setSignalToNoise(-100);
		expResult = 0.00;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test fiveth set of data
		instance.setBandwidth(10000);
		instance.setSignalToNoise(100);
		expResult = 332192.81;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		if(result!=expResult)
			fail("The test case is a prototype.");
		
		//test sixth set of data
		instance.setBandwidth(1);
		instance.setSignalToNoise(-100);
		expResult = 0.00;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test seventh set of data
		instance.setBandwidth(1);
		instance.setSignalToNoise(100);
		expResult = 33.22;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test eightth set of dat
		instance.setBandwidth(10000);
		instance.setSignalToNoise(-100);
		expResult = 0.00;
		result = Double.parseDouble(df.format(instance.getMaxinumDataRate()));
		//test second set of data
		if(result!=expResult)
			fail("The test case is a prototype.");
		//test exception
	    try{instance.setBandwidth(-100);
	         instance.setSignalToNoise(20);
	    
	    }catch(NumberFormatException e1){
	    	System.out.println("number should be positive");
	    }
		
	
		
	}



	/**
	 * Test method for {@link network.ShannonsModel#setBindwidth(double)}.
	 */
	public void testSetBandwidth() {
		System.out.println("setBandwidth");
		//expected result
		double expResult = 1000;
		//new 		ShannonsModel object
		ShannonsModel instance = new ShannonsModel();
		instance.setBandwidth(expResult);
		//test whethre results are matched
		if(expResult!=instance.getBandwidth())

			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}

	/**
	 * Test method for {@link network.ShannonsModel#setSignalToNoise(double)}.
	 */
	public void testSetSignalToNoise() {
		System.out.println("setSignalToNoise");
		//expected result
		double expResult = 10;
		ShannonsModel instance = new ShannonsModel();
		instance.setSignalToNoise(expResult);
		//test whether reulsts matched
		if(expResult!= instance.getSignalToNoise())

			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}



	/**
	 * Test method for {@link network.ShannonsModel#toString()}.
	 */
	public void testToString() {
		System.out.println("toString");
		//new 		ShannonsModel object
		ShannonsModel instance = new ShannonsModel();
		//set values of bindwidth and signaltonoise
		instance.setBandwidth(1000);
		instance.setSignalToNoise(30);
		//test whether the result is mathed
		if(!instance.toString().equals("The result of Max Data Rate is 9967.23"))

			// TODO review the generated test code and remove the default call to fail.
			fail("The test case is a prototype.");
	}

}
