/**
 * 
 */
package symphony.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.ID;

/**
 * class for testing ID class
 * @author Wang,Tao
 *@version 1.0
 *
 */
public class TestID extends TestCase {

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
	 * Test method for {@link symphony.domain.ID#ID(java.lang.String)}.
	 */
	@Test
	public void testID() {
		ID instance=new ID("ABC");
		assertTrue(instance.getId()=="ABC");
	}

	/**
	 * Test method for {@link symphony.domain.ID#getId()}.
	 */
	@Test
	public void testGetId() {
		//declare a object of ID
		ID instance=new ID("ABC");
		instance.setId("abc");
		//validate the result is correct or not
		assertTrue(instance.getId()=="abc");
	}

	/**
	 * Test method for {@link symphony.domain.ID#setId(java.lang.String)}.
	 */
	@Test
	public void testSetId() {
		//declare a object of ID
		ID instance=new ID("ABC");
		instance.setId("abc");
		//validate the result is correct or not
		assertTrue(instance.getId()=="abc");
	}

	/**
	 * Test method for {@link symphony.domain.ID#toString()}.
	 */
	@Test
	public void testToString() {
		//declare a object of ID
		ID instance=new ID("ABC");
		String expect="ABC";
		//validate the result is correct or not
		assertEquals(expect,instance.toString());
	}

}
