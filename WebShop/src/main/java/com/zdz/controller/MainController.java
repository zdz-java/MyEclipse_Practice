package com.zdz.controller;

import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zdz.model.Admin;
import com.zdz.model.Category;
import com.zdz.model.Member;
import com.zdz.service.AdminService;
import com.zdz.service.CartService;
import com.zdz.service.MemService;
import com.zdz.service.MerService;
import com.zdz.service.OrderService;
import com.zdz.service.WordService;

@Controller
@SessionAttributes("loginMember")
public class MainController {
	private AdminService adminService;
	private CartService cartService;
	private MerService merService;
	private MemService memService;
	private OrderService orderService;
	private WordService wordService;
	
	public AdminService getAdminService() {
		return adminService;
	}
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public CartService getCartService() {
		return cartService;
	}
	@Autowired
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public MerService getMerService() {
		return merService;
	}
	@Autowired
	public void setMerService(MerService merService) {
		this.merService = merService;
	}

	public MemService getMemService() {
		return memService;
	}
	@Autowired
	public void setMemService(MemService memService) {
		this.memService = memService;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public WordService getWordService() {
		return wordService;
	}
	@Autowired
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}

	@RequestMapping("/default")
	public String defaultMethod(Model model) throws Exception
	{
		List<Category> cateList = merService.browseCategory();
//		这两个列表应该是由merService.browseMer(pageSize, pageNo, cateId, isSpecial)的重载方法取出的
		List merList1 = merService.browseMer("是");
		List merList2 = merService.browseMer("的");
		model.addAttribute("cateList", cateList);
		model.addAttribute("loginLabel", "会员登录");
		model.addAttribute("merList1", merList1);
		model.addAttribute("merList2", merList2);
		return "jsp/default";
	}
	
//	@RequestMapping("/searchMer")
//	public String searchMer()
//	{
//		
//	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String loginName,@RequestParam String loginPwd,Model model) throws Exception
	{
//		验证语句应该取出整个member
		Member member = memService.memLogin(loginName, loginPwd); 
		Member member2 = memService.loadMember(2);
		if(member!=null)
		{
			model.addAttribute("loginMember", member);
			member.setLastDate(new Date());
			member.setLoginTimes(member.getLoginTimes()+1);
		}
		else {
			System.out.println("验证失败");
		}
		return "redirect:default";
	}
//	取消session中的loginMember
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
//		下面两种方法都无法让session失效
//		可以使用拦截器拦截此方法来避免使用ServletApi
//		session.removeAttribute("loginMember");
//		session.invalidate();
//		怀疑是通过SpringMVC而添加到session范围的，不能通过servletAPI来取消,但是modelAPI中没有提供移除方法
		request.getSession().removeAttribute("loginMember");
		System.out.println("进入到了session失效方法");
		return "redirect:default";
	}
	
	@RequestMapping(value="/reg",method=RequestMethod.GET)
	public String preReg(Model model)
	{
		model.addAttribute("memberToReg", new Member());
		return "jsp/reg";
	}
//	应该添加数据认证的JS和进入后台的认证
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(@ModelAttribute("memberToReg") Member member) throws Exception
	{
		member.setLoginTimes(0);
		member.setLastDate(new Date());
		member.setRegDate(new Date());
		memService.addMember(member);
		return "redirect:default";
	}
	@RequestMapping("/loadMember")
	public String loadMember(@ModelAttribute("memberToReg") Member member,Model model)
	{
		model.addAttribute("memberToModi", member);
		return "jsp/modiReg";
	}
}
