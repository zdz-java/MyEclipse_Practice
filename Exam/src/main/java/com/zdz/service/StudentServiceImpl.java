package com.zdz.service;

import java.util.List;

import com.sanqing.dao.StudentDAO;
import com.sanqing.po.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public boolean allowLogin(String studentID, String password) {
		if(studentID==null||password==null)
		{
			return false;
		}
		Student student = studentDAO.findByStudentID(studentID);
		if(student!=null&&student.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}

	@Override
	public Student getStudentInfo(String studentID) {
		return studentDAO.findByStudentID(studentID);
	}

	@Override
	public void setStudentResult(String studentID, int result) {
		Student student = studentDAO.findByStudentID(studentID);
		student.setResult(result);
		studentDAO.updateStudent(student);
	}

	@Override
	public List<Student> getStudentByName(String studentName) {
		return studentDAO.findByStudentName(studentName);
	}

	@Override
	public List<Student> getStudentByClass(String sclass) {
		return studentDAO.findByStudentClass(sclass);
	}

}
