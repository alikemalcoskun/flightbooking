package com.alikemal.flightbooking.aircraft;

import java.util.List;

public interface AircraftService {

    Aircraft getAircraftByCode(String code);
    List<Aircraft> getAircraftByManufacturer(String manufacturer);
    List<Aircraft> findAll();

    void deleteAircraftByCode(String code);
    void addAircraft(Aircraft aircraft);

}
