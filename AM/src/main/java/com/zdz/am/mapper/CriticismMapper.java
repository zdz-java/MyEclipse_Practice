package com.zdz.am.mapper;

import com.zdz.am.model.Criticism;

public interface CriticismMapper {
	public void addCriticism(Criticism criticism);			//�����
	public Criticism findCriticismByMsgID(int messageID);	//������ID������
	public void deleteCriticismByMsgID(int messageID);	//������ID������

}
