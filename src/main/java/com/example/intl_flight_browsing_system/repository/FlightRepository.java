package com.example.intl_flight_browsing_system.repository;

import com.example.intl_flight_browsing_system.domain.Flight;
import java.util.List;

public interface FlightRepository {
    Flight generateFlight(Flight flight);

    List<Flight> getFlights();
}
