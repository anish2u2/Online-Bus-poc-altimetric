package org.online.booking.bus.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoutPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 145643L;

	@Column(name = "FROM_CITY_ID")
	private Long fromCityId;
	
	@Column(name = "TO_CITY_ID")
	private Long toCityId;

	public Long getFromCityId() {
		return fromCityId;
	}

	public void setFromCityId(Long fromCityId) {
		this.fromCityId = fromCityId;
	}

	public Long getToCityId() {
		return toCityId;
	}

	public void setToCityId(Long toCityId) {
		this.toCityId = toCityId;
	}
	
	
	
}
