package com.serviceplazoleta.infrastructure.configurationfeign;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityFeingRequest implements HandlerInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private final static String ACCESS_TOKEN_SECRET="4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);

            // Decode JWT and extract userId
            try {
                Claims claimsJws = Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()).build().parseClaimsJws(jwtToken).getBody();
                String userId = claimsJws.get("id").toString();

                request.setAttribute("userId", userId);
            } catch (Exception e) {
                throw new Exception();
            }
        }

        return true;
    }
}
