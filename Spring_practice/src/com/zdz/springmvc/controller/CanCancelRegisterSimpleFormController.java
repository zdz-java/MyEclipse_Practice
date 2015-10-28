package com.zdz.springmvc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.CancellableFormController;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.zdz.bean.User;

public class CanCancelRegisterSimpleFormController extends CancellableFormController {
	public CanCancelRegisterSimpleFormController() {
		setCommandClass(User.class);
		setCommandName("user");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		User user = new User();
		user.setUsername("请输入用户名");
		return user;
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map map = new HashMap();
		map.put("cityList", Arrays.asList("山东", "北京", "上海"));
		return map;
	}

	@Override
	protected void doSubmitAction(Object command) throws Exception {
		User user = (User) command;
		System.out.println(user);
	}

	@Override
	protected ModelAndView onCancel(Object command) throws Exception {
		User user = (User) command;
		System.out.println(user);
		return super.onCancel(command);
	}
	

}
