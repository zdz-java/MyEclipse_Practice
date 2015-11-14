package com.zdz.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping(value = "/hello")
	public String test()
	{
		return "hello";
	}
}
