package symphony.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import symphony.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test ScheduledConcert class methods
 * @author Min Luo
 *
 */
public class TestScheduledConcert extends TestCase{
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	private ScheduledConcert instance;
	private Conductor conductor;
	private Venue venue;
	private Date date;
	private List<Soloist> solo;
	@Before
	public void setUp() throws Exception {
		super.setUp();
		ID id = new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phone = new PhoneNumber(001, 613, 900,712 );
		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		List<Composition> composition = new ArrayList<Composition>();
		conductor = new Conductor(id, name, address, phone);
		solo = new ArrayList<Soloist>();
		venue = new Venue(address, phones);
		date = new Date(0);
		// validate result
		instance = new ScheduledConcert(id, composition, conductor, solo,venue, date);
		assertTrue(instance instanceof ScheduledConcert);		
	}

	
	/*
	 *(non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Test constructor for {@link symphony.domain.ScheduledConcert#ScheduledConcert(ConcertBuilder)}.
	 */
	@Test
	public void testScheduledConcertConcertBuilder() {
		ID id = new ID("0001");
		ConcertBuilder builder = new ConcertBuilder(id);
		//create instance of ScheduledConcert
		ScheduledConcert instance = new ScheduledConcert(builder);
		//validate result
		assertTrue(instance instanceof ScheduledConcert);
	}

	/**
	 * Test constructor for {@link symphony.domain.ScheduledConcert#ScheduledConcert(ID, java.util.List, Conductor, java.util.List, Venue, java.sql.Date)}}.
	 * @throws ParseException 
	 */
	@Test
	public void testScheduledConcertIDListOfCompositionConductorListOfSoloistVenueDate() throws ParseException {
		ID id = new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phone = new PhoneNumber(001, 613, 900,712 );
		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		List<Composition> composition = new ArrayList<Composition>();
		Conductor conductor = new Conductor(id, name, address, phone);
		List<Soloist> solo = new ArrayList<Soloist>();
		Venue venue = new Venue(address, phones);
		Date date = new Date(0);
		// validate result
		ScheduledConcert instance = new ScheduledConcert(id, composition, conductor, solo,venue, date);
		assertTrue(instance instanceof ScheduledConcert);
		
	}

	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#GetConductor()}.
	 */
	@Test
	public void testGetConductor() {
		
		//validate result
		assertEquals(conductor,instance.getConductor());
	}
	
	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#setConductor(symphony.domain.Conductor)}
	 */
	@Test
	public void testSetConductor() {
		// create an instance of Conductor
		ID id = new ID("0003");
		Name name = new Name("Sara", "Javis","Mrs");
		PostalCode post = new PostalCode("K2G4R8");
		Address address = new Address("100","Bank Street","Ottawa","ON",post);
		PhoneNumber phone = new PhoneNumber(001,718, 312,712 );
		Conductor conductor2 = new Conductor(id, name, address, phone);
		// validate result
		instance.setConductor(conductor2);
		assertEquals(conductor2, instance.getConductor());
	}

	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#getVenue()}
	 */
	@Test
	public void testGetVenue() {
		//validate result
		assertEquals(venue,instance.getVenue());
	}

	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#setVenue(symphony.domain.Venue)}
	 */
	@Test
	public void testSetVenue() {
		// create instance of Venue
		PostalCode post2 = new PostalCode("K2G4R8");
		Address address2 = new Address("100","Bank Street","Ottawa","ON",post2);
		PhoneNumber phone2 = new PhoneNumber(001,718, 312,712 );
		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		Venue venue2 = new Venue(address2, phones);
		instance.setVenue(venue2);
		assertEquals(venue2, instance.getVenue());
	}
	
	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#getDate()}
	 */
	@Test
	public void testGetDate() {
		// validate result
		assertEquals(date, instance.getDate());
	}

	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#setDate(java.sql.Date)}
	 */
	@Test
	public void testSetDate() {
		// create instance of Date
		Date date2 = new Date(0);
		instance.setDate(date2);
		//validate result
		assertEquals(date2, instance.getDate());
	}

	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#getSoloist()}
	 */
	@Test
	public void testGetSoloist() {
		//validate result
		assertEquals(solo, instance.getSoloist());
	}
	
	/**
	 * Test method for {@link symphony.domain.ScheduledConcert#setSoloist(java.util.List)}
	 */
	@Test
	public void testSetSoloist() {
		//create instance of List<Soloist>
		List<Soloist> solo2 = new ArrayList<Soloist>();
		instance.setSoloist(solo2);
		//validate result
		assertEquals(solo2, instance.getSoloist());
		
	}
	

}
