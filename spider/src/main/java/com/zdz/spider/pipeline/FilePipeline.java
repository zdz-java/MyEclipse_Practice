package com.zdz.spider.pipeline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zdz.spider.util.ResultItem;

public class FilePipeline {
	private	String path;
	private Log log = LogFactory.getLog(this.getClass());
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void process(ResultItem resultItem) {
		System.out.println("enter into the pipeline process method");
		if(resultItem == null)
		{
			throw new NullPointerException("null resultItem");
		}
		String url = resultItem.getUrl();
		String name = url.substring(url.indexOf("/WebShop/")+9);
		name = name.replace('?', '@');
//		String name = Integer.toString(new Random().nextInt(1000));
		File file = new File(path+"/"+name+".txt");
//		File file = new File(path+"/"+resultItem.getUrl()+".txt");
		try {
			if(file.exists())
			{
				log.info(Thread.currentThread().getName()+":此url重复添加文件:"+url);
			}
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			bufferedWriter.write(resultItem.getHtml());
//			fileOutputStream.close();
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
