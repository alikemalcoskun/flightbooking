package com.alikemal.flightbooking.registration.token;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;

    @Override
    public String validateToken(String token) {
        Token token1 = tokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        return token1.getToken();
    }

    @Override
    public void save(Token token, Long userId) {
        tokenRepository.save(token);
    }
}
