package com.zdz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.zdz.bean.User;
@Component
public class UserDaoImpl implements UserDao{
	private SimpleJdbcTemplate jdbcTemplate;
	
	public SimpleJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(User user) {
		String sql = "insert into user values(null,?,?,?)";
		jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getRealname());

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List list() {
		String sql = "select * from user";
//		jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getRealname());
		return jdbcTemplate.queryForList("select * from user");
	}

}
