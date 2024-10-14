package com.booking.flight.services;

import com.booking.flight.entity.Booking;
import com.booking.flight.entity.Flight;
import com.booking.flight.entity.InternationalFlight;
import com.booking.flight.entity.Passenger;
import com.booking.flight.exception.BookingException;
import com.booking.flight.exception.FlightNotFoundException;
import com.booking.flight.repo.BookingRepository;
import com.booking.flight.repo.FlightRepository;
import com.booking.flight.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Transactional
    public Booking bookFlight(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with id: " + flightId));

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new BookingException("Passenger not found with id: " + passengerId));

        if (flight.getAvailableSeats() <= 0) {
            throw new BookingException("No available seats for flight id: " + flightId);
        }

        // Polymorphic booking procedure
        if (flight instanceof InternationalFlight) {
            // Additional checks for international flights
            InternationalFlight intlFlight = (InternationalFlight) flight;
            if ("YES".equalsIgnoreCase(intlFlight.getVisaRequired())) {
                // Assume we have a method to check visa status; here we just simulate
                boolean hasVisa = checkPassengerVisa(passenger);
                if (!hasVisa) {
                    throw new BookingException("Passenger does not have the required visa for this international flight.");
                }
            }
        }

        // Proceed with booking
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);
        Booking booking =new Booking();
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("BOOKED");

        return bookingRepository.save(booking);
    }

    @Transactional
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingException("Booking not found with id: " + bookingId));

        if ("CANCELLED".equalsIgnoreCase(booking.getStatus())) {
            throw new BookingException("Booking is already cancelled.");
        }

        // Update flight's available seats
        Flight flight = booking.getFlight();
        flight.setAvailableSeats(flight.getAvailableSeats() + 1);
        flightRepository.save(flight);

        // Update booking status
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }

    // Placeholder for visa check logic
    private boolean checkPassengerVisa(Passenger passenger) {
        // Implement actual visa verification logic
        return true; // Assume always true for simplicity
    }
}
