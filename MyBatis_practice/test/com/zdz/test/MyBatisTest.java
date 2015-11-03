package com.zdz.test;

import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zdz.mybatis.inter.UserOperation;
import com.zdz.mybatis.model.Article;
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
			
			String userName = "zdz"; 
			List<User> users = userOperation.selectUsers(userName);
            for(User u:users){
                System.out.println(u.getId()+":"+u.getUserName()+":"+u.getUserAddress());
            }
            
            user.setUserAge("20");
            userOperation.updateUser(user);
            
            userOperation.deleteUser(5);
            
//            User toInsert = new User();
//            toInsert.setUserAddress("changsha");
//            toInsert.setUserName("wiege");
//            toInsert.setUserAge("22");
//            userOperation.addUser(toInsert);
            session.commit();
//            System.out.println(toInsert.getId());
            
		} finally {
			session.close();
		}
	}
	@Test
	public void getUserArticles(int userid){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserOperation userOperation=session.getMapper(UserOperation.class);           
            List<Article> articles = userOperation.getUserArticles(userid);
            for(Article article:articles){
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":作者是:"+article.getUser().getUserName()+":地址:"+
                         article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }
}
