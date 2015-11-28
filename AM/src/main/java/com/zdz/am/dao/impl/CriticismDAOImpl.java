package com.zdz.am.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.am.dao.CriticismDAO;
import com.zdz.am.mapper.CriticismMapper;
import com.zdz.am.model.Criticism;

@Component
public class CriticismDAOImpl implements CriticismDAO{
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public void addCriticism(Criticism criticism) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CriticismMapper criticismMapper = sqlSession.getMapper(CriticismMapper.class);
		
		criticismMapper.addCriticism(criticism);
		
		sqlSession.commit();
		sqlSession.close();
	}
	public Criticism findCriticismByMsgID(int messageID) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CriticismMapper criticismMapper = sqlSession.getMapper(CriticismMapper.class);
		
		Criticism criticism = criticismMapper.findCriticismByMsgID(messageID);
		
		sqlSession.commit();
		sqlSession.close();
		return criticism;
	}
}
