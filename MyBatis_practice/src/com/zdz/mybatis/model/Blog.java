package com.zdz.mybatis.model;

public class Blog {
	private int bid;
	private String title;
	private String content;
	private int owner;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public String toString()
	{
		return "Blog["+bid+" "+title+" "+content+" "+owner+"]";
	}
}
