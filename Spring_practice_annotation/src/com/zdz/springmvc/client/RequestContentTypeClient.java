package com.zdz.springmvc.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class RequestContentTypeClient {
	public static void main(String[] args) {
		// 请求的地址
		String url = "http://localhost:8080/Spring_practice_annotation/request/ContentType";
		// ①创建Http Request(内部使用HttpURLConnection)
		ClientHttpRequest request;
		try {
System.out.println("It work! 2");			
			request = new SimpleClientHttpRequestFactory().createRequest(
					new URI(url), HttpMethod.POST);
			// ②设置请求头的内容类型头和内容编码（GBK）
			request.getHeaders().set("Content-Type",
					"application/json;charset=gbk");
			// ③以GBK编码写出请求内容体
			String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
			request.getBody().write(jsonData.getBytes("gbk"));
System.out.println("It work! 22");				
			// ④发送请求并得到响应
			ClientHttpResponse response = request.execute();
			System.out.println(response.getStatusCode());
System.out.println("It work! 222");				
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
