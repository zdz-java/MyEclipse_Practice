package com.zdz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.zdz.bean.Student;

public class TestDaoImpl implements TestDao {
	private SimpleJdbcTemplate jdbcTemplate;
	@Override
	public void insert(Student student) {
		String sql = "insert into test (name,sex,student_number,score) values(?,?,?,?)";
		jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getStudent_number(),student.getScore());
//		throw new NullPointerException();
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

	@Override
//	这个方法利用模版实现失败，使用临时自己实现的方法替代
	public Student getOne() {
		String sql = "select id,name,score,sex,student_number from test limit 1"; 
//		return jdbcTemplate.queryForObject(sql, Student.class, new RowMapper<Student>() {
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s = new Student();
//                s.setId(rs.getInt("id"));
//                s.setName(rs.getString("name"));
//                s.setScore(rs.getInt("score"));
//                s.setSex(rs.getString("sex"));
//                s.setStudent_number(rs.getInt("student_number"));
//                return s;
//            }});
//		return (Student)jdbcTemplate.q(sql,new Object[]{121L},Student.class);
		Student student = new Student();
		student.setName("tem");
		return student;
	}
	
	
}
