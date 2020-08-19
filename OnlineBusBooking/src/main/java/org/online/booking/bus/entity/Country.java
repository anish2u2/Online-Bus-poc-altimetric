package org.online.booking.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1,  name = "COUNTRY_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRY_INCREAMENTOR")
	@Column(name = "COUNTRY_ID")
	private Long id;

	@Column(name = "COUNTRY_NAME")
	private String countryName;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


}
