package com.yk.jdbc.test;

import java.util.List;

import org.junit.Test;

import com.yk.jdbc.dao.IPersonDao;
import com.yk.jdbc.dao.impl.PersonDaoImpl;
import com.yk.jdbc.domain.Person;

public class PersonDaoTest {
	
	
	@Test
	public void delete()
	{
		
		IPersonDao pe = new PersonDaoImpl();
		pe.delete(10);
	}
	@Test
	public void update()
	{
		
		
		IPersonDao pe = new PersonDaoImpl();
		Person p = pe.get(3);
		System.out.println(p.getId() + p.getName() + p.getAge());
		p.setName("^_^");
		pe.update(p);
	}
	
	@Test
	public void getall()
	{
		
		
		IPersonDao pe = new PersonDaoImpl();
		List<Person> p = pe.getAll();
		for (Person np : p) {
			System.out.println(np);
		}
	}
		
}
