package com.alikemal.flightbooking.registration.token;

public interface TokenService {
    String validateToken(String token);
    void save(Token token, Long userId);
}
