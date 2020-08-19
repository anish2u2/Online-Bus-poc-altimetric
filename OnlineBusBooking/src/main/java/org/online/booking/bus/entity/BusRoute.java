package org.online.booking.bus.entity;

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
@Table(name = "BUS_ROUTE")
public class BusRoute {
	
	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1, name = "BUS_ROUTE_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_ROUTE_INCREAMENTOR")
	private Long id;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "BUS_ID", referencedColumnName = "BUS_ID")
	private Bus busId;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(referencedColumnName = "BUS_ROUT_DETAILS_ID", name = "BUS_ROUT_DETAILS_ID")
	private BusRouteDetails routDetails;

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

	public BusRouteDetails getRoutDetails() {
		return routDetails;
	}

	public void setRoutDetails(BusRouteDetails routDetails) {
		this.routDetails = routDetails;
	}
	
	
	
}
