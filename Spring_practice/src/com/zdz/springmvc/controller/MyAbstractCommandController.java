package com.zdz.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.zdz.bean.User;

public class MyAbstractCommandController  extends AbstractCommandController{
	public MyAbstractCommandController()
	{
		setCommandClass(User.class);
	}
	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object command, BindException arg3)
			throws Exception {
		User user = (User)command;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("abstract");
		mv.addObject("user", user);
		return mv;
	}

}
