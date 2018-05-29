/* File: DataLoader.java
 * Course number: cst8277 
 * Professor:Rejaul Chowdhury, Stanley Pieda
 * lab: 304
 * Student: Tao Wang, 040857654
 * Description: Single-threaded application to read a dataset file formatted as csv text
 *              and insert the data into a database
 * 
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;


/**
 * Class for create and manage the threadpool, record the time the program runs.
 * @author Tao Wang
 * @version 1.0
 * Date: January 2018
 * */
public class DataLoader {
    /**
     *Method to start the program, calculate the time the program used, and print the information to console. 
     */
	public void startProcess() {

		long startTime = System.currentTimeMillis();//start time 
		ExecutorService executor = Executors.newFixedThreadPool(2);

		//Buffer<FishStick> buffer = new BlockingQueueBuffer();
		Buffer<FishStick> buffer = new CircularBuffer();
		//create objects of Consumer and Producer
        Consumer con = new Consumer(buffer);
        Producer pro = new Producer(buffer);
		// execute the threads 
        executor.execute(con);
		executor.execute(pro);
        // shutdown the threadpool
		executor.shutdown();
        
		try {
			executor.awaitTermination(1,TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("time is overdue "+e.getMessage());
			e.printStackTrace();
		}
	    if(executor.isTerminated()) {
		long endTime = System.currentTimeMillis();//end time
		long elapsedTime = endTime - startTime;//period
		int minutes = (int)elapsedTime / 1000 / 60;
		int seconds = (int)elapsedTime / 1000 % 60;
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
		
        //print all information of the program
		System.out.printf("\n%d records read%n", pro.getReadRecord());
		System.out.printf("%d records inserted%n", con.getInsertedRecord());
		System.out.printf("%d mileseconds elapsed%n", elapsedTime);
		System.out.printf("%02d minutes, %02d seconds, %03d millisecs%n", minutes, seconds, elapsedTime % 1000);
		System.out.printf("Program by: Tao Wang run on %s%n",dateTime.format(format));
		System.out.printf("Buffer type is %s%n", buffer.getClass().getName()); // tip for students threaded program
	}

	}

}
