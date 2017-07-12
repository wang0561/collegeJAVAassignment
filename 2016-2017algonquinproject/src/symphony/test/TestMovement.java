/**
 * 
 */
package symphony.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.*;

import symphony.domain.Name;

/**
 * Junit class for testing class of movement
 * @author Wang, Tao
 *@version 1.0
 *
 */
public class TestMovement extends TestCase{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link symphony.domain.Movement#Movement(symphony.domain.ID, symphony.domain.Name)}.
	 */
	@Test
	public void testMovement() {
		//delcare a object of movement
		
		ID id=new ID("ABC");
		Movement instance=new Movement(id);
		//validate the result is correct or not
		assertTrue(instance instanceof Movement);
		assertEquals(instance.getMovementID(),id);
		
	}

	/**
	 * Test method for {@link symphony.domain.Movement#getMovementID()}.
	 */
	@Test
	public void testGetMovementID() {
		//delcare a object of movement
		ID id=new ID("ABC");
		Movement instance=new Movement(null);
		instance.setMovementID(id);
		//validate the result is correct or not
		assertEquals(id, instance.getMovementID());
	}

	/**
	 * Test method for {@link symphony.domain.Movement#setMovementID(symphony.domain.ID)}.
	 */
	@Test
	public void testSetMovementID() {
		ID id=new ID("ABC");
		//delcare a object of movement
		Movement instance=new Movement(null);
		instance.setMovementID(id);
		//validate the result is correct or not
		assertEquals(id, instance.getMovementID());
	}



}
