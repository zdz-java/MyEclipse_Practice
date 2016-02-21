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
		if(studentService==null)
		{
			System.out.println("spring error");
		}
		if(studentService.selectStudent("123")==null)
		{
			System.out.println("sql error");
		}
		System.out.println(studentService.selectStudent("123").getStudentName());
		System.out.println("first controller test work");
	}
}
