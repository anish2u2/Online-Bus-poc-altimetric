package org.online.booking.bus.contracts;

import java.util.Date;

import org.online.booking.bus.model.BusSearchResult;

public interface Searcher {
	
	/**
	 * Finds available buses.
	 * @param sourceCity
	 * @param destinationCity
	 * @param travelDate
	 * @param returnDate
	 * @return
	 */
	public BusSearchResult findBuses(String sourceCity,String destinationCity,Date travelDate, Date returnDate);
	
	
	
	
}
