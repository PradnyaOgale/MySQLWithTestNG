package com.MySQLWithTestNG.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseSetup {

	static Connection con = null;
	protected static Statement stmt;
	public static String DB_URL = "jdbc:mysql://127.0.0.1:3306/student";
	public static String DB_USER = "root";
	public static String DB_PASS = "root";

	@BeforeTest
	public void setUp() {
		try {
			String dbClass = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbClass).getDeclaredConstructor().newInstance();
			Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			stmt=con.createStatement();
			System.out.println("Connection established...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		if(con!=null) {
			con.close();
			System.out.println("Connection closed!!!");
		}	
	}
}
