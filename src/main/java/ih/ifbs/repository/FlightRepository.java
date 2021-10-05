package ih.ifbs.repository;

import ih.ifbs.domain.Flight;
import java.util.List;

public interface FlightRepository {
    Flight generateFlight(Flight flight);

    List<Flight> getFlights();
}
