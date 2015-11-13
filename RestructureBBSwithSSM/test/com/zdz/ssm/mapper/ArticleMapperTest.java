package com.zdz.ssm.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.zdz.ssm.model.Article;

public class ArticleMapperTest {
	@Test
	public void getArticleByIdTest() throws IOException {
		String resource = "Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession ss = sqlSessionFactory.openSession();
		ArticleMapper articleMapper = ss.getMapper(ArticleMapper.class);
		Article article = articleMapper.getArticleById(11);
		Assert.assertEquals(article.getTitle(),"一个练习用的小小论坛，欢迎留言");
	}
}
