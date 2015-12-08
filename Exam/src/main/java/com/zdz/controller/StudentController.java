package com.zdz.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanqing.dao.StudentDAO;
import com.sanqing.po.Student;
import com.sanqing.po.Teacher;
import com.zdz.service.StudentService;
@Controller
@SessionAttributes("studentInfo")
public class StudentController {
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/test")
	public void test(HttpServletResponse response) throws IOException
	{
		Writer writer = response.getWriter();
		writer.write("test");
		System.out.println(studentService.getStudentInfo("0509302*21").getStudentName());
		writer.flush();
		writer.close();
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String preLogin()
	{
		return "login";
	}
//	该方法为临时的，会修改为使用拦截器
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String role,@RequestParam String password,@RequestParam String id,Model model)
	{
		if(role.equals("student"))
		{
			Student student = studentService.getStudentInfo(id);
			if(student!=null&&student.getPassword().equals(password))
			{
				model.addAttribute("studentInfo", student);
			}
		}
//		else if(role.equals("teacher"))
//		{
//			Teacher teacher = 
//		}
//		else 
//		{
//			return "login";
//		}
		return "forward:/studentIndex";
	}
	@RequestMapping("/studentIndex")
	public String studentIndex()
	{
		return "student/index";
	}
}
