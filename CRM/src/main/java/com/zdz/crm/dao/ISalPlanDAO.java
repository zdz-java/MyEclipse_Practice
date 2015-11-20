package com.zdz.crm.dao;
import java.util.List;
import java.util.Map;

import com.zdz.crm.model.SalPlan;
import com.zdz.crm.util.PageResult;


public interface ISalPlanDAO {

	// property constants
	public static final String PLA_TODO = "plaTodo";
	public static final String PLA_RESULT = "plaResult";
	
	public abstract PageResult findAll(Map paramMap);
	
	public abstract PageResult findPlanTodo(Map paramMap);

	public abstract void save(SalPlan transientInstance);

	public abstract void delete(SalPlan persistentInstance);

	public abstract SalPlan findById(java.lang.Long id);

	public abstract List findByExample(SalPlan instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPlaTodo(Object plaTodo);

	public abstract List findByPlaResult(Object plaResult);

	

	public abstract SalPlan merge(SalPlan detachedInstance);

	public abstract void attachDirty(SalPlan instance);

	public abstract void attachClean(SalPlan instance);

}