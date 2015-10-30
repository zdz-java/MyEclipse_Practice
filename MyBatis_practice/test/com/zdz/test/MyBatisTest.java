package com.zdz.test;

import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zdz.mybatis.inter.UserOperation;
import com.zdz.mybatis.model.User;

public class MyBatisTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
//	@Test
//	public void firstTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			User user = (User) session.selectOne(
//					"com.zdz.mybatis.model.UserMapper.selectUserByID", 1);
//			System.out.println(user.getUserAddress());
//			System.out.println(user.getUserName());
//		} finally {
//			session.close();
//		}
//	}
	@Test
	public void secondTest() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserOperation userOperation = session.getMapper(UserOperation.class);
			User user = (User) userOperation.selectUserByID(1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}
}
