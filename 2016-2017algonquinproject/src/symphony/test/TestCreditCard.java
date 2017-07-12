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
 * class for test class CreditCard
 * @author Wang
 *@version 1.0
 *
 */
public class TestCreditCard extends TestCase {

	private static final Object VISA = null;

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
	 * Test method for {@link symphony.domain.CreditCard#CreditCard(symphony.domain.CreditCard.CreditCardType, java.util.Date, int)}.
	 */
	@Test
	public void testCreditCard() {
		//declare a instance of creditcard and test if it is type of Creditcard
		CreditCard instance=new CreditCard(CreditCard.CreditCardType.VISA,new Date(0),0);
		assertTrue(instance instanceof CreditCard);
		assertEquals(instance.getCreditCardType(),CreditCard.CreditCardType.VISA);
	}

	/**
	 * Test method for {@link symphony.domain.CreditCard#getCreditCardType()}.
	 */
	@Test
	public void testGetCreditCardType() {
		//declare a instance of creditcard and test if it is type of Creditcard
				CreditCard instance=new CreditCard(CreditCard.CreditCardType.MASTER,new Date(0),0);
				assertEquals(instance.getCreditCardType(),CreditCard.CreditCardType.MASTER);
	}

	/**
	 * Test method for {@link symphony.domain.CreditCard#setCreditCardType(symphony.domain.CreditCard.CreditCardType)}.
	 */
	@Test
	public void testSetCreditCardType() {
		//declare a instance of creditcard and test if it is type of Creditcard
		CreditCard instance=new CreditCard(CreditCard.CreditCardType.MASTER,new Date(0),0);
		instance.setCreditCardType(CreditCard.CreditCardType.VISA);
		assertEquals(instance.getCreditCardType(),CreditCard.CreditCardType.VISA);
	}

	/**
	 * Test method for {@link symphony.domain.CreditCard#getExpireDate()}.
	 */
	@Test
	public void testGetExpireDate() {
		//declare and test the instance.getexpiredate() method
		Date date=new Date(0);
		CreditCard instance=new CreditCard(CreditCard.CreditCardType.MASTER,date,0);
		assertEquals(instance.getExpireDate(),date);
		
	}

	/**
	 * Test method for {@link symphony.domain.CreditCard#setExpireDate(java.util.Date)}.
	 */
	@Test
	public void testSetExpireDate() {
		//declare and test the setexpiredate() method
				Date date=new Date(0);
				CreditCard instance=new CreditCard(CreditCard.CreditCardType.MASTER,date,0);
				Date date2=new Date(5);
				instance.setExpireDate(date2);
				assertEquals(instance.getExpireDate(),date2);
	}

	/**
	 * Test method for {@link symphony.domain.CreditCard#getSecurityCode()}.
	 */
	@Test
	public void testGetSecurityCode() {
		//declare a instance of creditcard and test if it is type of Creditcard
				CreditCard instance=new CreditCard(CreditCard.CreditCardType.MASTER,new Date(0),0);
				assertEquals(instance.getSecurityCode(),0);
	}

	/**
	 * Test method for {@link symphony.domain.CreditCard#setSecurityCode(int)}.
	 */
	@Test
	public void testSetSecurityCode() {
		CreditCard instance=new CreditCard(CreditCard.CreditCardType.MASTER,new Date(0),0);
		instance.setSecurityCode(50);
		assertEquals(instance.getSecurityCode(),50);
	}

}
