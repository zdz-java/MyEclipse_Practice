package com.zdz.bean;

public class Magician implements MindReader{
	private String thought;
	@Override
	public void interceptThought(String thought) {
		this.thought = thought;
		System.out.println("now I inercept his thought");
	}
	@Override
	public String getThought() {
		return thought;
	}

}
