package com.zdz.service;

import java.util.List;

import com.zdz.mapper.WordMapper;
import com.zdz.model.Leaveword;

public class WordServiceImpl implements WordService {
	private WordMapper wordMapper;

	public WordMapper getWordMapper() {
		return wordMapper;
	}

	public void setWordMapper(WordMapper wordMapper) {
		this.wordMapper = wordMapper;
	}

	@Override
	public boolean addWord(Leaveword word) throws Exception {
		return wordMapper.addWord(word);
	}

//	未实现
	@Override
	public List browseWord(int pageSize, int pageNo) throws Exception {
		return null;
	}

	@Override
	public List browseWord() throws Exception {
		return wordMapper.browseWord();
	}

	@Override
	public int countWord() throws Exception {
		return wordMapper.countWord();
	}

	@Override
	public boolean delWord(Integer id) throws Exception {
		return wordMapper.delWord(id);
	}

	@Override
	public Leaveword loadWord(Integer id) throws Exception {
		return wordMapper.loadWord(id);
	}

	@Override
	public boolean updateWord(Leaveword word) throws Exception {
		return wordMapper.updateWord(word);
	}
	
}
