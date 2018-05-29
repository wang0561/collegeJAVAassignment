/* File: Consumer.java
 * Professor: Rejaul Chowdhury, Stanley Pieda
 * course number: cst8277_winter 2018
 * lab:304
 * student: Tao Wang, 040857654
 * created date: January 22, 2018
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.lang.System.*;

import java.io.IOException;


/**
 * @author Tao Wang
 * @version 1.0
 * Date: January 2018
 * Class for implement task of Consumer, read records from buffer and write them into database. Also create a
 * log file to track the information of the consumer thread.
 */
public class Consumer implements Runnable{
	
	/**Buffer reference*/
	private Buffer<FishStick> buffer;
	/**connection to database*/
	private Connection con = null;
	/**url of the database*/
	private final String connectionString = "jdbc:mysql://localhost/assignment1";
	/**user name of the database*/
	private final String username = "assignment1";
	/**password of the database*/
	private final String password = "password";
	/**count of records inserted into database*/
	private int recordsInserted;
	/**insert statement*/
	private PreparedStatement pstmt = null;
	/**sql query to insert*/
	private final String insert="INSERT INTO FishSticks (recordnumber, omega, lambda, uuid) VALUES(?, ?, ?, ?)";
	/**Logger reference*/
	private Logger logger = Logger.getLogger("Consumer log");
	/**file handler for log file*/
	private FileHandler fl;
	/**FishStick reference*/
	private FishStick fish;
	/**connection open info*/
	private final String conOpen="connection successful...........";
	/**cannot open connection info*/
	private final String notOpen="Cannot create new connection, one exists already";


	/**
	 * constructor for Consumer
	 * @param Buffer<FishStick> buffer which Buffer object used in the program
	 *
	 */
	public Consumer(Buffer<FishStick> buffer) {
		this.buffer=buffer;
	}
	/**
	 *Method for get the value of recordsInserted
	 *@return int value of recordsInserted 
	 */
	public int getInsertedRecord() {return recordsInserted;}

	/**
	 *Method to open the connection to database 
	 */
	private void openConnection(){
		try{
			if(con != null){
				out.println(notOpen);
				logger.info(notOpen);
			}
			else{
				con = DriverManager.getConnection(connectionString, username, password);
				pstmt = con.prepareStatement(insert);
				con.setAutoCommit(false);
				logger.info(conOpen);
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	/**
	 *Method to insert data into database
	 *@param FishStick fishstick, the object read from buffer 
	 *@throws SQLException
	 */
	private void insertFishStick(FishStick fishstick) throws SQLException {
		//insert fishsticks to database
		try{
			if(con == null || con.isClosed()) {
				System.out.println("Cannot insert records, no connection or connection closed");
			}
			logger.info(fish.toString());
			//preparedstatment for insert
			pstmt.setInt(   1, fishstick.getRecordNumber());
			pstmt.setString(2, fishstick.getOmega());
			pstmt.setString(3, fishstick.getLambda());	
			pstmt.setString(4, fishstick.getUUID());
			//add record to  cache
			pstmt.addBatch();
			//insert into database if the batch contains 500 records 
			if((++recordsInserted%500) == 0) {
				//write into database
				pstmt.executeBatch();
				//clear all cached data
				con.commit();
			}
		}
		catch(SQLException e){
			logger.info("sql exception "+e.getMessage());
		}

	}

	/**
	 *Method to close the database connection 
	 */
	private void closeConnection() {
		try{ if(con != null){ 
			con.close(); 
			logger.info("connection closed successfully..");
		}
		}
		catch(SQLException ex){
			logger.info("cannot close the connection "+ex.getMessage());
		}
	}

	/**
	 * Run method for this Runnable task. 
	 */
	@Override
	public void run() {
        Thread.currentThread().setName("Consumer");
        //create log file
		createLogger();
		//open database
		openConnection();
		//delete all records of the fishsticks talbe.
		FishStickCleaner.deleteAllFishStick(con);
		//read from buffer and write to database
		try {
			while(true) {
				
				if(buffer.isDone()&& buffer.isEmpty()) break;
				//take the fishstick object from buffer
				fish = buffer.blockingGet();
				//insert into database
				insertFishStick(fish);
				if(recordsInserted % 100 == 0) 
					out.printf("%d records inserted by Consumer%n", recordsInserted);
			}
		} catch (InterruptedException e) {
			logger.info(e.getMessage());

		} catch (SQLException e) {
			logger.info(e.getMessage());
		}  finally {
			out.printf("%d records inserted, task completed%n", recordsInserted);			//close connection to database
			closeConnection();
			try{ if(pstmt != null){ 
				//close preparestatement
				pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
	}

	/**
	 *Method for creating a logger file for consumer
	 * 
	 */
	private void createLogger() {
		/*create a log file for the records read from buffer*/

		logger.setUseParentHandlers(false);
		try {
			fl = new FileHandler("consumer_logger.log");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.addHandler(fl);
		SimpleFormatter formatter = new SimpleFormatter();  
		fl.setFormatter(formatter); 
		logger.info("program by Tao Wang :");
	}
}


