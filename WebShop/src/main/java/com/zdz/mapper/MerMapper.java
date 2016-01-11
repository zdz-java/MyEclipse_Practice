package com.zdz.mapper;

import java.util.List;

import com.zdz.model.Category;
import com.zdz.model.Merchandise;

public interface MerMapper {
//	还没有搞懂hql具体指的是什么，猜测为标题的搜索内容，两个关于分页的暂留
	/** ��ҳ�����Ʒ */
	public List browseMerByDetail(int pageSize,int pageNo,int cateId,Boolean isSpecial);
	/** ������Ʒ */
	public List browseMer(int pageSize,int pageNo,String hql);	
	public List browseCategory();	
	public Category loadCategory(Integer id);	
	public boolean delCategory(Integer id);	
	public boolean addCategory(Category cate);	
	public boolean updateCategory(Category cate);
//	存在BUG暂留
	public List browseMer(String hql);	
	public Merchandise loadMer(Integer id);	
	public boolean delMer(Integer id);	
	public boolean addMer(Merchandise mer);	
	public boolean updateMer(Merchandise mer);
//	存在BUG
	public int countRecord(String hql);	
}
