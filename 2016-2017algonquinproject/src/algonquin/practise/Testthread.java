package algonquin.practise;

import java.util. Scanner;//1



public  class Testthread extends Thread {//9
        private String name ;
        public Testthread(){}
        public Testthread(String name){
        	this.name=name;
        }
	   @Override
	   public void run(){
		   for (int i=0; i<3;i++){
			   System.out.println(name+"i="+i);
		   }
		   
	   }
	   
	
	
	public static void main(String[] args) {//2
		// TODO Auto-generated method stub
	    Testthread t1=new Testthread("threadone");
	    Testthread t2=new Testthread("threadtwo");
	    t1.start();
	    t2.start();
	    for(int i=0;i<3;i++){
	    System.out.println("main() mehtod i="+i);
	    }
	}

}

