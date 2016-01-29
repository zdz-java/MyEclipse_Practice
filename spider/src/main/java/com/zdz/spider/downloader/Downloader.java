package com.zdz.spider.downloader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Element;

import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;

public class Downloader {
	private Log log = LogFactory.getLog(this.getClass());
	public Page download(Request r)
	{
		System.out.println("进入到下载器的下载方法中");
		Page page = new Page();
		page.setUrl(r.getUrl());
		System.out.println(r.getUrl());
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		System.out.println("下载器中测试节点0");
		if("http://localhost:8080/WebShop/default"==r.getUrl())
		{
			
			HttpGet httpGet2login = new HttpGet("http://localhost:8080/WebShop/login?loginName=hujie&loginPwd=hujie");
			try {
				CloseableHttpClient httpclient2login = HttpClients.createDefault();
				CloseableHttpResponse httpResponse2login = httpclient2login
						.execute(httpGet2login);
				HttpEntity entity2login = httpResponse2login.getEntity();
				System.out.println("GET:模拟登录后回执的状态码为："
						+ httpResponse2login.getStatusLine().getStatusCode());
				if (entity2login != null) {
					System.out.println("GET:返回的页面为："+EntityUtils.toString(entity2login));
				}

			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (ClientProtocolException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
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
