package com.booking.flight.controller;

import com.booking.flight.entity.Booking;
import com.booking.flight.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookFlight(@RequestParam Long flightId, @RequestParam Long passengerId) {
        return bookingService.bookFlight(flightId, passengerId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking cancelled successfully: " + id);
    }

}

