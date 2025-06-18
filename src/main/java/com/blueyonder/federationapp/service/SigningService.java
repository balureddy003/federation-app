package com.blueyonder.federationapp.service;

import com.blueyonder.federationapp.util.JwtUtil;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;

@Service
public class SigningService {
    private JwtUtil jwtUtil;

    @PostConstruct
    public void init() {
        this.jwtUtil = new JwtUtil();
    }

    public String buildSignedStatement(Map<String, Object> metadata, String issuer) {
        try {
            JWTClaimsSet claims = new JWTClaimsSet.Builder()
                    .issuer(issuer)
                    .subject(issuer)
                    .issueTime(java.util.Date.from(Instant.now()))
                    .expirationTime(java.util.Date.from(Instant.now().plusSeconds(3600)))
                    .claim("metadata", metadata)
                    .claim("authority_hints", Collections.singletonList(issuer))
                    .build();
            return jwtUtil.sign(claims);
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign entity statement", e);
        }
    }

    public boolean verify(String jwt) {
        return jwtUtil.verify(jwt);
    }
}
