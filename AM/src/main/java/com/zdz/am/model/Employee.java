package com.zdz.am.model;

import java.util.Date;

public class Employee {
	private int employeeID;			//Ա�����
	private String employeeName;	//Ա������
	private boolean employeeSex;	//Ա���Ա�
	private Date employeeBirth;		//��������
	private String employeePhone;	//�칫�ҵ绰
	private String employeePlace;	//סַ
	private Date joinTime;			//¼��ʱ��
	private String password;		//ϵͳ����
	private boolean isLead;			//�Ƿ�Ϊ������쵼
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean isEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(boolean employeeSex) {
		this.employeeSex = employeeSex;
	}
	public Date getEmployeeBirth() {
		return employeeBirth;
	}
	public void setEmployeeBirth(Date employeeBirth) {
		this.employeeBirth = employeeBirth;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeePlace() {
		return employeePlace;
	}
	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLead() {
		return isLead;
	}
	public void setLead(boolean isLead) {
		this.isLead = isLead;
	}
}
