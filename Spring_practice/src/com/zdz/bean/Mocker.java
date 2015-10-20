package com.zdz.bean;

import com.zdz.util.Song;

public class Mocker implements Performer {
	private Song song;
	@Override
	public void perform() {
		if(song==null)
		{
			System.out.println("I'm sorry,but please tell me which song I should to mock.");
		}
		else
		{
			System.out.println("mock: "+song.getLir());
		}
	}
	public Mocker()
	{
		
	}
	public Mocker(Song song)
	{
		this.song = song;
	}
	
}
