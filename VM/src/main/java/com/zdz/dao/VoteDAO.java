package com.zdz.dao;

import java.util.List;

import com.zdz.bean.Vote;
import com.zdz.util.Page;



public interface VoteDAO {
	public void addVote(Vote vote);			//���ͶƱ
	public void updateVote(Vote vote);		//����ͶƱ
	public void deleteVote(int voteID);		//ɾ��ͶƱ
	public List<Vote> findAllVote(Page page);		//��ҳ��ѯ����ͶƱ
	public List<Vote> findVoteByChannel(Page page,int channelID);//��ҳ��ѯÿƵ����ͶƱ
	public Vote findVoteById(int voteID);	//ͨ��ID��ѯͶƱ
	public Vote findVoteByName(String voteName);	//ͨ��ID��ѯͶƱ
	public int findAllCount();				//��ѯ���м�¼��
	public int fintCountByChannel(int channelID);//��ѯÿƵ���µļ�¼��
}
