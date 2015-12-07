package com.zdz.service;

import java.util.List;

import com.sanqing.dao.SubjectDAO;
import com.sanqing.po.Subject;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public class SubjectServiceImpl implements SubjectService{
	private SubjectDAO subjectDAO;
	
	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	@Override
	public boolean saveSubject(Subject subject) {
		subjectDAO.addSubject(subject);	
//		?
		return true;
	}

	@Override
	public PageResult querySubjectByPage(Page page) {
		List list = subjectDAO.findSubjectByPage(page);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}

	@Override
	public Subject showSubjectParticular(int subjectID) {
		return subjectDAO.findSubjectByID(subjectID);
	}

	@Override
	public void updateSubject(Subject subject) {
		subjectDAO.updateSubject(subject);
	}

	@Override
	public void deleteSubject(int subjectID) {
		subjectDAO.deleteSubject(subjectID);
	}

	@Override
	public PageResult likeQueryBySubjectTitle(String subjectTitle, Page page) {
		List list = subjectDAO.likeQueryByTitle(subjectTitle, page);
		PageResult pageResult = new PageResult(page, list);
		return pageResult;
	}

	@Override
	public List<Subject> randomFindSubject(int number) {
		return subjectDAO.randomFindSubject(number);
	}
//	我觉得这个方法应当使用Map作为参数
	@Override
	public int accountResult(List<Integer> subjectIDs,
			List<String> studentAnswers) {
		if(subjectIDs==null||studentAnswers==null||subjectIDs.size()!=studentAnswers.size())
		{
//			不懂这样做的意义何在?
//			throw new NullPointerException();
			return 0;
		}
//		方法内变量不赋值可以吗？
		int result = 0;
		Subject subject = null;
		int subjectID = 0;
		String studentAnswer = null;
		for(int i=0;i<subjectIDs.size();i++)
		{
			subjectID = subjectIDs.get(i);
			subject = subjectDAO.findSubjectByID(subjectID);
			if(subject!=null&&subject.getSubjectAnswer().equals(studentAnswer))
			{
//				这里的分数计算方法要参考源代码
				result += 10;
			}
		}
		return result;
	}

}
