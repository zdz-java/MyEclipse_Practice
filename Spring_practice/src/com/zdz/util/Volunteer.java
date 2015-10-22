package com.zdz.util;

import org.springframework.stereotype.Component;

@Component
public class Volunteer {
	private String thought;
	
	public void thinkOfSomething(String thought) {
		this.thought = thought;
	}
	
	public String getThought()
	{
		return thought;
	}

//	public void setThought(String thought)
//	{
//		this.thought = thought;
//	}
}
