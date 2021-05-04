package it.objectmethod.worlddb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.worlddb.domain.City;
import it.objectmethod.worlddb.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepo;

	public List<City> findCityByCountryCode(String countryCode) {
		List<City> cityList = null;
		cityList = cityRepo.findByCountryCode(countryCode);
		return cityList;
	}

	public City findByName(String name) {
		City city = null;
		city = cityRepo.findByName(name);
		return city;
	}

	public List<City> findByCountryCode(String codN) {
		List<City> cityList = null;
		cityList = cityRepo.findByCountryCode(codN);
		return cityList;
	}

}
