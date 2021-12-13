package ih.ifbs.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FLIGHTS")
public class Flight extends EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="airline_flight")
    private final Airline airline;
//    private final String airline;

    @Column(name = "flight_number", nullable = false, length = 25, unique = true)
    private final String flightNumber;

    @Column(name = "flight_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private final FlightType flightType;

    @Column(name = "departure", nullable = false, length = 50)
    private final String departure;

    @Column(name = "arrival", nullable = false, length = 50)
    private final String arrival;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private final LocalDate scheduledOn;

    @Column(name = "status", nullable = false)
    private boolean onTime;

    @ManyToMany(targetEntity = Passenger.class, mappedBy = "flights", cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private final List<Passenger> passengerList;


    public Flight(Airline airline, String flightNumber, FlightType flightType, String departure,
                  String arrival, LocalDate scheduledOn, boolean isOnTime) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.flightType = flightType;
        this.departure = departure;
        this.arrival = arrival;
        this.scheduledOn = scheduledOn;
        this.onTime = isOnTime;
        this.passengerList = new ArrayList<>();
    }

    protected Flight() {
        this.airline = null;
        this.flightNumber = null;
        this.flightType = null;
        this.departure = null;
        this.arrival = null;
        this.scheduledOn = null;
        this.onTime = false;
        this.passengerList = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    public Airline getAirline() {
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
        return onTime;
    }

    public void setOnTime(boolean onTime) {
        this.onTime = onTime;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    @Override
    public String toString() {
        return String.format("-%-18s, Flight: %-6s - %s to %s - Time: %d-%s-%d (%s) ~ Passengers: %d (%s Flight)\n",
                airline, flightNumber, departure.toUpperCase(), arrival.toUpperCase(),
                scheduledOn.getYear(), scheduledOn.getMonth().toString().subSequence(0, 3), scheduledOn.getDayOfMonth(),
                onTime ? "OnTime" : "Delayed", passengerList.size(), flightType.getValue());
    }
}
