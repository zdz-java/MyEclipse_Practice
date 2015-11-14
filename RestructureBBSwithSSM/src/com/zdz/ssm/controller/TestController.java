package com.zdz.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.ssm.service.ArticleService;

@Controller
public class TestController {
	private ArticleService articleService;
	
	public ArticleService getArticleService() {
		return articleService;
	}
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(value = "/hello")
	public String test()
	{
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		TestController tc =  (TestController)ac.getBean("TestController");
//		System.out.println(tc.articleService.getArticleById(11));
		System.out.println(articleService.getArticleById(11));
		return "hello";
	}
}
