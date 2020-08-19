package org.online.booking.bus.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.online.booking.bus.entity.Bus;
import org.online.booking.bus.model.BusSearchResult;
import org.online.booking.bus.model.Buses;
import org.online.booking.bus.repos.BusRepos;
import org.online.booking.bus.structure.Distance;
import org.online.booking.bus.structure.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class BusBookingDataAccessObject extends HibernateDaoSupport {

	private final String SEARCH_QUERY = "select distinct  br.bus_id from BUS_ROUTE br left join bus b on (b.bus_id=br.bus_id) left join BUS_DETAILS bd on (bd.BUS_DETAILS_ID=b.BUS_DETAILS_ID) left join BUS_TYPE bt on (bt.BUS_TYPE_ID=bd.BUS_TYPE_ID) where bus_rout_details_id in (select distinct bus_rout_details_id from BUS_ROUTE_DETAILS where ROUTE_ID in (select distinct route_id FROM ROUTS WHERE  (source_city_id IN (select distinct city_id from city where upper(city_name) like upper(:source)) OR (route_id IN (SELECT DISTINCT routs_route_id FROM routs_routestops WHERE stops in(select distinct city_id from city where upper(city_name) like upper(:source))) )) AND (destination_city_id IN (select distinct city_id from city where upper(city_name) like upper(:destination))OR (route_id IN (SELECT DISTINCT routs_route_id FROM routs_routestops WHERE stops in(select distinct city_id from city where upper(city_name) like upper(:destination)))))))  ";

	private final String FILTER_AVAILABLE_BUS = "select distinct bus_id from BUS_CANCELLED_DATES where CANCELLED_DATE in (:travelDate) and bus_id in (:busIds) ";

	@Autowired
	private DistanceUtil util;

	@Autowired
	private BusRepos busRepo;

	@Autowired
	public void setInjectSessionFactory(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@SuppressWarnings("All")
	public BusSearchResult searchBuses(final String sourceCity, final String destinationCity, final Date travelDate,
			final Date returnDate) {
		return this.getHibernateTemplate().execute(new HibernateCallback<BusSearchResult>() {

			@Override
			public BusSearchResult doInHibernate(Session session) throws HibernateException {
				BusSearchResult busResult = new BusSearchResult();
				Query query = session.createNativeQuery(SEARCH_QUERY);
				query.setParameter("source", sourceCity);
				query.setParameter("destination", destinationCity);
				List<Long> results = getLongList(query.getResultList());
				results.forEach((value)->{System.out.println(value);});
				query = session.createNativeQuery(FILTER_AVAILABLE_BUS);
				query.setParameter("travelDate", travelDate);
				query.setParameter("busIds", results);
				List<Long> cancelledTravelledDateBuses =getLongList( query.getResultList());
				cancelledTravelledDateBuses.forEach((value)->{System.out.println(value);});
				query = session.createNativeQuery(FILTER_AVAILABLE_BUS);
				if (returnDate != null) {
					query.setParameter("travelDate", returnDate);
					query.setParameter("busIds", results);
					List<Long> cancelledreturnDateBuses = getLongList(query.getResultList());
					cancelledreturnDateBuses.forEach((value)->{System.out.println(value);});
					List<Long> list = new ArrayList<Long>(results.size());
					list.addAll(results);
					list.removeAll(cancelledreturnDateBuses);
					Iterable<Bus> returningDateBuses = busRepo.findAllById(list);
					Buses returningBus = prepareBuses(returningDateBuses,sourceCity,destinationCity,returnDate);
					busResult.setDown(returningBus);
				}
				List<Long> list = new ArrayList<Long>(results.size());
				list.addAll(results);
				list.removeAll(cancelledTravelledDateBuses);
				Iterable<Bus> travellDateBuses = busRepo.findAllById(list);
				busResult.setUp(prepareBuses(travellDateBuses,sourceCity,destinationCity,travelDate));
				return busResult;
			}
		});
	}

	private Buses prepareBuses(Iterable<Bus> iterable, String from, String to, Date startDate) {
		Buses buses = new Buses();
		List<org.online.booking.bus.model.Bus> busList = new ArrayList<org.online.booking.bus.model.Bus>();
		Optional<Distance> dist = util.getDistanceTree().stream().filter((distance) -> {
			return distance.getFrom().equals(from) && distance.getTo().equals(to);
		}).findFirst();

		iterable.forEach((object) -> {
			org.online.booking.bus.model.Bus bus = new org.online.booking.bus.model.Bus();
			bus.setBusId(object.getId());
			bus.setBusNumber(object.getBusNumber());
			bus.setOperator(object.getOperator().getName());
			busList.add(bus);
			if (dist.isPresent()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(startDate);
				cal.add(Calendar.HOUR_OF_DAY, Long.valueOf((dist.get().km / object.getAverageSpeed())).intValue());
				bus.setDuration(Long.valueOf((dist.get().km / object.getAverageSpeed())));
				bus.setArrivalTime(cal.getTime());
				bus.setPrice(object.getFarePerKm()*(Long.valueOf((dist.get().km / object.getAverageSpeed()))));
			}
		});
		buses.setTotalResult(busList.size());
		buses.setBuses(busList);
		return buses;
	}
	
	private List<Long> getLongList(List<BigInteger> list){
		List<Long> longList=new ArrayList<Long>();
		list.forEach((value)->{
			longList.add(value.longValue());
		});
		return longList;
	}
	
}
