package com.zdz.crm.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdz.crm.mapper.SysUserMapper;
import com.zdz.crm.model.SysRole;
import com.zdz.crm.model.SysUser;

public class UserinfoServiceTest {
	
	@Test
	public void findByIdTest()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserinfoService userinfoService = (UserinfoService)ac.getBean("userinfoService");
		
		SysUser sysuser = userinfoService.findByUsrId((long) 2);
		assertEquals(sysuser.getUsrName(), "admin");
		assertEquals(sysuser.getSysRole().getRoleName(), "系统管理员");
	}
	
	@Test
	public void saveAndDeleteTest() throws IOException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserinfoService userinfoService = (UserinfoService)ac.getBean("userinfoService");

		SysUser user = new SysUser();
		SysRole role = new SysRole();
		role.setRoleId((long)6);
		
		user.setUsrFlag(1);
		user.setUsrName("zdz");
		user.setUsrPassword("121");
		user.setSysRole(role);
		
		userinfoService.add(user);
		
		SysUser getUser = userinfoService.findByUsrId(user.getUsrId());
		assertEquals(getUser.getUsrName(),"zdz");
		assertEquals((long)getUser.getSysRole().getRoleId(),6);
	}
}
