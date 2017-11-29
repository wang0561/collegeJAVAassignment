package multiplethreaddemo;
import java.util.concurrent.*;

public class ExcuteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ThreadDem td = new ThreadDem();
//       ExecutorService exe1 = Executors.newCachedThreadPool();
//       ExecutorService exe2 = Executors.newFixedThreadPool(2);
//       ExecutorService exe3 = Executors.newSingleThreadExecutor();
//       
//       exe1.execute(td);
//       exe2.execute(td);
//       exe3.execute(td);
//       
//       try{
//    	   TimeUnit.MILLISECONDS.sleep(100);
//       }catch(InterruptedException e){
//    	   e.printStackTrace();
//       }
//       exe1.shutdown();
//       exe1.shutdown();
//       exe1.shutdown();
        ExecutorService exe2 = Executors.newFixedThreadPool(5);
        exe2.execute(td);
        exe2.shutdown();
        System.out.println(exe2.getClass().getName());
	}

}
class ThreadDem implements Runnable {
	private int num = 1000;
	Object obj = new Object();
	@Override
	public void run() {
	
		// TODO Auto-generated method stub
		while (num>0)
		{/*while and synchronized cannot be converted because when num=0, Thread-3 ticket number1
			Thread-2 ticket number0
			Thread-1 ticket number-1
			Thread-0 ticket number-2*/
			synchronized (obj)
			 {
				if(num>0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				System.out.println(Thread.currentThread().getName() + " ticket number" + num--);
				}
			}
		}
	}
}