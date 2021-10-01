package com.example.intl_flight_browsing_system.services;

import com.example.intl_flight_browsing_system.domain.Passenger;
import java.util.List;

public interface PassengerService {
    Passenger createPassenger(Passenger passenger);

    List<Passenger> getAllPassengers();

    List<Passenger> getAllPassengers(boolean isTransit);
}
