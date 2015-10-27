package com.zdz.springmvc.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.springmvc.service.TestService;
@Controller
public class HomeController {
	
	private TestService testService;
	public HomeController()
	{
		
	}
	@Inject
	public HomeController(TestService testService)
	{
		this.testService = testService;
	}
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model)
	{
//		model.put("student", testService.getOne());
		model.put("test", "this is for test");
		return "home";
	}
}
