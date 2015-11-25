package com.zdz.am.mapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zdz.am.model.Criticism;


public class CriticismMapperTest {
	private String resource;
	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void prepare() throws IOException {
		resource = "mybatis-config.xml";
		inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	@Test
	public void findByIdTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		CriticismMapper criticismMapper = session.getMapper(CriticismMapper.class);
		
		Criticism criticism = criticismMapper.findCriticismByMsgID(3);
		assertEquals(criticism.getEmployeeID(), 3052);
		assertEquals(criticism.getCriticismContent(), "<p>不错，以后大家好好干活！！</p>");
		session.commit();
		session.close();
	}
}
