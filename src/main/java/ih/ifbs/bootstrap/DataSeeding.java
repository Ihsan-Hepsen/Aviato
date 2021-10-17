package ih.ifbs.bootstrap;

import ih.ifbs.domain.*;
import ih.ifbs.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeding implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeeding.class);
    private final ListRepository<Airline> airlines;
    private final ListRepository<Passenger> passengers;
    private final ListRepository<Flight> flights;

    public DataSeeding(ListRepository<Airline> airlineRepository, ListRepository<Passenger> passengerRepository,
                       ListRepository<Flight> flightRepository) {
        this.airlines = airlineRepository;
        this.passengers = passengerRepository;
        this.flights = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Seeding the repositories");

        airlines.create(new Airline("Qantas Airlines", 134, 77));
        airlines.create(new Airline("Turkish Airlines", 350, 304));
        airlines.create(new Airline("Air New Zealand", 114, 80));
        airlines.create(new Airline("Virgin Australia", 68, 40));
        airlines.create(new Airline("Bahamas Air", 10, 21));
        airlines.create(new Airline("Private Voyages", 11, 13));

        passengers.create(new Passenger("Johnny Thunder", 21, Gender.M, true));
        passengers.create(new Passenger("Anna Cooper", 23, Gender.F, true));
        passengers.create(new Passenger("Padme Amidala", 35, Gender.F, false));
        passengers.create(new Passenger("Kilroy Barron", 52, Gender.M, false));
        passengers.create(new Passenger("Senor Palomar", 32, Gender.M, false));
        passengers.create(new Passenger("Kül Tigin", 37, Gender.M, false));

        flights.create(new Flight("Qantas Airlines", "QF12", FlightType.COMM,
                "Los Angeles","Sydney",
                LocalDate.of(2021, 10, 21), true));
        flights.create(new Flight("Turkish Airlines","TK77", FlightType.COMM,
                "Istanbul","Miami",
                LocalDate.of(2021, 10, 22), false));
        flights.create(new Flight("Private Voyages","HI4506", FlightType.PRIV,
                "Honolulu","Sydney",
                LocalDate.of(2021, 10, 21), true));
        flights.create(new Flight("Air New Zealand", "NZ6141", FlightType.COMM,
                "Auckland","Sydney",
                LocalDate.of(2021, 10, 22), false));
        flights.create(new Flight("Bahamas Air", "BHS224", FlightType.COMM,
                "Miami", "Nassau",
                LocalDate.of(2021, 10, 23), false));
        flights.create(new Flight("Virgin Australia", "VA526", FlightType.COMM,
                "Sydney", "Gold Coast",
                LocalDate.of(2021, 10, 22), true));
        flights.create(new Flight("Virgin Australia", "VA734", FlightType.COMM,
                "Gold Coast", "Melbourne",
                LocalDate.of(2021, 10, 23), false));
        flights.create(new Flight("Private Voyages", "HI1204", FlightType.PRIV,
                "New York", "Miami",
                LocalDate.of(2021, 10, 23), false));

        airlines.read().get(0).addFlight(flights.read().get(0));
        airlines.read().get(1).addFlight(flights.read().get(1));
        airlines.read().get(2).addFlight(flights.read().get(3));
        airlines.read().get(3).addFlight(flights.read().get(5));
        airlines.read().get(3).addFlight(flights.read().get(6));
        airlines.read().get(4).addFlight(flights.read().get(4));
        airlines.read().get(5).addFlight(flights.read().get(2));
        airlines.read().get(5).addFlight(flights.read().get(7));

        flights.read().get(0).addPassenger(passengers.read().get(0));
        flights.read().get(5).addPassenger(passengers.read().get(0));
        flights.read().get(6).addPassenger(passengers.read().get(0));
        flights.read().get(1).addPassenger(passengers.read().get(1));
        flights.read().get(4).addPassenger(passengers.read().get(1));
        flights.read().get(2).addPassenger(passengers.read().get(2));
        flights.read().get(3).addPassenger(passengers.read().get(3));
        flights.read().get(3).addPassenger(passengers.read().get(4));
        flights.read().get(7).addPassenger(passengers.read().get(5));

        passengers.read().get(0).addFlight(flights.read().get(0));
        passengers.read().get(0).addFlight(flights.read().get(5));
        passengers.read().get(0).addFlight(flights.read().get(6));
        passengers.read().get(1).addFlight(flights.read().get(1));
        passengers.read().get(1).addFlight(flights.read().get(4));
        passengers.read().get(2).addFlight(flights.read().get(2));
        passengers.read().get(3).addFlight(flights.read().get(3));
        passengers.read().get(4).addFlight(flights.read().get(3));
        passengers.read().get(5).addFlight(flights.read().get(7));
    }
}
