package org.online.booking.bus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVED_BUS_SEAT_DEATILS")
public class ReservedBusSeatDetails {
	@EmbeddedId
	private ReservedBusSeatPK reservedBusSeatPK;
	
	@Column(name = "SEAT_SELECTION_TIME")
	private Date selectedTime;

	public ReservedBusSeatPK getReservedBusSeatPK() {
		return reservedBusSeatPK;
	}

	public void setReservedBusSeatPK(ReservedBusSeatPK reservedBusSeatPK) {
		this.reservedBusSeatPK = reservedBusSeatPK;
	}

	public Date getSelectedTime() {
		return selectedTime;
	}

	public void setSelectedTime(Date selectedTime) {
		this.selectedTime = selectedTime;
	}

}
