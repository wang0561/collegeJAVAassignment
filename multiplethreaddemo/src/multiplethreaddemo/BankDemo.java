package multiplethreaddemo;

public class BankDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}

}

class Bank {
	private int sum;

	public synchronized  void add(int num) {
	
			sum = sum + num;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName()+"  sum=" + sum);
		}
	

}

class Customer implements Runnable {

	private Bank bank = new Bank();

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		for (int x = 0; x < 30; x++) {

			bank.add(100);
		}
	}

}