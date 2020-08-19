package org.online.booking.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "BUS_DETAILS")
public class BusDetails {
	
	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1, name = "BUS_DETAILS_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_DETAILS_INCREAMENTOR")
	@Column(name = "BUS_DETAILS_ID")
	private Long id;

	
	@Column(name = "CAPACITY")
	private Long busCapacity;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "BUS_TYPE_ID")
	private BusType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusCapacity() {
		return busCapacity;
	}

	public void setBusCapacity(Long busCapacity) {
		this.busCapacity = busCapacity;
	}

	public BusType getType() {
		return type;
	}

	public void setType(BusType type) {
		this.type = type;
	}
	
	
	
}
