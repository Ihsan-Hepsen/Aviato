package com.example.intl_flight_browsing_system.services;

import com.example.intl_flight_browsing_system.domain.Passenger;
import com.example.intl_flight_browsing_system.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassengerServiceImpl implements PassengerService {
    // TODO: services & methods that the presentation layer needs
    private final PassengerRepository repository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return repository.createPassenger(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return repository.getPassengers();
    }

    @Override
    public List<Passenger> getAllPassengers(boolean isTransit) {
        return repository.getPassengers().stream()
                .filter(n -> isTransit == n.isTransitPassenger())
                .collect(Collectors.toList());
    }
}
