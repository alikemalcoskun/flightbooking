package com.alikemal.flightbooking.booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    List<Booking> getBookingsByUserIdAndFlightNumber(Long userId, Long flightNumber);
    void addBooking(Booking booking);
    void deleteBookingById(Long id);
}
