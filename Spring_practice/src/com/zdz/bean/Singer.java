package com.zdz.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zdz.util.Song;
@Component
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
	@Autowired
	@Qualifier(value="song")
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
