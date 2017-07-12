/**
 * 
 */
package symphony.test;

import java.text.ParseException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.*;
/**
 * class for testing the concertSeason
 * @author Wang
 *@version 1.0
 *
 */
public class TestConcertSeason extends TestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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
	 * Test method for {@link symphony.domain.ConcertSeason#getStartDate()}.
	 */
	@Test
	public void testGetStartDate() {
		//delcare a new object of concertseason
				ConcertSeason instance= ConcertSeason.getConcertSeason();
				Date date=new Date(0);
				instance.setOpenDate(date);
				//validate the result is correct or not
				assertEquals(instance.getStartDate() , date);
	}
	/**
	 * Test method for {@link symphony.domain.ConcertSeason#setOpenDate(Date)}.
	 * 
	 */
	 
	@Test
	public void testSetOpenDate(){
		//delcare a new object of concertseason
		ConcertSeason instance= ConcertSeason.getConcertSeason();
		Date date=new Date(0);
		instance.setOpenDate(date);
		//validate the result is correct or not
		assertEquals(instance.getStartDate() , date);
	}
	

	/**
	 * Test method for {@link symphony.domain.ConcertSeason#getLength()}.
	 */
	@Test
	public void testGetLength() {
		//delcare a new object of concertseason
				ConcertSeason instance= ConcertSeason.getConcertSeason();
				instance.setLength(50);
				assertEquals(50,instance.getLength());
	}

	/**
	 * Test method for {@link symphony.domain.ConcertSeason#setLength(int)}.
	 */
	@Test
	public void testSetLength() {
		//delcare a new object of concertseason
		ConcertSeason instance= ConcertSeason.getConcertSeason();
		instance.setLength(50);
		assertEquals(50,instance.getLength());
	}

	/**
	 * Test method for {@link symphony.domain.ConcertSeason#add(symphony.domain.Concert)}.
	 */
	@Test
	public void testAddConcert() {
		//delcare a new object of concertseason
				ConcertSeason instance= ConcertSeason.getConcertSeason();
		Boolean expect=true;
		Boolean actual=instance.add(new Concert());
		assertEquals(expect,actual);
	}

	/**
	 * Test method for {@link symphony.domain.ConcertSeason#getConcertSeason()}.
	 */
	@Test
	public void testGetConcertSeason() {
		//delcare a new object of concertseason
				ConcertSeason instance= ConcertSeason.getConcertSeason();
				assertTrue(instance instanceof ConcertSeason);
	}

}
