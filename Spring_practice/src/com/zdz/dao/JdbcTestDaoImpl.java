package com.zdz.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.zdz.bean.Student;

public class JdbcTestDaoImpl extends SimpleJdbcDaoSupport implements TestDao{

	@Override
	public void insert(Student student) {
		String sql = "insert into test (id,name,sex,student_number,score) values(?,?,?,?,?)";
		getJdbcTemplate().update(sql,student.getId(),student.getName(),student.getSex(),student.getStudent_number(),student.getScore());

	}

	@Override
	public String getNameById(int id) {
		return null;
	}

	@Override
	public Student getOne() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
