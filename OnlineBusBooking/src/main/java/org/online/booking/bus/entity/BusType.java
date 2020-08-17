package org.online.booking.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUS_TYPE")
public class BusType {

	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1, name = "BUS_TYPE_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_TYPE_INCREAMENTOR")
	@Column(name = "BUS_TYPE_ID")
	private Long id;
	
	@Column(name = "TYPE_DESCRIPTION")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
