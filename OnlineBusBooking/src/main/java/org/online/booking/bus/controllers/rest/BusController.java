package org.online.booking.bus.controllers.rest;

import java.util.Collections;
import java.util.Date;

import org.online.booking.bus.contracts.Searcher;
import org.online.booking.bus.model.BusSearchResult;
import org.online.booking.bus.util.SortSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

	@Autowired
	private Searcher searcher;

	@RequestMapping(path = "/search.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BusSearchResult searchBus(@RequestParam(name = "sourceCity") String sourceCity,
			@RequestParam(name = "destinationCity") String destinationCity,
			@RequestParam(name = "travelDate") Date travelDate,
			@RequestParam(name = "returnDate", required = false) Date returnDate) {
		try {
			BusSearchResult result = searcher.findBuses(sourceCity, destinationCity, travelDate, returnDate);
			SortSearchResult sort = new SortSearchResult();
			Collections.sort(result.getUp().getBuses(), sort);
			if (returnDate != null)
				Collections.sort(result.getDown().getBuses(), sort);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
