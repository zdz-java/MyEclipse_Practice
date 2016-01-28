package com.zdz.spider.pageprocesser;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.nodes.Element;

import com.zdz.spider.scheduler.Scheduler;
import com.zdz.spider.util.Page;
import com.zdz.spider.util.Request;
import com.zdz.spider.util.ResultItem;

public class PageProcesser {
	private Log log = LogFactory.getLog(this.getClass());
	public ResultItem process(Page page)
	{
		System.out.println("进入到PageProcess的处理方法中");
		List<String> nextUrl = page.getNextUrls();
		System.out.println("Page中链接的个数为"+nextUrl.size());
		for(String str:nextUrl)
		{
			if(str!=null&&str!="")
			{
//				如果不满足条件就移除
				if(str.indexOf("http://localhost:8080/WebShop/cart.do")!=-1)
				{
					nextUrl.remove(str);
					log.info(Thread.currentThread().getName()+":移除了链接："+str);
				}
			}
			
		}
		ResultItem resultItem = new ResultItem();
		resultItem.setUrl(page.getUrl());
		resultItem.setHtml(page.getContent());
		return resultItem;
	}
}
