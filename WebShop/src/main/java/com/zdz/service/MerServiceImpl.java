package com.zdz.service;

import java.util.List;

import com.zdz.mapper.MerMapper;
import com.zdz.model.Category;
import com.zdz.model.Merchandise;

public class MerServiceImpl implements MerService{
	private MerMapper merMapper;
	
	public MerMapper getMerMapper() {
		return merMapper;
	}

	public void setMerMapper(MerMapper merMapper) {
		this.merMapper = merMapper;
	}
//	该方法没有实现
	@Override
	public List browseMer(int pageSize, int pageNo, int cateId,
			boolean isSpecial) throws Exception {
		return null;
	}
	
	@Override
	public List browseCategory() throws Exception {
		return merMapper.browseCategory();
	}

	@Override
	public Category loadCategory(Integer id) throws Exception {
		return merMapper.loadCategory(id);
	}

	@Override
	public boolean delCategory(Integer id) throws Exception {
		return merMapper.delCategory(id);
	}

	@Override
	public boolean addCategory(Category cate) throws Exception {
		return merMapper.addCategory(cate);
	}

	@Override
	public boolean updateCategory(Category cate) throws Exception {
		return merMapper.updateCategory(cate);
	}

	@Override
	public List browseMer(String hql) throws Exception {
		return merMapper.browseMer("%"+hql+"%");
	}

	@Override
	public Merchandise loadMer(Integer id) throws Exception {
		return merMapper.loadMer(id);
	}

	@Override
	public boolean delMer(Integer id) throws Exception {
		return merMapper.delMer(id);
	}

	@Override
	public boolean addMer(Merchandise mer) throws Exception {
		return merMapper.addMer(mer);
	}

	@Override
	public boolean updateMer(Merchandise mer) throws Exception {
		return merMapper.updateMer(mer);
	}


	@Override
	public List browseMer(int pageSize, int pageNo, String hql)
			throws Exception {
		return merMapper.browseMer(pageSize, pageNo, "%"+hql+"%");
	}

	@Override
	public int countRecord(String hql) throws Exception {
		return merMapper.countRecord("%"+hql+"%");
	}

}
