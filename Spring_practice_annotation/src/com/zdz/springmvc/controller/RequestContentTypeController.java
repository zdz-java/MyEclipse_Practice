package com.zdz.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdz.springmvc.model.DataBinderTestModel;
import com.zdz.springmvc.model.User;

@Controller
public class RequestContentTypeController {
	@RequestMapping(value = "/ContentType", method = RequestMethod.GET)
	public String showForm() throws IOException {
		// form表单，使用application/x-www-form-urlencoded编码方式提交表单
		return "consumesproduces/Content-Type";
	}

	@RequestMapping(value = "/ContentType", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
	public String request1(HttpServletRequest request) throws IOException {
		// ①得到请求的内容区数据的类型
		String contentType = request.getContentType();
		System.out.println("========ContentType:" + contentType);
		// ②得到请求的内容区数据的编码方式，如果请求中没有指定则为null
		// 注意，我们的CharacterEncodingFilter这个过滤器设置了编码(UTF-8)
		// 编码只能被指定一次，即如果客户端设置了编码，则过滤器不会再设置
		String characterEncoding = request.getCharacterEncoding();
		System.out.println("========CharacterEncoding:" + characterEncoding);

		// ③表示请求的内容区数据为form表单提交的参数，此时我们可以通过request.getParameter得到数据（key=value）
		System.out.println(request.getParameter("realname"));
		System.out.println(request.getParameter("username"));
		return "success";
	}

	@RequestMapping(value = "/request/ContentType", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public String request2(HttpServletRequest request) throws IOException {
		// ①表示请求的内容区数据为json数据
		System.out.println("It work!");
		InputStream is = request.getInputStream();
		byte bytes[] = new byte[request.getContentLength()];
		is.read(bytes);
		// ②得到请求中的内容区数据（以CharacterEncoding解码）
		// 此处得到数据后你可以通过如json-lib转换为其他对象
		String jsonStr = new String(bytes, request.getCharacterEncoding());
		System.out.println("json data：" + jsonStr);
		return "success";
	}

	@RequestMapping("/response/ContentType")
	public void response1(HttpServletResponse response) throws IOException {
		// ①表示响应的内容区数据的媒体类型为html格式，且编码为utf-8(客户端应该以utf-8解码)
		System.out.println("it work!3");
		response.setContentType("text/html;charset=utf-8");
		// ②写出响应体内容
		response.getWriter().write("<font style='color:red'>hello</font>");
	}

	@RequestMapping(value = "/request/ContentType")
	public String request22(HttpServletRequest request) throws IOException {
		// ①表示请求的内容区数据为json数据
		System.out.println("It work!!!!");
		InputStream is = request.getInputStream();
		byte bytes[] = new byte[request.getContentLength()];
		is.read(bytes);
		// ②得到请求中的内容区数据（以CharacterEncoding解码）
		// 此处得到数据后你可以通过如json-lib转换为其他对象
		String jsonStr = new String(bytes, request.getCharacterEncoding());
		System.out.println("json data：" + jsonStr);
		return "success";
	}

	@RequestMapping(value = "requestparam1")
	public String requestparam1(
			@RequestParam(value = "user", required = false, defaultValue = "z") String username) {
		System.out.println(username);
		return "success";
	}

	@RequestMapping(value = "/users/{userId}/topics/{topicId}")
	public String requestparam2(@PathVariable(value = "userId") int userId,
			@PathVariable(value = "topicId") int topicId) {
		System.out.println("userId:" + userId);
		System.out.println("topicId:" + topicId);
		return "success";
	}
	
	@RequestMapping(value = "cookie")
	public String cookie(@CookieValue(value="JSESSIONID",defaultValue="")String sessionId)
	{
		System.out.println(sessionId);
		return "success";
	}
	
	@RequestMapping(value = "model")
	public String model(@ModelAttribute("user") User user)
	{
		System.out.println(user);
		System.out.println(user.getSchoolInfo().getSchoolName());
		return "success";
	}
	@RequestMapping(value = "model2/{username}")
	public String model2(@ModelAttribute("model") DataBinderTestModel model)
	{
		System.out.println(model.getUsername());
		return "model";
	}
//	@RequestMapping(value = "model3")
//	public String model3()
//	{
//		
//	}
	@RequestMapping("cityList")
	public List<String> cityList()
	{
		return Arrays.asList("浙江","北京");
	}
}
