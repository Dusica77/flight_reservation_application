package com.booking.flight.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("DOMESTIC")
public class DomesticFlight extends Flight {
    private String state;

    public DomesticFlight() {
        super();
    }

    public DomesticFlight(Long id, String flightNumber, String origin, String destination,
                          LocalDateTime departureTime, LocalDateTime arrivalTime,
                          int totalSeats, int availableSeats, String state) {
        super(id, flightNumber, origin, destination, departureTime, arrivalTime, totalSeats, availableSeats);
        this.state = state;
    }

    // Constructors, Getters, Setters

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

