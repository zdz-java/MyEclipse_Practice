package com.zdz.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zdz.mybatis.inter.UserOperation;
import com.zdz.mybatis.model.Article;

@Controller
public class UserController {
	@Autowired
	UserOperation userMapper;

	@RequestMapping("/list")
	public ModelAndView listall(HttpServletRequest request,
			HttpServletResponse response) {
		List<Article> articles = userMapper.getUserArticles(1);
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("articles", articles);
		return mav;
	}
}
