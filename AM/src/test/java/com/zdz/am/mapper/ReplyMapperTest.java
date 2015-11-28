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

import com.zdz.am.model.Reply;
import com.zdz.am.util.Page;

public class ReplyMapperTest {
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
	public void findReplayByMsgIDTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);
		
		Page page = new Page();
		page.setBeginIndex(0);
		page.setEveryPage(10);
		List<Reply> list = replyMapper.findReplayByMsgID(14,page);
		assertEquals(list.get(0).getEmployeeID(), 3052);
		assertEquals(list.get(0).getReplyID(), 9);
		session.commit();
		session.close();
	}
	@Test
	public void findCountByMsgIDTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);
		
		int count = replyMapper.findCountByMsgID(14);
		assertEquals(count,3);
		
		session.commit();
		session.close();
	}
//	@Test
//	public void addReplayTest() throws IOException {
//		SqlSession session = sqlSessionFactory.openSession();
//		ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);
//		
//		Reply reply = new Reply();
//		reply.setReplyContent("temp");
//		reply.setEmployeeID(3052);
//		reply.setMessageID(14);
//		
//		replyMapper.addReplay(reply);
//		
//		session.commit();
//		session.close();
//	}
}
