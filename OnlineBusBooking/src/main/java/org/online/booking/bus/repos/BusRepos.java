package org.online.booking.bus.repos;

import org.online.booking.bus.entity.Bus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepos extends CrudRepository<Bus, Long>{
	
	@Query("from Bus where busNumber=:busNumber")
	public Bus findByName(String busNumber);
	

}
