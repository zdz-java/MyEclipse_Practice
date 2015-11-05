package com.zdz.springmvc.model;

import javax.validation.constraints.NotNull;



public class User {
	@NotNull(message="{username.not.empty}")
	private String username;
	private String password;
	private String realname;
    private WorkInfoModel workInfo;  
    private SchoolInfoModel schoolInfo; 
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public WorkInfoModel getWorkInfo() {
		return workInfo;
	}

	public void setWorkInfo(WorkInfoModel workInfo) {
		this.workInfo = workInfo;
	}

	public SchoolInfoModel getSchoolInfo() {
		return schoolInfo;
	}

	public void setSchoolInfo(SchoolInfoModel schoolInfo) {
		this.schoolInfo = schoolInfo;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String toString()
	{
		String str;
		str="user:["+username+" "+password+" "+realname+" "+workInfo+" "+schoolInfo+"]";
		return str;
	}
}
