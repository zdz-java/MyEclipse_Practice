package com.zdz.crm.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zdz.crm.model.SysRole;
import com.zdz.crm.model.SysUser;

public class SysUserMapperTest {
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
	public void findByIdTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = session.getMapper(SysUserMapper.class);
		
		SysUser sysuser = sysUserMapper.findById((long) 2);
		assertEquals(sysuser.getUsrName(), "admin");
		assertEquals(sysuser.getSysRole().getRoleName(), "系统管理员");
		session.commit();
		session.close();
	}
	
	@Test
	public void saveAndDeleteTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = session.getMapper(SysUserMapper.class);
		
		SysUser user = new SysUser();
		SysRole role = new SysRole();
		role.setRoleId((long)6);
		
		user.setUsrFlag(1);
		user.setUsrName("zdz");
		user.setUsrPassword("121");
		user.setSysRole(role);
		
		sysUserMapper.save(user);
		session.commit();
		
		SysUser getUser = sysUserMapper.findById(user.getUsrId());
		assertEquals(getUser.getUsrName(),"zdz");
		assertEquals((long)getUser.getSysRole().getRoleId(),6);
		
		sysUserMapper.delete(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void findByTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = session.getMapper(SysUserMapper.class);
		
		SysUser user = new SysUser();
		
		user.setUsrFlag(1);
		user.setUsrName("zdz");
		user.setUsrPassword("121");
		
		sysUserMapper.save(user);
		session.commit();
		
		List<SysUser> users;
		users = sysUserMapper.findByUsrName("zdz");
		assertEquals(users.get(users.size()-1).getUsrPassword(),"121");
		users = sysUserMapper.findByUsrPassword("121");
		assertEquals(users.get(users.size()-1).getUsrName(),"zdz");
		users = sysUserMapper.findByUsrFlag(1);
		assertEquals(users.get(users.size()-1).getUsrName(),"zdz");
		
		sysUserMapper.delete(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void findByPropertyTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = session.getMapper(SysUserMapper.class);
		
		SysUser user = new SysUser();
		
		user.setUsrFlag(1);
		user.setUsrName("zdz");
		user.setUsrPassword("121");
		
		sysUserMapper.save(user);
		session.commit();
		
		List<SysUser> users;
		users = sysUserMapper.findByProperty("usrName","zdz");
		assertEquals(users.get(users.size()-1).getUsrPassword(),"121");
		users = sysUserMapper.findByProperty("usrPassword","121");
		assertEquals(users.get(users.size()-1).getUsrName(),"zdz");
		users = sysUserMapper.findByProperty("usrFlag",1);
		assertEquals(users.get(users.size()-1).getUsrName(),"zdz");
		users = sysUserMapper.findByProperty("not","not");
		assertEquals(users.size(),0);
		
		sysUserMapper.delete(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void findByExampleTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		SysUserMapper sysUserMapper = session.getMapper(SysUserMapper.class);
		
		SysUser user = new SysUser();
		SysRole role = new SysRole();
		role.setRoleId((long)6);

		user.setSysRole(role);
		user.setUsrFlag(1);
		user.setUsrName("zdz");
		user.setUsrPassword("121");
		
		sysUserMapper.save(user);
		session.commit();
		
		SysUser example = new SysUser();
//		example.setUsrFlag(1);
//		example.setUsrName("zdz");
		example.setSysRole(role);
		
		List<SysUser> users;
		users = sysUserMapper.findByExample(example);
		assertEquals(users.get(users.size()-1).getUsrPassword(),"121");
		assertEquals(users.get(users.size()-1).getUsrName(),"zdz");
		assertEquals((int)users.get(users.size()-1).getUsrFlag(),1);
		
		sysUserMapper.delete(user);
		session.commit();
		session.close();
	}
}
