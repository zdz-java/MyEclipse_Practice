package com.zdz.crm.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserinfoController {
	@RequestMapping("/hello")
	public void test(HttpServletResponse response)
	{
		try(Writer writer = response.getWriter()) {
			writer.write("hello!");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
