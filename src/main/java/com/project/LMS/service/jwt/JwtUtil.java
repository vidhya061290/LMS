package com.project.LMS.service.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtil {

    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512); 
    private final long expirationTimeMs = 86400000; // 24 hours

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTimeMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey) 
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
     
    private Date getExpiration(String token) {
    	 Claims claims = Jwts.parserBuilder()
                 .setSigningKey(secretKey)
                 .build()
                 .parseClaimsJws(token)
                 .getBody();
    	 return claims.getExpiration();
    	 
    }
    private Boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }
    
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = getUsernameFromToken(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // ... (Add validation logic here) ...
}
