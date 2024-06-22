package com.alikemal.flightbooking.airport;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    Optional<Airport> findByCode(String code);
    Optional<List<Airport>> findByCity(String city);
    Optional<List<Airport>> findByCountry(String country);

    @Transactional
    void deleteByCode(String code);

}
