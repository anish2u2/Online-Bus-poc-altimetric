package org.online.booking.bus.contracts;

import org.online.booking.bus.model.BookRequest;

public interface BookTicket {
	
	public Long bookTicket(BookRequest request);
	
}
