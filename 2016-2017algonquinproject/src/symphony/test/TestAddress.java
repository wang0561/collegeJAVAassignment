/**
 * 
 */
package symphony.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.Address;
import symphony.domain.PostalCode;

/**
 * Class for testing the methods of Class Address
 * @author Wang
 * @version 1.0
 *
 */
public class TestAddress extends TestCase {

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
	 * Test method for {@link symphony.domain.Address#Address()}.
	 */
	@Test
	public void testAddress() {
		Address a=new Address();
		//validate the result
		assertTrue(a instanceof Address);
		
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#Address(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddressStringStringStringStringString() {
		//declare a new object of Address
		Address instance =new Address("102","Abc Street","ottawa","ON",new PostalCode("K2J5T1"));
		String expectResult="102 Abc Street ottawa ON K2J5T1";
		//validate the result
		assertEquals(expectResult, instance.toString());
		
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#getStreetName()}.
	 */
	@Test
	public void testGetStreetName() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setStreetName("abc");
		String expectResult="abc";
		//validate the result
		assertEquals(expectResult, instance.getStreetName());
	
	}

	/**
	 * Test method for {@link symphony.domain.Address#setStreetName(java.lang.String)}.
	 */
	@Test
	public void testSetStreetName() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setStreetName("abc");
		String expectResult="abc";
		//validate the result
		assertEquals(expectResult, instance.getStreetName());
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#getStreeNumber()}.
	 */
	@Test
	public void testGetStreeNumber() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setStreeNumber("123");
		String expectResult="123";
		//validate the result
		assertEquals(expectResult, instance.getStreeNumber());
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#setStreeNumber(java.lang.String)}.
	 */
	@Test
	public void testSetStreeNumber() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setStreeNumber("123");
		String expectResult="123";
		//validate the result
		assertEquals(expectResult, instance.getStreeNumber());
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#getCity()}.
	 */
	@Test
	public void testGetCity() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setCity("ottawa");
		String expectResult="ottawa";
		//validate the result
		assertEquals(expectResult, instance.getCity());
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#setCity(java.lang.String)}.
	 */
	@Test
	public void testSetCity() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setCity("ottawa");
		String expectResult="ottawa";
		//validate the result
		assertEquals(expectResult, instance.getCity());
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#getProvince()}.
	 */
	@Test
	public void testGetProvince() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setProvince("ON");
		String expectResult="ON";
		//validate the result
		assertEquals(expectResult, instance.getProvince());
	
	}

	/**
	 * Test method for {@link symphony.domain.Address#setProvince(java.lang.String)}.
	 */
	@Test
	public void testSetProvince() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setProvince("ON");
		String expectResult="ON";
		//validate the result
		assertEquals(expectResult, instance.getProvince());
		
	}

	/**
	 * Test method for {@link symphony.domain.Address#getPostalCode()}.
	 */
	@Test
	public void testGetPostalCode() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setPostalCode(new PostalCode("K2J5T1"));
		String expectResult="K2J5T1";
		//validate the result
		assertEquals(expectResult, instance.getPostalCode().getPostcode());
	
	}

	/**
	 * Test method for {@link symphony.domain.Address#setPostalCode(java.lang.String)}.
	 */
	@Test
	public void testSetPostalCode() {
		//declare a new object of Address
		Address instance =new Address();
		instance.setPostalCode(new PostalCode("K2J5T1"));
		String expectResult="K2J5T1";
		//validate the result
		assertEquals(expectResult, instance.getPostalCode().getPostcode());
	
	}

	/**
	 * Test method for {@link symphony.domain.Address#toString()}.
	 */
	@Test
	public void testToString() {
		//declare a new object of Address
		Address instance =new Address("102","AbcStreet","ottawa","ON",new PostalCode("K2J5T1"));
		String expectResult="102 AbcStreet ottawa ON K2J5T1";
		//validate the result
		assertEquals(expectResult, instance.toString());

	}

}
