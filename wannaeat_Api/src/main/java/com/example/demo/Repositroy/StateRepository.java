// StateRepository.java
package com.example.demo.Repositroy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.State;

public interface StateRepository extends JpaRepository<State, Long> {

	State findByName(String name);
}