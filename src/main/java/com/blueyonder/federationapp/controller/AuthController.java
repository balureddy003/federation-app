package com.blueyonder.federationapp.controller;

import com.blueyonder.federationapp.service.DynamicIdpService;
import com.blueyonder.federationapp.service.SigningService;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final DynamicIdpService dynamicIdpService;
    private final SigningService signingService;

    public AuthController(DynamicIdpService dynamicIdpService, SigningService signingService) {
        this.dynamicIdpService = dynamicIdpService;
        this.signingService = signingService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String idp) {
        // In a real implementation redirect to IDP authorization endpoint
        return ResponseEntity.ok("Redirecting to " + idp);
    }

    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam String idToken) throws Exception {
        SignedJWT jwt = SignedJWT.parse(idToken);
        // TODO: resolve trust chain and validate
        boolean valid = signingService.verify(idToken);
        return ResponseEntity.ok("Token valid: " + valid);
    }
}
