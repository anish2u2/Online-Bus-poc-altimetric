package org.online.booking.bus.repos;

import org.online.booking.bus.entity.Operator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepos extends CrudRepository<Operator, Long>{
	
	@Query("from Operator where name=:operatorName")
	public Operator findByName(String operatorName);
	
}
