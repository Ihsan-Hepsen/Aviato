package ih.ifbs.services;

import ih.ifbs.domain.Flight;
import java.util.Collection;
import java.util.List;

public interface FlightService {
    Flight findFLightById(int id);

    Flight addFlight(Flight flight);

    List<Flight> getAllFlights();

    Collection<Flight> getAllFlights(String city, String date);
}
