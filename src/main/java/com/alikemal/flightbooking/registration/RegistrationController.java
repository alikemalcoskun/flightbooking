package com.alikemal.flightbooking.registration;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/register", headers = "Content-Type=application/json")
    public String register(@RequestBody RegUser user) {
        return registrationService.register(user);
    }

    @PostMapping("/validate/{token}")
    public String validate(@PathParam("token") String token) {
        return registrationService.validate(token);
    }
}
