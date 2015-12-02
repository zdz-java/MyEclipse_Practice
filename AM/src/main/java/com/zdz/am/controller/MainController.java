package com.zdz.am.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zdz.am.dao.CriticismDAO;
import com.zdz.am.dao.EmployeeDAO;
import com.zdz.am.dao.MessageDAO;
import com.zdz.am.dao.ReplyDAO;
import com.zdz.am.model.Criticism;
import com.zdz.am.model.Employee;
import com.zdz.am.model.Message;
import com.zdz.am.model.Reply;
import com.zdz.am.util.Page;
import com.zdz.am.util.PageUtil;

@Controller
@SessionAttributes("employee")
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

	@RequestMapping("/index")
	public String index(Model model) {
		Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
		List<Message> messages = messageDAO.findAllMessagee(pageX);
		model.addAttribute("messages", messages);
		return "index";
	}

	@RequestMapping(value = "/statusRecognise", method = RequestMethod.GET)
	public String getStatusRecogniseForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employeeToConfrim", employee);
		return "statusRecognise";
	}

	@RequestMapping(value = "/statusRecognise", method = RequestMethod.POST)
	public String statusRecogniseForm(Model model,@Valid@ModelAttribute("employeeToConfrim") Employee employee,Errors errors) {
		if(errors.hasErrors())
		{
//			这里只是进行测试，能够进行验证，但是验证后值是取得了错误名，没能取到对应的配置文件中的信息
//			System.out.println("进入用户ID为空的错误处理了");	
//			return "statusRecognise";
		}
		int employeeID = employee.getEmployeeID();
		Employee toConfirm = employeeDAO.findEmployeeById(employeeID);
		if (toConfirm == null) {
//			这里的错误信息尚不知道如何添加到errors中去，还是说应该自己写验证的类，在那个类中赋进去
			model.addAttribute("error", "不存在该用户ID");
			return "statusRecognise";
		} else {
			if (toConfirm.getPassword().equals(employee.getPassword())) {
				model.addAttribute("employee", toConfirm);
				return "forward:/index";
			} else {
				model.addAttribute("error", "用户密码错误");
				return "statusRecognise";
			}
		}
	}

	@RequestMapping(value = "/publishNewMsg", method = RequestMethod.GET)
	public String getPublishNewMsg(Model model) {
		Message message = new Message();
		model.addAttribute("message", message);
		return "publishNewMsg";
	}

	@RequestMapping(value = "/publishNewMsg", method = RequestMethod.POST)
	public String publishNewMsg(Model model, Message message,Employee employee) {
		message.setEmployeeID(employee.getEmployeeID());
		message.setPublishTime(new Date());
		messageDAO.addMessage(message);
		return "forward:/index";
	}

	@RequestMapping(value = "/GetMessageList")
	public String getMessageList(
			@RequestParam(required = false, defaultValue = "1") int currentPage,
			Model model) {
		Page page = PageUtil.createPage(5, messageDAO.findAllCount(),
				currentPage);
		List<Message> messages = messageDAO.findAllMessagee(page);
		model.addAttribute("messageList", messages);
		model.addAttribute("page", page);
		return "msgList";
	}

	@RequestMapping(value = "/GetMessage")
	public String getMessage(@RequestParam("messageID") int messageID,
			Model model,Employee employee,
			@RequestParam(required = false, defaultValue = "1") int currentPage) {
		
		Page page = PageUtil.createPage(5,
				replyDAO.findCountByMsgID(messageID), currentPage);// ���÷�ҳ��Ϣ
		Message message = messageDAO.findMessageById(messageID);
		Criticism criticism = criticismDAO.findCriticismByMsgID(messageID);
		Criticism criticismToAdd = new Criticism();
		criticismToAdd.setMessageID(messageID);
		List<Reply> replyList = replyDAO.findReplayByMsgID(messageID, page);
		Reply reply = new Reply();
		reply.setMessageID(messageID);
		reply.setEmployeeID(employee.getEmployeeID());
		model.addAttribute("page",page);
		model.addAttribute("reply",reply);
		model.addAttribute("message", message);
		model.addAttribute("criticism", criticism);
		model.addAttribute("criticismToAdd", criticismToAdd);
		model.addAttribute("replyList", replyList);
		return "showMsg";
	}
	@RequestMapping(value="/CommitReply")
	public String commitReply(Reply reply)
	{
		reply.setReplyTime(new Date());
		replyDAO.addReplay(reply);
		return "forward:/GetMessage";
	}
	@RequestMapping(value="/CommitCriticism")
	public String commitCriticism(Criticism criticism,Employee employee)
	{
		criticism.setCriticismTime(new Date());
		criticism.setEmployeeID(employee.getEmployeeID());
		criticismDAO.addCriticism(criticism);
		return "forward:/GetMessage";
	}
}
