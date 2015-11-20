package com.zdz.crm.dao;
import java.util.List;
import java.util.Map;

import com.zdz.crm.model.SysRole;
import com.zdz.crm.util.PageResult;


public interface ISysRoleDAO {

	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_DESC = "roleDesc";
	public static final String ROLE_FLAG = "roleFlag";

	public abstract void save(SysRole transientInstance);

	public abstract void delete(SysRole persistentInstance);

	public abstract SysRole findById(java.lang.Long id);

	public abstract List findByExample(SysRole instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRoleName(Object roleName);

	public abstract List findByRoleDesc(Object roleDesc);

	public abstract List findByRoleFlag(Object roleFlag);

	public PageResult findAll();

	public List<SysRole> findAllRoles();

	public PageResult findAllRole(Map paramMap);

	public abstract SysRole merge(SysRole detachedInstance);

	public abstract void attachDirty(SysRole instance);

	public abstract void attachClean(SysRole instance);

}