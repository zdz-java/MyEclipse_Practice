package com.zdz.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zdz.mapper.StudentMapper;
import com.zdz.model.Student;
@Component
public class StudentServiceImpl implements StudentService{
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void addStudent(Student student) {
		
	}

	@Override
	public void updateStudent(Student student) {
		
	}

	@Override
	public Student selectStudent(String sid) {
		System.out.println("spring work");
		SqlSession session = sqlSessionFactory.openSession();
		Student student = null;
		try {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			student = studentMapper.selectStudent(sid);
			session.commit();	
		}
		finally{
			session.close();	
		}
		return student;
	}
	
	
}
