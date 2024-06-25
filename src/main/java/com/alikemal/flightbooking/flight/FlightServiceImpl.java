package com.alikemal.flightbooking.flight;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flight getFlightByFlightNumber(Long flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber).orElseThrow(() -> new FlightNotFoundException("Flight not found with flight number: " + flightNumber));
    }

    @Override
    public void deleteFlightByFlightNumber(Long flightNumber) {
        flightRepository.deleteByFlightNumber(flightNumber);
    }

    @Override
    public void setStatus(Long flightNumber, FlightStatus status) {
        flightRepository.setStatus(flightNumber, status);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<List<Flight>> getFlightsByDepartureAndDestinationAndStatusAndDate(String departure, String destination, FlightStatus status, LocalDate date) {
        return flightRepository.findByDepartureAndDestinationAndStatusAndDate(departure, destination, status, date);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }


}
