package it.objectmethod.worlddb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.worlddb.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	public Country findByName(String name);

//	@Query(value = "SELECT x FROM Country x WHERE ('' LIKE ?1 OR x.continent LIKE ?1) AND ('' LIKE ?2 OR x.name LIKE ?2)")
//	public List<Country> findCountriesByNameAndContinent(String continent, String name);

	@Query(value = "SELECT DISTINCT x.continent FROM Country x")
	public List<String> showContinents();

	@Query(value = "SELECT x FROM Country x WHERE (x.continent LIKE ?1 OR '' LIKE ?1)")
	public List<Country> findCountriesByContinent(String continent);

	@Query(value = "SELECT x FROM Country x WHERE (x.name LIKE ?1 OR '' LIKE ?1)")
	public List<Country> findCountriesByName(String name);
}
