package com.zdz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.service.StudentService;

@Controller
public class MainController {
	private StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/test")
	public void test()
	{
		System.out.println(studentService.selectStudent("zdz").getStudentName());
		System.out.println("first controller test work");
	}
}
