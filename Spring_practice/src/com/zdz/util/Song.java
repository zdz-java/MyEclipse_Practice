package com.zdz.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Song {
	private String lir;
	public Song(String lir)
	{
		this.lir = lir;
	}
	public Song()
	{
		
	}
	public String getLir() {
		return lir;
	}
	@Autowired
	@Value("lalalala")
	public void setLir(String lir) {
		this.lir = lir;
	}
	
}
