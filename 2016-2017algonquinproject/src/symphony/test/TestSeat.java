package symphony.test;

import static org.junit.Assert.*;
import symphony.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
/**
 * test Seat class methods
 * @author Min Luo
 *
 */
public class TestSeat extends TestCase{
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
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
	 * test constructor for {@link} {@link symphony.domain.Seat#Seat(symphony.domain.Seat.boolean, symphony.domain.Seat.int, symphony.domain.Seat.int)}
	 */
	@Test
	public void testSeat() {
		boolean isReserved = true;
		int rowNO =2; 
		int columNO =4;
		//declare an instance of object 
		Seat instance = new Seat(isReserved, rowNO, columNO);
		//validate the result
		assertTrue(instance instanceof Seat);	
	}

	/**
	 * test method for {@link symphony.domain.Seat#isSeatReserved()}.
	 */
	@Test
	public void testIsSeatReserved() {
		int rowNO =2; 
		int columNO =4;
		boolean isReserved = true;
		//declare an instance of object 
		Seat instance = new Seat(isReserved, rowNO, columNO);
		//validate the result
		assertTrue(instance.isSeatReserved());
	}
	/**
	 * test method for {@link symphony.domain.Seat#setSeatReserved(boolean)}.
	 */
	@Test
	public void testSetSeatReserved() {
		int rowNO =2; 
		int columNO =4;
		boolean isReserved = true;
		//declare an instance of object 
		Seat instance = new Seat(isReserved, rowNO, columNO);
		instance.setSeatReserved(false);
		//validate the result
		assertTrue(!instance.isSeatReserved());
	}
	
	/**
	 * test method for {@link symphony.domain.Seat#getRowNo()}.
	 */
	@Test
	public void testGetRowNo() {
		int rowNO = 3;
		int columNO =5;
		boolean isReserved = true;
		//declare an instance of object 
		Seat instance = new Seat(isReserved, rowNO, columNO);
		//validate the result
		assertEquals(rowNO, instance.getRowNo());
	}
	
	/**
	 * test method for {@link symphony.domain.Seat#setRowNo(symphony.domain.int)}.
	 */
	@Test
	public void testSetRowNo() {
		int rowNo = 3;
		int columNo =5;
		boolean isReserved = true;
		//declare an instance of object 
		Seat instance = new Seat(isReserved, rowNo, columNo);
		instance.setRowNo(10);
		//validate the result
		assertEquals(10, instance.getRowNo());
	}
	
	/**
	 *test method for {@link symphony.domain.Seat#getColumNo()}. 
	 */
	@Test
	public void testGetColumNo() {
		int rowNo = 3;
		int columNo =5;
		boolean isReserved = true;
		//declare an instance of object 
		Seat instance = new Seat(isReserved, rowNo, columNo);
		//validate the result
		assertEquals(columNo, instance.getColumNo());
	}

	/**
	 * test method for {@link symphony.domain.Seat#setColumNo(symphony.domain.int)}. 
	 */
	@Test
	public void testSetColumNo() {
		int rowNo = 3;
		int columNo =5;
		boolean isReserved = true;
		//declare an instance of object 
		Seat instance = new Seat(isReserved, rowNo, columNo);
		instance.setColumNo(5);
		//validate the result
		assertEquals(5, instance.getColumNo());
	}

}
