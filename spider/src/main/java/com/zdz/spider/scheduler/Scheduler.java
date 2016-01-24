package com.zdz.spider.scheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zdz.spider.util.Request;

public class Scheduler {
	private Log log = LogFactory.getLog(this.getClass());
	private BlockingQueue<Request> requests = new LinkedBlockingDeque<Request>();
	public void put(Request request)
	{
		try {
			requests.put(request);
		} catch (InterruptedException e) {
			log.debug("等待添加新的Request到Scheduler被打断");			
			e.printStackTrace();
		}
	}
	public Request take()
	{
		Request toMove = null;
		try {
			toMove = requests.take();
		} catch (InterruptedException e) {
			log.debug("等待从Scheduler中获取Request被打断");
			e.printStackTrace();
		}
		return toMove;
	}
}
