package org.online.booking.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1,  name = "ORDER_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_INCREAMENTOR")
	@Column(name = "ORDER_DETAILS_ID")
	private Long orderId;
	
	@Column(name = "ORDER_STATUS")
	private String status;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
