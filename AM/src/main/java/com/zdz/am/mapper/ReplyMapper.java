package com.zdz.am.mapper;

import java.util.List;

import com.zdz.am.model.Reply;
import com.zdz.am.util.Page;

public interface ReplyMapper {
	public void addReplay(Reply replay);			//��ӻظ�
	public List<Reply> findReplayByMsgID(int messageID);//������ID���һظ�
	public int findCountByMsgID(int messageID);//��ѯ��Ϣ�ظ���¼��
}
