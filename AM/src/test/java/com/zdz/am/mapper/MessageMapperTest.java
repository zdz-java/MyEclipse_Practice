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

import com.zdz.am.model.Employee;
import com.zdz.am.model.Message;
import com.zdz.am.util.Page;

public class MessageMapperTest {
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
		MessageMapper messageMapper = session.getMapper(MessageMapper.class);
		
		Message message = messageMapper.findMessageById(20);
		assertEquals(message.getMessageTitle(), "测试一下发布！");
		
		session.commit();
		session.close();
	}
	@Test
	public void addMessageAndDleteTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		MessageMapper messageMapper = session.getMapper(MessageMapper.class);
		
		Message toadd = new Message();
		toadd.setMessageTitle("zdz");
		toadd.setEmployeeID(3052);
		messageMapper.addMessage(toadd);
		session.commit();
		
		Message message = messageMapper.findMessageById(toadd.getMessageID());
		assertEquals(message.getMessageTitle(), "zdz");
		
		messageMapper.deleteMessage(toadd.getMessageID());
		
		session.commit();
		session.close();
	}
	@Test
	public void otherTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		MessageMapper messageMapper = session.getMapper(MessageMapper.class);
		
		Message toadd = new Message();
		toadd.setMessageTitle("zdz");
		toadd.setEmployeeID(3052);
		messageMapper.addMessage(toadd);
		session.commit();
		
		Message message = messageMapper.findMessageById(toadd.getMessageID());
		assertEquals(message.getMessageTitle(), "zdz");
		
		message.setMessageTitle("zdzdz");;
		messageMapper.updateMessage(message);;
		session.commit();
		
		Page page = new Page();
		page.setBeginIndex(0);
		page.setEveryPage(10);
		List<Message> list = messageMapper.findAllMessage(page );
		assertEquals(list.get(list.size()-1).getMessageTitle(), "zdzdz");
		
		messageMapper.deleteMessage(toadd.getMessageID());
		
		assertEquals(messageMapper.findAllCount(),6);
		
		session.commit();
		session.close();
	}
}
