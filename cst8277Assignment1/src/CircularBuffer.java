

/* File: CircularBuffer.java
 * Course number: cst8277_winter 2018
 * lab:304
 * Professor: Rejaul Chowdhury, Stanley Pieda
 * Student: Tao Wang, 040857654
 * version: 1/0
 * created date: January 22, 2018
 * reference: Paul Deitel& Harvey Deitel, Java How to program, Fig. 23.18: CircularBuffer.java
 * */

/**
 * Class to implement a circular buffer
 * @author Tao Wang
 * @version 1.0
 * Date: Januray 2018
 * */
public class CircularBuffer implements Buffer<FishStick>{
    
	/** count number of buffers used*/
	private int count = 0; 
	/**index of next element to write to*/
	private int putIndex = 0; 
	/**index of next element to read*/
	private int getIndex = 0; 
	/**array reference for take and put FishStick objects.*/
	private final FishStick[] buffer ;
	/**variable if the task is done*/
	private volatile boolean isDone=false;

	/**constructor and initialize the */
	public CircularBuffer() {
		 buffer = new FishStick[100];
	}
	
	/**
	 * Method for putting FishStick Object in buffer
	 * @param FishStick fish
	 * @throws  InterruptedException
	 */
	@Override
	public synchronized void blockingPut(FishStick fish) throws InterruptedException {
		   //while the buffer is full, current thread will in blocking state
			while(count==buffer.length) 
				wait();
			//insert the FishStick object into the buffer
			buffer[putIndex]= fish;
			//if take the last object, update the buffer put index from 0
//			if(++putIndex == buffer.length)
//				putIndex=0;
			putIndex = (putIndex + 1) % buffer.length;
			//the count of objects in buffer increased by 1.
			++count;
			//awake the threads in waiting 
			notifyAll();
		
	}
    
	/**
	 * Method for getting a FishStick object from the buffer
	 * @return FishStick 
	 * @throws  InterruptedException
	 * 
	 */
	@Override
	public synchronized FishStick blockingGet() throws InterruptedException {
		//while the buffer is empty, current thread will in blocking state
        while(count==0)
        	wait();
        //take a FishStick object from buffer
        FishStick fish = buffer[getIndex];
        //if the count is equal to buffer length, update the buffer getindex to 0
//        if(++getIndex == buffer.length)
//        	getIndex=0;
        getIndex = (getIndex + 1) % buffer.length;
        //count of objects to decreased by 1
        --count;
        //awake all threads in waiting state
        notifyAll();
        //return the object token.
		return fish;
	}
	
	 /**
     *Method to check if the buffer is empty.
     *@return boolean 
     */
	@Override
	public boolean isDone() {
		return isDone;
	}
    
	/**
	 *Method to set done
	 *@param boolean done 
	 */
	@Override
	public void setDone(boolean done) {
		// TODO Auto-generated method stub
		isDone=done;
	}

	/**
	 *Method to check if the buffer is empty
	 *@return boolean
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}
	
	

}
