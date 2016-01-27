package com.zdz.spider.util;

import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Page {
	private String url;
	private String content;
	private int statusCode;
	private Document document;
	public List<String> nextUrls;

	public Document getDocument() {
		return document;
	}

	public List<String> getNextUrls() {
		// 应该返回一份拷贝以防止被修改
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

	public String getHandledContent()
	{
		String contentAfterHandleTagA = UrlUtils.fixAllRelativeHrefs(content,
				url);
		return contentAfterHandleTagA;
	}
	
	public void setContent(String content) {
		this.content = content;
		document = Jsoup.parse(getHandledContent());
	}

	public List<Element> getElementsByTag(String str) {
		return document.getElementsByTag(str);
	}

}
