package com.yk.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=MyTest";
	public static String user = "sa";
	public static String password = "w201024..";
	
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getCon()
	{
		try{
			return DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}
