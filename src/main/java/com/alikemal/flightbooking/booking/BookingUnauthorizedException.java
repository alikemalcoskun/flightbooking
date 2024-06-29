package com.alikemal.flightbooking.booking;

public class BookingUnauthorizedException extends RuntimeException {
    public BookingUnauthorizedException(String format) {
        super(format);
    }
}
