package com.zdz.ssm.model;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Article{
	private int id;
	private int pid; //private Article parent
	private int rootId;
	private String title;
	private String cont;
	private Date pdate;
	private boolean isLeaf;
	private String username;
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public void initFromRs(ResultSet rs) {
		try {
			setId(rs.getInt("id"));
			setPid(rs.getInt("pid"));
			setRootId(rs.getInt("rootid"));
			setTitle(rs.getString("title"));
			setIsLeaf(rs.getInt("isleaf") == 0 ? true : false);
			setPdate(rs.getTimestamp("pdate"));
			setCont(rs.getString("cont"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
