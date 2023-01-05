package com.learn.test.util;

import com.learn.test.model.users.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtils {

    private static String secret = "This_is_secret";
    private static long expiryDuration = 60 * 60;

    public static String generateJwt(Users users) {

        long milliTIme = System.currentTimeMillis();
        long expiryTime = milliTIme + expiryDuration * 1000;

        Date issueAt = new Date();
        Date expiryAt = new Date(expiryTime);
        String encodedString = Base64.getEncoder().encodeToString(secret.getBytes());


        Claims claims = Jwts.claims()
                .setIssuer(String.valueOf(users.getUserId()))
                .setIssuedAt(issueAt)
                .setExpiration(expiryAt);


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, encodedString)
                .compact();
    }
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, encodedString ).compact();
//    }
}
