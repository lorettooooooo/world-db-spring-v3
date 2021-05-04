package it.objectmethod.worlddb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worlddb.domain.City;
import it.objectmethod.worlddb.service.CityService;

@RestController
@RequestMapping("/api/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@RequestMapping("/{cityName}/find-by-name")
	public City findMilano(@PathVariable("cityName") String cityName) {
		City city = cityService.findByName(cityName);
		return city;
	}

	@RequestMapping("/{countryCode}/cities")
	public List<City> findCitiesByCC(@PathVariable("countryCode") String countryCode) {
		List<City> cities = cityService.findByCountryCode(countryCode);
		return cities;
	}

}
