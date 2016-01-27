package com.zdz.spider.pageprocesser;

import java.util.List;

import org.jsoup.nodes.Element;

import com.zdz.spider.scheduler.Scheduler;
import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;
import com.zdz.spider.util.ResultItem;

public class PageProcesser {
	private Scheduler scheduler;

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	public ResultItem process(Page page)
	{
		System.out.println("进入到PageProcess的处理方法中");
		List<String> nextUrl = page.getNextUrls();
		System.out.println("Page中链接的个数为"+nextUrl.size());
		for(String str:nextUrl)
		{
			if(str!=null&&str!="")
			{
				Request request = new Request(str);
				System.out.println("正在将连接："+str+"放入调度器中");
				scheduler.put(request);
			}
			
		}
		ResultItem resultItem = new ResultItem();
		resultItem.setUrl(page.getUrl());
		resultItem.setHtml(page.getContent());
		return resultItem;
	}
}
