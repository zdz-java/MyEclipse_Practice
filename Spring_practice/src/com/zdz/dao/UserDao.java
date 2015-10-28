package com.zdz.dao;

import java.util.List;

import com.zdz.bean.User;

public interface UserDao {
	abstract public void create(User user);

	abstract public void update(User user);

	abstract public User get(String username);

	abstract public void delete(User user);

	abstract public List<User> list();
	
}
