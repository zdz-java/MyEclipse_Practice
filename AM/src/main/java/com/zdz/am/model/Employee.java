package com.zdz.am.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Employee {
	
	private int employeeID;	
	private String employeeName;	//Ա������
	private boolean employeeSex;
//	只是为了测试数据验证，没有实际用途
//	结果处出了一个小BUG，取出来的错误值为"{employeeID.not.null}"而不是对应的错误信息
	@NotNull(message="{employeeID.not.null}")
	private Date employeeBirth;		//��������
	private String employeePhone;	//�칫�ҵ绰
	private String employeePlace;
	private Date joinTime;	
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
