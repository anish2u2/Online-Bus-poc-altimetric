package org.online.booking.bus.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookingDetailsPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1435435L;

	@Column(name = "BUS_ID")
	private Long id;
	
	@Column(name = "TRAVELLING_DATE")
	private Date travellingDate;
	
	@Column(name = "SEAT_NUMBER")
	private int seatNumber;
	
	@Column(name = "SOURCE_CITY_ID")
	private Long sourceCityId;
	
	@Column(name = "DESTINATION_CITY_ID")
	private Long destinationCityId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTravellingDate() {
		return travellingDate;
	}

	public void setTravellingDate(Date travellingDate) {
		this.travellingDate = travellingDate;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Long getSourceCityId() {
		return sourceCityId;
	}

	public void setSourceCityId(Long sourceCityId) {
		this.sourceCityId = sourceCityId;
	}

	public Long getDestinationCityId() {
		return destinationCityId;
	}

	public void setDestinationCityId(Long destinationCityId) {
		this.destinationCityId = destinationCityId;
	}
	
	
}
