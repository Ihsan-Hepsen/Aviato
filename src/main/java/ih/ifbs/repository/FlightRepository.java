package ih.ifbs.repository;

import ih.ifbs.domain.Flight;
import java.util.List;

public interface FlightRepository {
    Flight create(Flight flight);
    Flight findById(int id);
    List<Flight> read();
}
