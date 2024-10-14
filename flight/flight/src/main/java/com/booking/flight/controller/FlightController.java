package com.booking.flight.controller;


import com.booking.flight.entity.Flight;
import com.booking.flight.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<?> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();

        // Create a response body containing a message and the list of flights
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Successfully retrieved all flight details.");
        responseBody.put("flights", flights);

        return ResponseEntity.ok(responseBody);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);

        if (flight == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Flight with ID: " + id + " not found.");
        }

        // Create a response body containing a message and the flight details
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Successfully retrieved flight details.");
        responseBody.put("flight", flight);

        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<?> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        String message = "Flight created successfully with ID: " + createdFlight.getId();

        // Create a response body containing both the message and the created flight details
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", message);
        responseBody.put("createdFlight", createdFlight);

        return ResponseEntity.ok(responseBody);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        Flight updatedFlight = flightService.updateFlight(id, flightDetails);
        String message = "Flight details updated successfully for ID: " + id;

        // Create a response body containing both the message and the updated flight details
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", message);
        responseBody.put("updatedFlight", updatedFlight);

        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok("Flight deleted successfully for ID: " + id);
    }
}
