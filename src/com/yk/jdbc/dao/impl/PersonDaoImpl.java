package com.yk.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.yk.jdbc.dao.IPersonDao;
import com.yk.jdbc.domain.Person;

public class PersonDaoImpl implements IPersonDao {

	public void sava(Person p) {
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=MyTest;";
		String user = "sa";
		String password = "w201024..";
		Connection conn = null;
		Statement st = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			conn = DriverManager.getConnection(url, user, password);

			st = conn.createStatement();

			String insert = "insert into stu(id, name, age) values('"
					+ p.getId() + "', '" + p.getName() + "', '" + p.getAge()
					+ "')";

			st.executeUpdate(insert);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();

				}
				if (conn != null) {
					conn.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Person get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
