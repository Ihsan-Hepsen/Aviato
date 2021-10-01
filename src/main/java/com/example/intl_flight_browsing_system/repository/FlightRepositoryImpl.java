package com.example.intl_flight_browsing_system.repository;

import com.example.intl_flight_browsing_system.domain.Airline;
import com.example.intl_flight_browsing_system.domain.Flight;
import com.example.intl_flight_browsing_system.domain.FlightType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightRepositoryImpl implements FlightRepository {

    private static final List<Flight> flights = new ArrayList<>();
    
    static {
        fillFlights();
    }

    private static void fillFlights() {
        flights.add(new Flight(new Airline("Qantas Airlines", 134, 77),
                "QF12", FlightType.COMM, "Los Angeles","Sydney",
                LocalDate.of(2021, 9, 21), true));
        flights.add(new Flight(new Airline("Turkish Airlines", 350, 304),
                "TK77", FlightType.COMM, "Istanbul","Miami",
                LocalDate.of(2021, 9, 22), false));
        flights.add(new Flight(new Airline("Private Voyages", 11, 13),
                "HI4506", FlightType.PRIV, "Honolulu","Sydney",
                LocalDate.of(2021, 9, 21), true));
        flights.add(new Flight(new Airline("Air New Zealand", 114, 83),
                "NZ6141", FlightType.COMM, "Auckland","Sydney",
                LocalDate.of(2021, 9, 22), false));
        flights.add(new Flight(new Airline("Bahamas Air", 10, 32),
                "BHS224", FlightType.COMM, "Miami", "Nassau",
                LocalDate.of(2021, 9, 23), false));
        flights.add(new Flight(new Airline("Virgin Australia", 68, 40),
                "VA526", FlightType.COMM, "Sydney", "Gold Coast",
                LocalDate.of(2021, 9, 22), true));
        flights.add(new Flight(new Airline("Virgin Australia", 68, 40),
                "VA734", FlightType.COMM, "Gold Coast", "Melbourne",
                LocalDate.of(2021, 9, 23), false));
        flights.add(new Flight(new Airline("Private Voyages", 11, 13),
                "HI1204", FlightType.PRIV, "New York", "Miami",
                LocalDate.of(2021, 9, 23), false));
    }

    @Override
    public Flight generateFlight(Flight flight) {
        flights.add(flight);
        return flight;
    }

    @Override
    public List<Flight> getFlights() {
        return flights;
    }
}
