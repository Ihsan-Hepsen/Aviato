package ih.ifbs.domain;

import java.util.ArrayList;
import java.util.List;

public class Airline extends Entity {

    private final String airlineName;
    private final int fleetSize;
    private final int totalDestinations;
    private transient final List<Flight> flightList;


    public Airline(String airlineName, int fleetSize, int totalDestinations) {
        this.airlineName = airlineName;
        this.fleetSize = fleetSize;
        this.totalDestinations = totalDestinations;
        this.flightList = new ArrayList<>();
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

    public double getTotalDestinations() {
        return totalDestinations;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    @Override
    public String toString() {
        String fixPrint = String.format("# %s - (Fleet Size: %d, Flights to: %d destinations, Current Flights: %d)",
                airlineName.toUpperCase(), fleetSize, totalDestinations, flightList.size());
        StringBuilder airlinePrint = new StringBuilder(fixPrint);
        flightList.forEach(airlinePrint::append);
        return airlinePrint.toString();
    }
}
