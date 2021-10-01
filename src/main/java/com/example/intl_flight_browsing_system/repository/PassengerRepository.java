package com.example.intl_flight_browsing_system.repository;

import com.example.intl_flight_browsing_system.domain.Flight;
import com.example.intl_flight_browsing_system.domain.Passenger;
import java.util.List;

public interface PassengerRepository {
    Passenger createPassenger(Passenger passenger);

    Passenger createPassenger(Passenger passenger, Flight flight);

    List<Passenger> getPassengers();
}
