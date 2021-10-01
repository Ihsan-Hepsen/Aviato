package com.example.intl_flight_browsing_system.domain;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Passenger {

    private final String name;
    private final int age;
    private final Gender gender;
    @SerializedName("transit")
    private final boolean isTransitPassenger;
    private transient final List<Flight> flights;

    public Passenger(String name, int age, Gender gender, boolean isTransitPassenger) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isTransitPassenger = isTransitPassenger;
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isTransitPassenger() {
        return isTransitPassenger;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nGender: %s\nTransit: %s\nFlights: %d\n",
                name, age, gender.getGender(), isTransitPassenger ? "Yes" : "No", flights.size());
    }
}
