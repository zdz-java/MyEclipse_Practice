package com.zdz.am.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.am.dao.ReplyDAO;
import com.zdz.am.mapper.ReplyMapper;
import com.zdz.am.model.Reply;
import com.zdz.am.util.Page;

@Component
public class ReplyDAOImpl implements ReplyDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public void addReplay(Reply replay) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
		
		replyMapper.addReplay(replay);
		
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);

		List list = replyMapper.findReplayByMsgID(messageID, page);
		
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public int findCountByMsgID(int messageID) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
		
		int count = replyMapper.findCountByMsgID(messageID);
		
		sqlSession.commit();
		sqlSession.close();
		return count;
	}

}
