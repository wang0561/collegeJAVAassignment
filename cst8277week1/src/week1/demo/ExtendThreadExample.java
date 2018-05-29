package week1.demo;
// import java.lang.Thread;
// This is not the preferred approach
// - locked into Thread inheritance hierarchy
// - only use if must change class Thread's behavior
public class ExtendThreadExample extends Thread{
	@Override
	public void run() {
		Thread.currentThread().setName("ExtendsThread");
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
