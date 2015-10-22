package com.zdz.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class Magician implements MindReader{
	private String thought;
	@Pointcut("execution(* com.zdz.util.Volunteer.thinkOfSomething(String)) && args(thought)")
	public void point(String thought)
	{
		
	}
	@Override
	@Before("point(thought)")
	public void interceptThought(String thought) {
		this.thought = thought;
		System.out.println("now I inercept his thought");
	}
	@Override
	public String getThought() {
		return thought;
	}

}
