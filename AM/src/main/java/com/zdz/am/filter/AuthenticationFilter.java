package com.zdz.am.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zdz.am.model.Employee;

public class AuthenticationFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpSession session = req.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		if (employee == null) {
			req.getRequestDispatcher("statusRecognise").forward(req, response);;
		}
		else {
			filterChain.doFilter(req, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}


}
