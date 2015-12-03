package com.zdz.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdz.dao.VoteDAO;
import com.zdz.dao.VoteOptionDAO;

@Controller
public class MainController {
	private VoteDAO voteDAO;
	private VoteOptionDAO voteOptionDAO;
	
	public VoteDAO getVoteDAO() {
		return voteDAO;
	}
	@Autowired
	public void setVoteDAO(VoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}

	public VoteOptionDAO getVoteOptionDAO() {
		return voteOptionDAO;
	}
	@Autowired
	public void setVoteOptionDAO(VoteOptionDAO voteOptionDAO) {
		this.voteOptionDAO = voteOptionDAO;
	}

	@RequestMapping("/hello")
	public void test(HttpServletResponse response) throws IOException
	{
		response.getWriter().write("hello!");
	}
	
}
