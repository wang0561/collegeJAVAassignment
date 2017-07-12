package symphony.test;

import static org.junit.Assert.*;
import symphony.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test PostalCode class method
 * @author Min Luo
 *
 */
public class TestPostalCode extends TestCase {
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test constructor for {@link symphony.domain.PostalCode#PostalCode(String)}}
	 */
	@Test
	public void testPostalCode() {
		//instantiate an instance of object
		PostalCode ps = new PostalCode("K1V2B2");
		//validate result
		assertTrue(ps instanceof PostalCode);	
	}
	

	/**
	 * Test method for {@link symphony.domain.PostalCode#computeDestination()}}
	 */
	@Test
	public void testComputeDestination() {
		//instantiate an instance of object
		PostalCode ps = new PostalCode("K1V2B2");
		PostalCode ps2 = new PostalCode("A2C3V4");
		//validate result
		assertEquals("in Eastern Ontario",ps.computeDestination());
		assertEquals("in Newfoundland",ps2.computeDestination());
	}

	/**
	 * Test method for {@link symphony.domain.PostalCode#getPostcode()}}
	 */
	@Test
	public void testGetPostcode() {
		//instantiate an instance of object
		PostalCode ps = new PostalCode("K1V2B2");
		//validate result
		assertEquals("K1V2B2", ps.getPostcode());		
	}

	/**
	 * Test method for {@link symphony.domain.PostalCode#setPostcode(String)}}
	 */
	@Test
	public void testSetPostcode() {
		//instantiate an instance of object
		PostalCode ps = new PostalCode("K1V2B2");
		ps.setPostcode("K2G4R8");
		//validate result
		assertEquals("K2G4R8", ps.getPostcode());		
	}

}
