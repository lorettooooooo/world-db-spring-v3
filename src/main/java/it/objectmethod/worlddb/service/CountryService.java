package it.objectmethod.worlddb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.worlddb.domain.Country;
import it.objectmethod.worlddb.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepo;

	public List<Country> findCountriesByContinent(String continent) {
		List<Country> countryList = null;
		countryList = countryRepo.findCountriesByContinent("%" + continent + "%");
		return countryList;
	}

	public List<Country> findCountriesByName(String name) {
		List<Country> countryList = null;
		countryList = countryRepo.findCountriesByName("%" + name + "%");
		return countryList;
	}

	public List<String> showContinents() {
		List<String> continents = countryRepo.showContinents();
		return continents;
	}

//	public List<Country> findCountriesByName(String name) {
//		List<Country> countryList = null;
//		System.out.println(name);
//		countryList = countryRepo.findCountriesByName("%" + name + "%");
//		return countryList;
//	}
}
