package com.zdz.bean;

import com.zdz.util.Song;

public class Singer implements Performer {
	private Song song;

	@Override
	public void perform() {
		sing();
	}

	public Singer() {

	}

	public Singer(Song song) {
		this.song = song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	public Song getSong()
	{
		return song;
	}
	public void sing() {
		if (song != null) {
			System.out.println(song.getLir());
		} else {
			System.out.println("I'm sorry,I'm not read.");
		}
	}
	
	public void warmUp()
	{
		System.out.println(this.getClass().getName()+"[init-method]:"+"I'm dancing to warm up");
	}
	
	public void thank()
	{
		System.out.println("thank everyone to watch my show");
	}
	
	
}
