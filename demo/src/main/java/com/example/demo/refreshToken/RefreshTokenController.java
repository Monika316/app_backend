package com.example.demo.refreshToken;

import com.example.demo.appuser.AppUserRole;
import com.example.demo.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.utils.Utils.forbiddenException;

@RestController
@RequestMapping(path = "refresh/token")
@AllArgsConstructor
public class RefreshTokenController {


    @GetMapping
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                var decodedJWT= Utils.decodeJWT(authorizationHeader);
                String username = decodedJWT.getSubject();
                var accessToken = Utils.getAccessToken(username, request.getRequestURL().toString());
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", accessToken);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            } catch (Exception exception) {
                forbiddenException(exception.getMessage(), response);
            }
        }
        else {
            forbiddenException("Authorization failed", response);
        }
    }
}
