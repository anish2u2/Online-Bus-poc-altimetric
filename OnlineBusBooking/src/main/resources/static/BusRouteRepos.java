package org.online.booking.bus.repos;

import org.online.booking.bus.entity.Routs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRouteRepos extends CrudRepository<Routs, Long> {
	
	
	
	
}
