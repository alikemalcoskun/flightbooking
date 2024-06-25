package com.alikemal.flightbooking.flight;

import com.alikemal.flightbooking.aircraft.Aircraft;
import com.alikemal.flightbooking.airport.Airport;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "flights")
public class Flight {

    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Id
    private Long flightNumber;

    @ManyToOne
    @JoinColumn(name = "departure", referencedColumnName = "code", nullable = false)
    private Airport departure;

    @ManyToOne
    @JoinColumn(name = "destination", referencedColumnName = "code", nullable = false)
    private Airport destination;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableTickets;

    @ManyToOne
    @JoinColumn(name = "aircraft_code", referencedColumnName = "code", nullable = false)
    private Aircraft aircraft;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FlightStatus status = FlightStatus.ACTIVE;
}
