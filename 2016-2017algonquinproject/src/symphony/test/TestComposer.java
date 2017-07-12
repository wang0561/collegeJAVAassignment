/**
 * 
 */
package symphony.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.Address;
import symphony.domain.Composer;
import symphony.domain.ID;
import symphony.domain.Name;
import symphony.domain.PhoneNumber;

/**
 * class for testing composer
 * @author Wang,Tao
 * @version 1.0
 * 
 *
 */
public class TestComposer extends TestCase {

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
	 * Test method for {@link symphony.domain.Composer#Composer(symphony.domain.ID, symphony.domain.Name, symphony.domain.Address, symphony.domain.PhoneNumber)}.
	 */
	@Test
	public void testComposer() {
		//declare a new object of composer and validate if it is an instance of Composer
		Composer instance=new Composer(new Name("John","kit","M"));
		assertTrue(instance instanceof Composer);
		
		
	}

}
