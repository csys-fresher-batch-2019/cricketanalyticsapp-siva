package com.csys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.csys.exceptionmsg.DBexception;

public class TestConnection1 {

	public static Connection getConnection() throws DBexception {
		// String server = "192.168.56.215";
		// String server = "13.235.147.120";
		Connection connection;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String server = "localhost";
			connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "system", "oracle");
			System.out.println(connection);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBexception("", e);
		}
		return connection;
	}
}
