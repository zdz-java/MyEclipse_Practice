package com.zdz.crm.dao;
import java.util.List;
import java.util.Map;

import com.zdz.crm.model.CstManager;
import com.zdz.crm.util.PageResult;


public interface ICstManagerDAO {

	public abstract PageResult findAll(Map paramMap);
	public abstract List<CstManager> findByManName(String manName);
}