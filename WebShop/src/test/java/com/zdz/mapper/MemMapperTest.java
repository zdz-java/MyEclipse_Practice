package com.zdz.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zdz.model.Cart;
import com.zdz.model.Member;
import com.zdz.model.Memberlevel;

public class MemMapperTest {
	private String source = "Configuration.xml";
	private SqlSessionFactory sessionFactory;
	@Before
	public void prepare() throws IOException
	{
		Reader reader = Resources.getResourceAsReader(source); 
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	@Test
	public void browseTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);
		
		List<Member> members = memMapper.browseMember();
		List<Memberlevel> memberlevels = memMapper.browseMemberLevel();
		
		Assert.assertEquals(members.get(0).getMemberName(), "刘桥");
		Assert.assertEquals(memberlevels.get(0).getLevelName(), "普通会员");
		sqlSession.commit();
		sqlSession.close();
	}
}
