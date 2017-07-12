/**
 * 
 */
package symphony.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.Conductor;

/**
 * class for testing conductor
 * @author Wang,Tao
 *@version 1.0
 *
 */
public class TestConductor extends TestCase {

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
	 * Test method for {@link symphony.domain.Conductor#Conductor(symphony.domain.ID, symphony.domain.Name, symphony.domain.Address, symphony.domain.PhoneNumber)}.
	 */
	@Test
	public void testConductor() {
		//declare a new object of conduct and validet it is an instance of conductor
		Conductor instance=new Conductor(null,null,null,null);
		assertTrue(instance instanceof Conductor);
	}

}
