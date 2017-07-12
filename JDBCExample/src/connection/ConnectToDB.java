package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.jdbc.Driver;

public class ConnectToDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// com.mysql.cj.jdbc.Driver driver=new com.mysql.cj.jdbc.Driver();
			// DriverManager.registerDriver(driver);

			// connect driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loading driver successful........");
			// connect to database
			String url = "jdbc:mysql://localhost:3306/sakila";
			Connection connection = DriverManager.getConnection(url, "root", "ydong1Wang66");
			System.out.println("Database connected successful....");
			// querying
			java.sql.Statement statement = connection.createStatement();
			String sqlQuery="select*from actor ";
			ResultSet rs=statement.executeQuery(sqlQuery);
			//display database contents
			System.out.println("actor_table");
			System.out.println("actor_id\t"+"firstname\t"+"lastname");
			while(rs.next()){
				
			System.out.println(rs.getString(1)+" \t "+rs.getString(2)+"\t "+rs.getString(3));	
			}

			
			connection.close();
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("loading failed.........");
		}
	}

}
