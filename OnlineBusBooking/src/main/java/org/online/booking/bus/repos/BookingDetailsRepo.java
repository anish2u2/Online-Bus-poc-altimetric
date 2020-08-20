package org.online.booking.bus.repos;

import java.util.Date;
import java.util.List;

import org.online.booking.bus.entity.BookingDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepo extends CrudRepository<BookingDetails, Long>{

	@Query("select distinct bookingId.seatNumber from BookingDetails where bookingId.travellingDate in (:date) and bookingId.id=:busId")
	public List<Integer> findAllUnavailableSeats(Date date,Long busId);
	
}
