package symphony.test;
import static org.junit.Assert.*;
import symphony.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
/**
 * Test PhoneNumber class methods
 * @author Min Luo
 *
 */
public class TestPhoneNumber extends TestCase {
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
	 * Test method for {@link symphony.domain.PhoneNumber#PhoneNumber(symphony.domain.int, symphony.domain.int, symphony.domain.int, symphony.domain.int)}}.
	 */
	@Test
	public void testPhoneNumber() {
		//declare the phoneNumber object
		PhoneNumber instance = new PhoneNumber(001, 613, 900,712 );
	    //validate the result is correct or not
	    assertTrue(instance instanceof PhoneNumber);	  
	}
	
	/**
	 * Test method for {@link symphony.domain.PhoneNumber#toString()}.
	 */
	@Test
	public void testToString() {
		//declare the phoneNumber object
		PhoneNumber instance = new PhoneNumber(001, 613,900,712 );
		//validate the result is correct or not	
	    assertEquals("(00001)(613) 900-0712",instance.toString());
	}

}
