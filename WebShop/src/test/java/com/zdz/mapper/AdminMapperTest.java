package com.zdz.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zdz.model.Admin;

public class AdminMapperTest {
	private String source = "Configuration.xml";
	private SqlSessionFactory sessionFactory;
	@Before
	public void prepare() throws IOException
	{
		Reader reader = Resources.getResourceAsReader(source); 
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	@Test
	public void addAdminTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		Admin admin = new Admin();
		admin.setAdminName("zdz");
		admin.setAdminType(1);
		adminMapper.addAdmin(admin);
		
		sqlSession.commit();
		sqlSession.close();
	}
}
