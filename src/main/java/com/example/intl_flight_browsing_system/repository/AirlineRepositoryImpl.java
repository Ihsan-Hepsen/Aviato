package com.example.intl_flight_browsing_system.repository;

import com.example.intl_flight_browsing_system.domain.Airline;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirlineRepositoryImpl implements AirlineRepository {

    private static final List<Airline> airlines = new ArrayList<>();

    static {
        initAirlines();
    }

    private static void initAirlines() {
        airlines.add(new Airline("Qantas Airlines", 134, 77));
        airlines.add(new Airline("Turkish Airlines", 350, 304));
        airlines.add(new Airline("Air New Zealand", 114, 80));
        airlines.add(new Airline("Virgin Australia", 68, 40));
        airlines.add(new Airline("Bahamas Air", 10, 21));
        airlines.add(new Airline("Private Voyages", 11, 13));
    }


    @Override
    public List<Airline> getAirlines() {
        return airlines;
    }
}
