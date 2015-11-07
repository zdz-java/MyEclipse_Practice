package com.zdz.mybatis.inter;

import com.zdz.mybatis.model.Student;

public interface StudentOperation {
	public abstract Student selectStudentById(int id);
}
