package dataaccesslayer;
/* File: DataSource.java
 * Author: Stanley Pieda
 * Date: Jan 2018
 * References:
 * Ram N. (2013). Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */ 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The only purpose of this class is to open a connection to a MySQL database
 * and return a reference to that connection object.
 * Note: It is your responsibility to close the connection.
 * @author Stanley Pieda
 *
 */
public class DataSource {
	private Connection con = null;
	private final String connectionString = "jdbc:mysql://localhost/assignment2?useSSL=true";
	private final String username = "assignment2";
	private final String password = "password";

	/**
	 * Returns a reference to a connection object, configured to communicate with 
	 * a MySQL database. Note: It is your responsibility to close the connection
	 * when done with it.
	 * @return A connection to the configured MySQL database
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException{
		try {
		if(con != null){
			System.out.println("Cannot create new connection, one exists already");
		}
		else{
			con = DriverManager.getConnection(connectionString, username, password);
		}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
		return con;
	}
}
