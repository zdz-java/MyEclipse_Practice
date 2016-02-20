package com.zdz.mapper;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zdz.model.Student;

public class StudentMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void prepare() throws IOException {
		String resource = "Mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	@Test
	public void selectStudentTest() throws IOException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			Student student = studentMapper.selectStudent("123");
			Assert.assertEquals("zdz",student.getStudentName());
			session.commit();	
		}
		finally{
			session.close();	
		}
	}
}
