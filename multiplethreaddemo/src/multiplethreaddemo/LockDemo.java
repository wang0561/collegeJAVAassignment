package multiplethreaddemo;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;

/*
 * This is an example for java.util.concurrent.locks.lock and condition
 *  
 * lock object is the replacement for synchronized block. lock have multiple conditions(monitor),so the lock could choose to await and awake single thread,
 * this is more effective than nofifyall. 
 * 
 * otherwise, executor is another way to start up thread. and more effective than thread
 * */
public class LockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//two producor lines and two consumer lines
		ResourceL r = new ResourceL();
		ProducerL pro1 = new ProducerL(r);
		ConsumerL con1 = new ConsumerL(r);
		ProducerL pro2 = new ProducerL(r);
		ConsumerL con2= new ConsumerL(r);


		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(pro1);
		executor.execute(con1);
		executor.execute(pro2);
		executor.execute(con2);
		executor.shutdown();
	}

}

class ProducerL implements Runnable {
	ResourceL r;

	public ProducerL(ResourceL r) {
		this.r = r;
	}

	public void run() {
        
		int i =100000;
		while (i-->0) {
			r.set("Computer...");
		}
	}
}

class ConsumerL implements Runnable {
	ResourceL r;

	public ConsumerL(ResourceL r) {
		this.r = r;
	}

	public void run() {
        int i =100000;
		while (i-- >0) {
			r.out();
		}
	}
}

class ResourceL {
	private String name;
	private int id = 1;
	private boolean empty;
	private final Lock lock = new ReentrantLock();
	private final Condition proCondition = lock.newCondition();
	private final Condition conCondition = lock.newCondition();
	

	public void set(String name) {
		lock.lock();
		try{
		while (empty)
			try {
				//this.wait();
				proCondition.await();
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		this.name = name + id;
		id++;
		System.out.println(Thread.currentThread().getName() + " produced " + this.name);
		empty = true;
		//this.notifyAll();
		conCondition.signal();
		}
		finally{
			lock.unlock();
		}
	}

	public void out() {
		
		lock.lock();
		try{
		while (!empty)
			try {
				//this.wait();
				conCondition.await();
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		System.out.println(Thread.currentThread().getName() + " consumer ......." + this.name);
		empty = false;
		//this.notifyAll();
		proCondition.signal();
		}finally{
			lock.unlock();
		}
	}
}