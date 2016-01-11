package com.zdz.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zdz.model.Category;
import com.zdz.model.Member;
import com.zdz.model.Memberlevel;
import com.zdz.model.Merchandise;

public class MerMapperTest {
	private String source = "Configuration.xml";
	private SqlSessionFactory sessionFactory;
	@Before
	public void prepare() throws IOException
	{
		Reader reader = Resources.getResourceAsReader(source); 
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	@Test
	public void browseTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
	 	MerMapper merMapper = sqlSession.getMapper(MerMapper.class);
		
		List<Merchandise> merchandises = merMapper.browseMer("%理是%");
		List<Category> categories = merMapper.browseCategory();
		
		Assert.assertEquals(merMapper.countRecord("%是%"), 2);
		Assert.assertEquals(merchandises.get(0).getMerName(), "管理是什么");
		Assert.assertEquals(categories.get(0).getCateName(), "计算机类");
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void loadTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);		
		
		Category category = merMapper.loadCategory(1);
		Merchandise merchandise = merMapper.loadMer(15);
		
		Assert.assertEquals(category.getCateName(), "计算机类");
		Assert.assertEquals(merchandise.getMerName(), "管理是什么");
		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void addDelUpdateTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);		
		
		Category category = new Category();
		category.setCateName("zdz");
		merMapper.addCategory(category);
		Category category2 = merMapper.loadCategory(category.getId());
		Assert.assertEquals(category2.getCateName(), "zdz");
		category.setCateName("zdzdz");
		merMapper.updateCategory(category);
		category2 = merMapper.loadCategory(category.getId());
		Assert.assertEquals(category2.getCateName(), "zdzdz");
		
		Merchandise merchandise = new Merchandise();
		merchandise.setMerName("zdz");
		merchandise.setCategory(category);
		merMapper.addMer(merchandise);
		Merchandise merchandise2 = merMapper.loadMer(merchandise.getId());
		Assert.assertEquals(merchandise2.getMerName(), "zdz");
		merchandise.setMerName("zdzdz");
		merMapper.updateMer(merchandise);
		merchandise2 = merMapper.loadMer(merchandise.getId());
		Assert.assertEquals(merchandise2.getMerName(), "zdzdz");
		
		merMapper.delMer(merchandise.getId());
		merMapper.delCategory(category.getId());
		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void browseMerByDetailTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		MerMapper merMapper = sqlSession.getMapper(MerMapper.class);		
		
		List<Merchandise> list = merMapper.browseMerByDetail(0, 0, 2, true);
		Assert.assertEquals(list.get(0).getMerName(), "管理是什么");
		
		List<Merchandise> list2 = merMapper.browseMerByDetail(0, 0, 2, null);
		Assert.assertEquals(list2.get(0).getMerName(), "巴菲特教你读财报");

		sqlSession.commit();
		sqlSession.close();
	}
}
