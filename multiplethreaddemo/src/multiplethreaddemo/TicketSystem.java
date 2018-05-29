package multiplethreaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketSystem {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i =0;i<3;i++) {
			executor.execute(new ThreadDemo());
		    executor.execute(getR());
		
		}
	}
    static Runnable getR(){
    	return new Runnable(){
    		public void run(){System.out.println("this is an inner class from Runnable"+Thread.currentThread().getName());}
    	};
    }
}

class ThreadDemo implements Runnable {
	private static int num = 500;
	//Object obj = new Object();
	@Override
	public void run() {
	
		// TODO Auto-generated method stub
		while (num>0)
		{/*while and synchronized cannot be converted 
		because when num=0, Thread-3 ticket number1
			Thread-2 ticket number0
			Thread-1 ticket number-1
			Thread-0 ticket number-2*/
			synchronized (ThreadDemo.class)
			 {
				if(num>0){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
					}
				System.out.println(Thread.currentThread().getName() + " ticket number" + num--);
				}
			}
		}
	}
}
