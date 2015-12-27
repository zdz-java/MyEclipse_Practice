package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Leaveword;

public interface WordMapper {
	/** �������� */	
	public boolean addWord(Leaveword word);
	/** ��ҳ����������� */
	public List browseWord(int pageSize,int pageNo);
	/** ����������� */
	public List browseWord();
	/** ͳ���������� */
	public int countWord();	
	/** ɾ������ */	
	public boolean delWord(Integer id);	
	/** װ������ */	
	public Leaveword loadWord(Integer id);
	/** �ظ����� */	
	public boolean updateWord(Leaveword word);
}
