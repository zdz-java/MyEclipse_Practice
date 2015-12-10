package com.zdz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.service.TeacherService;
@Controller
public class TeacherController {
	private TeacherService teacherService;

	public TeacherService getTeacherService() {
		return teacherService;
	}
	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	@RequestMapping("/teacherIndex")
	public String index()
	{
System.out.println("come into teacherindex");
		return "teacher/index";
	}
}
