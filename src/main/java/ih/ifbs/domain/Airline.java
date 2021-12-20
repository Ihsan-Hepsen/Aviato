package ih.ifbs.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airlines")
public class Airline extends EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "airline", nullable = false, length = 50)
    private final String airlineName;

    @Column(name = "fleet_size", nullable = false)
    private final int fleetSize;

    @Column(name = "destinations", nullable = false)
    private final int totalDestinations;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private final List<Flight> flightList;

    public Airline(String airlineName, int fleetSize, int totalDestinations) {
        this.airlineName = airlineName;
        this.fleetSize = fleetSize;
        this.totalDestinations = totalDestinations;
        this.flightList = new ArrayList<>();
    }

    protected Airline() {
        this.airlineName = null;
        this.fleetSize = 0;
        this.totalDestinations = 0;
        this.flightList = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public String getAirlineName() {
        return airlineName;
    }

    public int getFleetSize() {
        return fleetSize;
    }

    public int getTotalDestinations() {
        return totalDestinations;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    @Override
    public String toString() {
        String fixPrint = String.format("# %s - (Fleet Size: %d, Flights to: %d destinations, Current Flights: %d)",
                airlineName.toUpperCase(), fleetSize, totalDestinations, flightList.size());
//        StringBuilder airlinePrint = new StringBuilder(fixPrint);
//        flightList.forEach(airlinePrint::append);
        return fixPrint;
    }
}
