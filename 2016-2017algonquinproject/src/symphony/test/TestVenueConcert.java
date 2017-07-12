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
import symphony.domain.Venue;
import symphony.domain.VenueConcert;


/**
 * Class for testing class VenueConcert
 * @author bo
 *@version 1.0
 *
 */

public class TestVenueConcert extends TestCase {
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
	 * Test method for {@link symphony.domain.VenueConcert#VenueConcert()}.
	 */
	@Test
	public void testVenueConcertConstructor() {
		
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		assertTrue(instance instanceof VenueConcert);
	}

	/**
	 * Test method for {@link symphony.domain.VenueConcert#VenueConcert(symphony.domain.Address, symphony.domain.Name)}.
	 */
	@Test
	public void testGetConcert() {
		
		
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		
		assertTrue(instance instanceof VenueConcert);
		assertEquals(concert, instance.getConcert());
	}

	/**
	 * Test method for {@link symphony.domain.Place#getSeat()}.
	 */
	@Test
	public void testGetSeat() {
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		assertTrue(instance instanceof VenueConcert);
		assertEquals(seat, instance.getSeat());
		
	}

	/**
	 * Test method for {@link symphony.domain.Place#setAddress(symphony.domain.Address)}.
	 */
	@Test
	public void testGetAddress() {
		
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		
		assertTrue(instance instanceof VenueConcert);
		assertEquals(address, instance.getAddress());
	}

	/**
	 * Test method for {@link symphony.domain.Place#getPhonenumber()}.
	 */
	@Test
	public void testGetPhonenumber() {
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		
		assertEquals(phonenumber, instance.getPhonenumber());
	}

	/**
	 * Test method for {@link symphony.domain.Place#setConcert(symphony.domain.Name)}.
	 */
	@Test
	public void testSetConcert() {
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		//declare object of place
		
		instance.setConcert(concert);
		//validate the result is correct or not
		assertEquals(concert, instance.getConcert());
	}

	/**
	 * Test method for {@link symphony.domain.Place#setSeat()}.
	 */
	@Test
	public void testSetSeat() {
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		//declare object of place
		
		instance.setSeat(seat);
		//validate the result is correct or not
		assertEquals(seat, instance.getSeat());
	}
	
	/**
	 * Test method for {@link symphony.domain.Place#setSeat()}.
	 */
	@Test
	public void testSetPhoneNo() {
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		//declare object of place
		
		instance.setPhonenumber(phonenumber);
		//validate the result is correct or not
		assertEquals(phonenumber, instance.getPhonenumber());
	}
	
	/**
	 * Test method for {@link symphony.domain.Place#setSeat()}.
	 */
	@Test
	public void testSetAddress() {
		VenueConcert instance=new VenueConcert( address,  phonenumber, seat,  concert);
		//declare object of place
		
		instance.setAddress(address);;
		//validate the result is correct or not
		assertEquals(address, instance.getAddress());
	}
	
	
	Address address=new Address("102","Abc Street","ottawa","ON",new PostalCode("K2J 5T1"));
	PhoneNumber ph1= new PhoneNumber(613,227,6130,3344);
	List<PhoneNumber> phonenumber = new ArrayList<PhoneNumber>() {
		{
			add(ph1);
		}} ;
		List<Seat> seat = new ArrayList<Seat>() { {
			add(new Seat(false, 22, 33));
		}};
		Venue venue1 = new Venue(
				new Address("1355 ", "Woodroffe ", "Ottawa ", "ON ", new PostalCode("K1L2A2")),
					new ArrayList<PhoneNumber>() {
					{
						add(ph1);
					}}	);
		
		Soloist soloist1 = new Soloist(new ID("soloist1"), new Name("Wang", "Tao", "Mr"),
				new Address("875 ", "Heron ", "Ottawa ", "ON ", new PostalCode("K2L2A2")), new PhoneNumber(613,227,6130,3344),
				new ArrayList<String>() {
					{
						add("sax");
					}
				});
		Conductor conductor1 = new Conductor(new ID("conductor1"), new Name("Sungwon", "Lee", "MR"),
				new Address("66 ", "Slater ", "Ottawa ", "ON ",new PostalCode("K1L2A2")), new PhoneNumber(613,727,8888,333));
		Date concertStartDate1 = new Date (2017,04,022);
			
			ScheduledConcert sc= new ConcertBuilder(new ID("composition2")).conductor(conductor1).date(concertStartDate1)
					.soloist(new ArrayList<Soloist>() {
						{
							add(soloist1);
						}
					}).venue(venue1).build();
		
			List<Concert> concert = new ArrayList<Concert>(){{
				add (sc);
			}};

}
