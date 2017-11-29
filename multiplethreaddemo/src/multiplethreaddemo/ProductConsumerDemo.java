package multiplethreaddemo;

public class ProductConsumerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceN r = new ResourceN();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}

}

class Producer implements Runnable {
	ResourceN r;

	public Producer(ResourceN r) {
		this.r = r;
	}

	public void run() {

		while (true) {
			r.set("Computer...");
		}
	}
}

class Consumer implements Runnable {
	ResourceN r;

	public Consumer(ResourceN r) {
		this.r = r;
	}

	public void run() {

		while (true) {
			r.out();
		}
	}
}

class ResourceN {
	private String name;
	private int id = 1;
	private boolean empty;

	public synchronized void set(String name) {
		while (empty)
			try {
				this.wait();
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		this.name = name + id;
		id++;
		System.out.println(Thread.currentThread().getName() + " produced " + this.name);
		empty = true;
		this.notifyAll();

	}

	public synchronized void out() {
		while (!empty)
			try {
				this.wait();
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		System.out.println(Thread.currentThread().getName() + " consumer ......." + this.name);
		empty = false;
		this.notifyAll();
	}
}