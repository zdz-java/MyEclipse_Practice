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
//import static org.junit.




import com.zdz.mapper.AdminMapper;
import com.zdz.model.Admin;

public class AdminMapperTest {
	private String source = "Configuration.xml";
	private SqlSessionFactory sessionFactory;
	@Before
	public void prepare() throws IOException
	{
		Reader reader = Resources.getResourceAsReader(source); 
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	@Test
	public void addAdminAndOtherTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		Admin admin = new Admin();
		admin.setAdminName("zdz");
		admin.setAdminType(1);
		adminMapper.addAdmin(admin);
		Admin admin2 = adminMapper.loadAdmin(admin.getId());
		Assert.assertEquals(admin2.getAdminName(), admin.getAdminName());
		admin.setAdminName("zdzdz");
		adminMapper.updateAdmin(admin);
		Admin afterUpdateAdmin = adminMapper.loadAdmin(admin.getId());
		Assert.assertEquals(afterUpdateAdmin.getAdminName(), admin.getAdminName());
		adminMapper.delAdmin(admin.getId());
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void browseAdminTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		List<Admin> list = adminMapper.browseAdmin();
		Assert.assertEquals(list.get(0).getAdminName(), "商品管理员");
		sqlSession.commit();
		sqlSession.close();
	}
}
