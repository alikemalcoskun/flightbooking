package com.alikemal.flightbooking.aircraft;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    @Autowired
    private final AircraftRepository aircraftRepository;

    @Override
    public Aircraft getAircraftByCode(String code) {
        return aircraftRepository.findByCode(code).orElseThrow(() -> new AircraftNotFoundException("Aircraft not found with code: " + code));
    }

    @Override
    public List<Aircraft> getAircraftByManufacturer(String manufacturer) {
        return aircraftRepository.findByManufacturer(manufacturer).orElseThrow(() -> new AircraftNotFoundException("Aircraft not found with manufacturer: " + manufacturer));
    }

    @Override
    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    @Override
    public void deleteAircraftByCode(String code) {
        aircraftRepository.deleteByCode(code);
    }

    @Override
    public void addAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }
}
