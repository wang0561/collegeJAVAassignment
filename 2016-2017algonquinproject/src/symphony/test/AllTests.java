package symphony.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;
import symphony.test.*;
/**
 * Class for test all classes in symphony.domain
 * @author Tao Wang
 * */
@RunWith(Suite.class)
@SuiteClasses({ TestAddress.class, TestComposer.class, TestComposition.class, TestCompositionBuilder.class,
		TestConcert.class, TestConcertBuilder.class, TestConcertSeason.class, TestConductor.class, TestCreditCard.class,
		TestCreditPayment.class, TestDebitCard.class, TestDebitPayment.class, TestID.class, TestMovement.class,
		TestMusician.class, TestName.class, TestPerformacedConcert.class, TestPerson.class, TestPhoneNumber.class,
		TestPostalCode.class, TestScheduledConcert.class, TestSeat.class, TestSoloist.class, TestTicket.class,
		TestTrasaction.class, TestVenue.class, TestVenueConcert.class })

public class AllTests {
/**
 * method for count how many mehtods tested
 * @return test
 * 
 * */
	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
	
		suite.addTestSuite(TestAddress.class);
		suite.addTestSuite(TestComposition.class);
		suite.addTestSuite(TestComposer.class);
		suite.addTestSuite(TestCompositionBuilder.class);
		suite.addTestSuite(TestConcert.class);
		suite.addTestSuite(TestConcertBuilder.class);
		
		suite.addTestSuite(TestConcertSeason.class);
		suite.addTestSuite(TestConductor.class);
		suite.addTestSuite(TestCreditCard.class);
		suite.addTestSuite(TestCreditPayment.class);
		
		suite.addTestSuite(TestDebitCard.class);
		suite.addTestSuite(TestDebitPayment.class);
		
		suite.addTestSuite(TestID.class);
		
		suite.addTestSuite(TestMovement.class);
		suite.addTestSuite(TestMusician.class);
		
		suite.addTestSuite(TestName.class);
		suite.addTestSuite(TestPerformacedConcert.class);
		suite.addTestSuite(TestPerson.class);
		suite.addTestSuite(TestPhoneNumber.class);
		
		suite.addTestSuite(TestPostalCode.class);
		suite.addTestSuite(TestScheduledConcert.class);
		suite.addTestSuite(TestSeat.class);
		suite.addTestSuite(TestSoloist.class);
		suite.addTestSuite(TestTicket.class);
		suite.addTestSuite(TestTrasaction.class);
		suite.addTestSuite(TestVenue.class);
		suite.addTestSuite(TestVenueConcert.class);
		
		
		//$JUnit-END$
		return suite;
	}
	/**
	 * main method
	 * @param String[] args
	 * 
	 * */
	 public static void main(String[] args) {
	     //catch the period of all tests   
		 System.out.println("Executing AllTests ...");
	        junit.textui.TestRunner.run(suite());
	    }
}
