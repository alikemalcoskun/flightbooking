package com.alikemal.flightbooking.booking;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));

        // Check current user is the owner of the booking or admin
        // TODO

        return booking;
    }

    @Override
    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUserIdAndFlightNumber(Long userId, Long flightNumber) {
        return bookingRepository.findByUserIdAndFlightNumber(userId, flightNumber);
    }

}
