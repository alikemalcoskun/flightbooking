package com.alikemal.flightbooking.aircraft;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {
    Optional<Aircraft> findByCode(String code);
    Optional<List<Aircraft>> findByManufacturer(String manufacturer);

    @Transactional
    void deleteByCode(String code);

}
