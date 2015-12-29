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
import com.zdz.model.Leaveword;
import com.zdz.model.Member;
import com.zdz.model.Merchandise;

public class WordMapperTest {
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
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);
		
		List<Leaveword> leavewords = wordMapper.browseWord();
		
		Assert.assertEquals(leavewords.get(0).getTitle(), "非常感谢");
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void loadTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);	
		
		Leaveword leaveword = wordMapper.loadWord(1);
		
		Assert.assertEquals(leaveword.getTitle(), "非常感谢");		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void addDelUpdateTest()
	{
		SqlSession sqlSession = sessionFactory.openSession();
		WordMapper wordMapper = sqlSession.getMapper(WordMapper.class);		
		
		Member member = new Member();
		member.setId(1);
		Leaveword leaveword = new Leaveword();
		leaveword.setTitle("zdz");
		leaveword.setMember(member);
		wordMapper.addWord(leaveword);
		Leaveword leaveword2 = wordMapper.loadWord(leaveword.getId());
		Assert.assertEquals(leaveword2.getTitle(), "zdz");
		leaveword.setTitle("zdzdz");
		wordMapper.updateWord(leaveword);
		leaveword2 = wordMapper.loadWord(leaveword.getId());
		Assert.assertEquals(leaveword2.getTitle(), "zdzdz");
		
		wordMapper.delWord(leaveword.getId());
		
		sqlSession.commit();
		sqlSession.close();
	}
}
