package org.online.booking.bus.repos;

import org.online.booking.bus.entity.BusType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusTypesRepos extends CrudRepository<BusType, Long>{
	
	@Query("from BusType where description=:name")
	public BusType findByName(String name);
	

}
