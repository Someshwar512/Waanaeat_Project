package com.example.demo.Repositroy;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

	Optional<User> findById(Long userId);
	
}
