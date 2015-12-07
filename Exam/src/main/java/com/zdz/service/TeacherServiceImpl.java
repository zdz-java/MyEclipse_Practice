package com.zdz.service;

import com.sanqing.dao.TeacherDAO;
import com.sanqing.po.Teacher;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDAO teacherDAO;

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public boolean allowLogin(String teacherID, String password) {
		if(teacherID==null||password==null)
		{
			return false;
		}
		Teacher teacher = teacherDAO.findByTeacherID(teacherID);
		if(teacher!=null&&teacher.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}

}
