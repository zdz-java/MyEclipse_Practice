package com.zdz.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zdz.mapper.MemMapper;
import com.zdz.mapper.MerMapper;
import com.zdz.model.Category;
import com.zdz.model.Merchandise;

public class MerServiceImpl implements MerService{
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
//	该方法没有实现
	@Override
	public List browseMer(int pageSize, int pageNo, int cateId,
			boolean isSpecial) throws Exception {
		return null;
	}
	
	@Override
	public List browseCategory() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		List list = merMapper.browseCategory();

		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public Category loadCategory(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		Category category = merMapper.loadCategory(id);

		sqlSession.commit();
		sqlSession.close();
		return category;
	}

	@Override
	public boolean delCategory(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		boolean b = merMapper.delCategory(id);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean addCategory(Category cate) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		boolean b = merMapper.addCategory(cate);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean updateCategory(Category cate) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		boolean b = merMapper.updateCategory(cate);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public List browseMer(String hql) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		List list = merMapper.browseMer("%"+hql+"%");

		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public Merchandise loadMer(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		Merchandise merchandise = merMapper.loadMer(id);

		sqlSession.commit();
		sqlSession.close();
		return merchandise;
	}

	@Override
	public boolean delMer(Integer id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		boolean b = merMapper.delMer(id);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean addMer(Merchandise mer) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		boolean b = merMapper.addMer(mer);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}

	@Override
	public boolean updateMer(Merchandise mer) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		boolean b = merMapper.updateMer(mer);

		sqlSession.commit();
		sqlSession.close();
		return b;
	}


	@Override
	public List browseMer(int pageSize, int pageNo, String hql)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		List list = merMapper.browseMer(pageSize, pageNo, "%"+hql+"%");

		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	@Override
	public int countRecord(String hql) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);

		int i = merMapper.countRecord("%"+hql+"%");

		sqlSession.commit();
		sqlSession.close();
		return i;
	}

}
