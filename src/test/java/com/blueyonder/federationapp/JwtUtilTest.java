package com.blueyonder.federationapp;

import com.blueyonder.federationapp.service.SigningService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Map;

public class JwtUtilTest {

    @Test
    void testSignAndVerify() {
        SigningService signingService = new SigningService();
        signingService.init();
        String jwt = signingService.buildSignedStatement(Collections.singletonMap("foo", "bar"), "issuer");
        assertTrue(signingService.verify(jwt));
    }
}
