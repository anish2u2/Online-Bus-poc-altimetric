package org.online.booking.bus.util;

import java.util.Comparator;

import org.online.booking.bus.model.Bus;

public class SortSearchResult implements Comparator<Bus> {

	@Override
	public int compare(Bus o1, Bus o2) {
		if(o1.getPrice()<o2.getPrice()) {
			return -1;
		}else if(o1.getPrice()>o2.getPrice()) {
			return 1;
		}
		return 0;
	}

}
