package com.zdz.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanqing.dao.StudentDAO;
import com.sanqing.po.Student;
import com.sanqing.po.Teacher;
import com.zdz.service.StudentService;
import com.zdz.service.SubjectService;
@Controller
@SessionAttributes({"studentInfo","subjects"})
public class StudentController {
	private StudentService studentService;
	private SubjectService subjectService;
	
	public SubjectService getSubjectService() {
		return subjectService;
	}
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
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
//	该方法为临时的，尝试使用容器的安全机制
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
		return "redirect:/studentIndex";
	}
	@RequestMapping("/studentIndex")
	public String studentIndex(Model model)
	{
		List list = subjectService.randomFindSubject(20);
//		这里放在Session中岂不是也将答案也防盗session去了？
		model.addAttribute("subjects", list);
		return "student/index";
	}
	@RequestMapping("/calculateScore")
	public String calculateScore(Model model,@RequestParam List<Integer> subjectID ,HttpServletRequest request,@ModelAttribute("studentInfo")Student student)
	{
		List<String> subjectAnswer = new LinkedList<String>();
		for(int i=0;i<20;i++)
		{
			String string = request.getParameter("subjectAnswer"+i);
			subjectAnswer.add(string);
		}
		int score = subjectService.accountResult(subjectID, subjectAnswer);
		student.setResult(score);
		studentService.setStudentResult(student.getStudentID(), score);
		model.addAttribute("studentName",student.getStudentName());
		model.addAttribute("GeneralPoint",score);
		return "student/examResult";
	}
	@RequestMapping("/showSubjectAnswer")
	public String showSubjectAnswer()
	{
		
		return "student/showAnswer";
	}
}
