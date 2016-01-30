package com.zdz.spider.util;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zdz.spider.downloader.Downloader;
import com.zdz.spider.pageprocesser.PageProcesser;
import com.zdz.spider.pipeline.FilePipeline;
import com.zdz.spider.scheduler.Scheduler;

public class Spider implements Callable<Boolean>{
	private Log log = LogFactory.getLog(this.getClass());
	private BlockingQueue<String> urls = new LinkedBlockingQueue<String>(10);
	private Downloader downloader;
	private PageProcesser pageProcesser;
	private FilePipeline filePipeline;
	private Scheduler scheduler = new Scheduler();
	private ExecutorService executorService = Executors.newFixedThreadPool(3);

	public void setDownloader(Downloader downloader) {
		this.downloader = downloader;
	}

	public void setPageProcesser(PageProcesser pageProcesser) {
		this.pageProcesser = pageProcesser;
	}

	public void setFilePipeline(FilePipeline filePipeline) {
		this.filePipeline = filePipeline;
	}

	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public Spider downloader(Downloader downloader) {
		setDownloader(downloader);
		return this;
	}

	public Spider pageProcesser(PageProcesser pageProcesser) {
		setPageProcesser(pageProcesser);
		return this;
	}

	public Spider pipeline(FilePipeline filePipeline) {
		setFilePipeline(filePipeline);
		return this;
	}

	public Boolean call() throws Exception {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				break;
			}
			executorService.submit(new Runnable() {
				public void run() {
					
					Request request = scheduler.poll();
					if(request==null)
					{
						return;
					}
					Page page = downloader.download(request);
					ResultItem resultItem = pageProcesser.process(page);
					
					List<String> nextUrls = page.getNextUrls();
					for(String s:nextUrls)
					{
						log.info(Thread.currentThread().getName()+":正在申请将链接放于调度器中："+s);
						scheduler.put(new Request(s));
					}
					
					filePipeline.process(resultItem);
				}
			});
		}
		return null;
	}

	public void start() {
		for (String url : urls) {
			scheduler.put(new Request(url));
		}
		try {
			call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void putUrl(String url) {
		try {
			urls.put(url);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Spider spider = new Spider();
		String beginUrl = "http://localhost:8080/WebShop/default";
		spider.putUrl(beginUrl);
		FilePipeline pipeline = new FilePipeline();
		pipeline.setPath("c:/_forjavatest");
		spider.pipeline(pipeline).downloader(new Downloader()).pageProcesser(new PageProcesser());
		spider.start();
	}
}
