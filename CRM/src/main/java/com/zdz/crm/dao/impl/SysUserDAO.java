package com.zdz.crm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.crm.dao.ISysRoleDAO;
import com.zdz.crm.dao.ISysRoleRightDAO;
import com.zdz.crm.dao.ISysUserDAO;
import com.zdz.crm.mapper.SysUserMapper;
import com.zdz.crm.model.SysUser;
import com.zdz.crm.util.PageResult;

@Component
public class SysUserDAO implements ISysUserDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static final Log log = LogFactory.getLog(SysUserDAO.class);
	private ISysRoleDAO sysRoleDao = null;
	private ISysRoleRightDAO roleRDao = null;

	public ISysRoleDAO getSysRoleDao() {
		return sysRoleDao;
	}

	public void setSysRoleDao(ISysRoleDAO sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	public ISysRoleRightDAO getRoleRDao() {
		return roleRDao;
	}

	public void setRoleRDao(ISysRoleRightDAO roleRDao) {
		this.roleRDao = roleRDao;
	}

	public Log getLog() {
		return log;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	// 该方法没有实现，留待
	@Override
	public PageResult findAll(Map paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(SysUser instance) {
		log.debug("find by example begin");

		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
		List users = null;
		try {
			users = sysUserMapper.findByExample(instance);
			sqlSession.commit();
			log.debug("find by example successful");
		} catch (RuntimeException e) {
			log.error("find by example failed", e);
			throw e;
		} finally {
			sqlSession.close();
		}
		return users;
	}

	// 该方法没有实现，留待
	@Override
	public SysUser merge(SysUser detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	// 该方法没有实现，留待
	@Override
	public void attachDirty(SysUser instance) {
		// TODO Auto-generated method stub

	}

	// 该方法没有实现，留待
	@Override
	public void attachClean(SysUser instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(SysUser transientInstance) {
		log.debug("saving SysUser instance");

		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

		try {
			sysUserMapper.save(transientInstance);
			sqlSession.commit();
			log.debug("save successful");
		} catch (RuntimeException e) {
			log.error("save failed", e);
			throw e;
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public void delete(SysUser persistentInstance) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

		log.debug("deleting SysUser instance");
		try {
			sysUserMapper.delete(persistentInstance);
			sqlSession.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public SysUser findById(Long id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

		SysUser sysUser = sysUserMapper.findById(id);
		sqlSession.commit();
		sqlSession.close();
		return sysUser;
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

		List list = sysUserMapper.findByProperty(propertyName, value);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public List findByUsrName(Object usrName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

		List list = sysUserMapper.findByUsrName(usrName);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public List findByUsrPassword(Object usrPassword) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

		List list = sysUserMapper.findByUsrPassword(usrPassword);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public List findByUsrFlag(Object usrFlag) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

		List list = sysUserMapper.findByUsrFlag(usrFlag);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

}
