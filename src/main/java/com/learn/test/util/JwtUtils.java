package com.learn.test.util;

import com.learn.test.model.users.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static String secret;
    private static long expiryDuration = 60 * 60;

    public String generateJwt(Users users) {

        long milliTIme = System.currentTimeMillis();
        long expiryTime = milliTIme + expiryDuration * 1000;

        Date issueAt = new Date();
        Date expiryAt = new Date(expiryTime);

        Claims claims = Jwts.claims()
                .setIssuer(String.valueOf(users.getUserId()))
                .setIssuedAt(issueAt)
                .setExpiration(expiryAt);


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
