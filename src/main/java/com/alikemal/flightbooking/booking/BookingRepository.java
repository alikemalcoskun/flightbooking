package com.alikemal.flightbooking.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.user.id = ?1 AND b.flight.flightNumber = ?2")
    List<Booking> findByUserIdAndFlightNumber(Long userId, Long flightNumber);
}
