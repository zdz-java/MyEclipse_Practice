package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Member;
import com.zdz.model.Memberlevel;

public interface MemMapper {
	public List browseMemberLevel();
	public Memberlevel loadMemberLevel(Integer id);
//	应该不需要
//	public boolean chkLoginName(String loginName);	
	public boolean addMember(Member member);
	public boolean updateMember(Member member);
	public List browseMember();
	public boolean delMember(Integer id);
	public Member loadMember(Integer id);	
}
