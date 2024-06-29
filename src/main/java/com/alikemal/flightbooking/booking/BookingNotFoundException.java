package com.alikemal.flightbooking.booking;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String format) {
        super(format);
    }
}
