package com.booking.flight.exception;


public class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException(String message) {
        super(message);
    }
}
