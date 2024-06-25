package com.alikemal.flightbooking.flight;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class FlightSearchRequest {
    private String departure;
    private String destination;
    private LocalDate date;
    private FlightStatus status = FlightStatus.ACTIVE;
}
