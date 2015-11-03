package com.zdz.springmvc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class FormatterModel {
	@NumberFormat(style = Style.NUMBER, pattern = "#,###")
	private int totalCount;
	@NumberFormat(style = Style.PERCENT)
	private double discount;
	@NumberFormat(style = Style.CURRENCY)
	private double sumMoney;

	@DateTimeFormat(iso = ISO.DATE)
	private Date registerDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderDate;

	
	private PhoneNumberModel phoneNumber;
	
	
	
	
	public PhoneNumberModel getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumberModel phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
