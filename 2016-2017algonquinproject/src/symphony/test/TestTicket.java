package symphony.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.Address;
import symphony.domain.Concert;
import symphony.domain.ConcertBuilder;
import symphony.domain.Conductor;
import symphony.domain.ID;
import symphony.domain.Name;
import symphony.domain.PhoneNumber;
import symphony.domain.PostalCode;
import symphony.domain.ScheduledConcert;
import symphony.domain.Seat;
import symphony.domain.Soloist;
import symphony.domain.Ticket;
import symphony.domain.Transaction;
import symphony.domain.Venue;
import symphony.domain.VenueConcert;

/**
 * Class for testing class
 * @author Bo
 *@version 1.0
 *
 *
 */

public class TestTicket extends TestCase{
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
	 * Test method for {@link symphony.domain.Ticket#Ticket()}.
	 */
	@Test
	public void testTicketConstructor() {
		
		
		assertTrue(tk instanceof Ticket);
	}


	/**
	 * Test method for {@link symphony.domain.Place#getID(symphony.domain.Ticket)}.
	 */
	/**
	 * Test method for {@link symphony.domain.Tikcket#getID()}.
	 */
	@Test
	public void testGetID() {

		
		
		assertEquals(id, tk.getId());
	}

	/**
	 * Test method for {@link symphony.domain.Ticket#setID()}.
	 */
	@Test
	public void testSetID() {
		
		
		
	 tk.setId(id);
		
		assertEquals(id,  tk.getId());
	}
	
	
	
	/**
	 * Test method for {@link symphony.domain.Ticket#getTicketPrice()}.
	 */
	@Test
	public void testGetPrice() {
			
		//validate the result is correct or not
		assertEquals(32.88, tk.getTicketPrice());
	}
	
	/**
	 * Test method for {@link symphony.domain.Ticket#setTicketPrice()}.
	 */
	@Test
	public void testSetPrice() {

		//Set Price object of place
		
		tk.setTicketPrice(55.55);
		//validate the result is correct or not
		assertEquals(55.55, tk.getTicketPrice());
	}
	
	
	/**
	 * Test method for {@link symphony.domain.Ticket#getVenue()}.
	 */
	@Test
	public void testGetVenue() {
			
		//validate the result is correct or not
		assertEquals(vc, tk.getVenue());
	}
	
	/**
	 * Test method for {@link symphony.domain.Ticket#setTicketPrice()}.
	 */
	@Test
	public void testSetVenue() {

		//Set Price object of place
		
		tk.setVenue(vc);
		//validate the result is correct or not
		assertEquals(vc, tk.getVenue());
	}
	
	
	/**
	 * Test method for {@link symphony.domain.Ticket#getVenue()}.
	 */
	@Test
	public void testGetConcert() {
			
		//validate the result is correct or not
		assertEquals(concert, tk.getConcert());
	}
	
	/**
	 * Test method for {@link symphony.domain.Ticket#setTicketPrice()}.
	 */
	@Test
	public void testSetConcert() {

		//Set Price object of place
		
		tk.setConcert(concert);
		//validate the result is correct or not
		assertEquals(concert, tk.getConcert());
	}

	//instantiate ID
	ID id = new ID("22345");
	//instantiate date
	Date date = new  Date (2017,04,022);
	//instantiate address
	Address address=new Address("102","Abc Street","ottawa","ON",new PostalCode("K2J 5T1"));
	//instantiate PhoneNumber
	PhoneNumber ph1= new PhoneNumber(613,227,6130,3344);
	//instantiate list PhoneNumber
	List<PhoneNumber> phonenumber = new ArrayList<PhoneNumber>() {
		{
			add(ph1);
		}} ;
		List<Seat> seat = new ArrayList<Seat>() { {
			add(new Seat(false, 22, 33));
		}};
		//instantiate Venue
		Venue venue1 = new Venue(
				new Address("1355 ", "Woodroffe ", "Ottawa ", "ON ", new PostalCode("K1L2A2")),
					new ArrayList<PhoneNumber>() {
					{
						add(ph1);
					}}	);
		//instantiate Soloist
		Soloist soloist1 = new Soloist(new ID("soloist1"), new Name("Wang", "Tao", "Mr"),
				new Address("875 ", "Heron ", "Ottawa ", "ON ", new PostalCode("K2L2A2")), new PhoneNumber(613,227,6130,3344),
				new ArrayList<String>() {
					{
						add("sax");
					}
				});
		//instantiate Conductor
		Conductor conductor1 = new Conductor(new ID("conductor1"), new Name("Sungwon", "Lee", "MR"),
				new Address("66 ", "Slater ", "Ottawa ", "ON ",new PostalCode("K1L2A2")), new PhoneNumber(613,727,8888,333));
		Date concertStartDate1 = new Date (2017,04,022);
		
		//instantiate Scheduled concert	
			ScheduledConcert sc= new ConcertBuilder(new ID("composition2")).conductor(conductor1).date(concertStartDate1)
					.soloist(new ArrayList<Soloist>() {
						{
							add(soloist1);
						}
					}).venue(venue1).build();
			//instantiate list concert
			List<Concert> concert = new ArrayList<Concert>(){{
				add (sc);
			}};

			//instantiate VenueConcert
			VenueConcert vc =new VenueConcert( address,  phonenumber, seat,  concert);
			
			//instantiate Ticket		
			Ticket tk = new Ticket(id, 32.88, vc,  concert);
}