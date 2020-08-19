package org.online.booking.bus.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROUTS")
public class Routs {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "ROUTE_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROUTE_INCREAMENTOR")
	@Column(name = "ROUTE_ID")
	private Long id;
	
	@ElementCollection
	@Column(name = "STOPS")
	private List<Long> routeStops;

	@OneToOne
	@JoinColumn(name = "SOURCE_CITY_ID" ,referencedColumnName = "CITY_ID")
	private City startCity;

	@OneToOne
	@JoinColumn(name = "DESTINATION_CITY_ID",referencedColumnName = "CITY_ID")
	private City destinationCity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getRouteStops() {
		return routeStops;
	}

	public void setRouteStops(List<Long> routeStops) {
		this.routeStops = routeStops;
	}

	public City getStartCity() {
		return startCity;
	}

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}

	public City getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}

}
