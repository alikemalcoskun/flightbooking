package com.alikemal.flightbooking.booking.passenger;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Passenger {
    private String name;
    private String surname;
    private String phone;
}
