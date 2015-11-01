package com.zdz.mybatis.inter;

import java.util.List;

import com.zdz.mybatis.model.User;

public interface UserOperation {
	abstract public User selectUserByID(int id);
	abstract public List selectUsers(String userName);
	abstract public int addUser(User user);
	abstract public void updateUser(User user);
	abstract public void deleteUser(int id);
}
