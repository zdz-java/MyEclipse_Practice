package com.zdz.mybatis.dao;

import com.zdz.mybatis.model.Blog;

public interface BlogDao {
	public abstract Blog getBlogByBid(int bid);
}
