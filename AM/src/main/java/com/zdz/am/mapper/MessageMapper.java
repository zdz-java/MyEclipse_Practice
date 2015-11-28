package com.zdz.am.mapper;

import java.util.List;

import com.zdz.am.model.Message;
import com.zdz.am.util.Page;


public interface MessageMapper {
	public void addMessage(Message message);		//���������Ϣ�ķ���
	public void updateMessage(Message message);	//�����޸���Ϣ�ķ���
	public void deleteMessage(int messageID);		//����ɾ����Ϣ�ķ���
	public List<Message> findAllMessage(Page page);		//���尴��ҳ��Ϣ��ѯ������Ϣ�ķ���
	public Message findMessageById(int messageID);	//���尴ID��ѯ��Ϣ�ķ���
	public int findAllCount();					//�����ѯ��Ϣ��¼��

}
