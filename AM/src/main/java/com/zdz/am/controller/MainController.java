package com.zdz.am.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zdz.am.dao.CriticismDAO;
import com.zdz.am.dao.EmployeeDAO;
import com.zdz.am.dao.MessageDAO;
import com.zdz.am.dao.ReplyDAO;
import com.zdz.am.model.Employee;
import com.zdz.am.model.Message;
import com.zdz.am.util.Page;
import com.zdz.am.util.PageUtil;
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
	
	@RequestMapping("/index")
	public String index(Model model)
	{
		Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
		List<Message> messages = messageDAO.findAllMessagee(pageX);
		model.addAttribute("messages", messages);
		return "index";
	}
	
	@RequestMapping(value="/statusRecognise",method = RequestMethod.GET)
	public String getStatusRecogniseForm(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "statusRecognise";
	}
//	这里需要对employee进行检验，还有错误处理
	@RequestMapping(value="/statusRecognise",method = RequestMethod.POST)
	public String statusRecogniseForm(Model model,Employee employee)
	{
		int employeeID = employee.getEmployeeID();
		Employee toConfirm = employeeDAO.findEmployeeById(employeeID);
		if(toConfirm==null)
		{
			model.addAttribute("error","不存在该用户ID");
			return "redirect:/statusRecognise";
		}
		else {
			if(toConfirm.getPassword().endsWith(employee.getPassword()))
			{
				model.addAttribute("employee", toConfirm);
				return "forward:/index";
			}
			else {
				model.addAttribute("error","用户密码错误");
				return "redirect:/statusRecognise";
			}
		}
	}
	@RequestMapping(value="/publishNewMsg",method=RequestMethod.GET)
	public String getPublishNewMsg(Model model)
	{
		Message message = new Message();
		model.addAttribute("message", message);
		return "publishNewMsg";
	}
	@RequestMapping(value="/publishNewMsg",method=RequestMethod.POST)
	public String publishNewMsg(Model model,Message message)
	{
//		message.setEmployeeID();
		model.addAttribute("message", message);
		return "publishNewMsg";
	}
}
