package com.zdz.bean;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	public void siteDown() {
		System.out.println("the audiance site down");
	}

	public void cheer() {
		System.out.println("bravo!bravo!");
	}

	public void booing() {
		System.out.println("I don't want to watch this shit!");
	}

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
