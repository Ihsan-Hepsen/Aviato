package ih.ifbs.repository;

import ih.ifbs.domain.Airline;
import java.util.List;

public interface AirlineRepository {
    Airline create(Airline airline);
    Airline findById(int id);
    List<Airline> read();
}
