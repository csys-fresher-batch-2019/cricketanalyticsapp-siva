package com.csys.util;



import java.sql.Connection;
import java.sql.DriverManager;



public class TestConnection1 {
	
	
	public static Connection getConnection() throws Exception {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		  String server = "localhost";
		  //String server = "192.168.56.215";
		 //String server = "13.235.147.120";
		 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:XE", "system","oracle");
			System.out.println(connection);
			return connection;
	}
}

	
