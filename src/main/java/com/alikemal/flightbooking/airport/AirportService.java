package com.alikemal.flightbooking.airport;

import java.util.List;

public interface AirportService {

    Airport getAirportByCode(String code);
    List<Airport> getAirportsByCity(String city);
    List<Airport> getAirportsByCountry(String country);
    List<Airport> findAll();

    void deleteAirportByCode(String code);
    void addAirport(Airport airport);

}
