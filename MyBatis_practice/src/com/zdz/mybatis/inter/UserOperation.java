package com.zdz.mybatis.inter;

import com.zdz.mybatis.model.User;

public interface UserOperation {
	abstract public User selectUserByID(int id);
}
