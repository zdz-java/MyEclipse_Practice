package com.zdz.am.model;

import java.util.Date;

public class Criticism {
	private int criticismID;		//��ID
	private String criticismContent;//������
	private int employeeID;			//����ID
	private Date criticismTime;		//��ʱ��
	private int messageID;			//��ϢID
	public int getCriticismID() {
		return criticismID;
	}
	public void setCriticismID(int criticismID) {
		this.criticismID = criticismID;
	}
	public String getCriticismContent() {
		return criticismContent;
	}
	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getCriticismTime() {
		return criticismTime;
	}
	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
}
