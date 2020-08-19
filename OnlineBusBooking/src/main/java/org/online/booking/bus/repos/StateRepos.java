package org.online.booking.bus.repos;

import org.online.booking.bus.entity.State;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepos extends CrudRepository<State, Long>{
	
	@Query("from State where name=:stateName")
	public State findByName(String stateName);
	
}
