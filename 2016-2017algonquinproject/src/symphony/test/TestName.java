/**
 * 
 */
package symphony.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import symphony.domain.*;
/**
 * Class for testing the Name class
 * @author Wang
 * @version 1.0
 * 
 *
 */
public class TestName extends TestCase {

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
	 * Test method for {@link symphony.domain.Name#Name()}.
	 */
	@Test
	public void testName() {
		//declare object of Name
		Name name=new Name();
		//validate the reuslt is correct or not
		assertTrue(name instanceof Name);
	}

	/**
	 * Test method for {@link symphony.domain.Name#Name(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testNameStringStringString() {
		//declare object of Name
				Name instance=new Name("Wang","Tao","Mr");
				//validate the reuslt is correct or not
				assertTrue(instance instanceof Name);
				assertEquals("Wang",instance.getFirstName());
				assertEquals("Tao",instance.getLastName());
				assertEquals("Mr",instance.getSalutation());
	}

	/**
	 * Test method for {@link symphony.domain.Name#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		//declare object of Name
		Name instance=new Name("Wang","Tao","Mr");
		//validate the reuslt is correct or not
		assertEquals("Wang",instance.getFirstName());
	}

	/**
	 * Test method for {@link symphony.domain.Name#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstName() {
		//declare object of Name
		Name instance=new Name("Wang","Tao","Mr");
		instance.setFirstName("li");
		//validate the reuslt is correct or not
		assertEquals("li",instance.getFirstName());
	}

	/**
	 * Test method for {@link symphony.domain.Name#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		//declare object of Name
		Name instance=new Name("Wang","Tao","Mr");
		//validate the reuslt is correct or not
		assertEquals("Tao",instance.getLastName());
	}

	/**
	 * Test method for {@link symphony.domain.Name#setLastName(java.lang.String)}.
	 */
	@Test
	public void testSetLastName() {
		//declare object of Name
				Name instance=new Name("Wang","Tao","Mr");
				//validate the reuslt is correct or not
				instance.setLastName("tao");
				assertEquals("tao",instance.getLastName());
	}

	/**
	 * Test method for {@link symphony.domain.Name#getSalutation()}.
	 */
	@Test
	public void testGetSalutation() {
		//declare object of Name
		Name instance=new Name("Wang","Tao","Mr");
		//validate the reuslt is correct or not
		assertEquals("Mr",instance.getSalutation());
	}

	/**
	 * Test method for {@link symphony.domain.Name#setSalutation(java.lang.String)}.
	 */
	@Test
	public void testSetSalutation() {
		//declare object of Name
		Name instance=new Name("Wang","Tao","Mr");
		instance.setSalutation("Mrs");
		//validate the reuslt is correct or not
		assertEquals("Mrs",instance.getSalutation());
	}

	/**
	 * Test method for {@link symphony.domain.Name#toString()}.
	 */
	@Test
	public void testToString() {
		//declare object of Name
		Name instance=new Name("Wang","Tao","Mr");
		//validate the reuslt is correct or not
		String expect="Name [firstName=" + instance.getFirstName() + ", lastName=" + instance.getLastName() + ", salutation=" + instance.getSalutation()+ "]";
		assertEquals(expect,instance.toString());
	}

}
