package com.alikemal.flightbooking.flight;

import com.alikemal.flightbooking.airport.Airport;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    void deleteFlightByFlightNumber(Long flightNumber);

    void setStatus(Long flightNumber, FlightStatus status);
    Flight getFlightByFlightNumber(Long flightNumber);
    List<Flight> getAllFlights();
    Optional<List<Flight>> getFlightsByDepartureAndDestinationAndStatusAndDate(String departure, String destination, FlightStatus status, LocalDate date);
    List<Flight> findAll();
    void addFlight(Flight flight);
}
