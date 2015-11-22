package com.zdz.crm.mapper;

import java.util.List;
import java.util.Map;

import com.zdz.crm.model.SysUser;
import com.zdz.crm.util.PageResult;

public interface SysUserMapper {
//	这个方法的业务逻辑不了解，留待
	public abstract PageResult findAll(Map paramMap);
	
	public abstract void save(SysUser transientInstance);

	public abstract void delete(SysUser persistentInstance);

	public abstract SysUser findById(java.lang.Long id);

	public abstract List findByExample(SysUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUsrName(Object usrName);

	public abstract List findByUsrPassword(Object usrPassword);

	public abstract List findByUsrFlag(Object usrFlag);
//	这个方法的业务逻辑不了解，留待
	public abstract SysUser merge(SysUser detachedInstance);
//	这个方法的业务逻辑不了解，留待
	public abstract void attachDirty(SysUser instance);
//	这个方法的业务逻辑不了解，留待
	public abstract void attachClean(SysUser instance);
}
