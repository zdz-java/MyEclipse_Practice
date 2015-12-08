package com.sanqing.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Teacher;
@Component
public class TeacherDAOImpl implements TeacherDAO{
	public Teacher findByTeacherID(String teacherID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Teacher teacher = (Teacher) session.get(Teacher.class, teacherID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return teacher;
	}
}
