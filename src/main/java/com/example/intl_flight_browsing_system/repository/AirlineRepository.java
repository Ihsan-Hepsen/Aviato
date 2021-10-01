package com.example.intl_flight_browsing_system.repository;

import com.example.intl_flight_browsing_system.domain.Airline;
import java.util.List;

public interface AirlineRepository {
    List<Airline> getAirlines();
}
