package org.online.booking.bus.model;

import java.util.Date;
import java.util.List;

public class Bus {

	private Long busId;

	private String busNumber;

	private String operator;

	private Date arrivalTime;

	private Long duration;

	private Long price;
	
	private Long capacity;

	private List<Integer> unavailableSeats;

	public List<Integer> getUnavailableSeats() {
		return unavailableSeats;
	}

	public void setUnavailableSeats(List<Integer> unavailableSeats) {
		this.unavailableSeats = unavailableSeats;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	
	
	
}
