package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/employee";
	private static String userName = "root";
	private static String password = "yenuli";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);	
		}
		catch(Exception e){
			System.out.println("database connection is not success!!!");
	}
		return con;
}
}
