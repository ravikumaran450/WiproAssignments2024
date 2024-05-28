package com.wipro.jdbc.util;

import java.sql.*;


public class DBCon {
	public static Connection getConnection() throws SQLSyntaxErrorException,SQLException,ClassNotFoundException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE","system","rps@123");
		return con;
	}
}
