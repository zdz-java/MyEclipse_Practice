package com.zdz.mybatis.inter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zdz.mybatis.model.Article;
import com.zdz.mybatis.model.Blog;
import com.zdz.mybatis.model.User;
import com.zdz.util.PageInfo;

public interface UserOperation {
	abstract public User selectUserByID(int id);

	abstract public List selectUsers(String userName);

	abstract public int addUser(User user);

	abstract public void updateUser(User user);

	abstract public void deleteUser(int id);

	abstract public List<Article> getUserArticles(int id);

	public List<Article> selectArticleListPage(@Param("page") PageInfo page,
			@Param("userid") int userid);

	public List<Blog> dynamicIfTest(Blog blog);

	public List<Blog> dynamicChooseTest(Blog blog);

	public List<Blog> dynamicTrimTest(Blog blog);

	public List<Blog> dynamicForeachTest(List<Integer> bids);

	public List<Blog> dynamicForeach3Test(Map<String, Object> params);
}
