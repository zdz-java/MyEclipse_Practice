package com.zdz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.model.Admin;
import com.zdz.model.Category;
import com.zdz.service.AdminService;
import com.zdz.service.CartService;
import com.zdz.service.MemService;
import com.zdz.service.MerService;
import com.zdz.service.OrderService;
import com.zdz.service.WordService;

@Controller
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

	@RequestMapping("/test")
	public String testController()
	{
		return "test";
	}
	
	@RequestMapping("/default")
	public String defaultMethod(Model model) throws Exception
	{
		List<Category> cateList = merService.browseCategory();
//		System.out.println(cateList.get(0).getCateName());
		model.addAttribute("cateList", cateList);
		model.addAttribute("item1", "商城首页");
		model.addAttribute("item2", "购物车管理");
		model.addAttribute("item3", "订单管理");
		model.addAttribute("item4", "顾客留言");
		model.addAttribute("item5", "修改注册资料");
		model.addAttribute("loginLabel", "会员登录");
		return "jsp/default";
	}
}
