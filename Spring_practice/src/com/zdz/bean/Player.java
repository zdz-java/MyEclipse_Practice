package com.zdz.bean;

import java.util.LinkedList;
import java.util.List;

import com.zdz.util.Instrument;

public class Player implements Performer {
	List<Instrument> instruments = new LinkedList<>();

	@Override
	public void perform() {
		if (instruments.size() > 0) {
			for (Instrument instrument : instruments)
			{
				instrument.work();
			}
		}else {
			System.out.println("I'm sorry,but My instrument lost.");
		}
	}

	public void addInstruments(Instrument instrument) {
		instruments.add(instrument);
	}
	public boolean remove(Instrument instrument)
	{
		return instruments.remove(instrument);
	}
	public void setInstruments(List<Instrument> list) {
		instruments = list;
	}
}
