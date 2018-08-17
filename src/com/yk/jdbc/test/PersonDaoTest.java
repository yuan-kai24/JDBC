package com.yk.jdbc.test;

import com.yk.jdbc.dao.IPersonDao;
import com.yk.jdbc.dao.impl.PersonDaoImpl;
import com.yk.jdbc.domain.Person;

public class PersonDaoTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.setId(10);
		p.setName("桀桀");
		p.setAge(25);
		
		IPersonDao pe = new PersonDaoImpl();
		pe.sava(p);
	}
}
