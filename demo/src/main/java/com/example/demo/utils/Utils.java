package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.appuser.AppUserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class Utils {
    private final static Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
    public static DecodedJWT decodeJWT (String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer ".length());
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

    public static String getAccessToken (String username, String issuer) {
        return JWT.create().withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() +10 * 60 * 1000))
                .withIssuer(issuer)
                .withClaim("roles", List.of(AppUserRole.USER.name()))
                .sign(algorithm);
    }

    public static String getRefreshToken (String username, String issuer) {
        return JWT.create().withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public static void forbiddenException(String errorMessage, HttpServletResponse response ) throws IOException {
        log.error("Error logging in {}", errorMessage);
        response.setStatus(FORBIDDEN.value());
        Map<String, String> error = new HashMap<>();
        error.put("error_message", errorMessage);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), error);
    }
}
