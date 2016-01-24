package com.zdz.spider.util;

import java.util.List;

public class Page {
	private String url;
	private String content;
	private int statusCode;
	private List<String> nextUrls;
	

	public List<String> getNextUrls() {
//		应该返回一份拷贝以防止被修改
		return nextUrls;
	}

	
	public void setNextUrls(List<String> nextUrls) {
		this.nextUrls = nextUrls;
	}


	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
