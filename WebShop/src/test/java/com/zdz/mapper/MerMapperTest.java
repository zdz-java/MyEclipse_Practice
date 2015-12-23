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
		
		List<Merchandise> merchandises = merMapper.browseMer("理是");
		List<Category> categories = merMapper.browseCategory();
		
		Assert.assertEquals(merchandises.get(0).getMerName(), "管理是什么");
		Assert.assertEquals(categories.get(0).getCateName(), "计算机类");
		sqlSession.commit();
		sqlSession.close();
	}
//	@Test
//	public void loadTest()
//	{
//		SqlSession sqlSession = sessionFactory.openSession();
//		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);
//		
//		Member member = memMapper.loadMember(1);
//		Memberlevel memberlevel = memMapper.loadMemberLevel(1);
//		
//		Assert.assertEquals(member.getMemberName(), "刘桥");
//		Assert.assertEquals(memberlevel.getLevelName(), "普通会员");
//		sqlSession.commit();
//		sqlSession.close();
//	}
//	@Test
//	public void addDelUpdateTest()
//	{
//		SqlSession sqlSession = sessionFactory.openSession();
//		MemMapper memMapper = sqlSession.getMapper(MemMapper.class);
//		
//		Member toAdd = new Member();
//		Memberlevel memberlevel = new Memberlevel();
//		memberlevel.setLevelName("testLevel");
//		memberlevel.setId(1);;
//		toAdd.setMemberlevel(memberlevel);
//		toAdd.setMemberName("zdz");
//		memMapper.addMember(toAdd);
//		Member member = memMapper.loadMember(toAdd.getId());
//		Assert.assertEquals(member.getMemberName(), "zdz");
//		member.setMemberName("zdzdz");
//		memMapper.updateMember(member);
//		member = memMapper.loadMember(toAdd.getId());
//		Assert.assertEquals(member.getMemberName(), "zdzdz");
//		memMapper.delMember(member.getId());
//		sqlSession.commit();
//		sqlSession.close();
//	}
}
