package com.zdz.am.mapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

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
	public void findCriticismByMsgIDTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		CriticismMapper criticismMapper = session.getMapper(CriticismMapper.class);
		
		Criticism criticism = criticismMapper.findCriticismByMsgID(3);
		assertEquals(criticism.getEmployeeID(), 3052);
		assertEquals(criticism.getCriticismContent(), "<p>不错，以后大家好好干活！！</p>");
		session.commit();
		session.close();
	}
	@Test
	public void addCriticismTest()
	{
		SqlSession session = sqlSessionFactory.openSession();
		CriticismMapper criticismMapper = session.getMapper(CriticismMapper.class);
		
		Criticism toinsert = new Criticism();
		toinsert.setCriticismContent("temp");
		toinsert.setMessageID(16);
		toinsert.setEmployeeID(3052);
		criticismMapper.addCriticism(toinsert);
		session.commit();
		
		Criticism criticism = criticismMapper.findCriticismByMsgID(toinsert.getCriticismID());
		assertEquals(criticism.getMessageID(), 16);
		assertEquals(criticism.getCriticismContent(), "temp");
		criticismMapper.deleteCriticismByMsgID(toinsert.getCriticismID());
		session.commit();
		session.close();
	}
}
