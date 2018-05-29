package cst8277midtermString;

public class ProConDemo {
	private static String myString="";
	Object obj = new Object();
	static int con=0;
	static int pro=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ProConDemo demo = new ProConDemo();
		demo.new Producer().start();
		demo.new Consumer().start();

	}
	private class Producer extends Thread{

		@Override
		public void run() {

			while(pro<100) {
				//System.out.println("procuder run"+myString);
				synchronized(obj) {

					while(myString=="hello") {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					myString = "hello";
					System.out.println(Thread.currentThread().getName()+": produce "+myString);
					obj.notifyAll();

				}
			}
		}
	}
	private class Consumer extends Thread{

		@Override
		public void run() {

			while(con<100) {
				//System.out.println("consumer run");
				synchronized(obj) {

					while(myString=="") {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+": consumes "+myString);
					myString = "";
					obj.notifyAll();

				}
			}
		}
	}
}
