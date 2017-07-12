/**
 * 
 */
package symphony.test;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.*;
/**
 * class for test class creditpayment
 * @author Wang
 * @version 1.0
 * 
 *
 */
public class TestCreditPayment extends TestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

	/**
	 * Test method for {@link symphony.domain.CreditPayment#CreditPayment(symphony.domain.CreditCard)}.
	 */
	@Test
	public void testCreditPayment() {
		CreditCard card=new CreditCard(CreditCard.CreditCardType.VISA,new Date(0),0);
		CreditPayment instance =new CreditPayment(card);
		//Test if it is a instance of the creditpayment
		assertTrue(instance instanceof CreditPayment);
		assertEquals(instance.getCreditCard(),card);
	}

	/**
	 * Test method for {@link symphony.domain.CreditPayment#getCreditCard()}.
	 */
	@Test
	public void testGetCreditCard() {
		CreditCard card=new CreditCard(CreditCard.CreditCardType.VISA,new Date(0),0);
		CreditPayment instance =new CreditPayment(card);
		assertEquals(card,instance.getCreditCard());
		
	}

	/**
	 * Test method for {@link symphony.domain.CreditPayment#setCreditCard(symphony.domain.CreditCard)}.
	 */
	@Test
	public void testSetCreditCard() {
		//test setcreidtcard method
		CreditCard card=new CreditCard(CreditCard.CreditCardType.VISA,new Date(0),0);
		CreditCard card2=new CreditCard(CreditCard.CreditCardType.MASTER,new Date(5),50);
		CreditPayment instance =new CreditPayment(card);
		instance.setCreditCard(card2);
		assertEquals(card2,instance.getCreditCard());
	}

	/**
	 * Test method for {@link symphony.domain.CreditPayment#pay(double)}.
	 */
	@Test
	public void testPay() {
		
	}

}
