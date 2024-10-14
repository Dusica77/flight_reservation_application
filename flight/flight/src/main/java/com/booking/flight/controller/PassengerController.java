package com.booking.flight.controller;

import com.booking.flight.entity.Passenger;
import com.booking.flight.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPassenger(@RequestBody Passenger passenger) {
        Passenger createdPassenger = passengerService.createPassenger(passenger);

        // Create a response body containing a message and the created passenger details
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Passenger created successfully with ID: " + createdPassenger.getId());
        responseBody.put("createdPassenger", createdPassenger); // Include the created passenger details

        return ResponseEntity.ok(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails) {
        Passenger updatedPassenger = passengerService.updatePassenger(id, passengerDetails);

        // Create a response body containing a message and the updated passenger details
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Passenger data updated successfully for ID: " + id);
        responseBody.put("updatedPassenger", updatedPassenger); // Include the updated passenger details

        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.ok("Passenger data deleted successfully for ID: " + id);
    }
}
