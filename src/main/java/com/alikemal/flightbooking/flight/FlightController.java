package com.alikemal.flightbooking.flight;

import com.alikemal.flightbooking.aircraft.Aircraft;
import com.alikemal.flightbooking.aircraft.AircraftService;
import com.alikemal.flightbooking.airport.Airport;
import com.alikemal.flightbooking.airport.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/flights")
@AllArgsConstructor
public class FlightController {
    private final FlightService flightService;
    private final AirportService airportService;
    private final AircraftService aircraftService;

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
        // Check if flight exists
        Flight flight = flightService.getFlightByFlightNumber(flightNumber);

        if (flight == null) {
            throw new IllegalArgumentException("Flight not found with flight number: " + flightNumber);
        }

        flightService.deleteFlightByFlightNumber(flightNumber);
    }

    @PostMapping
    public void addFlight(@RequestBody FlightPostRequest flightPost) {
        // Get departure and destination airports
        Airport departure = airportService.getAirportByCode(flightPost.getDeparture());
        Airport destination = airportService.getAirportByCode(flightPost.getDestination());

        // Get Aircraft
        Aircraft aircraft = aircraftService.getAircraftByCode(flightPost.getAircraft());

        // Create a new flight
        Flight flight = new Flight();
        flight.setDeparture(departure);
        flight.setDestination(destination);
        flight.setDepartureTime(flightPost.getDepartureTime());
        flight.setArrivalTime(flightPost.getArrivalTime());
        flight.setPrice(flightPost.getPrice());
        flight.setAvailableTickets(flightPost.getAvailableTickets());
        flight.setAircraft(aircraft);
        flight.setStatus(flightPost.getStatus());

        // Check if flight contains null attribute
        if (flight.getDepartureTime() == null || flight.getArrivalTime() == null || flight.getPrice() == null || flight.getAvailableTickets() == null) {
            throw new IllegalArgumentException("Flight cannot contain null attributes");
        }

        flightService.addFlight(flight);
    }

    @GetMapping("/search")
    public Optional<List<Flight>> getFlightsByDepartureAndDestinationAndStatusAndDate(@RequestBody FlightSearchRequest request) {
        return flightService.getFlightsByDepartureAndDestinationAndStatusAndDate(request.getDeparture(), request.getDestination(), request.getStatus(), request.getDate());
    }
}
