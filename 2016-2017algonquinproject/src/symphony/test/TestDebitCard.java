/**
 * 
 */
package symphony.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import symphony.domain.*;

import junit.framework.TestCase;

/**
 * Class for testing Class DebitCard
 * @author Wang
 *@version 1.0
 *
 */
public class TestDebitCard extends TestCase {

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
	 * Test method for {@link symphony.domain.DebitCard#DebitCard(symphony.domain.Name, long)}.
	 */
	@Test
	public void testDebitCard() {
		//delcare a instance of DebitCard and test if it is an instanceof
		Name name=new Name();
		DebitCard instance=new DebitCard(name,50);
		assertTrue(instance instanceof DebitCard);
		assertEquals(instance.getName(),name);
		assertEquals(instance.getAccountNO(),50);
	}

	/**
	 * Test method for {@link symphony.domain.DebitCard#getName()}.
	 */
	@Test
	public void testGetName() {
		Name name=new Name("TDtrust","card",null);
		DebitCard instance=new DebitCard(name,50);
		assertEquals(name,instance.getName());
	}

	/**
	 * Test method for {@link symphony.domain.DebitCard#setName(symphony.domain.Name)}.
	 */
	@Test
	public void testSetName() {
		Name name=new Name("TDtrust","card",null);
		DebitCard instance=new DebitCard(new Name(),50);
		instance.setName(name);
		assertEquals(name,instance.getName());
	}

	/**
	 * Test method for {@link symphony.domain.DebitCard#getAccountNO()}.
	 */
	@Test
	public void testGetAccountNO() {
		Name name=new Name("TDtrust","card",null);
		DebitCard instance=new DebitCard(new Name(),50234242);
		//test result
		assertEquals(50234242,instance.getAccountNO());
	}

	/**
	 * Test method for {@link symphony.domain.DebitCard#setAccountNO(long)}.
	 */
	@Test
	public void testSetAccountNO() {
		Name name=new Name("TDtrust","card",null);
		DebitCard instance=new DebitCard(new Name(),50234242);
		instance.setAccountNO(123456);
		//test result
		assertEquals(123456,instance.getAccountNO());
	}

}
