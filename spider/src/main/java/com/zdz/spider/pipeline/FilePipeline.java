package com.zdz.spider.pipeline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import com.zdz.spider.util.ResultItem;

public class FilePipeline {
	private	String path;
	
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
		String name = Integer.toString(new Random().nextInt(1000));
		File file = new File(path+"/"+name+".txt");
//		File file = new File(path+"/"+resultItem.getUrl()+".txt");
		try {
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
