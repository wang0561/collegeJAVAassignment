/* File: NoNibernate.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Description: Using JDBC instead of Hibernate.
 */
import java.sql.*;

/* This is an example of using JDBC to access a database WITHOUT using Hibernate
 * This code will need to be adjusted to work with your own database (credentials, jdbc URL, etc)
 * Depending on the state of your database (existence of tables, contents of tables), errors may result
 */
public class NoHibernate {

	public static void main(String[] args) {
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://192.168.225.141:3306/";
		String dbName = "test";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "tgk"; 
		String password = "tgkpass";

		Statement st = null;
		ResultSet rs = null;


		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);

			System.out.println("Connected to the database");

			st = conn.createStatement();
			rs = st.executeQuery("SELECT * from Employee");
			while (rs.next()){

				System.out.println(rs.getString(1) +','+ rs.getString(2) + ','+ rs.getString(3));
				//System.out.println(rs.getString("id") +','+ rs.getString("name") + ','+ rs.getString(3));
			}

			//   st.executeUpdate("INSERT into Employee (empid, empname) VALUES (40000, 'Test person' ) ");

                        /* Insert 1000 rows into the account table */
			for (int i=0; i<1000; i++)
			{
				String s = "Insert into account (accno,owner) values ("+i+",'test"+i+"')";
				System.out.println(s);
				st.executeUpdate(s);
			}
			conn.close();
			System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
