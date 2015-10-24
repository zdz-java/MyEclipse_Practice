package com.zdz.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.zdz.bean.Student;

public class TestDaoImpl implements TestDao {
	private SimpleJdbcTemplate jdbcTemplate;
	@Override
	public void insert(Student student) {
		String sql = "insert into test (name,sex,student_number,score) values(?,?,?,?)";
		jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getStudent_number(),student.getScore());
		throw new NullPointerException();
	}

	@Override
	public String getNameById(int id) {
		return null;
	}

	public SimpleJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
