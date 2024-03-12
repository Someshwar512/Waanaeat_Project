package com.example.demo.Repositroy;

// ZipcodeRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Zipcode;

public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {

	Object findByZipcode(String zipcode);
}
