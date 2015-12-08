package com.sanqing.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION 
					= "/hibernate.cfg.xml";					//ָ�������ļ�·��
	private static final ThreadLocal<Session> threadLocal 
					= new ThreadLocal<Session>();			//����ThreadLocal����
	private  static Configuration configuration 
					= new Configuration();					//����Configuration����
	private static org.hibernate.SessionFactory sessionFactory;//����SessionFactory����
	private static String configFile = CONFIG_FILE_LOCATION;
	static {
		try {
			configuration.configure(configFile);//��ȡ�����ļ�
			sessionFactory = 
				configuration.buildSessionFactory();//��������ļ�����SessionFactory����
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}
	private HibernateSessionFactory() {
	}
	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();//��ThreadLocal�����л��Session����
		if (session == null || !session.isOpen()) {//�жϻ�õ�Session�����Ƿ�Ϊ�ջ���δ��
			if (sessionFactory == null) {//���û�д���SessionFactory���������ȴ���
				rebuildSessionFactory();
			}
			//���SessionFactory����Ϊ�գ��������openSession��������Session����
			session = (sessionFactory != null) ? sessionFactory.openSession(): null;
			threadLocal.set(session);//��ThreadLocal�����б����Session����
		}
		return session;
	}
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);//��ȡ�����ļ�
			sessionFactory = 
				configuration.buildSessionFactory();//��������ļ�����sessionFactory����
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}
	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();//��ThreadLocal�����л��Session����
		threadLocal.set(null);//����ǰ�߳�Session�����ThreadLocal�������Ƴ�
		if (session != null) {
			session.close();
		}
	}
	public static org.hibernate.SessionFactory getSessionFactory() {//ȡ��SessionFactory����
		return sessionFactory;
	}
	public static void setConfigFile(String configFile) {//�����µ������ļ�
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
	public static Configuration getConfiguration() {//���Configuration����
		return configuration;
	}
}