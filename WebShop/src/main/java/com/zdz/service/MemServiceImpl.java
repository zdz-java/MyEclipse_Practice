package com.zdz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.mapper.CartMapper;
import com.zdz.mapper.MemMapper;
import com.zdz.model.Member;
import com.zdz.model.Memberlevel;
@Component
public class MemServiceImpl implements MemService {
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Member memLogin(String loginName, String loginPwd) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		Member member = memMapper.memLogin(loginName, loginPwd);

		sqlSession.commit();
		sqlSession.close();
		return member;
	}

	@Override
	public List browseMemberLevel() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		List list = memMapper.browseMemberLevel();

		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public Memberlevel loadMemberLevel(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		Memberlevel memberlevel = memMapper.loadMemberLevel(id);

		sqlSession.commit();
		sqlSession.close();
		return memberlevel;
	}

	@Override
	public boolean chkLoginName(String loginName) throws Exception {
		//
		return false;
	}

	@Override
	public boolean addMember(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		boolean b = memMapper.addMember(member);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		boolean b = memMapper.updateMember(member);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public List browseMember() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		List list = memMapper.browseMember();

		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public boolean delMember(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		boolean b = memMapper.delMember(id);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public Member loadMember(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);

		Member member = memMapper.loadMember(id);

		sqlSession.commit();
		sqlSession.close();
		return member;
	}

}
