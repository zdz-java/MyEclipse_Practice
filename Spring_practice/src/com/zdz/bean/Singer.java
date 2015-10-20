package com.zdz.bean;

public class Singer implements Performer {
	private Song song;

	@Override
	public void perform() {
		sing();
	}
	public Singer()
	{
		
	}
	public Singer(Song song)
	{
		this.song = song;
	}
	public void setSong(Song song)
	{
		this.song = song;
	}
	public void sing() {
		if (song != null) {
			System.out.println(song.getLir());
		} else {
			System.out.println("I'm sorry,I'm not read.");
		}
	}
}
