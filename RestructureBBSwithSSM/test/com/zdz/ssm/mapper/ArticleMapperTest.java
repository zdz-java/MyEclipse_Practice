package com.zdz.ssm.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
	
}
