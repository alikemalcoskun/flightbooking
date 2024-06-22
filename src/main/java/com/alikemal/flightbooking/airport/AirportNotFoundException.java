package com.alikemal.flightbooking.airport;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String format) {
        super(format);
    }
}
