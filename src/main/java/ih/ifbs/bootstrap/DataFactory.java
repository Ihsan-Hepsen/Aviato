package ih.ifbs.bootstrap;

import ih.ifbs.domain.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFactory { // CONSOLE APPLICATION ONLY!

    private static final List<Passenger> passengerList = new ArrayList<>();
    private static final List<Flight> flightList = new ArrayList<>();

    public DataFactory() {

    }

    static {
        seed();
    }

    public static void seed() {
        passengerList.add(new Passenger("Johnny Thunder", 21, Gender.M, true));
        passengerList.add(new Passenger("Jessica Cooper", 23, Gender.F, true));
        passengerList.add(new Passenger("Padme McKinney", 35, Gender.F, false));
        passengerList.add(new Passenger("Kilroy Barron", 52, Gender.M, false));
        passengerList.add(new Passenger("Senor Palomar", 32, Gender.M, false));
        passengerList.add(new Passenger("Kül Tigin", 37, Gender.M, false));

        flightList.add(new Flight(new Airline("Qantas Airlines", 134, 77),
                "QF12", FlightType.COMM, "Los Angeles","Sydney",
                LocalDate.of(2021, 9, 21), true));
        flightList.add(new Flight(new Airline("Turkish Airlines", 350, 304),
                "TK77", FlightType.COMM, "Istanbul","Miami",
                LocalDate.of(2021, 9, 22), false));
        flightList.add(new Flight(new Airline("Private Voyages", 11, 13),
                "HI4506", FlightType.PRIV, "Honolulu","Sydney",
                LocalDate.of(2021, 9, 21), true));
        flightList.add(new Flight(new Airline("Air New Zealand", 114, 83),
                "NZ6141", FlightType.COMM, "Auckland","Sydney",
                LocalDate.of(2021, 9, 22), false));
        flightList.add(new Flight(new Airline("Bahamas Air", 10, 32),
                "BHS224", FlightType.COMM, "Miami", "Nassau",
                LocalDate.of(2021, 9, 23), false));
        flightList.add(new Flight(new Airline("Virgin Australia", 68, 40),
                "VA526", FlightType.COMM, "Sydney", "Gold Coast",
                LocalDate.of(2021, 9, 22), true));
        flightList.add(new Flight(new Airline("Virgin Australia", 68, 40),
                "VA734", FlightType.COMM, "Gold Coast", "Melbourne",
                LocalDate.of(2021, 9, 23), false));
        flightList.add(new Flight(new Airline("Private Voyages", 11, 13),
                "HI1204", FlightType.PRIV, "New York", "Miami",
                LocalDate.of(2021, 9, 23), false));

        // adding flights to passenger's flight list
        passengerList.get(0).addFlight(flightList.get(0));
        passengerList.get(0).addFlight(flightList.get(5));
        passengerList.get(0).addFlight(flightList.get(6));
        passengerList.get(1).addFlight(flightList.get(1));
        passengerList.get(1).addFlight(flightList.get(4));
        passengerList.get(2).addFlight(flightList.get(2));
        passengerList.get(3).addFlight(flightList.get(3));
        passengerList.get(4).addFlight(flightList.get(3));
        passengerList.get(5).addFlight(flightList.get(7));

        //  adding passengers to their flights
        flightList.get(0).addPassenger(passengerList.get(0));
        flightList.get(5).addPassenger(passengerList.get(0));
        flightList.get(6).addPassenger(passengerList.get(0));
        flightList.get(1).addPassenger(passengerList.get(1));
        flightList.get(4).addPassenger(passengerList.get(1));
        flightList.get(2).addPassenger(passengerList.get(2));
        flightList.get(3).addPassenger(passengerList.get(3));
        flightList.get(3).addPassenger(passengerList.get(4));
        flightList.get(7).addPassenger(passengerList.get(5));
    }
}
