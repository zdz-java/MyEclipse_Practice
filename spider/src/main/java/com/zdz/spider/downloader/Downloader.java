package com.zdz.spider.downloader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;

public class Downloader {
	public Page download(Request r)
	{
		Page page = new Page();
		page.setUrl(r.getUrl());
		List<String> nextUrls = new LinkedList<String>();
//		nextUrls.add("http://www.zhihu.com/");
		page.setNextUrls(nextUrls);
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		HttpGet httpget = new HttpGet(r.getUrl());
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httpget);
			 HttpEntity entity = response.getEntity();  
	          page.setStatusCode(response.getStatusLine().getStatusCode());
	          if (entity != null) {  
	        	  page.setContent(EntityUtils.toString(entity));
	          }  
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		return page;
	}
}
