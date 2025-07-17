package org.umar.learning.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.Jwts.parserBuilder;

@Component
    public class JwtUtil {

        private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        public String generateToken(String email) {
            return Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) //1 day
                    .signWith(key)
                    .compact();
        }

        public boolean validateToken(String token) {
            try {
                Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
                return true;
            } catch (JwtException e) {
                return false;
            }
            }

        public String extractUsername(String token) {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
        }


    }

