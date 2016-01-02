package com.zdz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.zdz.mapper.AdminMapper;
import com.zdz.model.Admin;
@Component
public class AdminServiceImpl implements AdminService {
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Admin adminLogin(String loginName, String loginPwd) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		Admin admin = adminMapper.adminLogin(loginName, loginPwd);
		
		sqlSession.commit();
		sqlSession.close();
		return admin;
		
	}

	@Override
	public List browseAdmin() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		List list = adminMapper.browseAdmin(); 
		
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public Admin loadAdmin(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		Admin admin = adminMapper.loadAdmin(id); 
		
		sqlSession.commit();
		sqlSession.close();
		return admin;
	}

	@Override
	public boolean delAdmin(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		boolean b = adminMapper.delAdmin(id); 
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean addAdmin(Admin admin) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		boolean b = adminMapper.addAdmin(admin); 
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean updateAdmin(Admin admin) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		boolean b = adminMapper.updateAdmin(admin); 
		
		sqlSession.commit();
		sqlSession.close();
		return b;
	}
	
}
