package com.zdz.spider.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.zdz.spider.downloader.Downloader;
import com.zdz.spider.pageprocesser.PageProcesser;
import com.zdz.spider.pipeline.FilePipeline;
import com.zdz.spider.scheduler.Scheduler;

public class Spider implements Callable<Boolean>{
	private BlockingQueue<String> urls = new LinkedBlockingQueue<String>(10);
	private Downloader downloader = new Downloader();
	private PageProcesser pageProcesser = new PageProcesser();
	private FilePipeline filePipeline = new FilePipeline();
	private Scheduler scheduler = new Scheduler();
	public Boolean call() throws Exception {
		while(true)
		{
			if(Thread.currentThread().isInterrupted())
			{
				break;
			}
			Request request = scheduler.take();
			Page page = downloader.download(request);
			ResultItem resultItem = pageProcesser.process(page);
			filePipeline.process(resultItem);	
		}
		
		return null;
	}
	public void start()
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(String url:urls)
		{
			scheduler.put(new Request(url));
		}
		executorService.submit(this);
	}
	public void putUrl(String url)
	{
		try {
			urls.put(url);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
