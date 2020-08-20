package org.online.booking.bus.service;

import java.util.Calendar;
import java.util.Date;

import org.online.booking.bus.contracts.BookTicket;
import org.online.booking.bus.contracts.Searcher;
import org.online.booking.bus.contracts.Service;
import org.online.booking.bus.dao.BusBookingDataAccessObject;
import org.online.booking.bus.entity.BookingDetails;
import org.online.booking.bus.entity.BookingDetailsPk;
import org.online.booking.bus.entity.OrderDetails;
import org.online.booking.bus.model.BookRequest;
import org.online.booking.bus.model.BusSearchResult;
import org.online.booking.bus.repos.CityRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class ServiceImpl<T> implements Service<T>,Searcher,BookTicket {

	@Autowired
	private BusBookingDataAccessObject dao;
	
	@Autowired
	private CityRepos cityRepos;

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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long bookTicket(BookRequest request) {
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setStatus("IN-PROGRESS");
		dao.getHibernateTemplate().save(orderDetails);
		System.out.println("Order Id:"+orderDetails.getOrderId());
		System.out.println("bus id:"+request.getBusId());
		request.getPersonDetails().forEach((person)->{
			Calendar cal=Calendar.getInstance();
			cal.setTime(person.getTravellingDate());
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.MILLISECOND, 0);
			BookingDetails details=new BookingDetails();
			details.setTravellerName(person.getTravellerName());
			details.setOrderDetails(orderDetails);
			details.setTravellerContactNumber(person.getTravellerContactNumber());
			details.setTravellerEmailId(person.getTravellerEmailId());
			details.setTravellerId(person.getTravelerId());
			BookingDetailsPk pk=new BookingDetailsPk();
			pk.setDestinationCityId(cityRepos.findByName(person.getSourceCity()).getId());
			pk.setSourceCityId(cityRepos.findByName(person.getSourceCity()).getId());
			pk.setSeatNumber(person.getSeatNumber());
			pk.setId(request.getBusId());
			pk.setTravellingDate(cal.getTime());
			details.setBookingId(pk);
			dao.getHibernateTemplate().save(details);
		});
		orderDetails.setStatus("BOOKED");
		dao.getHibernateTemplate().saveOrUpdate(orderDetails);
		return orderDetails.getOrderId();
	}

}
