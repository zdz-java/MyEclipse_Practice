package com.zdz.am.dao;


import com.zdz.am.model.Criticism;


public interface CriticismDAO {
	public void addCriticism(Criticism criticism);			//�����
	public Criticism findCriticismByMsgID(int messageID);	//������ID������
}
