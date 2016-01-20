package com.zdz.service;

import java.util.*;

import com.zdz.model.Admin;

public interface AdminService {

	public Admin adminLogin(String loginName,String loginPwd);
	public List browseAdmin();	
	/** װ��ָ���Ĺ���Ա */	
	public Admin loadAdmin(Integer id);	
	/** ɾ��ָ���Ĺ���Ա */	
	public boolean delAdmin(Integer id);	
	/** ��������Ա */	
	public boolean addAdmin(Admin admin);	
	/** ���¹���Ա */	
	public boolean updateAdmin(Admin admin);	
}