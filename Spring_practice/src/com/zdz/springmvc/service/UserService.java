package com.zdz.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.bean.User;
import com.zdz.dao.UserDao;
@Component
public class UserService {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void create(User user)
	{
		userDao.create(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public Object get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	public List list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}
	
}
