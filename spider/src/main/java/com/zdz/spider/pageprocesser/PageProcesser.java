package com.zdz.spider.pageprocesser;

import java.util.List;

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
		
		List<String> nextUrl = page.getNextUrls();
		for(String str:nextUrl)
		{
			Request request = new Request();
			request.setUrl(str);
			scheduler.put(request);
		}
		ResultItem resultItem = new ResultItem();
		resultItem.setHtml(page.getContent());
		return resultItem;
	}
}
