package org.online.booking.bus.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private String countyName;

	@OneToMany
	@JoinColumn(name = "STATE_ID")
	private List<State> states;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	

}
