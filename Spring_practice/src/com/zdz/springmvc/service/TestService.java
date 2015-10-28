package com.zdz.springmvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.bean.Student;
import com.zdz.dao.TestDao;
@Component
public class TestService {
	private TestDao testDao;
	public void Save(Student s)
	{
		testDao.insert(s);
	}
	public Student getOne()
	{
		return testDao.getOne();
	}
	public TestDao getTestDao() {
		return testDao;
	}
	@Autowired
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
}