package com.zdz.springmvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zdz.springmvc.model.User;

@Controller
// @RequestMapping(value="/zdz")
public class HelloWorldController {
	@RequestMapping(value = { "/hello/**", "/home/{userid}" })
	public ModelAndView helloWorld() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("message", "Hello World");
		return mv;
	}

	@RequestMapping(value = "method", method = RequestMethod.GET)
	public String get() {
		System.out.println("get");
		return "hello";
	}

	@RequestMapping(value = "method", method = RequestMethod.POST)
	public String post() {
		System.out.println("post");
		return "hello";
	}

	@RequestMapping(params = "a")
	public String params() {
		System.out.println("params");
		return "hello";
	}

	@RequestMapping(params = "b=a")
	public String params2() {
		System.out.println("params2");
		return "hello";
	}

	@RequestMapping(value = "/validate/hello")
	public String testValid(@Valid @ModelAttribute("user") User user,
			Errors errors) {
		if (errors.hasErrors()) {
			return "validate/error";
		}
		return "redirect:/success";
	}
}
