package com.example.intl_flight_browsing_system.repository;

import com.example.intl_flight_browsing_system.domain.Flight;
import com.example.intl_flight_browsing_system.domain.Gender;
import com.example.intl_flight_browsing_system.domain.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PassengerRepositoryImpl implements PassengerRepository {

    private static final List<Passenger> passengers = new ArrayList<>();
    private final FlightRepository flights;

    @Autowired
    public PassengerRepositoryImpl(FlightRepository flights) {
        this.flights = flights;
        fillPassengers();
    }

    private void fillPassengers() {
        passengers.add(new Passenger("Johnny Thunder", 21, Gender.M, true));
        passengers.add(new Passenger("Jessica Cooper", 23, Gender.F, true));
        passengers.add(new Passenger("Padme McKinney", 35, Gender.F, false));
        passengers.add(new Passenger("Kilroy Barron", 52, Gender.M, false));
        passengers.add(new Passenger("Senor Palomar", 32, Gender.M, false));
        passengers.add(new Passenger("Kül Tigin", 37, Gender.M, false));

        passengers.get(0).addFlight(flights.getFlights().get(0));
        passengers.get(0).addFlight(flights.getFlights().get(5));
        passengers.get(0).addFlight(flights.getFlights().get(6));
        passengers.get(1).addFlight(flights.getFlights().get(1));
        passengers.get(1).addFlight(flights.getFlights().get(4));
        passengers.get(2).addFlight(flights.getFlights().get(2));
        passengers.get(3).addFlight(flights.getFlights().get(3));
        passengers.get(4).addFlight(flights.getFlights().get(3));
        passengers.get(5).addFlight(flights.getFlights().get(7));

        flights.getFlights().get(0).addPassenger(passengers.get(0));
        flights.getFlights().get(5).addPassenger(passengers.get(0));
        flights.getFlights().get(6).addPassenger(passengers.get(0));
        flights.getFlights().get(1).addPassenger(passengers.get(1));
        flights.getFlights().get(4).addPassenger(passengers.get(1));
        flights.getFlights().get(2).addPassenger(passengers.get(2));
        flights.getFlights().get(3).addPassenger(passengers.get(3));
        flights.getFlights().get(3).addPassenger(passengers.get(4));
        flights.getFlights().get(7).addPassenger(passengers.get(5));
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        passengers.add(passenger);
        return passenger;
    }

    @Override
    public Passenger createPassenger(Passenger passenger, Flight flight) {
        passenger.addFlight(flight);
        flight.addPassenger(passenger);
        passengers.add(passenger);
        return passenger;
    }

    @Override
    public List<Passenger> getPassengers() {
        return passengers;
    }
}
