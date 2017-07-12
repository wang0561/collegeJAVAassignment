package symphony.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.Address;
import symphony.domain.PhoneNumber;
import symphony.domain.PostalCode;
import symphony.domain.Seat;
import symphony.domain.Venue;

/**
 * Class for testing class Venue
 * @author Bo
 *@version 1.0
 *
 *
 */

public class TestVenue extends TestCase{
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
	public void testVenueConstructor() {
		
		Venue instance=new Venue( address,  phonenumber);
		assertTrue(instance instanceof Venue);
	}


	/**
	 * Test method for {@link symphony.domain.Place#setAddress(symphony.domain.Address)}.
	 */
	@Test
	public void testGetAddress() {
		
		Venue instance=new Venue( address,  phonenumber);
		
		assertEquals(address, instance.getAddress());
	}

	/**
	 * Test method for {@link symphony.domain.Place#getPhonenumber()}.
	 */
	@Test
	public void testGetPhonenumber() {
		Venue instance=new Venue( address,  phonenumber);
		
		assertEquals(phonenumber, instance.getPhonenumber());
	}

	
	
	/**
	 * Test method for {@link symphony.domain.Place#setSeat()}.
	 */
	@Test
	public void testSetPhoneNo() {
		Venue instance=new Venue( address,  phonenumber);
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
		Venue instance=new Venue( address,  phonenumber);
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
				new Address("1355 ", "Woodroffe ", "Ottawa ", "ON ", new PostalCode("K1L 2A2")),
					new ArrayList<PhoneNumber>() {
					{
						add(ph1);
					}}	);
		
		

}