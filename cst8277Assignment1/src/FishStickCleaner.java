/*
 * File: FishStickCleaner.java
 * Course number: cst8277_winter 2018
 * Professor: Rejaul Chowdhury,Stanley Pieda
 * Student: Tao Wang, 040857654
 * version: 1/0
 * created date: January 22, 2018
 * Description:class for deleting all records of the table fishsticks in the DB
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for removing all records of the table fishsticks in the Database.
 * @author Tao Wang
 * @version 1.0
 * Date: January 2018
 * */
public class FishStickCleaner {

	/**
	 * Method for deleting all records of the fishsticks table.
	 * @param Connection con , the current connection between program and the database
	 */
	public static void deleteAllFishStick(Connection con) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		try{
			if(con == null || con.isClosed()) {
				System.out.println("Cannot delete records, no connection or connection closed");
			}
			//delete all records
			pstmt = con.prepareStatement(
					"TRUNCATE TABLE fishsticks");
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{// close the preparedstatement
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
	}



}
