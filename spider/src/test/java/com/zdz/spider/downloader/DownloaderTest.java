package com.zdz.spider.downloader;

import org.junit.Assert;
import org.junit.Test;

import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;

public class DownloaderTest {
	@Test
	public void mainTest()
	{
		Downloader d = new Downloader();
		Request r = new Request();
		
		String url = "http://www.baidu.com/";
		r.setUrl(url);
		
		Page p = d.download(r);
		Assert.assertEquals(p.getUrl(), url);
		Assert.assertEquals(p.getStatusCode(), 200);
		System.out.println(p.getContent());
	}
	@Test
	public void contentTest()
	{
		
	}
}
