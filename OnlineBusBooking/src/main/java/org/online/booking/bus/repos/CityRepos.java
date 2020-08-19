package org.online.booking.bus.repos;

import java.util.List;

import org.online.booking.bus.entity.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepos extends CrudRepository<City, Long>{
	
	@Query("from City where upper(cityName) like upper(:cityName)")
	public City findByName(String cityName);
	
	@Query("select distinct id from City where cityName in (:cities)")
	public List<Long> findCityIdByNames(List<String> cities);
	
}
