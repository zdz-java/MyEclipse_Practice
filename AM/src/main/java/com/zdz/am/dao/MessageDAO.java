package com.zdz.am.dao;

import java.util.List;

import javax.mail.Message;

import com.zdz.am.util.Page;


public interface MessageDAO {
	public void addMessage(Message message);		//���������Ϣ�ķ���
	public void updateMessage(Message message);	//�����޸���Ϣ�ķ���
	public void deleteMessage(int messageID);		//����ɾ����Ϣ�ķ���
	public List<Message> findAllMessagee(Page page);		//���尴��ҳ��Ϣ��ѯ������Ϣ�ķ���
	public Message findMessageById(int messageID);	//���尴ID��ѯ��Ϣ�ķ���
	public int findAllCount();					//�����ѯ��Ϣ��¼��
}
