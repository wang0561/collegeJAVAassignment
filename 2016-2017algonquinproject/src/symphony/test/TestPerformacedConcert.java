/**
 * 
 */
package symphony.test;

import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.*;
/**
 * Class for testing PerformancedConcert
 * @author Wang
 * @version 1.0
 * 
 *
 */
public class TestPerformacedConcert extends TestCase {

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
	 * Test method for {@link symphony.domain.PerformedConcert#PerformedConcert(symphony.domain.ID, java.util.List, symphony.domain.Conductor, java.util.List, symphony.domain.Venue, java.sql.Date)}.
	 * @throws ParseException 
	 */
	@Test
	public void testPerformedConcert() throws ParseException {
		try{
			boolean result=true;
			boolean result2=false;
			List<Composition> list1=new ArrayList<Composition>();
			List<Soloist> list2=new ArrayList<Soloist>();

			PerformedConcert instance=
					new PerformedConcert(new ID("abc"),list1,
							new Conductor(new ID("abc"),new Name(null,null,null),new Address(),new PhoneNumber(001,613,623,1234)),
							list2,new Venue(new Address(),new ArrayList<>()),new Date(2017,04,05));
			assertEquals(instance.isPormaned(),result);
		}catch(Exception e){}

	}
	/**
	 * Test method for{@link symphony.domain.PerformedConcert#isPerformed()}
	 * */
	@Test
	public void testisPerformed(){
		try{
			boolean result=true;
			boolean result2=false;
			List<Composition> list1=new ArrayList<Composition>();
			List<Soloist> list2=new ArrayList<Soloist>();

			PerformedConcert instance=
					new PerformedConcert(new ID("abc"),list1,
							new Conductor(new ID("abc"),new Name(null,null,null),new Address(),new PhoneNumber(001,613,623,1234)),
							list2,new Venue(new Address(),new ArrayList<>()),new Date(2017,04,31));
			assertEquals(instance.isPormaned(),result2);
		}catch(Exception e){}
	}
}
