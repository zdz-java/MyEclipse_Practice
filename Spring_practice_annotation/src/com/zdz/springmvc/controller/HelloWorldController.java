package com.zdz.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
//@RequestMapping(value="/zdz")
public class HelloWorldController {
	@RequestMapping(value={"/hello/**","/home/{userid}"})
	public ModelAndView helloWorld()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("message", "Hello World");
		return mv;
	}
	@RequestMapping(value="method",method=RequestMethod.GET)
	public String get()
	{
		System.out.println("get");
		return "hello";
	}
	@RequestMapping(value="method",method=RequestMethod.POST)
	public String post()
	{
		System.out.println("post");
		return "hello";
	}
	@RequestMapping(params="a")
	public String params()
	{
		System.out.println("params");
		return "hello";
	}
	@RequestMapping(params="b=a")
	public String params2()
	{
		System.out.println("params2");
		return "hello";
	}
}
