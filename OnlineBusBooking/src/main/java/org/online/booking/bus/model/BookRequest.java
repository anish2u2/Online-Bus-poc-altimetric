package org.online.booking.bus.model;

import java.util.List;

public class BookRequest {

	private Long busId;

	private List<PersonDetails> personDetails;

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public List<PersonDetails> getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(List<PersonDetails> personDetails) {
		this.personDetails = personDetails;
	}

}
