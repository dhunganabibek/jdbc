package com.bibekdhungana;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class App {
	
    public static void main( String[] args ) throws Exception{
    	
    	//loading information of database from properties file
    	FileInputStream fis = new FileInputStream(new File("src/main/java/com/bibekdhungana/databaseInfo.properties"));
    	Properties databaseProperty = new Properties();
    	databaseProperty.load(fis);
    	
    	
    	//database information
    	String url = databaseProperty.getProperty("url");
    	String username = databaseProperty.getProperty("username");
    	String password = databaseProperty.getProperty("password");
    	

    	//sql query using prepared statement
    	Connection con;
    	String sqlQuery = "INSERT INTO UserDetails VALUES(?,?)";
    	Scanner sc = new Scanner(System.in);
    	
    	//getting input from console to save in database
    	System.out.println("Enter username:");
    	String usernameInput = sc.nextLine();
    	System.out.println("Enetr Password");
    	String passwordInput = sc.nextLine();
    	
    	
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
