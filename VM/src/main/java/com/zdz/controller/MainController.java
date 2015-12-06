package com.zdz.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdz.bean.Vote;
import com.zdz.bean.VoteOption;
import com.zdz.bean.VoteResult;
import com.zdz.dao.VoteDAO;
import com.zdz.dao.VoteOptionDAO;
import com.zdz.util.Page;
import com.zdz.util.PageUtil;

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
	public void test(HttpServletResponse response) throws IOException {
		response.getWriter().write("hello!");
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/showVote")
	public String showVote(
			@RequestParam(required = false, defaultValue = "1") int currentPage,
			Model model) {
		Page page = PageUtil.createPage(3, voteDAO.findAllCount(), currentPage);
		List<Vote> votes = voteDAO.findAllVote(page);
		List<VoteResult> voteResultList = new LinkedList<VoteResult>();
		VoteResult voteResult = null;
		for (Vote v : votes) {
			voteResult = new VoteResult();
			voteResult.setVote(v);
			voteResult.setVoteOptions(voteOptionDAO.findVoteOptionByVoteID(v
					.getVoteID()));
			voteResultList.add(voteResult);
		}
		model.addAttribute("voteResultList", voteResultList);
		model.addAttribute("page", page);
		return "showVote";
	}

	@RequestMapping("/deleteVote")
	public String deleteVote(@RequestParam int voteID) {
		List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);
		for(VoteOption voteOption:voteOptions)
		{
			voteOptionDAO.deleteVoteOption(voteOption.getVoteOptionID());	
		}
		voteDAO.deleteVote(voteID);
		return "forward:/showVote";
	}

	@RequestMapping(value = "/addVote", method = RequestMethod.GET)
	public String preAddVote(Model model) {
		Vote voteToAdd = new Vote();
		model.addAttribute("voteToAdd", voteToAdd);
		return "addVote";
	}

	@RequestMapping(value = "/addVote", method = RequestMethod.POST)
	public String addVote(Model model,
			@ModelAttribute(value = "voteToAdd") Vote vote,
			@RequestParam("voteOption") List<String> voteOptions) {
		voteDAO.addVote(vote);
		VoteOption voteOption = null;
		for (String str : voteOptions) {
			voteOption = new VoteOption();
			voteOption.setVoteOptionName(str);
			voteOption.setVoteID(vote.getVoteID());
			voteOptionDAO.addVoteOption(voteOption);
		}
		return "index";
	}
	@RequestMapping("/showVoteByChannel")
	public String userIndex(Model model,@RequestParam(required = false, defaultValue = "1") int currentPage,@RequestParam(required=false,defaultValue="1")int channelID)
	{
		
		Page page = PageUtil.createPage(3, voteDAO.fintCountByChannel(channelID), currentPage);
		List<Vote> votes = voteDAO.findVoteByChannel(page, channelID);
		List<VoteResult> voteResultList = new LinkedList<VoteResult>();
		VoteResult voteResult = null;
		for (Vote v : votes) {
			voteResult = new VoteResult();
			voteResult.setVote(v);
			voteResult.setVoteOptions(voteOptionDAO.findVoteOptionByVoteID(v
					.getVoteID()));
			voteResultList.add(voteResult);
		}
		model.addAttribute("voteResultList", voteResultList);
		model.addAttribute("page", page);
		return "user/index";
	}
	@RequestMapping("/doVote")
	public String doVote(@RequestParam int voteOptionID,@RequestParam int voteID,@RequestParam String otherOption,@RequestParam int channelID)
	{
		if(voteOptionID!=0)
		{
			VoteOption voteOption = voteOptionDAO.findVoteOptionById(voteOptionID);
			voteOption.setTicketNum(voteOption.getTicketNum()+1);
			voteOptionDAO.updateVoteOption(voteOption);
		}
		else {
			VoteOption voteOptionToAdd = new VoteOption();
			voteOptionToAdd.setTicketNum(1);
			voteOptionToAdd.setVoteID(voteID);
			voteOptionToAdd.setVoteOptionName(otherOption);
			voteOptionDAO.addVoteOption(voteOptionToAdd);
		}
		return "forward:/showVoteByChannel?channelID="+channelID;
	}
	@RequestMapping("/voteResult")
	public String voteResult(@RequestParam int voteID)
	{
		return "";
	}
}
