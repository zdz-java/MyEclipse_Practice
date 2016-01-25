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
	@Test
	public void downloaderTest()
	{
		Downloader d = new Downloader();
		Request r = new Request();
		
		String url = "http://localhost:8080/WebShop/default";
		r.setUrl(url);
		
		Scheduler s = new Scheduler();
		s.put(r);
		Request r2 = s.take();
		
		
		Page p = d.download(r2);

		Assert.assertEquals(p.getUrl(), url);
		Assert.assertEquals(p.getStatusCode(), 200);
	}
	@Test
	public void pageProcesserPutIntoSchedulerTest()
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
		Request r = new Request();
		
		String url = "http://localhost:8080/WebShop/default";
		r.setUrl(url);
		
		Scheduler s = new Scheduler();
		s.put(r);
		Request r2 = s.take();
		
		
		Page p = d.download(r2);
		
		PageProcesser pageProcesser = new PageProcesser();
		
		pageProcesser.setScheduler(s);
		pageProcesser.process(p);
		
//		Assert.assertEquals(s.take().getUrl(), "javascript:QuickSearch()");
//		由于此处的take当为空时为阻塞，所以会在最后一个url输出时卡住，如果要遍历则应该给出阻塞队列的对应不阻塞的方法
		String str = s.take().getUrl();
		while(str!=null)
		{
			System.out.println(str);
		}
	}
//	@Test
//	public void spiderTest()
//	{
//		Spider spider = new Spider();
//		String beginUrl = "http://localhost:8080/WebShop/default";
//		spider.putUrl();
//		spider.start();
//	}
}
