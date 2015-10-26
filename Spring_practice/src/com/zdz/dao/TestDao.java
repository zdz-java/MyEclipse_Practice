package com.zdz.dao;

import javax.transaction.Transactional;

import com.zdz.bean.Student;
@Transactional
public interface TestDao {
	void insert(Student student);
	String getNameById(int id);
	Student getOne();
}
