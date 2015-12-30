package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Admin;

public interface AdminMapper {
	public Admin adminLogin(String loginName,String loginPwd);
	public boolean addAdmin(Admin admin);
	public boolean delAdmin(Integer id);
	public Admin loadAdmin(Integer id);
	public boolean updateAdmin(Admin admin);
	public List browseAdmin();
}
