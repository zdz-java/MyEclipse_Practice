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
import org.jsoup.nodes.Element;

import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;

public class Downloader {
	public Page download(Request r)
	{
		System.out.println("进入到下载器的下载方法中");
		Page page = new Page();
		page.setUrl(r.getUrl());
		System.out.println(r.getUrl());
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		System.out.println("下载器中测试节点0");
		HttpGet httpget = new HttpGet(r.getUrl());
		CloseableHttpResponse response;
		try {
			System.out.println("下载器中测试节点1");
			response = httpclient.execute(httpget);
			 HttpEntity entity = response.getEntity();  
	          page.setStatusCode(response.getStatusLine().getStatusCode());
	          if (entity != null) {  
	        	  System.out.println("下载器中测试节点2");
	        	  page.setContent(EntityUtils.toString(entity));
	          }  
	          System.out.println("下载器中测试节点3");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		System.out.println("下载完成，正在将页面内的链接放于page中");
		List<String> nextUrls = new LinkedList<String>();
		List<Element> elements = page.getElementsByTag("a");
		for(Element e:elements)
		{
			if(e.hasAttr("href"))
			{
				nextUrls.add(e.attr("href"));
				System.out.println("正在将链接"+e.attr("href")+" 放入page中");
			}
		}
		page.setNextUrls(nextUrls);
		return page;
	}
}
