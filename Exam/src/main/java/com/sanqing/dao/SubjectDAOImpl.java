package com.sanqing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Student;
import com.sanqing.po.Subject;
import com.sanqing.util.Page;
@Component
public class SubjectDAOImpl implements SubjectDAO{
	public void addSubject(Subject subject){
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.save(subject);//����������Ϣ
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

	public Subject findSubjectByTitle(String subjectTitle) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle = ?");
		query.setString(0, subjectTitle);
		List list = query.list();					//��ѯ���浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		if(list.size() == 0) {
			return null;							//����null
		}else {
			return (Subject) list.get(0);			//���ص�һ������
		}
	}

	public List<Subject> findSubjectByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Subject");
		query.setMaxResults(page.getEveryPage());//���ò�ѯ��¼��
		query.setFirstResult(page.getBeginIndex());//���ò�ѯ��¼��ʼλ��
		List list = query.list();					//��ѯ���浽list��
		HibernateSessionFactory.closeSession();//�ر�Session����
		return list;
	}

	public int findSubjectCount() {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Subject");
		List list = query.list();					//��ѯ���浽list��
		int count = list.size();
		HibernateSessionFactory.closeSession();//�ر�Session����
		return count;
	}

	public Subject findSubjectByID(int subjectID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Subject subject = (Subject) session.get(Subject.class, subjectID);
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return subject;
	}

	public void updateSubject(Subject subject) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.update(subject);//����������Ϣ
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

	public void deleteSubject(int subjectID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Subject subject = (Subject) session.get(Subject.class, subjectID);
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.delete(subject);
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

	public List<Subject> likeQueryByTitle(String subjectTitle,Page page) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like :title ");
		query.setString("title","%"+subjectTitle+"%");
		query.setMaxResults(page.getEveryPage());//���ò�ѯ��¼��
		query.setFirstResult(page.getBeginIndex());//���ò�ѯ��¼��ʼλ��
		List list = query.list();					//��ѯ���浽list��
		HibernateSessionFactory.closeSession();//�ر�Session����
		return list;
	}

	public int findLinkQueryCount(String subjectTitle) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like :title ");
		query.setString("title","%"+subjectTitle+"%");
		List list = query.list();					//��ѯ���浽list��
		int count = list.size();
		HibernateSessionFactory.closeSession();//�ر�Session����
		return count;
	}

	public List<Subject> randomFindSubject(int number) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from Subject as sub order by rand()");
		query.setMaxResults(number);//���ò�ѯ��¼��
		List list = query.list();					//��ѯ���浽list��
		HibernateSessionFactory.closeSession();//�ر�Session����
		return list;
	}
}
