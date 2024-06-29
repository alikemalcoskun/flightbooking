package com.alikemal.flightbooking.booking;

import com.alikemal.flightbooking.booking.passenger.Passenger;
import com.alikemal.flightbooking.flight.Flight;
import com.alikemal.flightbooking.flight.FlightRepository;
import com.alikemal.flightbooking.flight.FlightService;
import com.alikemal.flightbooking.user.User;
import com.alikemal.flightbooking.user.UserRepository;
import com.alikemal.flightbooking.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.util.List;

@RestController
@RequestMapping("api/v1/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;
    private final FlightService flightService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/{userId}/{flightNumber}")
    public List<Booking> getBookingsByUserIdAndFlightNumber(@PathVariable Long userId, @PathVariable Long flightNumber) {
        // Get User
        User user = userService.getUserById(userId);

        // Check if user is not admin and user is not authorized to view this booking

        return bookingService.getBookingsByUserIdAndFlightNumber(userId, flightNumber);
    }

    @DeleteMapping("/{id}")
    public void deleteBookingById(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
    }

    @PostMapping
    public void addBooking(@RequestBody BookingRequest bookingRequest) {
        // Get user
        User user = userService.getUserById(bookingRequest.getUserId());

        // Get flight
        Flight flight = flightService.getFlightByFlightNumber(bookingRequest.getFlightNumber());

        // Create a new booking for all passengers
        List<Passenger> passengers = bookingRequest.getPassengers();
        for (Passenger passenger : passengers) {
            Booking booking = new Booking();
            booking.setUser(user);
            booking.setFlight(flight);
            booking.setName(passenger.getName());
            booking.setSurname(passenger.getSurname());
            booking.setPhone(passenger.getPhone());

            bookingService.addBooking(booking);
        }
    }
}
