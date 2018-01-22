/* File: DataLoader.java
 * Author: Stanley Pieda
 * Date: Jan, 2018
 * Description: Single-threaded application to read a dataset file formatted as csv text
 *              and insert the data into a database
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;

public class DataLoader {
	private long elapsedTime;
	private int recordsRead;
	private int recordsInserted;

	private Scanner fishstickScanner = null;
	private Connection con = null;

	private final String connectionString = "jdbc:mysql://localhost/assignment1";
	private final String username = "assignment1";
	private final String password = "password";


	public void processRecords() {
		// open file
		// open connection to database
		// delete old data
		// starting time stamp
		// loop over file reading records
		//   load data into record object
		//   insert new data
		// end loop
		// ending time stamp
		// output to screen
		try {
			openFile();
			openConnection();
			deleteAllFishSticks();
			long startTime = System.currentTimeMillis();
			while(fishstickScanner.hasNext()){
				String line = fishstickScanner.nextLine(); // read raw data
				String[] fields = line.split(","); // split on delimiter
				FishStick fishstick = new FishStick();
				fishstick.setRecordNumber(Integer.parseInt(fields[0]));
				fishstick.setOmega(fields[1]);
				fishstick.setLambda(fields[2]);
				fishstick.setUUID(fields[3]);
				recordsRead++;
				insertFishStick(fishstick);
				recordsInserted++;
				if(recordsInserted % 100 == 0) {
					System.out.printf("%d records read and inserted%n", recordsInserted);
				}
			}

			long endTime = System.currentTimeMillis();

			elapsedTime = endTime - startTime;
			int minutes = (int)elapsedTime / 1000 / 60;
			int seconds = (int)elapsedTime / 1000 % 60;
			
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");

			System.out.printf("%d records read%n", recordsRead);
			System.out.printf("%d records inserted%n", recordsInserted);
			System.out.printf("%d mileseconds elapsed%n", elapsedTime);
			System.out.printf("%02d minutes, %02d seconds, %03d millisecs%n", minutes, seconds, elapsedTime % 1000);
			System.out.printf("Program by: Stanley Pieda run on %s%n",dateTime.format(format));
			//System.out.printf("Buffer type is %s%n", buffer.getClass().getName()); // tip for students threaded program
		}
		finally {
			closeFile();
			closeConnection();
		}
	}

	private void openFile() {
		try {
			fishstickScanner = new Scanner(new FileReader(new File("DataSet18W_100000.csv")));
		}
		catch(IOException ex){
			System.out.println("Problem opening file: "
					+ ex.getMessage());
		}
	}
	
	private void closeFile() {
		try {
			if(fishstickScanner != null) {fishstickScanner.close();}
		}
		catch(Exception ex) {
			System.out.println("Problem closing file: "
					+ ex.getMessage());
		}
	}

	private void openConnection(){
		try{
			if(con != null){
				System.out.println("Cannot create new connection, one exists already");
			}
			else{
				con = DriverManager.getConnection(connectionString, username, password);
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	private void closeConnection() {
		try{ if(con != null){ con.close(); }}
		catch(SQLException ex){System.out.println(ex.getMessage());}
	}

	public void insertFishStick(FishStick fishstick) {
		PreparedStatement pstmt = null;
		try{
			if(con == null || con.isClosed()) {
				System.out.println("Cannot insert records, no connection or connection closed");
			}


			pstmt = con.prepareStatement(
					"INSERT INTO FishSticks (recordnumber, omega, lambda, uuid) " +
					"VALUES(?, ?, ?, ?)");
			pstmt.setInt(   1, fishstick.getRecordNumber());
			pstmt.setString(2, fishstick.getOmega());
			pstmt.setString(3, fishstick.getLambda());	
			pstmt.setString(4, fishstick.getUUID());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
	}

	public void deleteAllFishSticks() {
		PreparedStatement pstmt = null;
		try{
			if(con == null || con.isClosed()) {
				System.out.println("Cannot delete records, no connection or connection closed");
			}

			pstmt = con.prepareStatement(
					"TRUNCATE TABLE fishsticks");
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
	}
}
