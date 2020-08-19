package org.online.booking.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUS_ROUTE_DETAILS")
public class BusRouteDetails {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "BUS_ROUTE_DETAILS_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_ROUTE_DETAILS_INCREAMENTOR")
	@Column(name = "BUS_ROUT_DETAILS_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ROUTE_ID")
	private Routs route;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Routs getRoute() {
		return route;
	}

	public void setRoute(Routs route) {
		this.route = route;
	}

	
}
