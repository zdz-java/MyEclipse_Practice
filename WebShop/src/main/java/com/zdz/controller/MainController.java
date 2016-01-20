package com.zdz.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.zdz.model.Cart;
import com.zdz.model.Cartselectedmer;
import com.zdz.model.Category;
import com.zdz.model.Leaveword;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;
import com.zdz.model.Orders;
import com.zdz.service.AdminService;
import com.zdz.service.CartService;
import com.zdz.service.MemService;
import com.zdz.service.MerService;
import com.zdz.service.OrderService;
import com.zdz.service.WordService;

@Controller
@SessionAttributes({"loginMember","cateList"})
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
		System.out.println("进入到登录方法");
//		验证语句应该取出整个member
		Member member = memService.memLogin(loginName, loginPwd); 
		System.out.println("验证时从数据库中取出的level的id"+member.getMemberlevel().getId());
		if(member!=null)
		{
			System.out.println("验证通过");
			model.addAttribute("loginMember", member);
			member.setLastDate(new Date());
			int beforeTime = 0;
			if(member.getLoginTimes()!=null)
			{
				beforeTime = member.getLoginTimes();
			}
			member.setLoginTimes(beforeTime+1);
			memService.updateMember(member);
			System.out.println("在default页面更新后level的id"+member.getMemberlevel().getId());
		}
		else {
			System.out.println("验证失败");
		}
		System.out.println("离开登录方法");
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
		System.out.println("提交到数据库时level的id"+member.getMemberlevel().getId());
		return "redirect:default";
	}
	@RequestMapping("/loadMember")
	public String loadMember(@ModelAttribute("loginMember") Member member,Model model)
	{
		model.addAttribute("memberToModi", member);
		System.out.println("更改前加载到更改页面的level的id"+member.getMemberlevel().getId());
		System.out.println("更改前加载到更改页面的level的name"+member.getMemberlevel().getLevelName());
		return "jsp/modiReg";
	}
	@RequestMapping("/modiReg")
	public String modiReg(@ModelAttribute("memberToModi") Member member,Model model) throws Exception
	{
		System.out.println("提交到更改前的level的id"+member.getMemberlevel().getId());
		System.out.println("提交到更改前的level的name"+member.getMemberlevel().getLevelName());
		memService.updateMember(member);
		System.out.println("提交到更改后的level的id"+member.getMemberlevel().getId());
		System.out.println("提交到更改后的level的name"+member.getMemberlevel().getLevelName());
		model.addAttribute("loginMember", member);
		return "redirect:default";
	}
	@RequestMapping("/listMerByCate")
	public String listMerByCate(@RequestParam int cateid,Model model) throws Exception
	{
		List list = merService.browseMer(0, 0, cateid, null);
		model.addAttribute("merList", list);
		return "jsp/merchandise";
	}
	@RequestMapping("/showMer")
	public String showMer(@RequestParam int id,Model model) throws Exception
	{
		Merchandise merchandise = merService.loadMer(id);
		model.addAttribute("mer", merchandise);
		return "jsp/merInfo";
	}
	@RequestMapping("/searchMer")
	public String searchMer(@RequestParam int cateid,@RequestParam String key,Model model) throws Exception
	{
		System.out.println("key is "+key+" "+"cateid is "+cateid);
		List list = null;
		if(cateid==0)
		{
			list = merService.browseMerBySearch(0,0,key,null);
		}
		else{
			list = merService.browseMerBySearch(0, 0, key, cateid);
		}
		model.addAttribute("merList", list);
		return "jsp/merchandise";
	}
	@RequestMapping("/cartManage")
//	该页面中的Ajax实现暂时留待
	public String cartManage(@RequestParam(value="mid",required=false,defaultValue="0") int mid,@ModelAttribute("loginMember") Member member,Model model) throws Exception
	{
//		这里不明白为什么使用购买键进入此方法时，将会使得member的id变为商品的id
		Cart cart = cartService.loadCart(member);
		System.out.println("接收的member的id为"+member.getId());
		if(cart == null)
		{
			System.out.println("缺乏购物车对象，创建购物车中");
			cart = new Cart();
			cart.setMember(member);
			cart.setCartStatus(0);
			cartService.addCart(cart);
		}
		List<Cartselectedmer> cartselectedmers = orderService.browseOrderMer(cart);
		Map<Cartselectedmer,Merchandise> rows = new LinkedHashMap<Cartselectedmer,Merchandise>();
		Iterator<Cartselectedmer> iterator = cartselectedmers.iterator();
		Cartselectedmer ct = null;
		boolean isExist = false;
		while(iterator.hasNext())
		{
			ct = iterator.next();
			if(ct.getMerchandise()==mid)
			{
				isExist = true;
				ct.setNumber(ct.getNumber()+1);
				ct.setMoney(ct.getMoney()+ct.getPrice());
			}
			rows.put(ct, merService.loadMer(ct.getMerchandise()));
		}
		if(!isExist)
		{
//			此处应该进行更详尽的id检查
			if(mid!=0)
			{
				Cartselectedmer cartselectedmer = new Cartselectedmer();
				cartselectedmer.setCart(cart.getId());
				cartselectedmer.setMerchandise(mid);
				cartselectedmer.setPrice(merService.loadMer(mid).getPrice());//这里需要乘以折扣，还需要对id进行检验
				cartselectedmer.setNumber(1);
				cartselectedmer.setMoney(merService.loadMer(mid).getPrice());
				cartService.addCartselectedmer(cartselectedmer);
				
				rows.put(cartselectedmer, merService.loadMer(mid));
			}
		}
		
		double totalMoney = 110;
		model.addAttribute("rows", rows);
		model.addAttribute("totalMoney", totalMoney);
		return "jsp/cart";
	}
	@RequestMapping("/checkOrder")
	public String checkOrder()
	{
		return "jsp/checkOrder";
	}
	@RequestMapping("/submitOrder")
	public String submitOrder(@ModelAttribute("loginMember") Member member,@RequestParam String memName,@RequestParam String phone,@RequestParam String zip,@RequestParam String address,Model model) throws Exception
	{
System.out.println("submitOrder memName is"+memName);		
		member.setMemberName(memName);
		member.setPhone(phone);
		member.setZip(zip);
		member.setAddress(address);
		memService.updateMember(member);
		model.addAttribute("loginMember", member);
		
		Cart cart = cartService.loadCart(member);
		
		Orders orders = new Orders();
		orders.setCart(cart);
		orders.setMember(member);
		orders.setOrderDate(new Date());
		orders.setOrderStatus(1);
		
		String preOrderNo = UUID.randomUUID().toString();
		StringBuilder orderNo = new StringBuilder();
		int indexOfIll = 0;
		for(int i=0;i<13;i++)
		{
			while(preOrderNo.charAt(indexOfIll)=='-')
			{
				indexOfIll++;
			}
			orderNo = orderNo.append(preOrderNo.charAt(indexOfIll));
			indexOfIll++;
		}
		
		orders.setOrderNo(orderNo.toString());
		cart.setCartStatus(1);
		cartService.updateCart(cart);
		
		orderService.addOrder(orders);
		model.addAttribute("order", orders);
		
		return "jsp/submitOrder";
	}
	@RequestMapping("/browseOrder")
	public String browseOrder(@ModelAttribute("loginMember") Member member,Model model) throws Exception
	{
		List list = orderService.browseOrder(member);
		model.addAttribute("orders", list);
		return "jsp/Order";
	}
	@RequestMapping("/delOrder")
	public String delOrder(@RequestParam int oid) throws Exception
	{
		orderService.delOrder(oid);
		return "redirect:browseOrder";
	}
	@RequestMapping("/viewOrder")
	public String viewOrder(@RequestParam int oid,Model model) throws Exception
	{
		Orders order = orderService.loadOrder(oid);
		
		List<Cartselectedmer> cartselectedmers = orderService.browseOrderMer(order.getCart());
		Map<Cartselectedmer,Merchandise> rows = new LinkedHashMap<Cartselectedmer,Merchandise>();
		Iterator<Cartselectedmer> iterator = cartselectedmers.iterator();
		Cartselectedmer ct = null;
		while(iterator.hasNext())
		{
			ct = iterator.next();
			rows.put(ct, merService.loadMer(ct.getMerchandise()));
		}
		model.addAttribute("rows", rows);
		model.addAttribute("totalMoney", order.getCart().getMoney());
		model.addAttribute("order", order);
		
		return "jsp/OrderInfo";
	}
	@RequestMapping("/leaveword")
	public String leaveWord(Model model) throws Exception
	{
		List list = wordService.browseWord();
		model.addAttribute("words", list);
		return "jsp/leaveword";
	}
	@RequestMapping("/addWord")
	public String addWord(@RequestParam String wordTitle,@RequestParam String content,@ModelAttribute("loginMember") Member member) throws Exception
	{
		Leaveword leaveword = new Leaveword();
		leaveword.setContent(content);
		leaveword.setMember(member);
		leaveword.setTitle(wordTitle);
		leaveword.setLeaveDate(new Date());
		
		wordService.addWord(leaveword);
		
		return "redirect:leaveword";
	}
}
