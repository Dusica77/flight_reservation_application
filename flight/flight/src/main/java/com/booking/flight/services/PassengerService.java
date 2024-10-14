package com.booking.flight.services;

import com.booking.flight.entity.Passenger;
import com.booking.flight.exception.PassengerNotFoundException;
import com.booking.flight.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found with id: " + id));
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Passenger passenger = getPassengerById(id);
        passenger.setName(passengerDetails.getName());
        passenger.setEmail(passengerDetails.getEmail());
        passenger.setPhoneNumber(passengerDetails.getPhoneNumber());
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        Passenger passenger = getPassengerById(id);
        passengerRepository.delete(passenger);
    }
}
