package org.online.booking.bus.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING_DETAILS")
public class BookingDetails {
	
	@EmbeddedId
	private BookingDetailsPk bookingId;
	
	@Column(name = "TRAVELLER_NAME")
	private String travellerName;
	
	@Column(name = "TRAVELLER_CONTACT_NUMBER")
	private Long travellerContactNumber;
	
	@Column(name = "TRAVELLER_EMAIL_ID")
	private String travellerEmailId;
	
	@Column(name = "TRAVELLER_GOV_NUMBER")
	private String travellerId;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_DETAILS_ID")
	private OrderDetails orderDetails;

	public BookingDetailsPk getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingDetailsPk bookingId) {
		this.bookingId = bookingId;
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

	public String getTravellerId() {
		return travellerId;
	}

	public void setTravellerId(String travellerId) {
		this.travellerId = travellerId;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
}
