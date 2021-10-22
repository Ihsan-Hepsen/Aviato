package ih.ifbs.domain;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight extends Entity {

    private final String airline;
    private final String flightNumber;
    private final FlightType flightType;
    private final String departure;
    private final String arrival;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final LocalDate scheduledOn;
    private boolean isOnTime;
    private final List<Passenger> passengerList;


    public Flight(String airline, String flightNumber, FlightType flightType, String departure,
                  String arrival, LocalDate scheduledOn, boolean isOnTime) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.flightType = flightType;
        this.departure = departure;
        this.arrival = arrival;
        this.scheduledOn = scheduledOn;
        this.isOnTime = isOnTime;
        this.passengerList = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    public String getAirline() {
        return airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public LocalDate getFlightSchedule() {
        return scheduledOn;
    }

    public boolean isOnTime() {
        return isOnTime;
    }

    public void setOnTime(boolean onTime) {
        isOnTime = onTime;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    @Override
    public String toString() {
        return String.format("-%-18s, Flight: %-6s - %s to %s - Time: %d-%s-%d (%s) ~ Passengers: %d (%s Flight)\n",
                airline, flightNumber, departure.toUpperCase(), arrival.toUpperCase(),
                scheduledOn.getYear(), scheduledOn.getMonth().toString().subSequence(0, 3), scheduledOn.getDayOfMonth(),
                isOnTime ? "OnTime" : "Delayed", passengerList.size(), flightType.getValue());
    }
}
