package com.alikemal.flightbooking.airport;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {
    @Autowired
    private final AirportRepository airportRepository;

    @Override
    public Airport getAirportByCode(String code) {
        return airportRepository.findByCode(code).orElseThrow(() -> new AirportNotFoundException("Airport not found with code: " + code));
    }

    @Override
    public List<Airport> getAirportsByCity(String city) {
        return airportRepository.findByCity(city).orElseThrow(() -> new AirportNotFoundException("Airport not found with city: " + city));
    }

    @Override
    public List<Airport> getAirportsByCountry(String country) {
        return airportRepository.findByCountry(country).orElseThrow(() -> new AirportNotFoundException("Airport not found with country: " + country));
    }


    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public void deleteAirportByCode(String code) {
        airportRepository.deleteByCode(code);
    }

    @Override
    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }
}
