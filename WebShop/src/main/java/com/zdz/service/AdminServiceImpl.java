package com.zdz.service;

import java.util.List;

import com.zdz.mapper.AdminMapper;
import com.zdz.model.Admin;

public class AdminServiceImpl implements AdminService {
	private AdminMapper adminMapper;

	public AdminMapper getAdminMapper() {
		return adminMapper;
	}

	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public Admin adminLogin(String loginName, String loginPwd) throws Exception {
		return adminMapper.adminLogin(loginName, loginPwd);
	}

	@Override
	public List browseAdmin() throws Exception {
		return adminMapper.browseAdmin();
	}

	@Override
	public Admin loadAdmin(Integer id) throws Exception {
		return adminMapper.loadAdmin(id);
	}

	@Override
	public boolean delAdmin(Integer id) throws Exception {
		return adminMapper.delAdmin(id);
	}

	@Override
	public boolean addAdmin(Admin admin) throws Exception {
		return adminMapper.addAdmin(admin);
	}

	@Override
	public boolean updateAdmin(Admin admin) throws Exception {
		return adminMapper.updateAdmin(admin);
	}
	
}
