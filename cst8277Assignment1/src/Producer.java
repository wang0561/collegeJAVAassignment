/* File: Producer.java
 * Professor: Rejaul Chowdhury,Stanley Pieda
 * course number: cst8277_winter 2018
 * lab:304
 * Student:Tao Wang, 040857654
 * created date: January 22, 2018
 * Description:  a runnable task that read data from buffer and write the data into Database
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.lang.System.*;

/**
 * @author Tao Wang
 * @version 1.0
 * Date: Januray 2018
 * Class for implement task of procuder, read records from csv file and write them into buffer. Also
 * create a log file to track the producer thread.
 */
public class Producer implements Runnable {

	/**buffer to put FishStick in.*/
	private Buffer<FishStick> sharedBuffer;

	/**CSV file name*/
	private  String fileName = "DataSet18W_100000.csv";

	/**count of reading records*/
	private int recordsRead;

	/**Logger reference*/
	private Logger logger = Logger.getLogger("Producer log");

	/**file handler for logger*/
	private FileHandler fl;

	/**file cannot open info*/
	private final String failToOpenFile="cannot reader file or \ncannot find the file "+fileName + "\n please try again...";

	/**file open successful info*/
	private final String fileOpen="File "+fileName+" openned successful..";

	/**
	 * Constructor for Producer class
	 *@param Buffer<FishStick> buffer
	 */
	public Producer(Buffer<FishStick> buffer) {
		
		this.sharedBuffer=buffer;

	}

	/**
	 *Method to get the value of record read from the csv file 
	 * @return value of recordsRead
	 */
	public int getReadRecord() {
		return recordsRead;
	}

	/**
	 * Run method for the Producer 
	 * 
	 */
	@Override
	public void run() {
		Thread.currentThread().setName("Producer");
		try {
			//create log file
			createLogger();
			//read from csv file and write into buffer
			writeInBuffer(fileName);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SecurityException e) {  
			e.printStackTrace();  
		}  
	}

	/**
	 *Method for read from csv file and write the data into buffer 
	 *@param String fileName
	 *@throws  InterruptedException FileNotFoundException
	 */
	private void writeInBuffer(String fileName) throws InterruptedException {

		try(BufferedReader fileReader=getFileReader(fileName)){

			String line="";
			while((line=fileReader.readLine())!=null ) {
				
				//read data from csv and parse to Fishstick object
				String[] fields = line.split(",");
				FishStick fishstick = new FishStick();
				fishstick.setRecordNumber(Integer.parseInt(fields[0]));
				fishstick.setOmega(fields[1]);
				fishstick.setLambda(fields[2]);
				fishstick.setUUID(fields[3]);
                logger.info("read record from csv:"+fishstick.toString());
				try {
					// put FishStick object into buffer
					sharedBuffer.blockingPut(fishstick);
					recordsRead++;
					if(recordsRead % 100 == 0) 
						out.printf("%d records read by producer%n", recordsRead);
				} catch (Exception e) {
					//write error info into log
					logger.info(e.getMessage());
				}	
			}
		}catch(IOException e) {
			err.println(failToOpenFile);
			logger.info(failToOpenFile);
			
		}
		out.printf("%d records read, task completed%n", recordsRead);
		logger.info("read task completed");
		sharedBuffer.setDone(true);
	}

	/**
	 *Method for get a BufferedRader object
	 *@param String fileName, the csv file path
	 *@return BufferedReader object wrapped the file
	 *@throws IOException
	 */
	private BufferedReader getFileReader(String fileName) throws IOException{

		return Files.newBufferedReader(Paths.get(fileName));
	}
	/**
	 *Method for creating a logger file for producer
	 * 
	 */
	private void createLogger() {
		/**create log file for producer information*/
		logger.setUseParentHandlers(false);
		try {
			fl = new FileHandler("producer_logger.log");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.addHandler(fl);
		SimpleFormatter formatter = new SimpleFormatter();  
		fl.setFormatter(formatter);  
		logger.info("program by Tao Wang :"+fileOpen);
	}
}
