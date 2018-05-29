package week1.demo;
//import java.lang.Runnable
// This is the preferred approach
// - can quickly add interface Runnable, and method run
//   to allow running on a new Thread.
public class ImplementRunnableExample implements Runnable{
	@Override
	public void run(){
		Thread.currentThread().setName("ImplementsRunnable");
		for(int count = 1; count <= 10; count++) {
			System.out.println(Thread.currentThread().getName() + " " + count);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
