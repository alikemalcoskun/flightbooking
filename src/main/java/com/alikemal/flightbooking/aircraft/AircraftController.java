package com.alikemal.flightbooking.aircraft;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aircraft")
public class AircraftController {
    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/{code}")
    public Aircraft getAircraftByCode(@PathVariable String code) {
        return aircraftService.getAircraftByCode(code);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    public List<Aircraft> getAircraftByManufacturer(@PathVariable String manufacturer) {
        return aircraftService.getAircraftByManufacturer(manufacturer);
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.findAll();
    }

    @DeleteMapping("/{code}")
    public void deleteAircraftByCode(@PathVariable String code) {
        aircraftService.deleteAircraftByCode(code);
    }

    @PostMapping
    public void addAircraft(@RequestBody Aircraft aircraft) {
        aircraftService.addAircraft(aircraft);
    }

}
