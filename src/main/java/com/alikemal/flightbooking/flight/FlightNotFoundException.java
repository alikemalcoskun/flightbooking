package com.alikemal.flightbooking.flight;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String format) {
        super(format);
    }
}
