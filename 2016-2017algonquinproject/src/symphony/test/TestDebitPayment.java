/**
 * 
 */
package symphony.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.*;
/**
 * Class for test DebitPayment
 * @author Wang
 *@version 1.0
 *
 */
public class TestDebitPayment extends TestCase {

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
	 * Test method for {@link symphony.domain.DebitPayment#DebitPayment(symphony.domain.DebitCard)}.
	 */
	@Test
	public void testDebitPayment() {
		DebitCard card=new DebitCard(new Name("TDtrust","card",null),123456);
		DebitPayment instance=new DebitPayment(card);
		assertTrue(instance instanceof DebitPayment);
		assertEquals(instance.getDebitCard(),card);
	}

	/**
	 * Test method for {@link symphony.domain.DebitPayment#getDebitCard()}.
	 */
	@Test
	public void testGetDebitCard() {
		DebitCard card=new DebitCard(new Name("TDtrust","card",null),123456);
		DebitPayment instance=new DebitPayment(card);
		//test result
		assertEquals(instance.getDebitCard(),card);
	}

	/**
	 * Test method for {@link symphony.domain.DebitPayment#setDebitCard(symphony.domain.DebitCard)}.
	 */
	@Test
	public void testSetDebitCard() {
		DebitCard card=new DebitCard(new Name("TDtrust","card",null),123456);
		DebitCard card2=new DebitCard(new Name("BMO","card",null),1234563445);
		DebitPayment instance=new DebitPayment(card);
		//test result
		instance.setDebitCard(card2);
		assertEquals(instance.getDebitCard(),card2);
	}

	/**
	 * Test method for {@link symphony.domain.DebitPayment#pay(double)}.
	 */
	@Test
	public void testPay() {
		//test in when code finish
	}

}
