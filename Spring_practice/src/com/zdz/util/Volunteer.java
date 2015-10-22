package com.zdz.util;

public class Volunteer implements Thinker{
	private String thought;
	@Override
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
