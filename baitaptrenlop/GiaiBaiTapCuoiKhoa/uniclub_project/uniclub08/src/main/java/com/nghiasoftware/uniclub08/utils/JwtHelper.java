package com.nghiasoftware.uniclub08.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtHelper {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        return Jwts.builder().subject(data).signWith(key).compact();
    }

    // Giải mã token
    public String decodeToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        String data = null;
        try {
            data = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
        } catch (ExpiredJwtException e) {
            System.out.println("Expired JWT token");
        } catch (JwtException e) {
            System.out.println("Decode JWT token");
        }
        return data;
    }
}
