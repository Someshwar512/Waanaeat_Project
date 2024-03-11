package com.example.demo.Util;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Functions {

	public static String generateJwtToken(int userId) {
        String secretKey = "your_secret_key"; 
        int expirationDays = 1; //1 day expire token

        return Jwts.builder()
                .claim("user_id", userId)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setExpiration(Date.from(Instant.now().plus(expirationDays, ChronoUnit.DAYS)))
                .compact();
    }
}
