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

@Entity
@Table(name = "BUS")
public class Bus {
	
	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1, name = "BUS_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_INCREAMENTOR")
	@Column(name = "BUS_ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "BUS_DETAILS_ID")
	private BusDetails busDetails;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "OPERATOR_ID", name = "OPERATOR_ID")
	private Operator operator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BusDetails getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	
	
}
