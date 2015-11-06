package com.zdz.mybatis.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zdz.mybatis.inter.BlogOperation;
import com.zdz.mybatis.model.Blog;

public class BlogDaoImpl extends SqlSessionDaoSupport  implements BlogDao{
	
	public BlogDaoImpl(SqlSessionFactory ssf)
	{
		setSqlSessionFactory(ssf);
	}
	@Override
	public Blog getBlogByBid(int bid) {
		if(this.getSqlSession()==null)
		{
			System.out.println("sqlsession==null");
		}
		BlogOperation bo  = this.getSqlSession().getMapper(BlogOperation.class);
		Blog blog = bo.getBlogByBid(2);
		return blog;
	}
	
}
