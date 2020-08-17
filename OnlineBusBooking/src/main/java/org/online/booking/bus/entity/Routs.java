package org.online.booking.bus.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROUTS")
public class Routs {

	@EmbeddedId
	private RoutPK routePK;

	public RoutPK getRoutePK() {
		return routePK;
	}

	public void setRoutePK(RoutPK routePK) {
		this.routePK = routePK;
	}

}
