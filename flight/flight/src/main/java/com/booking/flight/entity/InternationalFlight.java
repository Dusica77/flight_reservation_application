package com.booking.flight.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("INTERNATIONAL")
public class InternationalFlight extends Flight {
    private String country;
    private String visaRequired;

    public InternationalFlight() {
        super();
    }

    public InternationalFlight(Long id, String flightNumber, String origin, String destination,
                               LocalDateTime departureTime, LocalDateTime arrivalTime,
                               int totalSeats, int availableSeats,
                               String country, String visaRequired) {
        super(id, flightNumber, origin, destination, departureTime, arrivalTime, totalSeats, availableSeats);
        this.country = country;
        this.visaRequired = visaRequired;
    }

    // Constructors, Getters, Setters

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVisaRequired() {
        return visaRequired;
    }

    public void setVisaRequired(String visaRequired) {
        this.visaRequired = visaRequired;
    }
}

