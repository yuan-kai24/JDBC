package com.yk.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yk.jdbc.dao.IPersonDao;
import com.yk.jdbc.domain.Person;
import com.yk.jdbc.util.JDBCUtil;

public class PersonDaoImpl implements IPersonDao {

	private static Statement st = null;
	private static ResultSet res = null;
	private static Connection conn = null;

	public void sava(Person p) {

		try {
			conn = JDBCUtil.getCon();

			st = conn.createStatement();

			String insert = "insert into stu(id, name, age) values('"
					+ p.getId() + "', '" + p.getName() + "', '" + p.getAge()
					+ "')";

			st.executeUpdate(insert);

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

		try {
			conn = JDBCUtil.getCon();

			st = conn.createStatement();
			String insert = "update stu set name='" + p.getName() + "',age="
					+ p.getAge() + " where id=" + p.getId() + "";

			st.executeUpdate(insert);

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
	public void delete(int id) {

		try {
			conn = JDBCUtil.getCon();

			st = conn.createStatement();

			String insert = "delete from stu where id=" + id;

			st.executeUpdate(insert);

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
	public Person get(int id) {
		Person p = new Person();
		try {
			conn = JDBCUtil.getCon();

			st = conn.createStatement();

			String sql = "select * from stu where id=" + id + "";

			res = st.executeQuery(sql);
			if (res.next()) {
				p.setId(res.getInt("id"));
				p.setName(res.getString("name"));
				p.setAge(res.getInt("age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null) {
					res.close();
				}
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

		return p;
	}

	@Override
	public List<Person> getAll() {

		List<Person> p = new ArrayList<>();

		try {
			conn = JDBCUtil.getCon();

			st = conn.createStatement();
			String sql = "select * from stu";

			res = st.executeQuery(sql);

			while (res.next()) {
				Person np = new Person();
				np.setId(res.getInt("id"));
				np.setAge(res.getInt("age"));
				np.setName(res.getString("name"));
				p.add(np);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
