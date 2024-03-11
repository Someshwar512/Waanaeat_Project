package com.example.demo.Repositroy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Auth_Token;
import com.example.demo.Model.User;

public interface AuthTokenRepository extends JpaRepository<Auth_Token, Long> {


}
