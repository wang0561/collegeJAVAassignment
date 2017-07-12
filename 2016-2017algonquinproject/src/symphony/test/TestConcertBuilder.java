/**
 * 
 */
package symphony.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import symphony.domain.*;

import junit.framework.TestCase;

/**
 * Class for testing methods in ConcertBuilder.java
 * @author Wang
 *
 */
public class TestConcertBuilder extends TestCase {

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
	 * Test method for {@link symphony.domain.ConcertBuilder#ConcertBuilder(symphony.domain.ID)}.
	 */
	@Test
	public void testConcertBuilder() {
		//declare a new object and test if it is an instance of the ConcertBuilder
		ID id=new ID("ABC");
		ConcertBuilder instance=new ConcertBuilder(id);
		assertTrue(instance instanceof ConcertBuilder);
		assertEquals(instance.build().getConcertId(),id);
	}

	/**
	 * Test method for {@link symphony.domain.ConcertBuilder#conductor(symphony.domain.Conductor)}.
	 */
	@Test
	public void testConductor() {
		ID id=new ID("ABC");
		//declare a new object of concertbuilder
		ConcertBuilder instance=new ConcertBuilder(id);
		Conductor conductor=new Conductor(id,null,null,null);
		ConcertBuilder expect=instance.conductor(conductor);
		//validate the result is correct or not
		assertEquals(expect, instance);
	}

	/**
	 * Test method for {@link symphony.domain.ConcertBuilder#date(java.sql.Date)}.
	 */
	@Test
	public void testDate() {
		ID id=new ID("ABC");
		//declare a new object of concertbuilder
		ConcertBuilder instance=new ConcertBuilder(id);
		Date date =new Date(0);
		ConcertBuilder expect=instance.date(date);
		//validate the result is correct or not
		assertEquals(expect, instance);
	}

	/**
	 * Test method for {@link symphony.domain.ConcertBuilder#venue(symphony.domain.Venue)}.
	 */
	@Test
	public void testVenue() {
		ID id=new ID("ABC");
		//declare a new object of concertbuilder
		ConcertBuilder instance=new ConcertBuilder(id);
		Venue venue=new Venue(new Address(),new ArrayList<PhoneNumber>());
		ConcertBuilder expect=instance.venue(venue);
		//validate the result is correct or not
		assertEquals(expect, instance);
	}

	/**
	 * Test method for {@link symphony.domain.ConcertBuilder#soloist(java.util.List)}.
	 */
	@Test
	public void testSoloist() {
		ID id=new ID("ABC");
		//declare a new object of concertbuilder
		ConcertBuilder instance=new ConcertBuilder(id);
		List<Soloist> list=new ArrayList<Soloist>();
		ConcertBuilder expect=instance.soloist(list);
		assertEquals(expect, instance);
	}

	/**
	 * Test method for {@link symphony.domain.ConcertBuilder#build()}.
	 */
	@Test
	public void testBuild() {
		ID id=new ID("ABC");
		//declare a new object of concertbuilder
		ConcertBuilder instance=new ConcertBuilder(id);
		
		//test result
		assertTrue(instance.build() instanceof ScheduledConcert);
	}

}
