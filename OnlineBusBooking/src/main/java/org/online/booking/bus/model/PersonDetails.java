package org.online.booking.bus.model;

import java.util.Date;

public class  PersonDetails {
	private String travellerName;
	private Long travellerContactNumber;
	private String travellerEmailId;
	private Integer seatNumber;
	private Date travellingDate;
	private String sourceCity;
	private String destinationCity;
	private String travelerId;
	
	

	public String getTravelerId() {
		return travelerId;
	}

	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}

	public String getTravellerName() {
		return travellerName;
	}

	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}

	public Long getTravellerContactNumber() {
		return travellerContactNumber;
	}

	public void setTravellerContactNumber(Long travellerContactNumber) {
		this.travellerContactNumber = travellerContactNumber;
	}

	public String getTravellerEmailId() {
		return travellerEmailId;
	}

	public void setTravellerEmailId(String travellerEmailId) {
		this.travellerEmailId = travellerEmailId;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Date getTravellingDate() {
		return travellingDate;
	}

	public void setTravellingDate(Date travellingDate) {
		this.travellingDate = travellingDate;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

}

