package multiplethreaddemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Tao Wang
 * class for test BankDemo
 * */
public class BankDemoTest {
    /**
     * unit test for Bank.getSum()
     * */
	@Test
	void testGetSum() {
		Bank bank = new Bank();
		bank.deposit(1000);
		int expect = bank.getSum();
		assertEquals(1000,expect);
		System.out.println("unittest by Tao Wang");
	}

}
