package com.alikemal.flightbooking.booking;

import com.alikemal.flightbooking.booking.passenger.Passenger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class BookingRequest {
    private Long id;
    private Long userId;
    private Long flightNumber;
    private List<Passenger> passengers;
}
