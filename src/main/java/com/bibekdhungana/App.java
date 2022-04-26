package com.bibekdhungana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "RisinG123@";
	
	
    public static void main( String[] args ){

    	Connection con;
    	String sqlQuery = "INSERT INTO UserDetails VALUES(?,?)";
    	String usernameInput = "Bibek";
    	String passwordInput = "Lubbock";
    	
    	
        //loading .class file to memory
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	
    	//creating the Connection object
    	try {
    		//create connection object
			con = DriverManager.getConnection(url,username,password);
			
			//creating prepare statement
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, usernameInput);
			ps.setString(2, passwordInput);
			
			//executing the query
			ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("Value Inserted Sucessfully");
    	
    	
    	
    	
    	
    	
    }
}
