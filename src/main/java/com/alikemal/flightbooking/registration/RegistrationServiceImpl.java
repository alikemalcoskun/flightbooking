package com.alikemal.flightbooking.registration;

import com.alikemal.flightbooking.registration.email.EmailService;
import com.alikemal.flightbooking.registration.token.Token;
import com.alikemal.flightbooking.registration.token.TokenRepository;
import com.alikemal.flightbooking.user.User;
import com.alikemal.flightbooking.user.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
    private final TokenRepository tokenRepository;
    private final UserService userService;
    private final EmailService emailService;

    @Override
    public String register(RegUser regUser) {

        User user = userService.save(regUser);
        String token = UUID.randomUUID().toString();

        Token tokenObj = new Token(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);
        tokenRepository.save(tokenObj);

        emailService.send(user.getEmail(), "Confirm your email: " + token);

        return "Email sent to: " + user.getEmail() + " Please confirm your email address";
    }

    @Override
    public String validate(String inputToken) {
        Token token = tokenRepository.findByToken(inputToken)
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        LocalDateTime expiredAt = token.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token expired");
        }

        userService.enableUser(token.getUser().getUsername());
        return "Token validated";
    }
}
