package com.alikemal.flightbooking.aircraft;

public class AircraftNotFoundException extends RuntimeException {
    public AircraftNotFoundException(String format) {
        super(format);
    }
}
