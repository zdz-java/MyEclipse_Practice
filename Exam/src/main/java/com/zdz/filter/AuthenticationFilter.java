package com.zdz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sanqing.po.Student;
import com.sanqing.po.Teacher;

public class AuthenticationFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpSession session = req.getSession();
		
		Student student = (Student) session.getAttribute("studentInfo");
		
//		session = req.getSession();
//		if(session==null)
//		{
//			System.out.println("session is null");
//		}
		boolean teacher = false;
		if(session.getAttribute("teacher")!=null)
		{
			teacher =  (boolean)session.getAttribute("teacher");
		}
		if (student == null&&teacher==false) {
			req.getRequestDispatcher("login").forward(req, response);;
		}
		else {
			filterChain.doFilter(req, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}


}
