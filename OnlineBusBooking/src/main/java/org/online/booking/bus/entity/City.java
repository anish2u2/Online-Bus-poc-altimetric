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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "CITY")
public class City {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CITY_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_INCREAMENTOR")
	@Column(name = "CITY_ID")
	private Long id;

	@Column(name = "CITY_NAME")
	private String cityName;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	
}
