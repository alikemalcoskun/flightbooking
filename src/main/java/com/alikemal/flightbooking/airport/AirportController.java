package com.alikemal.flightbooking.airport;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/airports")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{code}")
    public Airport getAirportByCode(@PathVariable String code) {
        return airportService.getAirportByCode(code);
    }

    @GetMapping("/city/{city}")
    public List<Airport> getAirportsByCity(@PathVariable String city) {
        return airportService.getAirportsByCity(city);
    }

    @GetMapping("/country/{country}")
    public List<Airport> getAirportsByCountry(@PathVariable String country) {
        return airportService.getAirportsByCountry(country);
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.findAll();
    }

    @DeleteMapping("/{code}")
    public void deleteAirportByCode(@PathVariable String code) {
        airportService.deleteAirportByCode(code);
    }

    @PostMapping
    public void addAirport(@RequestBody Airport airport) {
        airportService.addAirport(airport);
    }

}
