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
 * Test all methods in class Transaction
 * @author Bo
 * @version 1.0
 * */
public class TestTrasaction extends TestCase{


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
	 * Test method for {@link symphony.domain.VenueConcert#TransactionConstructor()}.
	 */
	@Test
	public void testTransactionConstructor() {
		
		Transaction transaction=new Transaction(new Date (2017,04,022),  ticket,  id, 22345, "");
		assertTrue(transaction instanceof Transaction);
	}
	
	
	/**
	 * Test method for {@link symphony.domain.Place#getTransactionDate()}.
	 */
	@Test
	public void testGetTransactionDate() {
	
		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
		assertEquals(date, transaction.getTransactionDate());
	}

	/**
	 * Test method for {@link symphony.domain.Place#setTransactionDate()}.
	 */
	@Test
	public void testSetTransactionDate() {
	
		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
	 transaction.setTransactionDate(date);
		
		assertEquals(date,  transaction.getTransactionDate());
	}
	
	/**
	 * Test method for {@link symphony.domain.Place#getTicket()}.
	 */
	@Test
	public void testGetTicket() {

		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
		assertEquals(ticket, transaction.getTicket());
	}

	/**
	 * Test method for {@link symphony.domain.Place#setTransactionDate()}.
	 */
	@Test
	public void testSetTicket() {
		
		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
	 transaction.setTicket(ticket);
		
		assertEquals(ticket,  transaction.getTicket());
	}
	
	/**
	 * Test method for {@link symphony.domain.Place#getID()}.
	 */
	@Test
	public void testGetID() {

		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
		assertEquals(id, transaction.getId());
	}

	/**
	 * Test method for {@link symphony.domain.Place#setID()}.
	 */
	@Test
	public void testSetID() {
		
		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
	 transaction.setId(id);
		
		assertEquals(id,  transaction.getId());
	}
	
	
	/**
	 * Test method for {@link symphony.domain.Place#getTerminalNumber()}.
	 */
	@Test
	public void testGetTerminalNo() {

		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
		assertEquals(22345, transaction.getTerminalNumber());
	}

	/**
	 * Test method for {@link symphony.domain.Place#setID()}.
	 */
	@Test
	public void testSetTerminalNo() {
		
		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
	 transaction.setTerminalNumber(22345);
		
		assertEquals(22345,  transaction.getTerminalNumber());
	}
	
	/**
	 * Test method for {@link symphony.domain.Place#getDescription()}.
	 */
	@Test
	public void testGetDescription() {

		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "Success");
		
		assertEquals( "Success", transaction.getDescription());
	}

	/**
	 * Test method for {@link symphony.domain.Place#setDescription()}.
	 */
	@Test
	public void testSetDescription() {
		
		Transaction transaction=new Transaction(date,  ticket,  id, 22345, "");
		
	 transaction.setDescription("not success");
		
	 assertEquals( "not success",  transaction.getDescription());
	}
	
	
	ID id = new ID("22345");
	
	Date date = new  Date (2017,04,022);
	
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

			VenueConcert vc =new VenueConcert( address,  phonenumber, seat,  concert);
			
		
			
	Ticket tk = new Ticket(new ID(" id"), 32.88, vc,  concert);
	
	ArrayList ticket = new ArrayList<Ticket>() {
		{
			add(tk);
		}};
		
		Transaction transaction=new Transaction(new Date (2017,04,022),  ticket,  id, 22345, "");
}
	
