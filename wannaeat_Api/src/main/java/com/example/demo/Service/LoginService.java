// LoginService.java
package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Auth_Token;
import com.example.demo.Model.User;
import com.example.demo.Repositroy.AuthTokenRepository;
import com.example.demo.Repositroy.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
    @Autowired
    private AuthTokenRepository authTokenRepository;

    public Auth_Token login(String email, String password, Enum role) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password) && user.getRole().equals(role)) {
            String accessToken = generateAccessToken(user.getId());

            Auth_Token authToken = new Auth_Token();
            authToken.setAccessToken(accessToken);
            authToken.setUser(user);
            
            return authTokenRepository.save(authToken);
        }

        return null;
    }

//	private String generateAccessToken(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public static String generateAccessToken(int userId) {
        String secretKey = "your_secret_key"; 
        int expirationDays = 1; //1 day expire token

        return Jwts.builder()
                .claim("user_id", userId)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setExpiration(Date.from(Instant.now().plus(expirationDays, ChronoUnit.DAYS)))
                .compact();
    }

   
}
