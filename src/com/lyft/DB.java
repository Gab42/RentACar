package com.lyft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class DB {
	
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.10.158:3306/ridebooked";
	// Database credentials
	static final String USER = "user";
	static final String PASS = "pass";
	static Connection conn = null;
	static Statement stmt = null;
    
	public static void openCon() throws ClassNotFoundException, SQLException{

		
		// Register JDBC driver
        Class.forName (JDBC_DRIVER);

        // Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        // Execute a query
        System.out.println("Creating Statement...");
        stmt = conn.createStatement();
        
        // Alternate way to connect
		/*MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("qhuser");
		dataSource.setServerName("192.168.10.158");		
		Connection conn = dataSource.getConnection();*/
	}
	
	public static void closeCon() throws SQLException{
		stmt.close();
		conn.close();
	}
	
	public static JSONArray query(String query) throws Exception{
		ResultSet rs = stmt.executeQuery(query);
		return ResultSetConvertor.convertResultSetIntoJSON(rs);
		//return rs;
	}
	

	
}
