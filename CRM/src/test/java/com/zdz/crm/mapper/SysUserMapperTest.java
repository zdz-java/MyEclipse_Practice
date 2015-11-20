package com.zdz.crm.mapper;

import static org.junit.Assert.*;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zdz.crm.model.SysUser;

public class SysUserMapperTest {
	@Before
	public void prepare()
	{
		
	}
	@Test
	public void findByIdTest() throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = session.getMapper(SysUserMapper.class);
		SysUser user = sysUserMapper.findById((long) 2);
		assertEquals(user.getUsrName(),"admin");
		session.commit();
		session.close();
	}
}
