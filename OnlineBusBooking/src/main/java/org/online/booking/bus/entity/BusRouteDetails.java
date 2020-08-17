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
	@JoinColumn(name = "STATE_ID")
	private State state;

	@ManyToOne
	@JoinColumn(name = "CITY_ID")
	private City city;

	@Column(name = "SOURCE")
	private boolean source;

	@Column(name = "DESTINATION")
	private boolean destination;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isSource() {
		return source;
	}

	public void setSource(boolean source) {
		this.source = source;
	}

	public boolean isDestination() {
		return destination;
	}

	public void setDestination(boolean destination) {
		this.destination = destination;
	}

}
