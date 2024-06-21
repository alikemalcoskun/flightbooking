package com.alikemal.flightbooking.registration;

public interface RegistrationService {
    String register(RegUser user);
    String validate(String token);
}
