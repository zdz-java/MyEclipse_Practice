package com.zdz.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class ExamtimeCount {
	private static final Log log = LogFactory.getLog(ExamtimeCount.class);
	public Log getLog()
	{
		return log;
	}
	public void beforeEnter()
	{
		log.debug("enter into exam");
		System.out.println("enter into exam");
	}
	public Object countTime(ProceedingJoinPoint joinPoint)
	{
		Object object = null;
		try {
			long start = System.currentTimeMillis();
			object = joinPoint.proceed();
			long end = System.currentTimeMillis();
			long result = end - start;
			System.out.println("取出试题时间:"+result);
			
		} catch (Throwable e) {
			System.out.println("Exception happen when take out the subject");
			e.printStackTrace();
		}
		return object;
	}
	public void afterEnter()
	{
		log.debug("quit exam");
		System.out.println("quit exam");
	}
}