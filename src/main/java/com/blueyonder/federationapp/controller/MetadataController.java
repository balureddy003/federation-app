package com.blueyonder.federationapp.controller;

import com.blueyonder.federationapp.service.SigningService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MetadataController {

    private final SigningService signingService;

    @Value("${federation.issuer}")
    private String issuer;

    public MetadataController(SigningService signingService) {
        this.signingService = signingService;
    }

    @GetMapping(value = "/.well-known/openid-federation", produces = MediaType.APPLICATION_JSON_VALUE)
    public String metadata() {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("issuer", issuer);
        metadata.put("jwks_uri", issuer + "/jwks");
        return signingService.buildSignedStatement(metadata, issuer);
    }
}
