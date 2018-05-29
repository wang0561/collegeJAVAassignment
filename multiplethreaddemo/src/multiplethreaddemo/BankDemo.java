package multiplethreaddemo;
/*
 *File: BankDemo.java
 *Student: Tao Wang, 040857654 
 *Professor: Stanley Pieda
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author Tao Wang
 * class for start a sample multiple threads demo program. 
 * @version 1.0
 */
public class BankDemo {
    /**
     * Main method for the program
     * @param String[] args
     * */
	public static void main(String[] args) {

		new BankDemo().startDemo();
	}
	/**
	 * method for starting initializing the demo
	 * @author Tao Wang
	 */
	private void startDemo() {
		long startTime = System.currentTimeMillis();//start time 
		Bank bank = new Bank();
		Customer c1 = new Customer(bank);
		Customer c2 = new Customer(bank);
		Customer c3 = new Customer(bank);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(c1);
		executor.execute(c2);
		executor.execute(c3);
		executor.shutdown();
		try {
			executor.awaitTermination(1,TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("time is overdue "+e.getMessage());
			e.printStackTrace();
		}
		if(executor.isTerminated()) {
			long endTime = System.currentTimeMillis();//end time
			long elapsedTime = endTime - startTime;//period
			int minutes = (int)elapsedTime / 1000 / 60;
			int seconds = (int)elapsedTime / 1000 % 60;
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
			System.out.printf("%02d minutes, %02d seconds, %03d millisecs%n", minutes, seconds, elapsedTime % 1000);
			System.out.printf("Program by: Tao Wang run on %s%n",dateTime.format(format));

		}

	}
}

/**
 *@author Tao Wang
 *class for bank resource 
 */
class Bank {
	/**sum of account*/
	private int sum;

    /**
     * Method for deposit
     * 
     * */
	public synchronized void deposit(int num) {
		
		sum = sum + num;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" account sum=" +"$"+ getSum());
		
	}
	
	public int getSum() {
		return sum;
	}


}
/**
 *@author Tao Wang
 *class Customer which used to deposit money. 
 */
class Customer implements Runnable {
    /**Bank reference*/
	private Bank bank;
	/**
	 *constructor of Customer
	 *@param Bank bank 
	 */
	public Customer(Bank bank) {
		this.bank = bank;
	}
	/**
	 * Method for overriding the run method of Runnable
	 * */
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		for (int x = 0; x < 100; x++) {

			bank.deposit(100);
		}
	}

}