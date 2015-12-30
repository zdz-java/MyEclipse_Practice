package com.zdz.service;

import java.util.List;

import com.zdz.mapper.MemMapper;
import com.zdz.model.Member;
import com.zdz.model.Memberlevel;

public class MemServiceImpl implements MemService {
	private MemMapper memMapper;
	
	public MemMapper getMemMapper() {
		return memMapper;
	}

	public void setMemMapper(MemMapper memMapper) {
		this.memMapper = memMapper;
	}

	@Override
	public Member memLogin(String loginName, String loginPwd) throws Exception {
		return memMapper.memLogin(loginName, loginPwd);
	}

	@Override
	public List browseMemberLevel() throws Exception {
		return memMapper.browseMemberLevel();
	}

	@Override
	public Memberlevel loadMemberLevel(Integer id) throws Exception {
		return memMapper.loadMemberLevel(id);
	}

	@Override
	public boolean chkLoginName(String loginName) throws Exception {
		//
		return false;
	}

	@Override
	public boolean addMember(Member member) throws Exception {
		return memMapper.addMember(member);
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		return memMapper.updateMember(member);
	}

	@Override
	public List browseMember() throws Exception {
		return memMapper.browseMember();
	}

	@Override
	public boolean delMember(Integer id) throws Exception {
		return memMapper.delMember(id);
	}

	@Override
	public Member loadMember(Integer id) throws Exception {
		return memMapper.loadMember(id);
	}

}
