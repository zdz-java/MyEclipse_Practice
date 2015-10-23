package com.zdz.dao;

import com.zdz.bean.Student;

public interface TestDao {
	void insert(Student student);
	String getNameById(int id);
}
