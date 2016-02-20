package com.zdz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.service.StudentService;

@Controller
public class MainController {
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/test")
	public void test()
	{
		System.out.println("first controller test work");
	}
}
