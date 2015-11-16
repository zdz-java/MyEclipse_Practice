package com.zdz.ssm.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdz.ssm.model.Article;

public class ArticleServiceTest {
	@Test
	public void getArticleByIdTest()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArticleService articleService = (ArticleService)ac.getBean("articleService");
		
		Article article = articleService.getArticleById(11);
		Assert.assertEquals(article.getTitle(), "一个练习用的小小论坛，欢迎留言");
		Assert.assertEquals(article.getIsLeaf(), false);
	}
	
	@Test
	public void updateTest()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArticleService articleService = (ArticleService)ac.getBean("articleService");
		
		Article article = articleService.getArticleById(11);
		Assert.assertEquals(article.getTitle(), "一个练习用的小小论坛，欢迎留言");
		Assert.assertEquals(article.getIsLeaf(), false);
		
		article.setTitle("一个练习用的小小论坛，欢迎留言.");
		articleService.update(article);
		article = articleService.getArticleById(11);
		Assert.assertEquals(article.getTitle(), "一个练习用的小小论坛，欢迎留言.");
		
		article.setTitle("一个练习用的小小论坛，欢迎留言");
		articleService.update(article);
		
	}
}
