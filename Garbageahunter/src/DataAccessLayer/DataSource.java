package DataAccessLayer;

/** File: DataSource.java
 * Author: Jine Chang
 * Date: March 2016 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private Connection conn = null;
	private final String url = "jdbc:mysql://localhost:8889/";
	private final String dbName = "GarbageHunter";
	private final String driver = "com.mysql.jdbc.Driver";
	private final String userName = "root"; 
	private final String password = "root";
	
	public DataSource() {}
	
	public Connection createConnection(){
		try{
			if (conn != null){ 
				System.out.println("Cannot create new connection, one exists already");
			}
			else{ 
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,password);
			//	System.out.println("Connected to the database");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return conn;
	}


}