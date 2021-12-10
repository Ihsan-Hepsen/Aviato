package ih.ifbs.repository.hsqlrepository;

import ih.ifbs.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);
}
