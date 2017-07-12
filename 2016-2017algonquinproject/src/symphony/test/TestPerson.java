package symphony.test;

import static org.junit.Assert.*;
import symphony.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
/**
 * Test Person Class methods
 * @author Min Luo
 *
 */
public class TestPerson extends TestCase{
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 *  test constructor for {@link symphony.domain.Person#Person(symphony.domain.Name)}.
	 */
	@Test
	public void testPersonName() {
		Name name = new Name("Jack", "Chen","Mr");
		// instantiate an instance of Person
		Composer instance = new Composer(name);
		// validate the result
		assertTrue(instance instanceof Person);
	}
	
	/**
	 *  test constructor for {@link symphony.domain.Person#Person(symphony.domain.Name, symphony.domain.Address, symphony.domain.PhoneNumber)}.
	 */
	@Test
	public void testPersonNameAddressPhoneNumber() {
		ID id = new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phone = new PhoneNumber(001, 613, 900,712 );
		// instantiate an instance of Person
		Conductor conduct = new Conductor(id,name, address, phone);
		// validate result
		assertTrue(conduct instanceof Person);
	}
	
	/**
	 * test constructor for {@link symphony.domain.Person#Person(symphony.domain.ID,symphony.domain.Name, symphony.domain.Address, symphony.domain.PhoneNumber)}.
	 */
	@Test
	public void testPersonIDNameAddressPhoneNumber() {
		ID id = new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phone = new PhoneNumber(001, 613, 900 ,712 );
		// instantiate an instance of Person
		Conductor conductor = new Conductor(id,name, address, phone);
		//validate the result
		assertTrue(conductor instanceof Person);
	}

	/**
	 * test constructor for {@link symphony.domain.Person#GetId(symphony.domain.ID))}.
	 */
	@Test
	public void testGetId() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		//validate the result is correct or not
		assertEquals(id,instance.getId());
	}

	/**
	 * Test method for {@link symphony.domain.Person#setId(symphony.domain.ID)}.
	 */
	@Test
	public void testSetId() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		assertEquals(id,instance.getId());
		ID id2 =new ID("0004");
		instance.setId(id2);
		//validate the result is correct or not
		assertEquals(id2,instance.getId());
	}
	
	/**
	 * Test method for {@link symphony.domain.Person#getName()})}.
	 */
	@Test
	public void testGetName() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		//validate the result is correct or not
		assertEquals(name, instance.getName());
	}
	
	/**
	 * Test method for {@link symphony.domain.Person#setName(symphony.domain.Name)}.
	 */
	@Test
	public void testSetName() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		assertEquals(name, instance.getName());
		Name name02 = new Name("Sara", "Jarvis","Miss");
		instance.setName(name02);
		//validate the result is correct or not
		assertEquals(name02,instance.getName());
	}

	/**
	 * Test method for {@link symphony.domain.Person#getAddress()}.
	 */
	@Test
	public void testGetAddress() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		//validate the result is correct or not
		assertEquals(address, instance.getAddress());
	}

	/**
	 * Test method for {@link symphony.domain.Person#setAddress(symphony.domain.Address)}.
	 */
	@Test
	public void testSetAddress() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		assertEquals(address, instance.getAddress());
		PostalCode post2 = new PostalCode("K2G4R8");
		Address address2 = new Address("103","Abc Street","Ottawa","ON",post2);
		instance.setAddress(address2);
		//validate the result is correct or not
		assertEquals(address2,instance.getAddress());
	}
	
	/**
	 * Test method for {@link symphony.domain.Person#getPhoneNumber()}.
	 */
	@Test
	public void testGetPhoneNumber() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		//validate the result is correct or not
		assertEquals(phoneNumber, instance.getPhoneNumber());
	}

	/**
	 * Test method for {@link symphony.domain.Person#setPhoneNumber(symphony.domain.PhoneNumber)}.
	 */
	@Test
	public void testSetPhoneNumber() {
		ID id=new ID("0001");
		Name name = new Name("Jack", "Chen","Mr");
		PostalCode post = new PostalCode("K2J5T1");
		Address address = new Address("102","Albert Street","Ottawa","ON",post);
		PhoneNumber phoneNumber = new PhoneNumber(001, 613, 900 ,712);
		//define an object of Person
		Conductor instance = new Conductor(id,name,address,phoneNumber);
		assertEquals(phoneNumber, instance.getPhoneNumber());
		PhoneNumber phoneNumber2 = new PhoneNumber(010,613, 800, 702);
		instance.setPhoneNumber(phoneNumber2);
		//validate the result is correct or not
		assertEquals(phoneNumber2,instance.getPhoneNumber());
	}

}
