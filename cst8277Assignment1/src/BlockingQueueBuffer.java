/* File: BlockingQueueBuffer.java
 * Professor: Rejaul Chowdhury,Stanley Pieda
 * course number: cst8277_winter 2018
 * lab: 304
 * Student: Tao Wang, 040857654
 * created date: January 22, 2018
 * reference:  Paul Deitel& Harvey Deitel, Java How to program, Fig. 23.14: BlockingBuffer.java
 * 
 * */
import java.util.concurrent.ArrayBlockingQueue;

/**
 *Class for implementing a buffer with the feature of blokingQueue, first in first out
 * @author Tao Wang
 * @version 1.0
 * Date: January 2018
 */
public class BlockingQueueBuffer implements Buffer<FishStick> {

	/**identify a ArrayBlockingQuere reference to put and take FishStick objects.*/
	private final ArrayBlockingQueue<FishStick> buffer;
	
	/**variable for check if the buffer is empty and end*/
	private volatile boolean  isDone=false;
	/**
	 * constructor and initialize the buffer
	 * */
	public BlockingQueueBuffer() {
		
		buffer = new ArrayBlockingQueue<FishStick>(100);
	}
	
	/**
	 * Method for putting FishStick into buffer
	 * @param FishStick value, FishStick object
	 * @throws  InterruptedException
	 */
	@Override
	public void blockingPut(FishStick value) throws InterruptedException {
		
		//place an object of FishStick in buffer. 
		buffer.put(value); 
	    
	}
    
	/**
	 * Method for get the object from buffer
	 * @return FishStick, the object from buffer
	 * @throws  InterruptedException
	 */
	@Override
	public FishStick blockingGet() throws InterruptedException {
		
		//take an object of FishStick from buffer and return.
		return buffer.take();
	}
    /**
     *Method to check if the buffer is empty.
     *@return boolean 
     */
	@Override
	public synchronized boolean isDone() {
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
     * 
     *Method to check if the buffer is empty 
     */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return buffer.isEmpty();
	}
}
