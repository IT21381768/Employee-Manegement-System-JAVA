package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Employee> validate(String userName, String password){
		
		ArrayList<Employee> emp = new ArrayList<>();
		
		//validate
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
     		String sql = "select * from employee where username='" + userName + "' and password='" + password + "'";
     		rs = stmt.executeQuery(sql);
     		
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
	
	

	//insert
	public static boolean insertemployee(String name,String email,String phone,String username,String password,String gender) {
		
		boolean isSuccess = false;
		
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
		     		
		     		//String sql = "insert into employee values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"','"+gender+"',)";
					 String sql = "INSERT INTO employee VALUES (0, '" + name + "', '" + email + "', '" + phone + "', '" + username + "', '" + password + "', '" + gender + "')";

					int rs = stmt.executeUpdate(sql);
					
					if(rs > 0) {
						isSuccess = true;	
					} else {
						isSuccess = false;
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
		
		
		return isSuccess;
	}
	
}