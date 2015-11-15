package com.zdz.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		System.out.println(articleService.getArticleById(11).getTitle());
		return "hello";
	}
}
