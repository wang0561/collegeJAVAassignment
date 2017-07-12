/**
 * 
 */
package symphony.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import symphony.domain.*;

import junit.framework.TestCase;

/**
 * class for testing the compositionBuilder
 * @author Wang,Tao
 * @version 1.0
 * 
 *
 */
public class TestCompositionBuilder extends TestCase {

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
	 * Test method for {@link symphony.domain.CompositionBuilder#CompositionBuilder(symphony.domain.ID, symphony.domain.Name)}.
	 */
	@Test
	public void testCompositionBuilder() {
		//declare a new object of compositonBuilder
		ID id=new ID("abc");
		CompositionBuilder instance=new CompositionBuilder(id);
		//validate the result is correct or not
		assertTrue(instance instanceof CompositionBuilder);
		assertEquals(id,instance.build().getCompositionID());
		
	}

	/**
	 * Test method for {@link symphony.domain.CompositionBuilder#composer(symphony.domain.Composer)}.
	 */
	@Test
	public void testComposer() {
		ID id=new ID("abc");
		Name name=new Name("Wang","Tao","Mr");
		//declare a new object of compositonBuilder
		CompositionBuilder instance=new CompositionBuilder(id);
		Composer composer=new Composer(name);
		CompositionBuilder expect=instance.composer(composer);
		//validate the result is correct or not
		assertEquals(expect,instance);

	}



	/**
	 * Test method for {@link symphony.domain.CompositionBuilder#movement(java.util.ArrayList)}.
	 */
	@Test
	public void testMovement() {
		ID moveid=new ID("123");
		ID id=new ID("abc");
		Name name=new Name("Wang","Tao","Mr");
		//declare a new object of compositonBuilder
		CompositionBuilder instance=new CompositionBuilder(id);
		Movement movement=new Movement(moveid);
		ArrayList<Movement> list=new ArrayList<Movement>();
		list.add(movement);
		//declare a expect object
		CompositionBuilder expect=instance.movement(list);
		//validate the result is correct or not
		assertEquals(expect,instance);
	}

	/**
	 * Test method for {@link symphony.domain.CompositionBuilder#build()}.
	 */
	@Test
	public void testBuild() {
		ID id=new ID("abc");
		//declare a new object of compositonBuilder
		CompositionBuilder instance=new CompositionBuilder(id);
		//validate the result is correct or not
		assertTrue(instance instanceof CompositionBuilder);
			
	}

}
