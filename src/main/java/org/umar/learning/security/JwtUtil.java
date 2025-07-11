package org.umar.learning.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

    @Component
    public class JWT_Utility {

        private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        private final long expirationMillis = 1000 * 60 * 60; // 1 hour

        public String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                    .signWith(key)
                    .compact();
        }

        public String extractUsername(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }

        public boolean validateToken(String token) {
            try {
                extractUsername(token);
                return true;
            } catch (JwtException e) {
                return false;
            }
        }
    }

