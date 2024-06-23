package com.alikemal.flightbooking.aircraft;

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
@Table(name = "aircraft")
public class Aircraft {
    @Id
    private String code;
    private String model;
    private String manufacturer;
    private Integer capacity;
}
