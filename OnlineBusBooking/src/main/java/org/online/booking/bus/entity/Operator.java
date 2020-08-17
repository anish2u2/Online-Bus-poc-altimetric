package org.online.booking.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATOR")
public class Operator {
	
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1,  name = "OPERATOR_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPERATOR_INCREAMENTOR")
	@Column(name = "OPERATOR_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
