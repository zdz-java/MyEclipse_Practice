package com.zdz.service;

import java.util.List;

import com.sanqing.po.Subject;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public interface SubjectService {
	// ������⣬�����жϸ���������Ƿ��Ѿ����ڣ�����Ѿ��������
	public int findSubjectCount();
	
	public boolean saveSubject(Subject subject);
	// ����ҳ��Ϣ��ѯ����
	public PageResult querySubjectByPage(Page page);
	// �鿴������ϸ��Ϣ
	public Subject showSubjectParticular(int subjectID);
	// ����������Ϣ
	public void updateSubject(Subject subject);
	// ɾ��������Ϣ
	public void deleteSubject(int subjectID);
	//ģ���ѯ������Ϣ
	public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);
	//����ѯ�����¼
	public List<Subject> randomFindSubject(int number);
	//����ѧ��÷�
	public int accountResult(List<Integer> subjectIDs,List<String> studentAnswers);
}
