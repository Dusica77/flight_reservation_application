✈️ Flight Reservation System


📌 Project Overview

The Flight Reservation System is a mini project built using Java 7, Spring Boot, and MySQL to simulate a simple airline booking platform. It supports both domestic and international flights, allowing users to push reservation data via APIs and store it securely in a relational database.

This project demonstrates API development, database integration, and service-oriented architecture with separate layers for repositories, services, and flight-specific classes.

⚙️ Tech Stack
Backend Language: Java 7
Framework: Spring Boot
IDE: IntelliJ IDEA
Database: MySQL
API Testing Tool: Postman

📂 Project Structure
The system follows a layered architecture with three main interfaces:
Repositories Layer
Handles interaction with MySQL database.
Provides CRUD operations for flight records.
Service Layer
Contains business logic.
Manages domestic and international flight services.

Flight Classes
DomesticFlight.java – Represents domestic flight details.
InternationalFlight.java – Represents international flight details.

Additional entities like Passenger, Booking.

🚀 Features

Add domestic or international flight records.
Store booking details in MySQL database.
Expose REST APIs through Spring Boot.
Test APIs via Postman using localhost server.
Separation of concerns using repository-service-controller architecture.

🔗 How It Works

Run the project in IntelliJ IDEA.
Spring Boot generates a localhost server port (e.g., http://localhost:8080).
Use Postman to test APIs (e.g., POST /flights/domestic, POST /flights/international).
Data gets pushed from Postman → Spring Boot API → MySQL database.
Retrieve and manage flight reservation records via API calls.

🛠️ Setup Instructions
Prerequisites

Install Java 7+
Install MySQL
Install IntelliJ IDEA
Install Postman

Steps to Run
Clone this repository:
git clone https://github.com/your-username/flight-reservation-system.git
cd flight-reservation-system


Configure MySQL database in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/flightdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Run the project from IntelliJ (Run → SpringBootApplication).

Open Postman and hit the APIs using localhost:<port>.

📌 Example API Endpoints
Add Domestic Flight

POST http://localhost:8080/api/flights/domestic

{
  "flightNumber": "IND101",
  "airline": "Air India",
  "source": "Mumbai",
  "destination": "Delhi",
  "price": 4500
}

Add International Flight

POST http://localhost:8080/api/flights/international

{
  "flightNumber": "INT202",
  "airline": "Emirates",
  "source": "Bangalore",
  "destination": "Dubai",
  "price": 18000
}

Learning Outcomes

API development with Spring Boot

CRUD operations with MySQL

Testing APIs using Postman

Layered architecture with repositories, services, and controllers

Hands-on experience with real-world flight reservation workflows


