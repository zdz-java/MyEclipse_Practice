package com.zdz.bean.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdz.bean.Performer;
import com.zdz.bean.Singer;
import com.zdz.bean.Song;

public class SingerTest {
//	@Test
//	public void singerTestOrigin() {
//		Song twoTiger = new Song();
//		String lir = "两只老虎，两只老虎\n" +
//				"跑得快，跑得快";
//		twoTiger.setLir(lir);
//		Performer angelababy = new Singer(twoTiger);
//		angelababy.perform();
//	}
	@Test
	public void singerTestSpringXML()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Performer angelababy = (Performer)ac.getBean("singer");
		angelababy.perform();
	}
}
