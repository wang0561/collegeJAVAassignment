package github.test;

public class github {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   ThreadDemo td=new ThreadDemo();
   Thread t1= new Thread(td);
   Thread t2= new Thread(td);
   Thread t3= new Thread(td);

   Thread t4= new Thread(td);
   t1.start();
   t2.start();

   t3.start();

   t4.start();

   

	}

}
class ThreadDemo implements Runnable{
	private int num=100;
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(num>0)
		System.out.println(Thread.currentThread().getName()+ " ticket number"+num--);
	}}
