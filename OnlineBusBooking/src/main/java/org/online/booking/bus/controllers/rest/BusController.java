package org.online.booking.bus.controllers.rest;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.online.booking.bus.contracts.BookTicket;
import org.online.booking.bus.contracts.Searcher;
import org.online.booking.bus.model.BookRequest;
import org.online.booking.bus.model.BookResponse;
import org.online.booking.bus.model.BusSearchResult;
import org.online.booking.bus.util.SortSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

	@Autowired
	private Searcher searcher;

	@Autowired
	private BookTicket ticketBookService;

	@RequestMapping(path = "/search.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BusSearchResult searchBus(@RequestParam(name = "sourceCity") String sourceCity,
			@RequestParam(name = "destinationCity") String destinationCity,
			@RequestParam(name = "travelDate") Date travelDate,
			@RequestParam(name = "returnDate", required = false) Date returnDate) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(travelDate);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		travelDate=cal.getTime();
		if(returnDate!=null) {
		cal.setTime(returnDate);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		returnDate=cal.getTime();
		}
		BusSearchResult result = searcher.findBuses(sourceCity, destinationCity, travelDate, returnDate);
		SortSearchResult sort = new SortSearchResult();
		Collections.sort(result.getUp().getBuses(), sort);
		if (returnDate != null)
			Collections.sort(result.getDown().getBuses(), sort);

		return result;

	}

	@RequestMapping(path = "/book.json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BookResponse bookTicket(@RequestBody BookRequest request) {
		try {
			Long tranxactionId = ticketBookService.bookTicket(request);
			if (tranxactionId == null) {
				throw new RuntimeException("Unable to book ticket");
			}
			BookResponse response = new BookResponse();
			response.setBookingId(tranxactionId.toString());
			response.setRequestDetails(request);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
