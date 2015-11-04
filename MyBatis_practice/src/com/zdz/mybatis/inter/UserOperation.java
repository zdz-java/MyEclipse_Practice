package com.zdz.mybatis.inter;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdz.mybatis.model.Article;
import com.zdz.mybatis.model.User;
import com.zdz.util.PageInfo;

public interface UserOperation {
	abstract public User selectUserByID(int id);

	abstract public List selectUsers(String userName);

	abstract public int addUser(User user);

	abstract public void updateUser(User user);

	abstract public void deleteUser(int id);

	abstract public List<Article> getUserArticles(int id);

	public List<Article> selectArticleListPage(@Param("page") PageInfo page,@Param("userid") int userid);
}
