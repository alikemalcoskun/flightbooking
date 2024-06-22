package com.alikemal.flightbooking.airport;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "airports")
public class Airport {

    @Id
    private String code;
    private String name;
    private String city;
    private String country;
    private String timezone;
    private Double lat;
    private Double lon;
}
