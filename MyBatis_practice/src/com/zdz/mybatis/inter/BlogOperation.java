package com.zdz.mybatis.inter;

import com.zdz.mybatis.model.Blog;

public interface BlogOperation {
	public abstract Blog getBlogByBid(int bid);
}
