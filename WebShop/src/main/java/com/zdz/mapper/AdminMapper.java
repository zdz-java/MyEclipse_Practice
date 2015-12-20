package com.zdz.mapper;

import com.zdz.model.Admin;

public interface AdminMapper {
	public boolean addAdmin(Admin admin);
	public boolean delAdmin(Integer id);
	public Admin loadAdmin(Integer id);
}
