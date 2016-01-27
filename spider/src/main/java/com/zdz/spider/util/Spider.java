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

public class Spider implements Callable<Boolean>,Runnable{
	private BlockingQueue<String> urls = new LinkedBlockingQueue<String>(10);
	private Downloader downloader;
	private PageProcesser pageProcesser;
	private FilePipeline filePipeline;
	private Scheduler scheduler = new Scheduler();
	private ExecutorService executorService = Executors.newFixedThreadPool(2);

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
		pageProcesser.setScheduler(scheduler);
		return this;
	}

	public Spider pipeline(FilePipeline filePipeline) {
		setFilePipeline(filePipeline);
		return this;
	}

	public Boolean call() throws Exception {
		 while(true)
		 {
		 if(Thread.currentThread().isInterrupted())
		 {
		 break;
		 }
		 executorService.submit(new Runnable() {
		 public void run() {
		 Request request = scheduler.take();
		 Page page = downloader.download(request);
		 ResultItem resultItem = pageProcesser.process(page);
		 filePipeline.process(resultItem);
		 }
		 });
		 }
//		for (int i = 0; i < 20; i++) {
//			executorService.execute(new Runnable() {
//				public void run() {
//					System.out.println("进入到线程池中任务的run方法中");
//					Request request = scheduler.take();
//					System.out.println("run方法中的测试节点二");
//					Page page = downloader.download(request);
//					System.out.println("run方法中的测试节点一");
//					ResultItem resultItem = pageProcesser.process(page);
//					filePipeline.process(resultItem);
//					System.out.println("完成线程池中任务的run方法");
//				}
//			});
//		}

		return null;
	}

	public void start() {
		for (String url : urls) {
			scheduler.put(new Request(url));
		}
		try {
			call();
			
//			System.out.println("进入到线程池中任务的run方法中");
//			Request request = scheduler.take();
//			System.out.println("run方法中的测试节点二");
//			Page page = downloader.download(request);
//			System.out.println("run方法中的测试节点一");
//			ResultItem resultItem = pageProcesser.process(page);
//			filePipeline.process(resultItem);
//			System.out.println("完成线程池中任务的run方法");

//			Thread thread = new Thread(this);
//			thread.start();
			
			System.out.println("主线程进入休眠");
			Thread.sleep(50000);
			System.out.println("主线程休眠结束");
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

	public void run() {
		System.out.println("进入到线程池中任务的run方法中");
		Request request = scheduler.take();
		System.out.println("run方法中的测试节点二");
		Page page = downloader.download(request);
		System.out.println("run方法中的测试节点一");
		ResultItem resultItem = pageProcesser.process(page);
		filePipeline.process(resultItem);
		System.out.println("完成线程池中任务的run方法");		
	}
	
}
