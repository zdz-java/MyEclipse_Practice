package com.zdz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanqing.dao.SubjectDAO;
import com.sanqing.po.Subject;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;
@Component
public class SubjectServiceImpl implements SubjectService{
	private SubjectDAO subjectDAO;
	
	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}
	@Autowired
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
		if(list!=null)
		{
			page.setTotalCount(list.size());
		}
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
		int result = 0;
		Subject subject = null;
		int subjectID = 0;
		String studentAnswer = null;
		for(int i=0;i<subjectIDs.size();i++)
		{
			subjectID = subjectIDs.get(i);
			subject = subjectDAO.findSubjectByID(subjectID);
			studentAnswer = studentAnswers.get(i);
			if(subject!=null&&subject.getSubjectAnswer().equals(studentAnswer))
			{
				result += 5;
			}
		}
		return result;
	}
	@Override
	public int findSubjectCount() {
		return subjectDAO.findSubjectCount();
	}

}
