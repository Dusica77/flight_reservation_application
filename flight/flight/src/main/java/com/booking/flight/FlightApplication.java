package com.booking.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightApplication {

	public static void main(String[] args) {
		System.out.println("Flight-Reservation-Application");
		SpringApplication.run(FlightApplication.class, args);
	}

}
