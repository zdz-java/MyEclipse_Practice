package com.zdz.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.springmvc.model.DataBinderTestModel;

@Controller
public class DataBinderTestController {
	@RequestMapping(value = "/dataBind")
	public String test(@ModelAttribute(value="model") DataBinderTestModel command) {
System.out.println("I come into the test method");
		// 输出command对象看看是否绑定正确
		System.out.println(command);
//		为什么使用注解在这里会出现model？
//		model.addAttribute("dataBinderTest", command);
		return "success";
	}
}
