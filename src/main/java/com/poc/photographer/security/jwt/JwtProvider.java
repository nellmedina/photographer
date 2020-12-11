package com.poc.photographer.security.jwt;

import com.poc.photographer.model.UserEntity;
import com.poc.photographer.repository.UserRepository;
import com.poc.photographer.security.services.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Autowired
    private UserRepository userRepository;

    @Value("${api.security.jwtSecret}")
    private String jwtSecret;

    @Value("${api.security.jwtExpiration}")
    private int jwtExpiration;


    public String generateJwtToken(Authentication authentication) {

        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        final Map<String, Object> roles = new HashMap<>();
        roles.put("roles", userPrincipal.getAuthorities());

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .claim("roles", userPrincipal.getAuthorities())
                .claim("username", userPrincipal.getUsername())
                .claim("userId", userPrincipal.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration * 1000L))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public UserEntity getUserFromJwtToken(String token) {
        Long userId = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .get("userId",Long.class);
        return userRepository.findById(userId).orElse(null);
    }

    public Long getUserIdFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .get("userId",Long.class);
    }

    public String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ","");
        }

        return null;
    }

    public String getJwt(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ","");
        }
        return null;
    }
}