package com.ssafit.ccachi.global.token;

import com.ssafit.ccachi.user.model.Entity.User;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtTokenUtils {



    public static String generateToken(UserResponseDto user, String key, long expiredTimeMs){
        Claims claims = Jwts.claims();
        claims.put("user", user);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTimeMs))
                .signWith(getKey(key), SignatureAlgorithm.HS256)
                .compact();
    }

    private static Key getKey(String key){
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static Claims parseJwtToken(String token , String key) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey(key))
                .build()
                .parseClaimsJws(token)
                .getBody();
        System.out.println("claims = " + claims.toString());

        return claims;
    }
}