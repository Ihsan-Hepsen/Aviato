package com.example.intl_flight_browsing_system.presentation;

import com.example.intl_flight_browsing_system.domain.Flight;
import com.example.intl_flight_browsing_system.domain.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.intl_flight_browsing_system.services.FlightService;
import com.example.intl_flight_browsing_system.services.PassengerService;
import com.example.intl_flight_browsing_system.util.InputOutOfRangeException;
import com.example.intl_flight_browsing_system.util.JsonSaver;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class View {

    private final FlightService flightService;
    private final PassengerService passengerService;
    private final Scanner scanner = new Scanner(System.in);
    private boolean done = false;

    @Autowired
    public View(FlightService flightService, PassengerService passengerService) {
        this.flightService = flightService;
        this.passengerService = passengerService;
    }

    public void displayMainMenu() {
        while (!done) {
            System.out.println("PLEASE CHOOSE AN ACTION\n" +
                    "======================\n" +
                    "1) Show all passengers\n" +
                    "2) Show passengers by category\n" +
                    "3) Show all flights\n" +
                    "4) Show flights by city and/or date\n" +
                    "0) Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 0 : done = true; break;
            case 1 : showAllPassengers(); break;
            case 2 : showTransitPassengers(); break;
            case 3 : getFlights(); break;
            case 4 : getFlightsByCriteria(); break;
        }
    }

    private void showAllPassengers() {
        List<Passenger> passengers = passengerService.getAllPassengers();
        passengers.forEach(System.out::println);
        JsonSaver.saveAsJSON(passengers);
    }

    private void showTransitPassengers() {
        boolean invalid = true;
        while (invalid) {
            try {
                System.out.print("Transit Passengers(1) - Non-Transit Passengers(2): ");
                int choice = scanner.nextInt();
                if (choice > 2 || choice < 1) throw new InputOutOfRangeException();
                invalid = false;
                List<Passenger> passengers = passengerService.getAllPassengers(choice == 1);
                passengers.forEach(System.out::println);
                JsonSaver.saveAsJSON(passengers);
            } catch (InputMismatchException | InputOutOfRangeException e) {
                System.out.println("Please choose the following options.");
                scanner.nextLine();
            }
        }
    }

    private void getFlights() {
        List<Flight> flights = flightService.getAllFlights();
        flights.forEach(System.out::println);
        JsonSaver.saveAsJSON(flights);
    }

    private void getFlightsByCriteria() {
        scanner.nextLine();
        System.out.print("Enter a city(optional): ");
        String city = scanner.nextLine();
        System.out.print("Enter a date(optional): ");
        String date = scanner.nextLine();
        System.out.println();
        Collection<Flight> flights = flightService.getAllFlights(city, date);
        flights.forEach(System.out::println);
        JsonSaver.saveAsJSON(flights);
    }
}
