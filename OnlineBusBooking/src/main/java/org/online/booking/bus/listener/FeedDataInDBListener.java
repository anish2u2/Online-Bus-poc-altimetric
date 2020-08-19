package org.online.booking.bus.listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.online.booking.bus.contracts.Service;
import org.online.booking.bus.entity.Bus;
import org.online.booking.bus.entity.BusDetails;
import org.online.booking.bus.entity.BusRoute;
import org.online.booking.bus.entity.BusRouteDetails;
import org.online.booking.bus.entity.BusType;
import org.online.booking.bus.entity.City;
import org.online.booking.bus.entity.Country;
import org.online.booking.bus.entity.Operator;
import org.online.booking.bus.entity.Routs;
import org.online.booking.bus.entity.State;
import org.online.booking.bus.repos.BusRepos;
import org.online.booking.bus.repos.BusRouteRepos;
import org.online.booking.bus.repos.BusTypesRepos;
import org.online.booking.bus.repos.CityRepos;
import org.online.booking.bus.repos.CountryRepos;
import org.online.booking.bus.repos.OperatorRepos;
import org.online.booking.bus.structure.Distance;
import org.online.booking.bus.structure.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FeedDataInDBListener {
	@Autowired
	private Service<Object> service;

	@Autowired
	private CityRepos cityRepos;

	@Autowired
	private CountryRepos countryRepo;

	@Autowired
	private OperatorRepos operatorRepo;

	@Autowired
	private BusTypesRepos repos;

	@Autowired
	private DistanceUtil distanceUtil;

	@Autowired
	private BusRepos busRpos;

	@Autowired
	private BusRouteRepos busRouteRepos;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Value("${bus.booking.karnataka.cities}")
	private String citiesDetailsFileLoc;

	@Value("${bus.operators}")
	private String busOperators;

	@Value("${bus.buses}")
	private String buses;

	@Value("${bus.routs}")
	private String routs;

	@Value("${bus.types}")
	private String busTypes;

	@Value("${bus.bus_route}")
	private String busRouts;

	@Value("${bus.distance}")
	private String distance;

	@EventListener(classes = ContextRefreshedEvent.class)
	public void initializeData() {
		logger.info("Initializing...");
		prepareCountry();
		initOperators();
		initBusTypes();
		initRouts();
		initBus();
		initBusRouts();
		initDistance();
		logger.info("Initialization done...");
	}
	
	@Transactional
	private void prepareCountry() {
		Country country = countryRepo.findByName("India");
		if (country == null) {
			country = new Country();
			country.setCountryName("India");
			service.save(country);
			prepareStates(country);
		}
	}
	
	@Transactional
	private void prepareStates(Country country) {
		State state = new State();
		state.setName("Karnataka");
		state.setCountry(country);
		service.save(state);
		prepareCities(state);
	}
	
	@Transactional
	private void prepareCities(State state) {
		List<City> cities = new ArrayList<>();
		for (String value : citiesDetailsFileLoc.split(",")) {
			Resource resource = new ClassPathResource(value);
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					City city = new City();
					city.setCityName(line);
					cities.add(city);
					city.setState(state);
					service.save(city);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				resource = null;
			}
		}
	}
	
	@Transactional
	private void initRouts() {
		Resource resource = new ClassPathResource(routs);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(" ");
				Routs routs = new Routs();
				routs.setStartCity(cityRepos.findByName(values[0]));
				routs.setDestinationCity(cityRepos.findByName(values[1]));
				routs.setRouteStops(cityRepos.findCityIdByNames(Arrays.asList(values[2].split(","))));
				service.save(routs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource = null;
		}
	}
	
	@Transactional
	private void initOperators() {
		Resource resource = new ClassPathResource(busOperators);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				Operator operator = new Operator();
				operator.setName(line);
				service.save(operator);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource = null;
		}
	}
	
	@Transactional
	private void initBus() {
		Resource resource = new ClassPathResource(buses);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(" ");
				if (busRpos.findByName(values[0]) == null) {
					Bus bus = new Bus();
					bus.setBusNumber(values[0]);
					bus.setFarePerKm(Long.valueOf(values[1]));
					bus.setAverageSpeed(Long.valueOf(values[5]));
					bus.setOperator(operatorRepo.findByName(values[2].replace("-", " ")));
					BusDetails details = new BusDetails();
					details.setBusCapacity(Long.valueOf(values[3]));
					details.setType(repos.findByName(values[4]));
					bus.setBusDetails(details);
					service.save(bus);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource = null;
		}
	}
	
	@Transactional
	private void initBusTypes() {
		Resource resource = new ClassPathResource(busTypes);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (repos.findByName(line) == null) {
					BusType type = new BusType();
					type.setDescription(line);
					service.save(type);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource = null;
		}
	}
	@Transactional
	private void initBusRouts() {
		Resource resource = new ClassPathResource(busRouts);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(" ");
				Bus bus = busRpos.findByName(values[0]);
				Optional<Routs> route = busRouteRepos.findById(Long.valueOf(values[1]));
				BusRoute busRout = new BusRoute();
				busRout.setBusId(bus);
				BusRouteDetails details = new BusRouteDetails();
				details.setRoute(route.get());
				busRout.setRoutDetails(details);
				service.save(busRout);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource = null;
		}
	}
	@Transactional
	private void initDistance() {
		Resource resource = new ClassPathResource(distance);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			Set<Distance> set = new HashSet<Distance>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] value = line.split(" ");
				String[] cities = value[0].split("-");
				
				Distance distance = new Distance();
				distance.setFrom(cities[0]);
				distance.setTo(cities[1]);
				distance.setKm(Long.valueOf(value[1]));
				Set<Distance> child = new HashSet<Distance>();
				for(Distance d:set) {
					if(d.getFrom().equals(distance.getFrom())) {
						Distance diste = new Distance();
						diste.setFrom(d.getTo());
						diste.setTo(distance.getTo());
						Long dis=d.getKm()>distance.getKm()?(distance.getKm()-d.getKm()):(d.getKm()-distance.getKm());
						diste.setKm(dis);
						child.add(diste);
					}
				}
				set.addAll(child);
				set.add(distance);
			}
			distanceUtil.setDistanceTree(set);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource = null;
		}
	}

}
