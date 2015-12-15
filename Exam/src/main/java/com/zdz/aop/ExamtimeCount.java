package com.zdz.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class ExamtimeCount {
	private static final Log log = LogFactory.getLog(ExamtimeCount.class);
	
	@Pointcut("execution(* com.zdz.controller.StudentController.studentIndex(..))")
	public void studentIndex()
	{
		
	}
	
	@Pointcut("execution(* com.zdz.controller.StudentController.calculateScore(..))")
	public void calculate()
	{
		
	}
	
	public Log getLog()
	{
		return log;
	}
	@Before("studentIndex()")
	public void beforeEnter()
	{
		log.debug("enter into exam");
		System.out.println("enter into exam");
	}
	@Around("studentIndex()")
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
	@Before("calculate()")
	public void afterEnter()
	{
		log.debug("quit exam");
		System.out.println("quit exam");
	}
}