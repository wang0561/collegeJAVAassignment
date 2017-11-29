package multiplethreaddemo;

public class WaitNotifyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Resource r = new Resource();
        Input input= new Input(r);
        Output out= new Output(r);
        
        Thread t1=new Thread(input);
        Thread t2 = new Thread(out);
        
        t1.start();
        t2.start();
	}

}

class Input implements Runnable {
	Resource r;

	public Input(Resource r) {
		this.r = r;
	}

	public void run() {
		int x = 0;
		while (true) {
			if (x % 2==0) {
				r.set("Wang", "male");
			} else {
				r.set("dong", "female");
			}
           x++;
		}
	}

}

class Output implements Runnable{
	
	Resource r;
	Output(Resource r){
		this.r=r;
	}
	public void run(){
		
		
		while (true) {
			r.out();
		}
	}
}

/*
 * this class is the resource should be shared by multiple threads. set() and
 * out() should be synchronized
 * 
 */
class Resource {
	private String name;
	private String sex;
	private boolean empty;

	public synchronized void set(String name, String sex) {

		if (empty)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		this.name = name;
		this.sex = sex;
		empty = true;
		this.notify();

	}

	public synchronized void out() {
		if (!empty)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		System.out.println(name + "----" + sex);
		empty = false;
		this.notify();
	}

}