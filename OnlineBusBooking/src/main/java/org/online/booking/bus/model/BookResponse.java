package org.online.booking.bus.model;

public class BookResponse {

	private String bookingId;

	private BookRequest requestDetails;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public BookRequest getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(BookRequest requestDetails) {
		this.requestDetails = requestDetails;
	}

}
