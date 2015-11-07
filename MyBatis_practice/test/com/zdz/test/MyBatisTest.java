package com.zdz.test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdz.mybatis.dao.BlogDao;
import com.zdz.mybatis.dao.BlogDaoImpl;
import com.zdz.mybatis.inter.StudentOperation;
import com.zdz.mybatis.inter.UserOperation;
import com.zdz.mybatis.model.Article;
import com.zdz.mybatis.model.Blog;
import com.zdz.mybatis.model.Student;
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

	// @Test
	// public void firstTest() {
	// SqlSession session = sqlSessionFactory.openSession();
	// try {
	// User user = (User) session.selectOne(
	// "com.zdz.mybatis.model.UserMapper.selectUserByID", 1);
	// System.out.println(user.getUserAddress());
	// System.out.println(user.getUserName());
	// } finally {
	// session.close();
	// }
	// }
//	@Test
//	public void secondTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			UserOperation userOperation = session
//					.getMapper(UserOperation.class);
//			// User user = (User) userOperation.selectUserByID(1);
//			// System.out.println(user.getUserAddress());
//			// System.out.println(user.getUserName());
//
//			// String userName = "zdz";
//			// List<User> users = userOperation.selectUsers(userName);
//			// for (User u : users) {
//			// System.out.println(u.getId() + ":" + u.getUserName() + ":"
//			// + u.getUserAddress());
//			// }
//
//			// user.setUserAge("20");
//			// userOperation.updateUser(user);
//
//			// userOperation.deleteUser(5);
//			for (int i = 1; i < 10; i++) {
//				User toInsert = new User();
//				toInsert.setUserAddress("changsha");
//				toInsert.setUserName("wiege");
//				toInsert.setUserAge(""+i);
//				userOperation.addUser(toInsert);
//			}
//			session.commit();
//			// System.out.println(toInsert.getId());
//
//		} finally {
//			session.close();
//		}
//	}
	// @Test
	// public void getUserArticle() {
	// int userid = 1;
	// SqlSession session = sqlSessionFactory.openSession();
	// try {
	// UserOperation userOperation = session
	// .getMapper(UserOperation.class);
	// List<Article> articles = userOperation.getUserArticles(userid);
	// for (Article article : articles) {
	// System.out.println(article.getTitle() + ":"
	// + article.getContent() + ":作者是:"
	// + article.getUser().getUserName() + ":地址:"
	// + article.getUser().getUserAddress());
	// }
	// } finally {
	// session.close();
	// }
	// }

	// @Test
	// public void testSpringConnection() {
	// ApplicationContext ctx = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	// UserOperation mapper = (UserOperation) ctx.getBean("userMapper");
	// // 测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
	// System.out.println("得到用户id=1的用户信息");
	// User user = mapper.selectUserByID(1);
	// System.out.println(user.getUserAddress());
	//
	// // 得到文章列表测试
	// System.out.println("得到用户id为1的所有文章列表");
	// List<Article> articles = mapper.getUserArticles(1);
	//
	// for (Article article : articles) {
	// System.out
	// .println(article.getContent() + "--" + article.getTitle());
	// }
	// }
	
//	@Test
//	public void ifTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			UserOperation userOperation = session
//					.getMapper(UserOperation.class);
//			Blog blog = new Blog();
//			blog.setOwner(1);
//			List<Blog> list = userOperation.dynamicIfTest(blog);
//			for(Blog b:list)
//			{
//				System.out.print(b);
//			}
//			session.commit();
//
//		} finally {
//			session.close();
//		}
//	}
	
//	@Test
//	public void chooseTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			UserOperation userOperation = session
//					.getMapper(UserOperation.class);
//			Blog blog = new Blog();
//			blog.setTitle("2");
//			List<Blog> list = userOperation.dynamicChooseTest(blog);
//			for(Blog b:list)
//			{
//				System.out.print(b);
//			}
//			session.commit();
//
//		} finally {
//			session.close();
//		}
//	}
	
//	@Test
//	public void trimTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			UserOperation userOperation = session
//					.getMapper(UserOperation.class);
//			Blog blog = new Blog();
//			blog.setTitle("3");
//			blog.setContent("4");
//			List<Blog> list = userOperation.dynamicChooseTest(blog);
//			for(Blog b:list)
//			{
//				System.out.print(b);
//			}
//			session.commit();
//
//		} finally {
//			session.close();
//		}
//	}
//	@Test
//	public void foreachTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			UserOperation userOperation = session
//					.getMapper(UserOperation.class);
//			List<Integer> bids = new LinkedList<>();
//			bids.add(1);
//			bids.add(3);
//			List<Blog> list = userOperation.dynamicForeachTest(bids);
//			for(Blog b:list)
//			{
//				System.out.println(b);
//			}
//			session.commit();
//
//		} finally {
//			session.close();
//		}
//	}
//	@Test
//	关于Map的foreach单元测试没有通过，暂时不清楚怎么使用。
//	public void foreachTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			UserOperation userOperation = session
//					.getMapper(UserOperation.class);
//			Map map = new HashMap();
////			List<Integer> bids = new LinkedList<>();
////			bids.add(1);
////			bids.add(3);
////
////			map.put("3", bids);
////			List<Blog> list = userOperation.dynamicForeach3Test(map);
//			Blog blog = new Blog();
//			blog.setTitle("1");
//			blog.setBid(1);
//			List ls = new LinkedList<>();
//			ls.add(blog);
//			map.put("1", ls);
//			List<Blog> list = userOperation.dynamicForeach3Test(map);
//			for(Blog b:list)
//			{
//				System.out.println(b);
//			}
//			session.commit();
//
//		} finally {
//			session.close();
//		}
//	}
	
//	@Test
//	public void mutiParamTest() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			UserOperation userOperation = session
//					.getMapper(UserOperation.class);
//			List<Blog> list = userOperation.selectBlogByBids(2,3);
//			for(Blog b:list)
//			{
//				System.out.println(b);
//			}
//			session.commit();
//
//		} finally {
//			session.close();
//		}
//	}
	
//	@Test
//	public void suppoterTest() {
//		BlogDao bd = new BlogDaoImpl(getSession());
//		Blog blog = bd.getBlogByBid(1);
//		System.out.println(blog);
//	}
	
	@Test
	public void testAPI() throws IOException
	{
		String resource = "Configuration.xml";
		String environment = "spring_practice";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader,environment);
		SqlSession ss = ssf.openSession();
		StudentOperation studentOperation = ss.getMapper(StudentOperation.class);
		System.out.println(studentOperation.selectStudentById(1));
		
	}
}
