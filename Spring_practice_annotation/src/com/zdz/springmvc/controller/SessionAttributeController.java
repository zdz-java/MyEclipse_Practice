package com.zdz.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.zdz.springmvc.model.User;
@Controller
@SessionAttributes(value = { "user" })
public class SessionAttributeController {
	// 2、@ModelAttribute注解的方法进行表单引用对象的创建
	@ModelAttribute("user")
	// ②
	public User initUser() {
		System.out.println("this is in the initUser method");
		User u = new User();
		u.setUsername("1");
		return u;
	}

	// 3、@RequestMapping注解方法的@ModelAttribute注解的参数进行命令对象的绑定
	@RequestMapping("/session1")
	// ③
	public String session1(@ModelAttribute("user") User user) {
		System.out.println("this is in the session1");
		System.out.println(user.getUsername());
		return "success";
	}

	// 4、通过SessionStatus的setComplete()方法清除@SessionAttributes指定的会话数据
	@RequestMapping("/session2")
	// ③
	public String session(@ModelAttribute("user") User user,
			SessionStatus status) {
		if (true) { // ④
			status.setComplete();
		}
		return "success";
	}
}
