package com.zdz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.mapper.OrderMapper;
import com.zdz.mapper.WordMapper;
import com.zdz.model.Leaveword;
@Component
public class WordServiceImpl implements WordService {
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean addWord(Leaveword word) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);

		boolean b = wordMapper.addWord(word);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

//	未实现
	@Override
	public List browseWord(int pageSize, int pageNo) throws Exception {
		return null;
	}

	@Override
	public List browseWord() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);

		List list = wordMapper.browseWord();

		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public int countWord() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);

		int i = wordMapper.countWord();

		sqlSession.commit();
		sqlSession.close();
		return i;
	}

	@Override
	public boolean delWord(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);

		boolean b = wordMapper.delWord(id);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public Leaveword loadWord(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);

		Leaveword leaveword = wordMapper.loadWord(id);

		sqlSession.commit();
		sqlSession.close();
		return leaveword;
	}

	@Override
	public boolean updateWord(Leaveword word) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);

		boolean b = wordMapper.updateWord(word);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}
	
}
