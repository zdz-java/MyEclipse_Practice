package com.zdz.service;

import java.util.*;

import com.zdz.model.Category;
import com.zdz.model.Merchandise;

/** ��Ʒ���ࡢ��Ʒ���ؼ���Ʒҵ���߼�����ӿ� */
public interface MerService {	
	/** �����Ʒ���� */
	public List browseCategory() throws Exception;	
	/** װ��ָ������Ʒ���� */	
	public Category loadCategory(Integer id) throws Exception;	
	/** ɾ��ָ������Ʒ���� */	
	public boolean delCategory(Integer id) throws Exception;	
	/** ������Ʒ���� */	
	public boolean addCategory(Category cate) throws Exception;	
	/** ������Ʒ���� */	
	public boolean updateCategory(Category cate) throws Exception;
	
	/** �����Ʒ */
	public List browseMer(String hql) throws Exception;	
	/** װ��ָ������Ʒ */	
	public Merchandise loadMer(Integer id) throws Exception;	
	/** ɾ��ָ������Ʒ */	
	public boolean delMer(Integer id) throws Exception;	
	/** ������Ʒ */	
	public boolean addMer(Merchandise mer) throws Exception;	
	/** ������Ʒ */	
	public boolean updateMer(Merchandise mer) throws Exception;
	
	/** ��ҳ�����Ʒ */
	public List browseMer(int pageSize,int pageNo,int cateId,Boolean isSpecial) throws Exception;
	/** ������Ʒ */
	public List browseMerBySearch(int pageSize,int pageNo,String hql,Integer cateid) throws Exception;	
	/** ͳ�Ƽ�¼���� */
	public int countRecord(String hql) throws Exception;	
}