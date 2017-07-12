/**
 * 
 */
package symphony.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import symphony.domain.*;

import junit.framework.TestCase;

/**
 * class for testing methods in Concert.java
 * @author Wang
 *
 */
public class TestConcert extends TestCase {

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
	 * Test method for {@link symphony.domain.Concert#Concert()}.
	 */
	@Test
	public void testConcert() {
		//declare a new object of Concert
		Concert instance = new Concert();
		//validate the result is correct or not
		assertTrue(instance instanceof Concert);
	}

	/**
	 * Test method for {@link symphony.domain.Concert#Concert(symphony.domain.ID, java.util.List)}.
	 */
	@Test
	public void testConcertIDListOfComposition() {
		//declare a new object of Concert
		Concert instance = new Concert(new ID("ABC"),new ArrayList<Composition>());
		//validate the result is correct or not
		assertTrue(instance instanceof Concert);
	}

	/**
	 * Test method for {@link symphony.domain.Concert#getConcertId()}.
	 */
	@Test
	public void testGetConcertId() {
		ID id=new ID("ABC");
		Concert instance =new Concert(id,new ArrayList<Composition>());
		ID expect=id;
		ID actual=instance.getConcertId();
		assertEquals(expect,actual);
	}

	/**
	 * Test method for {@link symphony.domain.Concert#setConcertId(symphony.domain.ID)}.
	 */
	@Test
	public void testSetConcertId() {
		//declare new id object
		ID id=new ID("ABC");
		Concert instance =new Concert();
		//set id
		instance.setConcertId(id);
		ID expect=id;
		ID actual=instance.getConcertId();
		//test result
		assertEquals(expect,actual);
	}

	/**
	 * Test method for {@link symphony.domain.Concert#getComposition()}.
	 */
	@Test
	public void testGetComposition() {
		//declare a new object of Concert
		List<Composition> list=new ArrayList<Composition>();
		Concert instance=new Concert(new ID("ABC"),list);
		List<Composition> expect=list;
		List<Composition> actual=instance.getComposition();
		//test result
		assertEquals(expect,actual);

	}

	/**
	 * Test method for {@link symphony.domain.Concert#setComposition(java.util.List)}.
	 */
	@Test
	public void testSetComposition() {
		//declare a new object of Concert
		List<Composition> list=new ArrayList<Composition>();
		Concert instance=new Concert();
		instance.setComposition(list);
		List<Composition> expect=list;
		List<Composition> actual=instance.getComposition();
		//test result
		assertEquals(expect,actual);
	}

}
