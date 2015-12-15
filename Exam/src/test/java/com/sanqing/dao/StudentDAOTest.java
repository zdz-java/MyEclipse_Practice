package com.sanqing.dao;
import static junit.framework.Assert.assertEquals; 
import org.junit.Test;

import com.sanqing.po.Student;

public class StudentDAOTest {
	@Test
	public void findByStudentIDTest()
	{
		StudentDAO studentDAO = new StudentDAOImpl();
		String studentID = "0509302*21";
		Student student = studentDAO.findByStudentID(studentID);
		assertEquals(student.getStudentName(),"李明华");
		
	}
	@Test
	public void updateStudentTest()
	{
		StudentDAO studentDAO = new StudentDAOImpl();
		String studentID = "123";
		Student student = studentDAO.findByStudentID(studentID);
		student.setPassword("1234567");
		studentDAO.updateStudent(student);
	}
}
