package multiplethreaddemo;
/*
 *This is a program for producing computer and selling computer through concurrent. 
 * */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinalProConDemo {

	public static void main(String[] args) {
		ResourceF r = new ResourceF();
		ProducerF pro1 = new ProducerF(r);
		ConsumerF con1 = new ConsumerF(r);
		ProducerF pro2 = new ProducerF(r);
		ConsumerF con2 = new ConsumerF(r);

		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(pro1);
		executor.execute(con1);
		executor.execute(pro2);
		executor.execute(con2);
		executor.shutdown();
	}
}

class ProducerF implements Runnable {
	ResourceF r;

	public ProducerF(ResourceF r) {
		this.r = r;
	}

	public void run() {

		int i = 100000;
		while (i-- > 0) {
			
			r.put("Computer...");
		}
	}
}

class ConsumerF implements Runnable {
	ResourceF r;

	public ConsumerF(ResourceF r) {
		this.r = r;
	}

	public void run() {
		int i = 1000;
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		while (i-- > 0) {
			r.take();
		}
	}
}

class ResourceF {
	private String computer;
	private int id = 1;

	private final Lock lock = new ReentrantLock();
	private final Condition proCondition = lock.newCondition();
	private final Condition conCondition = lock.newCondition();
	private String[] computers = new String[10];
	private int putptr, takeptr, count;

	public void put(String computer) {
		lock.lock();
		try {
			while (count == computers.length)
				try {
				
					proCondition.await();
					
				} catch (InterruptedException e) {
				}
			this.computer = computer + id;
			computers[putptr] = this.computer;
			if (++putptr == computers.length)
				putptr = 0;
			++count;
			if(id%100==0)
				System.out.println(Thread.currentThread().getName() + " produced " + this.computer);
			id++;
			
			conCondition.signal();
		} finally {
			lock.unlock();
		}
	}

	public void take() {

		lock.lock();
		try {
			while (count == 0)
				try {

					conCondition.await();
					
				} catch (InterruptedException e) {
				}
			computer= computers[takeptr];
			if(id%100 == 0)
			System.out.println(Thread.currentThread().getName() + " consumer ......." + computer);
			if (++takeptr == computers.length)
				takeptr = 0;
			--count;
			proCondition.signal();
		} finally {
			lock.unlock();
		}
	}
}