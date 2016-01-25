package com.zdz.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.zdz.spider.downloader.Downloader;
import com.zdz.spider.pageprocesser.PageProcesser;
import com.zdz.spider.pipeline.FilePipeline;
import com.zdz.spider.scheduler.Scheduler;
import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;
import com.zdz.spider.util.ResultItem;

public class MainTest {
//	@Test
//	public void downloaderTest()
//	{
//		Downloader d = new Downloader();
//		Request r = new Request();
//		
//		String url = "http://www.baidu.com/";
//		r.setUrl(url);
//		
//		Scheduler s = new Scheduler();
//		s.put(r);
//		Request r2 = s.take();
//		
//		
//		Page p = d.download(r2);
//
//		Assert.assertEquals(p.getUrl(), url);
//		Assert.assertEquals(p.getStatusCode(), 200);
//	}
	@Test
	public void pageProcesserTest()
	{
		Page page = new Page();
		List<String> nextUrls = new LinkedList<String>();
		String url = "http://www.zhihu.com/";
		nextUrls.add(url);
		page.setNextUrls(nextUrls);
		PageProcesser pageProcesser = new PageProcesser();
		Scheduler s = new Scheduler();
		
		pageProcesser.setScheduler(s);
		pageProcesser.process(page);
		
		Assert.assertEquals(s.take().getUrl(), url);
		
	}
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
		
		File file = new File(path+"/"+url);
		try {
		FileInputStream	fileInputStream = new FileInputStream(file);
		StringBuilder fileContent = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
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
		}
	}
}
