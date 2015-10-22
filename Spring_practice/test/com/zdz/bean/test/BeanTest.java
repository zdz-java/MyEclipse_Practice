package com.zdz.bean.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdz.bean.Magician;
import com.zdz.bean.Performer;
import com.zdz.bean.Singer;
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
	@Test
	public void VolunteerTest()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Thinker weige = (Thinker)ac.getBean("volunteer");
		Volunteer weige = (Volunteer)ac.getBean("volunteer");
		Magician liuqian = (Magician)ac.getBean("magician");
		
		weige.thinkOfSomething("he will never know what I'm thinking now");
		System.out.println(liuqian.getThought());
	}
}
