package com.zdz.ssm.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zdz.ssm.model.Article;

public class ArticleMapperTest {
	SqlSessionFactory sqlSessionFactory;

	@Before
	public void prepare() throws IOException {
		String resource = "Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void getArticleByIdTest() throws IOException {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);

		Article article = articleMapper.getArticleById(11);
		Assert.assertEquals(article.getTitle(), "一个练习用的小小论坛，欢迎留言");
		Assert.assertEquals(article.getIsLeaf(), false);
	}

	@Test
	public void saveAndDeleteTest() {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);

		Article article = new Article();
		article.setTitle("23333");
		article.setPdate(new Date());
		articleMapper.save(article);
		ss.commit();

		articleMapper.deleteById(article.getId());
		ss.commit();
	}

	@Test
	public void getArticlesByRootidTest() {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);
		List<Article> articles = articleMapper.getArticlesByRootid(1);
		
		Article a = articles.get(0);
		Assert.assertEquals(a.getTitle(),"mbmn");
		a = articles.get(1);
		Assert.assertEquals(a.getTitle(),"aaaaaaaaaa");
	}

	@Test
	public void getTotalTest() {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);
		
		Assert.assertEquals(articleMapper.getTotal(), 38);
	}
	
	@Test
	public void getSplitPageListTest() {
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);
		List<Article> articles = articleMapper.getSplitPageList(2,2);
		
//		System.out.println(articles.get(0).getTitle());
		Article a = articles.get(0);
		Assert.assertEquals(a.getTitle(),"a");
		a = articles.get(1);
		Assert.assertEquals(a.getTitle(),"zzz");
	}
}
