package dataaccesslayer;
/* File: CabbageDaoImpl.java
 * Author: Stanley Pieda
 * Date: Sept, 2017
 * References:
 * Ram N. (2013). Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */ 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datatransfer.FishStick;

/**
 * Partially complete implementation for DAO design pattern.
 * Has one insert method, and one find-by-UUID method.
 * @author Stanley Pieda
 */
public class FishStickDaoImpl implements FishStickDao{
	
	/** 
	 * Returns a reference to a FishStick object, loaded with data
	 * from the database, based on lookup using a UUID as String
	 * @param uuid String based UUID
	 * @return FishStick transfer object, or null if no match based on uuid found
	 * @throws SQLException
	 * @author Stanley Pieda
	 */
		@Override
	public FishStick findByUUID(String uuid) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FishStick fishStick = null;
		try{
			DataSource source = new DataSource();
			con = source.getConnection();
			pstmt = con.prepareStatement(
					"SELECT * FROM FishSticks WHERE uuid = ?");
			pstmt.setString(1, uuid);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			fishStick = new FishStick();
			fishStick.setId(rs.getInt("id"));
			fishStick.setRecordNumber(rs.getInt("recordnumber"));
			fishStick.setOmega(rs.getString("omega"));
			fishStick.setLambda(rs.getString("lambda"));
			fishStick.setUUID(rs.getString("uuid"));
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
		finally{
			try{ if(rs != null){ rs.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return fishStick;
	}

    /**
	 * Accepts a FishTick object reference, inserting the encapsulated data into database.
	 * @param fishStick with data for record insertion
	 * @throws SQLException
	 * @author Stanley Pieda
	 */
	public void insertFishStick(FishStick fishStick) throws SQLException{
    	DataSource source = new DataSource();
		Connection con = source.getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(
					"INSERT INTO FishSticks (recordnumber, omega, lambda, uuid) " +
					"VALUES(?, ?, ?, ?)");
			pstmt.setInt(1, fishStick.getRecordNumber());
			pstmt.setString(2, fishStick.getOmega());
			pstmt.setString(3, fishStick.getLambda());	
			pstmt.setString(4,  fishStick.getUUID());
			pstmt.executeUpdate();
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
	}
}
