package ih.ifbs.presentation.dto;

import ih.ifbs.domain.FlightType;
import ih.ifbs.domain.Passenger;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

public class FlightDTO {

    private String airline;
    private String flightNumber;
    private FlightType flightType;
    private String departure;
    private String arrival;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduledOn;
    private String isOnTime;
    private List<Passenger> passengerList;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDate getScheduledOn() {
        return scheduledOn;
    }

    public void setScheduledOn(LocalDate scheduledOn) {
        this.scheduledOn = scheduledOn;
    }

    public String getIsOnTime() {
        return isOnTime;
    }

    public void setIsOnTime(String onTime) {
        isOnTime = onTime;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
