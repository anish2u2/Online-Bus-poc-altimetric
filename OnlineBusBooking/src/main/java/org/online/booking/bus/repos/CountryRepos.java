package org.online.booking.bus.repos;

import org.online.booking.bus.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepos extends CrudRepository<Country, Long>{
	
	@Query("from Country where countryName=:countryName ")
	public Country findByName(String countryName);
	
}
