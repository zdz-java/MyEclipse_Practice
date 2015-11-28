package com.zdz.am.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.am.dao.CriticismDAO;
import com.zdz.am.dao.EmployeeDAO;
import com.zdz.am.dao.MessageDAO;
import com.zdz.am.dao.ReplyDAO;
import com.zdz.am.model.Employee;
@Controller
public class MainController {
	private MessageDAO messageDAO;
	private CriticismDAO criticismDAO;
	private EmployeeDAO employeeDAO;
	private ReplyDAO replyDAO;
	
	public CriticismDAO getCriticismDAO() {
		return criticismDAO;
	}
	@Autowired
	public void setCriticismDAO(CriticismDAO criticismDAO) {
		this.criticismDAO = criticismDAO;
	}
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	public ReplyDAO getReplyDAO() {
		return replyDAO;
	}
	@Autowired
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}
	@Autowired
	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	@RequestMapping("/helloTest")
	public void test(HttpServletResponse httpServletResponse)
	{
		try (Writer writer = httpServletResponse.getWriter();){
			writer.write("hehe");
			writer.write(messageDAO.findAllCount());
			System.out.println(messageDAO.findAllCount());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
