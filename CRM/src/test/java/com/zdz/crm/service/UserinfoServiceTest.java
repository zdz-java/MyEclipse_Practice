package com.zdz.crm.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
