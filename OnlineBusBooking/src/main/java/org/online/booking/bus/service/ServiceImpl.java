package org.online.booking.bus.service;

import java.util.Date;

import org.online.booking.bus.contracts.Searcher;
import org.online.booking.bus.contracts.Service;
import org.online.booking.bus.dao.BusBookingDataAccessObject;
import org.online.booking.bus.model.BusSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class ServiceImpl<T> implements Service<T>,Searcher {

	@Autowired
	private BusBookingDataAccessObject dao;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public void save(T data) {
		dao.getHibernateTemplate().save(data);
	}

	@Override
	public void delete(T data) {
		dao.getHibernateTemplate().delete(data);
	}

	@Override
	public void update(T data) {
		dao.getHibernateTemplate().saveOrUpdate(data);
	}

	@Override
	public BusSearchResult findBuses(String sourceCity, String destinationCity, Date travelDate, Date returnDate) {
		
		return dao.searchBuses(sourceCity, destinationCity, travelDate, returnDate);
	}

}
