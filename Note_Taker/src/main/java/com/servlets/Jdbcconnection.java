package com.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class Jdbcconnection{
		public static Connection initializeDatabase() 
		        throws SQLException, ClassNotFoundException 
		        {
			String dbDriver = "com.mysql.jdbc.Driver"; 
	        String dbURL = "jdbc:mysql://localhost:3306/"; 
	        
	        // Database name to access 
	        String dbName = "myhiber"; 
	        String dbUsername = "root"; 

			Class.forName(dbDriver);
			Connection con=DriverManager.getConnection(dbURL+dbName,dbUsername,"");
		
			return con;
		   
		}
}
