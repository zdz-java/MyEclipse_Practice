package com.zdz.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class Audience {
	@Pointcut("execution(* com.zdz.bean.Player.perform(..))")
	public void point()
	{
		
	}
	
	@Before("point()")
	public void siteDown() {
		System.out.println("the audiance site down");
	}
	@After("point()")
	public void cheer() {
		System.out.println("bravo!bravo!");
	}
	@AfterThrowing("point()")
	public void booing() {
		System.out.println("I don't want to watch this shit!");
	}
	@Around("point()")
	public void timeCount(ProceedingJoinPoint joinpoint) {

		try {
			long before = System.currentTimeMillis();
			joinpoint.proceed();
			long after = System.currentTimeMillis();
			System.out.println("the show insist " + (after - before) + " ms");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
}
