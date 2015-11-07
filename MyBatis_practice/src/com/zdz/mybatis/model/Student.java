package com.zdz.mybatis.model;

import javax.faces.flow.builder.ReturnBuilder;

public class Student {
	private int id;
	private String name;
	private int lessonid;
	private int studentid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLessonid() {
		return lessonid;
	}
	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public String toString()
	{
		return "Student["+id+" "+name+" "+studentid+" "+lessonid+"]";
	}
	
}
