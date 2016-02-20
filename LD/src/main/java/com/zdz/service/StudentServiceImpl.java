package com.zdz.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;

import com.zdz.mapper.StudentMapper;
import com.zdz.model.Student;

public class StudentServiceImpl implements StudentService{
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public void addStudent(Student student) {
		
	}

	@Override
	public void updateStudent(Student student) {
		
	}

	@Override
	public Student selectStudent(String sid) {
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
