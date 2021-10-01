package com.example.intl_flight_browsing_system.services;

import com.example.intl_flight_browsing_system.domain.Flight;
import java.util.Collection;
import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);

    List<Flight> getAllFlights();

    Collection<Flight> getAllFlights(String city, String date);
}
