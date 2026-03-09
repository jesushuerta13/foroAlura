package com.foroAlura.foroAlura.Controller.security;


import lombok.RequiredArgsConstructor;

import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class JwtService {
        private final JwtEncoder jwtEncoder;
        private final JwtDecoder jwtDecoder;

        private Long expirationMs;
        @Value("${app.jwt.expiration-ms}")
        public String generateToken(String email) {
            Instant now = Instant.now();
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .subject(email)
                    .issuedAt(now)
                    .expiresAt(now.plusMillis(expirationMs))
                    .claim("scope", "USER")
                    .build();
            JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();
            return jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
        }
            public String extractUsername(String token){
                Jwt jwt =jwtDecoder.decode(token);
                return jwt.getSubject();
            }
            public boolean isTokenValid(String token, String email) {
                Jwt jwt= jwtDecoder.decode(token);
                return jwt.getSubject().equals(email) &&
                        jwt.getExpiresAt()!=  null &&
                        jwt.getExpiresAt().isAfter(Instant.now());
            }

}