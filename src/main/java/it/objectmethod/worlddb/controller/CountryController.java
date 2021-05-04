package it.objectmethod.worlddb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worlddb.domain.Country;
import it.objectmethod.worlddb.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping("/countryByName")
	public Country findCountryByName(@RequestParam("countryName") String countryName) {
		Country country = countryService.findCountryByName(countryName);
		return country;
	}

	@RequestMapping("/find-country")
	public List<Country> findCountriesByNameAndContinent(@RequestParam("continent") String continent,
			@RequestParam("countryName") String countryName) {
		if (continent.isBlank() || continent.isEmpty()) {
			continent = "";
		}
		if (countryName.isBlank() || countryName.isEmpty()) {
			countryName = "";
		}
		List<Country> countriesByContinent = countryService.findCountriesByContinent(continent);
		List<Country> countriesByName = countryService.findCountriesByName(countryName);
		countriesByContinent.retainAll(countriesByName);

		return countriesByContinent;
	}

	@RequestMapping("/continents")
	public List<String> showContinents() {
		List<String> continents = countryService.showContinents();
		return continents;
	}

	@RequestMapping("/{continent}/countries")
	public List<Country> countriesByContinent(@PathVariable("continent") String continent) {
		List<Country> countryList = countryService.findCountriesByContinent(continent);
		return countryList;
	}
}
