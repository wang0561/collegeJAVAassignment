package week1.demo;
public class RunDemo {
	public static void main(String[] args) {
		ImplementRunnableExample runnable = new ImplementRunnableExample();
		Thread thread1 = new Thread(runnable);
		thread1.start();
		//runnable.run(); // not multithreading!
		
		ExtendThreadExample thread2 = new ExtendThreadExample();
		thread2.start();

		System.out.println("Main thread has shutdown");
	}
}
