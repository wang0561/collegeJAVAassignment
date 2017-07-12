/**
 * 
 */
package symphony.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.Address;
import symphony.domain.Composer;
import symphony.domain.Composition;
import symphony.domain.CompositionBuilder;
import symphony.domain.ID;
import symphony.domain.Movement;
import symphony.domain.Name;
import symphony.domain.PhoneNumber;
import symphony.domain.Soloist;

/**
 * class for testing the composition class
 * @author Wang
 *@version 1.0
 *
 */
public class TestComposition extends TestCase {

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
	 * Test method for {@link symphony.domain.Composition#Composition(symphony.domain.CompositionBuilder)}.
	 */
	@Test
	public void testComposition() {
		//declare a new object of Composition and validte if it is an instance of Composition
		ID id=new ID("abc");
		CompositionBuilder builder=new CompositionBuilder(id);
		Composition instance=new Composition(builder);
		//valide the result
		assertTrue(instance instanceof Composition);
		assertEquals(id,instance.getCompositionID());
		
		
	}

	/**
	 * Test method for {@link symphony.domain.Composition#getCompositionID()}.
	 */
	@Test
	public void testGetCompositionID() {
		//declare a new object of Composition
		Composition instance=new Composition(new CompositionBuilder(new ID("abc")));
		ID id=new ID("abc");
		instance.setCompositionID(id);
		ID expectResult=id;
		assertEquals(expectResult,instance.getCompositionID());

	}

	/**
	 * Test method for {@link symphony.domain.Composition#setCompositionID(symphony.domain.ID)}.
	 */
	@Test
	public void testSetCompositionID() {
		//declare a new object of Composition
		Composition instance=new Composition(new CompositionBuilder(new ID("abc")));
		ID id=new ID("abc");
		instance.setCompositionID(id);
		ID expectResult=id;
		//valide the result
		assertEquals(expectResult,instance.getCompositionID());
	}




	/**
	 * Test method for {@link symphony.domain.Composition#getComposer()}.
	 */
	@Test
	public void testGetComposer() {
		//declare a new object of Composition
		Composition instance=new Composition(new CompositionBuilder(new ID("abc")));
		Composer composer=new Composer(new Name("wang","Tao","Mr"));
		instance.setComposer(composer);
		Composer expectResult=composer;
		//valide the result
		assertEquals(expectResult,instance.getComposer());

	}

	/**
	 * Test method for {@link symphony.domain.Composition#setComposer(symphony.domain.Composer)}.
	 */
	@Test
	public void testSetComposer() {
		//declare a new object of Composition
		Composition instance=new Composition(new CompositionBuilder(new ID("abc")));
		Composer composer=new Composer(new Name("wang","Tao","Mr"));
		instance.setComposer(composer);
		Composer expectResult=composer;
		//valide the result
		assertEquals(expectResult,instance.getComposer());

	}





	/**
	 * Test method for {@link symphony.domain.Composition#getMovement()}.
	 */
	@Test
	public void testGetMovement() {
		//declare a new object of Composition
		
		ID id=new ID("abc");
		CompositionBuilder builder=new CompositionBuilder(id);
		Composition instance=new Composition(builder);
		List<Movement> list=new ArrayList<Movement>();
		List<Movement> expect=list;
		instance.setMovement(list);
		//valide the result
		assertEquals(expect,instance.getMovement());
	}

	/**
	 * Test method for {@link symphony.domain.Composition#setMovement(java.util.List)}.
	 */
	@Test
	public void testSetMovement() {
		//declare a new object of Composition
	
		ID id=new ID("abc");
		CompositionBuilder builder=new CompositionBuilder(id);
		Composition instance=new Composition(builder);
		List<Movement> list=new ArrayList<Movement>();
		List<Movement> expect=list;
		instance.setMovement(list);
		//valide the result
		assertEquals(expect,instance.getMovement());
	}

}
