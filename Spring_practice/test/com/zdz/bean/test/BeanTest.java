package com.zdz.bean.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.zdz.bean.Magician;
import com.zdz.bean.Performer;
import com.zdz.bean.Singer;
import com.zdz.bean.Student;
import com.zdz.dao.JdbcTestDaoImpl;
import com.zdz.dao.TestDao;
import com.zdz.dao.TestDaoImpl;
import com.zdz.util.Song;
import com.zdz.util.Thinker;
import com.zdz.util.Volunteer;

public class BeanTest {
//	@Test
//	public void singerTestOrigin() {
//		Song twoTiger = new Song();
//		String lir = "两只老虎，两只老虎\n" +
//				"跑得快，跑得快";
//		twoTiger.setLir(lir);
//		Performer angelababy = new Singer(twoTiger);
//		angelababy.perform();
//	}
//	@Test
//	public void singerTestSpringXML()
//	{
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Performer angelababy = (Singer)ac.getBean("singer");
//		angelababy.perform();
//	}
//	@Test
//	public void PlayerTest()
//	{
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Performer angelababy = (Performer)ac.getBean("player");
//		angelababy.perform();
//	}
//	@Test
//	public void mockerTest()
//	{
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Performer angelababy = (Performer)ac.getBean("mocker");
//		angelababy.perform();
//	}
//	@Test
//	public void VolunteerTest()
//	{
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
////		Thinker weige = (Thinker)ac.getBean("volunteer");
//		Volunteer weige = (Volunteer)ac.getBean("volunteer");
//		Magician liuqian = (Magician)ac.getBean("magician");
//		
//		weige.thinkOfSomething("he will never know what I'm thinking now");
//		System.out.println(liuqian.getThought());
//	}
//	@Test
//	public void daoTest()
//	{
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
////		SimpleJdbcTemplate sjt = (SimpleJdbcTemplate)ac.getBean("jdbcTemplate");
//		TestDao td = (TestDaoImpl)ac.getBean("testDaoImpl");
//		Student student = new Student();
//		student.setId(1);
//		student.setName("weige");
//		student.setScore(90);
//		student.setSex("w");
//		student.setStudent_number(8);
//		td.insert(student);
//	}
	
	@Test
	public void jdbcDaoTest()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		SimpleJdbcTemplate sjt = (SimpleJdbcTemplate)ac.getBean("jdbcTemplate");
		TestDao td = (TestDao)ac.getBean("testDaoImpl");
		Student student = new Student();
		student.setName("Z10");
		student.setScore(1);
		student.setSex("m");
		student.setStudent_number(24);
		td.insert(student);
	}
}
