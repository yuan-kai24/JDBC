
package com.yk.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryClass {
	
	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=MyTest;";
	private static String username = "sa";
	private static String password = "w201024..";
	private static Connection conn = null;
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(conn);
		
		try {
			String str = "select * from stu";
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(str);
			while(res.next())
			{
				System.out.println(res.getInt("id") + res.getString("name") + res.getInt("age"));
			}
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
