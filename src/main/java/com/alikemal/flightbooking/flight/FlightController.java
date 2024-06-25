package com.alikemal.flightbooking.flight;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{flightNumber}")
    public Flight getFlightByFlightNumber(@PathVariable Long flightNumber) {
        return flightService.getFlightByFlightNumber(flightNumber);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.findAll();
    }

    @DeleteMapping("/{flightNumber}")
    public void deleteFlightByFlightNumber(@PathVariable Long flightNumber) {
        flightService.deleteFlightByFlightNumber(flightNumber);
    }

    @PostMapping
    public void addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    @GetMapping("/search")
    public Optional<List<Flight>> getFlightsByDepartureAndDestinationAndStatusAndDate(@RequestBody FlightSearchRequest request) {
        return flightService.getFlightsByDepartureAndDestinationAndStatusAndDate(request.getDeparture(), request.getDestination(), request.getStatus(), request.getDate());
    }
}
