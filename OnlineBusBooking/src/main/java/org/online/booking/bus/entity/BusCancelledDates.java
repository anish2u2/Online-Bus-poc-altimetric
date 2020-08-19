package org.online.booking.bus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUS_CANCELLED_DATES")
public class BusCancelledDates {
	
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "BUS_CANCELLED_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_CANCELLED_INCREAMENTOR")
	@Column(name = "ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "BUS_ID")
	private Bus busId;
	
	@Column(name = "CANCELLED_DATE")
	private Date cancelledDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bus getBusId() {
		return busId;
	}

	public void setBusId(Bus busId) {
		this.busId = busId;
	}

	public Date getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(Date cancelledDate) {
		this.cancelledDate = cancelledDate;
	}
	
	
}
