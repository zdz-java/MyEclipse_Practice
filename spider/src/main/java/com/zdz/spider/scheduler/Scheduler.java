package com.zdz.spider.scheduler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zdz.spider.util.Request;

public class Scheduler {
	private Log log = LogFactory.getLog(this.getClass());
	private BlockingQueue<Request> requests = new LinkedBlockingDeque<Request>();
	private Set<String> loadedUrl = Collections.synchronizedSet(new HashSet<String>());
	public void put(Request request)
	{
		String url = request.getUrl();
		synchronized (loadedUrl) {
			if(loadedUrl.contains(url))
			{
				log.info(Thread.currentThread().getName()+":该链接已经添加，不再重复添加："+url);
				return;
			}
			log.info(Thread.currentThread().getName()+":该链接尚未添加，正在加入到调度器中："+url);
			loadedUrl.add(url);
		}
		try {
			requests.put(request);
		} catch (InterruptedException e) {
			log.debug("等待添加新的Request到Scheduler被打断");			
			e.printStackTrace();
		}
	}
	public Request take()
	{
		System.out.println("进入到调度器的take方法,此时阻塞队列的size是："+requests.size());
		Request toMove = null;
		try {
			toMove = requests.take();
			System.out.println("离开调度器的take方法,此时阻塞队列的size是"+requests.size());
		} catch (InterruptedException e) {
			log.debug("等待从Scheduler中获取Request被打断");
			e.printStackTrace();
		}
		return toMove;
	}
}
