package com.yk.jdbc.conn;

import java.beans.Statement;
import java.sql.*;

public class Connection {
	
	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=MyTest;";
	private static String username = "sa";
	private static String password = "w201024..";
	private static java.sql.Connection conn = null;
	
	static{
		try {
			//加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		String str = "create table stu(id int,name nvarchar(50),age int)";
		
		try {
			java.sql.Statement st = conn.createStatement();
			int row = st.executeUpdate(str);
			System.out.println(row);
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
