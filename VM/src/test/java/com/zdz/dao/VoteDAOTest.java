package com.zdz.dao;

import org.junit.Test;

import com.zdz.bean.Vote;
import com.zdz.daoImpl.VoteDAOImpl;

public class VoteDAOTest {
	@Test
	public void addVoteTest()
	{
		VoteDAO voteDAO = new VoteDAOImpl();
		Vote vote = new Vote();
		vote.setChannelID(1);
		voteDAO.addVote(vote);
		System.out.println(vote.getVoteID());
		voteDAO.deleteVote(vote.getVoteID());
	}
}
