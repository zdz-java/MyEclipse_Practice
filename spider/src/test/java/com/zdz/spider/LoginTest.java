package com.zdz.spider;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
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
import org.junit.Test;

public class LoginTest {

//	@Test
	public void postLoginTest() {
		HttpPost httppost = new HttpPost("http://localhost:8080/WebShop/login");
		List<NameValuePair> parms = new ArrayList<NameValuePair>();
		parms.add(new BasicNameValuePair("loginName", "hujie"));
		parms.add(new BasicNameValuePair("loginPwd", "hujie"));
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parms,
					"utf-8");
			httppost.setEntity(entity);
			CloseableHttpClient httpclient2login = HttpClients.createDefault();
			CloseableHttpResponse httpResponse2login = httpclient2login
					.execute(httppost);
			HttpEntity entity2login = httpResponse2login.getEntity();
			System.out.println("POST:模拟登录后回执的状态码为："
					+ httpResponse2login.getStatusLine().getStatusCode());
			if (entity2login != null) {
				System.out.println("POST:返回的页面为："+EntityUtils.toString(entity2login));
			}

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	public void getLoginTest() {
		HttpGet httpGet = new HttpGet("http://localhost:8080/WebShop/login?loginName=hujie&loginPwd=hujie");
		try {
			CloseableHttpClient httpclient2login = HttpClients.createDefault();
			CloseableHttpResponse httpResponse2login = httpclient2login
					.execute(httpGet);
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
}
