/*
 * lab2
 * package networktest
 * AllTest.java
 * */

package networktest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 *testsuite for test all class in package network
 *@author Wang,Tao
 *@version 1.0 
 * 
 */
public class AllTests extends TestCase {
/**
 *Method fostr test suite
 *@return return a suite
 */
	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(Test_ShannonsModel.class);
		suite.addTestSuite(Test_ShannonsTheorem.class);
		//$JUnit-END$
		return suite;
	}
	 public static void main(String[] args) {
	        System.out.println("Executing AllTests ...");
	        junit.textui.TestRunner.run(suite());
	    }

}
