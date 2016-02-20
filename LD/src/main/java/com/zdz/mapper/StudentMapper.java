package com.zdz.mapper;

import com.zdz.model.Student;

public interface StudentMapper {
	public void addStudent(Student student);
	public void updateStudent(Student student);
	public Student selectStudent(String sid);
}
