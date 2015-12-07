package com.zdz.service;

import java.util.List;

import com.sanqing.po.Student;

public interface StudentService {
	//�ж��Ƿ�Ϊ�Ϸ�ѧ��Ӷ�����Ƿ������¼
	public boolean allowLogin(String studentID,String password);
	//���ѧ����Ϣ
	public Student getStudentInfo(String studentID);
	//����ѧ��ɼ�
	public void setStudentResult(String studentID,int result);
	//���ѧ���������ѧ��
	public List<Student> getStudentByName(String studentName);
	//��ݰ༶����ѧ��
	public List<Student> getStudentByClass(String sclass);
}
