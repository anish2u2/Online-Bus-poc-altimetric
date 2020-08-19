package org.online.booking.bus.model;

import java.util.List;

public class Buses {
	
	private List<Bus> buses;
	
	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	private int totalResult;
	
	

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
}
