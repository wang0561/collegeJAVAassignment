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
 * class for testing Musician 
 * @author Wang
 *@version 1.0
 *
 */
public class TestMusician extends TestCase {

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
	 * Test method for {@link symphony.domain.Musician#Musician(symphony.domain.ID, symphony.domain.Name, symphony.domain.Address, symphony.domain.PhoneNumber)}.
	 */
	@Test
	public void testMusician() {
		Musician instance =new Musician(new ID("ABC"),new Name(),new Address(),new PhoneNumber(001,613,697,3815));
		assertTrue(instance instanceof Musician);
	}

}
