package org.online.booking.bus.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "STATE")
public class State {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "STATE_INCREAMENTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_INCREAMENTOR")
	@Column(name = "STATE_ID")
	private Long id;

	@Column(name = "STATE_NAME")
	private String name;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
