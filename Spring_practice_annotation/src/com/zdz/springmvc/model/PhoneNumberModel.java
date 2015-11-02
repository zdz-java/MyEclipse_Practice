package com.zdz.springmvc.model;

public class PhoneNumberModel {
	private String areaCode;// 区号
	private String phoneNumber;// 电话号码
	public PhoneNumberModel()
	{
		
	}
	public PhoneNumberModel(String string, String string2) {
		areaCode = string;
		phoneNumber = string2;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String toString()
	{
		return "Phone:[areaCode:"+areaCode+" phoneNumber:"+phoneNumber+" ]";
	}
}
