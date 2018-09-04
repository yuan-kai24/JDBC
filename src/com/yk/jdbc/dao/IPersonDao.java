package com.yk.jdbc.dao;

import java.util.List;

import com.yk.jdbc.domain.Person;
	
public interface IPersonDao{
		//保存数据
	void sava(Person p);
	
	//修改指定人信息
	void update(Person p);
	
	//删除人
	void delete(int id);
	
	//获取人
	Person get(int id);
	
	//获取所有信息
	List<Person> getAll();
}
