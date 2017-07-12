/**
 * 
 */
package symphony.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.*;
/**
 * Class for testing the class Soloist
 * @author Bo, Tao
 * @version 1.0
 * 
 *
 */
public class TestSoloist extends TestCase {

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
	 * Test method for {@link symphony.domain.Soloist#Soloist(symphony.domain.ID, symphony.domain.Name, symphony.domain.Address, symphony.domain.PhoneNumber, java.util.ArrayList)}.
	 */
	@Test
	public void testSoloist() {
		
		
		//validate results are correct or not
		assertTrue(instance instanceof Soloist);
		assertEquals(id,instance.getId());
		assertEquals(name,instance.getName());
		assertEquals(address,instance.getAddress());
		assertEquals(phoneNumber,instance.getPhoneNumber());
		assertEquals(list,instance.getExpertise());
	}

	/**
	 * Test method for {@link symphony.domain.Soloist#getExpertise()}.
	 */
	@Test
	public void testGetExpertise() {
		
		//declare object of soloist
		Soloist instance=new Soloist(id,name,address,phoneNumber,list);
		//validate results are correct or not
		assertEquals(list,instance.getExpertise());
	}

	/**
	 * Test method for {@link symphony.domain.Soloist#setExpertise(java.util.ArrayList)}.
	 */
	@Test
	public void testSetExpertise() {
		
		instance.setExpertise(list);
		//validate results are correct or not
		assertEquals(list,instance.getExpertise());
	}

	
	ID id=new ID("ABC");
	Name name = new Name("wang", "Tao","Mr");
	Address address =new Address("102","Abc Street","ottawa","ON",new PostalCode("K2J5T1"));
	PhoneNumber phoneNumber = new PhoneNumber(613,697,3876,000);
	ArrayList<String> list=new ArrayList<String>(){{
		add("Sax");
	}};
	//declare object of soloist
	Soloist instance=new Soloist(id,name,address,phoneNumber,list);
}
