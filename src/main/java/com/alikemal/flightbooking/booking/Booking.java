package com.alikemal.flightbooking.booking;

import com.alikemal.flightbooking.flight.Flight;
import com.alikemal.flightbooking.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "bookings")
public class Booking {

    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_number", referencedColumnName = "flightNumber", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    private String name;
    private String surname;
    private String phone;

}
