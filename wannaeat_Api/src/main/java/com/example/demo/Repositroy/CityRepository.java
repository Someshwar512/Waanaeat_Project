// CityRepository.java
package com.example.demo.Repositroy;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}