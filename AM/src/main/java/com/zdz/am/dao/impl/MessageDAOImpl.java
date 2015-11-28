package com.zdz.am.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.am.dao.MessageDAO;
import com.zdz.am.mapper.MessageMapper;
import com.zdz.am.model.Message;
import com.zdz.am.util.Page;

@Component
public class MessageDAOImpl implements MessageDAO{
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public void addMessage(Message message) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
		
		messageMapper.addMessage(message);
		
		sqlSession.commit();
		sqlSession.close();
		
	}

	@Override
	public void updateMessage(Message message) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
		
		messageMapper.updateMessage(message);
		
		sqlSession.commit();
		sqlSession.close();		
	}

	@Override
	public void deleteMessage(int messageID) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
		
		messageMapper.deleteMessage(messageID);;
		
		sqlSession.commit();
		sqlSession.close();		
	}

	@Override
	public List<Message> findAllMessagee(Page page) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
		
		List<Message> list = messageMapper.findAllMessage(page);
		
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public Message findMessageById(int messageID) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
		
		Message message = messageMapper.findMessageById(messageID);
		
		sqlSession.commit();
		sqlSession.close();
		return message;
	}

	@Override
	public int findAllCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
		
		int count = messageMapper.findAllCount();
		
		sqlSession.commit();
		sqlSession.close();
		return count;
	}

}
