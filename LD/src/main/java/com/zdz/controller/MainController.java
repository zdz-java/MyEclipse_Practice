package com.zdz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/test")
	public void test()
	{
		System.out.println("first controller test work");
	}
}
