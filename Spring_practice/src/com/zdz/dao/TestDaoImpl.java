package com.zdz.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.zdz.bean.Student;

public class TestDaoImpl implements TestDao {
	private SimpleJdbcTemplate jdbcTemplate;
	@Override
	public void insert(Student student) {
		String sql = "insert into test (id,name,sex,student_number,score) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,student.getId(),student.getName(),student.getSex(),student.getStudent_number(),student.getScore());
		
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
