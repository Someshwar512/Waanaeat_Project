
// CountryRepository.java
package com.example.demo.Repositroy;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Country;
public interface CountryRepository extends JpaRepository<Country, Long> {

	Country findByName(String name);
}