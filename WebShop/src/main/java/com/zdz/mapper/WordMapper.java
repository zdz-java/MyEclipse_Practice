package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Leaveword;

public interface WordMapper {
	/** ��ҳ����������� */
//	public List browseWord(int pageSize,int pageNo);
	public List browseWord();
	public boolean addWord(Leaveword word);
	public int countWord();	
	public boolean delWord(Integer id);	
	public Leaveword loadWord(Integer id);
	public boolean updateWord(Leaveword word);
}
