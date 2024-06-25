package com.alikemal.flightbooking.flight;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(Long flightNumber);
    @Transactional
    void deleteByFlightNumber(Long flightNumber);
    @Transactional
    @Query("UPDATE Flight f SET f.status = ?2 WHERE f.flightNumber = ?1")
    void setStatus(Long flightNumber, FlightStatus status);

    @Query("SELECT f FROM Flight f WHERE f.departure.code = ?1 AND f.destination.code = ?2 AND f.status = ?3 AND DATE(f.departureTime) = DATE(?4)")
    Optional<List<Flight>> findByDepartureAndDestinationAndStatusAndDate(String departure, String destination, FlightStatus status, LocalDate date);


}
