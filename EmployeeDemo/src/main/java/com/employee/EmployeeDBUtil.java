package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDBUtil {
	
	public static List<Employee> validate(String userName, String password){
		
		ArrayList<Employee> emp = new ArrayList<>();
		
		//crate database connection
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String pass = "yenuli";
		
		//validate
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
     		String sql = "select * from employee where username='" + userName + "' and password='" + password + "'";
	//		String sql = "select * from employee where username='" + userName + "' and password='" + password + "'";

			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);
				String gender = rs.getString(7);
						
				Employee e = new Employee(id,name,email,phone,userU,passU,gender);
				emp.add(e);		
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return emp;
		
	}
	
}
