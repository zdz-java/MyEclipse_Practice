package com.zdz.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

import com.zdz.spider.downloader.Downloader;
import com.zdz.spider.pageprocesser.PageProcesser;
import com.zdz.spider.pipeline.FilePipeline;
import com.zdz.spider.scheduler.Scheduler;
import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;
import com.zdz.spider.util.ResultItem;
import com.zdz.spider.util.Spider;

public class MainTest {
	@Test
	public void downloaderTest()
	{
		Downloader d = new Downloader();
		String url = "http://localhost:8080/WebShop/default";
		Request r = new Request(url);
		Scheduler s = new Scheduler();
		s.put(r);
		Request r2 = s.take();
		
		
		Page p = d.download(r2);

		Assert.assertEquals(p.getUrl(), url);
		Assert.assertEquals(p.getStatusCode(), 200);
	}
//	@Test
//	因为pageProcesser与Scheduler解耦，此测试方法不再起作用
//	public void pageProcesserPutIntoSchedulerTest()
//	{
//		Downloader d = new Downloader();
//		String url = "http://localhost:8080/WebShop/default";
//		Request r = new Request(url);
//		Scheduler s = new Scheduler();
//		s.put(r);
//		Request r2 = s.take();
//		Page page = d.download(r2);
//		
//		List<String> nextUrls = new LinkedList<String>();
//		String nurl = "http://www.zhihu.com/";
//		nextUrls.add(nurl);
//		page.setNextUrls(nextUrls);
//		PageProcesser pageProcesser = new PageProcesser();
//		
//		pageProcesser.process(page);
//		
//		Assert.assertEquals(s.take().getUrl(), nurl);
//		
//	}
	@Test
	public void pipelineTest()
	{
		FilePipeline p = new FilePipeline();
		String path = "c:/_forjavatest";
		p.setPath(path);
		ResultItem resultItem = new ResultItem();
		String url = "www.zdz.com";
		String html = "this is the result html";
		resultItem.setUrl(url);
		resultItem.setHtml(html);
		p.process(resultItem);
		
		File file = new File(path+"/"+url+".txt");
		BufferedReader bufferedReader = null;
		try {
		FileInputStream	fileInputStream = new FileInputStream(file);
		StringBuilder fileContent = new StringBuilder();
		bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String temp = bufferedReader.readLine();
		while(temp!=null)
		{
			fileContent.append(temp);
			temp = bufferedReader.readLine();
		}
		Assert.assertEquals(html, fileContent.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	public void pageProcesserTest()
	{
		Downloader d = new Downloader();
		String url = "http://localhost:8080/WebShop/default";
		Request r = new Request(url);
		Scheduler s = new Scheduler();
		s.put(r);
		Request r2 = s.take();
		
		
		Page p = d.download(r2);
		
		PageProcesser pageProcesser = new PageProcesser();
		
		pageProcesser.process(p);
		
		System.out.println(p.getContent());
		List<Element> list = p.getElementsByTag("a");
		for(Element e:list)
		{
			System.out.println("Element:");
			System.out.println(e.attr("href"));
			
		}
		for(String str:p.nextUrls)
		{
			System.out.println(str);
		}
	}
//	@Test
//	public void spiderTest()
//	{
//		Spider spider = new Spider();
//		String beginUrl = "http://localhost:8080/WebShop/default";
//		spider.putUrl(beginUrl);
//		FilePipeline pipeline = new FilePipeline();
//		pipeline.setPath("c:/_forjavatest");
//		spider.pipeline(pipeline).downloader(new Downloader()).pageProcesser(new PageProcesser());
//		spider.start();
//	}
}
