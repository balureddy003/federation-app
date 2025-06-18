package com.blueyonder.federationapp.service;

import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.Map;

@Service
public class DynamicIdpService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${federation.trust-anchor}")
    private String trustAnchor;

    @Cacheable("idpMetadata")
    public Map<String, Object> fetchMetadata(String wellKnownUrl) {
        try {
            ResponseEntity<String> resp = restTemplate.getForEntity(wellKnownUrl, String.class);
            SignedJWT jwt = SignedJWT.parse(resp.getBody());
            // In a real implementation verify trust chain to trustAnchor
            return jwt.getJWTClaimsSet().getJSONObjectClaim("metadata");
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch metadata", e);
        }
    }
}
